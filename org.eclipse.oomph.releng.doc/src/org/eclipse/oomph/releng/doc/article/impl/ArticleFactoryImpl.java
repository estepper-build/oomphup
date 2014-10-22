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
package org.eclipse.oomph.releng.doc.article.impl;

//import org.eclipse.oomph.releng.doc.article.*;
import org.eclipse.oomph.releng.doc.article.Article;
import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Callout;
import org.eclipse.oomph.releng.doc.article.Category;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.Context;
import org.eclipse.oomph.releng.doc.article.Description;
import org.eclipse.oomph.releng.doc.article.Diagram;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Excel;
import org.eclipse.oomph.releng.doc.article.ExtensionPoint;
import org.eclipse.oomph.releng.doc.article.ExternalArticle;
import org.eclipse.oomph.releng.doc.article.ExternalTarget;
import org.eclipse.oomph.releng.doc.article.Image;
import org.eclipse.oomph.releng.doc.article.ImageFactory;
import org.eclipse.oomph.releng.doc.article.ImageFormatter;
import org.eclipse.oomph.releng.doc.article.JavaElement;
import org.eclipse.oomph.releng.doc.article.JavaFormatter;
import org.eclipse.oomph.releng.doc.article.JavaPackage;
import org.eclipse.oomph.releng.doc.article.Javadoc;
import org.eclipse.oomph.releng.doc.article.Key;
import org.eclipse.oomph.releng.doc.article.Link;
import org.eclipse.oomph.releng.doc.article.Plugin;
import org.eclipse.oomph.releng.doc.article.PluginResource;
import org.eclipse.oomph.releng.doc.article.Schemadoc;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.Selection;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.SourceCode;
import org.eclipse.oomph.releng.doc.article.Text;
import org.eclipse.oomph.releng.doc.article.Toc;
import org.eclipse.oomph.releng.doc.article.TreeFormatter;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;
import org.eclipse.oomph.releng.doc.article.XmlFormatter;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import java.io.File;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class ArticleFactoryImpl extends EFactoryImpl implements ArticleFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public static ArticleFactory init()
  {
    try
    {
      ArticleFactory theArticleFactory = (ArticleFactory)EPackage.Registry.INSTANCE.getEFactory(ArticlePackage.eNS_URI);
      if (theArticleFactory != null)
      {
        return theArticleFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new ArticleFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ArticleFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case ArticlePackage.DOCUMENTATION:
        return createDocumentation();
      case ArticlePackage.CONTEXT:
        return createContext();
      case ArticlePackage.CATEGORY:
        return createCategory();
      case ArticlePackage.ARTICLE:
        return createArticle();
      case ArticlePackage.CHAPTER:
        return createChapter();
      case ArticlePackage.SNIPPET:
        return createSnippet();
      case ArticlePackage.DIAGRAM:
        return createDiagram();
      case ArticlePackage.JAVA_ELEMENT:
        return createJavaElement();
      case ArticlePackage.CALLOUT:
        return createCallout();
      case ArticlePackage.EXTERNAL_TARGET:
        return createExternalTarget();
      case ArticlePackage.SECTION:
        return createSection();
      case ArticlePackage.TEXT:
        return createText();
      case ArticlePackage.LINK:
        return createLink();
      case ArticlePackage.EMBEDDING:
        return createEmbedding();
      case ArticlePackage.SOURCE_CODE:
        return createSourceCode();
      case ArticlePackage.PLUGIN:
        return createPlugin();
      case ArticlePackage.JAVA_PACKAGE:
        return createJavaPackage();
      case ArticlePackage.JAVADOC:
        return createJavadoc();
      case ArticlePackage.EXTERNAL_ARTICLE:
        return createExternalArticle();
      case ArticlePackage.SCHEMADOC:
        return createSchemadoc();
      case ArticlePackage.EXTENSION_POINT:
        return createExtensionPoint();
      case ArticlePackage.TOC:
        return createToc();
      case ArticlePackage.PLUGIN_RESOURCE:
        return createPluginResource();
      case ArticlePackage.EXCEL:
        return createExcel();
      case ArticlePackage.JAVA_FORMATTER:
        return createJavaFormatter();
      case ArticlePackage.XML_FORMATTER:
        return createXmlFormatter();
      case ArticlePackage.TREE_FORMATTER:
        return createTreeFormatter();
      case ArticlePackage.IMAGE:
        return createImage();
      case ArticlePackage.TREE_NODE:
        return createTreeNode();
      case ArticlePackage.TREE_NODE_PROPERTY:
        return createTreeNodeProperty();
      case ArticlePackage.IMAGE_FACTORY:
        return createImageFactory();
      case ArticlePackage.KEY:
        return createKey();
      case ArticlePackage.SELECTION:
        return createSelection();
      case ArticlePackage.IMAGE_FORMATTER:
        return createImageFormatter();
      case ArticlePackage.DESCRIPTION:
        return createDescription();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object createFromString(EDataType eDataType, String initialValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ArticlePackage.FILE:
        return createFileFromString(eDataType, initialValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String convertToString(EDataType eDataType, Object instanceValue)
  {
    switch (eDataType.getClassifierID())
    {
      case ArticlePackage.FILE:
        return convertFileToString(eDataType, instanceValue);
      default:
        throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Documentation createDocumentation()
  {
    DocumentationImpl documentation = new DocumentationImpl();
    return documentation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Context createContext()
  {
    ContextImpl context = new ContextImpl();
    return context;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Category createCategory()
  {
    CategoryImpl category = new CategoryImpl();
    return category;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Article createArticle()
  {
    ArticleImpl article = new ArticleImpl();
    return article;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Chapter createChapter()
  {
    ChapterImpl chapter = new ChapterImpl();
    return chapter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Snippet createSnippet()
  {
    SnippetImpl snippet = new SnippetImpl();
    return snippet;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Diagram createDiagram()
  {
    DiagramImpl diagram = new DiagramImpl();
    return diagram;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public JavaElement createJavaElement()
  {
    JavaElementImpl javaElement = new JavaElementImpl();
    return javaElement;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Callout createCallout()
  {
    CalloutImpl callout = new CalloutImpl();
    return callout;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ExternalTarget createExternalTarget()
  {
    ExternalTargetImpl externalTarget = new ExternalTargetImpl();
    return externalTarget;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Section createSection()
  {
    SectionImpl section = new SectionImpl();
    return section;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Text createText()
  {
    TextImpl text = new TextImpl();
    return text;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Link createLink()
  {
    LinkImpl link = new LinkImpl();
    return link;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Embedding createEmbedding()
  {
    EmbeddingImpl embedding = new EmbeddingImpl();
    return embedding;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public SourceCode createSourceCode()
  {
    SourceCodeImpl sourceCode = new SourceCodeImpl();
    return sourceCode;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Plugin createPlugin()
  {
    PluginImpl plugin = new PluginImpl();
    return plugin;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public JavaPackage createJavaPackage()
  {
    JavaPackageImpl javaPackage = new JavaPackageImpl();
    return javaPackage;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Javadoc createJavadoc()
  {
    JavadocImpl javadoc = new JavadocImpl();
    return javadoc;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ExternalArticle createExternalArticle()
  {
    ExternalArticleImpl externalArticle = new ExternalArticleImpl();
    return externalArticle;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Schemadoc createSchemadoc()
  {
    SchemadocImpl schemadoc = new SchemadocImpl();
    return schemadoc;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ExtensionPoint createExtensionPoint()
  {
    ExtensionPointImpl extensionPoint = new ExtensionPointImpl();
    return extensionPoint;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Toc createToc()
  {
    TocImpl toc = new TocImpl();
    return toc;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public PluginResource createPluginResource()
  {
    PluginResourceImpl pluginResource = new PluginResourceImpl();
    return pluginResource;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Excel createExcel()
  {
    ExcelImpl excel = new ExcelImpl();
    return excel;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public JavaFormatter createJavaFormatter()
  {
    JavaFormatterImpl javaFormatter = new JavaFormatterImpl();
    return javaFormatter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public XmlFormatter createXmlFormatter()
  {
    XmlFormatterImpl xmlFormatter = new XmlFormatterImpl();
    return xmlFormatter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeFormatter createTreeFormatter()
  {
    TreeFormatterImpl treeFormatter = new TreeFormatterImpl();
    return treeFormatter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Image createImage()
  {
    ImageImpl image = new ImageImpl();
    return image;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeNode createTreeNode()
  {
    TreeNodeImpl treeNode = new TreeNodeImpl();
    return treeNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TreeNodeProperty createTreeNodeProperty()
  {
    TreeNodePropertyImpl treeNodeProperty = new TreeNodePropertyImpl();
    return treeNodeProperty;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImageFactory createImageFactory()
  {
    ImageFactoryImpl imageFactory = new ImageFactoryImpl();
    return imageFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Key createKey()
  {
    KeyImpl key = new KeyImpl();
    return key;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Selection createSelection()
  {
    SelectionImpl selection = new SelectionImpl();
    return selection;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ImageFormatter createImageFormatter()
  {
    ImageFormatterImpl imageFormatter = new ImageFormatterImpl();
    return imageFormatter;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Description createDescription()
  {
    DescriptionImpl description = new DescriptionImpl();
    return description;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public File createFileFromString(EDataType eDataType, String initialValue)
  {
    return (File)super.createFromString(eDataType, initialValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public String convertFileToString(EDataType eDataType, Object instanceValue)
  {
    return super.convertToString(eDataType, instanceValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public ArticlePackage getArticlePackage()
  {
    return (ArticlePackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static ArticlePackage getPackage()
  {
    return ArticlePackage.eINSTANCE;
  }

} // ArticleFactoryImpl
