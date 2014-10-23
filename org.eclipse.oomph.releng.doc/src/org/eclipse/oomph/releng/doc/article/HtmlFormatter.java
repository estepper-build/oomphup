/**
 */
package org.eclipse.oomph.releng.doc.article;

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Html Formatter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.HtmlFormatter#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getHtmlFormatter()
 * @model
 * @generated
 */
public interface HtmlFormatter extends Formatter
{
  String TYPE = "html";

  /**
   * Returns the value of the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File</em>' attribute.
   * @see #setFile(File)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getHtmlFormatter_File()
   * @model dataType="org.eclipse.oomph.releng.doc.article.File"
   * @generated
   */
  File getFile();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.HtmlFormatter#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(File value);

} // HtmlFormatter
