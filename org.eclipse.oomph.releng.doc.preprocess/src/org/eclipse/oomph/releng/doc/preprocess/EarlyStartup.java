package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.dynamichelpers.IExtensionTracker;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

import java.io.File;
import java.io.IOException;

public class EarlyStartup implements IStartup
{
  public void earlyStartup()
  {
    final String projects = System.getProperty("preprocessor.projects");
    if (projects != null)
    {
      final Display display = Display.getDefault();
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
                final PreprocessApplication preprocessApplication = new PreprocessApplication();
                Job job = new UIJob(workbench.getDisplay(), "Preprocessing")
                {
                  @Override
                  public IStatus runInUIThread(IProgressMonitor monitor)
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
}
