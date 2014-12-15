/*
 * NAME = com.vectorsf.springmvc_base.utils.exception.WrappedException.java;
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

package com.vectorsf.springmvc_base.utils.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Class description: A veces, haces catch de una excepción ante la cual 
 * no puedes hacer nada, excepto parar la página y mostrar error al usuario. 
 * Esta clase sirve para envolver esas excepciones, de forma que no tengas
 * que hacer que todas las clases del proyecto dependan de una librería 
 * simplemente porque tienen que hacer un throws de una excepción definida 
 * en la librería.
 * <p/>
 * Dado que normalmente nadie más va a hacer un catch de esta excepción, 
 * asegurate de logarla en el log antes de envolverla y lanzarla hacia arriba.
 * <p/>
 * User: David Agudo
 * Date: 11/11/2011
 * 
 * @author Marcelo Rodriguez
 * @version $LastChangedRevision$ 
 *			$Author$
 * 			$Date$
 */

public class WrappedException extends RuntimeException {
	private static final long serialVersionUID = -7818097266231858597L;

	private WrappedException(Throwable cause) {
		super(cause);
	}

	/**
	 * Función que crea una WrappedException para encapsular la excepción indicada, pero solo
	 * si dicha excepción no es Runtime, ya que las Runtime no necesitan ser encapsuladas.
	 *
	 * @param cause La excepción a envolver para poder mandarla a top
	 * @return La excepción original o la envuelta, según sea necesario
	 */
	public static RuntimeException wrap(Throwable cause) {
		if (cause instanceof RuntimeException) {
			return (RuntimeException) cause;
		} else return new WrappedException(cause);
	}

	/**
	 * Obtiene la excepción original que ha sido envuelta en esta. Notese que para el uso
	 * normal no es necesario desenvolver la excepción, ya que los metodos de esta excepción
	 * invocan transparentemente los de la excepción envuelta.
	 *
	 * @return La excepción original
	 */
	public Throwable unwrap() {
		return super.getCause();
	}

	@Override
	public String getMessage() {
		return unwrap().getMessage();
	}

	@Override
	public String getLocalizedMessage() {
		return unwrap().getLocalizedMessage();
	}

	@Override
	public Throwable getCause() {
		return unwrap().getCause();
	}

	@Override
	public Throwable initCause(Throwable cause) {
		return unwrap().initCause(cause);
	}

	@Override
	public String toString() {
		return unwrap().toString();
	}

	@Override
	public void printStackTrace() {
		unwrap().printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		unwrap().printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		unwrap().printStackTrace(s);
	}

	@Override
	public Throwable fillInStackTrace() {
		return unwrap().fillInStackTrace();
	}

	@Override
	public StackTraceElement[] getStackTrace() {
		return unwrap().getStackTrace();
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		unwrap().setStackTrace(stackTrace);
	}
}
