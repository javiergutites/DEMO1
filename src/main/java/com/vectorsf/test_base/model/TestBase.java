/*
 * NAME = com.vectorsf.test_base.admin.model.TestBase.java;
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

package com.vectorsf.test_base.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name="test_base")
public class TestBase {

	@Id
	private Integer field1;
	private String field2;
	
	public Integer getField1() {
		return field1;
	}
	public void setField1(Integer field1) {
		this.field1 = field1;
	}
	
	public String getField2() {
		return field2;
	}
	public void setField2(String field2) {
		this.field2 = field2;
	}
}
