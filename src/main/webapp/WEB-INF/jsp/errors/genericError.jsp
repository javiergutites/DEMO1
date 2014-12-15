<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<div class="contenedor centro" style="margin-top:100px">
		<div class="carrusel">
			<p class="mayuscula"> ERROR GENÉRICO</p>	
			<p>Ha ocurrido un error inesperado.</p>
		</div>
	</div>

<%
    java.io.StringWriter sw = new java.io.StringWriter();
    java.io.PrintWriter pr = new java.io.PrintWriter(sw);
    exception.printStackTrace(pr);
    request.setAttribute("stacktrace", sw.toString());
%>

<!--
${stacktrace}
-->