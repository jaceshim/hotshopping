<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 :: <sitemesh:write property='title' /></title>
<style type="text/css">
	#wrapper {width: 100%; height: 100%; border: 1px solid #BDC0C1;}
	#headerWrapper {padding: 10px; border-bottom: 1px solid #BDC0C1;; height: 40px;}
	#contentWrapper {padding: 10px;}
	#footerWrapper {padding: 10px; border-top: 1px solid #BDC0C1; height: 40px;}
	
</style>

<sitemesh:write property='head' />

</head>
<body>
	<div id="wrapper">
		<div id="headerWrapper">Header</div>
		<div id="contentWrapper">
			<sitemesh:write property='body' />
		</div>
		<div id="footerWrapper">Footer</div>
	</div>
</body>
</html>