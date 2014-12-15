/*
 * NAME = com.vectorsf.springmvc_base.utils.file.ZipUtils.java;
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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description: Clase de utilidad sobre archivos zip.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class ZipUtils {

	private static Logger log = LoggerFactory.getLogger(ZipUtils.class);
	private static int BUFFER = FileUtils.BUFFER;
	
	/**
	 * Unzip.
	 * @param zipPath
	 */
	public static void unzip(String zipPath, String unzipPath) {		
		log.info("Unzipping archive: {}", zipPath);
		try {
	        ZipFile zipFile = new ZipFile(zipPath);
			Enumeration<? extends ZipEntry> zipFiles = zipFile.entries();
			 while(zipFiles.hasMoreElements()) {
				 ZipEntry entry = (ZipEntry) zipFiles.nextElement();
				 copyDir(zipFile, entry, new File(unzipPath + entry.getName()));
			 }
		} catch(Exception e) {
			log.error("Problems unzipping archive {}", zipPath);
			return;
		}
		log.info("Archive {} unzipped correctly.", zipPath);
	}
	
	/**
	 * Copy a directory into destinationPath
	 * @param zipFile
	 * @param entry
	 * @param destinationPath
	 * @throws Exception
	 */
	private static void copyDir(ZipFile zipFile, ZipEntry entry, File destinationPath) throws Exception {
		if (entry.isDirectory()) {
			// if not exists destination directory, make a dir.
            if (!destinationPath.exists()){                              
            	destinationPath.mkdir();
            } 
		} else {
			copyZipFile(zipFile, entry, destinationPath);
		}
	}
	
	/**
	 * Copy a zip file in a destination.
	 * @param zipFile
	 * @param entry
	 * @param destinationFileName
	 * @throws Exception
	 */
	private static void copyZipFile(ZipFile zipFile, ZipEntry entry, File destinationFileName) throws Exception {
		FileOutputStream dest = null;
        BufferedInputStream is = null;
        is = new BufferedInputStream (zipFile.getInputStream(entry));

        int count = 0;
        byte data[] = new byte[BUFFER];
       
        dest = new FileOutputStream(destinationFileName);
        while ((count = is.read(data, 0, BUFFER)) != -1) {
           dest.write(data, 0, count);
        }
        dest.flush();
        dest.close();
        is.close();
	}
}
