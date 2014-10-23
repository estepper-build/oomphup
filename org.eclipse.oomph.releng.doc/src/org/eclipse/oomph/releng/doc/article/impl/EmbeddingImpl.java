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
import org.eclipse.oomph.releng.doc.article.BodyElementContainer;
import org.eclipse.oomph.releng.doc.article.Callout;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.Description;
import org.eclipse.oomph.releng.doc.article.EmbeddableElement;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.util.ArticleException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
  public Body getBody()
  {
    BodyElementContainer container = getContainer();
    if (container instanceof Body)
    {
      Body body = (Body)container;
      return body;
    }

    if (container instanceof Section)
    {
      Chapter chapter = ((Section)container).getChapter();
      return chapter;
    }

    EObject eContainer = container.eContainer();
    if (eContainer instanceof EmbeddableElement)
    {
      EmbeddableElement embeddableElement = (EmbeddableElement)eContainer;
      Embedding embedding = embeddableElement.getEmbedding();
      if (embedding != null)
      {
        return embedding.getBody();
      }
    }

    return null;
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
    BodyElementContainer container = getContainer();
    if (container instanceof Body)
    {
      Body body = (Body)container;
      return getEmbeddingPrefix(body) + getEmbeddingPrefix(body);
    }

    if (container instanceof Section)
    {
      Chapter chapter = ((Section)container).getChapter();
      return getEmbeddingPrefix(chapter) + getEmbeddingPrefix(chapter);
    }

    EObject eContainer = container.eContainer();
    if (eContainer instanceof EmbeddableElement)
    {
      EmbeddableElement embeddableElement = (EmbeddableElement)eContainer;
      Embedding embedding = embeddableElement.getEmbedding();
      String prefix = embedding.getEmbeddingID();
      if (embeddableElement instanceof Snippet)
      {
        Snippet snippet = (Snippet)embeddableElement;
        int index = 0;
        Description description = snippet.getDescription();
        if (description != null)
        {
          for (BodyElement element : description.getElements())
          {
            if (element instanceof Embedding)
            {
              ++index;
            }

            if (element == this)
            {
              return prefix + "_" + index;
            }
          }
        }

        for (Callout callout : snippet.getCallouts())
        {
          for (BodyElement element : callout.getElements())
          {
            if (element instanceof Embedding)
            {
              ++index;
            }

            if (element == this)
            {
              return prefix + "_" + index;
            }
          }
        }
      }

      return prefix;
    }

    throw new ArticleException("Nested embedding");
  }

  private String getEmbeddingPrefix(Body body)
  {
    String prefix = body.getDoc().name();
    int lastDot = prefix.lastIndexOf('.');
    if (lastDot != -1)
    {
      prefix = prefix.substring(lastDot + 1);
    }

    return prefix;
  }

  private int getEmbeddingIndex(Body body)
  {
    int index = 0;
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
    if (element.getEmbedding() != null)
    {
      throw new ArticleException("Nested embedding");
    }

    element.setEmbedding(this);
    element.addHeaders(headers, this);
    element.setEmbedding(null);
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    if (element.getEmbedding() != null)
    {
      throw new ArticleException("Nested embedding");
    }

    element.setEmbedding(this);
    element.generate(out, this);
    element.setEmbedding(null);
  }

} // EmbeddingImpl
