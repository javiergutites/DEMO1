/*
 * NAME = com.vectorsf.test_base.facade.TestBaseFacade.java;
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

package com.vectorsf.test_base.facade;

import java.util.List;

import com.vectorsf.test_base.model.TestBase;

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

public interface TestBaseFacade {

	/**
	 * Obtiene todos los test base.
	 * @return
	 */
	public List<TestBase> getTestBases();
	
	/**
	 * Obtiene un test base por su id.
	 * @param field1
	 * @return
	 */
	public TestBase getTestBaseById(Integer field1);
}
