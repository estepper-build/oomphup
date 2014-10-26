/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Selection;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.Tag;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Selection</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class SelectionImpl extends BodyElementImpl implements Selection
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionImpl()
  {
    super();
  }

  SelectionImpl(Tag tag)
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
    return ArticlePackage.Literals.SELECTION;
  }

  public BodyElement copy()
  {
    return new SelectionImpl(getTag());
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    String text = getTag().text();
    boolean first = true;

    StringTokenizer tokenizer = new StringTokenizer(text, "|");
    while (tokenizer.hasMoreTokens())
    {
      String token = tokenizer.nextToken().trim().replace(" ", "&nbsp;").replace("...", "&hellip;");

      if (first)
      {
        first = false;
      }
      else
      {
        out.print("&nbsp;&rarr; ");
      }

      out.print("<span class=\"selectstep\">");
      out.print(token);
      out.print("</span>");
    }
  }

} // SelectionImpl
