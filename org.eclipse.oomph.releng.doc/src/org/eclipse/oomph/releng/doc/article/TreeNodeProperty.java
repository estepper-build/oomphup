/**
 */
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValueImage <em>Value Image</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNodeProperty()
 * @model
 * @generated
 */
public interface TreeNodeProperty extends EObject
{
  /**
   * Returns the value of the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Key</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' attribute.
   * @see #setKey(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNodeProperty_Key()
   * @model
   * @generated
   */
  String getKey();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getKey <em>Key</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' attribute.
   * @see #getKey()
   * @generated
   */
  void setKey(String value);

  /**
   * Returns the value of the '<em><b>Value Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value Image</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value Image</em>' attribute.
   * @see #setValueImage(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNodeProperty_ValueImage()
   * @model
   * @generated
   */
  String getValueImage();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValueImage <em>Value Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value Image</em>' attribute.
   * @see #getValueImage()
   * @generated
   */
  void setValueImage(String value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNodeProperty_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

  /**
   * Returns the value of the '<em><b>Properties</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Properties</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Properties</em>' containment reference list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNodeProperty_Properties()
   * @model containment="true"
   * @generated
   */
  EList<TreeNodeProperty> getProperties();

} // TreeNodeProperty
