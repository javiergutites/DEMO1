/*
 * NAME = com.vectorsf.test_base.facade.impl.TestBaseFacadeImpl.java;
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

package com.vectorsf.test_base.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googlecode.ehcache.annotations.Cacheable;
import com.vectorsf.test_base.facade.TestBaseFacade;
import com.vectorsf.test_base.model.TestBase;
import com.vectorsf.test_base.model.dao.TestBaseDAO;

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
public class TestBaseFacadeImpl implements TestBaseFacade {

	private final static Logger log = LoggerFactory.getLogger(TestBaseFacadeImpl.class);

	@Autowired private TestBaseDAO testBaseDAO;
	
	@Cacheable(cacheName = "testBases")
	public List<TestBase> getTestBases() {
		log.debug("ADMIN: Listing test bases.");
		return testBaseDAO.findAll();
	}

	public TestBase getTestBaseById(Integer testBaseId) {
		log.debug("ADMIN: Searching testBase by id " + testBaseId);
		return testBaseDAO.findById(testBaseId);
	}
}
