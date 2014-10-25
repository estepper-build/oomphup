package org.eclipse.oomph.releng.doc;

import org.eclipse.oomph.releng.doc.AssembleScripts.AntLib;
import org.eclipse.oomph.releng.doc.AssembleScripts.JavaDoc;
import org.eclipse.oomph.releng.doc.AssembleScripts.SourcePlugin;
import org.eclipse.oomph.releng.doc.article.ArticlePlugin;
import org.eclipse.oomph.util.internal.pde.TargetPlatformClasspathFile;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import org.osgi.framework.Bundle;
import org.osgi.service.prefs.BackingStoreException;
import org.osgi.service.prefs.Preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Eike Stepper
 */
@SuppressWarnings("restriction")
public class DocDash extends ViewPart
{
  public static final String ID = "org.eclipse.oomph.releng.doc.ui.DocDash";

  private static final IWorkspaceRoot ROOT = ResourcesPlugin.getWorkspace().getRoot();

  private static final String PREF_PREPROCESS = "<Preprocess>";

  private static final String PREF_JAVA = "<Java>";

  private static final String PREF_SCHEMA = "<Schema>";

  private static final String PREF_ARTICLE = "<Article>";

  private static final String RELENG_NAME = "org.eclipse.oomph.releng.doc";

  private final Preferences preferences = InstanceScope.INSTANCE.getNode(RELENG_NAME).node(DocDash.class.getSimpleName());

  private Composite container;

  private Button preprocessButton;

  private Button javaButton;

  private Button schemaButton;

  private Button articleButton;

  private Button generateButton;

  private DocContentProvider contentProvider;

  private CheckboxTreeViewer treeViewer;

  private File helpcenter;

  private File plugins;

  private File releng;

  private AntLib antLib;

  private boolean debugPreprocessor;

  public DocDash()
  {
  }

  @Override
  public void setFocus()
  {
    generateButton.setFocus();
  }

  @Override
  public void dispose()
  {
    try
    {
      preferences.flush();
    }
    catch (BackingStoreException ex)
    {
      ArticlePlugin.INSTANCE.log(ex);
    }
    finally
    {
      super.dispose();
    }
  }

  @Override
  public void createPartControl(Composite parent)
  {
    GridLayout containerLayout = new GridLayout(1, false);
    containerLayout.marginWidth = 0;
    containerLayout.marginHeight = 0;
    containerLayout.marginLeft = 10;
    containerLayout.marginRight = 0;
    containerLayout.marginTop = 10;
    containerLayout.marginBottom = 0;
    containerLayout.verticalSpacing = 10;

    container = new Composite(parent, SWT.NONE);
    container.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
    container.setLayout(containerLayout);

    GridLayout helpCenterLayout = new GridLayout(5, false);
    helpCenterLayout.marginHeight = 0;

    Composite composite = new Composite(container, SWT.NONE);
    composite.setLayout(helpCenterLayout);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    preprocessButton = new Button(composite, SWT.CHECK);
    preprocessButton.setText("Preprocess");
    preprocessButton.setSelection(preferences.getBoolean(PREF_PREPROCESS, false));
    preprocessButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    preprocessButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        preferences.putBoolean(PREF_PREPROCESS, preprocessButton.getSelection());
        updateEnablement();
      }
    });

    javaButton = new Button(composite, SWT.CHECK);
    javaButton.setText("Java");
    javaButton.setSelection(preferences.getBoolean(PREF_JAVA, true));
    javaButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    javaButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        preferences.putBoolean(PREF_JAVA, javaButton.getSelection());
        updateEnablement();
      }
    });

    schemaButton = new Button(composite, SWT.CHECK);
    schemaButton.setText("Schema");
    schemaButton.setSelection(preferences.getBoolean(PREF_SCHEMA, true));
    schemaButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    schemaButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        preferences.putBoolean(PREF_SCHEMA, schemaButton.getSelection());
        updateEnablement();
      }
    });

    articleButton = new Button(composite, SWT.CHECK);
    articleButton.setText("Article");
    articleButton.setSelection(preferences.getBoolean(PREF_ARTICLE, true));
    articleButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false));
    articleButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        preferences.putBoolean(PREF_ARTICLE, articleButton.getSelection());
        updateEnablement();
      }
    });

    generateButton = new Button(composite, SWT.NONE);
    generateButton.setText("Generate");
    generateButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, false));
    generateButton.addSelectionListener(new SelectionAdapter()
    {
      @Override
      public void widgetSelected(SelectionEvent e)
      {
        try
        {
          generate();
        }
        catch (Exception ex)
        {
          ArticlePlugin.INSTANCE.log(ex);
        }
      }
    });

    Label label = new Label(container, SWT.SEPARATOR | SWT.HORIZONTAL);
    label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

    contentProvider = new DocContentProvider();

    treeViewer = new CheckboxTreeViewer(container, SWT.NONE);
    treeViewer.setContentProvider(contentProvider);
    treeViewer.setLabelProvider(new DocLabelProvider());
    treeViewer.setInput(this);
    treeViewer.addCheckStateListener(new ICheckStateListener()
    {
      public void checkStateChanged(CheckStateChangedEvent event)
      {
        Object element = event.getElement();

        if (!(element instanceof AntLib))
        {
          while (!(element instanceof JavaDoc))
          {
            element = contentProvider.getParent(element);
          }
        }

        checkTreeElement(element, event.getChecked());

        int sum = 0;
        Collection<JavaDoc> javaDocs = antLib.getJavaDocs();
        for (JavaDoc javaDoc : javaDocs)
        {
          boolean checked = treeViewer.getChecked(javaDoc);
          sum += checked ? 1 : 0;

          String project = javaDoc.getProject().getName();
          if (preferences.getBoolean(project, true) != checked)
          {
            preferences.putBoolean(project, checked);
          }
        }

        treeViewer.setChecked(antLib, sum == antLib.getJavaDocs().size());
        updateEnablement();
      }
    });

    Tree tree = treeViewer.getTree();
    tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();

    toolbarManager.add(new Action("Debug", Action.AS_CHECK_BOX)
    {
      {
        setImageDescriptor(AbstractUIPlugin.imageDescriptorFromPlugin(RELENG_NAME, "icons/debug.gif"));
      }

      @Override
      public void run()
      {
        debugPreprocessor = isChecked();
      }
    });

    toolbarManager.add(new Action("Refresh", AbstractUIPlugin.imageDescriptorFromPlugin(RELENG_NAME, "icons/refresh.gif"))
    {
      @Override
      public void run()
      {
        init();
      }
    });

    init();
  }

  private void updateEnablement()
  {
    boolean enabled = preprocessButton.getSelection() || javaButton.getSelection() || schemaButton.getSelection() || articleButton.getSelection();
    if (enabled)
    {
      enabled = false;
      for (JavaDoc javaDoc : antLib.getJavaDocs())
      {
        if (treeViewer.getChecked(javaDoc))
        {
          enabled = true;
          break;
        }
      }
    }

    generateButton.setEnabled(enabled);
  }

  private void checkTreeElement(Object element, boolean checked)
  {
    treeViewer.setChecked(element, checked);
    for (Object child : contentProvider.getChildren(element))
    {
      checkTreeElement(child, checked);
    }
  }

  private void init()
  {
    try
    {
      antLib = null;
      helpcenter = null;
      plugins = null;
      releng = null;

      for (IProject project : ROOT.getProjects())
      {
        if (helpcenter == null)
        {
          if (project.getFile(AssembleScripts.ANTLIB_NAME).exists())
          {
            helpcenter = project.getLocation().toFile();
          }
        }

        if (plugins == null)
        {
          if (project.getFile("toc.xml").exists())
          {
            plugins = project.getLocation().toFile().getParentFile();
          }
        }

        if (releng == null)
        {
          if (project.getName().equals(RELENG_NAME))
          {
            releng = project.getLocation().toFile();
          }
        }

        if (helpcenter != null && plugins != null && releng != null)
        {
          break;
        }
      }

      if (releng == null)
      {
        Bundle bundle = Platform.getBundle(RELENG_NAME);
        if (bundle != null)
        {
          File bundleFile = FileLocator.getBundleFile(bundle);
          if (bundleFile != null)
          {
            releng = bundleFile;
          }
        }
      }

      AssembleScripts assembler = new AssembleScripts(helpcenter, plugins, releng);
      assembler.setLogger(new AssembleScripts.Logger()
      {
        @Override
        public void info(Object object)
        {

        }

        @Override
        public void error(Object object)
        {
          if (object instanceof Throwable)
          {
            ArticlePlugin.INSTANCE.log(object);
          }
        }
      });

      antLib = assembler.run();

      treeViewer.refresh();
      treeViewer.expandToLevel(2);

      int sum = 0;
      Set<IResource> resourcesToRefresh = initResourcesToRefresh();

      Collection<JavaDoc> javaDocs = antLib.getJavaDocs();
      for (JavaDoc javaDoc : javaDocs)
      {
        String project = javaDoc.getProject().getName();
        boolean checked = preferences.getBoolean(project, true);
        sum += checked ? 1 : 0;
        checkTreeElement(javaDoc, checked);

        resourcesToRefresh.add(ROOT.getProject(project));
      }

      treeViewer.setChecked(antLib, sum == antLib.getJavaDocs().size());
      updateEnablement();

      refreshResources(resourcesToRefresh);
    }
    catch (Exception ex)
    {
      ArticlePlugin.INSTANCE.log(ex);
    }
  }

  private Set<IResource> initResourcesToRefresh()
  {
    Set<IResource> resourcesToRefresh = new HashSet<IResource>();
    if (helpcenter != null)
    {
      resourcesToRefresh.add(ROOT.getProject(helpcenter.getName()));
    }

    return resourcesToRefresh;
  }

  private void refreshResources(final Set<IResource> resources)
  {
    new Job("Refresh")
    {
      @Override
      protected IStatus run(IProgressMonitor monitor)
      {
        try
        {
          ROOT.getWorkspace().run(new IWorkspaceRunnable()
          {
            public void run(IProgressMonitor monitor) throws CoreException
            {
              monitor.beginTask("", resources.size());
              for (IResource resource : resources)
              {
                try
                {
                  resource.refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 1));
                }
                catch (Exception ex)
                {
                  ArticlePlugin.INSTANCE.log(ex);
                }
              }

              monitor.done();
            }
          }, monitor);
        }
        catch (CoreException ex)
        {
          ArticlePlugin.INSTANCE.log(ex);
        }

        return Status.OK_STATUS;
      }

      private void refresh(final Set<IResource> resources, IProgressMonitor monitor)
      {
        try
        {
          ROOT.getWorkspace().run(new IWorkspaceRunnable()
          {
            public void run(IProgressMonitor monitor) throws CoreException
            {
              monitor.beginTask("", resources.size());
              for (IResource resource : resources)
              {
                try
                {
                  resource.refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 1));
                }
                catch (Exception ex)
                {
                  ArticlePlugin.INSTANCE.log(ex);
                }
              }

              monitor.done();
            }
          }, monitor);
        }
        catch (CoreException ex)
        {
          ArticlePlugin.INSTANCE.log(ex);
        }
      }
    }.schedule();
  }

  private void generate() throws Exception
  {
    try
    {
      generateButton.setEnabled(false);

      final boolean preprocess = preprocessButton.getSelection();
      final boolean generate = javaButton.getSelection() || schemaButton.getSelection() || articleButton.getSelection();

      final Set<IResource> resourcesToRefresh = initResourcesToRefresh();
      final String tpClasspathFile = new TargetPlatformClasspathFile().resolveValue(null, null);
      final StringBuilder preprocessorProjects = new StringBuilder("");
      final StringBuilder generatorArguments = new StringBuilder("-Dtp.classpath.file=" + tpClasspathFile + " -Dplugins.dir=" + plugins
          + " -Dhelpcenter.project=" + helpcenter + " -Dreleng.project=" + releng + " -Dskip.assemble.scripts=true");

      if (!javaButton.getSelection())
      {
        generatorArguments.append(" -Dskip.javadoc=true");
      }

      if (!schemaButton.getSelection())
      {
        generatorArguments.append(" -Dskip.schemadoc=true");
      }

      if (!articleButton.getSelection())
      {
        generatorArguments.append(" -Dskip.articledoc=true");
      }

      for (JavaDoc javaDoc : antLib.getJavaDocs())
      {
        String project = javaDoc.getProject().getName();
        if (treeViewer.getChecked(javaDoc))
        {
          resourcesToRefresh.add(ROOT.getProject(project));

          if (preprocessorProjects.length() != 0)
          {
            preprocessorProjects.append(";");
          }

          preprocessorProjects.append("${resource_loc:/" + project + "}");
        }
        else
        {
          generatorArguments.append(" -Dskip." + project + "=true");
        }
      }

      new Job("Doc Dash")
      {
        @Override
        protected IStatus run(IProgressMonitor monitor)
        {
          try
          {
            ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();

            if (preprocess)
            {
              ILaunchConfigurationType type = launchManager.getLaunchConfigurationType("org.eclipse.pde.ui.RuntimeWorkbench");
              ILaunchConfigurationWorkingCopy wc = type.newInstance(null, launchManager.generateLaunchConfigurationName("Preprocess Documentation"));
              configurePreprocessor(wc, preprocessorProjects);

              ILaunch launch = wc.launch(debugPreprocessor ? ILaunchManager.DEBUG_MODE : ILaunchManager.RUN_MODE, null);
              waitForLaunch(launch);
            }

            if (generate)
            {
              ILaunchConfigurationType type = launchManager.getLaunchConfigurationType("org.eclipse.ant.AntLaunchConfigurationType");
              ILaunchConfigurationWorkingCopy wc = type.newInstance(null, launchManager.generateLaunchConfigurationName("Generate Documentation"));
              configureGenerator(wc, generatorArguments);

              ILaunch launch = wc.launch(ILaunchManager.RUN_MODE, null);
              waitForLaunch(launch);
            }
          }
          catch (CoreException ex)
          {
            return ex.getStatus();
          }
          finally
          {
            reenableGenerateButton();
            refreshResources(resourcesToRefresh);
          }

          return Status.OK_STATUS;
        }

        private void waitForLaunch(final ILaunch launch)
        {
          while (launch != null && !launch.isTerminated())
          {
            try
            {
              Thread.sleep(200);
            }
            catch (InterruptedException ex)
            {
              throw new RuntimeException(ex);
            }
          }
        }

        private void refresh(final Set<IResource> resources, IProgressMonitor monitor)
        {
          try
          {
            if (!resources.isEmpty())
            {
              ROOT.getWorkspace().run(new IWorkspaceRunnable()
              {
                public void run(IProgressMonitor monitor) throws CoreException
                {
                  monitor.beginTask("", resources.size());
                  for (IResource resource : resources)
                  {
                    try
                    {
                      resource.refreshLocal(IResource.DEPTH_INFINITE, new SubProgressMonitor(monitor, 1));
                    }
                    catch (Exception ex)
                    {
                      ArticlePlugin.INSTANCE.log(ex);
                    }
                  }

                  monitor.done();
                }
              }, monitor);
            }
          }
          catch (CoreException ex)
          {
            ArticlePlugin.INSTANCE.log(ex);
          }
        }

        private void reenableGenerateButton()
        {
          if (!generateButton.isDisposed())
          {
            generateButton.getDisplay().syncExec(new Runnable()
            {
              public void run()
              {
                generateButton.setEnabled(true);
              }
            });
          }
        }
      }.schedule();
    }
    catch (Error ex)
    {
      generateButton.setEnabled(true);
      throw ex;
    }
    catch (Exception ex)
    {
      generateButton.setEnabled(true);
      throw ex;
    }
  }

  private void configureGenerator(ILaunchConfigurationWorkingCopy wc, final StringBuilder generatorArguments)
  {
    wc.setAttribute("org.eclipse.ant.ui.DEFAULT_VM_INSTALL", false);
    wc.setAttribute("org.eclipse.jdt.launching.CLASSPATH_PROVIDER", "org.eclipse.ant.ui.AntClasspathProvider");
    wc.setAttribute("org.eclipse.jdt.launching.JRE_CONTAINER",
        "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7");
    wc.setAttribute("org.eclipse.jdt.launching.MAIN_TYPE", "org.eclipse.ant.internal.launching.remote.InternalAntRunner");
    wc.setAttribute("org.eclipse.jdt.launching.PROJECT_ATTR", "");
    wc.setAttribute("org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER", "org.eclipse.ant.ui.AntClasspathProvider");
    wc.setAttribute("org.eclipse.ui.externaltools.ATTR_LOCATION", releng + "/build.ant");
    wc.setAttribute("org.eclipse.ui.externaltools.ATTR_TOOL_ARGUMENTS", generatorArguments.toString());
    wc.setAttribute("org.eclipse.ui.externaltools.ATTR_WORKING_DIRECTORY", helpcenter.getAbsolutePath());
    wc.setAttribute("process_factory_id", "org.eclipse.ant.ui.remoteAntProcessFactory");
  }

  private void configurePreprocessor(ILaunchConfigurationWorkingCopy wc, final StringBuilder preprocessorProjects)
  {
    wc.setAttribute("append.args", true);
    wc.setAttribute("askclear", true);
    wc.setAttribute("automaticAdd", true);
    wc.setAttribute("automaticValidate", false);
    wc.setAttribute("bootstrap", "");
    wc.setAttribute("checked", "[NONE]");
    wc.setAttribute("clearConfig", false);
    wc.setAttribute("clearws", false);
    wc.setAttribute("clearwslog", false);
    wc.setAttribute("configLocation", "${workspace_loc}/.metadata/.plugins/org.eclipse.pde.core/Preprocess Documentation");
    wc.setAttribute("default", true);
    wc.setAttribute("generateProfile", true);
    wc.setAttribute("includeOptional", true);
    wc.setAttribute("location", "${workspace_loc}/preprocessor-workspace");
    wc.setAttribute("org.eclipse.debug.ui.ATTR_CONSOLE_ENCODING", "UTF-8");
    wc.setAttribute("org.eclipse.jdt.launching.ATTR_USE_START_ON_FIRST_THREAD", true);
    wc.setAttribute("org.eclipse.jdt.launching.JRE_CONTAINER",
        "org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.7");
    wc.setAttribute("org.eclipse.jdt.launching.PROGRAM_ARGUMENTS", "-os ${target.os} -ws ${target.ws} -arch ${target.arch} -nl ${target.nl} -consoleLog");
    wc.setAttribute("org.eclipse.jdt.launching.SOURCE_PATH_PROVIDER", "org.eclipse.pde.ui.workbenchClasspathProvider");
    wc.setAttribute("org.eclipse.jdt.launching.VM_ARGUMENTS",
        "-Xms1024m -Xmx2500m -XX:MaxPermSize=512m -Doomph.setup.skip=true -Dpreprocessor.workspace=${workspace_loc} -Dpreprocessor.projects="
            + preprocessorProjects);
    wc.setAttribute("pde.version", "3.3");
    wc.setAttribute("product", "org.eclipse.sdk.ide");
    wc.setAttribute("show_selected_only", false);
    wc.setAttribute("templateConfig", "${target_home}\\configuration\\config.ini");
    wc.setAttribute("tracing", false);
    wc.setAttribute("useCustomFeatures", false);
    wc.setAttribute("useDefaultConfig", true);
    wc.setAttribute("useDefaultConfigArea", true);
    wc.setAttribute("useProduct", true);

    Map<String, String> environmentVariables = new LinkedHashMap<String, String>();
    environmentVariables.put("preprocessor.workspace.project.locations", "${workspace_project_locations}");
    wc.setAttribute("org.eclipse.debug.core.environmentVariables", environmentVariables);
  }

  /**
   * @author Eike Stepper
   */
  private static final class ElementWrapper
  {
    private final Object parent;

    private final Type type;

    private final String name;

    public ElementWrapper(Object parent, Type type, String name)
    {
      this.parent = parent;
      this.type = type;
      this.name = name;
    }

    public Object getParent()
    {
      return parent;
    }

    public Type getType()
    {
      return type;
    }

    public String getName()
    {
      return name;
    }

    @Override
    public int hashCode()
    {
      final int prime = 31;
      int result = 1;
      result = prime * result + (name == null ? 0 : name.hashCode());
      result = prime * result + (parent == null ? 0 : parent.hashCode());
      result = prime * result + (type == null ? 0 : type.hashCode());
      return result;
    }

    @Override
    public boolean equals(Object obj)
    {
      if (this == obj)
      {
        return true;
      }

      if (obj == null)
      {
        return false;
      }

      if (getClass() != obj.getClass())
      {
        return false;
      }

      ElementWrapper other = (ElementWrapper)obj;
      if (name == null)
      {
        if (other.name != null)
        {
          return false;
        }
      }
      else if (!name.equals(other.name))
      {
        return false;
      }

      if (parent == null)
      {
        if (other.parent != null)
        {
          return false;
        }
      }
      else if (!parent.equals(other.parent))
      {
        return false;
      }

      if (type != other.type)
      {
        return false;
      }

      return true;
    }

    @Override
    public String toString()
    {
      return name;
    }

    /**
     * @author Eike Stepper
     */
    public static enum Type
    {
      Dependency, JavaPackage, ExtensionPoint
    }
  }

  /**
   * @author Eike Stepper
   */
  private class DocContentProvider implements ITreeContentProvider
  {
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput)
    {
    }

    public void dispose()
    {
    }

    public Object[] getElements(Object inputElement)
    {
      return getChildren(inputElement);
    }

    public Object[] getChildren(Object parentElement)
    {
      if (parentElement instanceof DocDash && antLib != null)
      {
        return new Object[] { antLib };
      }

      if (parentElement instanceof AntLib)
      {
        AntLib antLib = (AntLib)parentElement;
        List<Object> children = new ArrayList<Object>();
        for (JavaDoc child : antLib.getJavaDocsSortedByDependencies())
        {
          children.add(child);
        }

        Collections.reverse(children);
        return children.toArray();
      }

      if (parentElement instanceof JavaDoc)
      {
        JavaDoc javaDoc = (JavaDoc)parentElement;
        List<Object> children = new ArrayList<Object>();
        for (String child : javaDoc.getAllDependencies())
        {
          children.add(new ElementWrapper(parentElement, ElementWrapper.Type.Dependency, child));
        }

        children.addAll(javaDoc.getSortedSourcePlugins());
        return children.toArray();
      }

      if (parentElement instanceof SourcePlugin)
      {
        SourcePlugin sourcePlugin = (SourcePlugin)parentElement;
        List<Object> children = new ArrayList<Object>();
        for (String child : sourcePlugin.getSortedPackageNames())
        {
          children.add(new ElementWrapper(parentElement, ElementWrapper.Type.JavaPackage, child));
        }

        for (String child : sourcePlugin.getSortedSchemaNames())
        {
          children.add(new ElementWrapper(parentElement, ElementWrapper.Type.ExtensionPoint, child));
        }

        return children.toArray();
      }

      return new Object[0];
    }

    public boolean hasChildren(Object element)
    {
      return getChildren(element).length != 0;
    }

    public Object getParent(Object element)
    {
      if (element instanceof AntLib)
      {
        return DocDash.this;
      }

      if (element instanceof JavaDoc)
      {
        JavaDoc javaDoc = (JavaDoc)element;
        return antLib;
      }

      if (element instanceof SourcePlugin)
      {
        SourcePlugin sourcePlugin = (SourcePlugin)element;
        return sourcePlugin.getJavaDoc();
      }

      if (element instanceof ElementWrapper)
      {
        ElementWrapper wrapper = (ElementWrapper)element;
        return wrapper.getParent();
      }

      return null;
    }
  }

  /**
   * @author Eike Stepper
   */
  private class DocLabelProvider extends LabelProvider
  {
    private Image helpCenterImage = loadImage("icons/helpcenter.gif");

    private Image documentationImage = loadImage("html/helpcenter/documentation.gif");

    private Image dependencyImage = loadImage("icons/dependency.gif");

    private Image pluginImage = loadImage("html/helpcenter/plugin.gif");

    private Image packageImage = loadImage("html/helpcenter/package.gif");

    private Image schemaImage = loadImage("html/helpcenter/extpoint.gif");

    private Image loadImage(String path)
    {
      ImageDescriptor imageDescriptor = AbstractUIPlugin.imageDescriptorFromPlugin(RELENG_NAME, path);
      return imageDescriptor.createImage();
    }

    @Override
    public void dispose()
    {
      helpCenterImage.dispose();
      documentationImage.dispose();
      dependencyImage.dispose();
      pluginImage.dispose();
      packageImage.dispose();
      schemaImage.dispose();
      super.dispose();
    }

    @Override
    public Image getImage(Object element)
    {
      if (element instanceof AntLib)
      {
        return helpCenterImage;
      }

      if (element instanceof JavaDoc)
      {
        return documentationImage;
      }

      if (element instanceof SourcePlugin)
      {
        return pluginImage;
      }

      if (element instanceof ElementWrapper)
      {
        switch (((ElementWrapper)element).getType())
        {
          case Dependency:
            return dependencyImage;

          case JavaPackage:
            return packageImage;

          case ExtensionPoint:
            return schemaImage;
        }
      }

      return super.getImage(element);
    }

    @Override
    public String getText(Object element)
    {
      if (element instanceof AntLib)
      {
        return helpcenter == null ? "<helpcenter>" : helpcenter.getName();
      }

      return super.getText(element);
    }
  }
}
