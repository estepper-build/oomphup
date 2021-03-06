/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Description;
import org.eclipse.oomph.releng.doc.article.Snippet;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import com.sun.javadoc.Tag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.DescriptionImpl#getSnippet <em>Snippet</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DescriptionImpl extends BodyElementContainerImpl implements Description
{
  private Tag tag;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DescriptionImpl()
  {
    super();
  }

  DescriptionImpl(Snippet snippet, Tag tag)
  {
    setSnippet(snippet);
    this.tag = tag;

    BodyElementContainerImpl.analyzeTags(getElements(), tag.inlineTags(), false);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.DESCRIPTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Snippet getSnippet()
  {
    if (eContainerFeatureID() != ArticlePackage.DESCRIPTION__SNIPPET)
    {
      return null;
    }
    return (Snippet)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSnippet(Snippet newSnippet, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newSnippet, ArticlePackage.DESCRIPTION__SNIPPET, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSnippet(Snippet newSnippet)
  {
    if (newSnippet != eInternalContainer() || eContainerFeatureID() != ArticlePackage.DESCRIPTION__SNIPPET && newSnippet != null)
    {
      if (EcoreUtil.isAncestor(this, newSnippet))
      {
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      }
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
      {
        msgs = eBasicRemoveFromContainer(msgs);
      }
      if (newSnippet != null)
      {
        msgs = ((InternalEObject)newSnippet).eInverseAdd(this, ArticlePackage.SNIPPET__DESCRIPTION, Snippet.class, msgs);
      }
      msgs = basicSetSnippet(newSnippet, msgs);
      if (msgs != null)
      {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.DESCRIPTION__SNIPPET, newSnippet, newSnippet));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArticlePackage.DESCRIPTION__SNIPPET:
        if (eInternalContainer() != null)
        {
          msgs = eBasicRemoveFromContainer(msgs);
        }
        return basicSetSnippet((Snippet)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
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
      case ArticlePackage.DESCRIPTION__SNIPPET:
        return basicSetSnippet(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs)
  {
    switch (eContainerFeatureID())
    {
      case ArticlePackage.DESCRIPTION__SNIPPET:
        return eInternalContainer().eInverseRemove(this, ArticlePackage.SNIPPET__DESCRIPTION, Snippet.class, msgs);
    }
    return super.eBasicRemoveFromContainerFeature(msgs);
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
      case ArticlePackage.DESCRIPTION__SNIPPET:
        return getSnippet();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.DESCRIPTION__SNIPPET:
        setSnippet((Snippet)newValue);
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
      case ArticlePackage.DESCRIPTION__SNIPPET:
        setSnippet((Snippet)null);
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
      case ArticlePackage.DESCRIPTION__SNIPPET:
        return getSnippet() != null;
    }
    return super.eIsSet(featureID);
  }

  public Tag getTag()
  {
    return tag;
  }
} // DescriptionImpl
