/*
 * NAME = com.vectorsf.springmvc_base.utils.job.CustomJobFactory.java;
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
package com.vectorsf.test_base.utils.job;


import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description: Job factory customizado para la generalización
 * de clases.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class JobExample extends JobData {

	private final static Logger log = LoggerFactory.getLogger(JobExample.class);
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		log.debug("TASKS: Start execution task task");
		System.out.println("TASKS: Ping de tarea de prueba.");
		log.debug("TASKS: Finish execution task.");
	}
}
