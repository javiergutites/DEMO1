/*
 * NAME = com.vectorsf.springmvc_base.utils.file.ftp.FtpManager.java;
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

package com.vectorsf.test_base.utils.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vectorsf.springmvc_base.configuration.Configuration;
import com.vectorsf.springmvc_base.configuration.ConfigurationParameters;

/**
 * Class description: Manager para la gestión de ftp.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class FtpManager {
	
	private Logger log = LoggerFactory.getLogger(FtpManager.class);

	private FtpClient ftpClient;
	private String hostName;
	private int port;
	private String userName;
	private String password;
	private int dataTimeOut;
	private int socketTimeOut;
	private String pathBase;
	
	public FtpManager() throws SocketException, IOException {
		configure();
	}
	
	private void configure() throws SocketException, IOException {
		this.hostName = Configuration.getInstance().getParameter(ConfigurationParameters.FTP_HOST_NAME, "localhost");
		this.port = Configuration.getInstance().getIntegerParameter(ConfigurationParameters.FTP_PORT, 21);
		this.userName = Configuration.getInstance().getParameter(ConfigurationParameters.FTP_USER, "");
		this.password = Configuration.getInstance().getParameter(ConfigurationParameters.FTP_PASSWORD, "");
		this.dataTimeOut = Configuration.getInstance().getIntegerParameter(ConfigurationParameters.FTP_DATA_TIMEOUT, 30000);
		this.socketTimeOut = Configuration.getInstance().getIntegerParameter(ConfigurationParameters.FTP_SOCKET_TIMEOUT, 30000);
		this.pathBase = Configuration.getInstance().getParameter(ConfigurationParameters.FTP_BASE_PATH, "/");
		
		ftpClient = new FtpClient();
		ftpClient.connect(hostName, port, userName, password, dataTimeOut, socketTimeOut);
		log.info("FTP Init: {}, {}, {}, {}, {}, {}, {}",
                new Object[] {hostName, port, userName, password, dataTimeOut, socketTimeOut, pathBase});
	} 
	
	/**
	 * Upload a file to FTP.
	 * @param fileName
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public boolean uploadFile(String path, String fileName, InputStream inputStream) throws Exception {
		log.info("FTP Uploading file: {} into {}", fileName, this.pathBase + path);
		if (ftpClient.changeWorkingDirectory(this.pathBase + path) == false) {
			log.info("FTP ERROR: Problems changing directory to: {}", this.pathBase + path);
			throw new Exception("Impossible to change directory.");
		}
		boolean completed = ftpClient.storeFile(fileName, inputStream);
		if (!completed) {
			throw new Exception("Impossible to upload file.");
		}
		ftpClient.breakItOff();
		log.info("FTP File upload: {} in: {}", fileName, ftpClient.printWorkingDirectory());
		return completed;
	}
	
	/**
	 * Download a file from FTP.
	 * @param filePath
	 * @param outputStream
	 * @return
	 * @throws IOException
	 */
	public boolean downloadFile(String filePath, OutputStream outputStream) throws Exception {
		log.info("FTP Downloading file: {} in: {}", filePath, this.pathBase);
		boolean completed = ftpClient.retrieveFile(this.pathBase + filePath, outputStream);
		if (!completed) {
			throw new Exception("Impossible to download file.");
		}
		ftpClient.breakItOff();
		log.info("FTP Download file: {} in: {}", filePath, this.pathBase);
		return completed;
	}
	
	/**
	 * Delete a file of FTP with the path name indicated.
	 * @param pathName
	 * @return
	 * @throws IOException
	 */
	public boolean deleteFile(String pathName) throws Exception {
		log.info("FTP Deleting file: {} in: {}", pathName, this.pathBase);
		boolean completed = ftpClient.deleteFile(this.pathBase + pathName);
		if (!completed) {
			throw new Exception("Impossible to delete file.");
		}
		ftpClient.breakItOff();
		log.info("FTP Delete file: {} in: {}", pathName, this.pathBase);
		return completed;
	}

	/*
	 * GETTERS AND SETTERS
	 */
	public FtpClient getFtpClient() {
		return ftpClient;
	}
	public void setFtpClient(FtpClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getDataTimeOut() {
		return dataTimeOut;
	}
	public void setDataTimeOut(int dataTimeOut) {
		this.dataTimeOut = dataTimeOut;
	}

	public int getSocketTimeOut() {
		return socketTimeOut;
	}
	public void setSocketTimeOut(int socketTimeOut) {
		this.socketTimeOut = socketTimeOut;
	}	
}
