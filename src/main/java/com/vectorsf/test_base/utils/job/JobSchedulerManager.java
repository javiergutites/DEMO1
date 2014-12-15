package com.vectorsf.test_base.utils.job;

import java.text.ParseException;
import java.util.List;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vectorsf.springmvc_base.configuration.Configuration;
import com.vectorsf.springmvc_base.configuration.ConfigurationParameters;


public class JobSchedulerManager {

private static final Logger log = LoggerFactory.getLogger(JobSchedulerManager.class);
	
	private static JobSchedulerManager instance;
	private static Scheduler sched;
	private static Boolean active;
	
	/**
	 * Comprueba si el scheduler está activado según la parametrización.
	 * 
	 * @return true o false.
	 */
	public static boolean isSchedulerActive() {
		if (active == null) {
			active = Configuration.getInstance().getBooleanParameter(ConfigurationParameters.SCHEDULE_ACTIVE, true);
		}
		return active;
	}
	
	/**
	 * Método singleton que obtiene o crea la única instancia de configuración existente.
	 * 
	 * @return instancia de configuracion.
	 */
	public static JobSchedulerManager getInstance() {
		if (instance == null) {
			instance = new JobSchedulerManager();
			initScheduler();
		}
		return instance;
	}
	
	/**
	 * Inicializa el scheduler.
	 */
	public static void initScheduler() {
		if (!isSchedulerActive()) {
			log.info("JOB - Scheduler is not active.");
			return;
		}

		log.debug("JOB - Init scheduler.");
		try {
			prepareScheduler();
		} catch(SchedulerException schException) {
			log.error("During the scheduler preparation: ", schException);
		}
		log.debug("JOB - Init scheduler finished.");
	}
	
	/**
	 * Inicializa todas las tareas.
	 * @param jobsToScheduler
	 */
	public void initJobs(List<JobData> jobsToScheduler) {
		for (JobData jobData : jobsToScheduler) {
			scheduleJob(jobData);
		}	
	}
	
	
	/**
	 * Prepara el scheduler para su lanzamiento.
	 * @throws SchedulerException
	 */
	private static void prepareScheduler() throws SchedulerException {
		if (sched == null) {
			sched = new StdSchedulerFactory().getScheduler();
			sched.setJobFactory(new CustomJobFactory());
		}
		if (!sched.getMetaData().isStarted()) {
			sched.start();
			log.info("JOB - TaskManager scheduler started");
		} else {
			log.info("JOB - TaskManager scheduler already running");
		}
	}
	
	/**
	 * Parada del scheduler, no de una tarea.
	 */
	public void stopScheduler() {
		log.info("JOB - Stopping scheduler");
		try {
			if (sched !=null) {
				sched.shutdown();
				sched = null;
			}
			instance = null;
		} catch (SchedulerException se) {
			log.error("JOB - Error stopping scheduler", se);
		}
	}
	
	/**
	 * Planifica una tarea.
	 * @param jobData
	 */
	public void scheduleJob(JobData jobData) {
		try {
			stopJob(jobData);
			CronTrigger trigger = createCronTrigger(jobData);
			JobDetail jobDetail = new JobDetail(jobData.getTaskName(), jobData.getTaskGroup(), jobData.getTaskClass());
			sched.scheduleJob(jobDetail, trigger);
			log.info("JOB - Task {} with cron: {} scheduled.", jobData.getTaskName(), jobData.getCron());
		} catch (Exception e) {
			log.error("JOB - Exception while scheduling task " + jobData.getTaskName()
					+ ", group " + jobData.getTaskGroup() + " at " + jobData.getCron(), e);
		}
	}
	
	/**
	 * Re-planifica una tarea.
	 * @param jobData
	 * @throws SchedulerException
	 */
	public void reScheduleJob(JobData jobData) throws SchedulerException {
		stopJob(jobData);
		scheduleJob(jobData);
		log.info("JOB - Task {} re-scheduled correctly.", jobData.getTaskName());
	}
	
	/**
	 * Detiene una tarea que se está ejecutando.
	 * @param jobData
	 * @throws SchedulerException
	 */
	public void stopJob(JobData jobData) throws SchedulerException {
		sched.unscheduleJob(jobData.getTaskName(), jobData.getTaskGroup());
		log.info("JOB - Job {} stopping correctly.", jobData.getTaskName());
	}
	
	/**
	 * Crea un cron.
	 * @param jobData
	 * @return
	 * @throws ParseException
	 */
	private CronTrigger createCronTrigger(JobData jobData) throws ParseException {
		log.info("JOB - Cron {} created for task {}", jobData.getCron(), jobData.getTaskName());
		return new CronTrigger(jobData.getTaskName(), jobData.getTaskGroup(), jobData.getTaskName(), 
				jobData.getTaskGroup(), jobData.getCron());
	}
}
