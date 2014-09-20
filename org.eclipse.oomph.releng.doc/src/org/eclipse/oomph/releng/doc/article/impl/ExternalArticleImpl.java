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

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.ExternalArticle;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl.TocWriter;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.ClassDoc;

import java.io.IOException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>External Article</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.oomph.releng.doc.article.impl.ExternalArticleImpl#getUrl <em>Url</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalArticleImpl extends ArticleImpl implements ExternalArticle
{
  /**
   * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected static final String URL_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getUrl() <em>Url</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getUrl()
   * @generated
   * @ordered
   */
  protected String url = URL_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected ExternalArticleImpl()
  {
    super();
  }

  ExternalArticleImpl(StructuralElement parent, ClassDoc classDoc, String url)
  {
    super(parent, classDoc);
    this.url = url;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.EXTERNAL_ARTICLE;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String getUrl()
  {
    return url;
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
      case ArticlePackage.EXTERNAL_ARTICLE__URL:
        return getUrl();
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
      case ArticlePackage.EXTERNAL_ARTICLE__URL:
        return URL_EDEFAULT == null ? url != null : !URL_EDEFAULT.equals(url);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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
    result.append(" (url: ");
    result.append(url);
    result.append(')');
    return result.toString();
  }

  @Override
  public void generate() throws IOException
  {
    // Do nothing
  }

  @Override
  public String linkFrom(StructuralElement source)
  {
    return url;
  }

  @Override
  protected void generateTocEntry(TocWriter writer) throws IOException
  {
    writer.writeSingle(getTitle(), url, "external");
  }
} // ExternalArticleImpl
