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
package org.eclipse.oomph.releng.doc;

import org.eclipse.oomph.releng.doc.article.impl.ArticleDoclet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class DocletTest
{
  private static final String RELENG = "D:/sandbox/oomph/git/oomphup/org.eclipse.oomph.releng.doc";

  private static final String BASE = "D:/sandbox/oomph/git/org.eclipse.oomph";

  private static final String PLUGINS = BASE + "/plugins";

  private static List<String> arguments = new ArrayList<String>();

  public static void main(String[] args) throws IOException
  {
    add("-doclet org.eclipse.oomph.releng.doc.article.impl.ArticleDoclet");
    add("-docletpath $RELENG/bin;$RELENG/lib-test/org.eclipse.emf.common_2.11.0.v20140916-0346.jar;$RELENG/lib-test/org.eclipse.emf.ecore_2.11.0.v20140916-0346.jar");
    add("-encoding ISO-8859-1");
    add("-private");
    // add("-classpath /develop/ws/cdo/_target/plugins/com.db4o_7.4.155.v20110215-0651.jar");
    add("-basefolder $BASE");
    add("-project org.eclipse.oomph.setup.doc");
    add("-externals http://download.oracle.com/javase/1.5.0/docs/api;http://help.eclipse.org/juno/topic/org.eclipse.platform.doc.isv/reference/api;http://download.eclipse.org/modeling/emf/emf/javadoc/2.7.0");
    add("-source 1.5");

    addJavaFiles("org.eclipse.oomph.setup.doc");

    String[] array = arguments.toArray(new String[arguments.size()]);
    com.sun.tools.javadoc.Main.execute(DocletTest.class.getSimpleName(), ArticleDoclet.class.getName(), array);
  }

  private static void add(String argument)
  {
    argument = expand(argument);

    int space = argument.trim().indexOf(' ');
    if (space == -1)
    {
      arguments.add(argument);
    }
    else
    {
      arguments.add(argument.substring(0, space));
      add(argument.substring(space + 1).trim());
    }
  }

  private static void addJavaFiles(String project) throws IOException
  {
    project = expand(project);
    addJavaFiles(new File(PLUGINS, project + "/src").getCanonicalFile());
  }

  private static void addJavaFiles(File folder)
  {
    File[] children = folder.listFiles();
    if (children != null)
    {
      for (File child : children)
      {
        String name = child.getName();
        if (child.isDirectory() && !name.equals(".git"))
        {
          addJavaFiles(child);
        }
        else if (child.isFile() && name.endsWith(".java"))
        {
          arguments.add(child.getPath());
        }
      }
    }
  }

  private static String expand(String string)
  {
    string = string.replace("$RELENG", RELENG);
    string = string.replace("$BASE", BASE);
    string = string.replace("$PLUGINS", PLUGINS);
    return string;
  }
}
