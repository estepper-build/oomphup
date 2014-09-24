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
import org.eclipse.oomph.releng.doc.article.util.ArticleException;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.sun.javadoc.SeeTag;

import java.io.File;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Formatter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.TreeFormatterImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeFormatterImpl extends FormatterImpl implements TreeFormatter
{
  private static final String NL = LinkTargetImpl.NL;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TreeFormatterImpl()
  {
    super();
  }

  TreeFormatterImpl(File file)
  {
    setFile(file);
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
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        return getFile();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.TREE_FORMATTER__FILE:
        setFile((File)newValue);
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
    result.append(')');
    return result.toString();
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
        "  e.style.display = (e.style.display == \"\" ? \"none\" : \"\");" + NL + //
        "  img = document.getElementById(\"img_\" + id);" + NL + //
        "  img.src = (e.style.display == \"none\" ? \"" + images + "/plus.gif\" : \"" + images + "/minus.gif\");" + NL + //
        "}" + NL + //
        "</script>");
  }

  public String getDefaultTitle(SeeTag embedderTag)
  {
    return file.getName();
  }

  public String getSnippetHtml(PrintWriter out, Embedding embedder, String id, String title)
  {
    StringBuilder builder = new StringBuilder();
    write(builder, "          </code>" + NL);

    ResourceSet resourceSet = new ResourceSetImpl();
    Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    map.put(TYPE, new XMIResourceFactoryImpl());

    Resource resource = resourceSet.getResource(URI.createFileURI(file.getAbsolutePath()), true);
    TreeNode root = (TreeNode)resource.getContents().get(0);

    AtomicInteger idCounter = new AtomicInteger();
    generateTree(builder, embedder, idCounter, 0, root);

    write(builder, "          <code>" + NL);
    return builder.toString();
  }

  public String getCalloutMarker()
  {
    return null;
  }

  @Override
  protected String getFormatterType()
  {
    return TYPE;
  }

  private int getEmbeddingIndex(Embedding embedder)
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

  private void generateTree(StringBuilder builder, Embedding embedder, AtomicInteger idCounter, int level, TreeNode node)
  {
    String icon = node.getImage();
    String label = node.getLabel();
    String href = null;

    EList<TreeNode> children = node.getChildren();
    if (children.isEmpty())
    {
      writeSingle(builder, embedder, level, icon, label, href);
    }
    else
    {
      writeGroupStart(builder, embedder, idCounter, level, icon, label, href);
      for (TreeNode child : children)
      {
        generateTree(builder, embedder, idCounter, level + 1, child);
      }

      writeGroupEnd(builder, level);
    }
  }

  private void writeSingle(StringBuilder builder, Embedding embedder, int level, String icon, String label, String href)
  {
    writeIndent(builder, level);
    write(builder, "<div class=\"te\"><span>");
    writeImage(builder, embedder.getBody().getImagePath() + "/empty.gif");
    writeImage(builder, icon);
    write(builder, " ");
    writeHref(builder, level, label, href);
    write(builder, "</span></div>" + NL);
  }

  private void writeGroupStart(StringBuilder builder, Embedding embedder, AtomicInteger idCounter, int level, String icon, String label, String href)
  {
    Body body = embedder.getBody();
    String path = body.getPath();
    String prefix = path.endsWith(".html") ? "node" : path;

    int index = getEmbeddingIndex(embedder);
    if (index != 0)
    {
      prefix += "_" + index;
    }

    String id = prefix + "_" + idCounter.incrementAndGet();

    writeIndent(builder, level);
    write(builder, "<div class=\"te\">");
    write(builder, "<span><a href=\"javascript:toggle('" + id + "')\">");
    write(builder, "<img src=\"" + body.getImagePath() + "/plus.gif\" id=\"img_" + id + "\">");
    write(builder, "</a>");
    writeImage(builder, icon);
    write(builder, " ");
    writeHref(builder, level, label, href);
    write(builder, "</span></div>" + NL);
    writeIndent(builder, level);
    write(builder, "<div id=\"" + id + "\" style=\"display:none; margin-left:20px;\">" + NL);
  }

  private void writeGroupEnd(StringBuilder builder, int level)
  {
    writeIndent(builder, level);
    write(builder, "</div>" + NL);
  }

  private void writeImage(StringBuilder builder, String name)
  {
    if (name == null)
    {
      name = "empty-icon.gif";
    }

    write(builder, "<img src=\"" + name + "\" valign=\"middle\"/>");
  }

  private void writeHref(StringBuilder builder, int level, String label, String href)
  {
    label = label.replaceAll(" ", "&nbsp;");
    // if (level == 0)
    // {
    // label = "<b>" + label + "</b>";
    // }

    if (href == null)
    {
      write(builder, label);
    }
    else
    {
      URI uri = URI.createURI(href);
      // if (uri.isRelative())
      // {
      // href = project.getName() + "/" + href;
      // }

      write(builder, "<a href=\"" + href + "\" target=\"content\">" + label + "</a>");
    }
  }

  private void writeIndent(StringBuilder builder, int level)
  {
    for (int i = 0; i < level; i++)
    {
      write(builder, "  ");
    }
  }

  private void write(StringBuilder builder, String string)
  {
    builder.append(string);
  }

} // TreeFormatterImpl
