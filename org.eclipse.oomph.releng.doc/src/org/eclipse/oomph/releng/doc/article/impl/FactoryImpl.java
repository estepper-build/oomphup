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
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Factory;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.MethodDoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Factory</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class FactoryImpl extends EmbeddableElementImpl implements Factory
{
  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected FactoryImpl()
  {
    super();
  }

  FactoryImpl(Documentation documentation, MethodDoc methodDoc)
  {
    super(documentation, methodDoc);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.FACTORY;
  }

  public void addHeaders(Set<String> headers, Embedding embedder)
  {
  }

  public abstract void generate(PrintWriter out, Embedding embedder) throws IOException;

} // FactoryImpl
