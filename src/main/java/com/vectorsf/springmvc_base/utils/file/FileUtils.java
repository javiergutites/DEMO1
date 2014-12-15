/*
 * NAME = com.vectorsf.springmvc_base.utils.file.FileUtils.java;
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

package com.vectorsf.springmvc_base.utils.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vectorsf.springmvc_base.configuration.Configuration;

/**
 * Class description: Clase de utilidades sobre el
 * tratamiento de ficheros.
 * User: Marcelo Rodriguez
 * Date: 05/10/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class FileUtils {

	public static Logger log = LoggerFactory.getLogger(FileUtils.class);
	public static final String SEPARATOR = "/";
	public static final int BUFFER = 1024;
	
	/**
	 * Get the <k>properties</k> of a given file.
	 * 
	 * @param pathPropertiesFile properties file path
	 * @return the properties
	 * @throws Exception
	 */
	public static Properties getPropertiesFile(String pathPropertiesFile) throws Exception {
		Properties props = new Properties();
		InputStream in = Configuration.class.getClassLoader().getResourceAsStream(pathPropertiesFile);
		if (in != null) {
			props.load(in);
			in.close();
		} 
		return props;
	}
	
	/**
	 * Delete a full directory. 
	 * @param directoryPath
	 */
	public static void deleteDirectory(String directoryPath) {
		File directory = new File(directoryPath);
		deleteDirectory(directory);
	}
	
	/**
	 * Delete a full directory.
	 * @param directory
	 */
	public static void deleteDirectory(File directory) {
		File[] files = directory.listFiles();
		for (int x = 0; x < files.length; x++){
            if (files[x].isDirectory()) {
            	deleteDirectory(files[x]);
            }
            deleteFile(files[x]);
		}      
	}
	
	/**
	 * Copy originDirectory into destinationDirectory.
	 * @param originDirectory
	 * @param destinationDirectory
	 */
	public static void copyDirectory(File originDirectory, File destinationDirectory) {
		log.debug("Copying directory {} into {}", originDirectory, destinationDirectory);
		if (originDirectory.isDirectory()) {
			// if not exists destination directory, make a dir.
            if (!destinationDirectory.exists()){                              
            	destinationDirectory.mkdir();
            }

            String[] ficheros = originDirectory.list();
            for (int x=0;x<ficheros.length;x++) {
            	// For each directory (or file), new copy directory.
                copyDirectory(new File(originDirectory, ficheros[x]), new File(destinationDirectory, ficheros[x]));                           
            }

		} else {
			copyFile(originDirectory, destinationDirectory);
		}
		log.info("Copy finished for directory {}", originDirectory);
	}
	
	/**
	 * Copy origin file into destination file.
	 * @param originFile
	 * @param destinationFile
	 */
	public static void copyFile(File originFile, File destinationFile) {
		log.debug("Copying file {} into {}", originFile, destinationFile);
		try {
            InputStream in = new FileInputStream(originFile);
            OutputStream out = new FileOutputStream(destinationFile);
                    
            byte[] buf = new byte[BUFFER];
            int len;

            while ((len = in.read(buf)) > 0) {
            	out.write(buf, 0, len);
            }
    
            in.close();
            out.close();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		log.info("Copy finished for file {}", originFile.toString());
	}
	
	/**
	 * Move a origin file into a destinationFilePath+fileName.
	 * @param originFile
	 * @param destinationFilePath
	 * @param fileName
	 */
	public static void moveFile(String originFile, String destinationFilePath, String fileName) {
		File destinationFile = new File(destinationFilePath);
		if (!destinationFile.exists()) {
			destinationFile.mkdir();
		}
		copyFile(new File(originFile), new File(destinationFilePath + fileName));
		deleteFile(originFile);
	}
	
	/**
	 * Delete a file.
	 * @param filePath
	 */
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		deleteFile(file);
	}
	
	/**
	 * Delete a file.
	 * @param file
	 */
	public static void deleteFile(File file) {
		file.delete();
	}
	
	/**
	 * Lee un fichero y devuelve su información.
	 * @param fileName
	 * @return
	 */
	public static String readFile(String fileName) {
		StringBuilder contents = new StringBuilder();
		try {
			BufferedReader input = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = input.readLine()) != null) {
				contents.append(line);
			}
			input.close();
		} catch (IOException ex) {
			log.error("No ha sido posible leer el fichero {}", fileName);
		}
		return contents.toString();
	}
	
	/**
	 * Crea un fichero a partir de un inputStream.
	 * @param filePath
	 * @param inputStream
	 */
	public static void createFile(String filePath, InputStream inputStream) {
		log.debug("Creating file {}", filePath);
		try {
            OutputStream out = new FileOutputStream(filePath);
                    
            byte[] buf = new byte[BUFFER];
            int len;

            while ((len = inputStream.read(buf)) > 0) {
            	out.write(buf, 0, len);
            }
    
            inputStream.close();
            out.close();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		log.info("Create file {} finished correctly.", filePath);
	}
}
