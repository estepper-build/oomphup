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
import org.eclipse.oomph.releng.doc.article.Documentation;
import org.eclipse.oomph.releng.doc.article.JavaElement;
import org.eclipse.oomph.releng.doc.article.StructuralElement;
import org.eclipse.oomph.releng.doc.article.util.ArticleUtil;

import org.eclipse.emf.ecore.EClass;

import com.sun.javadoc.ClassDoc;
import com.sun.javadoc.Doc;
import com.sun.javadoc.ExecutableMemberDoc;
import com.sun.javadoc.MemberDoc;
import com.sun.javadoc.PackageDoc;
import com.sun.javadoc.ProgramElementDoc;

import java.io.File;
import java.io.PrintWriter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Java Element</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.JavaElementImpl#getClassFile <em>Class File</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class JavaElementImpl extends LinkTargetImpl implements JavaElement
{
  /**
   * The default value of the '{@link #getClassFile() <em>Class File</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getClassFile()
   * @generated
   * @ordered
   */
  protected static final File CLASS_FILE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getClassFile() <em>Class File</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getClassFile()
   * @generated
   * @ordered
   */
  protected File classFile = CLASS_FILE_EDEFAULT;

  private Documentation documentation;

  private ProgramElementDoc programElementDoc;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected JavaElementImpl()
  {
    super();
  }

  JavaElementImpl(Documentation documentation, ProgramElementDoc programElementDoc, File classFile)
  {
    this.documentation = documentation;
    this.programElementDoc = programElementDoc;
    this.classFile = classFile;

    this.documentation.getContext().register(getId(), this);
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.JAVA_ELEMENT;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  public File getClassFile()
  {
    return classFile;
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
      case ArticlePackage.JAVA_ELEMENT__CLASS_FILE:
        return getClassFile();
    }
    return super.eGet(featureID, resolve, coreType);
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
      case ArticlePackage.JAVA_ELEMENT__CLASS_FILE:
        return CLASS_FILE_EDEFAULT == null ? classFile != null : !CLASS_FILE_EDEFAULT.equals(classFile);
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
    result.append(" (classFile: ");
    result.append(classFile);
    result.append(')');
    return result.toString();
  }

  @Override
  public String linkFrom(StructuralElement source)
  {
    String link = ArticleUtil.createLink(source.getOutputFile(), classFile);

    if (programElementDoc instanceof MemberDoc)
    {
      link += "#" + ((MemberDoc)programElementDoc).name();

      if (programElementDoc instanceof ExecutableMemberDoc)
      {
        link += ((ExecutableMemberDoc)programElementDoc).signature();
      }
    }

    return link;
  }

  @Override
  public Object getId()
  {
    return programElementDoc;
  }

  @Override
  public String getTooltip()
  {
    return getTooltip(programElementDoc);
  }

  @Override
  protected void writeLink(PrintWriter out, String label, String href, String tooltip)
  {
    super.writeLink(out, "<code>" + label + "</code>", href, tooltip);
  }

  public static String getTooltip(Doc doc)
  {
    String kind = getKind(doc);
    if (kind == null || kind.length() == 0)
    {
      return "";
    }

    if (doc instanceof ProgramElementDoc)
    {
      ProgramElementDoc programElementDoc = (ProgramElementDoc)doc;

      ClassDoc containingClass = programElementDoc.containingClass();
      if (containingClass != null)
      {
        return kind + " in " + containingClass.qualifiedTypeName();
      }

      PackageDoc containingPackage = programElementDoc.containingPackage();
      if (containingPackage != null)
      {
        return kind + " in " + containingPackage.name();
      }
    }

    return kind;
  }

  public static String getKind(Doc doc)
  {
    if (doc.isAnnotationType())
    {
      return "Annotation type";
    }

    if (doc.isAnnotationTypeElement())
    {
      return "Annotation element";
    }

    if (doc.isOrdinaryClass())
    {
      return "Class";
    }

    if (doc.isConstructor())
    {
      return "Constructor";
    }

    if (doc.isEnum())
    {
      return "Enum";
    }

    if (doc.isEnumConstant())
    {
      return "Enum constant";
    }

    if (doc.isError())
    {
      return "Error";
    }

    if (doc.isException())
    {
      return "Exception";
    }

    if (doc.isField())
    {
      return "Field";
    }

    if (doc.isInterface())
    {
      return "Interface";
    }

    if (doc.isMethod())
    {
      return "Method";
    }

    return null;
  }

} // JavaElementImpl
