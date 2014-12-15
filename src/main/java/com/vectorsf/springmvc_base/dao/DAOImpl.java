/*
 * NAME = com.vectorsf.springmvc_base.dao.DAOImpl.java;
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
package com.vectorsf.springmvc_base.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Class description: -
 * @param <T1> clase del modelo
 * @param <T2> id
 * User: Marcelo Rodriguez
 * Date: 19/10/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */
@SuppressWarnings("serial")
@Repository
public abstract class DAOImpl<T1, T2> implements DAO<T1, T2>, Serializable {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected Class<T1> clasz;	
	
	/**
	 * Constructor genérico para obtener la clase del modelo
	 */
	@SuppressWarnings("unchecked")
	public DAOImpl() {
		this.clasz = (Class<T1>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * @see com.vectorsf.goal.model.dao.springmvc_base.DAO#countAll()
	 */
	@Override
	public long countAll() {
		StringBuffer query = new StringBuffer();
		query.append("select count(*) from " + this.clasz.getName());
		try {
			return (Long) this.entityManager.createQuery(query.toString()).getSingleResult();
		} catch (NonUniqueResultException e) {
			return 0;
		} catch (NoResultException e) {
			return 0;
		}
	}

	/**
	 * @see com.vectorsf.goal.model.dao.springmvc_base.DAO#countAll(java.lang.String)
	 */
	@Override
	public long countAll(String where) {
		StringBuffer query = new StringBuffer();
		query.append("select count(*) from " + this.clasz.getName());
		query.append(" where " + where);
		try {
			return (Long) this.entityManager.createQuery(query.toString()).getSingleResult();
		} catch (NonUniqueResultException e) {
			return 0;
		} catch (NoResultException e) {
			return 0;
		}
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T1> findAll() {
		StringBuffer query = new StringBuffer();
		query.append("from " + this.clasz.getName());
		return this.entityManager.createQuery(query.toString()).getResultList();
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#findAll(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T1> findAll(String where) {
		StringBuffer query = new StringBuffer();
		query.append("from " + this.clasz.getName());
		query.append(" where " + where);
		return this.entityManager.createQuery(query.toString()).getResultList();
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#findById(java.lang.Object)
	 */
	@Override
	public T1 findById(T2 id) {
		return this.entityManager.find(this.clasz, id);
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#persist(java.lang.Object)
	 */
	@Override
	@Transactional
	public void persist(T1 o) {
		this.entityManager.persist(o);
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#merge(java.lang.Object)
	 */
	@Override
	@Transactional
	public T1 merge(T1 o) {
		return this.entityManager.merge(o);
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#remove(java.lang.Object)
	 */
	@Override
	@Transactional
	public void remove(T1 o) {
		this.entityManager.remove(o);
		
	}
	
	/**
	 * @see com.vectorsf.goal.model.dao.springmvc_base.DAO#removeById(java.lang.Object)
	 */
	@Override
	@Transactional
	public void removeById(T2 id) {
		T1 reference = this.entityManager.getReference(this.clasz, id);
		this.entityManager.remove(reference);
	}

	/**
	 * @see com.vectorsf.goal.model.dao.DAO#flush()
	 */
	@Override
	@Transactional
	public void flush() {
		this.entityManager.flush();	
	}
}
