package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.oomph.internal.ui.AccessUtil;
import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePlugin;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;
import org.eclipse.oomph.util.ReflectUtil;
import org.eclipse.oomph.util.StringUtil;

import org.eclipse.emf.codegen.merge.java.facade.FacadeVisitor;
import org.eclipse.emf.codegen.merge.java.facade.JAbstractType;
import org.eclipse.emf.codegen.merge.java.facade.JCompilationUnit;
import org.eclipse.emf.codegen.merge.java.facade.JField;
import org.eclipse.emf.codegen.merge.java.facade.JMethod;
import org.eclipse.emf.codegen.merge.java.facade.JNode;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTFacadeHelper;
import org.eclipse.emf.codegen.merge.java.facade.ast.ASTJCompilationUnit;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.edit.ui.provider.DiagnosticDecorator;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerColumn;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.XMLMemento;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.ui.views.properties.IPropertySheetEntry;
import org.eclipse.ui.views.properties.PropertySheet;
import org.eclipse.ui.views.properties.PropertySheetPage;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("restriction")
public class Preprocessor
{
  private static final String PREPROCESSOR_REPLACEMENT = "preprocessor.replacement.";

  private static Pattern TREE_SNIPPET_PATTERN = Pattern
      .compile(
          "@[ \t]*snippet[ \t]+tree[ \t]+([^ \t\n\r]+)[ \t]+([^\n\r]*?)([ \t]+\\(categorized|advanced|categorized[ \t]+advanced|advanced[ \t]+categorized\\))?[ \t]*[\r\n]",
          Pattern.MULTILINE);

  // {{
  private static Pattern IMAGE_PATTERN = Pattern.compile("@[ \t]*image[ \t]+([^ \t\n\r}]+)[ \t]+([^\n\r]*?)[ \t]*[\r\n}]", Pattern.MULTILINE);

  private static Pattern XML_SNIPPET_PATTERN = Pattern.compile("@[ \t]*snippet[ \t]+xml[ \t]+([^ \t\n\r]+)[ \t]+([^\n\r]+?)[ \t]*[\r\n]", Pattern.MULTILINE);

  private static final Object BLANK = ArticlePlugin.INSTANCE.getImage("full/obj16/Blank");

  private static final Object FAMILY_MODEL_LOAD;

  static
  {
    Object loadFamily = null;
    try
    {
      loadFamily = ReflectUtil.getValue(
          ReflectUtil.getField(CommonPlugin.loadClass("org.eclipse.oomph.setup.ui", "org.eclipse.oomph.setup.ui.SetupEditorSupport"), "FAMILY_MODEL_LOAD"),
          null);
    }
    catch (ClassNotFoundException ex)
    {
      // Ignore
    }

    FAMILY_MODEL_LOAD = loadFamily;
  }

  private static final IWorkbench workbench = PlatformUI.getWorkbench();

  private static final Display display = PlatformUI.getWorkbench().getDisplay();

  private final ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);

  private final AdapterFactoryItemDelegator itemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
      ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

  private final ILabelProvider defaultLabelProvider = new AdapterFactoryLabelProvider(adapterFactory);

  private final ITreeContentProvider defaultContentProvider = new AdapterFactoryContentProvider(adapterFactory);

  private final IWorkspaceRoot workspaceRoot = EcorePlugin.getWorkspaceRoot();

  private final IWorkspace workspace = workspaceRoot.getWorkspace();

  private final ResourceSet resourceSet = createResourceSet();

  private final Map<Object, String> imageURLs = new HashMap<Object, String>();

  private final Set<Class> pruned = new HashSet<Class>();

  private URI imageFolder;

  private String bundleID;

  private JAbstractType type;

  private JMethod method;

  private URI targetURI;

  private ILabelProvider labelProvider;

  private ITreeContentProvider contentProvider;

  private PropertySheetPage propertySheetPage;

  private Viewer viewer;

  private ViewerFilter[] filters;

  private Map<String, String> replacements = new HashMap<String, String>();

  public Preprocessor()
  {
    computeTargetPlatform();

    for (Map.Entry<Object, Object> entry : System.getProperties().entrySet())
    {
      Object key = entry.getKey();
      if (key instanceof String)
      {
        String property = (String)key;
        if (property.startsWith(PREPROCESSOR_REPLACEMENT))
        {
          String value = entry.getValue().toString();
          File file = new File(value);
          if (file.isAbsolute() && file.exists())
          {
            try
            {
              File x = file.getCanonicalFile();
              value = URI.createURI(".").resolve(URI.createFileURI(value)).trimSegments(2).toFileString();
            }
            catch (IOException ex)
            {
              ex.printStackTrace();
            }
          }

          replacements.put(value, "${" + property.substring(PREPROCESSOR_REPLACEMENT.length()) + "}");
        }
      }
    }
  }

  public void visitProject(File project)
  {
    URI projectURI = URI.createFileURI(project.getPath());
    bundleID = projectURI.lastSegment();
    imageFolder = projectURI.appendSegment("images").appendSegment("trees");
    visit(project);
  }

  private void visit(File file)
  {
    if (file.isDirectory())
    {
      for (File child : file.listFiles())
      {
        visit(child);
      }
    }
    else if (file.isFile())
    {
      URI uri = URI.createFileURI(file.getPath());
      if ("java".equals(uri.fileExtension()))
      {
        visitJava(uri);
      }
    }
  }

  private void visitJava(final URI uri)
  {
    try
    {
      String contents = getContents(uri, "UTF-8");
      ASTFacadeHelper astFacadeHelper = new ASTFacadeHelper();
      astFacadeHelper.setCompilerCompliance("1.7");
      ASTJCompilationUnit compilationUnit = astFacadeHelper.createCompilationUnit(uri.lastSegment(), contents);

      new FacadeVisitor()
      {
        protected void visitComment(String comment)
        {
          if (comment != null)
          {
            try
            {
              visitXMLs(uri, comment);
              visitImages(uri, comment);
              visitTrees(uri, comment);
            }
            catch (IOException ex)
            {
              ex.printStackTrace();
            }
          }
        }

        @Override
        protected boolean visit(JCompilationUnit compilationUnit)
        {
          return super.visit(compilationUnit);
        }

        @Override
        protected boolean visit(JField field)
        {
          visitComment(field.getComment());
          return super.visit(field);
        }

        @Override
        protected boolean visit(JMethod method)
        {
          Preprocessor.this.method = method;
          visitComment(method.getComment());
          Preprocessor.this.method = null;
          return super.visit(method);
        }

        @Override
        protected boolean visit(JAbstractType abstractType)
        {
          type = abstractType;
          visitComment(abstractType.getComment());
          type = abstractType;
          return super.visit(abstractType);
        }
      }.start(compilationUnit);
    }
    catch (IOException ex)
    {
      // Ignore.
    }
  }

  private void visitTrees(URI uri, String contents) throws IOException
  {
    for (Matcher matcher = TREE_SNIPPET_PATTERN.matcher(contents); matcher.find();)
    {
      String target = matcher.group(1);
      String sources = matcher.group(2);
      String options = matcher.group(3);

      if (sources != null && sources.length() != 0)
      {
        targetURI = resolve(uri, URI.createURI(target));
        List<URI> sourceURIs = new ArrayList<URI>();
        for (String source : sources.split("\\s"))
        {
          sourceURIs.add(resolve(uri, URI.createURI(source)));
        }

        boolean categorized = false;
        boolean advanced = false;
        if (options != null)
        {
          for (String option : options.split("\\s"))
          {
            if ("categorized".equals(option))
            {
              categorized = true;
            }
            else if ("advanced".equals(option))
            {
              advanced = true;
            }
          }
        }

        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        Map<Object, TreeNode> treeNodeMap = new HashMap<Object, TreeNode>();

        for (URI sourceURI : sourceURIs)
        {
          pruned.clear();
          labelProvider = null;
          contentProvider = null;
          propertySheetPage = null;
          viewer = null;
          filters = null;

          IViewPart view = getView(sourceURI);
          if (view != null)
          {
            try
            {
              visitTree(treeNodes, treeNodeMap, getTreeViewer(display.getFocusControl()));
            }
            catch (PartInitException ex)
            {
              ex.printStackTrace();
            }
          }
          else
          {
            IEditorPart editor = getEditor(sourceURI);
            if (editor != null)
            {
              try
              {
                if (editor instanceof IViewerProvider)
                {
                  IViewerProvider viewerProvider = (IViewerProvider)editor;
                  Viewer viewer = viewerProvider.getViewer();
                  String query = sourceURI.query();
                  URI queryURI = URI.createURI(query == null ? "" : query);
                  if (queryURI.segmentCount() == 1 && "Outline".equals(queryURI.segment(0)))
                  {
                    ContentOutline contentOutline = (ContentOutline)getWorkbenchPage().showView("org.eclipse.ui.views.ContentOutline");
                    contentOutline.setFocus();
                    visitTree(treeNodes, treeNodeMap, getTreeViewer(display.getFocusControl()));
                  }
                  else if (viewer instanceof TreeViewer)
                  {
                    TreeViewer treeViewer = (TreeViewer)viewer;
                    visitTree(treeNodes, treeNodeMap, treeViewer);
                  }
                }
              }
              catch (PartInitException ex)
              {
                ex.printStackTrace();
              }

              // editor.dispose();
            }
            else
            {
              labelProvider = defaultLabelProvider;
              contentProvider = defaultContentProvider;

              String query = sourceURI.query();
              if (query != null)
              {
                URI queryURI = URI.createURI(query);
                if ("prune".equals(queryURI.scheme()))
                {
                  for (String segment : queryURI.segments())
                  {
                    Class<?> segmentClass = loadClass(segment);
                    if (segmentClass != null)
                    {
                      pruned.add(segmentClass);
                    }
                  }

                  sourceURI = sourceURI.trimQuery();
                }
              }

              String fragment = sourceURI.fragment();
              if (fragment != null)
              {
                boolean allChildren = false;
                if (fragment.endsWith("/*"))
                {
                  fragment = fragment.substring(0, fragment.length() - 2);
                  sourceURI = sourceURI.appendFragment(fragment);
                  allChildren = true;
                }

                if (fragment.length() == 0)
                {
                  URI sourceResourceURI = sourceURI.trimFragment();
                  Resource resource = resourceSet.getResource(sourceResourceURI, true);
                  URI resourceURI = resource.getURI();
                  resource.setURI(sourceResourceURI);
                  TreeNode treeNode = createTreeNode(treeNodeMap, resource);
                  resource.setURI(resourceURI);
                  treeNodes.add(treeNode);

                  for (EObject eObject : resource.getContents())
                  {
                    treeNodes.add(createTreeNode(treeNodeMap, eObject));
                  }
                }
                else
                {
                  EObject eObject = resourceSet.getEObject(sourceURI, true);
                  if (allChildren)
                  {
                    for (EObject child : eObject.eContents())
                    {
                      treeNodes.add(createTreeNode(treeNodeMap, child));
                    }
                  }
                  else
                  {
                    treeNodes.add(createTreeNode(treeNodeMap, eObject));
                  }
                }
              }
              else
              {
                Resource resource = resourceSet.getResource(sourceURI, true);
                URI resourceURI = resource.getURI();
                resource.setURI(sourceURI);
                TreeNode treeNode = createTreeNode(treeNodeMap, resource);
                resource.setURI(resourceURI);
                treeNodes.add(treeNode);
              }
            }
          }
        }

        if (!treeNodes.isEmpty())
        {
          XMIResource treeResource = (XMIResource)resourceSet.getResourceFactoryRegistry().getFactory(URI.createURI("*.setup")).createResource(targetURI);
          treeResource.getContents().addAll(treeNodes);

          for (Map.Entry<Object, TreeNode> entry : treeNodeMap.entrySet())
          {
            Object object = entry.getKey();
            Object unwrappedObject = AdapterFactoryEditingDomain.unwrap(object);
            if (unwrappedObject instanceof EObject)
            {
              EObject eObject = (EObject)unwrappedObject;
              URI id = EcoreUtil.getURI(eObject);
              treeResource.setID(entry.getValue(), escape(id.isPlatformResource() ? id.toPlatformString(false) + "#" + id.fragment() : id.toString()));
            }
          }

          treeResource.save(null);
        }
      }
    }
  }

  private void visitXMLs(URI uri, String contents) throws IOException
  {
    for (Matcher matcher = XML_SNIPPET_PATTERN.matcher(contents); matcher.find();)
    {
      String target = matcher.group(1);
      String source = matcher.group(2);

      targetURI = resolve(uri, URI.createURI(target));
      URI sourceURI = resolve(uri, URI.createURI(source));

      Resource resource = resourceSet.getResource(sourceURI, true);
      resource.save(resourceSet.getURIConverter().createOutputStream(targetURI), null);
    }
  }

  private String getQualifiedName(JAbstractType type)
  {
    JNode parent = type.getParent();
    if (parent instanceof JAbstractType)
    {
      return getQualifiedName((JAbstractType)parent) + "$" + type.getName();
    }

    return type.getQualifiedName();
  }

  private void visitImages(URI uri, String contents) throws IOException
  {
    for (Matcher matcher = IMAGE_PATTERN.matcher(contents); matcher.find();)
    {
      String target = matcher.group(1);
      String source = matcher.group(2);

      targetURI = resolve(uri, URI.createURI(target));
      URI sourceURI = resolve(uri, URI.createURI(source));

      if ("invoke".equals(sourceURI.scheme()))
      {
        String typeName = sourceURI.authority();
        if (StringUtil.isEmpty(typeName))
        {
          typeName = getQualifiedName(type);
        }

        String methodName;
        if (sourceURI.segmentCount() == 0)
        {
          methodName = method.getName();
        }
        else
        {
          methodName = sourceURI.segment(0);
        }

        try
        {
          Class<?> invocationClass = loadClass(typeName);
          Method method = invocationClass.getMethod(methodName);

          EarlyStartup.closeShell = false;
          Image image = (Image)method.invoke(null);
          saveImage(image);
          image.dispose();
          EarlyStartup.closeShell = true;
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }
      else
      {
        IViewPart view = getView(sourceURI);
        if (view != null)
        {
          Control partControl = getPartControl(display.getFocusControl());
          capture(partControl);
        }
        else
        {
          IEditorPart editor = getEditor(sourceURI);
          if (editor != null)
          {
            URI queryURI = URI.createURI(sourceURI.query());
            if ("diagram".equals(queryURI.query()))
            {
              Class<?> saveAsImageFileAction = loadClass("org.eclipse.sirius.diagram.ui:org.eclipse.sirius.diagram.ui.tools.internal.actions.SaveAsImageFileAction");
              try
              {
                IAction action = (IAction)saveAsImageFileAction.newInstance();
                EarlyStartup.closeShell = false;

                final Listener displayListener = new Listener()
                {
                  private boolean outputVisited;

                  private String type;

                  {
                    String fileExtension = targetURI.fileExtension();
                    if ("jpg".equalsIgnoreCase(fileExtension) || "jpeg".equalsIgnoreCase(fileExtension))
                    {
                      type = "JPG";
                    }
                    else if ("svg".equalsIgnoreCase(fileExtension))
                    {
                      type = "SVG";
                    }
                    else if ("bmp".equalsIgnoreCase(fileExtension))
                    {
                      type = "BMP";
                    }
                    else if ("gif".equalsIgnoreCase(fileExtension))
                    {
                      type = "GIF";
                    }
                    else
                    {
                      type = "PNG";
                    }
                  }

                  public void handleEvent(final Event event)
                  {
                    if (event.widget instanceof Shell)
                    {
                      display.removeListener(SWT.Skin, this);
                      Shell shell = (Shell)event.widget;
                      updateDialogSettings(shell);

                      busyWait();

                      display.asyncExec(new Runnable()
                      {
                        public void run()
                        {
                          try
                          {
                            ReflectUtil.getMethod(Dialog.class, "okPressed").invoke(event.widget.getData());
                            // editor.dispose();
                            EarlyStartup.closeShell = true;
                          }
                          catch (Exception ex)
                          {
                            ex.printStackTrace();
                          }
                        }
                      });

                    }
                  }

                  private void updateDialogSettings(Control control)
                  {
                    if (control instanceof Combo)
                    {
                      Combo combo = (Combo)control;
                      if (outputVisited)
                      {
                        combo.setText(type);
                      }
                      else
                      {
                        combo.setText(targetURI.toFileString());
                      }

                      return;
                    }

                    if (control instanceof Composite)
                    {
                      Composite composite = (Composite)control;
                      for (Control child : composite.getChildren())
                      {
                        updateDialogSettings(child);
                      }
                    }
                  }
                };
                display.addListener(SWT.Skin, displayListener);

                action.run();
              }
              catch (Exception exception)
              {

              }
            }
            else
            {
              Control partControl = getPartControl(display.getFocusControl());
              capture(partControl);
            }

            // editor.dispose();
          }
        }
      }
    }
  }

  private IViewPart getView(URI sourceURI)
  {
    if ("viewer".equals(sourceURI.scheme()))
    {
      try
      {
        String query = sourceURI.query();
        if (query != null)
        {
          for (String segment : URI.createURI(query).segments())
          {
            Class<?> segmentClass = loadClass(segment);
            if (segmentClass != null)
            {
              pruned.add(segmentClass);
            }
          }
        }

        IViewPart view = getWorkbenchPage().showView(sourceURI.authority());
        busyWait();
        view.setFocus();
        return view;
      }
      catch (PartInitException ex)
      {
        ex.printStackTrace();
      }
    }

    return null;
  }

  private IEditorPart getEditor(URI sourceURI)
  {
    String query = sourceURI.query();
    if (query != null)
    {
      URI queryURI = URI.createURI(query);
      if ("editor".equals(queryURI.scheme()))
      {
        IEditorInput editorInput = getEditorInput(sourceURI);
        if (editorInput != null)
        {
          String editorID = getEditorID(sourceURI);
          try
          {
            IEditorPart editor = getWorkbenchPage().openEditor(editorInput, editorID);

            String editorQuery = queryURI.query();
            if (editorQuery != null)
            {
              URI editorQueryURI = URI.createURI(editorQuery);
              if (!editorQueryURI.hasRelativePath())
              {
                for (String segment : editorQueryURI.segments())
                {
                  Class<?> segmentClass = loadClass(segment);
                  if (segmentClass != null)
                  {
                    pruned.add(segmentClass);
                  }
                }
              }
            }

            busyWait();
            editor.setFocus();
            return editor;
          }
          catch (PartInitException ex)
          {
            ex.printStackTrace();
          }
        }
      }
    }

    return null;
  }

  private String getEditorID(URI sourceURI)
  {
    String query = sourceURI.query();
    if (query != null)
    {
      URI queryURI = URI.createURI(query);
      if ("editor".equals(queryURI.scheme()))
      {
        String editorID = queryURI.authority();
        if (editorID != null && !"".equals(editorID))
        {
          return editorID;
        }
      }
    }

    return workbench.getEditorRegistry().getDefaultEditor(sourceURI.lastSegment()).getId();
  }

  private void visit(Control control)
  {
    if (control != null)
    {
      visit(control.getParent());
    }
  }

  private void visitTree(List<TreeNode> treeNodes, Map<Object, TreeNode> treeNodeMap, TreeViewer treeViewer) throws PartInitException
  {
    if (treeViewer != null)
    {
      PropertySheet propertySheet = (PropertySheet)getWorkbenchPage().showView("org.eclipse.ui.views.PropertySheet");
      propertySheetPage = (PropertySheetPage)propertySheet.getCurrentPage();
      propertySheetPage.setFocus();
      labelProvider = (ILabelProvider)treeViewer.getLabelProvider();
      contentProvider = (ITreeContentProvider)treeViewer.getContentProvider();
      filters = treeViewer.getFilters();
      viewer = treeViewer;

      Object object = treeViewer.getInput();
      if (object != null)
      {
        for (Object child : contentProvider.getElements(object))
        {
          if (select(object, child))
          {
            treeNodes.add(createTreeNode(treeNodeMap, child));
          }
        }
      }
    }
  }

  private TreeNode createTreeNode(Map<Object, TreeNode> treeNodes, Object object)
  {
    TreeNode treeNode = ArticleFactory.eINSTANCE.createTreeNode();
    treeNodes.put(object, treeNode);

    Object image = labelProvider.getImage(object);
    treeNode.setImage(getImageURL(image));

    String text = labelProvider.getText(object);
    treeNode.setLabel(filter(text));

    Map<String, List<TreeNodeProperty>> categories = new LinkedHashMap<String, List<TreeNodeProperty>>();
    EList<TreeNodeProperty> properties = treeNode.getProperties();
    createTreePropertyNodes(categories, properties, object);
    if (!categories.isEmpty() && (categories.size() != 1 || !categories.keySet().contains(null)))
    {
      for (Map.Entry<String, List<TreeNodeProperty>> entry : categories.entrySet())
      {
        String category = entry.getKey();
        TreeNodeProperty treeNodeProperty = ArticleFactory.eINSTANCE.createTreeNodeProperty();
        treeNodeProperty.setKey(category == null ? "Other" : category);
        treeNodeProperty.setValueImage(getImageURL(BLANK));
        treeNodeProperty.getProperties().addAll(entry.getValue());
        properties.add(treeNodeProperty);
      }
    }

    EList<TreeNode> children = treeNode.getChildren();

    if (object instanceof EObject)
    {
      EObject eObject = (EObject)object;
      Resource resource = eObject.eResource();
      if (resource != null && "user".equals(resource.getURI().scheme()))
      {
        children.add(createEllipses());
        return treeNode;
      }
    }

    for (Class prunedClass : pruned)
    {
      if (prunedClass.isInstance(object))
      {
        children.add(createEllipses());
        return treeNode;
      }
    }

    for (Object child : contentProvider.getChildren(object))
    {
      if (select(object, child))
      {
        children.add(createTreeNode(treeNodes, child));
      }
    }

    return treeNode;
  }

  private TreeNode createEllipses()
  {
    String imageURL = getImageURL(ArticlePlugin.INSTANCE.getImage("ellipses"));
    TreeNode treeNode = ArticleFactory.eINSTANCE.createTreeNode();
    treeNode.setImage(imageURL);
    treeNode.setLabel("...");
    return treeNode;
  }

  private void createTreePropertyNodes(Map<String, List<TreeNodeProperty>> categories, List<TreeNodeProperty> properties, Object object)
  {
    if (propertySheetPage != null)
    {
      IPropertySheetEntry entry = getPropertySheetEntry(propertySheetPage, object);
      createTreePropertyNodes(categories, properties, entry);
    }
    else
    {
      for (IItemPropertyDescriptor itemPropertyDescriptor : itemDelegator.getPropertyDescriptors(object))
      {
        TreeNodeProperty treeNodeProperty = ArticleFactory.eINSTANCE.createTreeNodeProperty();

        String key = itemPropertyDescriptor.getDisplayName(object);
        treeNodeProperty.setKey(filter(key));

        IItemLabelProvider labelProvider = itemPropertyDescriptor.getLabelProvider(object);
        Object propertyValue = itemPropertyDescriptor.getPropertyValue(object);
        Object propertyValueImage = labelProvider.getImage(propertyValue);
        if (propertyValueImage == null)
        {
          propertyValueImage = BLANK;
        }

        String propertyValueText;
        if (propertyValue instanceof IItemPropertySource)
        {
          IItemPropertySource itemPropertySource = (IItemPropertySource)propertyValue;
          propertyValueText = labelProvider.getText(itemPropertySource.getEditableValue(itemPropertySource));
          createTreePropertyNodes(null, treeNodeProperty.getProperties(), itemPropertySource);
        }
        else
        {
          propertyValueText = labelProvider.getText(propertyValue);
        }

        treeNodeProperty.setValueImage(getImageURL(propertyValueImage));
        treeNodeProperty.setValue(filter(propertyValueText));

        properties.add(treeNodeProperty);

        if (categories != null)
        {
          String category = itemPropertyDescriptor.getCategory(object);
          List<TreeNodeProperty> categoryProperties = categories.get(category);
          if (categoryProperties == null)
          {
            categoryProperties = new ArrayList<TreeNodeProperty>();
            categories.put(category, categoryProperties);
          }

          categoryProperties.add(treeNodeProperty);
        }
      }
    }
  }

  private void createTreePropertyNodes(Map<String, List<TreeNodeProperty>> categories, List<TreeNodeProperty> properties, IPropertySheetEntry parentEntry)
  {
    for (IPropertySheetEntry entry : parentEntry.getChildEntries())
    {
      TreeNodeProperty treeNodeProperty = ArticleFactory.eINSTANCE.createTreeNodeProperty();

      String key = entry.getDisplayName();
      treeNodeProperty.setKey(key);

      Object propertyValueImage = entry.getImage();
      if (propertyValueImage == null)
      {
        propertyValueImage = BLANK;
      }

      treeNodeProperty.setValueImage(getImageURL(propertyValueImage));

      String propertyValueText = entry.getValueAsString();
      treeNodeProperty.setValue(filter(propertyValueText));

      properties.add(treeNodeProperty);

      if (categories != null)
      {
        String category = entry.getCategory();
        List<TreeNodeProperty> categoryProperties = categories.get(category);
        if (categoryProperties == null)
        {
          categoryProperties = new ArrayList<TreeNodeProperty>();
          categories.put(category, categoryProperties);
        }

        categoryProperties.add(treeNodeProperty);
      }
    }
  }

  private boolean select(Object parent, Object child)
  {
    if (filters != null)
    {
      for (ViewerFilter filter : filters)
      {
        if (!filter.select(viewer, parent, child))
        {
          return false;
        }
      }
    }

    return true;
  }

  private URI resolve(URI baseURI, URI uri)
  {
    if (uri.isRelative())
    {
      if (uri.hasRelativePath())
      {
        return uri.resolve(baseURI);
      }

      return URI.createURI("platform:/resource" + uri);
    }

    return uri;
  }

  private String filter(String value)
  {
    if (value == null)
    {
      return value;
    }

    for (Map.Entry<String, String> entry : replacements.entrySet())
    {
      value = value.replace(entry.getKey(), entry.getValue());
    }

    return escape(value);
  }

  private String escape(String value)
  {
    return value == null ? null : DiagnosticDecorator.escapeContent(value);
  }

  private String getImageURL(Object image)
  {
    if (image == null)
    {
      return null;
    }

    String result = imageURLs.get(image);
    if (result == null)
    {
      Image swtImage = ExtendedImageRegistry.INSTANCE.getImage(image);
      ImageData imageData = swtImage.getImageData();
      ImageLoader imageLoader = new ImageLoader();
      imageLoader.data = new ImageData[] { imageData };

      try
      {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        imageLoader.save(out, SWT.IMAGE_PNG);
        out.close();

        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = out.toByteArray();
        byte[] sha = digest.digest(bytes);

        URI imageURI = imageFolder.appendSegment(XMLTypeFactory.eINSTANCE.convertBase64Binary(sha).replace('/', '_').replace('+', '-') + ".png");

        OutputStream imageOutputStream = resourceSet.getURIConverter().createOutputStream(imageURI);
        imageOutputStream.write(bytes);
        imageOutputStream.close();

        result = imageURI.deresolve(targetURI, true, true, false).toString();
        imageURLs.put(image, result);
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }

    return result;
  }

  private void capture(Control control) throws IOException
  {
    Image image = AccessUtil.captureControl(control);
    saveImage(image);
    image.dispose();
  }

  private void saveImage(Image image) throws IOException
  {
    ImageLoader imageLoader = new ImageLoader();
    imageLoader.data = new ImageData[] { image.getImageData() };
    OutputStream out = resourceSet.getURIConverter().createOutputStream(targetURI);

    int type;
    String fileExtension = targetURI.fileExtension();
    if ("jpg".equalsIgnoreCase(fileExtension) || "jpeg".equalsIgnoreCase(fileExtension))
    {
      type = SWT.IMAGE_JPEG;
    }
    else if ("ico".equalsIgnoreCase(fileExtension))
    {
      type = SWT.IMAGE_ICO;
    }
    else if ("bmp".equalsIgnoreCase(fileExtension))
    {
      type = SWT.IMAGE_BMP;
    }
    else if ("gif".equalsIgnoreCase(fileExtension))
    {
      type = SWT.IMAGE_GIF;
    }
    else if ("tiff".equalsIgnoreCase(fileExtension))
    {
      type = SWT.IMAGE_TIFF;
    }
    else
    {
      type = SWT.IMAGE_PNG;
    }

    imageLoader.save(out, type);
    out.close();
  }

  private ResourceSet createResourceSet()
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

  private void computeTargetPlatform()
  {
    IWorkspaceDescription description = workspace.getDescription();
    description.setAutoBuilding(false);

    try
    {
      workspace.setDescription(description);
      workspace.run(new IWorkspaceRunnable()
      {
        public void run(IProgressMonitor monitor) throws CoreException
        {
          Map<URI, URI> uriMap = resourceSet.getURIConverter().getURIMap();

          IPluginModelBase[] activeModels = PluginRegistry.getActiveModels(false);
          for (IPluginModelBase activeModel : activeModels)
          {
            BundleDescription bundleDescription = activeModel.getBundleDescription();
            String symbolicName = bundleDescription.getSymbolicName();
            String installLocation = activeModel.getInstallLocation();
            if (installLocation != null)
            {
              URI locationURI = createProject(installLocation);
              uriMap.put(URI.createPlatformResourceURI(symbolicName, false).appendSegment(""), locationURI);
            }
          }

          String preprocessorWorkspace = System.getProperty("preprocessor.workspace");
          if (preprocessorWorkspace != null)
          {
            for (String installLocation : preprocessorWorkspace.split(";"))
            {
              createProject(installLocation);
            }
          }
        }
      }, null);
    }
    catch (CoreException ex2)
    {
      ex2.printStackTrace();
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
      if (resourceSet.getURIConverter().exists(projectURI, null))
      {
        try
        {
          IProjectDescription projectDescription = workspace.loadProjectDescription(resourceSet.getURIConverter().createInputStream(projectURI));
          IProject project = workspaceRoot.getProject(projectDescription.getName());
          if (!project.exists())
          {
            projectDescription.setLocation(new Path(locationURI.toFileString()));
            project.create(projectDescription, null);
            project.open(null);
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

  private static IEditorInput getEditorInput(final URI uri)
  {
    if (uri.lastSegment().endsWith("aird"))
    {
      XMLMemento memento = XMLMemento.createWriteRoot("input");
      memento.putString("SESSION_RESOURCE_URI", "platform:/resource/org.eclipse.oomph.setup/model/Setup.aird");
      memento.putString("bundle", "org.eclipse.sirius.ui");
      memento.putString("class", "org.eclipse.sirius.ui.business.api.session.SessionEditorInput");
      memento.putString("factoryID", "org.eclipse.sirius.ui.business.api.session.SessionEditorInputFactory");
      memento.putString("name", "Overview"); // TODO
      memento.putString("uri", uri.trimQuery().toString());

      try
      {
        Class<?> editorInputClass = CommonPlugin.loadClass("org.eclipse.sirius.ui", "org.eclipse.sirius.ui.business.api.session.SessionEditorInput");
        Constructor<?> constructor = editorInputClass.getConstructor(IMemento.class);
        IEditorInput editorInput = (IEditorInput)constructor.newInstance(memento);
        return editorInput;
      }
      catch (Exception ex)
      {
        ex.printStackTrace();
      }
    }

    if (uri.isPlatformResource())
    {
      IFile workspaceFile = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.trimQuery().trimFragment().toPlatformString(true)));
      return new FileEditorInput(workspaceFile);

    }

    if (uri.isFile())
    {
      FileEditorInput editorInput = getFileEditorInput(uri.trimQuery().trimFragment());
      if (editorInput != null)
      {
        return editorInput;
      }
    }

    return new URIEditorInput(uri, uri.lastSegment());
  }

  private static FileEditorInput getFileEditorInput(URI uri)
  {
    if (uri.isFile())
    {
      try
      {
        IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(new java.net.URI(uri.toString()));
        for (IFile file : files)
        {
          if (file.isAccessible())
          {
            return new FileEditorInput(file);
          }
        }
      }
      catch (URISyntaxException ex)
      {
        ex.printStackTrace();
      }
    }

    return null;
  }

  private void busyWait()
  {
    if (FAMILY_MODEL_LOAD != null)
    {
      final AtomicBoolean done = new AtomicBoolean();
      new Thread()
      {
        @Override
        public void run()
        {
          // Wait for the model load jobs to complete.
          try
          {
            Job.getJobManager().join(FAMILY_MODEL_LOAD, new NullProgressMonitor());

            // Wait 2 more seconds.
            display.asyncExec(new Runnable()
            {
              public void run()
              {
                display.timerExec(2000, new Runnable()
                {
                  public void run()
                  {
                    // Ensure that the sleeping display loop wakes up.
                    done.set(true);
                  }
                });
              }
            });
          }
          catch (Exception ex)
          {
            // Ignore
          }
        }
      }.start();

      while (!display.isDisposed() && !done.get())
      {
        if (!display.readAndDispatch())
        {
          display.sleep();
        }
      }
    }
  }

  private IWorkbenchPage getWorkbenchPage()
  {
    IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
    return workbenchWindow.getActivePage();
  }

  private Control getPartControl(Control control)
  {
    if (control == null)
    {
      return null;
    }

    if (control.getData("modelElement") != null)
    {
      return getCTabFolder(control);
    }

    return getPartControl(control.getParent());
  }

  private CTabFolder getCTabFolder(Control control)
  {
    if (control == null)
    {
      return null;
    }

    if (control instanceof CTabFolder)
    {
      CTabFolder cTabFolder = (CTabFolder)control;
      return cTabFolder;
    }

    return getCTabFolder(control.getParent());
  }

  private TreeViewer getTreeViewer(Control control)
  {
    if (control != null)
    {
      ViewerColumn viewerColumn = getViewerColumn(control);
      if (viewerColumn != null)
      {
        ColumnViewer viewer = viewerColumn.getViewer();
        if (viewer instanceof TreeViewer)
        {
          return (TreeViewer)viewer;
        }
      }
    }

    return null;
  }

  private ViewerColumn getViewerColumn(Control control)
  {
    if (control instanceof Composite)
    {
      Composite composite = (Composite)control;
      for (Control child : composite.getChildren())
      {
        ViewerColumn viewerColumn = getViewerColumn(child);
        if (viewerColumn != null)
        {
          return viewerColumn;
        }
      }
    }

    ViewerColumn viewerColumn = (ViewerColumn)control.getData("org.eclipse.jface.columnViewer");
    return viewerColumn;
  }

  private static IPropertySheetEntry getPropertySheetEntry(PropertySheetPage propertySheetPage, Object object)
  {
    propertySheetPage.selectionChanged(null, new StructuredSelection(object));
    Object value = ReflectUtil.getValue(ReflectUtil.getField(propertySheetPage.getClass(), "rootEntry"), propertySheetPage);
    return (IPropertySheetEntry)value;
  }

  private String getContents(URI uri, String encoding) throws IOException
  {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(resourceSet.getURIConverter().createInputStream(uri));
    byte[] input = new byte[bufferedInputStream.available()];
    bufferedInputStream.read(input);
    bufferedInputStream.close();
    return encoding == null ? new String(input) : new String(input, encoding);
  }

  private Class<?> loadClass(String typeName)
  {
    String pluginID;
    String className;
    int index = typeName.indexOf(':');
    if (index == -1)
    {
      pluginID = bundleID;
      className = typeName;
    }
    else
    {
      pluginID = typeName.substring(0, index);
      className = typeName.substring(index + 1);
    }

    try
    {
      return CommonPlugin.loadClass(pluginID, className);
    }
    catch (ClassNotFoundException ex)
    {
      throw new ReflectUtil.ReflectionException(ex);
    }
  }
}
