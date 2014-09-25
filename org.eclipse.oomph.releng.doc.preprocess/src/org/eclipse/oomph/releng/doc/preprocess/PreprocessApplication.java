package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePlugin;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypeFactory;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceDescription;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("restriction")
public class PreprocessApplication
{
  // {
  private static Pattern TREE_SNIPPET_PATTERN = Pattern
      .compile(
          "@[ \t]*snippet[ \t]+tree[ \t]+([^ \t\n\r]+)[ \t]+([^\n\r]*?)([ \t]+\\(categorized|advanced|categorized[ \t]+advanced|advanced[ \t]+categorized\\))?[ \t]*[\r\n]",
          Pattern.MULTILINE);

  private static final Object BLANK = ArticlePlugin.INSTANCE.getImage("full/obj16/Blank");

  private AdapterFactoryItemDelegator itemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
      ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

  final IWorkspaceRoot workspaceRoot = EcorePlugin.getWorkspaceRoot();

  final IWorkspace workspace = workspaceRoot.getWorkspace();

  private ResourceSet resourceSet = createResourceSet();

  private Map<Object, String> imageURLs = new HashMap<Object, String>();

  private URI imageFolder;

  private URI targetURI;

  private ILabelProvider labelProvider;

  private ITreeContentProvider contentProvider;

  public PreprocessApplication()
  {
    computeTargetPlatform();
  }

  public void visitProject(File project)
  {
    imageFolder = URI.createFileURI(project.getPath()).appendSegment("images").appendSegment("trees");
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
        try
        {
          String contents = getContents(file, "UTF-8");
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
              for (URI sourceURI : sourceURIs)
              {
                if (sourceURI.isPlatformResource() && !sourceURI.isPlatformResource())
                {
                  IFile workspaceFile = workspaceRoot.getFile(new Path(sourceURI.toPlatformString(true)));
                  if (workspaceFile.exists())
                  {
                    try
                    {
                      IWorkbench workbench = PlatformUI.getWorkbench();
                      IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
                      IEditorPart editor = workbenchWindow.getActivePage().openEditor(new FileEditorInput(workspaceFile),
                          workbench.getEditorRegistry().getDefaultEditor(workspaceFile.getFullPath().toString()).getId());
                      if (editor instanceof IViewerProvider)
                      {
                        IViewerProvider viewerProvider = (IViewerProvider)editor;
                        Viewer viewer = viewerProvider.getViewer();
                        if (viewer instanceof TreeViewer)
                        {
                          TreeViewer treeViewer = (TreeViewer)viewer;
                          labelProvider = (ILabelProvider)treeViewer.getLabelProvider();
                          contentProvider = (ITreeContentProvider)treeViewer.getContentProvider();
                          Object object = viewer.getInput();
                          treeNodes.add(createTreeNode(object));
                          labelProvider = null;
                          contentProvider = null;
                        }

                        System.err.println("###" + viewer);
                      }
                    }
                    catch (PartInitException ex)
                    {
                      ex.printStackTrace();
                    }
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
                    TreeNode treeNode = createTreeNode(resource);
                    resource.setURI(resourceURI);
                    treeNodes.add(treeNode);

                    for (EObject eObject : resource.getContents())
                    {
                      treeNodes.add(createTreeNode(eObject));
                    }
                  }
                  else
                  {
                    EObject eObject = resourceSet.getEObject(sourceURI, true);
                    if (allChildren)
                    {
                      for (EObject child : eObject.eContents())
                      {
                        treeNodes.add(createTreeNode(child));
                      }
                    }
                    else
                    {
                      treeNodes.add(createTreeNode(eObject));
                    }
                  }
                }
                else
                {
                  Resource resource = resourceSet.getResource(sourceURI, true);
                  URI resourceURI = resource.getURI();
                  resource.setURI(sourceURI);
                  TreeNode treeNode = createTreeNode(resource);
                  resource.setURI(resourceURI);
                  treeNodes.add(treeNode);
                }
              }

              Resource treeResource = resourceSet.getResourceFactoryRegistry().getFactory(URI.createURI("*.setup")).createResource(targetURI);
              treeResource.getContents().addAll(treeNodes);
              treeResource.save(null);
            }
          }
        }
        catch (IOException ex)
        {
          // Ignore.
        }
      }
    }
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

  protected String getContents(File file, String encoding) throws IOException
  {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
    byte[] input = new byte[bufferedInputStream.available()];
    bufferedInputStream.read(input);
    bufferedInputStream.close();
    return encoding == null ? new String(input) : new String(input, encoding);
  }

  private TreeNode createTreeNode(Object object)
  {
    TreeNode treeNode = ArticleFactory.eINSTANCE.createTreeNode();

    Object image = labelProvider == null ? itemDelegator.getImage(object) : labelProvider.getImage(object);
    treeNode.setImage(getImageURL(image));

    String text = labelProvider == null ? itemDelegator.getText(object) : labelProvider.getText(object);
    treeNode.setLabel(text);

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

    if (!(object instanceof EObject) || !"user".equals(((EObject)object).eResource().getURI().scheme()))
    {
      EList<TreeNode> children = treeNode.getChildren();
      for (Object child : contentProvider == null ? itemDelegator.getChildren(object) : Arrays.asList(contentProvider.getChildren(object)))
      {
        children.add(createTreeNode(child));
      }
    }

    return treeNode;
  }

  private void createTreePropertyNodes(Map<String, List<TreeNodeProperty>> categories, List<TreeNodeProperty> properties, Object object)
  {
    for (IItemPropertyDescriptor itemPropertyDescriptor : itemDelegator.getPropertyDescriptors(object))
    {
      TreeNodeProperty treeNodeProperty = ArticleFactory.eINSTANCE.createTreeNodeProperty();

      String key = itemPropertyDescriptor.getDisplayName(object);
      treeNodeProperty.setKey(key);

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
      treeNodeProperty.setValue(propertyValueText);

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

          // Determine the symbolic name, underlying resource, if any, and the install location.
          for (IPluginModelBase activeModel : activeModels)
          {
            BundleDescription bundleDescription = activeModel.getBundleDescription();
            String symbolicName = bundleDescription.getSymbolicName();
            String installLocation = activeModel.getInstallLocation();
            if (installLocation != null)
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

              uriMap.put(URI.createPlatformResourceURI(symbolicName, false).appendSegment(""), locationURI);
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

  public static class CaptureWidgetImageGC
  {
    public static void main(String[] args)
    {
      final Display display = new Display();
      final Shell shell = new Shell(display);
      shell.setText("Widget");

      final Table table = new Table(shell, SWT.MULTI);
      table.setLinesVisible(true);
      table.setBounds(10, 10, 100, 100);
      for (int i = 0; i < 9; i++)
      {
        new TableItem(table, SWT.NONE).setText("item" + i);
      }

      Button button = new Button(shell, SWT.PUSH);
      button.setText("Capture");
      button.pack();
      button.setLocation(10, 140);
      button.addListener(SWT.Selection, new Listener()
      {
        public void handleEvent(Event event)
        {
          Point tableSize = table.getSize();
          GC gc = new GC(table);
          final Image image = new Image(display, tableSize.x, tableSize.y);
          gc.copyArea(image, 0, 0);
          gc.dispose();

          Shell popup = new Shell(shell);
          popup.setText("Image");
          popup.addListener(SWT.Close, new Listener()
          {
            public void handleEvent(Event e)
            {
              image.dispose();
            }
          });

          Canvas canvas = new Canvas(popup, SWT.NONE);
          canvas.setBounds(10, 10, tableSize.x + 10, tableSize.y + 10);
          canvas.addPaintListener(new PaintListener()
          {
            public void paintControl(PaintEvent e)
            {
              e.gc.drawImage(image, 0, 0);
            }
          });
          popup.pack();
          popup.open();
        }
      });
      shell.pack();
      shell.open();
      while (!shell.isDisposed())
      {
        if (!display.readAndDispatch())
        {
          display.sleep();
        }
      }
      display.dispose();
    }
  }

}
