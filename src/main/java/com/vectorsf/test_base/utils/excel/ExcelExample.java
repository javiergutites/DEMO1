/*
 * NAME = com.vectorsf.springmvc_base.utils.excel.ExcelExample.java;
 *
 * COPYRIGHT (c) 2012 Vector Software Factory S.L. Reservados todos los derechos.
 * Este programa es material confidencial propiedad
 * de Vector Software Factory S.L. Se prohíbe la divulgación o revelación
 * de su contenido sin el permiso previo y por escrito del propietario.
 * COPYRIGHT (c) 2012 Vector Software Factory S.L. All rights reserved.
 * This document (Program, manual, etc.) consists of confidential information,
 * containing trade secrets that are property of Vector Software Factory S.L.
 * Its content may not be used or disclosed without prior written permission
 * of the owner.
 */

package com.vectorsf.test_base.utils.excel;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.vectorsf.test_base.model.TestBase;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 06/01/2012
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class ExcelExample extends AbstractExcelBean {

	public static final String EXCEL_EXAMPLE_FILENAME = "Example" + XlsUtils.EXCEL_EXTENSION;
	
	@Override
	protected void createHeader(HSSFSheet sheet, Map<String, Object> model) {
		HSSFRow header = sheet.createRow(rowNumber ++);
		columnNumber = XlsUtils.INITIAL_COLUMN_NUMBER;
		header.createCell(columnNumber ++).setCellValue("Columna 1");
		header.createCell(columnNumber ++).setCellValue("Columna 2");
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void createBody(HSSFSheet sheet, Map<String, Object> model) {
		List<TestBase> testBaseList = (List<TestBase>)model.get("testBaseList");
		HSSFCellStyle style = XlsUtils.createNumericFormat(workbook);
		for (TestBase testBase : testBaseList) {
			columnNumber = XlsUtils.INITIAL_COLUMN_NUMBER;
			HSSFRow row = sheet.createRow(rowNumber ++);
			XlsUtils.printNumericCell(row, testBase.getField1(), columnNumber ++, style);
			XlsUtils.printCell(row, testBase.getField2(), columnNumber ++);
		}
	}
	
	@Override
	protected String getTemplate() {
		return null;
	}

	@Override
	protected String getFileName() {
		return EXCEL_EXAMPLE_FILENAME;
	}
}
