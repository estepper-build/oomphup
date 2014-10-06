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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Extension Point</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getPlugin <em>Plugin</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getExtensionPoint()
 * @model
 * @generated
 */
public interface ExtensionPoint extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getExtensionPoint_Name()
   * @model required="true"
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Plugin</b></em>' container reference. It is bidirectional and its opposite is '
   * {@link org.eclipse.oomph.releng.doc.article.Plugin#getExtensionPoints <em>Extension Points</em>}'. <!--
   * begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Plugin</em>' container reference isn't clear, there really should be more of a
   * description here...
   * </p>
   * <!-- end-user-doc -->
   *
   * @return the value of the '<em>Plugin</em>' container reference.
   * @see #setPlugin(Plugin)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getExtensionPoint_Plugin()
   * @see org.eclipse.oomph.releng.doc.article.Plugin#getExtensionPoints
   * @model opposite="extensionPoints" required="true" transient="false"
   * @generated
   */
  Plugin getPlugin();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getPlugin <em>Plugin</em>}' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param value the new value of the '<em>Plugin</em>' container reference.
   * @see #getPlugin()
   * @generated
   */
  void setPlugin(Plugin value);

} // ExtensionPoint
