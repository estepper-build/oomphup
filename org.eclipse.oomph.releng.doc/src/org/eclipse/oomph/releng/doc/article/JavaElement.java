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

import java.io.File;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Java Element</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.JavaElement#getClassFile <em>Class File</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.JavaElement#getMember <em>Member</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getJavaElement()
 * @model
 * @generated
 */
public interface JavaElement extends LinkTarget
{

  /**
   * Returns the value of the '<em><b>Class File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Class File</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Class File</em>' attribute.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getJavaElement_ClassFile()
   * @model dataType="org.eclipse.oomph.releng.doc.article.File" changeable="false"
   * @generated
   */
  File getClassFile();

  /**
   * Returns the value of the '<em><b>Member</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Member</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Member</em>' attribute.
   * @see #setMember(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getJavaElement_Member()
   * @model
   * @generated
   */
  String getMember();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.JavaElement#getMember <em>Member</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Member</em>' attribute.
   * @see #getMember()
   * @generated
   */
  void setMember(String value);
} // JavaElement
