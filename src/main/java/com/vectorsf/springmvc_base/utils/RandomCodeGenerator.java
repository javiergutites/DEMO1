/*
 * NAME = com.vectorsf.springmvc_base.utils.RandomCodeGenerator.java;
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

package com.vectorsf.springmvc_base.utils;

import java.util.Random;

/**
 * Class description: Clase que genera códigos aleatorios.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class RandomCodeGenerator {

	public static final String DEFAULT_CHARS_ALLOWED = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final int DEFAULT_RANDOM_CHARS_NUMBER = 10;
	
	/**
	 * Genera un código aleatorio alfanumérico con el String indicado como prefijo y el 
	 * número de carácteres. 
	 * @param prefix
	 * @return código aleatorio
	 */
	public static String generateRandomCode (String prefix, int randomCharsNumbers) {
		Random r = new Random();
		String code = (prefix != null && !prefix.trim().equals("") ? prefix + "@" : "");
		for (int i = 0; i < randomCharsNumbers; i++) {
			code += DEFAULT_CHARS_ALLOWED.charAt(r.nextInt(DEFAULT_CHARS_ALLOWED.length())); 
		}
		return code;
	}
	
	/**
	 * Genera un código aleatorio alfanumérico con el string indicado como prefijo 
	 * @param prefix
	 * @return código aleatorio
	 */
	public static String generateRandomCode (String prefix) {
		return generateRandomCode(prefix, DEFAULT_RANDOM_CHARS_NUMBER);
	}
	
	/**
	 * Genera un código aleatorio alfanumérico con los carácteres indicados. 
	 * @param randomCharsNumber
	 * @return código aleatorio
	 */
	public static String generateRandomCode (int randomCharsNumber) {
		return generateRandomCode(null, randomCharsNumber);
	}
	
	/**
	 * Genera un código aleatorio alfanumérico. 
	 * @param randomCharsNumber
	 * @return código aleatorio
	 */
	public static String generateRandomCode () {
		return generateRandomCode(null, DEFAULT_RANDOM_CHARS_NUMBER);
	}
}
