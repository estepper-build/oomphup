/**
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.HtmlFormatter;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import com.sun.javadoc.SeeTag;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Html Formatter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.HtmlFormatterImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HtmlFormatterImpl extends FormatterImpl implements HtmlFormatter
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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected HtmlFormatterImpl()
  {
    super();
  }

  HtmlFormatterImpl(Snippet snippet, String args)
  {
    super(snippet);

    if (args.length() > 0)
    {
      File file = getFileArg(args);
      setFile(file);
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.HTML_FORMATTER;
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
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.HTML_FORMATTER__FILE, oldFile, file));
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
      case ArticlePackage.HTML_FORMATTER__FILE:
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
      case ArticlePackage.HTML_FORMATTER__FILE:
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
      case ArticlePackage.HTML_FORMATTER__FILE:
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
      case ArticlePackage.HTML_FORMATTER__FILE:
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
  protected String getFormatterType()
  {
    return TYPE;
  }

  public String getDefaultTitle(SeeTag embedderTag)
  {
    return "";
  }

  public String getCalloutMarker()
  {
    return null;
  }

  @Override
  public void addHeaders(Set<String> headers, Embedding embedder, Snippet snippet)
  {
    super.addHeaders(headers, embedder, snippet);
  }

  public String[] getSnippetHtml(Embedding embedder, String embeddingID, String title)
  {
    File file = getFile();
    if (file != null)
    {
      URI fileURI = URI.createFileURI(file.getAbsolutePath());
      List<String> imageURIs = ArticleUtil.readLines(file, "UTF-8");

      Snippet snippet = getSnippet();
      String style = ArticleUtil.getTagText(snippet.getDoc(), "@style");
      URI docFileURI = URI.createFileURI(snippet.getDoc().position().file().toString());
    }

    StringBuilder result = new StringBuilder();

    // resolvedImageURIs = new ArrayList<URI>();
    // for (String imageURI : imageURIs)
    // {
    // if (imageURI.length() == 0)
    // {
    // resolvedImageURIs.add(URI.createURI(""));
    // }
    // else
    // {
    // URI uri = URI.createURI(imageURI).resolve(fileURI).deresolve(docFileURI, true, true, false);
    // String path = snippet.rewritePath(uri.toFileString(), embedder);
    // resolvedImageURIs.add(URI.createURI(path));
    // }
    // }
    //
    // StringBuilder result = new StringBuilder();
    // String titleURI = resolvedImageURIs.get(0).toFileString();
    // if (titleURI.length() != 0)
    // {
    // result.append("<div ");
    // if (style != null)
    // {
    // result.append("class=\"" + style + "\" ");
    // }
    //
    // result.append("style=\"display: inline-block\"><img src=\"");
    // String path = snippet.rewritePath(titleURI, embedder);
    // result.append(path);
    // result.append("\"/></div>");
    // }

    // return title == null || title.length() == 0 ? new String[] { null, result.toString() } : new String[] { null, result.toString(), "<p>" + title + "<br/>"
    // };

    return new String[] { null };
  }

  @Override
  public String[] getCalloutGroupHtml(Embedding embedder, String embeddingID, String title)
  {
    return new String[] { "<table class=\"bullets\">", "</table>" };
  }

  @Override
  public String[] getCalloutItemHtml(Embedding embedder, String embeddingID, int index)
  {
    return new String[] { "<tr>", "</tr>" };
  }

  @Override
  public String[] getCalloutBodyHtml(Embedding embedder, String embeddingID, int index)
  {
    return new String[] { "<td>", "</td>" };
  }

  @Override
  public String getCalloutImageHtml(Embedding embedder, String embeddingID, int index)
  {
    return null;

    // return "<td><img src=\"" + resolvedImageURIs.get(index).toString() + "\"/></td>";
  }
} // HtmlFormatterImpl
