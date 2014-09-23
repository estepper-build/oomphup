/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Node Property</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl#getKeyImage <em>Key Image</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl#getValueImage <em>Value Image</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeNodePropertyImpl extends EObjectImpl implements TreeNodeProperty
{
  /**
   * The default value of the '{@link #getKeyImage() <em>Key Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyImage()
   * @generated
   * @ordered
   */
  protected static final String KEY_IMAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKeyImage() <em>Key Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKeyImage()
   * @generated
   * @ordered
   */
  protected String keyImage = KEY_IMAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected static final String KEY_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getKey() <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKey()
   * @generated
   * @ordered
   */
  protected String key = KEY_EDEFAULT;

  /**
   * The default value of the '{@link #getValueImage() <em>Value Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueImage()
   * @generated
   * @ordered
   */
  protected static final String VALUE_IMAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValueImage() <em>Value Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValueImage()
   * @generated
   * @ordered
   */
  protected String valueImage = VALUE_IMAGE_EDEFAULT;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProperties()
   * @generated
   * @ordered
   */
  protected EList<TreeNodeProperty> properties;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeNodePropertyImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.TREE_NODE_PROPERTY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKeyImage()
  {
    return keyImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKeyImage(String newKeyImage)
  {
    String oldKeyImage = keyImage;
    keyImage = newKeyImage;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_NODE_PROPERTY__KEY_IMAGE, oldKeyImage, keyImage));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getKey()
  {
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKey(String newKey)
  {
    String oldKey = key;
    key = newKey;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_NODE_PROPERTY__KEY, oldKey, key));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValueImage()
  {
    return valueImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValueImage(String newValueImage)
  {
    String oldValueImage = valueImage;
    valueImage = newValueImage;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_NODE_PROPERTY__VALUE_IMAGE, oldValueImage, valueImage));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_NODE_PROPERTY__VALUE, oldValue, value));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TreeNodeProperty> getProperties()
  {
    if (properties == null)
    {
      properties = new EObjectContainmentEList<TreeNodeProperty>(TreeNodeProperty.class, this, ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES);
    }
    return properties;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES:
        return ((InternalEList<?>)getProperties()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_NODE_PROPERTY__KEY_IMAGE:
        return getKeyImage();
      case ArticlePackage.TREE_NODE_PROPERTY__KEY:
        return getKey();
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE_IMAGE:
        return getValueImage();
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE:
        return getValue();
      case ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES:
        return getProperties();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_NODE_PROPERTY__KEY_IMAGE:
        setKeyImage((String)newValue);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__KEY:
        setKey((String)newValue);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE_IMAGE:
        setValueImage((String)newValue);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE:
        setValue((String)newValue);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES:
        getProperties().clear();
        getProperties().addAll((Collection<? extends TreeNodeProperty>)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_NODE_PROPERTY__KEY_IMAGE:
        setKeyImage(KEY_IMAGE_EDEFAULT);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__KEY:
        setKey(KEY_EDEFAULT);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE_IMAGE:
        setValueImage(VALUE_IMAGE_EDEFAULT);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES:
        getProperties().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_NODE_PROPERTY__KEY_IMAGE:
        return KEY_IMAGE_EDEFAULT == null ? keyImage != null : !KEY_IMAGE_EDEFAULT.equals(keyImage);
      case ArticlePackage.TREE_NODE_PROPERTY__KEY:
        return KEY_EDEFAULT == null ? key != null : !KEY_EDEFAULT.equals(key);
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE_IMAGE:
        return VALUE_IMAGE_EDEFAULT == null ? valueImage != null : !VALUE_IMAGE_EDEFAULT.equals(valueImage);
      case ArticlePackage.TREE_NODE_PROPERTY__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
      case ArticlePackage.TREE_NODE_PROPERTY__PROPERTIES:
        return properties != null && !properties.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy())
    {
      return super.toString();
    }

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (keyImage: ");
    result.append(keyImage);
    result.append(", key: ");
    result.append(key);
    result.append(", valueImage: ");
    result.append(valueImage);
    result.append(", value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} // TreeNodePropertyImpl
