/*
 * NAME = com.vectorsf.springmvc_base.utils.job.JobInitializer.java;
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

import java.util.List;

/**
 * Class description: Clase que inicializa las tareas a lanzar.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class JobInitializer {

	/**
	 * Almacena los scheduler que se tienen que lanzar.
	 * @param jobsToScheduler the jobs to set
	 */
	public void setJobsToScheduler(List<JobData> jobsToScheduler) {
		if (JobSchedulerManager.isSchedulerActive()) {
			JobSchedulerManager.getInstance().initJobs(jobsToScheduler);
		}
	}

	/**
	 * Para toda la ejecución del scheduler.
	 */
	public void shutdown() {
		if (JobSchedulerManager.isSchedulerActive()) {
			JobSchedulerManager.getInstance().stopScheduler();
		}
	}
}
