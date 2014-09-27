/**
 */
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.common.util.EList;

import java.io.File;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Formatter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getFile <em>File</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpandTo <em>Expand To</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpanded <em>Expanded</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeFormatter()
 * @model
 * @generated
 */
public interface TreeFormatter extends Formatter
{
  public static final String TYPE = "tree";

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
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeFormatter_File()
   * @model dataType="org.eclipse.oomph.releng.doc.article.File"
   * @generated
   */
  File getFile();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getFile <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File</em>' attribute.
   * @see #getFile()
   * @generated
   */
  void setFile(File value);

  /**
   * Returns the value of the '<em><b>Expand To</b></em>' attribute.
   * The default value is <code>"-1"</code>.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expand To</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expand To</em>' attribute.
   * @see #setExpandTo(int)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeFormatter_ExpandTo()
   * @model default="-1"
   * @generated
   */
  int getExpandTo();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpandTo <em>Expand To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expand To</em>' attribute.
   * @see #getExpandTo()
   * @generated
   */
  void setExpandTo(int value);

  /**
   * Returns the value of the '<em><b>Expanded</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expanded</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expanded</em>' attribute list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeFormatter_Expanded()
   * @model
   * @generated
   */
  EList<String> getExpanded();

  /**
   * Returns the value of the '<em><b>Selected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Selected</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Selected</em>' attribute.
   * @see #setSelected(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeFormatter_Selected()
   * @model
   * @generated
   */
  String getSelected();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getSelected <em>Selected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Selected</em>' attribute.
   * @see #getSelected()
   * @generated
   */
  void setSelected(String value);

} // TreeFormatter
