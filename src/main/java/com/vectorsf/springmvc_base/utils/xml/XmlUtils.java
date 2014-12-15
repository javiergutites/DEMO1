/*
 * NAME = com.vectorsf.springmvc_base.utils.xml.XmlUtils.java;
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

package com.vectorsf.springmvc_base.utils.xml;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vectorsf.springmvc_base.utils.GlobalParameters;
import com.vectorsf.springmvc_base.utils.exception.WrappedException;

/**
 * Class description: Clase de utilidad para el parseo de 
 * ficheros xml.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class XmlUtils {

	private static final Logger log = LoggerFactory.getLogger(XmlUtils.class);
	private JAXBContext jaxbContext;

	/**
	 * Init jaxb Context
	 * @param instance
	 */
	public void initJAXBContext(String instance) {
        JAXBContext context = null;

        /* *** JAX-B Context *** */
        log.debug("Creating the JAX-B context.");
        try {
            context = JAXBContext.newInstance(instance);
            log.debug("JAX-B context created.");
        } catch (JAXBException e) {
            log.error("JAX-B context creation failed.", e);
        }
        jaxbContext = context;
    }
	
	/**
	 * Unmarshal process
	 * @param file
	 * @return
	 */
	public Object unMarshalProcess (File file) {
		try {
			Unmarshaller u = jaxbContext.createUnmarshaller();
			return u.unmarshal(file);
		} catch (JAXBException je) {
			log.error("Error en el parseo.", je);
			throw WrappedException.wrap(je);
		} 
	}
	
	/**
	 * Marshal process with file path.
	 * @param filePath
	 * @param object
	 */
	public void marshalProcess(String filePath, Object object) {
		try {
	        OutputStream fileXML = new FileOutputStream(new File(filePath));
	        OutputStreamWriter out = new OutputStreamWriter(fileXML, Charset.forName(GlobalParameters.CHARSET));
	        BufferedWriter bufferedWriter = new BufferedWriter(out);
	        
	        Marshaller marshaller = null;
	        
	        try {
	            marshaller = getJaxbContext().createMarshaller();
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        } catch (JAXBException e) {
	            log.error("Errors creating xml converter.", e);
	            bufferedWriter.close();
	            return;
	        }

	        try {
	        	marshaller.marshal(object, bufferedWriter);
            } catch (JAXBException e) {
                log.warn("Problems with marshaller.", e);
            }
	        bufferedWriter.close();	        
	        out.close();
	        fileXML.close();
        } catch (FileNotFoundException fnfe) {
        	log.error("During the marshalling: ", fnfe);
        } catch (IOException ioe) {
        	log.error("During the marshalling: ", ioe);
        } 
	}
	
	/**
	 * Normal marshal process.
	 * @param object
	 * @return
	 */
	public String marshalProcess(Object object) {
		try {
			String data = "";
	        OutputStream outputStream = new ByteArrayOutputStream();
	        OutputStreamWriter out = new OutputStreamWriter(outputStream, Charset.forName(GlobalParameters.CHARSET));
	        BufferedWriter bufferedWriter = new BufferedWriter(out);
	        
	        Marshaller marshaller = null;
	        
	        try {
	            marshaller = getJaxbContext().createMarshaller();
	            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        } catch (JAXBException e) {
	            log.error("Errors creating xml converter.", e);
	            return data;
	        }

	        try {
	        	marshaller.marshal(object, bufferedWriter);
	        	data = outputStream.toString();
            } catch (JAXBException e) {
            	log.error("XML ERROR: Problemas con el marshaller.", e);
            } finally {
            	bufferedWriter.close();	        
    	        out.close();
    	        outputStream.close();
            }
            return data;
        } catch (IOException ioe) {
        	log.error("During the marshalling: ", ioe);
        } 
        return null;
	}
	
	/**
	 * JaxB Context.
	 * @return
	 */
    public JAXBContext getJaxbContext() {
        return jaxbContext;
    }
}
