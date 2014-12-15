/*
 * NAME = com.vectorsf.springmvc_base.utils.pdf.PDFExample.java;
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

package com.vectorsf.test_base.utils.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.vectorsf.test_base.model.TestBase;
import com.vectorsf.test_base.model.dao.TestBaseDAO;

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

public class PdfExample extends AbstractPdfBean {

	@Autowired (required = true) private TestBaseDAO testBaseDAO; 
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model,
			Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
 
		List<TestBase> testBaseList = testBaseDAO.findAll();
		Table table = new Table(2);
		table.addCell("Columna 1");
		table.addCell("Columna 2");
		for (TestBase testBase : testBaseList) {
			table.addCell(String.valueOf(testBase.getField1()));
			table.addCell(testBase.getField2());
		}
		document.add(table);
	}
}
