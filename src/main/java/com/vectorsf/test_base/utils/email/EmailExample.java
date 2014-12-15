/*
 * NAME = com.vectorsf.springmvc_base.utils.email.EmailExample.java;
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

package com.vectorsf.test_base.utils.email;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 30/01/2012
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Component
public class EmailExample {

	@Autowired
	private EmailManager emailManager;
	
	public void sendMail() {
		String subject = "subject-example";
		String template = "mail-example.vm";
		String from = "drodrigueza@vectorsf.com";
		String[] to = new String[]{"mrodriguezy@vectorsf.com"};
		String[] cc = new String[]{"mrodriguezy@vectorsf.com"};
		String[] bcc = new String[]{"mrodriguezy@vectorsf.com"};
		HashMap<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("text", "ATRIBUTO TEXT INCLUIDO.");
		emailManager.send(subject, template, from, to, cc, bcc, attributes);
	}
}