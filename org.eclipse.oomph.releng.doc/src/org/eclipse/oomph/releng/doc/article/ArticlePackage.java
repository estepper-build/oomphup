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
package org.eclipse.oomph.releng.doc.article;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.oomph.releng.doc.article.ArticleFactory
 * @model kind="package"
 * @generated
 */
public interface ArticlePackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "article";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipse.org/ARTICLE/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "article";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  ArticlePackage eINSTANCE = org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.Identifiable <em>Identifiable</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.Identifiable
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getIdentifiable()
   * @generated
   */
  int IDENTIFIABLE = 14;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IDENTIFIABLE__ID = 0;

  /**
   * The number of structural features of the '<em>Identifiable</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int IDENTIFIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl <em>Link Target</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getLinkTarget()
   * @generated
   */
  int LINK_TARGET = 10;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_TARGET__ID = IDENTIFIABLE__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_TARGET__DEFAULT_LABEL = IDENTIFIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_TARGET__TOOLTIP = IDENTIFIABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Link Target</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int LINK_TARGET_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.StructuralElementImpl <em>Structural Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.StructuralElementImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getStructuralElement()
   * @generated
   */
  int STRUCTURAL_ELEMENT = 9;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__ID = LINK_TARGET__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__DEFAULT_LABEL = LINK_TARGET__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__TOOLTIP = LINK_TARGET__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__CHILDREN = LINK_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__PARENT = LINK_TARGET_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__TITLE = LINK_TARGET_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__DOCUMENTATION = LINK_TARGET_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT__DOC = LINK_TARGET_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Structural Element</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int STRUCTURAL_ELEMENT_FEATURE_COUNT = LINK_TARGET_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl <em>Documentation</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDocumentation()
   * @generated
   */
  int DOCUMENTATION = 0;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__ID = STRUCTURAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__DEFAULT_LABEL = STRUCTURAL_ELEMENT__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__TOOLTIP = STRUCTURAL_ELEMENT__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__CHILDREN = STRUCTURAL_ELEMENT__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__PARENT = STRUCTURAL_ELEMENT__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__TITLE = STRUCTURAL_ELEMENT__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__DOCUMENTATION = STRUCTURAL_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__DOC = STRUCTURAL_ELEMENT__DOC;

  /**
   * The feature id for the '<em><b>Context</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__CONTEXT = STRUCTURAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Embeddable Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__EMBEDDABLE_ELEMENTS = STRUCTURAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Dependencies</b></em>' reference list.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__DEPENDENCIES = STRUCTURAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__PROJECT = STRUCTURAL_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Plugins</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int DOCUMENTATION__PLUGINS = STRUCTURAL_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Documentation</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int DOCUMENTATION_FEATURE_COUNT = STRUCTURAL_ELEMENT_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ContextImpl <em>Context</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ContextImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getContext()
   * @generated
   */
  int CONTEXT = 1;

  /**
   * The feature id for the '<em><b>Base Folder</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__BASE_FOLDER = 0;

  /**
   * The feature id for the '<em><b>Project</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__PROJECT = 1;

  /**
   * The feature id for the '<em><b>Documentations</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__DOCUMENTATIONS = 2;

  /**
   * The feature id for the '<em><b>Root</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT__ROOT = 3;

  /**
   * The number of structural features of the '<em>Context</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyImpl <em>Body</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.oomph.releng.doc.article.impl.BodyImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBody()
   * @generated
   */
  int BODY = 16;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__ID = STRUCTURAL_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__DEFAULT_LABEL = STRUCTURAL_ELEMENT__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__TOOLTIP = STRUCTURAL_ELEMENT__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__CHILDREN = STRUCTURAL_ELEMENT__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__PARENT = STRUCTURAL_ELEMENT__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__TITLE = STRUCTURAL_ELEMENT__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__DOCUMENTATION = STRUCTURAL_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__DOC = STRUCTURAL_ELEMENT__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__ELEMENTS = STRUCTURAL_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY__CATEGORY = STRUCTURAL_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Body</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_FEATURE_COUNT = STRUCTURAL_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.CategoryImpl <em>Category</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.CategoryImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getCategory()
   * @generated
   */
  int CATEGORY = 2;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__ID = BODY__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__DEFAULT_LABEL = BODY__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__TOOLTIP = BODY__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__CHILDREN = BODY__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__PARENT = BODY__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__TITLE = BODY__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__DOCUMENTATION = BODY__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__DOC = BODY__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__ELEMENTS = BODY__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY__CATEGORY = BODY__CATEGORY;

  /**
   * The number of structural features of the '<em>Category</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CATEGORY_FEATURE_COUNT = BODY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ChapterImpl <em>Chapter</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ChapterImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getChapter()
   * @generated
   */
  int CHAPTER = 4;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__ID = BODY__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__DEFAULT_LABEL = BODY__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__TOOLTIP = BODY__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__CHILDREN = BODY__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__PARENT = BODY__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__TITLE = BODY__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__DOCUMENTATION = BODY__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__DOC = BODY__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__ELEMENTS = BODY__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__CATEGORY = BODY__CATEGORY;

  /**
   * The feature id for the '<em><b>Article</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__ARTICLE = BODY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Sections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER__SECTIONS = BODY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Chapter</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHAPTER_FEATURE_COUNT = BODY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ArticleImpl <em>Article</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticleImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getArticle()
   * @generated
   */
  int ARTICLE = 3;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__ID = CHAPTER__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__DEFAULT_LABEL = CHAPTER__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__TOOLTIP = CHAPTER__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__CHILDREN = CHAPTER__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__PARENT = CHAPTER__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__TITLE = CHAPTER__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__DOCUMENTATION = CHAPTER__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__DOC = CHAPTER__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__ELEMENTS = CHAPTER__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__CATEGORY = CHAPTER__CATEGORY;

  /**
   * The feature id for the '<em><b>Article</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__ARTICLE = CHAPTER__ARTICLE;

  /**
   * The feature id for the '<em><b>Sections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE__SECTIONS = CHAPTER__SECTIONS;

  /**
   * The number of structural features of the '<em>Article</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARTICLE_FEATURE_COUNT = CHAPTER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.EmbeddableElementImpl <em>Embeddable Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.EmbeddableElementImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getEmbeddableElement()
   * @generated
   */
  int EMBEDDABLE_ELEMENT = 12;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDABLE_ELEMENT__ID = IDENTIFIABLE__ID;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDABLE_ELEMENT__DOCUMENTATION = IDENTIFIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDABLE_ELEMENT__DOC = IDENTIFIABLE_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Embeddable Element</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDABLE_ELEMENT_FEATURE_COUNT = IDENTIFIABLE_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl <em>Snippet</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.SnippetImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSnippet()
   * @generated
   */
  int SNIPPET = 5;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__ID = EMBEDDABLE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__DOCUMENTATION = EMBEDDABLE_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__DOC = EMBEDDABLE_ELEMENT__DOC;

  /**
   * The feature id for the '<em><b>Callouts</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__CALLOUTS = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Formatter</b></em>' containment reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SNIPPET__FORMATTER = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__TITLE = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Title Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET__TITLE_IMAGE = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Snippet</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SNIPPET_FEATURE_COUNT = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyElementImpl <em>Body Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.BodyElementImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBodyElement()
   * @generated
   */
  int BODY_ELEMENT = 18;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int BODY_ELEMENT__CONTAINER = 0;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_ELEMENT__TAG = 1;

  /**
   * The number of structural features of the '<em>Body Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int BODY_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.DiagramImpl <em>Diagram</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.DiagramImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDiagram()
   * @generated
   */
  int DIAGRAM = 6;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int DIAGRAM__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIAGRAM__TAG = BODY_ELEMENT__TAG;

  /**
   * The number of structural features of the '<em>Diagram</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DIAGRAM_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.FactoryImpl <em>Factory</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.FactoryImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFactory()
   * @generated
   */
  int FACTORY = 7;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__ID = EMBEDDABLE_ELEMENT__ID;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' container reference.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__DOCUMENTATION = EMBEDDABLE_ELEMENT__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY__DOC = EMBEDDABLE_ELEMENT__DOC;

  /**
   * The number of structural features of the '<em>Factory</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FACTORY_FEATURE_COUNT = EMBEDDABLE_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaElementImpl <em>Java Element</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.JavaElementImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaElement()
   * @generated
   */
  int JAVA_ELEMENT = 8;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_ELEMENT__ID = LINK_TARGET__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_ELEMENT__DEFAULT_LABEL = LINK_TARGET__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_ELEMENT__TOOLTIP = LINK_TARGET__TOOLTIP;

  /**
   * The feature id for the '<em><b>Class File</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_ELEMENT__CLASS_FILE = LINK_TARGET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Java Element</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int JAVA_ELEMENT_FEATURE_COUNT = LINK_TARGET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyElementContainerImpl <em>Body Element Container</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.BodyElementContainerImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBodyElementContainer()
   * @generated
   */
  int BODY_ELEMENT_CONTAINER = 17;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_ELEMENT_CONTAINER__ELEMENTS = 0;

  /**
   * The number of structural features of the '<em>Body Element Container</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int BODY_ELEMENT_CONTAINER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.CalloutImpl <em>Callout</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.CalloutImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getCallout()
   * @generated
   */
  int CALLOUT = 11;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLOUT__ELEMENTS = BODY_ELEMENT_CONTAINER__ELEMENTS;

  /**
   * The feature id for the '<em><b>Snippet</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLOUT__SNIPPET = BODY_ELEMENT_CONTAINER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Callout</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CALLOUT_FEATURE_COUNT = BODY_ELEMENT_CONTAINER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExternalTargetImpl <em>External Target</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ExternalTargetImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExternalTarget()
   * @generated
   */
  int EXTERNAL_TARGET = 13;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TARGET__ID = LINK_TARGET__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TARGET__DEFAULT_LABEL = LINK_TARGET__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TARGET__TOOLTIP = LINK_TARGET__TOOLTIP;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TARGET__URL = LINK_TARGET_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Target</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_TARGET_FEATURE_COUNT = LINK_TARGET_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.SectionImpl <em>Section</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.SectionImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSection()
   * @generated
   */
  int SECTION = 15;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__ID = LINK_TARGET__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__DEFAULT_LABEL = LINK_TARGET__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__TOOLTIP = LINK_TARGET__TOOLTIP;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__ELEMENTS = LINK_TARGET_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Chapter</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION__CHAPTER = LINK_TARGET_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Section</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SECTION_FEATURE_COUNT = LINK_TARGET_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.TextImpl <em>Text</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.oomph.releng.doc.article.impl.TextImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getText()
   * @generated
   */
  int TEXT = 19;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int TEXT__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT__TAG = BODY_ELEMENT__TAG;

  /**
   * The number of structural features of the '<em>Text</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TEXT_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.LinkImpl <em>Link</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.oomph.releng.doc.article.impl.LinkImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getLink()
   * @generated
   */
  int LINK = 20;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int LINK__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__TAG = BODY_ELEMENT__TAG;

  /**
   * The feature id for the '<em><b>Target</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK__TARGET = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Link</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LINK_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.EmbeddingImpl <em>Embedding</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.EmbeddingImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getEmbedding()
   * @generated
   */
  int EMBEDDING = 21;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int EMBEDDING__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDING__TAG = BODY_ELEMENT__TAG;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDING__ELEMENT = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Embedding</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EMBEDDING_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.SourceCodeImpl <em>Source Code</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.SourceCodeImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSourceCode()
   * @generated
   */
  int SOURCE_CODE = 22;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE__ID = EXTERNAL_TARGET__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE__DEFAULT_LABEL = EXTERNAL_TARGET__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE__TOOLTIP = EXTERNAL_TARGET__TOOLTIP;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SOURCE_CODE__URL = EXTERNAL_TARGET__URL;

  /**
   * The number of structural features of the '<em>Source Code</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int SOURCE_CODE_FEATURE_COUNT = EXTERNAL_TARGET_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.PluginImpl <em>Plugin</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.PluginImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getPlugin()
   * @generated
   */
  int PLUGIN = 23;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN__NAME = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN__PACKAGES = 1;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN__LABEL = 2;

  /**
   * The feature id for the '<em><b>Extension Points</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN__EXTENSION_POINTS = 3;

  /**
   * The number of structural features of the '<em>Plugin</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaPackageImpl <em>Java Package</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.JavaPackageImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaPackage()
   * @generated
   */
  int JAVA_PACKAGE = 24;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_PACKAGE__NAME = 0;

  /**
   * The feature id for the '<em><b>Plugin</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_PACKAGE__PLUGIN = 1;

  /**
   * The number of structural features of the '<em>Java Package</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int JAVA_PACKAGE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavadocImpl <em>Javadoc</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.JavadocImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavadoc()
   * @generated
   */
  int JAVADOC = 25;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__ID = CATEGORY__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__DEFAULT_LABEL = CATEGORY__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__TOOLTIP = CATEGORY__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__CHILDREN = CATEGORY__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__PARENT = CATEGORY__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__TITLE = CATEGORY__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__DOCUMENTATION = CATEGORY__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__DOC = CATEGORY__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__ELEMENTS = CATEGORY__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC__CATEGORY = CATEGORY__CATEGORY;

  /**
   * The number of structural features of the '<em>Javadoc</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVADOC_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExternalArticleImpl <em>External Article</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ExternalArticleImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExternalArticle()
   * @generated
   */
  int EXTERNAL_ARTICLE = 26;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__ID = ARTICLE__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__DEFAULT_LABEL = ARTICLE__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__TOOLTIP = ARTICLE__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__CHILDREN = ARTICLE__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__PARENT = ARTICLE__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__TITLE = ARTICLE__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__DOCUMENTATION = ARTICLE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__DOC = ARTICLE__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__ELEMENTS = ARTICLE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__CATEGORY = ARTICLE__CATEGORY;

  /**
   * The feature id for the '<em><b>Article</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__ARTICLE = ARTICLE__ARTICLE;

  /**
   * The feature id for the '<em><b>Sections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__SECTIONS = ARTICLE__SECTIONS;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE__URL = ARTICLE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>External Article</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTERNAL_ARTICLE_FEATURE_COUNT = ARTICLE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.SchemadocImpl <em>Schemadoc</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.SchemadocImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSchemadoc()
   * @generated
   */
  int SCHEMADOC = 27;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__ID = CATEGORY__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__DEFAULT_LABEL = CATEGORY__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__TOOLTIP = CATEGORY__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__CHILDREN = CATEGORY__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__PARENT = CATEGORY__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__TITLE = CATEGORY__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__DOCUMENTATION = CATEGORY__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__DOC = CATEGORY__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__ELEMENTS = CATEGORY__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC__CATEGORY = CATEGORY__CATEGORY;

  /**
   * The number of structural features of the '<em>Schemadoc</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCHEMADOC_FEATURE_COUNT = CATEGORY_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ExtensionPointImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExtensionPoint()
   * @generated
   */
  int EXTENSION_POINT = 28;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_POINT__NAME = 0;

  /**
   * The feature id for the '<em><b>Plugin</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_POINT__PLUGIN = 1;

  /**
   * The number of structural features of the '<em>Extension Point</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int EXTENSION_POINT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.TocImpl <em>Toc</em>}' class. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @see org.eclipse.oomph.releng.doc.article.impl.TocImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getToc()
   * @generated
   */
  int TOC = 29;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int TOC__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOC__TAG = BODY_ELEMENT__TAG;

  /**
   * The feature id for the '<em><b>Levels</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOC__LEVELS = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Toc</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TOC_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.PluginResourceImpl <em>Plugin Resource</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.PluginResourceImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getPluginResource()
   * @generated
   */
  int PLUGIN_RESOURCE = 30;

  /**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__ID = EXTERNAL_ARTICLE__ID;

  /**
   * The feature id for the '<em><b>Default Label</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__DEFAULT_LABEL = EXTERNAL_ARTICLE__DEFAULT_LABEL;

  /**
   * The feature id for the '<em><b>Tooltip</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__TOOLTIP = EXTERNAL_ARTICLE__TOOLTIP;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__CHILDREN = EXTERNAL_ARTICLE__CHILDREN;

  /**
   * The feature id for the '<em><b>Parent</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__PARENT = EXTERNAL_ARTICLE__PARENT;

  /**
   * The feature id for the '<em><b>Title</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__TITLE = EXTERNAL_ARTICLE__TITLE;

  /**
   * The feature id for the '<em><b>Documentation</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__DOCUMENTATION = EXTERNAL_ARTICLE__DOCUMENTATION;

  /**
   * The feature id for the '<em><b>Doc</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__DOC = EXTERNAL_ARTICLE__DOC;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__ELEMENTS = EXTERNAL_ARTICLE__ELEMENTS;

  /**
   * The feature id for the '<em><b>Category</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__CATEGORY = EXTERNAL_ARTICLE__CATEGORY;

  /**
   * The feature id for the '<em><b>Article</b></em>' reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__ARTICLE = EXTERNAL_ARTICLE__ARTICLE;

  /**
   * The feature id for the '<em><b>Sections</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__SECTIONS = EXTERNAL_ARTICLE__SECTIONS;

  /**
   * The feature id for the '<em><b>Url</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE__URL = EXTERNAL_ARTICLE__URL;

  /**
   * The number of structural features of the '<em>Plugin Resource</em>' class.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   * @ordered
   */
  int PLUGIN_RESOURCE_FEATURE_COUNT = EXTERNAL_ARTICLE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExcelImpl <em>Excel</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ExcelImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExcel()
   * @generated
   */
  int EXCEL = 31;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int EXCEL__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL__TAG = BODY_ELEMENT__TAG;

  /**
   * The number of structural features of the '<em>Excel</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCEL_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.FormatterImpl <em>Formatter</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.FormatterImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFormatter()
   * @generated
   */
  int FORMATTER = 32;

  /**
   * The feature id for the '<em><b>Snippet</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMATTER__SNIPPET = 0;

  /**
   * The number of structural features of the '<em>Formatter</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FORMATTER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaFormatterImpl <em>Java Formatter</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.JavaFormatterImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaFormatter()
   * @generated
   */
  int JAVA_FORMATTER = 33;

  /**
   * The feature id for the '<em><b>Snippet</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int JAVA_FORMATTER__SNIPPET = FORMATTER__SNIPPET;

  /**
   * The number of structural features of the '<em>Java Formatter</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int JAVA_FORMATTER_FEATURE_COUNT = FORMATTER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.XmlFormatterImpl <em>Xml Formatter</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.XmlFormatterImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getXmlFormatter()
   * @generated
   */
  int XML_FORMATTER = 34;

  /**
   * The feature id for the '<em><b>Snippet</b></em>' container reference.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XML_FORMATTER__SNIPPET = FORMATTER__SNIPPET;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int XML_FORMATTER__FILE = FORMATTER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Xml Formatter</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int XML_FORMATTER_FEATURE_COUNT = FORMATTER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl <em>Tree Formatter</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeFormatter()
   * @generated
   */
  int TREE_FORMATTER = 35;

  /**
   * The feature id for the '<em><b>Snippet</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER__SNIPPET = FORMATTER__SNIPPET;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER__FILE = FORMATTER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expand To</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER__EXPAND_TO = FORMATTER_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expanded</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER__EXPANDED = FORMATTER_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Selected</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER__SELECTED = FORMATTER_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Tree Formatter</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_FORMATTER_FEATURE_COUNT = FORMATTER_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.ImageImpl <em>Image</em>}' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.ImageImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getImage()
   * @generated
   */
  int IMAGE = 36;

  /**
   * The feature id for the '<em><b>Container</b></em>' container reference. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @generated
   * @ordered
   */
  int IMAGE__CONTAINER = BODY_ELEMENT__CONTAINER;

  /**
   * The feature id for the '<em><b>Tag</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE__TAG = BODY_ELEMENT__TAG;

  /**
   * The feature id for the '<em><b>File</b></em>' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE__FILE = BODY_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Image</em>' class.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMAGE_FEATURE_COUNT = BODY_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodeImpl <em>Tree Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.TreeNodeImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeNode()
   * @generated
   */
  int TREE_NODE = 37;

  /**
   * The feature id for the '<em><b>Xmi ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__XMI_ID = 0;

  /**
   * The feature id for the '<em><b>Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__IMAGE = 1;

  /**
   * The feature id for the '<em><b>Label</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__LABEL = 2;

  /**
   * The feature id for the '<em><b>Children</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__CHILDREN = 3;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE__PROPERTIES = 4;

  /**
   * The number of structural features of the '<em>Tree Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl <em>Tree Node Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeNodeProperty()
   * @generated
   */
  int TREE_NODE_PROPERTY = 38;

  /**
   * The feature id for the '<em><b>Key</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_PROPERTY__KEY = 0;

  /**
   * The feature id for the '<em><b>Value Image</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_PROPERTY__VALUE_IMAGE = 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_PROPERTY__VALUE = 2;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_PROPERTY__PROPERTIES = 3;

  /**
   * The number of structural features of the '<em>Tree Node Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TREE_NODE_PROPERTY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '<em>Root Doc</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see com.sun.javadoc.RootDoc
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getRootDoc()
   * @generated
   */
  int ROOT_DOC = 39;

  /**
   * The meta object id for the '<em>File</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see java.io.File
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFile()
   * @generated
   */
  int FILE = 40;

  /**
   * The meta object id for the '<em>Doc</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see com.sun.javadoc.Doc
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDoc()
   * @generated
   */
  int DOC = 41;

  /**
   * The meta object id for the '<em>Tag</em>' data type.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see com.sun.javadoc.Tag
   * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTag()
   * @generated
   */
  int TAG = 42;

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Documentation <em>Documentation</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Documentation</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation
   * @generated
   */
  EClass getDocumentation();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.Documentation#getContext <em>Context</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Context</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getContext()
   * @see #getDocumentation()
   * @generated
   */
  EReference getDocumentation_Context();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.Documentation#getEmbeddableElements <em>Embeddable Elements</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Embeddable Elements</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getEmbeddableElements()
   * @see #getDocumentation()
   * @generated
   */
  EReference getDocumentation_EmbeddableElements();

  /**
   * Returns the meta object for the reference list '
   * {@link org.eclipse.oomph.releng.doc.article.Documentation#getDependencies <em>Dependencies</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference list '<em>Dependencies</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getDependencies()
   * @see #getDocumentation()
   * @generated
   */
  EReference getDocumentation_Dependencies();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Documentation#getProject <em>Project</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getProject()
   * @see #getDocumentation()
   * @generated
   */
  EAttribute getDocumentation_Project();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.Documentation#getPlugins <em>Plugins</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Plugins</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Documentation#getPlugins()
   * @see #getDocumentation()
   * @generated
   */
  EReference getDocumentation_Plugins();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Context <em>Context</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Context</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Context
   * @generated
   */
  EClass getContext();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Context#getBaseFolder <em>Base Folder</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Base Folder</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Context#getBaseFolder()
   * @see #getContext()
   * @generated
   */
  EAttribute getContext_BaseFolder();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Context#getProject <em>Project</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Context#getProject()
   * @see #getContext()
   * @generated
   */
  EAttribute getContext_Project();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.oomph.releng.doc.article.Context#getDocumentations <em>Documentations</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Documentations</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Context#getDocumentations()
   * @see #getContext()
   * @generated
   */
  EReference getContext_Documentations();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Context#getRoot <em>Root</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Root</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Context#getRoot()
   * @see #getContext()
   * @generated
   */
  EAttribute getContext_Root();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Category <em>Category</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Category</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Category
   * @generated
   */
  EClass getCategory();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Article <em>Article</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Article</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Article
   * @generated
   */
  EClass getArticle();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Chapter <em>Chapter</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Chapter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Chapter
   * @generated
   */
  EClass getChapter();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.oomph.releng.doc.article.Chapter#getArticle <em>Article</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Article</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Chapter#getArticle()
   * @see #getChapter()
   * @generated
   */
  EReference getChapter_Article();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.Chapter#getSections <em>Sections</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Sections</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Chapter#getSections()
   * @see #getChapter()
   * @generated
   */
  EReference getChapter_Sections();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Snippet <em>Snippet</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Snippet</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Snippet
   * @generated
   */
  EClass getSnippet();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.Snippet#getCallouts <em>Callouts</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference list '<em>Callouts</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getCallouts()
   * @see #getSnippet()
   * @generated
   */
  EReference getSnippet_Callouts();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipse.oomph.releng.doc.article.Snippet#getFormatter <em>Formatter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Formatter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getFormatter()
   * @see #getSnippet()
   * @generated
   */
  EReference getSnippet_Formatter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getTitle()
   * @see #getSnippet()
   * @generated
   */
  EAttribute getSnippet_Title();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Snippet#getTitleImage <em>Title Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title Image</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Snippet#getTitleImage()
   * @see #getSnippet()
   * @generated
   */
  EAttribute getSnippet_TitleImage();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Diagram <em>Diagram</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Diagram</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Diagram
   * @generated
   */
  EClass getDiagram();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Factory <em>Factory</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Factory</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Factory
   * @generated
   */
  EClass getFactory();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.JavaElement <em>Java Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Element</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaElement
   * @generated
   */
  EClass getJavaElement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.JavaElement#getClassFile <em>Class File</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Class File</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaElement#getClassFile()
   * @see #getJavaElement()
   * @generated
   */
  EAttribute getJavaElement_ClassFile();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.StructuralElement <em>Structural Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Structural Element</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement
   * @generated
   */
  EClass getStructuralElement();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.oomph.releng.doc.article.StructuralElement#getChildren <em>Children</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement#getChildren()
   * @see #getStructuralElement()
   * @generated
   */
  EReference getStructuralElement_Children();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.StructuralElement#getParent <em>Parent</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Parent</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement#getParent()
   * @see #getStructuralElement()
   * @generated
   */
  EReference getStructuralElement_Parent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.StructuralElement#getTitle <em>Title</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Title</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement#getTitle()
   * @see #getStructuralElement()
   * @generated
   */
  EAttribute getStructuralElement_Title();

  /**
   * Returns the meta object for the reference '
   * {@link org.eclipse.oomph.releng.doc.article.StructuralElement#getDocumentation <em>Documentation</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the reference '<em>Documentation</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement#getDocumentation()
   * @see #getStructuralElement()
   * @generated
   */
  EReference getStructuralElement_Documentation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.StructuralElement#getDoc <em>Doc</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc</em>'.
   * @see org.eclipse.oomph.releng.doc.article.StructuralElement#getDoc()
   * @see #getStructuralElement()
   * @generated
   */
  EAttribute getStructuralElement_Doc();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.LinkTarget <em>Link Target</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Link Target</em>'.
   * @see org.eclipse.oomph.releng.doc.article.LinkTarget
   * @generated
   */
  EClass getLinkTarget();

  /**
   * Returns the meta object for the attribute '
   * {@link org.eclipse.oomph.releng.doc.article.LinkTarget#getDefaultLabel <em>Default Label</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the attribute '<em>Default Label</em>'.
   * @see org.eclipse.oomph.releng.doc.article.LinkTarget#getDefaultLabel()
   * @see #getLinkTarget()
   * @generated
   */
  EAttribute getLinkTarget_DefaultLabel();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.LinkTarget#getTooltip <em>Tooltip</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tooltip</em>'.
   * @see org.eclipse.oomph.releng.doc.article.LinkTarget#getTooltip()
   * @see #getLinkTarget()
   * @generated
   */
  EAttribute getLinkTarget_Tooltip();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Callout <em>Callout</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Callout</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Callout
   * @generated
   */
  EClass getCallout();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.Callout#getSnippet <em>Snippet</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the container reference '<em>Snippet</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Callout#getSnippet()
   * @see #getCallout()
   * @generated
   */
  EReference getCallout_Snippet();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.EmbeddableElement <em>Embeddable Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Embeddable Element</em>'.
   * @see org.eclipse.oomph.releng.doc.article.EmbeddableElement
   * @generated
   */
  EClass getEmbeddableElement();

  /**
   * Returns the meta object for the container reference '
   * {@link org.eclipse.oomph.releng.doc.article.EmbeddableElement#getDocumentation <em>Documentation</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the container reference '<em>Documentation</em>'.
   * @see org.eclipse.oomph.releng.doc.article.EmbeddableElement#getDocumentation()
   * @see #getEmbeddableElement()
   * @generated
   */
  EReference getEmbeddableElement_Documentation();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.EmbeddableElement#getDoc <em>Doc</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Doc</em>'.
   * @see org.eclipse.oomph.releng.doc.article.EmbeddableElement#getDoc()
   * @see #getEmbeddableElement()
   * @generated
   */
  EAttribute getEmbeddableElement_Doc();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.ExternalTarget <em>External Target</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>External Target</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExternalTarget
   * @generated
   */
  EClass getExternalTarget();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.ExternalTarget#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExternalTarget#getUrl()
   * @see #getExternalTarget()
   * @generated
   */
  EAttribute getExternalTarget_Url();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Identifiable <em>Identifiable</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Identifiable</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Identifiable
   * @generated
   */
  EClass getIdentifiable();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Identifiable#getId <em>Id</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Identifiable#getId()
   * @see #getIdentifiable()
   * @generated
   */
  EAttribute getIdentifiable_Id();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Section <em>Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Section</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Section
   * @generated
   */
  EClass getSection();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.Section#getChapter <em>Chapter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Chapter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Section#getChapter()
   * @see #getSection()
   * @generated
   */
  EReference getSection_Chapter();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Body <em>Body</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Body</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Body
   * @generated
   */
  EClass getBody();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.oomph.releng.doc.article.Body#getCategory <em>Category</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Category</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Body#getCategory()
   * @see #getBody()
   * @generated
   */
  EReference getBody_Category();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.BodyElementContainer <em>Body Element Container</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Body Element Container</em>'.
   * @see org.eclipse.oomph.releng.doc.article.BodyElementContainer
   * @generated
   */
  EClass getBodyElementContainer();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.oomph.releng.doc.article.BodyElementContainer#getElements <em>Elements</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipse.oomph.releng.doc.article.BodyElementContainer#getElements()
   * @see #getBodyElementContainer()
   * @generated
   */
  EReference getBodyElementContainer_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.BodyElement <em>Body Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Body Element</em>'.
   * @see org.eclipse.oomph.releng.doc.article.BodyElement
   * @generated
   */
  EClass getBodyElement();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.BodyElement#getContainer <em>Container</em>}'.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Container</em>'.
   * @see org.eclipse.oomph.releng.doc.article.BodyElement#getContainer()
   * @see #getBodyElement()
   * @generated
   */
  EReference getBodyElement_Container();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.BodyElement#getTag <em>Tag</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Tag</em>'.
   * @see org.eclipse.oomph.releng.doc.article.BodyElement#getTag()
   * @see #getBodyElement()
   * @generated
   */
  EAttribute getBodyElement_Tag();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Text <em>Text</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Text</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Text
   * @generated
   */
  EClass getText();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Link <em>Link</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Link</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Link
   * @generated
   */
  EClass getLink();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.oomph.releng.doc.article.Link#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Link#getTarget()
   * @see #getLink()
   * @generated
   */
  EReference getLink_Target();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Embedding <em>Embedding</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Embedding</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Embedding
   * @generated
   */
  EClass getEmbedding();

  /**
   * Returns the meta object for the reference '{@link org.eclipse.oomph.releng.doc.article.Embedding#getElement <em>Element</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Element</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Embedding#getElement()
   * @see #getEmbedding()
   * @generated
   */
  EReference getEmbedding_Element();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.SourceCode <em>Source Code</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Source Code</em>'.
   * @see org.eclipse.oomph.releng.doc.article.SourceCode
   * @generated
   */
  EClass getSourceCode();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Plugin <em>Plugin</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Plugin</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Plugin
   * @generated
   */
  EClass getPlugin();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Plugin#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Plugin#getName()
   * @see #getPlugin()
   * @generated
   */
  EAttribute getPlugin_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.Plugin#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Plugin#getPackages()
   * @see #getPlugin()
   * @generated
   */
  EReference getPlugin_Packages();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Plugin#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Plugin#getLabel()
   * @see #getPlugin()
   * @generated
   */
  EAttribute getPlugin_Label();

  /**
   * Returns the meta object for the containment reference list '
   * {@link org.eclipse.oomph.releng.doc.article.Plugin#getExtensionPoints <em>Extension Points</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for the containment reference list '<em>Extension Points</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Plugin#getExtensionPoints()
   * @see #getPlugin()
   * @generated
   */
  EReference getPlugin_ExtensionPoints();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.JavaPackage <em>Java Package</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Package</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaPackage
   * @generated
   */
  EClass getJavaPackage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.JavaPackage#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaPackage#getName()
   * @see #getJavaPackage()
   * @generated
   */
  EAttribute getJavaPackage_Name();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.JavaPackage#getPlugin <em>Plugin</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the container reference '<em>Plugin</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaPackage#getPlugin()
   * @see #getJavaPackage()
   * @generated
   */
  EReference getJavaPackage_Plugin();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Javadoc <em>Javadoc</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Javadoc</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Javadoc
   * @generated
   */
  EClass getJavadoc();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.ExternalArticle <em>External Article</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>External Article</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExternalArticle
   * @generated
   */
  EClass getExternalArticle();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.ExternalArticle#getUrl <em>Url</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Url</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExternalArticle#getUrl()
   * @see #getExternalArticle()
   * @generated
   */
  EAttribute getExternalArticle_Url();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Schemadoc <em>Schemadoc</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Schemadoc</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Schemadoc
   * @generated
   */
  EClass getSchemadoc();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint <em>Extension Point</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Extension Point</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExtensionPoint
   * @generated
   */
  EClass getExtensionPoint();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExtensionPoint#getName()
   * @see #getExtensionPoint()
   * @generated
   */
  EAttribute getExtensionPoint_Name();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.ExtensionPoint#getPlugin <em>Plugin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the container reference '<em>Plugin</em>'.
   * @see org.eclipse.oomph.releng.doc.article.ExtensionPoint#getPlugin()
   * @see #getExtensionPoint()
   * @generated
   */
  EReference getExtensionPoint_Plugin();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Toc <em>Toc</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Toc</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Toc
   * @generated
   */
  EClass getToc();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Toc#getLevels <em>Levels</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Levels</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Toc#getLevels()
   * @see #getToc()
   * @generated
   */
  EAttribute getToc_Levels();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.PluginResource <em>Plugin Resource</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Plugin Resource</em>'.
   * @see org.eclipse.oomph.releng.doc.article.PluginResource
   * @generated
   */
  EClass getPluginResource();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Excel <em>Excel</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Excel</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Excel
   * @generated
   */
  EClass getExcel();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Formatter <em>Formatter</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Formatter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Formatter
   * @generated
   */
  EClass getFormatter();

  /**
   * Returns the meta object for the container reference '{@link org.eclipse.oomph.releng.doc.article.Formatter#getSnippet <em>Snippet</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for the container reference '<em>Snippet</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Formatter#getSnippet()
   * @see #getFormatter()
   * @generated
   */
  EReference getFormatter_Snippet();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.JavaFormatter <em>Java Formatter</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Java Formatter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.JavaFormatter
   * @generated
   */
  EClass getJavaFormatter();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.XmlFormatter <em>Xml Formatter</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for class '<em>Xml Formatter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.XmlFormatter
   * @generated
   */
  EClass getXmlFormatter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.XmlFormatter#getFile <em>File</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see org.eclipse.oomph.releng.doc.article.XmlFormatter#getFile()
   * @see #getXmlFormatter()
   * @generated
   */
  EAttribute getXmlFormatter_File();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter <em>Tree Formatter</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree Formatter</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeFormatter
   * @generated
   */
  EClass getTreeFormatter();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeFormatter#getFile()
   * @see #getTreeFormatter()
   * @generated
   */
  EAttribute getTreeFormatter_File();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpandTo <em>Expand To</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expand To</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpandTo()
   * @see #getTreeFormatter()
   * @generated
   */
  EAttribute getTreeFormatter_ExpandTo();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpanded <em>Expanded</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Expanded</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeFormatter#getExpanded()
   * @see #getTreeFormatter()
   * @generated
   */
  EAttribute getTreeFormatter_Expanded();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeFormatter#getSelected <em>Selected</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Selected</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeFormatter#getSelected()
   * @see #getTreeFormatter()
   * @generated
   */
  EAttribute getTreeFormatter_Selected();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.Image <em>Image</em>}'. <!--
   * begin-user-doc --> <!-- end-user-doc -->
   *
   * @return the meta object for class '<em>Image</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Image
   * @generated
   */
  EClass getImage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.Image#getFile <em>File</em>}'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>File</em>'.
   * @see org.eclipse.oomph.releng.doc.article.Image#getFile()
   * @see #getImage()
   * @generated
   */
  EAttribute getImage_File();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.TreeNode <em>Tree Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree Node</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode
   * @generated
   */
  EClass getTreeNode();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getXmi_ID <em>Xmi ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Xmi ID</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode#getXmi_ID()
   * @see #getTreeNode()
   * @generated
   */
  EAttribute getTreeNode_Xmi_ID();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getImage <em>Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Image</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode#getImage()
   * @see #getTreeNode()
   * @generated
   */
  EAttribute getTreeNode_Image();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getLabel <em>Label</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Label</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode#getLabel()
   * @see #getTreeNode()
   * @generated
   */
  EAttribute getTreeNode_Label();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getChildren <em>Children</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Children</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode#getChildren()
   * @see #getTreeNode()
   * @generated
   */
  EReference getTreeNode_Children();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.TreeNode#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNode#getProperties()
   * @see #getTreeNode()
   * @generated
   */
  EReference getTreeNode_Properties();

  /**
   * Returns the meta object for class '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty <em>Tree Node Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tree Node Property</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNodeProperty
   * @generated
   */
  EClass getTreeNodeProperty();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getKey <em>Key</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Key</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getKey()
   * @see #getTreeNodeProperty()
   * @generated
   */
  EAttribute getTreeNodeProperty_Key();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValueImage <em>Value Image</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value Image</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValueImage()
   * @see #getTreeNodeProperty()
   * @generated
   */
  EAttribute getTreeNodeProperty_ValueImage();

  /**
   * Returns the meta object for the attribute '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getValue()
   * @see #getTreeNodeProperty()
   * @generated
   */
  EAttribute getTreeNodeProperty_Value();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.eclipse.oomph.releng.doc.article.TreeNodeProperty#getProperties()
   * @see #getTreeNodeProperty()
   * @generated
   */
  EReference getTreeNodeProperty_Properties();

  /**
   * Returns the meta object for data type '{@link com.sun.javadoc.RootDoc <em>Root Doc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for data type '<em>Root Doc</em>'.
   * @see com.sun.javadoc.RootDoc
   * @model instanceClass="com.sun.javadoc.RootDoc" serializeable="false"
   * @generated
   */
  EDataType getRootDoc();

  /**
   * Returns the meta object for data type '{@link java.io.File <em>File</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for data type '<em>File</em>'.
   * @see java.io.File
   * @model instanceClass="java.io.File"
   * @generated
   */
  EDataType getFile();

  /**
   * Returns the meta object for data type '{@link com.sun.javadoc.Doc <em>Doc</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for data type '<em>Doc</em>'.
   * @see com.sun.javadoc.Doc
   * @model instanceClass="com.sun.javadoc.Doc" serializeable="false"
   * @generated
   */
  EDataType getDoc();

  /**
   * Returns the meta object for data type '{@link com.sun.javadoc.Tag <em>Tag</em>}'.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @return the meta object for data type '<em>Tag</em>'.
   * @see com.sun.javadoc.Tag
   * @model instanceClass="com.sun.javadoc.Tag" serializeable="false"
   * @generated
   */
  EDataType getTag();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ArticleFactory getArticleFactory();

  /**
   * <!-- begin-user-doc --> Defines literals for the meta objects that represent
   * <ul>
   * <li>each class,</li>
   * <li>each feature of each class,</li>
   * <li>each enum,</li>
   * <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl <em>Documentation</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.DocumentationImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDocumentation()
     * @generated
     */
    EClass DOCUMENTATION = eINSTANCE.getDocumentation();

    /**
     * The meta object literal for the '<em><b>Context</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENTATION__CONTEXT = eINSTANCE.getDocumentation_Context();

    /**
     * The meta object literal for the '<em><b>Embeddable Elements</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference DOCUMENTATION__EMBEDDABLE_ELEMENTS = eINSTANCE.getDocumentation_EmbeddableElements();

    /**
     * The meta object literal for the '<em><b>Dependencies</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENTATION__DEPENDENCIES = eINSTANCE.getDocumentation_Dependencies();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute DOCUMENTATION__PROJECT = eINSTANCE.getDocumentation_Project();

    /**
     * The meta object literal for the '<em><b>Plugins</b></em>' containment reference list feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference DOCUMENTATION__PLUGINS = eINSTANCE.getDocumentation_Plugins();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ContextImpl <em>Context</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ContextImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getContext()
     * @generated
     */
    EClass CONTEXT = eINSTANCE.getContext();

    /**
     * The meta object literal for the '<em><b>Base Folder</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT__BASE_FOLDER = eINSTANCE.getContext_BaseFolder();

    /**
     * The meta object literal for the '<em><b>Project</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT__PROJECT = eINSTANCE.getContext_Project();

    /**
     * The meta object literal for the '<em><b>Documentations</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference CONTEXT__DOCUMENTATIONS = eINSTANCE.getContext_Documentations();

    /**
     * The meta object literal for the '<em><b>Root</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute CONTEXT__ROOT = eINSTANCE.getContext_Root();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.CategoryImpl <em>Category</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.CategoryImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getCategory()
     * @generated
     */
    EClass CATEGORY = eINSTANCE.getCategory();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ArticleImpl <em>Article</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticleImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getArticle()
     * @generated
     */
    EClass ARTICLE = eINSTANCE.getArticle();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ChapterImpl <em>Chapter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ChapterImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getChapter()
     * @generated
     */
    EClass CHAPTER = eINSTANCE.getChapter();

    /**
     * The meta object literal for the '<em><b>Article</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference CHAPTER__ARTICLE = eINSTANCE.getChapter_Article();

    /**
     * The meta object literal for the '<em><b>Sections</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHAPTER__SECTIONS = eINSTANCE.getChapter_Sections();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl <em>Snippet</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.SnippetImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSnippet()
     * @generated
     */
    EClass SNIPPET = eINSTANCE.getSnippet();

    /**
     * The meta object literal for the '<em><b>Callouts</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference SNIPPET__CALLOUTS = eINSTANCE.getSnippet_Callouts();

    /**
     * The meta object literal for the '<em><b>Formatter</b></em>' containment reference feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference SNIPPET__FORMATTER = eINSTANCE.getSnippet_Formatter();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNIPPET__TITLE = eINSTANCE.getSnippet_Title();

    /**
     * The meta object literal for the '<em><b>Title Image</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SNIPPET__TITLE_IMAGE = eINSTANCE.getSnippet_TitleImage();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.DiagramImpl <em>Diagram</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.DiagramImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDiagram()
     * @generated
     */
    EClass DIAGRAM = eINSTANCE.getDiagram();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.FactoryImpl <em>Factory</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.FactoryImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFactory()
     * @generated
     */
    EClass FACTORY = eINSTANCE.getFactory();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaElementImpl <em>Java Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.JavaElementImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaElement()
     * @generated
     */
    EClass JAVA_ELEMENT = eINSTANCE.getJavaElement();

    /**
     * The meta object literal for the '<em><b>Class File</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute JAVA_ELEMENT__CLASS_FILE = eINSTANCE.getJavaElement_ClassFile();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.StructuralElementImpl <em>Structural Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.StructuralElementImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getStructuralElement()
     * @generated
     */
    EClass STRUCTURAL_ELEMENT = eINSTANCE.getStructuralElement();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference STRUCTURAL_ELEMENT__CHILDREN = eINSTANCE.getStructuralElement_Children();

    /**
     * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STRUCTURAL_ELEMENT__PARENT = eINSTANCE.getStructuralElement_Parent();

    /**
     * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute STRUCTURAL_ELEMENT__TITLE = eINSTANCE.getStructuralElement_Title();

    /**
     * The meta object literal for the '<em><b>Documentation</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference STRUCTURAL_ELEMENT__DOCUMENTATION = eINSTANCE.getStructuralElement_Documentation();

    /**
     * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute STRUCTURAL_ELEMENT__DOC = eINSTANCE.getStructuralElement_Doc();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl <em>Link Target</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getLinkTarget()
     * @generated
     */
    EClass LINK_TARGET = eINSTANCE.getLinkTarget();

    /**
     * The meta object literal for the '<em><b>Default Label</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute LINK_TARGET__DEFAULT_LABEL = eINSTANCE.getLinkTarget_DefaultLabel();

    /**
     * The meta object literal for the '<em><b>Tooltip</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute LINK_TARGET__TOOLTIP = eINSTANCE.getLinkTarget_Tooltip();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.CalloutImpl <em>Callout</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.CalloutImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getCallout()
     * @generated
     */
    EClass CALLOUT = eINSTANCE.getCallout();

    /**
     * The meta object literal for the '<em><b>Snippet</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CALLOUT__SNIPPET = eINSTANCE.getCallout_Snippet();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.EmbeddableElementImpl <em>Embeddable Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.EmbeddableElementImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getEmbeddableElement()
     * @generated
     */
    EClass EMBEDDABLE_ELEMENT = eINSTANCE.getEmbeddableElement();

    /**
     * The meta object literal for the '<em><b>Documentation</b></em>' container reference feature.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @generated
     */
    EReference EMBEDDABLE_ELEMENT__DOCUMENTATION = eINSTANCE.getEmbeddableElement_Documentation();

    /**
     * The meta object literal for the '<em><b>Doc</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute EMBEDDABLE_ELEMENT__DOC = eINSTANCE.getEmbeddableElement_Doc();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExternalTargetImpl <em>External Target</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ExternalTargetImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExternalTarget()
     * @generated
     */
    EClass EXTERNAL_TARGET = eINSTANCE.getExternalTarget();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_TARGET__URL = eINSTANCE.getExternalTarget_Url();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.Identifiable <em>Identifiable</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.Identifiable
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getIdentifiable()
     * @generated
     */
    EClass IDENTIFIABLE = eINSTANCE.getIdentifiable();

    /**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     *
     * @generated
     */
    EAttribute IDENTIFIABLE__ID = eINSTANCE.getIdentifiable_Id();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.SectionImpl <em>Section</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.SectionImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSection()
     * @generated
     */
    EClass SECTION = eINSTANCE.getSection();

    /**
     * The meta object literal for the '<em><b>Chapter</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SECTION__CHAPTER = eINSTANCE.getSection_Chapter();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyImpl <em>Body</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.BodyImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBody()
     * @generated
     */
    EClass BODY = eINSTANCE.getBody();

    /**
     * The meta object literal for the '<em><b>Category</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference BODY__CATEGORY = eINSTANCE.getBody_Category();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyElementContainerImpl <em>Body Element Container</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.BodyElementContainerImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBodyElementContainer()
     * @generated
     */
    EClass BODY_ELEMENT_CONTAINER = eINSTANCE.getBodyElementContainer();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference BODY_ELEMENT_CONTAINER__ELEMENTS = eINSTANCE.getBodyElementContainer_Elements();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.BodyElementImpl <em>Body Element</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.BodyElementImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getBodyElement()
     * @generated
     */
    EClass BODY_ELEMENT = eINSTANCE.getBodyElement();

    /**
     * The meta object literal for the '<em><b>Container</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BODY_ELEMENT__CONTAINER = eINSTANCE.getBodyElement_Container();

    /**
     * The meta object literal for the '<em><b>Tag</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute BODY_ELEMENT__TAG = eINSTANCE.getBodyElement_Tag();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.TextImpl <em>Text</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.TextImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getText()
     * @generated
     */
    EClass TEXT = eINSTANCE.getText();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.LinkImpl <em>Link</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.LinkImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getLink()
     * @generated
     */
    EClass LINK = eINSTANCE.getLink();

    /**
     * The meta object literal for the '<em><b>Target</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference LINK__TARGET = eINSTANCE.getLink_Target();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.EmbeddingImpl <em>Embedding</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.EmbeddingImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getEmbedding()
     * @generated
     */
    EClass EMBEDDING = eINSTANCE.getEmbedding();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EReference EMBEDDING__ELEMENT = eINSTANCE.getEmbedding_Element();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.SourceCodeImpl <em>Source Code</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.SourceCodeImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSourceCode()
     * @generated
     */
    EClass SOURCE_CODE = eINSTANCE.getSourceCode();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.PluginImpl <em>Plugin</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.PluginImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getPlugin()
     * @generated
     */
    EClass PLUGIN = eINSTANCE.getPlugin();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute PLUGIN__NAME = eINSTANCE.getPlugin_Name();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference PLUGIN__PACKAGES = eINSTANCE.getPlugin_Packages();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute PLUGIN__LABEL = eINSTANCE.getPlugin_Label();

    /**
     * The meta object literal for the '<em><b>Extension Points</b></em>' containment reference list feature. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    EReference PLUGIN__EXTENSION_POINTS = eINSTANCE.getPlugin_ExtensionPoints();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaPackageImpl <em>Java Package</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.JavaPackageImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaPackage()
     * @generated
     */
    EClass JAVA_PACKAGE = eINSTANCE.getJavaPackage();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute JAVA_PACKAGE__NAME = eINSTANCE.getJavaPackage_Name();

    /**
     * The meta object literal for the '<em><b>Plugin</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference JAVA_PACKAGE__PLUGIN = eINSTANCE.getJavaPackage_Plugin();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavadocImpl <em>Javadoc</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.JavadocImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavadoc()
     * @generated
     */
    EClass JAVADOC = eINSTANCE.getJavadoc();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExternalArticleImpl <em>External Article</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ExternalArticleImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExternalArticle()
     * @generated
     */
    EClass EXTERNAL_ARTICLE = eINSTANCE.getExternalArticle();

    /**
     * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute EXTERNAL_ARTICLE__URL = eINSTANCE.getExternalArticle_Url();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.SchemadocImpl <em>Schemadoc</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.SchemadocImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getSchemadoc()
     * @generated
     */
    EClass SCHEMADOC = eINSTANCE.getSchemadoc();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExtensionPointImpl <em>Extension Point</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ExtensionPointImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExtensionPoint()
     * @generated
     */
    EClass EXTENSION_POINT = eINSTANCE.getExtensionPoint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute EXTENSION_POINT__NAME = eINSTANCE.getExtensionPoint_Name();

    /**
     * The meta object literal for the '<em><b>Plugin</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXTENSION_POINT__PLUGIN = eINSTANCE.getExtensionPoint_Plugin();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.TocImpl <em>Toc</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.TocImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getToc()
     * @generated
     */
    EClass TOC = eINSTANCE.getToc();

    /**
     * The meta object literal for the '<em><b>Levels</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute TOC__LEVELS = eINSTANCE.getToc_Levels();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.PluginResourceImpl <em>Plugin Resource</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.PluginResourceImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getPluginResource()
     * @generated
     */
    EClass PLUGIN_RESOURCE = eINSTANCE.getPluginResource();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ExcelImpl <em>Excel</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ExcelImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getExcel()
     * @generated
     */
    EClass EXCEL = eINSTANCE.getExcel();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.FormatterImpl <em>Formatter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.FormatterImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFormatter()
     * @generated
     */
    EClass FORMATTER = eINSTANCE.getFormatter();

    /**
     * The meta object literal for the '<em><b>Snippet</b></em>' container reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FORMATTER__SNIPPET = eINSTANCE.getFormatter_Snippet();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.JavaFormatterImpl <em>Java Formatter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.JavaFormatterImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getJavaFormatter()
     * @generated
     */
    EClass JAVA_FORMATTER = eINSTANCE.getJavaFormatter();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.XmlFormatterImpl <em>Xml Formatter</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.XmlFormatterImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getXmlFormatter()
     * @generated
     */
    EClass XML_FORMATTER = eINSTANCE.getXmlFormatter();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute XML_FORMATTER__FILE = eINSTANCE.getXmlFormatter_File();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl <em>Tree Formatter</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeFormatter()
     * @generated
     */
    EClass TREE_FORMATTER = eINSTANCE.getTreeFormatter();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_FORMATTER__FILE = eINSTANCE.getTreeFormatter_File();

    /**
     * The meta object literal for the '<em><b>Expand To</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_FORMATTER__EXPAND_TO = eINSTANCE.getTreeFormatter_ExpandTo();

    /**
     * The meta object literal for the '<em><b>Expanded</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_FORMATTER__EXPANDED = eINSTANCE.getTreeFormatter_Expanded();

    /**
     * The meta object literal for the '<em><b>Selected</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_FORMATTER__SELECTED = eINSTANCE.getTreeFormatter_Selected();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.ImageImpl <em>Image</em>}' class.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.ImageImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getImage()
     * @generated
     */
    EClass IMAGE = eINSTANCE.getImage();

    /**
     * The meta object literal for the '<em><b>File</b></em>' attribute feature.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     */
    EAttribute IMAGE__FILE = eINSTANCE.getImage_File();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodeImpl <em>Tree Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.TreeNodeImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeNode()
     * @generated
     */
    EClass TREE_NODE = eINSTANCE.getTreeNode();

    /**
     * The meta object literal for the '<em><b>Xmi ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE__XMI_ID = eINSTANCE.getTreeNode_Xmi_ID();

    /**
     * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE__IMAGE = eINSTANCE.getTreeNode_Image();

    /**
     * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE__LABEL = eINSTANCE.getTreeNode_Label();

    /**
     * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE_NODE__CHILDREN = eINSTANCE.getTreeNode_Children();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE_NODE__PROPERTIES = eINSTANCE.getTreeNode_Properties();

    /**
     * The meta object literal for the '{@link org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl <em>Tree Node Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.oomph.releng.doc.article.impl.TreeNodePropertyImpl
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTreeNodeProperty()
     * @generated
     */
    EClass TREE_NODE_PROPERTY = eINSTANCE.getTreeNodeProperty();

    /**
     * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE_PROPERTY__KEY = eINSTANCE.getTreeNodeProperty_Key();

    /**
     * The meta object literal for the '<em><b>Value Image</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE_PROPERTY__VALUE_IMAGE = eINSTANCE.getTreeNodeProperty_ValueImage();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TREE_NODE_PROPERTY__VALUE = eINSTANCE.getTreeNodeProperty_Value();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TREE_NODE_PROPERTY__PROPERTIES = eINSTANCE.getTreeNodeProperty_Properties();

    /**
     * The meta object literal for the '<em>Root Doc</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see com.sun.javadoc.RootDoc
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getRootDoc()
     * @generated
     */
    EDataType ROOT_DOC = eINSTANCE.getRootDoc();

    /**
     * The meta object literal for the '<em>File</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see java.io.File
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getFile()
     * @generated
     */
    EDataType FILE = eINSTANCE.getFile();

    /**
     * The meta object literal for the '<em>Doc</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see com.sun.javadoc.Doc
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getDoc()
     * @generated
     */
    EDataType DOC = eINSTANCE.getDoc();

    /**
     * The meta object literal for the '<em>Tag</em>' data type.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see com.sun.javadoc.Tag
     * @see org.eclipse.oomph.releng.doc.article.impl.ArticlePackageImpl#getTag()
     * @generated
     */
    EDataType TAG = eINSTANCE.getTag();

  }

} // ArticlePackage
