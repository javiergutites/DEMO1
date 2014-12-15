/*
 * NAME = com.vectorsf.springmvc_base.admin.service.impl.AdminProfileServiceImpl.java;
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

package com.vectorsf.springmvc_base.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vectorsf.springmvc_base.admin.facade.ProfileFacade;
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

@Service
public class AdminProfileServiceImpl implements AdminProfileService {

	@Autowired
	private ProfileFacade profileFacade;
	
	public List<Profile> getProfiles() {
		return profileFacade.getProfiles();
	}

	public Profile getProfileById(String profileName) {
		return profileFacade.getProfileById(profileName);
	}

	@Override
	@Transactional
	public void create(Profile profile) {
		this.profileFacade.create(profile);
	}
}
