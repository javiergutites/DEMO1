/*
 * NAME = com.vectorsf.springmvc_base.dao.DAO.java;
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

import java.util.List;

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
public abstract interface DAO<T1,T2> {
	
	/**
	 * Count all 
	 * @return long con el número de elementos
	 */
	public long countAll();
	
	/**
	 * Count all con criterios
	 * @param where parte where de la query (sin la palabra where)
	 * @return long con el número de elementos
	 */
	public long countAll(String where);
	
	/**
	 * Obtiene todos los elementos de la tabla
	 * @return Listado de elementos
	 */
	public List<T1> findAll();
	
	/**
	 * Obtiene todos los elementos de la tabla según el criterio especificado 
	 * @param where parte where de la query (sin la palabra where)
	 * @return Listado de elementos
	 */
	public List<T1> findAll(String where);
	
	/**
	 * Obtiene un elemento por su id
	 * @param id id del elemento
	 * @return Elemento o null si no existe ninguno
	 */
	public T1 findById(T2 id);

	/**
	 * Almacena un elemento en base de datos
	 * @param o elemento a insertar
	 */
	@Transactional
	public void persist(T1 o);
	
	/**
	 * Actualiza un elemento en base de datos
	 * @param o elemento a actualizar
	 * @return el elemento actualizado
	 */
	@Transactional
	public T1 merge(T1 o);

	/**
	 * Elimina un elemento de base de datos
	 * @param o el elemento a eliminar
	 */
	@Transactional
	public void remove(T1 o);
	
	/**
	 * Elimina un elemento de base de datos por su id
	 * @param id id del elemento a eliminar
	 */
	@Transactional
	public void removeById(T2 id);
	
	/**
	 * Hace un flush de la base de datos
	 */
	@Transactional
	public void flush();


}
