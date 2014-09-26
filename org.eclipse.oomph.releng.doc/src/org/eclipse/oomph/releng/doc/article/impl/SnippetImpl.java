/*
 * Copyright (c) 2011, 2012 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.oomph.releng.doc.article.impl;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElementContainer;
import org.eclipse.oomph.releng.doc.article.Callout;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Formatter;
import org.eclipse.oomph.releng.doc.article.Section;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.TreeFormatter;
import org.eclipse.oomph.releng.doc.article.XmlFormatter;
import org.eclipse.oomph.releng.doc.article.util.ArticleException;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import com.sun.javadoc.Doc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.Tag;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Snippet</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl#getCallouts <em>Callouts</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl#getFormatter <em>Formatter</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl#getTitle <em>Title</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.SnippetImpl#getTitleImage <em>Title Image</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SnippetImpl extends EmbeddableElementImpl implements Snippet
{
  public static final String CONTENT_INDENT = "            ";

  private static final Pattern PATTERN = Pattern.compile("<[^>]+?>", Pattern.MULTILINE | Pattern.DOTALL);

  /**
   * The cached value of the '{@link #getCallouts() <em>Callouts</em>}' containment reference list.
   * <!-- begin-user-doc
   * --> <!-- end-user-doc -->
   * @see #getCallouts()
   * @generated
   * @ordered
   */
  protected EList<Callout> callouts;

  /**
   * The cached value of the '{@link #getFormatter() <em>Formatter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFormatter()
   * @generated
   * @ordered
   */
  protected Formatter formatter;

  /**
   * The default value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected static final String TITLE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitle() <em>Title</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitle()
   * @generated
   * @ordered
   */
  protected String title = TITLE_EDEFAULT;

  /**
   * The default value of the '{@link #getTitleImage() <em>Title Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitleImage()
   * @generated
   * @ordered
   */
  protected static final String TITLE_IMAGE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTitleImage() <em>Title Image</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTitleImage()
   * @generated
   * @ordered
   */
  protected String titleImage = TITLE_IMAGE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected SnippetImpl()
  {
    super();
  }

  SnippetImpl(Documentation documentation, Doc doc)
  {
    super(documentation, doc);
    initFormatter(doc);
    initCallouts(doc);

    Tag[] titleTags = doc.tags("@title");
    if (titleTags.length > 1)
    {
      throw new ArticleException("More than one @title tag not allowed: " + ArticleUtil.makeConsoleLink(doc));
    }

    if (titleTags.length == 1)
    {
      String text = titleTags[0].text();
      if (text.length() != 0)
      {
        setTitle(text);
      }
    }

    Tag[] imageTags = doc.tags("@image");
    if (imageTags.length > 1)
    {
      throw new ArticleException("More than one @image tag not allowed: " + ArticleUtil.makeConsoleLink(doc));
    }

    if (imageTags.length == 1)
    {
      String text = imageTags[0].text();
      if (text.length() != 0)
      {
        setTitleImage(text);
      }
    }
  }

  private void initFormatter(Doc doc)
  {
    Tag[] tags = doc.tags("@snippet");
    if (tags.length > 1)
    {
      throw new ArticleException("More than one @snippet tag not allowed: " + ArticleUtil.makeConsoleLink(doc));
    }

    if (tags.length == 1)
    {
      String text = tags[0].text();
      if (text.length() != 0)
      {
        String format;
        String args;

        int pos = text.indexOf(' ');
        if (pos != -1)
        {
          format = text.substring(0, pos).trim().toLowerCase();
          args = text.substring(pos + 1).trim();
        }
        else
        {
          format = text;
          args = "";
        }

        format = format.trim().toLowerCase();
        args = args.trim();

        try
        {
          if (format.equals(XmlFormatter.TYPE))
          {
            File file = getFileArg(doc, args);
            setFormatter(new XmlFormatterImpl(file));
          }
          else if (format.equals(TreeFormatter.TYPE))
          {
            File file = getFileArg(doc, args);
            setFormatter(new TreeFormatterImpl(file));
          }
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }
      }
    }

    if (getFormatter() == null)
    {
      setFormatter(new JavaFormatterImpl());
    }
  }

  private void initCallouts(Doc doc)
  {
    int index = 0;
    for (Tag tag : doc.tags("@callout"))
    {
      new CalloutImpl(this, tag, ++index);
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.SNIPPET;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public EList<Callout> getCallouts()
  {
    if (callouts == null)
    {
      callouts = new EObjectContainmentWithInverseEList<Callout>(Callout.class, this, ArticlePackage.SNIPPET__CALLOUTS, ArticlePackage.CALLOUT__SNIPPET);
    }
    return callouts;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public Formatter getFormatter()
  {
    return formatter;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetFormatter(Formatter newFormatter, NotificationChain msgs)
  {
    Formatter oldFormatter = formatter;
    formatter = newFormatter;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ArticlePackage.SNIPPET__FORMATTER, oldFormatter, newFormatter);
      if (msgs == null)
      {
        msgs = notification;
      }
      else
      {
        msgs.add(notification);
      }
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFormatter(Formatter newFormatter)
  {
    if (newFormatter != formatter)
    {
      NotificationChain msgs = null;
      if (formatter != null)
      {
        msgs = ((InternalEObject)formatter).eInverseRemove(this, ArticlePackage.FORMATTER__SNIPPET, Formatter.class, msgs);
      }
      if (newFormatter != null)
      {
        msgs = ((InternalEObject)newFormatter).eInverseAdd(this, ArticlePackage.FORMATTER__SNIPPET, Formatter.class, msgs);
      }
      msgs = basicSetFormatter(newFormatter, msgs);
      if (msgs != null)
      {
        msgs.dispatch();
      }
    }
    else if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.SNIPPET__FORMATTER, newFormatter, newFormatter));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitle()
  {
    return title;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitle(String newTitle)
  {
    String oldTitle = title;
    title = newTitle;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.SNIPPET__TITLE, oldTitle, title));
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTitleImage()
  {
    return titleImage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTitleImage(String newTitleImage)
  {
    String oldTitleImage = titleImage;
    titleImage = newTitleImage;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.SNIPPET__TITLE_IMAGE, oldTitleImage, titleImage));
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        return ((InternalEList<InternalEObject>)(InternalEList<?>)getCallouts()).basicAdd(otherEnd, msgs);
      case ArticlePackage.SNIPPET__FORMATTER:
        if (formatter != null)
        {
          msgs = ((InternalEObject)formatter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ArticlePackage.SNIPPET__FORMATTER, null, msgs);
        }
        return basicSetFormatter((Formatter)otherEnd, msgs);
    }
    return super.eInverseAdd(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        return ((InternalEList<?>)getCallouts()).basicRemove(otherEnd, msgs);
      case ArticlePackage.SNIPPET__FORMATTER:
        return basicSetFormatter(null, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        return getCallouts();
      case ArticlePackage.SNIPPET__FORMATTER:
        return getFormatter();
      case ArticlePackage.SNIPPET__TITLE:
        return getTitle();
      case ArticlePackage.SNIPPET__TITLE_IMAGE:
        return getTitleImage();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        getCallouts().clear();
        getCallouts().addAll((Collection<? extends Callout>)newValue);
        return;
      case ArticlePackage.SNIPPET__FORMATTER:
        setFormatter((Formatter)newValue);
        return;
      case ArticlePackage.SNIPPET__TITLE:
        setTitle((String)newValue);
        return;
      case ArticlePackage.SNIPPET__TITLE_IMAGE:
        setTitleImage((String)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        getCallouts().clear();
        return;
      case ArticlePackage.SNIPPET__FORMATTER:
        setFormatter((Formatter)null);
        return;
      case ArticlePackage.SNIPPET__TITLE:
        setTitle(TITLE_EDEFAULT);
        return;
      case ArticlePackage.SNIPPET__TITLE_IMAGE:
        setTitleImage(TITLE_IMAGE_EDEFAULT);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case ArticlePackage.SNIPPET__CALLOUTS:
        return callouts != null && !callouts.isEmpty();
      case ArticlePackage.SNIPPET__FORMATTER:
        return formatter != null;
      case ArticlePackage.SNIPPET__TITLE:
        return TITLE_EDEFAULT == null ? title != null : !TITLE_EDEFAULT.equals(title);
      case ArticlePackage.SNIPPET__TITLE_IMAGE:
        return TITLE_IMAGE_EDEFAULT == null ? titleImage != null : !TITLE_IMAGE_EDEFAULT.equals(titleImage);
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
    result.append(" (title: ");
    result.append(title);
    result.append(", titleImage: ");
    result.append(titleImage);
    result.append(')');
    return result.toString();
  }

  public void generate(PrintWriter out, Embedding embedder) throws IOException
  {
    Formatter formatter = getFormatter();

    String snippetID = getDoc().name();
    int lastDot = snippetID.lastIndexOf('.');
    if (lastDot != -1)
    {
      snippetID = snippetID.substring(lastDot + 1);
    }

    SeeTag embedderTag = (SeeTag)embedder.getTag();
    String title = embedderTag.label();
    if (title == null || title.length() == 0)
    {
      title = getTitle();
    }

    if (title == null || title.length() == 0)
    {
      title = formatter.getDefaultTitle(embedderTag);
    }

    StructuralElement structuralElement = getStructuralElement(embedder);
    String imagePath = structuralElement.getImagePath() + "/";

    String editorIcon = getTitleImage();
    if (editorIcon == null || editorIcon.length() == 0)
    {
      int dot = title.lastIndexOf('.');
      if (dot != -1)
      {
        String icon = title.substring(dot + 1);
        if (icon.length() != 0)
        {
          icon += ".gif";
          String iconPath = imagePath + "editors/" + icon;

          File iconFile = new File(structuralElement.getOutputFile().getParentFile(), iconPath);
          if (iconFile.isFile())
          {
            editorIcon = iconPath;
          }
        }
      }

      if (editorIcon == null || editorIcon.length() == 0)
      {
        editorIcon = formatter.getTopLeftEditorIcon(imagePath);
      }
    }
    else
    {
      editorIcon = rewritePath(editorIcon, embedder);
    }

    out.write(NL);
    out.write(NL);

    String[] snippets = formatter.getSnippetHtml(embedder, snippetID, title);
    String html = snippets[0];
    html = processCallouts(snippetID, html, imagePath);
    html = getEditorHtml(imagePath, snippetID, title, editorIcon, html, 600, 300);

    out.write(html);
    for (int i = 1; i < snippets.length; i++)
    {
      String extraSnippet = snippets[i];
      out.write(extraSnippet);
    }

    EList<Callout> callouts = getCallouts();
    if (!callouts.isEmpty())
    {
      out.write("<p>" + NL);
      for (Callout callout : callouts)
      {
        String image = getCalloutImage(imagePath, snippetID, callout.getIndex(), false, "Jump to snippet...");
        out.write("<div style=\"margin-left:24px;\">" + image + "&nbsp;");

        try
        {
          BodyElementContainerImpl.generate(out, structuralElement, callout.getElements());
        }
        catch (IOException ex)
        {
          ex.printStackTrace();
        }

        out.write("</div>" + NL);
      }
    }

    out.write("<p>" + NL);
  }

  private String processCallouts(String snippetID, String html, String imagePath)
  {
    EList<Callout> callouts = getCallouts();
    int size = callouts.size();
    int callout = 0;

    String calloutMarker = getFormatter().getCalloutMarker();
    if (calloutMarker != null)
    {
      for (;;)
      {
        int pos = html.indexOf(calloutMarker);
        if (pos == -1)
        {
          break;
        }

        ++callout;

        String start = html.substring(0, pos);
        String rest = html.substring(pos + calloutMarker.length());
        if (!rest.startsWith("&nbsp;"))
        {
          rest = "&nbsp;" + rest;
        }

        String alt = "";
        int index = callout - 1;
        if (index < size)
        {
          Tag tag = callouts.get(index).getTag();
          for (Tag inlineTag : tag.inlineTags())
          {
            alt += inlineTag.text();
          }
        }

        String image = getCalloutImage(imagePath, snippetID, callout, true, alt);
        html = start + image + rest;
      }

      if (callout != size)
      {
        if (callout < size)
        {
          Tag tag = callouts.get(size).getTag();
          String link = ArticleUtil.makeConsoleLink(tag.holder(), tag.position());
          System.err.println("Too many callout descriptions: " + link);
        }
        else
        {
          String link = ArticleUtil.makeConsoleLink(getDoc(), getDoc().position());
          System.err.println("Callout descriptions missing: " + link);
        }
      }
    }

    return html;
  }

  private static String getCalloutImage(String imagePath, String prefix, int number, boolean code, String alt)
  {
    String name = "callout_" + prefix + "_" + number;
    String nameSuffix = code ? "_code" : "";
    String hrefSuffix = code ? "" : "_code";

    String image = "<img src=\"" + imagePath + "callout-" + number + ".png\" width=\"16\" height=\"16\" border=\"0\" align=\"top\">";

    alt = PATTERN.matcher(alt).replaceAll("");
    alt = alt.replaceAll("\"", "&quot;");

    return "<a name=\"" + name + nameSuffix + "\" href=\"#" + name + hrefSuffix + "\" alt=\"" + alt + "\" title=\"" + alt + "\">" + image + "</a>";
  }

  private static StructuralElement getStructuralElement(Embedding embedder)
  {
    BodyElementContainer container = embedder.getContainer();
    if (container instanceof StructuralElement)
    {
      return (StructuralElement)container;
    }

    if (container instanceof Section)
    {
      return ((Section)container).getChapter();
    }

    throw new ArticleException(ArticleUtil.makeConsoleLink("Nested embedding in ", embedder.getTag().position()));
  }

  private static File getFileArg(Doc doc, String args) throws IOException
  {
    int firstSpace = args.indexOf(' ');
    if (firstSpace != -1)
    {
      args = args.substring(0, firstSpace);
    }

    File folder = doc.position().file().getParentFile();
    return new File(folder, args).getCanonicalFile();
  }

  public void addHeaders(Set<String> headers, Embedding embedder)
  {
    headers.add("<link rel=\"stylesheet\" href=\"" + embedder.getBody().getHtmlPath() + "editor.css\" charset=\"UTF-8\" type=\"text/css\">");
    headers.add("<script src=\"http://code.jquery.com/jquery-1.11.1.min.js\"></script>");
    headers.add("<script src=\"http://code.jquery.com/ui/1.11.0/jquery-ui.min.js\"></script>");
    headers.add("<link rel=\"stylesheet\" href=\"http://code.jquery.com/ui/1.11.1/themes/smoothness/jquery-ui.css\">");
    headers.add("<script>" + NL + "$(function() {" + NL + "$( \".resizable\" ).resizable({ handles:\"s,e,se\", autoHide:true });" + NL + "});" + NL
        + "</script>");

    headers.add("<script type=\"text/javascript\">" + NL + //
        "function maximize(id)" + NL + //
        "{" + NL + //
        "  e = document.getElementById('max_' + id);" + NL + //
        "  c1 = document.getElementById('editor_content_1_' + id);" + NL + //
        "  c2 = document.getElementById('editor_content_2_' + id);" + NL + //
        "  pv = document.getElementById('max_pv_' + id);" + NL + //
        "  if (e.className == 'max')" + NL + //
        "  {" + NL + //
        "    e.className = 'rst';" + NL + //
        "    e.setAttribute('title', 'Restore');" + NL + //
        "    c1.setAttribute('style_orig', c1.getAttribute('style'));" + NL + //
        "    c1.setAttribute('style', 'border:2px solid #99b4d1; border-top:none;');" + NL + //
        "    c2.setAttribute('style', '');" + NL + //
        "    if (pv != null)" + NL + //
        "    {" + NL + //
        "      pv.setAttribute('width_orig', pv.getAttribute('width'));" + NL + //
        "      pv.setAttribute('width', '');" + NL + //
        "    }" + NL + //
        "  }" + NL + //
        "  else" + NL + //
        "  {" + NL + //
        "    e.className = 'max';" + NL + //
        "    e.setAttribute('title', 'Maximize');" + NL + //
        "    c1.setAttribute('style', c1.getAttribute('style_orig'));" + NL + //
        "    c1.setAttribute('style_orig', '');" + NL + //
        "    c2.setAttribute('style', 'overflow:scroll; width:100%; height:100%;');" + NL + //
        "    if (pv != null)" + NL + //
        "    {" + NL + //
        "      pv.setAttribute('width', pv.getAttribute('width_orig'));" + NL + //
        "      pv.setAttribute('width_orig', '');" + NL + //
        "    }" + NL + //
        "  }" + NL + //
        "}" + NL + //
        "</script>");

    Formatter formatter = getFormatter();
    formatter.addHeaders(headers, embedder, this);
  }

  public static String getEditorHtml(String imagePath, String id, String title, String editorIcon, String content, int contentWidth, int contentHeight)
  {
    StringBuilder builder = new StringBuilder();

    builder.append("<div class=\"snippet\" style=\"margin-left:24px;\" align=\"left\">" + NL);
    builder.append("  <a name=\"snippet_" + id + "\"></a>" + NL);
    builder.append("  <table border=\"0\" cellspacing=\"0\" cellpadding=\"0\">" + NL);
    builder.append("    <tr>" + NL);
    builder.append("      <td width=\"25px\"><div style=\"position:relative;\"><img src=\"" + imagePath
        + "editor-1.png\"><img style=\"position:absolute; top:5px; left:5px;\" src=\"" + editorIcon + "\"></div></td>" + NL);
    builder.append("      <td style=\"background-image:url(" + imagePath
        + "editor-2.png); background-repeat:repeat-x;\" width=\"1px\"><font face=\"Segoe UI,Arial\" size=\"-1\">" + title + "</font></td>" + NL);
    builder.append("      <td width=\"1px\"><img src=\"" + imagePath + "editor-3.png\"></td>" + NL);
    builder.append("      <td style=\"background-image:url(" + imagePath + "editor-4.png); background-repeat:repeat-x;\" align=\"right\"></td>" + NL);
    builder.append("      <td style=\"background-image:url(" + imagePath + "editor-4.png); background-repeat:repeat-x;\" align=\"center\" width=\"16\">" //
        + "<a href=\"javascript:maximize('" + id + "')\" id=\"max_" + id + "\" class=\"max\" title=\"Maximize\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></td>" + NL);
    builder.append("      <td width=\"6px\"><img src=\"" + imagePath + "editor-5.png\"></td>" + NL);
    builder.append("    </tr>" + NL);

    builder.append("    <tr>" + NL);
    builder.append("      <td colspan=\"6\" align=\"left\" valign=\"top\" style=\"border:1px solid #a0a0a0; border-top:none;\" nowrap>" + NL);
    builder.append("        <div id=\"editor_content_1_" + id + "\" class=\"ui-widget-content resizable\" style=\"width:" + contentWidth + "px; height:"
        + contentHeight + "px; border:2px solid #99b4d1; border-top:none;\">" + NL);
    builder.append("          <div id=\"editor_content_2_" + id + "\" style=\"overflow:scroll; width:100%; height:100%;\">" + NL);
    builder.append(content);
    builder.append("" + NL);
    builder.append("          </div>" + NL);
    builder.append("        </div>" + NL);
    builder.append("      </td>" + NL);
    builder.append("    </tr>" + NL);
    builder.append("  </table>" + NL);
    builder.append("</div>" + NL);

    return builder.toString();
  }
} // SnippetImpl
