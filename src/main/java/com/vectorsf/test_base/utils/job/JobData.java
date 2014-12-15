/*
 * NAME = com.vectorsf.springmvc_base.utils.job.JobData.java;
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
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

/**
 * Class description: Objeto genérico que representa una tarea.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

@Component
public abstract class JobData implements Job {
	
	private static final String DEFAULT_JOB_GROUP = "VECTOR_JOB_GROUP";
	private static final String DEFAULT_JOB_NAME = "VECTOR_JOB";
	private static final String DEFAULT_TASK_GROUP = "VECTOR";
	
	private String jobGroup;
	private String jobName;
	private String taskGroup;
	private String taskName;
	private String cron;
	private Class<? extends Job> taskClass;
	
	@SuppressWarnings({"unchecked"})
	public JobData() {
		this.jobGroup = DEFAULT_JOB_GROUP;
		this.jobName = DEFAULT_JOB_NAME;
		this.taskGroup = DEFAULT_TASK_GROUP;
		this.taskName = super.getClass().getName();
		this.taskClass = (Class<? extends Job>)super.getClass();
	}

	@Override
	public abstract void execute(JobExecutionContext jobContext) throws JobExecutionException;

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}
	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the jobGroup
	 */
	public String getJobGroup() {
		return jobGroup;
	}
	/**
	 * @param jobGroup the jobGroup to set
	 */
	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}
	/**
	 * @param taskName the taskName to set
	 */
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	/**
	 * @return the taskGroup
	 */
	public String getTaskGroup() {
		return taskGroup;
	}
	/**
	 * @param taskGroup the taskGroup to set
	 */
	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}

	/**
	 * @return the cron
	 */
	public String getCron() {
		return cron;
	}
	
	/**
	 * @param cron the cron to set
	 */
	public void setCron(String cron) {
		this.cron = cron;
	}

	/**
	 * @return the taskClass
	 */
	public Class<? extends Job> getTaskClass() {
		return taskClass;
	}
	/**
	 * @param taskClass the taskClass to set
	 */
	public void setTaskClass(Class<? extends Job> taskClass) {
		this.taskClass = taskClass;
	}
}
