/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Body;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Chapter;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.TreeFormatter;
import org.eclipse.oomph.releng.doc.article.TreeNode;
import org.eclipse.oomph.releng.doc.article.TreeNodeProperty;
import org.eclipse.oomph.releng.doc.article.util.ArticleException;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.sun.javadoc.SeeTag;
import com.sun.javadoc.Tag;

import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Formatter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl#getExpandTo <em>Expand To</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl#getExpanded <em>Expanded</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl#getSelected <em>Selected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeFormatterImpl extends FormatterImpl implements TreeFormatter
{
  /**
   * The default value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final File FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected File file = FILE_EDEFAULT;

  /**
   * The default value of the '{@link #getExpandTo() <em>Expand To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpandTo()
   * @generated
   * @ordered
   */
  protected static final int EXPAND_TO_EDEFAULT = -1;

  /**
   * The cached value of the '{@link #getExpandTo() <em>Expand To</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpandTo()
   * @generated
   * @ordered
   */
  protected int expandTo = EXPAND_TO_EDEFAULT;

  /**
   * The cached value of the '{@link #getExpanded() <em>Expanded</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpanded()
   * @generated
   * @ordered
   */
  protected EList<String> expanded;

  /**
   * The default value of the '{@link #getSelected() <em>Selected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelected()
   * @generated
   * @ordered
   */
  protected static final String SELECTED_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getSelected() <em>Selected</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSelected()
   * @generated
   * @ordered
   */
  protected String selected = SELECTED_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeFormatterImpl()
  {
    super();
  }

  TreeFormatterImpl(Snippet snippet, String args)
  {
    super(snippet);

    File file = getFileArg(args);
    setFile(file);

    String expandTo = ArticleUtil.getTagText(snippet.getDoc(), "@expandTo");
    if (expandTo != null && expandTo.length() != 0)
    {
      setExpandTo(Integer.parseInt(expandTo));
    }

    EList<String> expanded = getExpanded();
    for (Tag tag : snippet.getDoc().tags("@expanded"))
    {
      expanded.add(tag.text());
    }

    setSelected(ArticleUtil.getTagText(snippet.getDoc(), "@selected"));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.TREE_FORMATTER;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public File getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFile(File newFile)
  {
    File oldFile = file;
    file = newFile;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_FORMATTER__FILE, oldFile, file));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getExpandTo()
  {
    return expandTo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpandTo(int newExpandTo)
  {
    int oldExpandTo = expandTo;
    expandTo = newExpandTo;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_FORMATTER__EXPAND_TO, oldExpandTo, expandTo));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getExpanded()
  {
    if (expanded == null)
    {
      expanded = new EDataTypeUniqueEList<String>(String.class, this, ArticlePackage.TREE_FORMATTER__EXPANDED);
    }
    return expanded;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getSelected()
  {
    return selected;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSelected(String newSelected)
  {
    String oldSelected = selected;
    selected = newSelected;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.TREE_FORMATTER__SELECTED, oldSelected, selected));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        return getFile();
      case ArticlePackage.TREE_FORMATTER__EXPAND_TO:
        return getExpandTo();
      case ArticlePackage.TREE_FORMATTER__EXPANDED:
        return getExpanded();
      case ArticlePackage.TREE_FORMATTER__SELECTED:
        return getSelected();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        setFile((File)newValue);
        return;
      case ArticlePackage.TREE_FORMATTER__EXPAND_TO:
        setExpandTo((Integer)newValue);
        return;
      case ArticlePackage.TREE_FORMATTER__EXPANDED:
        getExpanded().clear();
        getExpanded().addAll((Collection<? extends String>)newValue);
        return;
      case ArticlePackage.TREE_FORMATTER__SELECTED:
        setSelected((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        setFile(FILE_EDEFAULT);
        return;
      case ArticlePackage.TREE_FORMATTER__EXPAND_TO:
        setExpandTo(EXPAND_TO_EDEFAULT);
        return;
      case ArticlePackage.TREE_FORMATTER__EXPANDED:
        getExpanded().clear();
        return;
      case ArticlePackage.TREE_FORMATTER__SELECTED:
        setSelected(SELECTED_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
      case ArticlePackage.TREE_FORMATTER__EXPAND_TO:
        return expandTo != EXPAND_TO_EDEFAULT;
      case ArticlePackage.TREE_FORMATTER__EXPANDED:
        return expanded != null && !expanded.isEmpty();
      case ArticlePackage.TREE_FORMATTER__SELECTED:
        return SELECTED_EDEFAULT == null ? selected != null : !SELECTED_EDEFAULT.equals(selected);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy())
    {
      return super.toString();
    }

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (file: ");
    result.append(file);
    result.append(", expandTo: ");
    result.append(expandTo);
    result.append(", expanded: ");
    result.append(expanded);
    result.append(", selected: ");
    result.append(selected);
    result.append(')');
    return result.toString();
  }

  @Override
  protected String getFormatterType()
  {
    return TYPE;
  }

  @Override
  public void addHeaders(Set<String> headers, Embedding embedder, Snippet snippet)
  {
    super.addHeaders(headers, embedder, snippet);
    String images = embedder.getBody().getImagePath();

    headers.add("<script type=\"text/javascript\">" + NL + //
        "function toggle(id)" + NL + //
        "{" + NL + //
        "  e = document.getElementById(id);" + NL + //
        "  e.style.display = (e.style.display == '' ? 'none' : '');" + NL + //
        "  img = document.getElementById('img_' + id);" + NL + //
        "  img.src = (e.style.display == 'none' ? '" + images + "/plus.gif' : '" + images + "/minus.gif');" + NL + //
        "}" + NL + //
        "</script>");

    headers.add("<script type=\"text/javascript\">" + NL + //
        "function select(selectionDiv, id)" + NL + //
        "{" + NL + //
        "  s = document.getElementById(selectionDiv);" + NL + //
        "  if (s.textContent)" + NL + //
        "  {" + NL + //
        "    e = document.getElementById('href_' + s.textContent);" + NL + //
        "    e.className = 'nosel';" + NL + //
        "    e = document.getElementById('pk_' + s.textContent);" + NL + //
        "    if (e != null) e.style.display = 'none';" + NL + //
        "    e = document.getElementById('pv_' + s.textContent);" + NL + //
        "    if (e != null) e.style.display = 'none';" + NL + //
        "  }" + NL + //
        "  e = document.getElementById('href_' + id);" + NL + //
        "  e.className = 'sel';" + NL + //
        "  e = document.getElementById('pk_' + id);" + NL + //
        "  if (e != null) e.style.display = '';" + NL + //
        "  e = document.getElementById('pv_' + id);" + NL + //
        "  if (e != null) e.style.display = '';" + NL + //
        "  s.textContent = id;" + NL + //
        "}" + NL + //
        "</script>");

    headers.add("<link rel=\"stylesheet\" href=\"" + embedder.getBody().getHtmlPath() + "tree.css\" charset=\"UTF-8\" type=\"text/css\">");
  }

  public String getDefaultTitle(SeeTag embedderTag)
  {
    return file.getName();
  }

  public String getCalloutMarker()
  {
    return null;
  }

  public String[] getSnippetHtml(Embedding embedder, String id, String title)
  {
    int embeddingIndex = getEmbeddingIndex(embedder);
    String selectionDiv = "selection_" + id + "_" + embeddingIndex;

    Builder pkBuilder = new PropertyKeysBuilder(embedder, embeddingIndex, null);
    Builder pvBuilder = new PropertyValuesBuilder(embedder, embeddingIndex, null);

    Builder builder = new Builder(embedder, embeddingIndex, selectionDiv);
    TreeNode root = getRootNode(); // TODO What about multiple roots?

    int expandTo = getExpandTo();
    if (expandTo == EXPAND_TO_EDEFAULT)
    {
      expandTo = Integer.MAX_VALUE;
    }

    Set<String> expandedIDs = new HashSet<String>(getExpanded());
    Set<TreeNode> expandedNodes = new HashSet<TreeNode>();
    initExpandedNodes(expandedIDs, expandedNodes, root, expandTo, 0);

    TreeNode selectedNode = initSelection(getSelected(), root);
    if (selectedNode == null)
    {
      selectedNode = root;
    }

    initExpandedNodeParents(expandedNodes, selectedNode);

    generateTreeNode(builder, pkBuilder, pvBuilder, expandedNodes, selectedNode, root);

    String imagePath = builder.getImagePath();
    String content = "<table border=\"0\" cellspacing=\"0\" cellpadding=\"0\"><tr><td>" + pkBuilder + "</td><td id=\"max_pv_" + id
        + "_properties\" width=\"100%\">" + pvBuilder + "</td></tr></table>";
    String propertiesHtml = SnippetImpl.getEditorHtml(imagePath, id + "_properties", "Properties", imagePath + "formatter-tree-properties.gif", content, 600,
        100);

    String selection = "";
    builder.append("          <div id=\"" + selectionDiv + "\" style=\"display:none;\">" + selection + "</div>" + NL);
    return new String[] { builder.toString(), "          <br>" + NL + propertiesHtml };
  }

  private void initExpandedNodeParents(Set<TreeNode> expandedNodes, TreeNode node)
  {
    for (;;)
    {
      EObject container = node.eContainer();
      if (container instanceof TreeNode)
      {
        TreeNode parentNode = (TreeNode)container;
        expandedNodes.add(parentNode);
        node = parentNode;
      }
      else
      {
        break;
      }
    }
  }

  private TreeNode getRootNode()
  {
    ResourceSet resourceSet = new ResourceSetImpl();
    Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put(TYPE, new XMIResourceFactoryImpl());

    Resource resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
    return (TreeNode)resource.getContents().get(0);
  }

  private void initExpandedNodes(Set<String> expandedIDs, Set<TreeNode> expandedNodes, TreeNode node, int expandTo, int level)
  {
    if (level < expandTo)
    {
      expandedNodes.add(node);
    }
    else
    {
      String id = node.getXmi_ID();
      if (expandedIDs.contains(id))
      {
        if (expandedNodes.add(node))
        {
          initExpandedNodeParents(expandedNodes, node);
        }
      }
    }

    for (TreeNode child : node.getChildren())
    {
      initExpandedNodes(expandedIDs, expandedNodes, child, expandTo, level + 1);
    }
  }

  private TreeNode initSelection(String selectedID, TreeNode node)
  {
    if (selectedID == null)
    {
      return node;
    }

    String id = node.getXmi_ID();
    if (selectedID.equals(id))
    {
      return node;
    }

    for (TreeNode child : node.getChildren())
    {
      TreeNode result = initSelection(selectedID, child);
      if (result != null)
      {
        return result;
      }
    }

    return null;
  }

  public int getEmbeddingIndex(Embedding embedder)
  {
    int index = 0;

    Body body = embedder.getBody();
    for (BodyElement element : body.getElements())
    {
      if (element instanceof Embedding)
      {
        ++index;
      }

      if (element == embedder)
      {
        return index;
      }
    }

    if (body instanceof Chapter)
    {
      Chapter chapter = (Chapter)body;
      for (Section section : chapter.getSections())
      {
        for (BodyElement element : section.getElements())
        {
          if (element instanceof Embedding)
          {
            ++index;
          }

          if (element == embedder)
          {
            return index;
          }
        }
      }
    }

    throw new ArticleException("Embedding not found: " + embedder.getTag().text());
  }

  private String generateTreeNode(Builder builder, Builder pkBuilder, Builder pvBuilder, Set<TreeNode> expandedNodes, TreeNode selectedNode, TreeNode node)
  {
    String id;

    boolean selected = node == selectedNode;
    String label = node.getLabel();
    String icon = node.getImage();
    if (icon != null)
    {
      icon = getSnippet().rewritePath(icon, builder.getEmbedder());
    }

    EList<TreeNode> children = node.getChildren();
    if (children.isEmpty())
    {
      id = builder.appendSingle(icon, label);
    }
    else
    {
      boolean expanded = expandedNodes.contains(node);
      id = builder.appendGroupStart(icon, label, expanded);

      for (TreeNode child : children)
      {
        generateTreeNode(builder, pkBuilder, pvBuilder, expandedNodes, selectedNode, child);
      }

      builder.appendGroupEnd();
    }

    EList<TreeNodeProperty> properties = node.getProperties();
    if (!properties.isEmpty())
    {
      generateTreeNodeProperties(pkBuilder, node, id, selected, properties, true, "pk", "keys");
      generateTreeNodeProperties(pvBuilder, node, id, selected, properties, false, "pv", "values");
    }

    return id;
  }

  private void generateTreeNodeProperties(Builder builder, TreeNode node, String id, boolean visible, EList<TreeNodeProperty> properties, boolean key,
      String idPrefix, String comment)
  {
    builder.appendIndent();
    builder.append("<!-- Property " + comment + " for " + node.getLabel() + " -->" + NL);
    builder.appendIndent();
    builder.append("<div id=\"" + idPrefix + "_" + id + "\"" + (visible ? "" : " style=\"display:none;\"") + ">" + NL);
    ++builder.level;

    for (TreeNodeProperty property : properties)
    {
      generateTreeNodeProperty(builder, node, property, key);
    }

    --builder.level;
    builder.appendIndent();
    builder.append("</div>" + NL);
  }

  private void generateTreeNodeProperty(Builder propertiesBuilder, TreeNode node, TreeNodeProperty property, boolean key)
  {
    String value = property.getValue();
    String label = key ? property.getKey() : value == null ? "" : value;
    String icon = property.getValueImage();
    if (icon != null)
    {
      icon = getSnippet().rewritePath(icon, propertiesBuilder.getEmbedder());
    }

    EList<TreeNodeProperty> children = property.getProperties();
    if (children.isEmpty())
    {
      propertiesBuilder.appendSingle(icon, label);
    }
    else
    {
      propertiesBuilder.appendGroupStart(icon, label, true);

      for (TreeNodeProperty child : children)
      {
        generateTreeNodeProperty(propertiesBuilder, node, child, key);
      }

      propertiesBuilder.appendGroupEnd();
    }
  }

  /**
   * @author Eike Stepper
   */
  private static class Builder
  {
    private final StringBuilder builder = new StringBuilder();

    private final Embedding embedder;

    private final String selectionDiv;

    private final String imagePath;

    private final String idPrefix;

    private int idCounter;

    private int level;

    public Builder(Embedding embedder, int embeddingIndex, String selectionDiv)
    {
      this.embedder = embedder;
      this.selectionDiv = selectionDiv;

      Body body = embedder.getBody();
      imagePath = body.getImagePath() + "/";

      String path = body.getPath();

      idPrefix = path.endsWith(".html") ? "node" : path + (embeddingIndex != 0 ? "_" + embeddingIndex : "");
    }

    public Embedding getEmbedder()
    {
      return embedder;
    }

    public String getImagePath()
    {
      return imagePath;
    }

    public String getIDPrefix()
    {
      return idPrefix;
    }

    public int getLevel()
    {
      return level;
    }

    public String appendSingle(String icon, String label)
    {
      String id = getNextID();

      appendIndent();
      append("<div class=\"" + (selectionDiv == null ? "pe" : "te") + "\">");
      append("<span>");
      appendSingleProlog(icon, id);
      appendHref(label, id);
      append("</span>");
      append("</div>" + NL);

      return id;
    }

    public String appendGroupStart(String icon, String label, boolean expanded)
    {
      String id = getNextID();

      appendIndent();
      append("<div class=\"" + (selectionDiv == null ? "pe" : "te") + "\">");
      append("<span>");
      appendGroupProlog(icon, id, expanded);
      appendHref(label, id);
      append("</span>");
      append("</div>" + NL);
      appendIndent();
      append("<div id=\"" + id + "\" style=\"" + (expanded ? "" : "display:none; ") + "margin-left:" + getGroupMarginLeft() + "px;\">" + NL);

      ++level;
      return id;
    }

    public void appendGroupEnd()
    {
      --level;
      appendIndent();
      append("</div>" + NL);
    }

    public void appendHref(String label, String id)
    {
      label = label.replaceAll(" ", "&nbsp;");

      if (selectionDiv == null || id == null)
      {
        append(label);
      }
      else
      {
        append("<a href=\"javascript:select('" + selectionDiv + "', '" + id + "')\" id=\"href_" + id + "\" class=\"nosel\">" + label + "</a>");
      }
    }

    public void appendIndent()
    {
      append("          ");
      for (int i = 0; i < level; i++)
      {
        append("  ");
      }
    }

    public void append(String string)
    {
      builder.append(string);
    }

    @Override
    public String toString()
    {
      return builder.toString();
    }

    protected void appendEmptyImage(int width, int height)
    {
      String path = getImagePath() + "empty.gif";
      append("<img src=\"" + path + "\" width=\"" + width + "\" height=\"" + height + "\" valign=\"middle\"/>");
    }

    protected void appendIcon(String icon)
    {
      if (icon == null)
      {
        appendEmptyImage(16, 16);
      }
      else
      {
        append("<img src=\"" + icon + "\" width=\"16\" height=\"16\" valign=\"middle\"/>");
      }

      append("&nbsp;");
    }

    protected void appendSingleProlog(String icon, String id)
    {
      appendEmptyImage(16, 16);
      appendIcon(icon);
    }

    protected void appendGroupProlog(String icon, String id, boolean expanded)
    {
      append("<a href=\"javascript:toggle('" + id + "')\">");
      append("<img src=\"" + imagePath + (expanded ? "minus" : "plus") + ".gif\" id=\"img_" + id + "\">");
      append("</a>");
      appendIcon(icon);
    }

    protected int getGroupMarginLeft()
    {
      return 20;
    }

    private String getNextID()
    {
      return idPrefix + "_" + (++idCounter);
    }
  }

  /**
   * @author Eike Stepper
   */
  private static class PropertyKeysBuilder extends Builder
  {
    public PropertyKeysBuilder(Embedding embedder, int embeddingIndex, String selectionDiv)
    {
      super(embedder, embeddingIndex, selectionDiv);
    }

    @Override
    protected void appendIcon(String icon)
    {
      // Do nothing.
    }

    @Override
    protected void appendSingleProlog(String icon, String id)
    {
      appendPrologIndent(getLevel());
    }

    @Override
    protected void appendGroupProlog(String icon, String id, boolean expanded)
    {
      appendPrologIndent(getLevel() - 1);
      super.appendGroupProlog(icon, id, expanded);
    }

    @Override
    protected int getGroupMarginLeft()
    {
      return 0;
    }

    private void appendPrologIndent(int level)
    {
      appendEmptyImage(1 + 16 * level, 16);
    }
  }

  /**
   * @author Eike Stepper
   */
  private static class PropertyValuesBuilder extends Builder
  {
    public PropertyValuesBuilder(Embedding embedder, int embeddingIndex, String selectionDiv)
    {
      super(embedder, embeddingIndex, selectionDiv);
    }

    @Override
    protected void appendSingleProlog(String icon, String id)
    {
      appendEmptyImage(4, 16);
      appendIcon(icon);
    }

    @Override
    protected void appendGroupProlog(String icon, String id, boolean expanded)
    {
      appendSingleProlog(icon, id);
    }

    @Override
    protected int getGroupMarginLeft()
    {
      return 0;
    }
  }
} // TreeFormatterImpl
