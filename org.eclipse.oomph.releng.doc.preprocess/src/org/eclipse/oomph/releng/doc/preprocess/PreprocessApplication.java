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
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.ImageLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("restriction")
public class PreprocessApplication implements IApplication
{
  private static final Object BLANK = ArticlePlugin.INSTANCE.getImage("full/obj16/Blank");

  private ResourceSet resourceSet = createResourceSet();

  protected Map<Object, String> imageURLs = new HashMap<Object, String>();

  private AdapterFactoryItemDelegator itemDelegator = new AdapterFactoryItemDelegator(new ComposedAdapterFactory(
      ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

  public Object start(IApplicationContext context) throws Exception
  {
    String[] args = (String[])context.getArguments().get(IApplicationContext.APPLICATION_ARGS);
    if (args != null)
    {
      for (String arg : args)
      {
        File file = new File(arg).getCanonicalFile();
        visit(file);

        EList<Resource> resources = resourceSet.getResources();
        for (int i = 0; i < resources.size(); ++i)
        {
          Resource resource = resources.get(i);
          System.err.println("###" + resource.getURI());
          List<TreeNode> treeNodes = new ArrayList<TreeNode>();
          for (EObject eObject : resource.getContents())
          {
            treeNodes.add(createTreeNode(eObject));
          }

          // {@snippet tree <tree-file-path> ((<model-uri>)+ (categorized)? (advanced)?)?}
          // {@model ../../tree/foo.tree ../../foo.setup#/dsfasdfas categorized advanced}
          Resource result = resourceSet.getResourceFactoryRegistry().getFactory(URI.createURI("*.setup"))
              .createResource(URI.createURI("file:/D:/stuff/tmp/" + resource.getURI().trimFileExtension().lastSegment() + ".tree"));
          result.getContents().addAll(treeNodes);
          result.save(null);
        }
      }
    }

    return null;
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

        String file = XMLTypeFactory.eINSTANCE.convertBase64Binary(sha).replace('/', '_');
        String path = "D:/stuff/tmp/" + file + ".png";

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        result = "file:/" + path;
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
      if ("setup".equals(uri.fileExtension()))
      {
        resourceSet.getResource(uri, true);
      }
      if ("genmodel".equals(uri.fileExtension()))
      {
        resourceSet.getResource(uri, true);
      }
    }
  }

  public void stop()
  {
  }
}
