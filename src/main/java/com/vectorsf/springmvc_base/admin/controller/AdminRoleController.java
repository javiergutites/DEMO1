/*
 * NAME = com.vectorsf.springmvc_base.admin.controller.AdminRoleController.java;
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

import com.vectorsf.springmvc_base.admin.model.Role;
import com.vectorsf.springmvc_base.admin.service.AdminRoleService;

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
public class AdminRoleController {

	@Autowired
	private AdminRoleService adminRoleService;
	
	@RequestMapping(value="/admin/role/list.html")
	public String list(Model model) {
		List<Role> roleList = adminRoleService.getRoles();
		model.addAttribute("roleList", roleList);
		return "admin.role.list";
	}
	
	@RequestMapping(value="/admin/role/{roleId}.html")
	public String detail(Model model) {
		return "admin.role.detail";
	}
}
