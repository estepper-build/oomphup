package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;
import org.eclipse.oomph.ui.UIUtil;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

public class EarlyStartup implements IStartup
{
  private static final String PREPROCESSOR_WORKSPACE_LOCATIONS = "preprocessor.workspace.project.locations";

  private static final URIConverter URI_CONVERTER = createResourceSet().getURIConverter();

  private final static IWorkspaceRoot WORKSPACE_ROOT = EcorePlugin.getWorkspaceRoot();

  private final IWorkspace WORKSPACE = WORKSPACE_ROOT.getWorkspace();

  static boolean closeShell = true;

  public void earlyStartup()
  {
    final String projects = System.getProperty("preprocessor.projects");
    if (projects != null)
    {
      initializeWorkspace();
      final Display display = Display.getDefault();
      final Listener displayListener = new Listener()
      {
        public void handleEvent(Event event)
        {
          if (event.widget instanceof Shell)
          {
            final Shell shell = (Shell)event.widget;
            Object data = shell.getData();
            if (data instanceof Dialog)
            {
              display.asyncExec(new Runnable()
              {
                public void run()
                {
                  if (closeShell && !shell.isDisposed())
                  {
                    shell.close();
                  }
                }
              });
            }
          }
        }
      };

      display.asyncExec(new Runnable()
      {
        public void run()
        {
          for (Shell shell : display.getShells())
          {
            Object data = shell.getData();
            if (data instanceof Dialog)
            {
              shell.close();
            }
          }
          display.addListener(SWT.Skin, displayListener);
        }
      });

      display.asyncExec(new Runnable()
      {
        public void run()
        {
          final IWorkbench workbench = PlatformUI.getWorkbench();
          IExtensionTracker extensionTracker = workbench.getExtensionTracker();
          if (extensionTracker == null || workbench.getWorkbenchWindowCount() == 0)
          {
            display.timerExec(5000, this);
          }
          else
          {
            final Object prepare = new Object();
            Job job = new Job("Prepare Workspace and Target Platform")
            {
              @Override
              protected IStatus run(IProgressMonitor monitor)
              {
                final Preprocessor preprocessApplication = new Preprocessor();
                Job job = new Job("Preprocessing")
                {
                  @Override
                  public IStatus run(IProgressMonitor monitor)
                  {
                    String projects = System.getProperty("preprocessor.projects");
                    if (projects != null)
                    {
                      String[] args = projects.split(";");
                      if (args != null)
                      {
                        for (String arg : args)
                        {
                          File file;
                          try
                          {
                            file = new File(arg).getCanonicalFile();
                            preprocessApplication.visitProject(file);
                          }
                          catch (IOException ex)
                          {
                            ex.printStackTrace();
                          }
                        }
                      }
                    }

                    UIUtil.asyncExec(new Runnable()
                    {
                      public void run()
                      {
                        display.removeListener(SWT.Skin, displayListener);
                      }
                    });
                    System.exit(0);
                    return Status.OK_STATUS;
                  }
                };

                job.schedule();

                return Status.OK_STATUS;
              }

              @Override
              public boolean belongsTo(Object family)
              {
                return prepare.equals(family);
              }
            };

            job.setRule(EcorePlugin.getWorkspaceRoot());
            job.schedule();
          }
        }
      });
    }
  }

  private void initializeWorkspace()
  {
    IWorkspaceDescription description = WORKSPACE.getDescription();
    description.setAutoBuilding(false);

    String workspaceLocations = System.getProperty(PREPROCESSOR_WORKSPACE_LOCATIONS);
    if (workspaceLocations == null)
    {
      workspaceLocations = System.getenv(PREPROCESSOR_WORKSPACE_LOCATIONS);
    }

    final String[] workspacePaths = workspaceLocations.split(File.pathSeparator);

    try
    {
      WORKSPACE.setDescription(description);
      WORKSPACE.run(new IWorkspaceRunnable()
      {
        public void run(IProgressMonitor monitor) throws CoreException
        {
          for (String installLocation : workspacePaths)
          {
            createProject(installLocation);
          }
        }
      }, null);
    }
    catch (CoreException ex)
    {
      ex.printStackTrace();
    }

    final String workspace = System.getProperty("preprocessor.workspace");
    if (workspace != null)
    {
      String setupPath = ".metadata/.plugins/org.eclipse.oomph.setup/workspace.setup";
      File workspaceSetup = new File(workspace, setupPath);
      if (workspaceSetup.exists())
      {
        ArticleUtil.copyFile(workspaceSetup, new File(WORKSPACE_ROOT.getLocation().toOSString(), setupPath));
      }
    }
  }

  private URI createProject(String installLocation)
  {
    URI locationURI = URI.createFileURI(installLocation);
    File locationFile = new File(installLocation);
    if (locationFile.isFile())
    {
      locationURI = URI.createURI("archive:" + locationURI + "!/");
    }
    else
    {
      URI projectURI = locationURI.appendSegment(".project");
      locationURI = locationURI.appendSegment("");
      if (URI_CONVERTER.exists(projectURI, null))
      {
        try
        {
          IProjectDescription projectDescription = WORKSPACE.loadProjectDescription(URI_CONVERTER.createInputStream(projectURI));
          IProject project = WORKSPACE_ROOT.getProject(projectDescription.getName());
          if (!project.exists())
          {
            projectDescription.setLocation(new Path(locationURI.toFileString()));
            project.create(projectDescription, null);
            project.open(null);
          }
          else
          {
            project.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
          }
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
        catch (CoreException ex)
        {
          ex.printStackTrace();
        }
      }
    }

    return locationURI;
  }

  static ResourceSet createResourceSet()
  {
    try
    {
      Class<?> setupUtilClass = CommonPlugin.loadClass("org.eclipse.oomph.setup.core", "org.eclipse.oomph.setup.internal.core.util.SetupUtil");
      Method createResourceSetMethod = setupUtilClass.getMethod("createResourceSet");
      return (ResourceSet)createResourceSetMethod.invoke(null);
    }
    catch (Exception ex)
    {
      return new ResourceSetImpl();
    }
  }
}
