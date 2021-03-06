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

import org.eclipse.oomph.releng.doc.article.Body;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Context;
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.EmbeddableElement;
import org.eclipse.oomph.releng.doc.article.LinkTarget;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.common.util.EList;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.MemberDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;
import com.sun.javadoc.SeeTag;
import com.sun.javadoc.Tag;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Eike Stepper
 */
public class UnresolvedBodyElement extends BodyElementImpl
{
  private static final boolean DEBUG = false;

  UnresolvedBodyElement(Tag tag)
  {
    super(tag);
  }

  public final String getText()
  {
    if (DEBUG)
    {
      return "<b><code><font color=\"#ff000000\">{" + getTag() + "}</font></code></b>";
    }

    return getTag().text();
  }

  public BodyElement copy()
  {
    return new UnresolvedBodyElement(getTag());
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    out.write(getText());
  }

  public List<? extends BodyElement> resolve(Context context)
  {
    List<? extends BodyElement> resolved = null;

    Tag tag = getTag();
    if (tag instanceof SeeTag)
    {
      SeeTag seeTag = (SeeTag)tag;
      resolved = resolveSeeTag(context, seeTag);
    }
    else if (tag.name().equals("@image"))
    {
      resolved = resolveImageTag(context, tag);
    }

    if (resolved != null)
    {
      return resolved;
    }

    System.err.println(ArticleUtil.makeConsoleLink("Unresolved link " + tag + " in ", tag.position()));
    return Collections.singletonList(this);
  }

  private List<? extends BodyElement> resolveSeeTag(Context context, SeeTag seeTag)
  {
    // TODO Handle links to packages!

    MemberDoc referencedMember = seeTag.referencedMember();
    if (referencedMember != null)
    {
      Object target = context.lookup(referencedMember);
      if (target == null)
      {
        target = resolveJavaElement(context, referencedMember.containingClass(), referencedMember);
      }

      if (target != null)
      {
        return createBodyElements(context, seeTag, target);
      }
    }

    ClassDoc referencedClass = seeTag.referencedClass();
    if (referencedClass != null)
    {
      Object target = context.lookup(referencedClass);
      if (target == null)
      {
        target = resolveJavaElement(context, referencedClass, referencedMember);
      }

      if (target != null)
      {
        return createBodyElements(context, seeTag, target);
      }
    }

    PackageDoc referencedPackage = seeTag.referencedPackage();
    if (referencedPackage != null)
    {
      Object target = context.lookup(referencedPackage);
      if (target != null)
      {
        return createBodyElements(context, seeTag, target);
      }
    }

    return null;
  }

  private Object resolveJavaElement(Context context, ClassDoc classDoc, MemberDoc memberDoc)
  {
    String packageName = classDoc.containingPackage().name();
    ProgramElementDoc programElementDoc = memberDoc != null ? memberDoc : classDoc;

    for (Documentation documentation : context.getDocumentations())
    {
      File projectFolder = documentation.getProjectFolder();
      File javadocFolder = new File(projectFolder, "javadoc");
      File packageFolder = new File(javadocFolder, packageName.replace('.', '/'));
      File classFile = new File(packageFolder, classDoc.typeName() + ".html");
      if (classFile.isFile())
      {
        return new JavaElementImpl(documentation, programElementDoc, classFile);
      }
    }

    String externalLink = context.getExternalLink(packageName);
    if (externalLink != null)
    {
      String url = externalLink + "/" + classDoc.typeName() + ".html";

      if (memberDoc != null)
      {
        url += "#" + memberDoc.name();
        if (memberDoc instanceof ExecutableMemberDoc)
        {
          ExecutableMemberDoc executableMemberDoc = (ExecutableMemberDoc)memberDoc;
          url += executableMemberDoc.signature();
        }
      }

      return new ExternalTargetImpl(context, programElementDoc, url);
    }

    return null;
  }

  private List<? extends BodyElement> resolveImageTag(Context context, Tag tag)
  {
    File source = tag.position().file().getParentFile();
    String path = tag.text();
    int index = path.indexOf(' ');
    if (index != -1)
    {
      path = path.substring(0, index);
    }

    try
    {
      File target = new File(source, path).getCanonicalFile();
      return Collections.singletonList(new ImageImpl(tag, target));
    }
    catch (Exception ex)
    {
      return null;
    }
  }

  private List<? extends BodyElement> createBodyElements(Context context, SeeTag seeTag, Object target)
  {
    if (target instanceof LinkTarget)
    {
      if (target instanceof Body && "@inline".equals(seeTag.label()))
      {
        Body body = (Body)target;
        EList<BodyElement> elements = body.getElements();
        resolve(context, elements);

        List<BodyElement> inlined = new ArrayList<BodyElement>();
        for (BodyElement element : elements)
        {
          inlined.add(element.copy());
        }

        return inlined;
      }

      return Collections.singletonList(new LinkImpl(seeTag, (LinkTarget)target));
    }

    if (target instanceof EmbeddableElement)
    {
      return Collections.singletonList(new EmbeddingImpl(seeTag, (EmbeddableElement)target));
    }

    return null;
  }

  public static void resolve(Context context, EList<BodyElement> elements)
  {
    List<BodyElement> resolved = new ArrayList<BodyElement>();
    for (int i = 0; i < elements.size(); i++)
    {
      BodyElement element = elements.get(i);
      if (element instanceof UnresolvedBodyElement)
      {
        UnresolvedBodyElement unresolved = (UnresolvedBodyElement)element;
        resolved.addAll(unresolved.resolve(context));
      }
      else
      {
        resolved.add(element);
      }
    }

    elements.clear();
    elements.addAll(resolved);
  }
}
