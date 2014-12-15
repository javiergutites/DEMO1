<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

		<div class="right">
			<p>
				<fmt:message key="public.menu.welcome"/> <a href="/springmvc_base/admin/login.html"><fmt:message key="public.menu.login"/></a>
			</p>
		</div>
		<div class="menu-div">
			<ul class="menu-ul">
				<li>
					<a href="#"><fmt:message key="admin.menu.home"/></a>
				</li>
			</ul>
		</div>
