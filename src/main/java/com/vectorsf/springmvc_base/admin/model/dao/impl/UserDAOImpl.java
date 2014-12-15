/*
 * NAME = com.vectorsf.springmvc_base.admin.model.dao.impl.UserDAOImpl.java;
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

package com.vectorsf.springmvc_base.admin.model.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.vectorsf.springmvc_base.admin.model.User;
import com.vectorsf.springmvc_base.admin.model.dao.UserDAO;
import com.vectorsf.springmvc_base.dao.DAOImpl;

/**
 * Class description: -
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@SuppressWarnings("serial")
@Repository
public class UserDAOImpl extends DAOImpl<User, Integer> implements UserDAO {

	@SuppressWarnings("unchecked")
	public User searchByNickName(String username) {
		StringBuffer query = new StringBuffer();
		query.append("from " + User.class.getName() + " u " + "LEFT JOIN FETCH u.profile profile ");
		query.append("LEFT JOIN FETCH profile.roles where u.username = :username");
		Query q = super.entityManager.createQuery(query.toString()).setParameter("username", username);
		
		List<User> results = q.getResultList();
        if (results.size() > 0) {
            return results.get(0);
        }
        return null;
	}
}
