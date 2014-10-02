/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Key;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.Tag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Key</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class KeyImpl extends BodyElementImpl implements Key
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeyImpl()
  {
    super();
  }

  KeyImpl(Tag tag)
  {
    super(tag);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.KEY;
  }

  public BodyElement copy()
  {
    return new KeyImpl(getTag());
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    String text = getTag().text();
    boolean first = true;

    StringTokenizer tokenizer = new StringTokenizer(text, "+");
    while (tokenizer.hasMoreTokens())
    {
      String token = tokenizer.nextToken().trim().replace(" ", "&nbsp;");

      if (first)
      {
        first = false;
      }
      else
      {
        out.print("&nbsp;+&nbsp;");
      }

      out.print("<span class=\"keycap\">");
      out.print(token);
      out.print("</span>");
    }
  }

} // KeyImpl
