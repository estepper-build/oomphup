/*
 * Copyright (c) 2011, 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.Article;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl.TocWriter;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.FieldDoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Chapter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.ChapterImpl#getArticle <em>Article</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.ChapterImpl#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ChapterImpl extends BodyImpl implements Chapter
{
  /**
   * The cached value of the '{@link #getSections() <em>Sections</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSections()
   * @generated
   * @ordered
   */
  protected EList<Section> sections;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ChapterImpl()
  {
    super();
  }

  ChapterImpl(StructuralElement parent, ClassDoc classDoc)
  {
    super(parent, makePath(classDoc), classDoc);
    ((ArticleImpl)getArticle()).registerChapter(this);
    createSections(classDoc.fields());
  }

  private static String makePath(ClassDoc classDoc)
  {
    return classDoc.simpleTypeName() + (classDoc.containingClass() == null ? ".html" : "");
  }

  private void createSections(FieldDoc[] fieldDocs)
  {
    EList<Section> sections = getSections();
    for (FieldDoc fieldDoc : fieldDocs)
    {
      Section section = new SectionImpl(this, fieldDoc);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.CHAPTER;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public Article getArticle()
  {
    if (this instanceof Article)
    {
      return (Article)this;
    }

    return ((Chapter)getParent()).getArticle();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Section> getSections()
  {
    if (sections == null)
    {
      sections = new EObjectContainmentWithInverseEList<Section>(Section.class, this, ArticlePackage.CHAPTER__SECTIONS, ArticlePackage.SECTION__CHAPTER);
    }
    return sections;
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
      case ArticlePackage.CHAPTER__SECTIONS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getSections()).basicAdd(otherEnd, msgs);
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
      case ArticlePackage.CHAPTER__SECTIONS:
        return ((InternalEList<?>)getSections()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.CHAPTER__ARTICLE:
        return getArticle();
      case ArticlePackage.CHAPTER__SECTIONS:
        return getSections();
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
      case ArticlePackage.CHAPTER__SECTIONS:
        getSections().clear();
        getSections().addAll((Collection<? extends Section>)newValue);
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
      case ArticlePackage.CHAPTER__SECTIONS:
        getSections().clear();
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.CHAPTER__ARTICLE:
        return getArticle() != null;
      case ArticlePackage.CHAPTER__SECTIONS:
        return sections != null && !sections.isEmpty();
    }
    return super.eIsSet(featureID);
  }

  @Override
  public ClassDoc getDoc()
  {
    return (ClassDoc)super.getDoc();
  }

  @Override
  protected String getKind()
  {
    return "Chapter";
  }

  @Override
  protected String createFullPath()
  {
    if (this instanceof Article)
    {
      return super.createFullPath();
    }

    return getArticle().getFullPath() + "#" + getName();
  }

  @Override
  protected void generateTocEntry(TocWriter writer) throws IOException
  {
    if (this instanceof Article)
    {
      super.generateTocEntry(writer);
    }
  }

  @Override
  public void generate(PrintWriter out) throws IOException
  {
    if (this instanceof Article)
    {
      generateHeader(out);
      super.generate(out);
      generateFooter(out);
    }
    else
    {
      String anchor = "<a name=\"" + getName() + "\"></a>";

      int level = getChapterNumbers().length + 1;
      out.write("<h" + level + ">");
      out.write(anchor + getTitleWithNumber());
      out.write("</h" + level + ">" + NL);

      super.generate(out);
    }
  }

  @Override
  protected void generateSections(PrintWriter out) throws IOException
  {
    for (Section section : getSections())
    {
      section.generate(out);
    }
  }

  public String getName()
  {
    return getDoc().simpleTypeName();
  }

  public String getTitleWithNumber()
  {
    return getChapterNumber() + "&nbsp;&nbsp;" + getTitle();
  }

  public String getChapterNumber()
  {
    int[] chapterNumber = getChapterNumbers();

    StringBuilder builder = new StringBuilder();
    for (int number : chapterNumber)
    {
      if (builder.length() != 0)
      {
        builder.append(".");
      }

      builder.append(number);
    }

    return builder.toString();
  }

  public int[] getChapterNumbers()
  {
    List<Integer> levelNumbers = new ArrayList<Integer>();
    getLevelNumbers(this, levelNumbers);

    int[] result = new int[levelNumbers.size()];
    for (int i = 0; i < result.length; i++)
    {
      result[i] = levelNumbers.get(i);

    }

    return result;
  }

  private static void getLevelNumbers(ChapterImpl chapter, List<Integer> levelNumbers)
  {
    StructuralElement parent = chapter.getParent();
    if (!(parent instanceof Article))
    {
      getLevelNumbers((ChapterImpl)parent, levelNumbers);
    }

    int number = parent.getSortedChildren().indexOf(chapter) + 1;
    levelNumbers.add(number);
  }
} // ChapterImpl
