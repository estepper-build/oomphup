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
import org.eclipse.oomph.releng.doc.article.LinkTarget;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import com.sun.javadoc.SeeTag;

import java.io.PrintWriter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Link Target</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl#getDefaultLabel <em>Default Label</em>}</li>
 *   <li>{@link org.eclipse.oomph.releng.doc.article.impl.LinkTargetImpl#getTooltip <em>Tooltip</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class LinkTargetImpl extends EObjectImpl implements LinkTarget
{
  protected static final String NL = System.getProperty("line.separator");

  /**
   * The default value of the '{@link #getId() <em>Id</em>}' attribute.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @see #getId()
   * @generated
   * @ordered
   */
  protected static final Object ID_EDEFAULT = null;

  /**
   * The default value of the '{@link #getDefaultLabel() <em>Default Label</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultLabel()
   * @generated
   * @ordered
   */
  protected static final String DEFAULT_LABEL_EDEFAULT = null;

  /**
   * The default value of the '{@link #getTooltip() <em>Tooltip</em>}' attribute.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @see #getTooltip()
   * @generated
   * @ordered
   */
  protected static final String TOOLTIP_EDEFAULT = null;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected LinkTargetImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.LINK_TARGET;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public abstract Object getId();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public String getDefaultLabel()
  {
    return null;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public abstract String getTooltip();

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @generated NOT
   */
  public abstract String linkFrom(StructuralElement source);

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case ArticlePackage.LINK_TARGET__ID:
        return getId();
      case ArticlePackage.LINK_TARGET__DEFAULT_LABEL:
        return getDefaultLabel();
      case ArticlePackage.LINK_TARGET__TOOLTIP:
        return getTooltip();
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
      case ArticlePackage.LINK_TARGET__ID:
        return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
      case ArticlePackage.LINK_TARGET__DEFAULT_LABEL:
        return DEFAULT_LABEL_EDEFAULT == null ? getDefaultLabel() != null : !DEFAULT_LABEL_EDEFAULT.equals(getDefaultLabel());
      case ArticlePackage.LINK_TARGET__TOOLTIP:
        return TOOLTIP_EDEFAULT == null ? getTooltip() != null : !TOOLTIP_EDEFAULT.equals(getTooltip());
    }
    return super.eIsSet(featureID);
  }

  public void generateLink(PrintWriter out, StructuralElement linkSource, SeeTag seeTag)
  {
    String label = seeTag == null ? null : seeTag.label();
    if (label == null || label.length() == 0)
    {
      label = getDefaultLabel();
      if (label == null || label.length() == 0)
      {
        label = seeTag == null ? null : seeTag.text();
      }
    }

    writeLink(out, linkSource, label);
  }

  protected void writeLink(PrintWriter out, StructuralElement linkSource, String label)
  {
    String href = linkFrom(linkSource);
    String tooltip = getTooltip();

    writeLink(out, label, href, tooltip);
  }

  protected void writeLink(PrintWriter out, String label, String href, String tooltip)
  {
    if (tooltip != null && tooltip.length() != 0)
    {
      tooltip = " title=\"" + tooltip + "\"";
    }
    else
    {
      tooltip = "";
    }

    out.write("<a href=\"" + href + "\"" + tooltip + ">" + label + "</a>");
  }

} // LinkTargetImpl
