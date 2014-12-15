/*
 * NAME = com.vectorsf.test_base.admin.controller.AdminDevelopmentController.java;
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

package com.vectorsf.test_base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vectorsf.test_base.model.dao.TestBaseDAO;
import com.vectorsf.test_base.utils.email.EmailExample;
import com.vectorsf.test_base.utils.excel.ExcelExample;

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

@Controller
public class AdminDevelopmentController {

	@Autowired private TestBaseDAO testBaseDAO;
	@Autowired private EmailExample emailExample;
	
	// MAIL
	@RequestMapping(value="/admin/development/mail.html")
	public String mailView(Model model) {
		return "admin.development.mail";
	}
	@RequestMapping(value="/admin/development/mail-test.html")
	public String mailTest(Model model) {
		emailExample.sendMail();
		return "admin.development.mail";
	}
	
	// EXCEL
	@RequestMapping(value="/admin/development/excel.html")
	public String excelView(Model model) {
		return "admin.development.excel";
	}
	@RequestMapping(value="/admin/development/excel-test.html")
	public ModelAndView excelTest(Model model) {
		model.addAttribute("testBaseList", testBaseDAO.findAll());
		return new ModelAndView(new ExcelExample(), model.asMap());
	}
	
	// PDF
	@RequestMapping(value="/admin/development/pdf.html")
	public String pdfView(Model model) {
		return "admin.development.pdf";
	}
	@RequestMapping(value="/admin/development/pdf-test.html")
	public ModelAndView pdfTest(Model model) {
		return new ModelAndView("pdfExampleView");
	}
	
	// SCHEDULER
	@RequestMapping(value="/admin/development/scheduler.html")
	public String schedulerView(Model model) {
		return "admin.development.scheduler";
	}
	@RequestMapping(value="/admin/development/scheduler-test.html")
	public ModelAndView schedulerTest(Model model) {
		return new ModelAndView("schedulerExampleView");
	}
	
	// FTP
	@RequestMapping(value="/admin/development/ftp.html")
	public String ftpView(Model model) {
		return "admin.development.ftp";
	}
	@RequestMapping(value="/admin/development/ftp-test.html")
	public ModelAndView ftpTest(Model model) {
		return new ModelAndView("ftpExampleView");
	}
}
