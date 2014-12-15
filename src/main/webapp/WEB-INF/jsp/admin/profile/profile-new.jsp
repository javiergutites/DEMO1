<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<script src="<c:url value="/resources/js/admin/profile-new.js"/>" type="text/javascript"></script>
 
	<span id="mensajes" >
		<c:out value="${message}"/>
	</span>
 
	<div class="title">New</div>
	<div class="content">
		<div class="content-form">
		<spring:url value="/admin/profile/add.html" htmlEscape="true" var="action"/>
			<form:form action="${action}" name="search" id="search-form" method="post" modelAttribute="profileForm">
				<table class="add-section center">
					<tr>
						<td align="right">
							<fmt:message key="admin.profile.searcher.name"/>
							<form:input path="name" size="10" cssClass="inputbox" id="id"/>
							<form:errors path="name" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td align="right">
							<fmt:message key="admin.profile.searcher.role"/>
							<form:input path="description" size="10" cssClass="inputbox" id="id"/>
							<form:errors path="description" cssClass="error"/>
						</td>
					</tr>
					<tr>
						<td align="center" class="submit">
							<input type="submit" value="<fmt:message key="admin.section.new.add"/>" class="button"/>
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
