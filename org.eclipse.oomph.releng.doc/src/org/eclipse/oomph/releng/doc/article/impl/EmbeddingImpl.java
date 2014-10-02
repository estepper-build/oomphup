/*
 * Copyright (c) 2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Body;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.EmbeddableElement;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.util.ArticleException;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.SeeTag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Embedding</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.EmbeddingImpl#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EmbeddingImpl extends BodyElementImpl implements Embedding
{
  /**
   * The cached value of the '{@link #getElement() <em>Element</em>}' reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getElement()
   * @generated
   * @ordered
   */
  protected EmbeddableElement element;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected EmbeddingImpl()
  {
    super();
  }

  EmbeddingImpl(SeeTag seeTag, EmbeddableElement element)
  {
    super(seeTag);
    this.element = element;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.EMBEDDING;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EmbeddableElement getElement()
  {
    return element;
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
      case ArticlePackage.EMBEDDING__ELEMENT:
        return getElement();
    }
    return super.eGet(featureID, resolve, coreType);
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
      case ArticlePackage.EMBEDDING__ELEMENT:
        return element != null;
    }
    return super.eIsSet(featureID);
  }

  @Override
  public SeeTag getTag()
  {
    return (SeeTag)super.getTag();
  }

  public BodyElement copy()
  {
    return new EmbeddingImpl(getTag(), element);
  }

  public String getEmbeddingID()
  {
    String prefix = getBody().getDoc().name();
    int lastDot = prefix.lastIndexOf('.');
    if (lastDot != -1)
    {
      prefix = prefix.substring(lastDot + 1);
    }

    return prefix + "_" + getEmbeddingIndex();
  }

  public int getEmbeddingIndex()
  {
    int index = 0;

    Body body = getBody();
    for (BodyElement element : body.getElements())
    {
      if (element instanceof Embedding)
      {
        ++index;
      }

      if (element == this)
      {
        return index;
      }
    }

    if (body instanceof Chapter)
    {
      Chapter chapter = (Chapter)body;
      for (Section section : chapter.getSections())
      {
        for (BodyElement element : section.getElements())
        {
          if (element instanceof Embedding)
          {
            ++index;
          }

          if (element == this)
          {
            return index;
          }
        }
      }
    }

    throw new ArticleException("Embedding not found: " + getTag().text());
  }

  @Override
  public void addHeaders(Set<String> headers, StructuralElement linkSource)
  {
    element.addHeaders(headers, this);
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    element.generate(out, this);
  }

} // EmbeddingImpl
