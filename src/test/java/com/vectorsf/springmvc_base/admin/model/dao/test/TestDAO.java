/*
 * COPYRIGHT (c) 2013 Vector Software Factory S.L. Reservados todos los derechos.
 * Este programa es material confidencial propiedad
 * de Vector Software Factory S.L. Se prohíbe la divulgación o revelación
 * de su contenido sin el permiso previo y por escrito del propietario.
 * COPYRIGHT (c) 2013 Vector Software Factory S.L. All rights reserved.
 * This document (Program, manual, etc.) consists of confidential information,
 * containing trade secrets that are property of Vector Software Factory S.L.
 * Its content may not be used or disclosed without prior written permission
 * of the owner.
 */
package com.vectorsf.springmvc_base.admin.model.dao.test;

import java.util.Date;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.vectorsf.springmvc_base.dao.DAO;

/**
 * Class description: -
 * User: Alvaro Alvarez
 * Date: 25/03/2013
 * 
 * @author Alvaro Alvarez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext-test.xml")
@Transactional
public abstract class TestDAO<T1, T2> {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://arquitectura.vectorsf.com:3306/springmvc_base";
	private static final String USER = "springmvc_base";
	private static final String PASS = "springmvc_base";
	protected Date DATE;
	
	@BeforeClass
	public static void setup() throws NamingException {
		SimpleNamingContextBuilder builder = SimpleNamingContextBuilder.emptyActivatedContextBuilder();
		builder.bind("java:comp/env/ds/springmvc_base", createTestDataSource());
	}
	
	private static DataSource createTestDataSource(){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(DRIVER);
		ds.setUrl(URL);
		ds.setUsername(USER);
		ds.setPassword(PASS);
		return ds;
	}
	
	@Before
	public void creaDate() {
		DATE = new Date();
	}
	
	@Test
	public void testDAO() {
		System.out.println("----------------------------");
		System.out.println("Count inicial");
		long count = getDAO().countAll();
		Assert.assertTrue("Count", count >= 0);
		
		System.out.println("Persist");
		T1 sp = createObject(getId());
		getDAO().persist(sp);
		Assert.assertTrue("Count after persist", count + 1 == getDAO().countAll());
		
		System.out.println("Find by Id & Merge");
		T1 find = getDAO().findById(getId(sp));
		changeValueForMerge(find);
		getDAO().merge(find) ;
		T1 findAfterMerge = getDAO().findById(getId(sp));
		Assert.assertTrue("Merge", verifyValueAfterMerge(findAfterMerge));
		
		System.out.println("Remove");
		getDAO().removeById(getId(sp));
		Assert.assertTrue("Count after remove", count == getDAO().countAll());
		System.out.println("----------------------------");
	}
	
	public T2 getId(T1 object) {
		return getId();
	}
	
	public abstract DAO<T1, T2> getDAO();
	public abstract T2 getId();
	public abstract T1 createObject(T2 id);
	public abstract void changeValueForMerge(T1 object);
	public abstract boolean verifyValueAfterMerge(T1 object);
}
