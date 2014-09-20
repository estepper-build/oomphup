/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.BodyElementContainer;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sun.javadoc.FieldDoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SectionImpl#getElements <em>Elements</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SectionImpl#getChapter <em>Chapter</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SectionImpl extends LinkTargetImpl implements Section
{
  /**
   * The cached value of the '{@link #getElements() <em>Elements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElements()
   * @generated
   * @ordered
   */
  protected EList<BodyElement> elements;

  private FieldDoc fieldDoc;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SectionImpl()
  {
    super();
  }

  SectionImpl(Chapter chapter, FieldDoc fieldDoc)
  {
    this.fieldDoc = fieldDoc;
    chapter.getSections().add(this);
    chapter.getDocumentation().getContext().register(getId(), this);

    EList<BodyElement> elements = getElements();
    BodyElementContainerImpl.analyzeTags(elements, fieldDoc.inlineTags(), false);

    BodyImpl.parseSeeTags(elements, fieldDoc);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.SECTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<BodyElement> getElements()
  {
    if (elements == null)
    {
      elements = new EObjectContainmentWithInverseEList<BodyElement>(BodyElement.class, this, ArticlePackage.SECTION__ELEMENTS,
          ArticlePackage.BODY_ELEMENT__CONTAINER);
    }
    return elements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Chapter getChapter()
  {
    if (eContainerFeatureID() != ArticlePackage.SECTION__CHAPTER)
    {
      return null;
    }
    return (Chapter)eInternalContainer();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetChapter(Chapter newChapter, NotificationChain msgs)
  {
    msgs = eBasicSetContainer((InternalEObject)newChapter, ArticlePackage.SECTION__CHAPTER, msgs);
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setChapter(Chapter newChapter)
  {
    if (newChapter != eInternalContainer() || eContainerFeatureID() != ArticlePackage.SECTION__CHAPTER && newChapter != null)
    {
      if (EcoreUtil.isAncestor(this, newChapter))
      {
        throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
      }
      NotificationChain msgs = null;
      if (eInternalContainer() != null)
      {
        msgs = eBasicRemoveFromContainer(msgs);
      }
      if (newChapter != null)
      {
        msgs = ((InternalEObject)newChapter).eInverseAdd(this, ArticlePackage.CHAPTER__SECTIONS, Chapter.class, msgs);
      }
      msgs = basicSetChapter(newChapter, msgs);
      if (msgs != null)
      {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.SECTION__CHAPTER, newChapter, newChapter));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArticlePackage.SECTION__ELEMENTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getElements()).basicAdd(otherEnd, msgs);
      case ArticlePackage.SECTION__CHAPTER:
        if (eInternalContainer() != null)
        {
          msgs = eBasicRemoveFromContainer(msgs);
        }
        return basicSetChapter((Chapter)otherEnd, msgs);
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
      case ArticlePackage.SECTION__ELEMENTS:
        return ((InternalEList<?>)getElements()).basicRemove(otherEnd, msgs);
      case ArticlePackage.SECTION__CHAPTER:
        return basicSetChapter(null, msgs);
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
      case ArticlePackage.SECTION__CHAPTER:
        return eInternalContainer().eInverseRemove(this, ArticlePackage.CHAPTER__SECTIONS, Chapter.class, msgs);
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
      case ArticlePackage.SECTION__ELEMENTS:
        return getElements();
      case ArticlePackage.SECTION__CHAPTER:
        return getChapter();
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
      case ArticlePackage.SECTION__ELEMENTS:
        getElements().clear();
        getElements().addAll((Collection<? extends BodyElement>)newValue);
        return;
      case ArticlePackage.SECTION__CHAPTER:
        setChapter((Chapter)newValue);
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
      case ArticlePackage.SECTION__ELEMENTS:
        getElements().clear();
        return;
      case ArticlePackage.SECTION__CHAPTER:
        setChapter((Chapter)null);
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
      case ArticlePackage.SECTION__ELEMENTS:
        return elements != null && !elements.isEmpty();
      case ArticlePackage.SECTION__CHAPTER:
        return getChapter() != null;
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass)
  {
    if (baseClass == BodyElementContainer.class)
    {
      switch (derivedFeatureID)
      {
        case ArticlePackage.SECTION__ELEMENTS:
          return ArticlePackage.BODY_ELEMENT_CONTAINER__ELEMENTS;
        default:
          return -1;
      }
    }
    return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass)
  {
    if (baseClass == BodyElementContainer.class)
    {
      switch (baseFeatureID)
      {
        case ArticlePackage.BODY_ELEMENT_CONTAINER__ELEMENTS:
          return ArticlePackage.SECTION__ELEMENTS;
        default:
          return -1;
      }
    }
    return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
  }

  @Override
  public Object getId()
  {
    return fieldDoc;
  }

  @Override
  public String getTooltip()
  {
    return "Section in " + getChapter().getDocumentation().getTitle();
  }

  @Override
  public String linkFrom(StructuralElement source)
  {
    Chapter chapter = getChapter();
    return chapter.linkFrom(source) + getAnchorSuffix();
  }

  public void generate(PrintWriter out) throws IOException
  {
    Chapter chapter = getChapter();
    out.write("<p><a name=\"" + chapter.getName() + getAnchorSuffix() + "\">");
    out.write(NL);

    EList<BodyElement> elements = getElements();
    BodyElementContainerImpl.generate(out, chapter, elements);
  }

  private String getAnchorSuffix()
  {
    return "." + fieldDoc.name();
  }

} // SectionImpl
