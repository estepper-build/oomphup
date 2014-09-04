/*
 * Copyright (c) 2011-2014 Eike Stepper (Berlin, Germany) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Eike Stepper - initial API and implementation
 */
package org.eclipse.oomph.releng.doc;

import org.eclipse.oomph.releng.doc.article.ArticleFactory;
import org.eclipse.oomph.releng.doc.article.ArticlePackage;
import org.eclipse.oomph.releng.doc.article.ExtensionPoint;
import org.eclipse.oomph.releng.doc.article.JavaPackage;
import org.eclipse.oomph.releng.doc.article.Plugin;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import org.eclipse.osgi.util.ManifestElement;

import org.osgi.framework.BundleException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Eike Stepper
 */
public class AssembleScripts
{
  public static final boolean INCLUDE_SPI = true;

  private static final String EXPORT_PACKAGE = "Export-Package";

  private static final AntLib ANTLIB = new AntLib();

  private static final Pattern PACKAGE_INFO_PATTERN = Pattern.compile(".*<body[^>]*>\\s*(.*)\\s*<p>\\s*</body>.*", Pattern.MULTILINE | Pattern.DOTALL);

  private static final int CURRENT_YEAR = new GregorianCalendar().get(Calendar.YEAR);

  private static final String COPYRIGHT_YEARS = "2014" + (CURRENT_YEAR == 2014 ? "" : "-" + CURRENT_YEAR);

  private static final String NL = System.getProperty("line.separator");

  private static File helpcenter;

  private static File plugins;

  private static File releng;

  public static void main(String[] args) throws Exception
  {
    try
    {
      plugins = new File(args[0]).getCanonicalFile();
      helpcenter = new File(args[1]).getCanonicalFile();
      releng = new File(args[2]).getCanonicalFile();

      for (File plugin : plugins.listFiles())
      {
        if (plugin.isDirectory())
        {
          Properties buildProperties = getProperties(new File(plugin, "build.properties"));
          String javadocProject = buildProperties.getProperty("doc.project");
          if (javadocProject != null)
          {
            Set<String> excludedPackages = getExcludedPackages(buildProperties);
            assembleJavaDocOptions(plugin, javadocProject, excludedPackages);
          }
        }
      }

      for (JavaDoc javaDoc : ANTLIB.getJavaDocs())
      {
        assembleArticleOptions(javaDoc);

        javaDoc.generateAnt();
        javaDoc.generateTocXmi();
      }

      System.out.println();
      ANTLIB.generate();
      ANTLIB.generateDebug();
      ANTLIB.generateDocsTxt();
      System.out.println();

      for (JavaDoc javaDoc : ANTLIB.getJavaDocs())
      {
        for (SourcePlugin sourcePlugin : javaDoc.getSourcePlugins())
        {
          sourcePlugin.validatePackageInfos();
        }
      }

      System.out.println();
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
      throw ex;
    }
  }

  private static void assembleJavaDocOptions(File plugin, String javadocProject, Set<String> excludedPackages) throws IOException, BundleException
  {
    SourcePlugin sourcePlugin = ANTLIB.getSourcePlugin(plugin.getName());
    JavaDoc javaDoc = ANTLIB.getJavaDoc(javadocProject);
    javaDoc.getSourcePlugins().add(sourcePlugin);

    Manifest manifest = getManifest(plugin);
    for (ManifestElement manifestElement : getManifestElements(manifest))
    {
      String packageName = manifestElement.getValue().trim();
      if (isIncluded(excludedPackages, packageName) && isPublic(manifestElement))
      {
        javaDoc.getSourceFolders().add(plugin.getName() + "/src/" + packageName.replace('.', '/'));
        javaDoc.getPackageNames().add(packageName);
        sourcePlugin.getPackageNames().add(packageName);
      }
      else
      {
        javaDoc.getPackageExcludes().add(packageName);
      }
    }

    File schemaFolder = new File(plugin, "schema");
    if (schemaFolder.isDirectory())
    {
      for (File file : schemaFolder.listFiles())
      {
        String name = file.getName();
        if (name.endsWith(".exsd"))
        {
          name = name.substring(0, name.length() - ".html".length()).replace('_', '.');
          javaDoc.getSchemaPlugins().add(plugin.getName());
          sourcePlugin.getSchemaNames().add(name);
        }
      }
    }
  }

  private static void assembleArticleOptions(JavaDoc javaDoc) throws IOException, BundleException
  {
    File plugin = javaDoc.getProject();
    Manifest manifest = getManifest(plugin);

    ManifestElement[] manifestElements = getManifestElements(manifest);
    if (manifestElements == null || manifestElements.length == 0)
    {
      System.err.println("No public packages in " + plugin.getName());
    }
    else
    {
      for (ManifestElement manifestElement : manifestElements)
      {
        if (isPublic(manifestElement))
        {
          String packageName = manifestElement.getValue().trim();
          javaDoc.getArticlePackages().add(packageName);
        }
      }
    }
  }

  private static boolean isIncluded(Set<String> excludedPackages, String packageName)
  {
    if (packageName.endsWith(".spi"))
    {
      return INCLUDE_SPI;
    }

    if (packageName.indexOf(".spi.") != -1)
    {
      return INCLUDE_SPI;
    }

    if (excludedPackages.contains(packageName))
    {
      return false;
    }

    return true;
  }

  private static boolean isPublic(ManifestElement manifestElement)
  {
    return manifestElement.getDirective("x-internal") == null && manifestElement.getDirective("x-friends") == null;
  }

  private static Set<String> getExcludedPackages(Properties buildProperties)
  {
    Set<String> excludedPackages = new HashSet<String>();

    String javadocExclude = buildProperties.getProperty("doc.exclude");
    if (javadocExclude != null)
    {
      for (String exclude : javadocExclude.split(","))
      {
        exclude = exclude.trim();
        if (exclude.length() != 0)
        {
          excludedPackages.add(exclude);
        }
      }
    }
    return excludedPackages;
  }

  private static ManifestElement[] getManifestElements(Manifest manifest) throws BundleException
  {
    Attributes attributes = manifest.getMainAttributes();
    String exportPackage = attributes.getValue(EXPORT_PACKAGE);
    ManifestElement[] elements = ManifestElement.parseHeader(EXPORT_PACKAGE, exportPackage);
    return elements == null ? new ManifestElement[0] : elements;
  }

  private static Manifest getManifest(File plugin) throws IOException
  {
    File metaInf = new File(plugin, "META-INF");
    File manifest = new File(metaInf, "MANIFEST.MF");
    InputStream in = null;

    try
    {
      in = new FileInputStream(manifest);
      return new Manifest(in);
    }
    finally
    {
      if (in != null)
      {
        in.close();
      }
    }
  }

  public static Properties getProperties(File file)
  {
    Properties properties = new Properties();

    if (file.exists())
    {
      InputStream in = null;

      try
      {
        in = new FileInputStream(file);
        properties.load(in);
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
            ex.printStackTrace();
          }
        }
      }
    }

    return properties;
  }

  public static boolean isWeb(File projectFolder)
  {
    Properties buildProperties = getProperties(new File(projectFolder, "build.properties"));
    return Boolean.parseBoolean(buildProperties.getProperty("doc.web", "true"));
  }

  public static List<String> getDependencies(File projectFolder)
  {
    List<String> result = new ArrayList<String>();

    Properties buildProperties = getProperties(new File(projectFolder, "build.properties"));
    String depends = buildProperties.getProperty("doc.depends");
    if (depends != null)
    {
      StringTokenizer tokenizer = new StringTokenizer(depends, ",");
      while (tokenizer.hasMoreTokens())
      {
        String depend = tokenizer.nextToken().trim();
        result.add(depend);
      }
    }

    return result;
  }

  public static String getPluginName(File projectFolder)
  {
    Properties pluginProperties = getProperties(new File(projectFolder, "plugin.properties"));
    String pluginName = pluginProperties.getProperty("pluginName");
    if (pluginName == null)
    {
      pluginName = "Plugin " + projectFolder.getName();
    }

    return pluginName;
  }

  private static List<String> sort(Collection<String> collection)
  {
    List<String> result = new ArrayList<String>(collection);
    Collections.sort(result);
    return result;
  }

  public static void writeGenerationWarning(BufferedWriter writer) throws IOException
  {
    writer.write("\t<!-- =========================================== -->" + NL);
    writer.write("\t<!-- THIS FILE HAS BEEN GENERATED, DO NOT CHANGE -->" + NL);
    writer.write("\t<!-- =========================================== -->" + NL);
  }

  /**
   * @author Eike Stepper
   */
  public static class AntLib
  {
    private Map<String, SourcePlugin> sourcePlugins = new HashMap<String, SourcePlugin>();

    private Map<String, JavaDoc> javaDocs = new HashMap<String, JavaDoc>();

    public AntLib()
    {
    }

    public SourcePlugin getSourcePlugin(String projectName) throws IOException
    {
      SourcePlugin sourcePlugin = sourcePlugins.get(projectName);
      if (sourcePlugin == null)
      {
        sourcePlugin = new SourcePlugin(projectName);
        sourcePlugins.put(projectName, sourcePlugin);
      }

      return sourcePlugin;
    }

    public Collection<JavaDoc> getJavaDocs()
    {
      return javaDocs.values();
    }

    public Collection<JavaDoc> getJavaDocsSortedByDependencies()
    {
      List<JavaDoc> javaDocs = new ArrayList<JavaDoc>(getJavaDocs());
      Collections.sort(javaDocs, new Comparator<JavaDoc>()
      {
        public int compare(JavaDoc javaDoc1, JavaDoc javaDoc2)
        {
          String name1 = javaDoc1.getProject().getName();
          if (javaDoc2.getAllDependencies().contains(name1))
          {
            return -1;
          }

          String name2 = javaDoc2.getProject().getName();
          if (javaDoc1.getAllDependencies().contains(name2))
          {
            return 1;
          }

          return 0;
        }
      });

      return javaDocs;
    }

    public JavaDoc getJavaDoc(String projectName) throws IOException
    {
      JavaDoc javaDoc = javaDocs.get(projectName);
      if (javaDoc == null)
      {
        javaDoc = new JavaDoc(projectName);
        javaDocs.put(projectName, javaDoc);

        javaDoc.getDependencies().addAll(getDependencies(javaDoc.getProject()));
      }

      return javaDoc;
    }

    public JavaDoc getJavaDocIfExists(String projectName)
    {
      JavaDoc javaDoc = javaDocs.get(projectName);
      if (javaDoc == null)
      {
        throw new IllegalStateException("JavaDoc project not found: " + projectName);
      }

      return javaDoc;
    }

    public void generate() throws IOException
    {
      FileWriter out = null;

      try
      {
        File target = new File(helpcenter, "buildLib.ant");
        System.out.println("Generating " + target.getCanonicalPath());

        out = new FileWriter(target);
        BufferedWriter writer = new BufferedWriter(out);

        writer.write("<?xml version=\"1.0\"?>" + NL);
        writer.write("<!--" + NL);
        writer.write("  Copyright (c) " + COPYRIGHT_YEARS + " Eike Stepper (Berlin, Germany) and others." + NL);
        writer.write("  All rights reserved. This program and the accompanying materials" + NL);
        writer.write("  are made available under the terms of the Eclipse Public License v1.0" + NL);
        writer.write("  which accompanies this distribution, and is available at" + NL);
        writer.write("  http://www.eclipse.org/legal/epl-v10.html" + NL);
        writer.write(NL);
        writer.write("  Contributors:" + NL);
        writer.write("    Eike Stepper - initial API and implementation" + NL);
        writer.write("-->" + NL);
        writer.write("<project name=\"JavaDocLib\" default=\"delegate\">" + NL);

        writer.write("" + NL);
        writeGenerationWarning(writer);
        writer.write("" + NL);

        // Generate delegator
        writer.write("\t<target name=\"delegate\">" + NL);

        List<JavaDoc> javaDocs = (List<JavaDoc>)getJavaDocsSortedByDependencies();
        for (JavaDoc javaDoc : javaDocs)
        {
          writer.write("\t\t<ant antfile=\"${plugins.dir}/" + javaDoc.getProject().getName() + "/build.xml\" target=\"${delegate.target}\" />" + NL);
        }

        writer.write("\t</target>" + NL);
        writer.write("" + NL);

        // Generate toc
        writer.write("\t<target name=\"toc\">" + NL);
        writer.write("\t\t<concat destfile=\"${helpcenter.project}/html/toc.html\">" + NL);
        writer.write("\t\t\t<path path=\"${releng.project}/html/tocHeader.html\" />" + NL);

        Collections.reverse(javaDocs);
        for (JavaDoc javaDoc : javaDocs)
        {
          if (javaDoc.isWeb())
          {
            writer.write("\t\t\t<path path=\"${plugins.dir}/" + javaDoc.getProject().getName() + "/toc.html\" />" + NL);
          }
        }

        writer.write("\t\t\t<path path=\"${releng.project}/html/tocFooter.html\" />" + NL);
        writer.write("\t\t</concat>" + NL);
        writer.write("\t</target>" + NL);
        writer.write("" + NL);

        writer.write("</project>" + NL);
        writer.flush();
      }
      finally
      {
        if (out != null)
        {
          out.close();
        }
      }
    }

    public void generateDocsTxt() throws IOException
    {
      FileWriter out = null;

      try
      {
        File target = new File(helpcenter, "docs.txt");
        target.getParentFile().mkdirs();
        System.out.println("Generating " + target.getCanonicalPath());

        out = new FileWriter(target);
        @SuppressWarnings("resource")
        BufferedWriter writer = new BufferedWriter(out);

        List<JavaDoc> javaDocs = (List<JavaDoc>)getJavaDocsSortedByDependencies();
        for (JavaDoc javaDoc : javaDocs)
        {
          File projectFolder = javaDoc.getProject();
          if (javaDoc.isWeb())
          {
            writer.write(projectFolder.getName());
            writer.write("" + NL);
          }
        }

        writer.flush();
      }
      finally
      {
        if (out != null)
        {
          out.close();
        }
      }
    }

    public void generateDebug() throws IOException
    {
      FileWriter out = null;

      try
      {
        File target = new File(helpcenter, "debug/frame.html");
        target.getParentFile().mkdirs();
        System.out.println("Generating " + target.getCanonicalPath());

        out = new FileWriter(target);
        @SuppressWarnings("resource")
        BufferedWriter writer = new BufferedWriter(out);

        List<JavaDoc> javaDocs = new ArrayList<JavaDoc>(getJavaDocsSortedByDependencies());
        Collections.reverse(javaDocs);

        for (JavaDoc javaDoc : javaDocs)
        {
          for (SourcePlugin sourcePlugin : javaDoc.getSortedSourcePlugins())
          {
            List<String> sortedPackageNames = sourcePlugin.getSortedPackageNames();
            if (sortedPackageNames.isEmpty())
            {
              continue;
            }

            writer.write("<b><a href=\"../../" + javaDoc.getProject().getName() + "/javadoc/" + sortedPackageNames.get(0).replace('.', '/')
                + "/package-summary.html\" target=\"debugDetails\">" + sourcePlugin.getLabel() + "</a></b>" + NL);
            writer.write("<ul>" + NL);

            for (String packageName : sortedPackageNames)
            {
              writer.write("\t<li><a href=\"../../" + javaDoc.getProject().getName() + "/javadoc/" + packageName.replace('.', '/')
                  + "/package-summary.html\" target=\"debugDetails\">" + packageName + "</a>" + NL);
            }

            writer.write("</ul>" + NL);
          }
        }

        writer.flush();
      }
      finally
      {
        if (out != null)
        {
          out.close();
        }
      }
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class SourcePlugin implements Comparable<SourcePlugin>
  {
    private String projectName;

    private String label;

    private Set<String> packageNames = new HashSet<String>();

    private Set<String> schemaNames = new HashSet<String>();

    public SourcePlugin(String projectName) throws IOException
    {
      this.projectName = projectName;
      label = getPluginName(getProject());
    }

    @Override
    public String toString()
    {
      return projectName;
    }

    public File getProject()
    {
      return new File(plugins, projectName);
    }

    public String getLabel()
    {
      return label;
    }

    public Set<String> getPackageNames()
    {
      return packageNames;
    }

    public List<String> getSortedPackageNames()
    {
      List<String> names = new ArrayList<String>(packageNames);
      Collections.sort(names);
      return names;
    }

    public Set<String> getSchemaNames()
    {
      return schemaNames;
    }

    public List<String> getSortedSchemaNames()
    {
      List<String> names = new ArrayList<String>(schemaNames);
      Collections.sort(names);
      return names;
    }

    public int compareTo(SourcePlugin o)
    {
      return getLabel().compareTo(o.getLabel());
    }

    public void validatePackageInfos() throws IOException
    {
      Set<String> packageNames2 = getPackageNames();
      for (String packageName : packageNames2)
      {
        File packageFolder = new File(getProject(), "src/" + packageName.replace('.', '/'));
        File packageInfo = new File(packageFolder, "package-info.java");
        if (!packageInfo.isFile())
        {
          File packageHtml = new File(packageFolder, "package.html");
          if (packageHtml.isFile())
          {
            convertPackageHTML(packageHtml, packageInfo, packageName);
          }

          if (!packageInfo.isFile())
          {
            System.err.println("Package info missing: " + packageInfo.getCanonicalPath());
          }
        }
      }
    }

    private void convertPackageHTML(File packageHtml, File packageInfo, String packageName) throws IOException
    {
      int length = (int)packageHtml.length();
      char[] content = new char[length];

      FileReader reader = null;

      try
      {
        reader = new FileReader(packageHtml);
        if (reader.read(content) != length)
        {
          throw new IOException("Invalid file length: " + packageHtml.getCanonicalPath());
        }
      }
      finally
      {
        if (reader != null)
        {
          reader.close();
        }
      }

      String input = new String(content);
      Matcher matcher = PACKAGE_INFO_PATTERN.matcher(input);
      if (!matcher.matches())
      {
        System.err.println("No match: " + packageHtml.getCanonicalPath());
        return;
      }

      System.out.println("Converting " + packageHtml.getCanonicalPath());
      String comment = matcher.group(1);
      FileWriter out = null;

      try
      {
        out = new FileWriter(packageInfo);
        @SuppressWarnings("resource")
        BufferedWriter writer = new BufferedWriter(out);

        writer.write("/*" + NL);
        writer.write(" * Copyright (c) " + COPYRIGHT_YEARS + " Eike Stepper (Berlin, Germany) and others." + NL);
        writer.write(" * All rights reserved. This program and the accompanying materials" + NL);
        writer.write(" * are made available under the terms of the Eclipse Public License v1.0" + NL);
        writer.write(" * which accompanies this distribution, and is available at" + NL);
        writer.write(" * http://www.eclipse.org/legal/epl-v10.html" + NL);
        writer.write(" * " + NL);
        writer.write(" * Contributors:" + NL);
        writer.write(" *    Eike Stepper - initial API and implementation" + NL);
        writer.write(" */" + NL);
        writer.write(NL);
        writer.write("/**" + NL);

        String[] lines = comment.split("" + NL);
        for (String line : lines)
        {
          writer.write(" * ");
          writer.write(line);
          writer.write(NL);
        }

        writer.write(" */" + NL);
        writer.write("package " + packageName + ";" + NL);
        writer.flush();
      }
      finally
      {
        if (out != null)
        {
          out.close();
        }
      }
    }
  }

  /**
   * @author Eike Stepper
   */
  public static class JavaDoc
  {
    private String projectName;

    private Set<String> dependencies = new HashSet<String>();

    private Set<SourcePlugin> sourcePlugins = new HashSet<SourcePlugin>();

    private List<String> sourceFolders = new ArrayList<String>();

    private Set<String> packageNames = new HashSet<String>();

    private Set<String> packageExcludes = new HashSet<String>();

    private Set<String> schemaPlugins = new HashSet<String>();

    private Set<String> articlePackages = new HashSet<String>();

    public JavaDoc(String projectName)
    {
      this.projectName = projectName;
    }

    @Override
    public String toString()
    {
      return projectName;
    }

    public File getProject()
    {
      return new File(plugins, projectName);
    }

    public Set<String> getDependencies()
    {
      return dependencies;
    }

    public Set<String> getAllDependencies()
    {
      Set<String> result = new HashSet<String>();
      recurseDependencies(this, result);
      return result;
    }

    private void recurseDependencies(JavaDoc javaDoc, Set<String> result)
    {
      for (String dependency : javaDoc.getDependencies())
      {
        if (result.add(dependency))
        {
          JavaDoc child = ANTLIB.getJavaDocIfExists(dependency);
          recurseDependencies(child, result);
        }
      }
    }

    public Set<SourcePlugin> getSourcePlugins()
    {
      return sourcePlugins;
    }

    public List<SourcePlugin> getSortedSourcePlugins()
    {
      List<SourcePlugin> plugins = new ArrayList<SourcePlugin>(sourcePlugins);
      Collections.sort(plugins);
      return plugins;
    }

    public List<String> getSourceFolders()
    {
      return sourceFolders;
    }

    public Set<String> getPackageNames()
    {
      return packageNames;
    }

    public Set<String> getPackageExcludes()
    {
      return packageExcludes;
    }

    public final Set<String> getSchemaPlugins()
    {
      return schemaPlugins;
    }

    public Set<String> getArticlePackages()
    {
      return articlePackages;
    }

    public boolean isWeb()
    {
      return AssembleScripts.isWeb(getProject());
    }

    public void generateAnt() throws IOException
    {
      File project = getProject();
      FileWriter out = null;
      FileReader in = null;

      try
      {
        File target = new File(project, "build.xml");
        System.out.println("Generating " + target.getCanonicalPath());

        out = new FileWriter(target);
        BufferedWriter writer = new BufferedWriter(out);

        try
        {
          in = new FileReader(new File(releng, "buildTemplate.ant"));
          @SuppressWarnings("resource")
          BufferedReader reader = new BufferedReader(in);

          String line;
          while ((line = reader.readLine()) != null)
          {
            line = line.replace("${PROJECT-NAME}", projectName);

            String id = line.trim();
            if ("<!-- GENERATION WARNING -->".equals(id))
            {
              writeGenerationWarning(writer);
            }
            else if ("<!-- ARTICLE SKIP -->".equals(id))
            {
              if (articlePackages.isEmpty())
              {
                writer.write("\t<property name=\"article.skip\" value=\"true\" />" + NL);
              }
            }
            else if ("<!-- SCHEMA SKIP -->".equals(id))
            {
              if (schemaPlugins.isEmpty())
              {
                writer.write("\t<property name=\"schema.skip\" value=\"true\" />" + NL);
              }
            }
            else if ("<!-- JAVA SKIP -->".equals(id))
            {
              if (packageNames.isEmpty())
              {
                writer.write("\t<property name=\"java.skip\" value=\"true\" />" + NL);
              }
            }
            else if ("<!-- SOURCE FOLDERS -->".equals(id))
            {
              for (String sourceFolder : sort(sourceFolders))
              {
                writer.write("\t\t\t\t<include name=\"" + sourceFolder + "/*.java\" />" + NL);
              }
            }
            else if ("<!-- COPY DOC FILES -->".equals(id))
            {
              CharArrayWriter buffer = new CharArrayWriter();
              buffer.write("\t\t<copy todir=\"${javadoc.destdir}\" verbose=\"true\" failonerror=\"false\">" + NL);
              buffer.write("\t\t\t<cutdirsmapper dirs=\"2\" />" + NL);
              buffer.write("\t\t\t<fileset dir=\"${plugins.dir}\" defaultexcludes=\"true\">" + NL);

              boolean exist = false;
              for (String sourceFolder : sort(sourceFolders))
              {
                File docFiles = new File("../../plugins/" + sourceFolder + "/doc-files");
                if (docFiles.isDirectory())
                {
                  exist = true;
                  buffer.write("\t\t\t\t<include name=\"" + sourceFolder + "/doc-files/**\" />" + NL);
                }
              }

              if (exist)
              {
                buffer.write("\t\t\t</fileset>" + NL);
                buffer.write("\t\t</copy>" + NL);
                buffer.write("" + NL);
                writer.write(buffer.toCharArray());
              }
            }
            else if ("<!-- PACKAGE NAMES -->".equals(id))
            {
              for (String packageName : sort(packageNames))
              {
                writer.write("\t\t\t<package name=\"" + packageName + "\" />" + NL);
              }
            }
            else if ("<!-- PACKAGE EXCLUDES -->".equals(id))
            {
              for (String packageExclude : sort(packageExcludes))
              {
                writer.write("\t\t\t<excludepackage name=\"" + packageExclude + "\" />" + NL);
              }
            }
            else if ("<!-- ARTICLE PACKAGES -->".equals(id))
            {
              for (String articlePackage : sort(articlePackages))
              {
                writer.write("\t\t\t<package name=\"" + articlePackage + "\" />" + NL);
              }

              for (String dependency : sort(getAllDependencies()))
              {
                JavaDoc javaDoc = ANTLIB.getJavaDoc(dependency);
                for (String articlePackage : sort(javaDoc.getArticlePackages()))
                {
                  writer.write("\t\t\t<package name=\"" + articlePackage + "\" />" + NL);
                }
              }
            }
            else if ("<!-- SCHEMA CONVERSIONS -->".equals(id))
            {
              for (String schemaPlugin : sort(schemaPlugins))
              {
                writer.write("\t\t<pde.convertSchemaToHTML destination=\"${schemadoc.destdir}\" manifest=\"${plugins.dir}/" + schemaPlugin + "/plugin.xml\" />"
                    + NL);
              }
            }
            else if ("<!-- JAVADOC DEPENDENCIES -->".equals(id))
            {
              for (String dependency : sort(getAllDependencies()))
              {
                writer.write("\t\t\t<link href=\"MAKE-RELATIVE/" + dependency + "/javadoc\" offline=\"true\" packagelistloc=\"${plugins.dir}/" + dependency
                    + "/javadoc\" />" + NL);
              }
            }
            else if ("<!-- ARTICLE DEPENDENCIES -->".equals(id))
            {
              for (String dependency : sort(getAllDependencies()))
              {
                writer.write("\t\t\t\t<include name=\"" + dependency + "/src/**/*.java\" />" + NL);
              }
            }
            else if ("<!-- GROUPS -->".equals(id))
            {
              for (SourcePlugin sourcePlugin : getSortedSourcePlugins())
              {
                List<String> sortedPackageNames = sourcePlugin.getSortedPackageNames();
                if (!sortedPackageNames.isEmpty())
                {
                  writer.write("\t\t\t<group title=\"" + sourcePlugin.getLabel() + "\">" + NL);

                  for (String packageName : sortedPackageNames)
                  {
                    writer.write("\t\t\t\t<package name=\"" + packageName + "\" />" + NL);
                  }

                  writer.write("\t\t\t</group>" + NL);
                }
              }
            }
            else
            {
              writer.write(line);
              writer.write("" + NL);
            }
          }

          writer.flush();
        }
        finally
        {
          if (in != null)
          {
            in.close();
          }
        }
      }
      finally
      {
        if (out != null)
        {
          out.close();
        }
      }
    }

    public void generateTocXmi() throws IOException
    {
      Resource resource = getTocXmiResource(getProject(), true);
      System.out.println("Generating " + new File(resource.getURI().toFileString()).getCanonicalPath());

      for (SourcePlugin sourcePlugin : getSortedSourcePlugins())
      {
        Plugin plugin = ArticleFactory.eINSTANCE.createPlugin();
        plugin.setName(sourcePlugin.getProject().getName());
        plugin.setLabel(sourcePlugin.getLabel());
        resource.getContents().add(plugin);

        for (String packageName : sourcePlugin.getSortedPackageNames())
        {
          JavaPackage javaPackage = ArticleFactory.eINSTANCE.createJavaPackage();
          javaPackage.setName(packageName);
          plugin.getPackages().add(javaPackage);
        }

        for (String schemaName : sourcePlugin.getSortedSchemaNames())
        {
          ExtensionPoint extensionPoint = ArticleFactory.eINSTANCE.createExtensionPoint();
          extensionPoint.setName(schemaName);
          plugin.getExtensionPoints().add(extensionPoint);
        }
      }

      resource.save(null);
    }

    public static Resource getTocXmiResource(File project, boolean create) throws IOException
    {
      ArticlePackage.eINSTANCE.eClass();

      ResourceSet resourceSet = new ResourceSetImpl();
      Map<String, Object> map = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
      map.put("xmi", new XMIResourceFactoryImpl());

      File target = new File(project, "toc.xmi");
      URI uri = URI.createFileURI(target.getCanonicalPath());

      if (create)
      {
        return resourceSet.createResource(uri);
      }

      return resourceSet.getResource(uri, true);
    }
  }
}
