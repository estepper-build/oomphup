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
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Chapter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Chapter#getArticle <em>Article</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Chapter#getSections <em>Sections</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getChapter()
 * @model
 * @generated
 */
public interface Chapter extends Body
{

  /**
   * Returns the value of the '<em><b>Article</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Article</em>' reference isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Article</em>' reference.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getChapter_Article()
   * @model resolveProxies="false" required="true" transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  Article getArticle();

  /**
   * Returns the value of the '<em><b>Sections</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.oomph.releng.doc.article.Section}.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Section#getChapter <em>Chapter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sections</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sections</em>' containment reference list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getChapter_Sections()
   * @see org.eclipse.oomph.releng.doc.article.Section#getChapter
   * @model opposite="chapter" containment="true"
   * @generated
   */
  EList<Section> getSections();

  public String getName();
} // Chapter
