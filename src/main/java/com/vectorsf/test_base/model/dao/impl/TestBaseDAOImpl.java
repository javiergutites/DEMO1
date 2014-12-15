/*
 * NAME = com.vectorsf.test_base.model.dao.impl.TestBaseDAOImpl.java;
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

package com.vectorsf.test_base.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.vectorsf.springmvc_base.dao.DAOImpl;
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

@SuppressWarnings("serial")
@Repository
public class TestBaseDAOImpl extends DAOImpl<TestBase, Integer> implements TestBaseDAO {

}
