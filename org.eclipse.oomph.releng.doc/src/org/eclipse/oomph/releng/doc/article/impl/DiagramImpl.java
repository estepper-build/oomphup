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

import org.eclipse.emf.ecore.EClass;

import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.BodyElement;
import org.eclipse.oomph.releng.doc.article.Diagram;
import org.eclipse.oomph.releng.doc.article.StructuralElement;

import com.sun.javadoc.Tag;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Diagram</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public class DiagramImpl extends BodyElementImpl implements Diagram
{
  // org.eclipse.oomph.releng.doc.supplemental;bundle-version="[1.0.0,2.0.0)";resolution:=optional,
  // org.eclipse.gmf.runtime.diagram.ui.render;bundle-version="1.4.1",
  // org.eclipse.gmf.runtime.diagram.ui;bundle-version="1.5.0",
  // org.eclipse.core.runtime;bundle-version="3.7.0",
  // com.ibm.icu;bundle-version="4.4.2"

  // private org.eclipse.gmf.runtime.notation.Diagram diagram;

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  protected DiagramImpl()
  {
    super();
  }

  DiagramImpl(Tag tag)
  {
    super(tag);

    loadDiagram(tag.text());
  }

  public void loadDiagram(String path)
  {
    // try
    // {
    // NotationPackage.eINSTANCE.getClass();
    // URI uri = URI.createFileURI(path);
    //
    // ResourceSet resourceSet = new ResourceSetImpl();
    // Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
    // map.put("*", new XMIResourceFactoryImpl());
    //
    // Resource resource = resourceSet.getResource(uri, true);
    // diagram = (org.eclipse.gmf.runtime.notation.Diagram)resource.getContents().get(0);
    // }
    // catch (Exception ex)
    // {
    // System.err.println("Could not load diagram " + path);
    // ex.printStackTrace();
    // }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return ArticlePackage.Literals.DIAGRAM;
  }

  public BodyElement copy()
  {
    // TODO: implement DiagramImpl.copy()
    throw new UnsupportedOperationException();
  }

  public void generate(PrintWriter out, StructuralElement linkSource) throws IOException
  {
    generate(linkSource.getOutputFile().getParentFile());
  }

  public void generate(File folder) throws IOException
  {
    // String name = diagram.eResource().getURI().path();
    // int lastDot = name.lastIndexOf('.');
    // if (lastDot != -1)
    // {
    // name = name.substring(0, lastDot);
    // }
    //
    // IPath destination = new Path(new File(folder, name + ".png").getCanonicalPath());
    //
    // PreferencesHint hint = null;
    //
    // try
    // {
    // CopyToImageUtil copyToImageUtil = new CopyToImageUtil();
    //
    // Shell shell = new Shell();
    // try
    // {
    // DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(diagram, shell,
    // hint);
    // Assert.isNotNull(diagramEditPart);
    // DiagramGenerator generator = copyToImageUtil.copyToImage(diagramEditPart, destination, ImageFileFormat.PNG,
    // new NullProgressMonitor());
    // List partInfo = generator.getDiagramPartInfo(diagramEditPart);
    // System.out.println(partInfo);
    // }
    // finally
    // {
    // shell.dispose();
    // }
    //
    // // copyToImageUtil.copyToImage(diagram, destination, ImageFileFormat.PNG, new NullProgressMonitor(), hint);
    // }
    // catch (Exception ex)
    // {
    // ex.printStackTrace();
    // }
  }

} // DiagramImpl
