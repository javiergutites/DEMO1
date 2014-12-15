/*
 * NAME = com.vectorsf.springmvc_base.utils.AbstractXLSBean.java;
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

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.view.document.AbstractExcelView;

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

public abstract class AbstractExcelBean extends AbstractExcelView {

	private static final Logger log = LoggerFactory.getLogger(AbstractExcelBean.class);
	protected HSSFWorkbook workbook;
	protected String template;
	protected int rowNumber;
	protected int columnNumber;

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		HSSFSheet sheet = null;
		if (getTemplate() != null) {
			this.workbook = generateWorkbook(getTemplate());
			sheet = this.workbook.getSheetAt(0); 
		} else {
			this.workbook = workbook;
			sheet = this.workbook.createSheet();
		}
		
		this.rowNumber = XlsUtils.INITIAL_ROW_NUMBER;
		this.columnNumber = XlsUtils.INITIAL_COLUMN_NUMBER;
		
		createHeader(sheet, model);
		createBody(sheet, model);
		generateResponseHeader(response);
	}
	
	private void generateResponseHeader(HttpServletResponse response) {
	    response.setHeader("Content-Type", XlsUtils.EXCEL_CONTENT_TYPE);
	    response.setHeader("Content-Disposition", "attachment;filename=\"" + getFileName() + "\"");
	}
	
    /**
     * Genera un workbook a partir de una plantilla
     * @param template ruta hacia la plantilla
     * @return workbook
     * @throws IOException en caso de error
     */
    private static HSSFWorkbook generateWorkbook(String template) {
        POIFSFileSystem fs = null;

        try {
            fs = new POIFSFileSystem(new FileInputStream(template));
        } catch (Exception e1) {
            log.error("No existe la plantilla: {}", template, e1);
        }
        // asignar la plantilla al workbook
        HSSFWorkbook wb = null;

        try {
            wb = new HSSFWorkbook(fs);
        } catch (IOException e1) {
            log.error("Problemas generando la hoja: ", e1);
        }
        return wb;
    }
	
    /**
     * Obtiene el nombre de la plantilla si hubiere.
     * @return
     */
    protected abstract String getTemplate();
	/**
	 * Obtiene el nombre del fichero.
	 * @return
	 */
	protected abstract String getFileName();
	/**
	 * Crea la fila de cabecera del documento excel.
	 * @param sheet
     * @param model
	 */
	protected abstract void createHeader(HSSFSheet sheet, Map<String, Object> model);
	/**
	 * Crea el body del documento excel.
	 * @param sheet
     * @param model
	 */
	protected abstract void createBody(HSSFSheet sheet, Map<String, Object> model);
}
