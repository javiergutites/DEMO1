<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<div class="box" id="login-box">

	<h1><fmt:message key="admin.login.header"/></h1>
	
	<c:if test="${not empty param.error}">
		<dl class="system-message">
			<dd class="error">
				<ul>
					<c:if test="${param.error eq 1}">
						<li><spring:message code="admin.error.login"/></li>
					</c:if>
				</ul>
			</dd>
		</dl>
	</c:if>
	<c:if test="${not empty param.info}">
		<dl class="system-message">
			<dd class="info">
				<ul>
					<c:if test="${param.info eq 1}">
						<li><spring:message code="admin.info.logout"/></li>
					</c:if>
					<c:if test="${param.info eq 2}">
						<li><spring:message code="admin.info.sesion.expirada"/></li>
					</c:if>
				</ul>
			</dd>
		</dl>
	</c:if>	
	
	<div class="box">
		<form action="<spring:url value="/j_spring_security_check" htmlEscape="true"/>" method="post" name="login" id="login-form">
			<p id="form-login-username">
				<label for="j_username"><fmt:message key="admin.login.username"/></label>
				<input type="text" size="10" class="inputbox" id="j_username" name="j_username">
			</p>
			<p id="form-login-password">
				<label for="j_password"><fmt:message key="admin.login.password"/></label>
				<input type="password" size="10" class="inputbox" id="j_password" name="j_password">
			</p>
			<p class="container-button">
				<input type="submit" value="<fmt:message key="admin.login.init"/>" class="button"/>
			</p>
				
		</form>
	</div>
	
	<div id="lock"></div>
</div> 