/*
 * NAME = com.vectorsf.springmvc_base.utils.file.date.DateUtils.java;
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

package com.vectorsf.springmvc_base.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class description: Clase de utilidad sobre fechas.
 * User: Marcelo Rodriguez
 * Date: 22/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class DateUtils {

	public static final String COMMON_PATTERN = "dd/MM/yyyy";
	public static final String COMMON_COMPLETE_PATTERN = "dd/MM/yyyy HH:mm:ss";
	public static final String FILE_NAME_PATTERN = "dd_MM_yyyy_HH_mm_ss-";

	
	public static String formatDate (Date dateToFormat) {
		return formatDate(dateToFormat, COMMON_PATTERN);
	}
	
	public static String formatDate (Date dateToFormat, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dateToFormat);
	}
	
	public static String getFormattedDateForFile() {
		return formatDate(new Date(), FILE_NAME_PATTERN);
	}
	
	/**
	 * Crea un Date a partir del día, mes y anio indicados.
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static Date createDate(Integer day, Integer month, Integer year) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, day);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.YEAR, year);
		return c.getTime();
	}
	
	/**
     * This method compare
     * @param date
     * @param otherDate
     * @return
     */
    public static int compareDatesWithoutTime(Date date, Date otherDate) {
		Calendar thisDay = Calendar.getInstance();
		Calendar otherDay = Calendar.getInstance();
		thisDay.setTime(date);
		otherDay.setTime(otherDate);
		
		if (thisDay.get(Calendar.YEAR) == otherDay.get(Calendar.YEAR)) {
			if (thisDay.get(Calendar.MONTH) == otherDay.get(Calendar.MONTH)) {
				if (thisDay.get(Calendar.DAY_OF_MONTH) == otherDay.get(Calendar.DAY_OF_MONTH)) {
					return 0;
				} else if (thisDay.get(Calendar.DAY_OF_MONTH) < otherDay.get(Calendar.DAY_OF_MONTH)) {
					return -1;
				} else {
					return 1;
				}
			} else if (thisDay.get(Calendar.MONTH) < otherDay.get(Calendar.MONTH)) {
				return -1;
			} else {
				return 1;
			}
		} else if (thisDay.get(Calendar.YEAR) < otherDay.get(Calendar.YEAR)) {
			return -1;
		} else {
			return 1;
		}
    }
}
