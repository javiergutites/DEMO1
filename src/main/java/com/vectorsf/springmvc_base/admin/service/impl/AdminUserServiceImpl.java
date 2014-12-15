/*
 * NAME = com.vectorsf.springmvc_base.admin.service.impl.AdminUserServiceImpl.java;
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

package com.vectorsf.springmvc_base.admin.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vectorsf.springmvc_base.admin.facade.UserFacade;
import com.vectorsf.springmvc_base.admin.model.User;
import com.vectorsf.springmvc_base.admin.service.AdminUserService;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 02/12/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Service
public class AdminUserServiceImpl implements AdminUserService {

	private final static Logger log = LoggerFactory.getLogger(AdminUserServiceImpl.class);
	
	@Autowired
	private UserFacade userFacade;
	
	public List<User> getUsers() {
		return userFacade.getUsers();
	}

	public User getUserById(int userId) {
		return userFacade.getUserById(userId);
	}
	
	public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException, DataAccessException {
		log.info("Init user login for username \"" + nickName + "\"");
		User user = userFacade.getUserByNickName(nickName);
		log.info("User \"" + nickName + "\" logged correctly.");
		return user;
	}
}
