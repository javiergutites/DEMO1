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

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

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

public class CustomJobFactory implements JobFactory {

	private final static Logger log = LoggerFactory.getLogger(CustomJobFactory.class);

	@SuppressWarnings("unchecked")
	public Job newJob(TriggerFiredBundle bundle) throws SchedulerException {
		JobDetail jobDetail = bundle.getJobDetail();
		Class<? extends Job> jobClass = jobDetail.getJobClass();
		try {
			if(log.isDebugEnabled()) {
				log.debug(
					"Producing instance of Job '" + jobDetail.getFullName() + "', class=" + jobClass.getName());
			}
			WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
			
			return (Job) ctx.getBean(jobClass);
		} catch (Exception   e) {
			SchedulerException se = new SchedulerException("Problem instantiating class '"
					+ jobDetail.getJobClass().getName() + "'", e);
			throw se;
		}
	}
}
