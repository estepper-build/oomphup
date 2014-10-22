/**
 */
package org.eclipse.oomph.releng.doc.article;

import com.sun.javadoc.Tag;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Description</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.Description#getSnippet <em>Snippet</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getDescription()
 * @model
 * @generated
 */
public interface Description extends BodyElementContainer
{
  /**
   * Returns the value of the '<em><b>Snippet</b></em>' container reference.
   * It is bidirectional and its opposite is '{@link org.eclipse.oomph.releng.doc.article.Snippet#getDescription <em>Description</em>}'.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Snippet</em>' container reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Snippet</em>' container reference.
   * @see #setSnippet(Snippet)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getDescription_Snippet()
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getDescription
   * @model opposite="description" required="true" transient="false"
   * @generated
   */
  Snippet getSnippet();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.Description#getSnippet <em>Snippet</em>}' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Snippet</em>' container reference.
   * @see #getSnippet()
   * @generated
   */
  void setSnippet(Snippet value);

  Tag getTag();

} // Description
