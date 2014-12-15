<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html lang="es-Es">
	<head>
		<!-- SEO -->
	  	<meta charset="utf-8"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
		<c:set var="page_title"><tiles:getAsString name="title" ignore="true"/></c:set>
		<c:set var="page_description"><tiles:getAsString name="description" ignore="true"/></c:set>
		<title><fmt:message key="${page_title}"/></title>
  		<meta name="description" content="<fmt:message key="${page_description}"/>"/>
		
		<!-- ICONS -->
	  	<link href="<c:url value='/resources/images/common/favicon.png'/>" rel="shortcut icon" type="image/x-icon"/>
	  	<link href="<c:url value='/resources/images/common/apple-touch-icon.png'/>" rel="apple-touch-icon" type="image/x-icon"/>
	  	
	  	<!-- CSS -->
	    <link href="<c:url value="/resources/css/global-admin.css"/>" rel="stylesheet" type="text/css"/>
	    
	    <!-- JAVASCRIPT -->
	    <script src="<c:url value="/resources/js/common/multimenu.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/common/jquery/jquery-1.7.1.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/common/jquery/jquery.dataTables-1.8.2.min.js"/>" type="text/javascript"></script>
	    <script src="<c:url value="/resources/js/common/jquery/jquery-ui-1.8.21.custom.min.js"/>" type="text/javascript"></script>
	</head>
	
	<body>
		<div class="wrapper">
			<div class="header">
				<tiles:insertAttribute name="header"/>
				<tiles:insertAttribute name="menu"/>
			</div>
			<div class="body">
				<tiles:insertAttribute name="body"/>
			</div>
			<div style="border:1px solid #159CDF"></div>
			<div style="float:right; margin-top:3px;">© 2011 Vector Software Factory</div>
			<!-- 
			<div class="footer">
				<tiles:insertAttribute name="footer"/>
			</div>
			 -->
		</div>
	</body>
</html>
