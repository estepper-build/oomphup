package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePlugin;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.osgi.service.resolver.BundleDescription;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("restriction")
public class PreprocessApplication implements IApplication
{
  // {
  private static Pattern TREE_SNIPPET_PATTERN = Pattern.compile(
      "\\{\\s*@\\s*snippet\\s+tree\\s+([^\\s]+)\\s+([^}]*?)(\\s+\\(categorized|advanced|categorized\\s+advanced|advanced\\s+categorized\\))?\\s*\\}",
      Pattern.MULTILINE);

  private static final Object BLANK = ArticlePlugin.INSTANCE.getImage("full/obj16/Blank");

  private AdapterFactoryItemDelegator itemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
      ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

  private ResourceSet resourceSet = createResourceSet();

  private Map<Object, String> imageURLs = new HashMap<Object, String>();

  private URI imageFolder;

  private URI targetURI;

  public PreprocessApplication()
  {
    computeTargetPlatform();
  }

  public Object start(final IApplicationContext context) throws Exception
  {
    final Display display = PlatformUI.createDisplay();

    display.asyncExec(new Runnable()
    {
      public void run()
      {
        final IWorkbench workbench = PlatformUI.getWorkbench();
        if (workbench.getWorkbenchWindowCount() == 0)
        {
          display.timerExec(1000, this);
        }
        else
        {
          for (IWorkbenchWindow window : workbench.getWorkbenchWindows())
          {
            window.getShell().setMinimized(true);
          }

          String[] args = (String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
          if (args != null)
          {
            for (String arg : args)
            {
              File file;
              try
              {
                file = new File(arg).getCanonicalFile();
                imageFolder = URI.createFileURI(file.getPath()).appendSegment("images").appendSegment("trees");
                visit(file);
              }
              catch (IOException ex)
              {
                ex.printStackTrace();
              }
            }

          }

          System.exit(0);
        }
      }
    });

    PlatformUI.createAndRunWorkbench(display, new WorkbenchAdvisor()
    {
      @Override
      public String getInitialWindowPerspectiveId()
      {
        return null;
      }
    });

    return null;
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

    Object image = itemDelegator.getImage(object);
    treeNode.setImage(getImageURL(image));

    String text = itemDelegator.getText(object);
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

    EList<TreeNode> children = treeNode.getChildren();
    for (Object child : itemDelegator.getChildren(object))
    {
      children.add(createTreeNode(child));
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
          locationURI = locationURI.appendSegment("");
        }

        uriMap.put(URI.createPlatformResourceURI(symbolicName, false).appendSegment(""), locationURI);
      }
    }
  }

  public void stop()
  {
  }
}
