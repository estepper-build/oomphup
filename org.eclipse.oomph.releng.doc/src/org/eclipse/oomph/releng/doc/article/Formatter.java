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
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.ecore.EObject;

import com.sun.javadoc.Doc;
import com.sun.javadoc.SeeTag;

import java.io.PrintWriter;
import java.util.Set;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Formatter</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Formatter#getSnippet <em>Snippet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getFormatter()
 * @model abstract="true"
 * @generated
 */
public interface Formatter extends EObject
{

  /**
   * Returns the value of the '<em><b>Snippet</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Snippet#getFormatter <em>Formatter</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Snippet</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Snippet</em>' container reference.
   * @see #setSnippet(Snippet)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getFormatter_Snippet()
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getFormatter
   * @model opposite="formatter" required="true" transient="false"
   * @generated
   */
  Snippet getSnippet();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Formatter#getSnippet <em>Snippet</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Snippet</em>' container reference.
   * @see #getSnippet()
   * @generated
   */
  void setSnippet(Snippet value);

  Doc getDoc();

  void addHeaders(Set<String> headers, Embedding embedder, Snippet snippet);

  String getDefaultTitle(SeeTag embedderTag);

  String getTopLeftEditorIcon(String imagePath);

  String getSnippetHtml(PrintWriter out, Embedding embedder, String id, String title);

  String getCalloutMarker();

} // Formatter
