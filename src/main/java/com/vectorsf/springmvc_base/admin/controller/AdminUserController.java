/*
 * NAME = com.vectorsf.springmvc_base.admin.controller.AdminUserController.java;
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

package com.vectorsf.springmvc_base.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vectorsf.springmvc_base.admin.model.User;
import com.vectorsf.springmvc_base.admin.service.AdminUserService;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 02/12/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Controller
public class AdminUserController {

	@Autowired
	private AdminUserService adminUserService;
	
	@RequestMapping(value="/admin/user/list.html")
	public String list(Model model) {
		List<User> userList = adminUserService.getUsers();
		model.addAttribute("userList", userList);
		return "admin.user.list";
	}
	
	@RequestMapping(value="/admin/user/{userId}.html")
	public String detail(Model model) {
		return "admin.user.detail";
	}
}
