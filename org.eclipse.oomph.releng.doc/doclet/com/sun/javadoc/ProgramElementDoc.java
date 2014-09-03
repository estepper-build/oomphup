/*
 * Copyright (c) 2004-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package com.sun.javadoc;

/**
 * @author Eike Stepper
 */
public interface ProgramElementDoc extends Doc
{
  public ClassDoc containingClass();

  public PackageDoc containingPackage();

  public boolean isPackagePrivate();
}
