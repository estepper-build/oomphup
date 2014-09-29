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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.JavaPackage;
import org.eclipse.oomph.releng.doc.article.Javadoc;
import org.eclipse.oomph.releng.doc.article.Plugin;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl.TocWriter;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import com.sun.javadoc.PackageDoc;

import java.io.File;
import java.io.IOException;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Javadoc</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class JavadocImpl extends CategoryImpl implements Javadoc
{
  private static final String OVERVIEW_SUMMARY = "javadoc/overview-summary.html";

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected JavadocImpl()
  {
    super();
  }

  JavadocImpl(StructuralElement parent, PackageDoc packageDoc)
  {
    super(parent, packageDoc);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.JAVADOC;
  }

  @Override
  public void generate() throws IOException
  {
    // Do nothing
  }

  @Override
  public String linkFrom(StructuralElement source)
  {
    File sourceFile = source.getOutputFile();
    File targetFile = new File(getDocumentation().getProjectFolder(), OVERVIEW_SUMMARY);
    return ArticleUtil.createLink(sourceFile, targetFile);
  }

  @Override
  protected void generateTocEntry(TocWriter writer) throws IOException
  {
    writer.writeGroupStart(getTitle(), OVERVIEW_SUMMARY, null);

    for (Plugin plugin : getDocumentation().getPlugins())
    {
      EList<JavaPackage> packages = plugin.getPackages();
      if (!packages.isEmpty())
      {
        String href = getHref(packages.get(0));
        writer.writeGroupStart(plugin.getLabel(), href, "plugin");

        for (JavaPackage javaPackage : packages)
        {
          href = getHref(javaPackage);
          writer.writeSingle(javaPackage.getName(), href, "package");
        }

        writer.writeGroupEnd();
      }
    }

    writer.writeGroupEnd();
  }

  private String getHref(JavaPackage javaPackage)
  {
    return "javadoc/" + javaPackage.getName().replace('.', '/') + "/package-summary.html";
  }
} // JavadocImpl
