/*
 * NAME = com.vectorsf.springmvc_base.utils.file.ftp.FtpClient.java;
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
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
 * Class description: Cliente sobre FTPClient de commons-net.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class FtpClient extends FTPClient {
	
	public void connect(String hostName, int port, String username, String password,
			int dataTimeOut, int socketTimeOut) throws SocketException, IOException {
		this.connect(hostName, port);
		this.login(username, password);
		this.setDataTimeout(dataTimeOut);
		this.setSoTimeout(socketTimeOut);
	}
	
	public void breakItOff() throws IOException {
		if (this.isConnected()) {
			this.logout();
			this.disconnect();
		}
	}
	
	public FTPFile findFile (String fileName, String pathName) throws IOException {
		FTPFile[] files = this.listFiles(pathName);
		for (FTPFile file : files) {
			if (file.getName().contains(fileName))
				return file;
		}
		return null;
	}
}
