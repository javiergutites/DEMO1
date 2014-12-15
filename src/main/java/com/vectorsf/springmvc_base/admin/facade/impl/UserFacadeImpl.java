/*
 * NAME = com.vectorsf.springmvc_base.admin.service.impl.UserServiceImpl.java;
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

package com.vectorsf.springmvc_base.admin.facade.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vectorsf.springmvc_base.admin.facade.UserFacade;
import com.vectorsf.springmvc_base.admin.model.User;
import com.vectorsf.springmvc_base.admin.model.dao.UserDAO;

/**
 * Class description: Implementación del servicio de usuarios.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Service
public class UserFacadeImpl implements UserFacade {

	private final static Logger log = LoggerFactory.getLogger(UserFacadeImpl.class);

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getUsers() {
		log.debug("ADMIN: Listing users.");
		return userDAO.findAll();
	}

	public User getUserById(int userId) {
		log.debug("ADMIN: Searching user by id " + userId);
		return userDAO.findById(userId);
	}
	
	public User getUserByNickName(String nickName) {
		log.debug("ADMIN: Searching user by nickname " + nickName);
		return userDAO.searchByNickName(nickName);
	}
}