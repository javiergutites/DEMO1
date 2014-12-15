/*
 * NAME = com.vectorsf.springmvc_base.utils.url.UrlUtils.java;
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

package com.vectorsf.springmvc_base.utils.url;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vectorsf.springmvc_base.configuration.Configuration;
import com.vectorsf.springmvc_base.configuration.ConfigurationParameters;
import com.vectorsf.springmvc_base.utils.GlobalParameters;

/**
 * Class description: Clase de utilidad para urls.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class UrlUtils {
	
	private static final Logger log = LoggerFactory.getLogger(UrlUtils.class);

	public static final Map<Character, Character> SPECIAL_CHARACTERS_MAP = new HashMap<Character, Character>();
	static {
		// tilde
		SPECIAL_CHARACTERS_MAP.put('\u00b4', '-');
		// minusculas con tildes
		SPECIAL_CHARACTERS_MAP.put('\u00e1', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00e9', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ed', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f3', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00fa', 'u');
		// mayusculas con tilde
		SPECIAL_CHARACTERS_MAP.put('\u00e0', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00e8', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ec', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f2', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00f9', 'u');
		SPECIAL_CHARACTERS_MAP.put('\u00e4', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00eb', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ef', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f6', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00fc', 'u');
		// minusculas acentos hacia atras
		SPECIAL_CHARACTERS_MAP.put('\u00e0', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00e8', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ec', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f2', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00f9', 'u');
		// mayusculas acentos hacia atras
		SPECIAL_CHARACTERS_MAP.put('\u00c0', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00c8', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00cc', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00d2', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00d9', 'u');
		// minusculas acentos circunflejos
		SPECIAL_CHARACTERS_MAP.put('\u00e2', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00ea', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ee', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f4', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00fb', 'u');
		// mayusculas dieresis
		SPECIAL_CHARACTERS_MAP.put('\u00e4', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00eb', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ef', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00d6', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00fc', 'u');
		// minusculas dieresis
		SPECIAL_CHARACTERS_MAP.put('\u00c4', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00cb', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00cf', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00f6', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00dc', 'u');
		// mayusculas acentos circunflejos
		SPECIAL_CHARACTERS_MAP.put('\u00c2', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00ca', 'e');
		SPECIAL_CHARACTERS_MAP.put('\u00ce', 'i');
		SPECIAL_CHARACTERS_MAP.put('\u00d4', 'o');
		SPECIAL_CHARACTERS_MAP.put('\u00db', 'u');
		// minusculas con virgulilla
		SPECIAL_CHARACTERS_MAP.put('\u00e3', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00f5', 'o');
		// mayusculas con virgulilla
		SPECIAL_CHARACTERS_MAP.put('\u00c3', 'a');
		SPECIAL_CHARACTERS_MAP.put('\u00d4', 'o');
		// C minuscula con cedilla
		SPECIAL_CHARACTERS_MAP.put('\u00e7', 'c');
		// C mayuscula con cedilla
		SPECIAL_CHARACTERS_MAP.put('\u00c7', 'c');
		// otros caracteres
		SPECIAL_CHARACTERS_MAP.put(' ', '-');
		SPECIAL_CHARACTERS_MAP.put('/', '-');
		SPECIAL_CHARACTERS_MAP.put('\u00f1', 'n');
		SPECIAL_CHARACTERS_MAP.put('\'', '-');
		SPECIAL_CHARACTERS_MAP.put('"', '-');
		SPECIAL_CHARACTERS_MAP.put('?', '-');
		SPECIAL_CHARACTERS_MAP.put('.', '-');
		SPECIAL_CHARACTERS_MAP.put('\u0026', null);
	}

	public static String encodeName(String name) {
		if (name == null)
			return null;
		String encodedName = name.toLowerCase();
		Iterator<Entry<Character, Character>> it = SPECIAL_CHARACTERS_MAP.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Character, Character> entry = it.next();
			if (entry.getValue() != null) {
				encodedName = encodedName.replace(entry.getKey(), entry.getValue());
			}
		}
		encodedName = encodedName.replaceAll("\u0026", "and"); // &

		return encodedName;
	}
	
	public static InputStream connect(String urlString, String contentToSend, int connectTimeout, int readTimeout)
			throws SocketTimeoutException, FileNotFoundException, Exception {
		URLConnection con;
		OutputStreamWriter out = null;
		long timestamp = 0L;
		try {
			try {
				if (log.isDebugEnabled()) {
					log.debug("Attempting to connect to url {} with connectTimeout {} and readTimeout {}",
                            new Object[] {urlString, connectTimeout, readTimeout});
					timestamp = System.currentTimeMillis();
				}
				URL url = new URL(urlString);
				con = url.openConnection();
				con.setDoInput(true);
				con.setDoOutput((contentToSend == null)?false:true);
				con.setUseCaches(false);
				if (connectTimeout != 0)
					con.setConnectTimeout(connectTimeout);
				else
					con.setConnectTimeout(Configuration.getInstance().getIntegerParameter(ConfigurationParameters.CONNECT_TIMEOUT_BY_DEFAULT, 10000));
				if (readTimeout != 0)
					con.setReadTimeout(readTimeout);
				else
					con.setReadTimeout(Configuration.getInstance().getIntegerParameter(ConfigurationParameters.READ_TIMEOUT_BY_DEFAULT, 10000));
				
//				con.setRequestProperty("Content-Length", String.valueOf(contentToSend.length()));
//				con.setRequestMethod("POST");
//				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				
				if (contentToSend != null) {
					// write
					out = new OutputStreamWriter(con.getOutputStream(), GlobalParameters.CHARSET);
	                out.write(contentToSend);
	                out.flush();
	                out.close();
	                out = null;
				}

                // read
                return con.getInputStream();
			} finally {
				if (out != null)
					out.close();
				if (log.isDebugEnabled()) {
					log.debug("Request to url " + urlString + " served in " +
							(System.currentTimeMillis() - timestamp) + " ms.");
				}
			}
		} catch (SocketTimeoutException e) {
			log.warn("Error conecting to URL: {}, error message: ", urlString, e);
			throw e;
		} catch (FileNotFoundException e) {
			// If Apache is listening but Tomcat is not, the errors are 404 and 50X, not SocketTimeout
			log.warn("Error conecting to URL: {}, error message: ", urlString, e);
			throw e;
		} catch (Exception e) {
			log.warn("Error conecting to URL: {}, error message: ", urlString, e);
			throw e;
		}
	}
	
	/**
	 * Connect to an specified url,  
	 * @param urlString url to connect
	 * @param connectTimeout connect timeout specified for the connection.  
	 * @param readTimeout read timeout specified for the connection.
	 * @return response sent by remote URL 
	 */
	public static StringBuffer connectSB(String urlString, String contentToSend, int connectTimeout, int readTimeout)
			throws SocketTimeoutException, FileNotFoundException, Exception {
		
		StringBuffer str = new StringBuffer();
				
        // read
        InputStream in = connect(urlString, contentToSend, connectTimeout, readTimeout);
		InputStreamReader res = new InputStreamReader(in, GlobalParameters.CHARSET);

		char[] buf = new char[1024];
		int num;
		while ((num = res.read(buf)) != -1) {
			str.append(buf, 0, num);
		}
		res.close();
		return str;
	}
}
