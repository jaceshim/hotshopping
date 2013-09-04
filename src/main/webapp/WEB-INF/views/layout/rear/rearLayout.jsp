
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
		<link href="static/css/bootstrap.css" rel="stylesheet">
		<link href="static/css/common.css" rel="stylesheet">

		<!-- Custom styles for this template -->
		<link href="navbar-fixed-top.css" rel="stylesheet">

		<script src="/static/js/jquery.js"></script>
		<script src="/static/js/bootstrap.min.js"></script>		

		<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
		<!--[if lt IE 9]>
		<script src="/static/js/html5shiv.js"></script>
		<script src="/static/js/respond.min.js"></script>
		<![endif]-->

		<decorator:head />
	</head>

	<body>

		<!-- Fixed navbar -->
		<div class="navbar navbar-default navbar-fixed-top">
			<div class="navbar-inner">
				<div class="container-fluid">
					<a href="" class="btn btn-navbar" data-toggle="collapse" data-target=".navr-collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</a>
					<a href="" class="brand">Project name</a>
					<div class="nav-collapse">
						<ul>
							<li class="active"><a href="">home</a></li>
							<li><a href="">about</a></li>
							<li><a href="">Contact</a></li>
						</ul>
						<p class="navbar-text pull-right">Logged in as<a href="" class="">Username</a></p>
					</div>
				</div>
			</div>
		</div>

		<div class="container-fluid">
			<div class="row-fluid row">
				<div class="span3">
					<div class="navbar-collapse collapse sidebar-nav-fixed well">
						<ul class="nav navbar-nav">
							<li class="nav-header">메뉴</li>
							<li class="active"><a href="#">Home</a></li>
							<li><a href="#about">상품관리</a></li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown">카테고리 관리 <b class="caret"></b></a>
								<ul class="dropdown-menu">
									<li><a href="#">카테고리 목록</a></li>
									<li><a href="#">태그 목록</a></li>
									<li><a href="#">미등록 태그 목록</a></li>
								</ul>
							</li>
							<li><a href="#about">회원 관리</a></li>
							<li><a href="#about">어플버전 관리</a></li>
							<li><a href="#about">공지사항 관리</a></li>
							<li><a href="#about">관리자 관리</a></li>							
						</ul>
					</div> <!-- /navbar-collapse -->
				</div> <!-- /span3 -->

				<div class="span9 span-fixed-sidebar">
					<div class="row-fluid">
						<decorator:body />
						content 
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
						<p></p>
					</div>
				</div>
			</div>

			<hr>

			<footer>
				<p>&copy; Company 2013</p>
			</footer>

		</div>

	</body>
</html>
