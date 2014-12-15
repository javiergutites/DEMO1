/*
 * NAME = com.vectorsf.springmvc_base.utils.performance.PerformanceFilter.java;
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

package com.vectorsf.springmvc_base.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class description: Filtro que loguea la duración
 * de una petición.
 * User: Marcelo Rodriguez
 * Date: 19/10/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class PerformanceFilter implements Filter {

	private final static Logger log = LoggerFactory.getLogger(PerformanceFilter.class);

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse arg1,
			FilterChain chain) throws IOException, ServletException {
		long t0 = System.currentTimeMillis();
		chain.doFilter(request, arg1);
		long t1 = System.currentTimeMillis();
		
		long t = t1 - t0;
		
		if (t > 100) {
		
			HttpServletRequest httpsReq = (HttpServletRequest) request;
	
			String requestURI = httpsReq.getRequestURI();
			String prefix = "";
			if (requestURI.endsWith(".json")) {
				prefix = " # JSON # ";
			}
			if (requestURI.endsWith(".js")) {
				prefix = " # JS # ";
			}
			
			String message = "[PerformanceFilter] -- " + prefix + requestURI 
				+ " :" + t + " milliseconds";
			
			log.info(message);
		}

	}

	public void init(FilterConfig arg0) throws ServletException {

	}
}