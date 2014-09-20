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

import org.eclipse.oomph.releng.doc.article.Article;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Category;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.Toc;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.Tag;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Toc</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TocImpl#getLevels <em>Levels</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TocImpl extends BodyElementImpl implements Toc
{
  /**
   * The default value of the '{@link #getLevels() <em>Levels</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getLevels()
   * @generated
   * @ordered
   */
  protected static final int LEVELS_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getLevels() <em>Levels</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getLevels()
   * @generated
   * @ordered
   */
  protected int levels = LEVELS_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected TocImpl()
  {
    super();
  }

  TocImpl(Tag tag)
  {
    super(tag);

    String text = tag == null ? null : tag.text();
    if (text != null && text.length() != 0)
    {
      levels = Integer.parseInt(text);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.TOC;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public int getLevels()
  {
    return levels;
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
      case ArticlePackage.TOC__LEVELS:
        return getLevels();
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
      case ArticlePackage.TOC__LEVELS:
        return levels != LEVELS_EDEFAULT;
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
    result.append(" (levels: ");
    result.append(levels);
    result.append(')');
    return result.toString();
  }

  public BodyElement copy()
  {
    return new TocImpl(getTag());
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    StructuralElement element = (StructuralElement)getContainer();
    if (element.isOverview())
    {
      element = element.getDocumentation();
    }

    out.write("<p>" + NL);
    out.write("<table border=\"0\">" + NL);

    String imagePath = linkSource.getImagePath() + "/";
    generate(out, linkSource, imagePath, element.getDepth(), element, 0);

    out.write("</table>" + NL);
    out.write("</p>" + NL);
  }

  private void generate(PrintWriter out, StructuralElement linkSource, String imagePath, int depth, StructuralElement element, int level)
  {
    if (level > levels && levels > 0)
    {
      return;
    }

    if (levels == -2)
    {
      if (!(element instanceof Documentation || element instanceof Category || element instanceof Article))
      {
        return;
      }
    }
    else if (levels == -3)
    {
      if (!(element instanceof Documentation || element instanceof Category))
      {
        return;
      }
    }

    if (level > 0)
    {
      out.write("<tr>");
      for (int i = 1; i < level; i++)
      {
        out.write("<td></td>");
      }

      out.write("<td>");

      if (element instanceof Category)
      {
        out.write("<img src=\"" + imagePath + "category.gif\">");
      }
      else if (element instanceof Article)
      {
        out.write("<img src=\"" + imagePath + "article.gif\">");
      }
      else
      {
        out.write(((ChapterImpl)element).getChapterNumber());
      }

      int colspan = depth - level + 2;
      out.write("&nbsp;</td><td colspan=\"" + colspan + "\">");
      element.generateLink(out, linkSource, null);
      out.write("</td></tr>" + NL);
    }

    for (StructuralElement child : element.getSortedChildren())
    {
      generate(out, linkSource, imagePath, depth, child, level + 1);
    }
  }
} // TocImpl
