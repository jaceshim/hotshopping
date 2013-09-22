<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="page" uri="http://www.opensymphony.com/sitemesh/page" %>

<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap Admin ::: <decorator:title /></title>
		<meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<link rel="stylesheet" type="text/css" href="${ctx}/static/css/bootstrap.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/static/css/layout.css">
		<link rel="stylesheet" type="text/css" href="${ctx}/static/css/common.css">

		<!-- Demo page code -->

		<style type="text/css">
			#line-chart {
				height:300px;
				width:800px;
				margin: 0px auto;
				margin-top: 1em;
			}
			.brand { font-family: georgia, serif; }
			.brand .first {
				color: #ccc;
				font-style: italic;
			}
			.brand .second {
				color: #fff;
				font-weight: bold;
			}
		</style>


		<script type="text/javascript" src="${ctx}/static/js/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="${ctx}/static/js/jquery.validate.js"></script>
		<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		
		<script src="${ctx}/static/js/bootstrap.js"></script>
		<script src="${ctx}/static/js/common.js"></script>
		
        <decorator:head />

	</head>

	<!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
	<!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
	<!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
	<!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
	<!--[if (gt IE 9)|!(IE)]><!-->
	<body>
	<!--<![endif]-->

		<div class="navbar">
			<div class="navbar-inner">
   				<ul class="nav pull-right">
   					<li id="fat-menu" class="dropdown">
   						<a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
   							<i class="icon-user"></i> Jack Smith
   							<i class="icon-caret-down"></i>
   						</a>

   						<ul class="dropdown-menu">
   							<li><a tabindex="-1" href="#">My Account</a></li>
   							<li class="divider"></li>
   							<li><a tabindex="-1" class="visible-phone" href="#">Settings</a></li>
   							<li class="divider visible-phone"></li>
   							<li><a tabindex="-1" href="sign-in.html">Logout</a></li>
   						</ul>
   					</li>
   				</ul>
   				<a class="brand" href="index.html"><span class="first">Your</span> <span class="second">Company</span></a>
			</div>
		</div>
		<div class="sidebar-nav">
			<a href="/rear/main" class="nav-header">
				<i class="icon-home"></i>
				Home
			</a>	
			<a href="/rear/product/list" class="nav-header">
				<i class="icon-gift"></i>
				상품관리
			</a>
			
			<a href="#dev-category-menu" class="nav-header">
				<i class="icon-list-alt"></i>
				카테고리 관리
				<i class="icon-chevron-down"></i>
			</a>
            <ul id="dev-category-menu" class="nav nav-list" style="display: none;">
                <li>
                	<a href="/rear/category/list">
                		<i class="icon-list-alt"></i>
                		카테고리 목록
                	</a>
                </li>
                <li>
                	<a href="/rear/category/tag/list">
                		<i class="icon-tags"></i>
                		TAG 목록
                	</a>
                </li>
                <li>
                	<a href="/rear/category/tag/unreg/list">
                		<i class="icon-flag"></i>
                		미등록 TAG 목록
                	</a>
                </li>
            </ul>
	        <a href="/rear/member/list" class="nav-header">
	        	<i class="icon-user"></i>
	        	회원관리
	        </a>
	        <a href="/rear/apps/version" class="nav-header">
	        	<i class="icon-eye-open"></i>
	        	어플버전 관리
	        </a>
	        <a href="/rear/notice/list" class="nav-header">
	        	<i class="icon-bullhorn"></i>
	        	공지사항 관리
	        </a>
	        <a href="/rear/manager/list" class="nav-header" >
	        	<i class="icon-user"></i>
	        	관리자 관리
	        </a>
		</div>
		<div class="content">
			<ul class="breadcrumb">
				<li>
					<i class="icon-globe"></i>
					<span class="content-title"><decorator:title /></span>
				</li>
			</ul>
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="row-fluid">
						<!--  -->
						<decorator:body />
					</div>
					<footer>
						<hr>

						<!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
						<!-- <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p> -->

						<p>&copy; 2013 <a href="#" target="_blank">company</a></p>
					</footer>
				</div>
			</div>
		</div>
	</body>
</html>


