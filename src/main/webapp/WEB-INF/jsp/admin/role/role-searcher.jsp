<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<h2>Buscador</h2>
<form action="<spring:url value="/j_spring_security_check" htmlEscape="true"/>" method="post" name="search" id="search-form">
	<table class="searcher">
		<tr>
			<td align="right">Id</td>
			<td><input type="text" size="15" class="inputbox" id="id" name="id"></td>
		</tr>
		<tr>
			<td align="right">Nombre</td>
			<td><input type="text" size="15" class="inputbox" id="name" name="name"></td>
		</tr>
	</table>
	
	<div class="button_holder">
		<div class="button1">
			<div class="next right">
				<a onclick="search.submit();">Buscar</a>
			</div>
		</div>
	</div>
</form>
