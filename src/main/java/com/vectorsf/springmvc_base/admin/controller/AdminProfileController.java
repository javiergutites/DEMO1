/*
 * NAME = com.vectorsf.springmvc_base.admin.controller.AdminProfileController.java;
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
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vectorsf.springmvc_base.admin.controller.forms.ProfileForm;
import com.vectorsf.springmvc_base.admin.model.Profile;
import com.vectorsf.springmvc_base.admin.service.AdminProfileService;

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
public class AdminProfileController {
	
	@Autowired
	private AdminProfileService adminProfileService;
	
	@Autowired
	private MessageSource messageSource;
	
	@ModelAttribute("profileForm")
	public final ProfileForm getProfileForm() {
		return new ProfileForm();
	}
	
	@RequestMapping(value="/admin/profile/list.html")
	public String list(Model model) {
		List<Profile> profileList = adminProfileService.getProfiles();
		model.addAttribute("profileList", profileList);
		return "admin.profile.list";
	}
	
	@RequestMapping(value="/admin/profile/{profileId}.html")
	public String detail(Model model) {
		return "admin.profile.detail";
	}
	
	@RequestMapping(value="/admin/profile/add.html")
	public String add(@Valid @ModelAttribute("profileForm") ProfileForm profileForm, BindingResult errors, Model model, Locale locale) {
		
		if (!errors.hasErrors()) {
			Profile profile = new Profile();
			profile.setName(profileForm.getName());
			profile.setDescription(profileForm.getDescription());
			try {
				this.adminProfileService.create(profile);
				model.addAttribute("message", this.messageSource.getMessage("profile.create.success", null, locale));
			} catch (Exception e) {
				model.addAttribute("message", this.messageSource.getMessage("profile.create.error", null, locale));
			}
		}
		
		return list(model);
	}
}
