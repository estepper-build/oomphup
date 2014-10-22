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
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Snippet</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Snippet#getCallouts <em>Callouts</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Snippet#getFormatter <em>Formatter</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitleImage <em>Title Image</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Snippet#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet()
 * @model
 * @generated
 */
public interface Snippet extends EmbeddableElement
{
  /**
   * Returns the value of the '<em><b>Callouts</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.oomph.releng.doc.article.Callout}.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Callout#getSnippet <em>Snippet</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Callouts</em>' containment reference list isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Callouts</em>' containment reference list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet_Callouts()
   * @see org.eclipse.oomph.releng.doc.article.Callout#getSnippet
   * @model opposite="snippet" containment="true"
   * @generated
   */
  EList<Callout> getCallouts();

  /**
   * Returns the value of the '<em><b>Formatter</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Formatter#getSnippet <em>Snippet</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Formatter</em>' containment reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Formatter</em>' containment reference.
   * @see #setFormatter(Formatter)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet_Formatter()
   * @see org.eclipse.oomph.releng.doc.article.Formatter#getSnippet
   * @model opposite="snippet" containment="true" required="true"
   * @generated
   */
  Formatter getFormatter();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Snippet#getFormatter <em>Formatter</em>}' containment reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Formatter</em>' containment reference.
   * @see #getFormatter()
   * @generated
   */
  void setFormatter(Formatter value);

  /**
   * Returns the value of the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title</em>' attribute.
   * @see #setTitle(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet_Title()
   * @model
   * @generated
   */
  String getTitle();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitle <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title</em>' attribute.
   * @see #getTitle()
   * @generated
   */
  void setTitle(String value);

  /**
   * Returns the value of the '<em><b>Title Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Title Image</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Title Image</em>' attribute.
   * @see #setTitleImage(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet_TitleImage()
   * @model
   * @generated
   */
  String getTitleImage();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitleImage <em>Title Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Title Image</em>' attribute.
   * @see #getTitleImage()
   * @generated
   */
  void setTitleImage(String value);

  /**
   * Returns the value of the '<em><b>Description</b></em>' containment reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Description#getSnippet <em>Snippet</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Description</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Description</em>' containment reference.
   * @see #setDescription(Description)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSnippet_Description()
   * @see org.eclipse.oomph.releng.doc.article.Description#getSnippet
   * @model opposite="snippet" containment="true"
   * @generated
   */
  Description getDescription();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Snippet#getDescription <em>Description</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Description</em>' containment reference.
   * @see #getDescription()
   * @generated
   */
  void setDescription(Description value);

} // Snippet
