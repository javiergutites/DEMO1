/*
 * NAME = com.vectorsf.springmvc_base.admin.service.impl.AdminCompanyServiceImpl.java;
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

import com.vectorsf.springmvc_base.admin.facade.CompanyFacade;
import com.vectorsf.springmvc_base.admin.model.Company;
import com.vectorsf.springmvc_base.admin.service.AdminCompanyService;

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
public class AdminCompanyServiceImpl implements AdminCompanyService {

	@Autowired
	private CompanyFacade companyFacade;
	
	public List<Company> getCompanies() {
		return companyFacade.getCompanies();
	}

	public Company getCompanyById(int companyId) {
		return companyFacade.getCompanyById(companyId);
	}
}
