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

		<title>Fixed Top Navbar Example for Bootstrap</title>

		<!-- Bootstrap core CSS -->
		<link href="/static/css/bootstrap.css" rel="stylesheet">
		<link href="/static/css/common.css" rel="stylesheet">

		<!-- Custom styles for this template -->

		<script src="/static/js/jquery-1.10.2.min.js"></script>
		<script src="/static/js/jquery.validate.js"></script>
		<script src="/static/js/bootstrap.min.js"></script>
		<script src="/static/js/common.js"></script>		

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="/static/js/html5shiv.js"></script>
		<script src="/static/js/respond.min.js"></script>
		<![endif]-->
		
		<decorator:head />

	</head>

	<body>
		<div class="navbar navbar-fixed-top bs-docs-nav" style="height: 50px;">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Project name</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown">관리자명 <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="#">정보변경</a></li>
								<li><a href="#">로그아웃</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>
		
		<div class="container bs-docs-container">
			<div class="row">
				<div class="col-md-2" style="padding-right: 0px !important;">
					<div class="bs-sidebar" data-spy="affix">
						<ul class="nav bs-sidenav">
							<li><a href="/rear/main">Home</a></li>
							<li><a href="/rear/product/list">상품관리</a></li>
							<li>
								<a href="#" class="dev-dropdown-link">카테고리 관리</a>
								<ul class="nav">
									<li><a href="/rear/category/list">카테고리 목록</a></li>
									<li><a href="/rear/category/tag/list">Tag 목록</a></li>
									<li><a href="/rear/category/tag/unreg/list">미등록 Tag 목록</a></li>
								</ul>
							</li>
							<li><a href="/rear/member/list">회원 관리</a></li>
							<li><a href="/rear/apps/version">어플버전 관리</a></li>
							<li><a href="/rear/notice/list">공지사항 관리</a></li>
							<li><a href="/rear/manager/list">관리자 관리</a></li>
						</ul>
					</div>
				</div>
				
				<div class="col-md-10" role="main">
					<div id="contentWrapper">
						<decorator:body />
					</div>
				</div>
			</div>
			
		</div>
		
		<footer class="bs-footer" role="contentinfo">
			<div class="container">
				<p>&copy; Company2013</p>
			</div>
		</footer>		
		
	</body>
	
</html>