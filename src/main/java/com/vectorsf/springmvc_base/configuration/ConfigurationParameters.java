/*
 * NAME = com.vectorsf.springmvc_base.configuration.ConfigurationParameters.java;
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

package com.vectorsf.springmvc_base.configuration;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 19/10/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class ConfigurationParameters {

	/* PROPERTIES FILE */
	public static final String FILE_CONFIGURATION = "configuration.properties";
	
	/* MAILS */
	public static final String MAIL_ACTIVE = "MAIL_ACTIVE";
	public static final String MAIL_FROM = "MAIL_FROM";
	
	/* SCHEDULER */ 
	public static final String SCHEDULE_ACTIVE = "SCHEDULE_ACTIVE";
	
	/* FTP PARAMETERS */
	public static final String FTP_HOST_NAME = "FTP_HOST_NAME";
	public static final String FTP_PORT = "FTP_PORT";
	public static final String FTP_USER = "FTP_USER";
	public static final String FTP_PASSWORD = "FTP_PASSWORD";
	public static final String FTP_DATA_TIMEOUT = "FTP_DATA_TIMEOUT";
	public static final String FTP_SOCKET_TIMEOUT = "FTP_SOCKET_TIMEOUT";
	public static final String FTP_BASE_PATH = "FTP_BASE_PATH";
	
	/* URL CONNECTION */
	public static final String CONNECT_TIMEOUT_BY_DEFAULT = "CONNECT_TIMEOUT_BY_DEFAULT";
	public static final String READ_TIMEOUT_BY_DEFAULT = "READ_TIMEOUT_BY_DEFAULT";
	
}