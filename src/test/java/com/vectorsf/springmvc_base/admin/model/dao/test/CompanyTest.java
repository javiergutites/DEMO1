/*
 * COPYRIGHT (c) 2013 Vector Software Factory S.L. Reservados todos los derechos.
 * Este programa es material confidencial propiedad
 * de Vector Software Factory S.L. Se prohíbe la divulgación o revelación
 * de su contenido sin el permiso previo y por escrito del propietario.
 * COPYRIGHT (c) 2013 Vector Software Factory S.L. All rights reserved.
 * This document (Program, manual, etc.) consists of confidential information,
 * containing trade secrets that are property of Vector Software Factory S.L.
 * Its content may not be used or disclosed without prior written permission
 * of the owner.
 */

package com.vectorsf.springmvc_base.admin.model.dao.test;

import org.springframework.beans.factory.annotation.Autowired;

import com.vectorsf.springmvc_base.admin.model.Company;
import com.vectorsf.springmvc_base.admin.model.dao.CompanyDAO;
import com.vectorsf.springmvc_base.dao.DAO;

/**
 * Class description: -
 * User: Alvaro Alvarez
 * Date: Jan 17, 2013
 * 
 * @author Alvaro Alvarez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class CompanyTest  extends TestDAO<Company, Integer> {

	@Autowired
	private CompanyDAO companyDAO;
	
	public DAO<Company, Integer> getDAO() {
		return companyDAO;
	}
	
	public Integer getId() {
		return -1;
	}

	@Override
	public Company createObject(Integer id) {
		Company sp = new Company();
		sp.setName("prueba");
		sp.setAddress("prueba2");
		sp.setPhone("91626262");
		sp.setId(id);
		return sp;
	}

	@Override
	public void changeValueForMerge(Company object) {
		object.setName("pruebas");
	}

	@Override
	public boolean verifyValueAfterMerge(Company object) {
		return object.getName().equalsIgnoreCase("pruebas");
	}
}