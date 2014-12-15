/*
 * NAME = com.vectorsf.springmvc_base.admin.service.impl.CompanyServiceImpl.java;
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

package com.vectorsf.springmvc_base.admin.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectorsf.springmvc_base.admin.facade.CompanyFacade;
import com.vectorsf.springmvc_base.admin.model.Company;
import com.vectorsf.springmvc_base.admin.model.dao.CompanyDAO;

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
public class CompanyFacadeImpl implements CompanyFacade {
	
	private final static Logger log = LoggerFactory.getLogger(CompanyFacadeImpl.class);

	@Autowired
	private CompanyDAO companyDAO;
	
	public List<Company> getCompanies() {
		log.debug("ADMIN: Listing companies.");
		return companyDAO.findAll();
	}

	public Company getCompanyById(int companyId) {
		log.debug("ADMIN: Searching company by id " + companyId);
		return companyDAO.findById(companyId);
	}
}
