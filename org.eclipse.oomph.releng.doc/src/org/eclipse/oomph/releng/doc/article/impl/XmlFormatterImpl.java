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

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.Embedding;
import org.eclipse.oomph.releng.doc.article.Snippet;
import org.eclipse.oomph.releng.doc.article.XmlFormatter;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.emf.ecore.resource.URIConverter;

import com.sun.javadoc.SeeTag;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Xml Formatter</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.XmlFormatterImpl#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class XmlFormatterImpl extends FormatterImpl implements XmlFormatter
{
  private static Pattern TAG_PATTERN = Pattern.compile("(<\\?.*?\\?>)|(<!--[ \t]*callout[ \t]*-->)|(<!--.*?-->)|(<.*?/?>)", Pattern.MULTILINE | Pattern.DOTALL);

  private static Pattern ATTRIBUTE_PATTERN = Pattern.compile("'[^']*?'|\"[^\"]*?\"", Pattern.MULTILINE | Pattern.DOTALL);

  private static final String CALLOUT = "callout";

  private static final String CALLOUT_MARKER = "<!--" + CALLOUT + "-->";

  /**
   * The default value of the '{@link #getFile() <em>File</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
   * -->
   *
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected static final File FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFile() <em>File</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getFile()
   * @generated
   * @ordered
   */
  protected File file = FILE_EDEFAULT;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected XmlFormatterImpl()
  {
    super();
  }

  XmlFormatterImpl(Snippet snippet, String args)
  {
    super(snippet);

    File file = getFileArg(args);
    setFile(file);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.XML_FORMATTER;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public File getFile()
  {
    return file;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public void setFile(File newFile)
  {
    File oldFile = file;
    file = newFile;
    if (eNotificationRequired())
    {
      eNotify(new ENotificationImpl(this, Notification.SET, ArticlePackage.XML_FORMATTER__FILE, oldFile, file));
    }
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
      case ArticlePackage.XML_FORMATTER__FILE:
        return getFile();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case ArticlePackage.XML_FORMATTER__FILE:
        setFile((File)newValue);
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
      case ArticlePackage.XML_FORMATTER__FILE:
        setFile(FILE_EDEFAULT);
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
      case ArticlePackage.XML_FORMATTER__FILE:
        return FILE_EDEFAULT == null ? file != null : !FILE_EDEFAULT.equals(file);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
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

  public String getDefaultTitle(SeeTag embedderTag)
  {
    return file.getName();
  }

  @Override
  protected String getFormatterType()
  {
    return XmlFormatter.TYPE;
  }

  public String[] getSnippetHtml(Embedding embedder, String id, String title)
  {
    try
    {
      String html = getHtml(URI.createFileURI(file.toString()));
      return new String[] { SnippetImpl.CONTENT_INDENT + "<code>" + NL + html + SnippetImpl.CONTENT_INDENT + "</code>" + NL };
    }
    catch (IOException ex)
    {
      return new String[] { "<b><font color=\"#FF0000\">" + ex.getMessage() + "</font></b>" };
    }
  }

  public String getCalloutMarker()
  {
    return CALLOUT_MARKER;
  }

  // public static void main(String[] args) throws Exception
  // {
  // URI uri =
  // URI.createFileURI("D:/sandbox/oomph/git/org.eclipse.oomph/plugins/org.eclipse.oomph.setup.doc/src/org/eclipse/oomph/setup/doc/examples/test.xml");
  // URIConverter.INSTANCE.getContentHandlers().add(new XMLContentHandlerImpl());
  // getHtml(uri);
  // }

  private static String getHtml(URI uri) throws IOException
  {
    Map<String, ?> contentDescription = URIConverter.INSTANCE.contentDescription(uri, null);
    String contents = getContents(uri, (String)contentDescription.get(ContentHandler.CHARSET_PROPERTY));

    Matcher matcher = TAG_PATTERN.matcher(contents);
    StringBuffer result = new StringBuffer();
    while (matcher.find())
    {
      String callout = matcher.group(2);
      if (callout != null)
      {
        append(result, matcher);
        result.append(CALLOUT_MARKER);
      }
      else
      {
        String xmlHeader = matcher.group(1);
        if (xmlHeader != null)
        {
          append(result, matcher);
          result.append("<font color=\"#0000e1\">");
          handleAttributes(result, xmlHeader);
          result.append("</font><font color=\"#000080\">");
        }
        else
        {
          String xmlComment = matcher.group(3);
          if (xmlComment != null)
          {
            append(result, matcher);
            result.append("</font><font color=\"#3f7f5f\">");
            int index = result.length();
            result.append(xmlComment);
            replace(result, index);
            result.append("</font><font color=\"#000080\">");
          }
          else
          {
            String xmlTag = matcher.group(4);
            append(result, matcher);
            result.append("</font><font color=\"#0000e1\">");
            handleAttributes(result, xmlTag);
            result.append("</font><font color=\"#000080\">");
          }
        }
      }
    }

    appendTail(result, matcher);
    result.append("</font>");

    return result.toString();
  }

  public static void handleAttributes(StringBuffer result, String tag)
  {
    Matcher matcher = ATTRIBUTE_PATTERN.matcher(tag);
    while (matcher.find())
    {
      append(result, matcher);
      result.append("</font><font color=\"#000080\">");
      int index = result.length();
      result.append(matcher.group());
      replace(result, index);
      result.append("<font color=\"#0000e1\">");
    }

    appendTail(result, matcher);
  }

  private static void append(StringBuffer result, Matcher matcher)
  {
    int index = result.length();
    matcher.appendReplacement(result, "");
    replace(result, index);
  }

  private static void appendTail(StringBuffer result, Matcher matcher)
  {
    int index = result.length();
    matcher.appendTail(result);
    replace(result, index);
  }

  private static void replace(StringBuffer result, int start)
  {
    for (int i = result.length(); --i >= start;)
    {
      char character = result.charAt(i);
      if (character == ' ')
      {
        result.replace(i, i + 1, "&nbsp;");
      }
      else if (character == '\t')
      {
        result.replace(i, i + 1, "&nbsp;&nbsp;");
      }
      else if (character == '<')
      {
        result.replace(i, i + 1, "&lt;");
      }
      else if (character == '>')
      {
        result.replace(i, i + 1, "&gt;");
      }
      else if (character == '\r')
      {
        result.delete(i, i + 1);
      }
      else if (character == '\n')
      {
        result.replace(i, i + 1, "<br/>" + NL);
      }
    }
  }

  private static String getContents(URI uri, String encoding) throws IOException
  {
    BufferedInputStream bufferedInputStream = new BufferedInputStream(URIConverter.INSTANCE.createInputStream(uri));
    byte[] input = new byte[bufferedInputStream.available()];
    bufferedInputStream.read(input);
    bufferedInputStream.close();
    return encoding == null ? new String(input) : new String(input, encoding);
  }

} // XmlFormatterImpl
