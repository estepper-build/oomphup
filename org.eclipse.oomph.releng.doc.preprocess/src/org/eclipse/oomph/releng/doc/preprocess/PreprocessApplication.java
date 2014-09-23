package org.eclipse.oomph.releng.doc.preprocess;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
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
import java.util.List;
import java.util.Map;

@SuppressWarnings("restriction")
public class PreprocessApplication implements IApplication
{
  private ResourceSet resourceSet = createResourceSet();

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

          // {@model ../../tree/foo.tree ../../foo.setup}
          Resource result = resourceSet.getResourceFactoryRegistry().getFactory(URI.createURI("*.setup")).createResource(URI.createURI("*.setup"));
          result.getContents().addAll(treeNodes);
          result.save(System.err, null);
        }
      }
    }

    return null;
  }

  private TreeNode createTreeNode(Object object)
  {
    TreeNode treeNode = ArticleFactory.eINSTANCE.createTreeNode();

    Object image = itemDelegator.getImage(object);
    String text = itemDelegator.getText(object);

    treeNode.setImage(getImageURL(image));
    treeNode.setLabel(text);

    EList<TreeNodeProperty> properties = treeNode.getProperties();
    for (IItemPropertyDescriptor itemPropertyDescriptor : itemDelegator.getPropertyDescriptors(object))
    {
      TreeNodeProperty treeNodeProperty = ArticleFactory.eINSTANCE.createTreeNodeProperty();

      String key = itemPropertyDescriptor.getDisplayName(object);
      treeNodeProperty.setKey(key);

      Object propertyValue = itemPropertyDescriptor.getPropertyValue(object);
      IItemLabelProvider labelProvider = itemPropertyDescriptor.getLabelProvider(object);
      Object propertyValueImage = labelProvider.getImage(propertyValue);
      String propertyValueText = labelProvider.getText(propertyValue);

      treeNodeProperty.setValue(getImageURL(propertyValueImage));
      treeNodeProperty.setValue(propertyValueText);

      properties.add(treeNodeProperty);
    }

    EList<TreeNode> children = treeNode.getChildren();
    for (Object child : itemDelegator.getChildren(object))
    {
      children.add(createTreeNode(child));
    }

    return treeNode;
  }

  int counter = 0;

  Map<Object, String> imageURLs = new HashMap<Object, String>();

  private String getImageURL(Object image)
  {
    if (image == null)
    {
      return null;
    }

    String result = imageURLs.get(image);
    if (result == null)
    {
      Image image2 = ExtendedImageRegistry.INSTANCE.getImage(image);
      ImageData imageData = image2.getImageData();
      ImageLoader imageLoader = new ImageLoader();
      imageLoader.data = new ImageData[] { imageData };

      ByteArrayOutputStream out = new ByteArrayOutputStream();
      imageLoader.save(out, SWT.IMAGE_PNG);

      try
      {
        out.close();
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = out.toByteArray();
        byte[] digest2 = digest.digest(bytes);
        String file = XMLTypeFactory.eINSTANCE.convertBase64Binary(digest2).replace('/', '_');
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
    }
  }

  public void stop()
  {
  }
}
