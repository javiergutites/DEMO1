/*
 * NAME = com.vectorsf.springmvc_base.configuration.Configuration.java;
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

import java.util.Properties;

import com.vectorsf.springmvc_base.utils.file.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class Configuration {

	private static Configuration instance;
	private Properties configurationFile;
	private static final Logger log = LoggerFactory.getLogger(Configuration.class);
	
	public Configuration() {
	}

	/**
	 * Método singleton que obtiene o crea la única instancia de configuración existente.
	 * 
	 * @return instancia de configuracion.
	 */
	public static Configuration getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}
	
	public Properties getConfigurationFile() {
		return configurationFile;
	}
	public void setConfigurationFile(Properties configurationFile) {
		this.configurationFile = configurationFile;
	}
	
	/**
	 * Método sincronizado para obtener una única instance de configuración.
	 * No contiene log como tal ya que no se puede haber inicializado.
	 */
	private static synchronized void createInstance() {
		instance = new Configuration();
		try {
			instance.setConfigurationFile(FileUtils.getPropertiesFile(ConfigurationParameters.FILE_CONFIGURATION));
		} catch(Exception e) {
			instance.setConfigurationFile(new Properties());
			log.error("No se ha encontrado el fichero de propiedades.");
		}
	}
	
	/**
	 * Obtiene un determinado parámetro del archivo de configuracion a través de su key.
	 * 
	 * @param key nombre del parámetro cuyo valor se desea obtener
	 * @return valor del parametro.
	 * @throws Exception. 
	 */
	public String getParameter(String key) throws Exception {
		String value = getProperty(key);
		if (value == null || value.trim().length() == 0) {
			throw new Exception("No existe el parámetro (" + key + ")");
		}
		log.info("Recogiendo parámetro " + key + " con valor: " + value);
		return value;
	}

	/**
	 * Obtiene un determinado parámetro del archivo de configuración a través de su key. En caso de
	 * no existir, se coloca el valor por defecto que esté indicado.
	 * 
	 * @param key nombre del parámetro cuyo valor se desea obtener.
	 * @param valorPorDefecto valor por defecto del parámetro.
	 * @return valor del parámetro.
	 */
    public String getParameter(String key, String defaultValue) {
    	String value = getProperty(key);
        if (value == null) {
            value = defaultValue;
        }
        return value;
    }
     
    /**
     * Obtiene un determinado parámetro entero del archivo de configuración a través de su key.
     * 
     * @param key nombre del parámetro cuyo valor se desea obtener.
     * @return valor del parámetro.
     * @throws Exception
     */
    public int getIntegerParameter(String key) throws Exception {
    	String value = getParameter(key);
    	try {
    		log.info("Recogiendo parámetro " + key + " con valor: " + value);
    		return Integer.parseInt(value);
    	} catch (NumberFormatException nfe) {
			throw new Exception("Parametro de configuración " + key + " en formato inesperado.");
    	}
	}
 
    /**
	 * Obtiene un determinado parámetro entero del archivo de configuración a través de su key. 
	 * En caso de no existir, se coloca el valor por defecto que esté indicado.
	 * 
     * @param key nombre del parámetro cuyo valor se desea obtener.
     * @param defaultValue valor por defecto del parámetro.
     * @return valor del parametro
     */
	public int getIntegerParameter(String key, int defaultValue) {
		String value = getParameter(key, String.valueOf(defaultValue));
		try {
			if (value == null) {
				log.info("Recogiendo parámetro " + key + " con valor: " + defaultValue);
				return defaultValue;
			}
			log.info("Recogiendo parámetro " + key + " con valor: " + value);
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			log.error("Parametro de configuración " + key + " con formato inesperado.");
			return defaultValue;
		}
	}
 
    /**
     * Obtiene un determinado parámetro booleano del archivo de configuración a través de su key.
     * 
     * @param key nombre del parámetro cuyo valor se desea obtener.
     * @return valor del parámetro.
     * @throws Exception
     */
	public boolean getBooleanParameter(String key) throws Exception {
		String value = getParameter(key);
		try {
			log.info("Recogiendo parámetro " + key + " con valor: " + value);
			return "true".equals(value.trim());
		} catch (Exception e) {
			throw new Exception("Parametro de configuración " + key + " en formato inesperado.");
		}
	}
 
    /**
	 * Obtiene un determinado parámetro booleano del archivo de configuración a través de su key. 
	 * En caso de no existir, se coloca el valor por defecto que esté indicado.
	 * 
     * @param key nombre del parámetro cuyo valor se desea obtener.
     * @param defaultValue valor por defecto del parámetro.
     * @return valor del parametro
     */
	public boolean getBooleanParameter(String key, boolean defaultValue) {
		String value = getParameter(key, String.valueOf(defaultValue));
		if (value == null) {
			log.info("Recogiendo parámetro " + key + " con valor: " + defaultValue);
			return defaultValue;
		}
		log.info("Recogiendo parámetro " + key + " con valor: " + value);
		return "true".equals(value.trim());
	}
	
	/**
	 * Obtiene el valor de la propiedad a partir del fichero de propiedades.
	 * 
	 * @param key nombre del parámetro cuyo valor se desea obtener
	 * @return valor del parámetro
	 */
	public String getProperty(String key) {
		return getConfigurationFile().getProperty(key);
	}
}