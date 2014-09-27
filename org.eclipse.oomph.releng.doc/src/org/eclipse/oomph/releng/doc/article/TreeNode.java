/**
 */
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tree Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNode#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNode#getImage <em>Image</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNode#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNode#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.TreeNode#getProperties <em>Properties</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode()
 * @model
 * @generated
 */
public interface TreeNode extends EObject
{
  /**
   * Returns the value of the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Id</em>' attribute.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode_Id()
   * @model transient="true" changeable="false" volatile="true" derived="true"
   * @generated
   */
  String getId();

  /**
   * Returns the value of the '<em><b>Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Image</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Image</em>' attribute.
   * @see #setImage(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode_Image()
   * @model
   * @generated
   */
  String getImage();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getImage <em>Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Image</em>' attribute.
   * @see #getImage()
   * @generated
   */
  void setImage(String value);

  /**
   * Returns the value of the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Label</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Label</em>' attribute.
   * @see #setLabel(String)
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode_Label()
   * @model
   * @generated
   */
  String getLabel();

  /**
   * Sets the value of the '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getLabel <em>Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Label</em>' attribute.
   * @see #getLabel()
   * @generated
   */
  void setLabel(String value);

  /**
   * Returns the value of the '<em><b>Children</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.oomph.releng.doc.article.TreeNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Children</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Children</em>' containment reference list.
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode_Children()
   * @model containment="true"
   * @generated
   */
  EList<TreeNode> getChildren();

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
   * @see org.eclipse.oomph.releng.doc.article.ArticlePackage#getTreeNode_Properties()
   * @model containment="true"
   * @generated
   */
  EList<TreeNodeProperty> getProperties();

} // TreeNode
