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
import org.eclipse.oomph.releng.doc.article.Context;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.util.ArticleException;

import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.xmi.impl.XMLContentHandlerImpl;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.RootDoc;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Eike Stepper
 */
public class ArticleDoclet
{
  public static final String OPTION_START_TIME = "-starttime";

  public static final String OPTION_PRIVATE = "-private";

  public static final String OPTION_BASE_FOLDER = "-basefolder";

  public static final String OPTION_PROJECT = "-project";

  public static final String OPTION_EXTERNALS = "-externals";

  // public static final String OPTION_MODEL_FOLDER = "-modelfolder";
  //
  // private static final String MODEL_EXTENSION = "article";

  public static boolean hasOption(RootDoc root, String optionName)
  {
    for (String[] option : root.options())
    {
      if (optionName.equalsIgnoreCase(option[0]))
      {
        return true;
      }
    }

    return false;
  }

  public static String getOption(RootDoc root, String optionName)
  {
    for (String[] option : root.options())
    {
      if (optionName.equalsIgnoreCase(option[0]))
      {
        // FIXME Multi-argument options?
        return option[1];
      }
    }

    return "";
  }

  public static void dumpOptions(RootDoc root)
  {
    Set<String> sourcepath = new HashSet<String>();
    Set<String> subpackages = new HashSet<String>();
    for (ClassDoc classDoc : root.classes())
    {
      sourcepath.add(classDoc.position().file().getAbsolutePath());
      subpackages.add(classDoc.containingPackage().name());
    }

    System.out.print("-sourcepath");
    String sep = " ";
    for (String string : sourcepath)
    {
      System.out.print(sep);
      System.out.print(string.replace('\\', '/').replace("C:/", "/"));
      sep = ";";
    }

    System.out.println();
    System.out.print("-subpackages");
    sep = " ";
    for (String string : subpackages)
    {
      System.out.print(sep);
      System.out.print(string);
      sep = ":";
    }

    System.out.println();
    for (String[] option : root.options())
    {
      System.out.print(option[0]);
      for (int i = 1; i < option.length; i++)
      {
        String value = option[i];
        System.out.print(" " + value.replace('\\', '/').replace("C:/", "/"));
      }

      System.out.println();
    }

    System.out.println();
  }

  public static int optionLength(String option)
  {
    if (OPTION_BASE_FOLDER.equals(option))
    {
      return 2;
    }

    if (OPTION_START_TIME.equals(option))
    {
      return 2;
    }

    if (OPTION_PROJECT.equals(option))
    {
      return 2;
    }

    if (OPTION_EXTERNALS.equals(option))
    {
      return 2;
    }

    // if (OPTION_MODEL_FOLDER.equals(option))
    // {
    // return 2;
    // }

    // Indicate we don't know about it
    return -1;
  }

  public static boolean start(RootDoc root)
  {
    // dumpOptions(root);

    long startTime = System.currentTimeMillis();

    try
    {
      String timeOption = getOption(root, OPTION_START_TIME);
      if (timeOption.length() != 0)
      {
        try
        {
          startTime = new SimpleDateFormat("y-M-D-H-m-s-S").parse(timeOption).getTime();
        }
        catch (Exception ex)
        {
          ex.printStackTrace();
        }
      }

      if (!hasOption(root, OPTION_PRIVATE))
      {
        throw new ArticleException("Missing option: " + OPTION_PRIVATE);
      }

      File baseFolder = new File(getOption(root, OPTION_BASE_FOLDER));
      String project = getOption(root, OPTION_PROJECT);
      String externals = getOption(root, OPTION_EXTERNALS);

      Context context = new ContextImpl(root, baseFolder, project, externals);

      Documentation documentation = context.getDocumentation();
      documentation.generate();

      // String modelFolder = getOption(root, OPTION_MODEL_FOLDER);
      // if (modelFolder != null && modelFolder.length() != 0)
      // {
      // ResourceSet resourceSet = new ResourceSetImpl();
      // resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(MODEL_EXTENSION, new XMIResourceFactoryImpl());
      //
      // URI contextURI = URI.createFileURI(modelFolder + "/" + context.getProject() + "." + MODEL_EXTENSION);
      // Resource contextResource = resourceSet.createResource(contextURI);
      // contextResource.getContents().add(context);
      //
      // for (Iterator<EObject> it = context.eAllContents(); it.hasNext();)
      // {
      // EObject object = it.next();
      // for (EObject target : object.eCrossReferences())
      // {
      // if (target.eResource() == null)
      // {
      // contextResource.getContents().add(target);
      // }
      // }
      // }
      //
      // contextResource.save(null);
      // }

      return true;
    }
    catch (ArticleException ex)
    {
      System.err.println(ex.getMessage());
    }
    catch (Error ex)
    {
      ex.printStackTrace();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
    finally
    {
      long duration = (System.currentTimeMillis() - startTime) / 1000;
      System.out.println("Total time: " + duration + " seconds");
    }

    return false;
  }

  static
  {
    ArticlePackage.eINSTANCE.eClass();
    URIConverter.INSTANCE.getContentHandlers().add(new XMLContentHandlerImpl());
  }
}
