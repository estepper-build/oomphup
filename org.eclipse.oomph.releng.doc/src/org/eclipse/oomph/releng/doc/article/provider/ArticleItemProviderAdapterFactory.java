/**
 */
package org.eclipse.oomph.releng.doc.article.provider;

import org.eclipse.oomph.releng.doc.article.util.ArticleAdapterFactory;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import java.util.ArrayList;
import java.util.Collection;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ArticleItemProviderAdapterFactory extends ArticleAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable
{
  /**
   * This keeps track of the root adapter factory that delegates to this adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ComposedAdapterFactory parentAdapterFactory;

  /**
   * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IChangeNotifier changeNotifier = new ChangeNotifier();

  /**
   * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected Collection<Object> supportedTypes = new ArrayList<Object>();

  /**
   * This constructs an instance.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArticleItemProviderAdapterFactory()
  {
    supportedTypes.add(IEditingDomainItemProvider.class);
    supportedTypes.add(IStructuredItemContentProvider.class);
    supportedTypes.add(ITreeItemContentProvider.class);
    supportedTypes.add(IItemLabelProvider.class);
    supportedTypes.add(IItemPropertySource.class);
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Documentation} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DocumentationItemProvider documentationItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Documentation}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDocumentationAdapter()
  {
    if (documentationItemProvider == null)
    {
      documentationItemProvider = new DocumentationItemProvider(this);
    }

    return documentationItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Context} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextItemProvider contextItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Context}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createContextAdapter()
  {
    if (contextItemProvider == null)
    {
      contextItemProvider = new ContextItemProvider(this);
    }

    return contextItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Category} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CategoryItemProvider categoryItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Category}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCategoryAdapter()
  {
    if (categoryItemProvider == null)
    {
      categoryItemProvider = new CategoryItemProvider(this);
    }

    return categoryItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Article} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ArticleItemProvider articleItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Article}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createArticleAdapter()
  {
    if (articleItemProvider == null)
    {
      articleItemProvider = new ArticleItemProvider(this);
    }

    return articleItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Chapter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ChapterItemProvider chapterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Chapter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createChapterAdapter()
  {
    if (chapterItemProvider == null)
    {
      chapterItemProvider = new ChapterItemProvider(this);
    }

    return chapterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Snippet} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SnippetItemProvider snippetItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Snippet}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSnippetAdapter()
  {
    if (snippetItemProvider == null)
    {
      snippetItemProvider = new SnippetItemProvider(this);
    }

    return snippetItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Diagram} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DiagramItemProvider diagramItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Diagram}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDiagramAdapter()
  {
    if (diagramItemProvider == null)
    {
      diagramItemProvider = new DiagramItemProvider(this);
    }

    return diagramItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.JavaElement} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaElementItemProvider javaElementItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.JavaElement}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createJavaElementAdapter()
  {
    if (javaElementItemProvider == null)
    {
      javaElementItemProvider = new JavaElementItemProvider(this);
    }

    return javaElementItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Callout} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CalloutItemProvider calloutItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Callout}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createCalloutAdapter()
  {
    if (calloutItemProvider == null)
    {
      calloutItemProvider = new CalloutItemProvider(this);
    }

    return calloutItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.ExternalTarget} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalTargetItemProvider externalTargetItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.ExternalTarget}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExternalTargetAdapter()
  {
    if (externalTargetItemProvider == null)
    {
      externalTargetItemProvider = new ExternalTargetItemProvider(this);
    }

    return externalTargetItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Section} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SectionItemProvider sectionItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Section}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSectionAdapter()
  {
    if (sectionItemProvider == null)
    {
      sectionItemProvider = new SectionItemProvider(this);
    }

    return sectionItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Text} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TextItemProvider textItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Text}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTextAdapter()
  {
    if (textItemProvider == null)
    {
      textItemProvider = new TextItemProvider(this);
    }

    return textItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Link} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected LinkItemProvider linkItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Link}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createLinkAdapter()
  {
    if (linkItemProvider == null)
    {
      linkItemProvider = new LinkItemProvider(this);
    }

    return linkItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Embedding} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EmbeddingItemProvider embeddingItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Embedding}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createEmbeddingAdapter()
  {
    if (embeddingItemProvider == null)
    {
      embeddingItemProvider = new EmbeddingItemProvider(this);
    }

    return embeddingItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.SourceCode} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SourceCodeItemProvider sourceCodeItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.SourceCode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSourceCodeAdapter()
  {
    if (sourceCodeItemProvider == null)
    {
      sourceCodeItemProvider = new SourceCodeItemProvider(this);
    }

    return sourceCodeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Plugin} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PluginItemProvider pluginItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Plugin}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPluginAdapter()
  {
    if (pluginItemProvider == null)
    {
      pluginItemProvider = new PluginItemProvider(this);
    }

    return pluginItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.JavaPackage} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaPackageItemProvider javaPackageItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.JavaPackage}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createJavaPackageAdapter()
  {
    if (javaPackageItemProvider == null)
    {
      javaPackageItemProvider = new JavaPackageItemProvider(this);
    }

    return javaPackageItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Javadoc} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavadocItemProvider javadocItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Javadoc}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createJavadocAdapter()
  {
    if (javadocItemProvider == null)
    {
      javadocItemProvider = new JavadocItemProvider(this);
    }

    return javadocItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.ExternalArticle} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExternalArticleItemProvider externalArticleItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.ExternalArticle}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExternalArticleAdapter()
  {
    if (externalArticleItemProvider == null)
    {
      externalArticleItemProvider = new ExternalArticleItemProvider(this);
    }

    return externalArticleItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Schemadoc} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SchemadocItemProvider schemadocItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Schemadoc}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSchemadocAdapter()
  {
    if (schemadocItemProvider == null)
    {
      schemadocItemProvider = new SchemadocItemProvider(this);
    }

    return schemadocItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.ExtensionPoint} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExtensionPointItemProvider extensionPointItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.ExtensionPoint}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExtensionPointAdapter()
  {
    if (extensionPointItemProvider == null)
    {
      extensionPointItemProvider = new ExtensionPointItemProvider(this);
    }

    return extensionPointItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Toc} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TocItemProvider tocItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Toc}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTocAdapter()
  {
    if (tocItemProvider == null)
    {
      tocItemProvider = new TocItemProvider(this);
    }

    return tocItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.PluginResource} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PluginResourceItemProvider pluginResourceItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.PluginResource}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createPluginResourceAdapter()
  {
    if (pluginResourceItemProvider == null)
    {
      pluginResourceItemProvider = new PluginResourceItemProvider(this);
    }

    return pluginResourceItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Excel} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExcelItemProvider excelItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Excel}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createExcelAdapter()
  {
    if (excelItemProvider == null)
    {
      excelItemProvider = new ExcelItemProvider(this);
    }

    return excelItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.JavaFormatter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaFormatterItemProvider javaFormatterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.JavaFormatter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createJavaFormatterAdapter()
  {
    if (javaFormatterItemProvider == null)
    {
      javaFormatterItemProvider = new JavaFormatterItemProvider(this);
    }

    return javaFormatterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.XmlFormatter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected XmlFormatterItemProvider xmlFormatterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.XmlFormatter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createXmlFormatterAdapter()
  {
    if (xmlFormatterItemProvider == null)
    {
      xmlFormatterItemProvider = new XmlFormatterItemProvider(this);
    }

    return xmlFormatterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.TreeFormatter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeFormatterItemProvider treeFormatterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.TreeFormatter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTreeFormatterAdapter()
  {
    if (treeFormatterItemProvider == null)
    {
      treeFormatterItemProvider = new TreeFormatterItemProvider(this);
    }

    return treeFormatterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Image} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImageItemProvider imageItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Image}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createImageAdapter()
  {
    if (imageItemProvider == null)
    {
      imageItemProvider = new ImageItemProvider(this);
    }

    return imageItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.TreeNode} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeNodeItemProvider treeNodeItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.TreeNode}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTreeNodeAdapter()
  {
    if (treeNodeItemProvider == null)
    {
      treeNodeItemProvider = new TreeNodeItemProvider(this);
    }

    return treeNodeItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeNodePropertyItemProvider treeNodePropertyItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.TreeNodeProperty}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createTreeNodePropertyAdapter()
  {
    if (treeNodePropertyItemProvider == null)
    {
      treeNodePropertyItemProvider = new TreeNodePropertyItemProvider(this);
    }

    return treeNodePropertyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.ImageFactory} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImageFactoryItemProvider imageFactoryItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.ImageFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createImageFactoryAdapter()
  {
    if (imageFactoryItemProvider == null)
    {
      imageFactoryItemProvider = new ImageFactoryItemProvider(this);
    }

    return imageFactoryItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Key} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected KeyItemProvider keyItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Key}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createKeyAdapter()
  {
    if (keyItemProvider == null)
    {
      keyItemProvider = new KeyItemProvider(this);
    }

    return keyItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Selection} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SelectionItemProvider selectionItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Selection}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createSelectionAdapter()
  {
    if (selectionItemProvider == null)
    {
      selectionItemProvider = new SelectionItemProvider(this);
    }

    return selectionItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.ImageFormatter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ImageFormatterItemProvider imageFormatterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.ImageFormatter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createImageFormatterAdapter()
  {
    if (imageFormatterItemProvider == null)
    {
      imageFormatterItemProvider = new ImageFormatterItemProvider(this);
    }

    return imageFormatterItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.Description} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DescriptionItemProvider descriptionItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.Description}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createDescriptionAdapter()
  {
    if (descriptionItemProvider == null)
    {
      descriptionItemProvider = new DescriptionItemProvider(this);
    }

    return descriptionItemProvider;
  }

  /**
   * This keeps track of the one adapter used for all {@link org.eclipse.oomph.releng.doc.article.HtmlFormatter} instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HtmlFormatterItemProvider htmlFormatterItemProvider;

  /**
   * This creates an adapter for a {@link org.eclipse.oomph.releng.doc.article.HtmlFormatter}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter createHtmlFormatterAdapter()
  {
    if (htmlFormatterItemProvider == null)
    {
      htmlFormatterItemProvider = new HtmlFormatterItemProvider(this);
    }

    return htmlFormatterItemProvider;
  }

  /**
   * This returns the root adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ComposeableAdapterFactory getRootAdapterFactory()
  {
    return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
  }

  /**
   * This sets the composed adapter factory that contains this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory)
  {
    this.parentAdapterFactory = parentAdapterFactory;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object type)
  {
    return supportedTypes.contains(type) || super.isFactoryForType(type);
  }

  /**
   * This implementation substitutes the factory itself as the key for the adapter.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Adapter adapt(Notifier notifier, Object type)
  {
    return super.adapt(notifier, this);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object adapt(Object object, Object type)
  {
    if (isFactoryForType(type))
    {
      Object adapter = super.adapt(object, type);
      if (!(type instanceof Class<?>) || ((Class<?>)type).isInstance(adapter))
      {
        return adapter;
      }
    }

    return null;
  }

  /**
   * This adds a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void addListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.addListener(notifyChangedListener);
  }

  /**
   * This removes a listener.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void removeListener(INotifyChangedListener notifyChangedListener)
  {
    changeNotifier.removeListener(notifyChangedListener);
  }

  /**
   * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void fireNotifyChanged(Notification notification)
  {
    changeNotifier.fireNotifyChanged(notification);

    if (parentAdapterFactory != null)
    {
      parentAdapterFactory.fireNotifyChanged(notification);
    }
  }

  /**
   * This disposes all of the item providers created by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void dispose()
  {
    if (documentationItemProvider != null)
    {
      documentationItemProvider.dispose();
    }
    if (contextItemProvider != null)
    {
      contextItemProvider.dispose();
    }
    if (categoryItemProvider != null)
    {
      categoryItemProvider.dispose();
    }
    if (articleItemProvider != null)
    {
      articleItemProvider.dispose();
    }
    if (chapterItemProvider != null)
    {
      chapterItemProvider.dispose();
    }
    if (snippetItemProvider != null)
    {
      snippetItemProvider.dispose();
    }
    if (diagramItemProvider != null)
    {
      diagramItemProvider.dispose();
    }
    if (javaElementItemProvider != null)
    {
      javaElementItemProvider.dispose();
    }
    if (calloutItemProvider != null)
    {
      calloutItemProvider.dispose();
    }
    if (externalTargetItemProvider != null)
    {
      externalTargetItemProvider.dispose();
    }
    if (sectionItemProvider != null)
    {
      sectionItemProvider.dispose();
    }
    if (textItemProvider != null)
    {
      textItemProvider.dispose();
    }
    if (linkItemProvider != null)
    {
      linkItemProvider.dispose();
    }
    if (embeddingItemProvider != null)
    {
      embeddingItemProvider.dispose();
    }
    if (sourceCodeItemProvider != null)
    {
      sourceCodeItemProvider.dispose();
    }
    if (pluginItemProvider != null)
    {
      pluginItemProvider.dispose();
    }
    if (javaPackageItemProvider != null)
    {
      javaPackageItemProvider.dispose();
    }
    if (javadocItemProvider != null)
    {
      javadocItemProvider.dispose();
    }
    if (externalArticleItemProvider != null)
    {
      externalArticleItemProvider.dispose();
    }
    if (schemadocItemProvider != null)
    {
      schemadocItemProvider.dispose();
    }
    if (extensionPointItemProvider != null)
    {
      extensionPointItemProvider.dispose();
    }
    if (tocItemProvider != null)
    {
      tocItemProvider.dispose();
    }
    if (pluginResourceItemProvider != null)
    {
      pluginResourceItemProvider.dispose();
    }
    if (excelItemProvider != null)
    {
      excelItemProvider.dispose();
    }
    if (javaFormatterItemProvider != null)
    {
      javaFormatterItemProvider.dispose();
    }
    if (xmlFormatterItemProvider != null)
    {
      xmlFormatterItemProvider.dispose();
    }
    if (treeFormatterItemProvider != null)
    {
      treeFormatterItemProvider.dispose();
    }
    if (imageItemProvider != null)
    {
      imageItemProvider.dispose();
    }
    if (treeNodeItemProvider != null)
    {
      treeNodeItemProvider.dispose();
    }
    if (treeNodePropertyItemProvider != null)
    {
      treeNodePropertyItemProvider.dispose();
    }
    if (imageFactoryItemProvider != null)
    {
      imageFactoryItemProvider.dispose();
    }
    if (keyItemProvider != null)
    {
      keyItemProvider.dispose();
    }
    if (selectionItemProvider != null)
    {
      selectionItemProvider.dispose();
    }
    if (imageFormatterItemProvider != null)
    {
      imageFormatterItemProvider.dispose();
    }
    if (descriptionItemProvider != null)
    {
      descriptionItemProvider.dispose();
    }
    if (htmlFormatterItemProvider != null)
    {
      htmlFormatterItemProvider.dispose();
    }
  }

}
