/**
 */
package org.eclipse.oomph.releng.doc.article.provider;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Body;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

import java.util.Collection;
import java.util.List;

/**
 * This is the item provider adapter for a {@link org.eclipse.oomph.releng.doc.article.Body} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class BodyItemProvider extends StructuralElementItemProvider
{
  /**
   * This constructs an instance from a factory and a notifier.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BodyItemProvider(AdapterFactory adapterFactory)
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

      addCategoryPropertyDescriptor(object);
    }
    return itemPropertyDescriptors;
  }

  /**
   * This adds a property descriptor for the Category feature.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void addCategoryPropertyDescriptor(Object object)
  {
    itemPropertyDescriptors.add(createItemPropertyDescriptor(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(), getResourceLocator(),
        getString("_UI_Body_category_feature"), getString("_UI_PropertyDescriptor_description", "_UI_Body_category_feature", "_UI_Body_type"),
        ArticlePackage.Literals.BODY__CATEGORY, false, false, false, null, null, null));
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
      childrenFeatures.add(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS);
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
    Object labelValue = ((Body)object).getId();
    String label = labelValue == null ? null : labelValue.toString();
    return label == null || label.length() == 0 ? getString("_UI_Body_type") : getString("_UI_Body_type") + " " + label;
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

    switch (notification.getFeatureID(Body.class))
    {
      case ArticlePackage.BODY__ELEMENTS:
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

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createDiagram()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createText()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createLink()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createEmbedding()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createToc()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createExcel()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createImage()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createKey()));

    newChildDescriptors.add(createChildParameter(ArticlePackage.Literals.BODY_ELEMENT_CONTAINER__ELEMENTS, ArticleFactory.eINSTANCE.createSelection()));
  }

}
