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
  	<meta charset="utf-8" />
  	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<meta name="viewport" content="width=device-width; initial-scale=1.0" />
	<c:set var="page_title"><tiles:getAsString name="title" ignore="true"/></c:set>
	<c:set var="page_description"><tiles:getAsString name="description" ignore="true"/></c:set>
	<title><fmt:message key="public.title"/></title>
  	<meta name="description" content="<fmt:message key="${page_description}"/>"/>

	<!-- ICONS -->
  	<link href="<c:url value='/resources/images/common/favicon.png'/>" rel="shortcut icon" type="image/x-icon"/>
  	<link href="<c:url value='/resources/images/common/apple-touch-icon.png'/>" rel="apple-touch-icon" type="image/x-icon"/>
  
  	<!-- CSS -->
  	<link href="resources/css/global-public.css" rel="stylesheet" type="text/css"/>
  	
  	<!-- JAVASCRIPT -->
  	<script src="<c:url value="/resources/js/common/multimenu.js"/>" type="text/javascript"></script>
  	<script src="<c:url value='/resources/js/common/jquery/jquery-1.7.1.min.js'/>" type="text/javascript"></script>
  	<script src="<c:url value="/resources/js/common/jquery/jquery-ui-1.8.21.custom.min.js"/>" type="text/javascript"></script>
	  	
  	<!--[if lt IE 9]>
		<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
  	<![endif]-->

</head>

<body>
	<div class="wrapper">
		<div class="header">
			<tiles:insertAttribute name="header"/>
			<tiles:insertAttribute name="menuPublico"/>
		</div>
		<div class="body">
			<tiles:insertAttribute name="body"/>
		</div>
		<div style="border:1px solid #159CDF"></div>
		<div class="footer">
			<tiles:insertAttribute name="footer"/>
		</div>
	</div>
</body>

</html>