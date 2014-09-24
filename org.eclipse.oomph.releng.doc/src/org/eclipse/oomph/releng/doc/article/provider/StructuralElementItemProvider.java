/**
 */
package org.eclipse.oomph.releng.doc.article.provider;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.List;

/**
 * This is the item provider adapter for a {@link org.eclipse.oomph.releng.doc.article.StructuralElement} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class StructuralElementItemProvider extends LinkTargetItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StructuralElementItemProvider(AdapterFactory adapterFactory)
  {
    super(adapterFactory);
  }

  /**
   * This returns the property descriptors for the adapted class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object)
  {
    if (itemPropertyDescriptors == null)
    {
      super.getPropertyDescriptors(object);

      addTitlePropertyDescriptor(object);
      addDocumentationPropertyDescriptor(object);
      addDocPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Title feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addTitlePropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_StructuralElement_title_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_StructuralElement_title_feature", "_UI_StructuralElement_type"),
        ArticlePackage.Literals.STRUCTURAL_ELEMENT__TITLE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
  }

  /**
   * This adds a property descriptor for the Documentation feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDocumentationPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_StructuralElement_documentation_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_StructuralElement_documentation_feature", "_UI_StructuralElement_type"),
        ArticlePackage.Literals.STRUCTURAL_ELEMENT__DOCUMENTATION, false, false, false, null, null, null));
  }

  /**
   * This adds a property descriptor for the Doc feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addDocPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_StructuralElement_doc_feature"),
        getString("_UI_PropertyDescriptor_description", "_UI_StructuralElement_doc_feature", "_UI_StructuralElement_type"),
        ArticlePackage.Literals.STRUCTURAL_ELEMENT__DOC, false, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
      childrenFeatures.add(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN);
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
   * @generated
   */
  @Override
  public String getText(Object object)
  {
    Object labelValue = ((StructuralElement)object).getId();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ? getString("_UI_StructuralElement_type") : getString("_UI_StructuralElement_type") + " " + label;
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

    switch (notification.getFeatureID(StructuralElement.class))
    {
      case ArticlePackage.STRUCTURAL_ELEMENT__TITLE:
      case ArticlePackage.STRUCTURAL_ELEMENT__DOC:
        fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
        return;
      case ArticlePackage.STRUCTURAL_ELEMENT__CHILDREN:
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

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createDocumentation()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createCategory()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createChapter()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createArticle()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createJavadoc()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createExternalArticle()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createSchemadoc()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.STRUCTURAL_ELEMENT__CHILDREN, ArticleFactory.eINSTANCE.createPluginResource()));
  }

}
