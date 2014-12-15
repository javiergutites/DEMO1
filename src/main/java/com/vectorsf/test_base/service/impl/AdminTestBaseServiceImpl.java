/*
 * NAME = com.vectorsf.test_base.service.impl.AdminTestBaseServiceImpl.java;
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

package com.vectorsf.test_base.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectorsf.test_base.facade.TestBaseFacade;
import com.vectorsf.test_base.model.TestBase;
import com.vectorsf.test_base.service.AdminTestBaseService;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 20/07/2012
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Service
public class AdminTestBaseServiceImpl implements AdminTestBaseService {

	@Autowired private TestBaseFacade testBaseFacade;
	
	@Override
	public List<TestBase> getTestBases() {
		return testBaseFacade.getTestBases();
	}

	@Override
	public TestBase getTestBaseById(Integer testBaseId) {
		return testBaseFacade.getTestBaseById(testBaseId);
	}
}
