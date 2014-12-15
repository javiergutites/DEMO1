/*
 * NAME = com.vectorsf.springmvc_base.utils.XLSUtils.java;
 *
 * COPYRIGHT (c) 2011 Vector Software Factory S.L. Reservados todos los derechos.
 * Este programa es material confidencial propiedad
 * de Vector Software Factory S.L. Se prohíbe la divulgación o revelación
 * de su contenido sin el permiso previo y por escrito del propietario.
 * COPYRIGHT (c) 2011 Vector Software Factory S.L. All rights reserved.
 * This document (Program, manual, etc.) consists of confidential information,
 * containing trade secrets that are property of Vector Software Factory S.L.
 * Its content may not be used or disclosed without prior written permission
 * of the owner.
 */

package com.vectorsf.test_base.utils.excel;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.vectorsf.springmvc_base.utils.date.DateUtils;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 26/12/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class XlsUtils {
	
	public static final String EXCEL_NAME = "excel";
	public static final String EXCEL_CONTENT_TYPE = "application/vnd.ms-excel";
	public static final String EXCEL_EXTENSION = ".xls";
	public static final Integer LIMIT_EXCEL_ROWS = 65535;
	public static final int INITIAL_ROW_NUMBER = 0;
	public static final int INITIAL_COLUMN_NUMBER = 0;
    
	/**
	 * Escribe una celda en formato cadena.
	 * @param row fila
	 * @param value valor
	 * @param cellNumber
	 */
	public static void printCell (HSSFRow row, String value, int cellNumber){
		HSSFCell cell = row.createCell(cellNumber);
		cell.setCellValue(new HSSFRichTextString(value));
	}
	
	/**
	 * Escribe una celda en formato determinado.
	 * @param value
	 * @param cell
	 * @param cellNumber
	 * @param style
	 */
	public static void printCell (String value, HSSFRow row, int cellNumber, HSSFCellStyle style) {
		HSSFCell cell = row.createCell(cellNumber);
		cell.setCellValue(value);
		cell.setCellStyle(style);
	}

	/**
	 * Escribe una celda en formato numérico.
	 * @param value
	 * @param cell
	 * @param format
	 */
	public static void printNumericCell(Double value, HSSFCell cell, HSSFCellStyle format){
		if (value != null) {
			cell.setCellValue(value.doubleValue());
			cell.setCellStyle(format);
		}
	}
	
	/**
	 * Escribe una celda en formato numérico.
	 * @param value
	 * @param cell
	 * @param format
	 */
	public static void printNumericCell(Integer value, HSSFCell cell, HSSFCellStyle format){
		if (value != null) {
			printNumericCell(value.doubleValue(), cell, format);
		} else {
			printNumericCell(new Double(0), cell, format);
		}
	}
	
    /**
     * Añade una celda numérica a partir de un Double a la fila según el formato indicado
     * 
     * @param row fila
     * @param value valor
     * @param cellNumber número de celda
     * @param format formato
     */
    public static void printNumericCell(HSSFRow row, Double value, int cellNumber, HSSFCellStyle format) {
    	HSSFCell cell = row.createCell(cellNumber);
        printNumericCell(value, cell, format);
    }
	
    /**
     * Añade una celda con una fecha
     * @param row fila
     * @param cellNumber número de celda
     * @param value fecha
     * @param format formateador de la fecha
     */
    public static void printDateCell(HSSFRow row, int cellNumber, Date value, HSSFCellStyle format) {
    	HSSFCell cell = row.createCell(cellNumber);
        cell.setCellStyle(format);
        cell.setCellValue(value);
    }

    /**
     * Añade una celda numérica a partir de un BigDecimal a la fila según el formato indicado
     * @param row fila
     * @param value valor
     * @param cellNumber número de celda
     * @param format formato
     */
    public static void printNumericCell(HSSFRow row, BigDecimal value, int cellNumber, HSSFCellStyle format) {
        if (value != null) {
            printNumericCell(row, new Double(value.doubleValue()), cellNumber, format);
        }
    }
    
    /**
     * Añade una celda numérica a partir de un Integer a la fila según el formato indicado
     * 
     * @param row fila
     * @param value valor
     * @param cellNumber número de celda
     * @param format formato
     */
    public static void printNumericCell(HSSFRow row, Integer value, int cellNumber, HSSFCellStyle format) {
        if (value != null) {
            printNumericCell(row, new Double(value.doubleValue()), cellNumber, format);
        }
    }
    
    /**
     * Añade una celda numérica a partir de un Long a la fila según el formato indicado
     * 
     * @param row fila
     * @param value valor
     * @param cellNumber número de celda
     * @param format formato
     */
    public static void printNumericCell(HSSFRow row, Long value, int cellNumber, HSSFCellStyle format) {
        if (value != null) {
            printNumericCell(row, new Double(value.doubleValue()), cellNumber, format);
        }
    }
    
    public static void printDateCell(HSSFRow row, Date value, int cellNumber, HSSFCellStyle format) {
    	if (value != null) {
    		printDateCell(row, cellNumber, value, format);
    	}
    }
    
	/**
	 * Da formato decimal de 2 decimales al libro.
	 * @param workbook libro
	 * @return
	 */
	public static HSSFCellStyle createDecimalFormat(HSSFWorkbook workbook) {
		HSSFCellStyle decimalsFormat = workbook.createCellStyle();
        decimalsFormat.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0.00"));
        return decimalsFormat;
	}
    
    /**
     * Crea un formateador para formato moneda
     * @param workbook libro
     * @return format
     */
    public static HSSFCellStyle createCurrencyFormat(HSSFWorkbook workbook) {
        HSSFCellStyle currencyFormat = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat();
        currencyFormat.setDataFormat(format.getFormat("#,##0.00"));
        return currencyFormat;
    }
    
    /**
     * Crea un formateador para fecha
     * @param workbook libro
     * @return dateFormat
     */
    public static HSSFCellStyle createDateFormat(HSSFWorkbook workbook) {
        HSSFCellStyle dateFormat = workbook.createCellStyle();
        HSSFDataFormat format = workbook.createDataFormat(); 
        dateFormat.setDataFormat(format.getFormat(DateUtils.COMMON_PATTERN));
        return dateFormat;
    }
    
    /**
     * Crea un formateador para formato numerico
     * @param workbook libro
     * @return format
     */
    public static HSSFCellStyle createNumericFormat(HSSFWorkbook workbook) {
        HSSFCellStyle numericFormat = workbook.createCellStyle();
        numericFormat.setDataFormat(HSSFDataFormat.getBuiltinFormat("0"));
        return numericFormat;
    }
}