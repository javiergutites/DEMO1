<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
	<div class="title"><fmt:message key="admin.section.searcher"/></div>
	<div class="content">
		<div class="content-form">
			<form action="<spring:url value="/j_spring_security_check" htmlEscape="true"/>" method="post" name="search" id="search-form">
				<table class="searcher-section center">
					<tr>
						<td align="right">
							<fmt:message key="admin.profile.searcher.name"/>
							<input type="text" size="10" class="inputbox" id="id" name="id">
						</td>
						<td align="right">
							<fmt:message key="admin.profile.searcher.role"/>
							<input type="text" size="10" class="inputbox" id="name" name="name">
						</td>
						<td>
							<input type="submit" value="<fmt:message key="admin.section.searcher.search"/>" class="button"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>