<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

	<sec:authorize access="isAuthenticated()">
		<div class="right">
			<p>
				<fmt:message key="admin.menu.welcome"/> <sec:authentication property="name"/>
			</p>
		</div>
		<div class="menu-div">
			<ul class="menu-ul">
				<li>
					<a href="#"><fmt:message key="admin.menu.home"/></a>
				</li>
				<li>
					<a href="#"><fmt:message key="admin.menu.configuration"/></a>
					<ul>
      					<li><a href="#"><fmt:message key="admin.menu.configuration.parameters"/></a></li>
      					<li><a href="#"><fmt:message key="admin.menu.configuration.tasks"/></a></li>
      				</ul>
				</li>
				<li>
					<a href="#"><fmt:message key="admin.menu.catalogue.admin"/></a>
					<ul>
      					<li><a href="<spring:url value="/admin/user/list.html" htmlEscape="true"/>"><fmt:message key="admin.menu.catalogue.admin.users"/></a></li>
      					<li><a href="<spring:url value="/admin/profile/list.html" htmlEscape="true"/>"><fmt:message key="admin.menu.catalogue.admin.profiles"/></a></li>
      					<li><a href="<spring:url value="/admin/role/list.html" htmlEscape="true"/>"><fmt:message key="admin.menu.catalogue.admin.roles"/></a></li>
      					<li><a href="<spring:url value="/admin/company/list.html" htmlEscape="true"/>"><fmt:message key="admin.menu.catalogue.admin.companies"/></a></li>
      				</ul>
				</li>
				<li>
					<a href="#"><fmt:message key="admin.menu.catalogue.application"/></a>
				</li>
				<li>
					<a href="#"><fmt:message key="admin.menu.development.test"/></a>
					<ul>
						<li><a href="<spring:url value="/admin/development/mail.html" htmlEscape="true"/>"><fmt:message key="admin.menu.development.test.mail"/></a></li>
						<li><a href="<spring:url value="/admin/development/excel.html" htmlEscape="true"/>"><fmt:message key="admin.menu.development.test.excel"/></a></li>
						<li><a href="<spring:url value="/admin/development/pdf.html" htmlEscape="true"/>"><fmt:message key="admin.menu.development.test.pdf"/></a></li>
						<li><a href="<spring:url value="/admin/development/scheduler.html" htmlEscape="true"/>"><fmt:message key="admin.menu.development.test.tasks"/></a></li>
						<li><a href="<spring:url value="/admin/development/ftp.html" htmlEscape="true"/>"><fmt:message key="admin.menu.development.test.ftp"/></a></li>
					</ul>
				</li>
				<li>
					<a href="#"><fmt:message key="admin.menu.preferences"/></a>
				</li>
				<li class="last">
					<a href="<spring:url value="/j_spring_security_logout" htmlEscape="true"/>"><fmt:message key="admin.menu.disconnect"/></a>
				</li>
			</ul>
		</div>
	</sec:authorize>
