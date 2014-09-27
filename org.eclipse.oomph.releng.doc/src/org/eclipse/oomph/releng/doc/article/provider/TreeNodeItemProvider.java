/**
 */
package org.eclipse.oomph.releng.doc.article.provider;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.ArticlePlugin;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This is the item provider adapter for a {@link org.eclipse.oomph.releng.doc.article.TreeNode} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class TreeNodeItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
    IItemLabelProvider, IItemPropertySource
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeNodeItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    TreeNode treeNode = (TreeNode)object;
    List<IItemPropertyDescriptor> result = new ArrayList<IItemPropertyDescriptor>();

    itemPropertyDescriptors = new ArrayList<IItemPropertyDescriptor>();
    addXmi_IDPropertyDescriptor(object);
    result.addAll(itemPropertyDescriptors);
    itemPropertyDescriptors = null;

    for (final TreeNodeProperty treeNodeProperty : treeNode.getProperties())
    {
      result.add(new TreeNodePropertyDescriptor(adapterFactory, treeNodeProperty));
    }

    return result;
  }

  /**
   * This adds a property descriptor for the Xmi ID feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addXmi_IDPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TreeNode_xmi_ID_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TreeNode_xmi_ID_feature", "_UI_TreeNode_type"),
        ArticlePackage.Literals.TREE_NODE__XMI_ID, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
        new String[] { "org.eclipse.ui.views.properties.expert" }));
  }

  /**
   * This adds a property descriptor for the Image feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addImagePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TreeNode_image_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TreeNode_image_feature", "_UI_TreeNode_type"),
        ArticlePackage.Literals.TREE_NODE__IMAGE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Label feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addLabelPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_TreeNode_label_feature"), getString("_UI_PropertyDescriptor_description", "_UI_TreeNode_label_feature", "_UI_TreeNode_type"),
        ArticlePackage.Literals.TREE_NODE__LABEL, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
   * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
   * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object)
  {
    if (childrenFeatures == null)
    {
      super.getChildrenFeatures(object);
      childrenFeatures.add(ArticlePackage.Literals.TREE_NODE__CHILDREN);
    }
    return childrenFeatures;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EStructuralFeature getChildFeature(Object object, Object child)
  {
    // Check the type of the specified child object and return the proper feature to use for
    // adding (see {@link AddCommand}) it as a child.

    return super.getChildFeature(object, child);
  }

  /**
   * This returns TreeNode.gif.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public Object getImage(Object object)
  {
    TreeNode treeNode = (TreeNode)object;
    String image = treeNode.getImage();
    return overlayImage(object, image != null ? getImageURI(treeNode, URI.createURI(image)) : getResourceLocator().getImage("full/obj16/TreeNode"));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected boolean shouldComposeCreationImage()
  {
    return true;
  }

  /**
   * This returns the label text for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated NOT
   */
  @Override
  public String getText(Object object)
  {
    TreeNode treeNode = (TreeNode)object;
    String label = treeNode.getLabel();
    return label == null ? "" : label;
  }

  /**
   * This handles model notifications by calling {@link #updateChildren} to update any cached
   * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void notifyChanged(Notification notification)
  {
    updateChildren(notification);

    switch (notification.getFeatureID(TreeNode.class))
    {
      case ArticlePackage.TREE_NODE__XMI_ID:
      case ArticlePackage.TREE_NODE__IMAGE:
      case ArticlePackage.TREE_NODE__LABEL:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ArticlePackage.TREE_NODE__CHILDREN:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
        return;
    }
    super.notifyChanged(notification);
  }

  /**
   * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
   * that can be created under this object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object)
  {
    super.collectNewChildDescriptors(newChildDescriptors, object);

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.TREE_NODE__CHILDREN, ArticleFactory.eINSTANCE.createTreeNode()));
  }

  /**
   * Return the resource locator for this item provider's resources.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public ResourceLocator getResourceLocator()
  {
    return ArticlePlugin.INSTANCE;
  }

  public static class TreeNodePropertyDescriptor implements IItemPropertyDescriptor
  {
    private TreeNodeProperty treeNodeProperty;

    private AdapterFactory adapterFactory;

    public TreeNodePropertyDescriptor(AdapterFactory adapterFactory, TreeNodeProperty treeNodeProperty)
    {
      this.adapterFactory = adapterFactory;
      this.treeNodeProperty = treeNodeProperty;
    }

    public void setPropertyValue(Object object, Object value)
    {
    }

    public void resetPropertyValue(Object object)
    {
    }

    public boolean isSortChoices(Object object)
    {
      return false;
    }

    public boolean isPropertySet(Object object)
    {
      return false;
    }

    public boolean isMultiLine(Object object)
    {
      return false;
    }

    public boolean isMany(Object object)
    {
      return false;
    }

    public boolean isCompatibleWith(Object object, Object anotherObject, IItemPropertyDescriptor anotherPropertyDescriptor)
    {
      return false;
    }

    public Object getPropertyValue(Object object)
    {
      return new ItemPropertyDescriptor.PropertyValueWrapper(adapterFactory, object, treeNodeProperty.getValue(), treeNodeProperty);
    }

    public IItemLabelProvider getLabelProvider(Object object)
    {
      return new IItemLabelProvider()
      {
        public String getText(Object object)
        {
          return treeNodeProperty.getValue();
        }

        public Object getImage(Object object)
        {
          String valueImage = treeNodeProperty.getValueImage();
          return valueImage == null ? null : getImageURI(treeNodeProperty, URI.createURI(valueImage));
        }
      };
    }

    public String getId(Object object)
    {
      return treeNodeProperty.getKey();
    }

    public Object getHelpContextIds(Object object)
    {
      return null;
    }

    public String[] getFilterFlags(Object object)
    {
      return null;
    }

    public Object getFeature(Object object)
    {
      return treeNodeProperty.getKey();
    }

    public String getDisplayName(Object object)
    {
      return treeNodeProperty.getKey();
    }

    public String getDescription(Object object)
    {
      return null;
    }

    public Collection<?> getChoiceOfValues(Object object)
    {
      return null;
    }

    public String getCategory(Object object)
    {
      return null;
    }

    public boolean canSetProperty(Object object)
    {
      return false;
    }
  }

  public static URI getImageURI(EObject eObject, URI uri)
  {
    if (uri.isRelative())
    {
      Resource resource = eObject.eResource();
      if (resource != null)
      {
        if (uri.hasRelativePath())
        {
          URI baseURI = resource.getURI();
          return uri.resolve(baseURI);
        }

        ResourceSet resourceSet = resource.getResourceSet();
        if (resourceSet != null)
        {
          return resourceSet.getURIConverter().normalize(uri);
        }
      }
    }

    return uri;
  }
}
