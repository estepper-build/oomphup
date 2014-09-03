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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import com.sun.javadoc.RootDoc;

import java.io.File;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Context#getBaseFolder <em>Base Folder</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Context#getProject <em>Project</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Context#getDocumentations <em>Documentations</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Context#getRoot <em>Root</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getContext()
 * @model
 * @generated
 */
public interface Context extends EObject
{
  /**
   * Returns the value of the '<em><b>Base Folder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Base Folder</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Base Folder</em>' attribute.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getContext_BaseFolder()
   * @model dataType="org.eclipse.oomph.releng.doc.article.File" required="true" changeable="false"
   * @generated
   */
  File getBaseFolder();

  /**
   * Returns the value of the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project</em>' attribute isn't clear, there really should be more of a description
   * here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project</em>' attribute.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getContext_Project()
   * @model required="true" changeable="false"
   * @generated
   */
  String getProject();

  /**
   * Returns the value of the '<em><b>Documentations</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.oomph.releng.doc.article.Documentation}.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Documentation#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Documentations</em>' containment reference list isn't clear, there really should be more
   * of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Documentations</em>' containment reference list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getContext_Documentations()
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getContext
   * @model opposite="context" containment="true" required="true"
   * @generated
   */
  EList<Documentation> getDocumentations();

  /**
   * Returns the value of the '<em><b>Root</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Root</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Root</em>' attribute.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getContext_Root()
   * @model dataType="org.eclipse.oomph.releng.doc.article.RootDoc" required="true" transient="true" changeable="false" volatile="true"
   * @generated
   */
  RootDoc getRoot();

  Documentation getDocumentation();

  Documentation getDocumentation(String id);

  boolean isRegistered(Object id);

  void register(Object id, Object value);

  Object lookup(Object id);

  String getExternalLink(String packageName);

} // Context
