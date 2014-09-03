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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.model.ThemesTable;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Eike Stepper
 */
public class ExcelTable
{
  private static final boolean FONT_COLORS = false;

  private FormulaEvaluator evaluator;

  private ThemesTable theme;

  private XSSFSheet sheet;

  private int rowMin = Integer.MAX_VALUE;

  private int rowMax = Integer.MIN_VALUE;

  private int colMin = Integer.MAX_VALUE;

  private int colMax = Integer.MIN_VALUE;

  public ExcelTable(String excel, String sheetName) throws IOException
  {
    XSSFWorkbook wb = new XSSFWorkbook(excel);
    evaluator = wb.getCreationHelper().createFormulaEvaluator();
    theme = wb.getTheme();
    sheet = sheetName == null ? wb.getSheetAt(0) : wb.getSheet(sheetName);

    for (Iterator rowIt = sheet.rowIterator(); rowIt.hasNext();)
    {
      Row row = (Row)rowIt.next();
      for (Iterator cellIt = row.cellIterator(); cellIt.hasNext();)
      {
        XSSFCell cell = (XSSFCell)cellIt.next();

        int rowIndex = cell.getRowIndex();
        rowMin = Math.min(rowMin, rowIndex);
        rowMax = Math.max(rowMax, rowIndex);

        int colIndex = cell.getColumnIndex();
        colMin = Math.min(colMin, colIndex);
        colMax = Math.max(colMax, colIndex);
      }
    }
  }

  public void writeHtml(PrintWriter out) throws IOException
  {
    out.println("<table border=\"0\" cellspacing=\"0\" cellpadding=\"4\">");

    for (int rowIndex = rowMin; rowIndex <= rowMax; rowIndex++)
    {
      out.println("  <tr>");

      for (int colIndex = colMin; colIndex <= colMax; colIndex++)
      {
        Span span = getSpan(rowIndex, colIndex);
        if (span == null)
        {
          continue;
        }

        Map<String, String> styles = new HashMap<String, String>();
        String value = "&nbsp;";
        String color = null;

        XSSFCell cell = getCell(rowIndex, colIndex);
        if (cell != null)
        {
          String cellValue = getCellValue(cell);
          if (cellValue != null && cellValue.length() != 0)
          {
            value = cellValue;
          }

          styleAlignment(styles, cell);
          styleVerticalAlignment(styles, cell);
          styleBackground(styles, cell);
          color = styleFont(styles, cell);
          styleBorders(styles, rowIndex, colIndex, span);
        }

        out.print("    <td" + formatSpan(span) + formatStyles(styles) + ">");
        if (color != null)
        {
          out.print("<font color=\"" + color + "\">");
        }

        out.print(value);
        if (color != null)
        {
          out.print("</font>");
        }

        out.println("</td>");
      }

      out.println("  </tr>");
    }

    out.println("</table>");
  }

  private XSSFCell getCell(int rowIndex, int colIndex)
  {
    XSSFRow row = sheet.getRow(rowIndex);
    if (row != null)
    {
      return row.getCell(colIndex);
    }

    return null;
  }

  private String getCellValue(XSSFCell cell)
  {
    switch (cell.getCellType())
    {
    case Cell.CELL_TYPE_BLANK:
      return "";

    case Cell.CELL_TYPE_BOOLEAN:
      return Boolean.toString(cell.getBooleanCellValue());

    case Cell.CELL_TYPE_ERROR:
      return cell.getErrorCellString();

    case Cell.CELL_TYPE_FORMULA:
      CellValue cellValue = evaluator.evaluate(cell);
      switch (cellValue.getCellType())
      {
      case Cell.CELL_TYPE_BLANK:
        return "";

      case Cell.CELL_TYPE_BOOLEAN:
        return Boolean.toString(cellValue.getBooleanValue());

      case Cell.CELL_TYPE_NUMERIC:
        return getNumericValue(cellValue.getNumberValue());

      case Cell.CELL_TYPE_STRING:
        return cellValue.getStringValue();

      case Cell.CELL_TYPE_ERROR:
      case Cell.CELL_TYPE_FORMULA:
      default:
        throw new IllegalStateException("Illegal cell type: " + cell.getCellType());
      }

    case Cell.CELL_TYPE_NUMERIC:
      if (DateUtil.isCellDateFormatted(cell))
      {
        return cell.getDateCellValue().toString();
      }

      return getNumericValue(cell.getNumericCellValue());

    case Cell.CELL_TYPE_STRING:
      return cell.getStringCellValue();

    default:
      throw new IllegalStateException("Illegal cell type: " + cell.getCellType());
    }
  }

  private String getNumericValue(double value)
  {
    String result = Double.toString(value);
    if (result.endsWith(".0"))
    {
      result = result.substring(0, result.length() - 2);
    }

    return result;
  }

  private String getHtmlColor(XSSFColor color)
  {
    StringBuilder builder = new StringBuilder("#");

    byte[] rgb = color.getRgb();
    for (byte c : rgb)
    {
      int i = (int)c;
      if (i < 0)
      {
        i += 256;
      }

      String cs = Integer.toHexString(i);
      if (cs.length() == 1)
      {
        builder.append('0');
      }

      builder.append(cs);
    }

    return builder.toString();
  }

  private void styleAlignment(Map<String, String> styles, XSSFCell cell)
  {
    XSSFCellStyle cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      short alignment = cellStyle.getAlignment();
      if (alignment == XSSFCellStyle.ALIGN_RIGHT)
      {
        styles.put("text-align", "right");
        return;
      }

      if (alignment == XSSFCellStyle.ALIGN_CENTER)
      {
        styles.put("text-align", "center");
        return;
      }
    }

    styles.put("text-align", "left");
  }

  private void styleVerticalAlignment(Map<String, String> styles, XSSFCell cell)
  {
    XSSFCellStyle cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      short alignment = cellStyle.getVerticalAlignment();
      if (alignment == XSSFCellStyle.VERTICAL_BOTTOM)
      {
        styles.put("vertical-align", "bottom");
        return;
      }

      if (alignment == XSSFCellStyle.VERTICAL_CENTER)
      {
        styles.put("vertical-align", "middle");
        return;
      }
    }

    styles.put("vertical-align", "top");
  }

  private void styleBackground(Map<String, String> styles, XSSFCell cell)
  {
    XSSFCellStyle cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      XSSFColor xssf = cellStyle.getFillForegroundXSSFColor();
      if (xssf != null)
      {
        String color = getHtmlColor(xssf);
        if (color != null && !color.equals("#ffffff"))
        {
          styles.put("background-color", color);
        }
      }
    }
  }

  private String styleFont(Map<String, String> styles, XSSFCell cell)
  {
    XSSFCellStyle cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      short fontIndex = cellStyle.getFontIndex();
      XSSFFont font = sheet.getWorkbook().getFontAt(fontIndex);

      if (font.getItalic())
      {
        styles.put("font-style", "italic");
      }

      if (font.getBoldweight() == Font.BOLDWEIGHT_BOLD)
      {
        styles.put("font-weight", "bold");
      }

      styles.put("font", "" + font.getFontHeightInPoints() + "px " + font.getFontName());

      if (FONT_COLORS)
      {
        String color = getHtmlColor(font.getXSSFColor());
        if (color != null && !color.equals("#000000"))
        {
          return color;
        }
      }
    }

    return null;
  }

  private void styleBorders(Map<String, String> styles, int rowIndex, int colIndex, Span span)
  {
    XSSFCell cell = getCell(rowIndex, colIndex);
    XSSFCellStyle cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      int topThickness = 0;
      if (rowIndex > rowMin)
      {
        XSSFCell topCell = getCell(rowIndex - 1, colIndex);
        if (topCell != null)
        {
          XSSFCellStyle topCellStyle = topCell.getCellStyle();
          if (topCellStyle != null)
          {
            topThickness = getThickness(topCellStyle.getBorderBottom());
          }
        }
      }

      styleBorder(styles, "top", cellStyle.getBorderTop(), topThickness, cellStyle.getTopBorderColor());

      int leftThickness = 0;
      if (colIndex > colMin)
      {
        XSSFCell leftCell = getCell(rowIndex, colIndex - 1);
        if (leftCell != null)
        {
          XSSFCellStyle leftCellStyle = leftCell.getCellStyle();
          if (leftCellStyle != null)
          {
            leftThickness = getThickness(leftCellStyle.getBorderRight());
          }
        }
      }

      styleBorder(styles, "left", cellStyle.getBorderLeft(), leftThickness, cellStyle.getLeftBorderColor());
    }

    cell = getCell(rowIndex + span.rowspan - 1, colIndex);
    cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      styleBorder(styles, "bottom", cellStyle.getBorderBottom(), 0, cellStyle.getBottomBorderColor());
    }

    cell = getCell(rowIndex, colIndex + span.colspan - 1);
    cellStyle = cell.getCellStyle();
    if (cellStyle != null)
    {
      styleBorder(styles, "right", cellStyle.getBorderRight(), 0, cellStyle.getRightBorderColor());
    }
  }

  private void styleBorder(Map<String, String> styles, String border, short style, int peerThickness, short color)
  {
    String borderStyle = getBorderStyle(style, peerThickness);
    if (borderStyle == null)
    {
      return;
    }

    styles.put("border-" + border, borderStyle);
  }

  private int getThickness(short style)
  {
    switch (style)
    {
    case XSSFCellStyle.BORDER_NONE:
      return 0;

    case XSSFCellStyle.BORDER_MEDIUM:
      return 2;

    case XSSFCellStyle.BORDER_THICK:
      return 3;
    }

    return 1;
  }

  private String getBorderStyle(short style, int peerThickness)
  {
    if (peerThickness > 0)
    {
      switch (style)
      {
      case XSSFCellStyle.BORDER_MEDIUM:
        int mediumThickness = 2 - peerThickness;
        if (mediumThickness > 0)
        {
          return "" + mediumThickness + "px solid";
        }

        break;

      case XSSFCellStyle.BORDER_THICK:
        int thickThickness = 3 - peerThickness;
        if (thickThickness > 0)
        {
          return "" + thickThickness + "px solid";
        }

        break;
      }

      return "none";
    }

    switch (style)
    {
    case XSSFCellStyle.BORDER_HAIR:
    case XSSFCellStyle.BORDER_THIN:
      return "1px solid";

    case XSSFCellStyle.BORDER_MEDIUM:
      return "2px solid";

    case XSSFCellStyle.BORDER_THICK:
      return "3px solid";

    case XSSFCellStyle.BORDER_DOUBLE:
      return "double";

    case XSSFCellStyle.BORDER_DOTTED:
      return "dotted";

    case XSSFCellStyle.BORDER_DASHED:
    case XSSFCellStyle.BORDER_MEDIUM_DASHED:
    case XSSFCellStyle.BORDER_DASH_DOT:
    case XSSFCellStyle.BORDER_MEDIUM_DASH_DOT:
    case XSSFCellStyle.BORDER_DASH_DOT_DOT:
    case XSSFCellStyle.BORDER_MEDIUM_DASH_DOT_DOT:
    case XSSFCellStyle.BORDER_SLANTED_DASH_DOT:
      return "dashed";
    }

    return "none";
  }

  private String formatStyles(Map<String, String> styles)
  {
    String style = "";
    if (!styles.isEmpty())
    {
      style += " style=\"";
      for (Entry<String, String> entry : styles.entrySet())
      {
        style += entry.getKey() + ":" + entry.getValue() + ";";
      }

      style += "\"";
    }

    return style;
  }

  private Span getSpan(int rowIndex, int colIndex)
  {
    Span span = new Span();
    for (int i = 0; i < sheet.getNumMergedRegions(); i++)
    {
      CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
      if (mergedRegion.getFirstRow() == rowIndex && mergedRegion.getFirstColumn() == colIndex)
      {
        span.rowspan = mergedRegion.getLastRow() - mergedRegion.getFirstRow() + 1;
        span.colspan = mergedRegion.getLastColumn() - mergedRegion.getFirstColumn() + 1;
        break;
      }

      if (mergedRegion.getFirstRow() <= rowIndex && rowIndex <= mergedRegion.getLastRow()
          && mergedRegion.getFirstColumn() <= colIndex && colIndex <= mergedRegion.getLastColumn())
      {
        // Skip cell
        return null;
      }
    }

    return span;
  }

  private String formatSpan(Span span)
  {
    StringBuilder builder = new StringBuilder();

    if (span.rowspan > 1)
    {
      builder.append(" rowspan=\"");
      builder.append(span.rowspan);
      builder.append("\"");
    }

    if (span.colspan > 1)
    {
      builder.append(" colspan=\"");
      builder.append(span.colspan);
      builder.append("\"");
    }

    return builder.toString();
  }

  /**
   * @author Eike Stepper
   */
  private static class Span
  {
    public int rowspan = 1;

    public int colspan = 1;
  }
}
