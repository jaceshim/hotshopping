<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>   

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

		<title>Hot Shopping :: <decorator:title /></title>

		<!-- Bootstrap core CSS -->
		<link href="${ctx}/static/css/bootstrap.css" rel="stylesheet">
		<link href="${ctx}/static/css/common.css" rel="stylesheet">

		<script src="${ctx}/static/js/jquery-1.10.2.min.js"></script>
		<script src="${ctx}/static/js/jquery.validate.js"></script>
		<script src="${ctx}/static/js/bootstrap.min.js"></script>
		<script src="${ctx}/static/js/common.js"></script>		

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="${ctx}/static/js/html5shiv.js"></script>
		<script src="${ctx}/static/js/respond.min.js"></script>
		<![endif]-->

		<decorator:head />
	</head>

	<body>
		<decorator:body />
	</body>
</html>
