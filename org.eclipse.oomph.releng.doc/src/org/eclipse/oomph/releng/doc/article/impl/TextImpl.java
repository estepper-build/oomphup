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
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.Text;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.Tag;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Text</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class TextImpl extends BodyElementImpl implements Text
{
  private static final Pattern IMG_PATTERN = Pattern.compile("(<img[^>]+src\\s*=\\s*)('[^']+'|\"[^\"]+\")");

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected TextImpl()
  {
    super();
  }

  TextImpl(Tag tag)
  {
    super(tag);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.TEXT;
  }

  public BodyElement copy()
  {
    return new TextImpl(getTag());
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    String text = getTag().text();
    Matcher matcher = IMG_PATTERN.matcher(text);

    boolean rewritten = false;
    StringBuffer buffer = new StringBuffer();
    while (matcher.find())
    {
      String group2 = matcher.group(2);
      String src = group2.substring(1, group2.length() - 1);

      if (src.startsWith("/"))
      {
        String group1 = matcher.group(1);
        String quote = group2.substring(0, 1);
        String link = copyImage(src, linkSource);

        matcher.appendReplacement(buffer, group1 + quote + link + quote);
        rewritten = true;
      }
      else
      {
        matcher.appendReplacement(buffer, matcher.group());
      }
    }

    if (rewritten)
    {
      matcher.appendTail(buffer);
      text = buffer.toString();
    }

    out.write(text);
  }

  private static String copyImage(String src, StructuralElement linkSource)
  {
    String path = src.substring(1);
    Documentation documentation = linkSource.getDocumentation();

    File pluginsFolder = documentation.getProjectFolder().getParentFile();
    File targetFile = new File(pluginsFolder, path);

    File copiesFolder = new File(documentation.getProjectImagesFolder(), "copies");
    File copyFile = new File(copiesFolder, path);

    copyFile.getParentFile().mkdirs();
    ArticleUtil.copyFile(targetFile, copyFile);

    return linkSource.getImagePath() + "/" + copiesFolder.getName() + src;
  }

} // TextImpl
