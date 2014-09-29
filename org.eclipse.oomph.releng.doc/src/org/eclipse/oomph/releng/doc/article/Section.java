/**
 */
package org.eclipse.oomph.releng.doc.article;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Section</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Section#getChapter <em>Chapter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSection()
 * @model
 * @generated
 */
public interface Section extends LinkTarget, BodyElementContainer
{

  /**
   * Returns the value of the '<em><b>Chapter</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Chapter#getSections <em>Sections</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Chapter</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Chapter</em>' container reference.
   * @see #setChapter(Chapter)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getSection_Chapter()
   * @see org.eclipse.oomph.releng.doc.article.Chapter#getSections
   * @model opposite="sections" required="true" transient="false"
   * @generated
   */
  Chapter getChapter();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Section#getChapter <em>Chapter</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Chapter</em>' container reference.
   * @see #getChapter()
   * @generated
   */
  void setChapter(Chapter value);

  void addHeaders(Set<String> headers);

  void generate(PrintWriter out) throws IOException;

} // Section
