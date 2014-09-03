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
package de.escnet;


import com.sun.javadoc.Doc;

import de.java2html.Java2Html;
import de.java2html.options.JavaSourceConversionOptions;
import de.java2html.options.JavaSourceStyleTable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eike Stepper
 */
public final class CodeSnippet
{
  private static final int INDENT_UNKNOWN = -1;

  private static final int FLAGS = Pattern.MULTILINE | Pattern.DOTALL;

  private static final Pattern PATTERN0 = Pattern.compile(".*<code>\\s*(.*)</code>.*", FLAGS);

  private static final Pattern PATTERN1 = Pattern.compile("^<font color=\"#ffffff\">&nbsp;&nbsp;", FLAGS);

  private static final Pattern PATTERN2 = Pattern.compile("^<font color=\"#ffffff\"></font>", FLAGS);

  private static final Pattern PATTERN3 = Pattern.compile("<font color=\"#ffffff\">((&nbsp;)+)</font>", FLAGS);

  private static final Pattern PATTERN4 = Pattern.compile("<br />", FLAGS);

  private static final Pattern PATTERN5 = Pattern.compile("^(.*)$", Pattern.MULTILINE);

  private static final Pattern PATTERN6 = Pattern.compile("<font color=\"#3f7f5f\">//&nbsp;snip.*?//&nbsp;snap", FLAGS);

  private static final Pattern PATTERN7 = Pattern.compile("<font color=\"#000000\">(.*?)</font>", Pattern.MULTILINE);

  private final Doc snippetDoc;

  private final String id;

  private final String title;

  private final boolean includeSignature;

  private final String imagePath;

  public CodeSnippet(Doc snippetDoc, Map<String, Object> options)
  {
    this.snippetDoc = snippetDoc;

    String name = snippetDoc.name();
    int lastDot = name.lastIndexOf('.');
    if (lastDot != -1)
    {
      name = name.substring(lastDot + 1);
    }

    id = name;
    title = getOption(options, "title", id + ".java");

    includeSignature = getOption(options, "includeSignature", false);
    imagePath = getOption(options, "imagePath", "");
  }

  public String getHtml()
  {
    File file = snippetDoc.position().file();
    Reader in = null;

    try
    {
      in = new FileReader(file);
      BufferedReader reader = new BufferedReader(in);
      String code = getSnippetText(reader, snippetDoc.position().line(), includeSignature);

      return convertToHtml(code, !includeSignature);
    }
    catch (IOException ex)
    {
      throw new RuntimeException(ex);
    }
    finally
    {
      if (in != null)
      {
        try
        {
          in.close();
        }
        catch (IOException ex)
        {
          throw new RuntimeException(ex);
        }
      }
    }
  }

  private static String getSnippetText(BufferedReader reader, int startLine, boolean includeSignature)
      throws IOException
  {
    StringBuilder builder = new StringBuilder();
    int number = 1;
    int level = 0;
    int indent = INDENT_UNKNOWN;
    boolean onSignature = false;
    boolean inSnippet = false;

    String line;
    while ((line = readLine(reader, indent)) != null)
    {
      if (number++ == startLine)
      {
        onSignature = true;

        indent = countLeading(line, " ");
        line = unindent(line, indent);
        if (includeSignature)
        {
          builder.append(line);
          builder.append("\n");
        }

        continue;
      }

      String trimmmed = line.trim();
      if (onSignature)
      {
        if (includeSignature)
        {
          builder.append(line);
          builder.append("\n");
        }

        if (trimmmed.startsWith("{"))
        {
          onSignature = false;
          inSnippet = true;
          ++level;
        }

        continue;
      }

      if (inSnippet)
      {
        if (trimmmed.startsWith("{"))
        {
          ++level;
        }
        else if (trimmmed.startsWith("}"))
        {
          if (--level == 0)
          {
            if (includeSignature)
            {
              builder.append(line);
              builder.append("\n");
            }

            break;
          }
        }

        builder.append(line);
        builder.append("\n");
      }
    }

    return builder.toString();
  }

  private static String convertToHtml(String javaText, boolean unindent)
  {
    JavaSourceConversionOptions options = JavaSourceConversionOptions.getDefault();
    options.setStyleTable(JavaSourceStyleTable.getDefaultEclipseStyleTable());
    options.setShowTableBorder(true);

    String html = Java2Html.convertToHtml(javaText, options);

    Matcher matcher = PATTERN0.matcher(html);
    if (!matcher.matches())
    {
      throw new AssertionError("No match found");
    }

    String code = matcher.group(1);
    if (unindent)
    {
      code = PATTERN1.matcher(code).replaceAll("<font color=\"#ffffff\">");
    }

    code = PATTERN2.matcher(code).replaceAll("");
    code = PATTERN3.matcher(code).replaceAll("$1");
    code = PATTERN4.matcher(code).replaceAll("<br/>");
    code = PATTERN5.matcher(code).replaceAll("            $1");
    code = PATTERN6.matcher(code).replaceAll("<font color=\"#000000\">&hellip;");
    code = PATTERN7.matcher(code).replaceAll("$1");
    return code;
  }

  private static String readLine(BufferedReader reader, int indent) throws IOException
  {
    String line = reader.readLine();
    line = line.replaceAll("\\s", " ");
    return unindent(line, indent);
  }

  private static String unindent(String line, int indent) throws IOException
  {
    if (indent != INDENT_UNKNOWN)
    {
      line = line.substring(Math.min(indent, line.length()));
    }

    return line;
  }

  private static int countLeading(String string, String search)
  {
    int count = 0;
    int i = 0;

    for (;;)
    {
      if (string.indexOf(search, i) == i)
      {
        ++count;
        i += search.length();
      }
      else
      {
        break;
      }
    }

    return count;
  }

  private static <T> T getOption(Map<String, Object> options, String name, T defaultValue)
  {
    if (!options.containsKey(name))
    {
      return defaultValue;
    }

    return (T)options.get(name);
  }
}
