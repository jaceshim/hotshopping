<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html >
<head>
	<meta charset="utf-8">
	<title>Hot Shopping Administration :: <sitemesh:write property='title' /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<!-- The styles -->
	<link id="bs-css" href="${ctx}/static/ui/css/bootstrap-cerulean.css" rel="stylesheet">
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<link href="${ctx}/static/ui/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/charisma-app.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/fullcalendar.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/fullcalendar.print.css" rel="stylesheet"  media="print">
	<link href="${ctx}/static/ui/css/chosen.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/uniform.default.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/colorbox.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/jquery.cleditor.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/jquery.noty.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/noty_theme_default.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/elfinder.min.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/elfinder.theme.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/jquery.iphone.toggle.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/opa-icons.css" rel="stylesheet">
	<link href="${ctx}/static/ui/css/uploadify.css" rel="stylesheet">

	<!-- The fav icon -->
	<link rel="shortcut icon" href="${ctx}/static/ui/img/favicon.ico">
	
	<!-- jQuery -->
	<script src="${ctx}/static/ui/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="${ctx}/static/ui/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="${ctx}/static/ui/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="${ctx}/static/ui/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="${ctx}/static/ui/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="${ctx}/static/ui/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="${ctx}/static/ui/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="${ctx}/static/ui/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="${ctx}/static/ui/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="${ctx}/static/ui/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="${ctx}/static/ui/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="${ctx}/static/ui/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="${ctx}/static/ui/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="${ctx}/static/ui/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="${ctx}/static/ui/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="${ctx}/static/ui/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src="${ctx}/static/ui/js/fullcalendar.min.js"></script>
	<!-- data table plugin -->
	<script src="${ctx}/static/ui/js/jquery.dataTables.min.js"></script>

	<!-- chart libraries start -->
	<script src="${ctx}/static/ui/js/excanvas.js"></script>
	<script src="${ctx}/static/ui/js/jquery.flot.min.js"></script>
	<script src="${ctx}/static/ui/js/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/ui/js/jquery.flot.stack.js"></script>
	<script src="${ctx}/static/ui/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="${ctx}/static/ui/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="${ctx}/static/ui/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="${ctx}/static/ui/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="${ctx}/static/ui/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="${ctx}/static/ui/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="${ctx}/static/ui/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="${ctx}/static/ui/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="${ctx}/static/ui/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="${ctx}/static/ui/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="${ctx}/static/ui/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="${ctx}/static/ui/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="${ctx}/static/ui/js/charisma.js"></script>	
	
	
	<sitemesh:write property='head' />
		
</head>

<body>
		<!-- topbar starts -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"> <img alt="WCS Logo" src="${ctx}/static/ui/img/logo20.png" /> <span>Hot Shopping</span></a>
				
				<!-- theme selector starts -->
				<div class="btn-group pull-right theme-container" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-tint"></i><span class="hidden-phone">테마변경</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="themes">
						<li><a data-value="classic" href="#"><i class="icon-blank"></i> Classic</a></li>
						<li><a data-value="cerulean" href="#"><i class="icon-blank"></i> Cerulean</a></li>
						<li><a data-value="cyborg" href="#"><i class="icon-blank"></i> Cyborg</a></li>
						<li><a data-value="redy" href="#"><i class="icon-blank"></i> Redy</a></li>
						<li><a data-value="journal" href="#"><i class="icon-blank"></i> Journal</a></li>
						<li><a data-value="simplex" href="#"><i class="icon-blank"></i> Simplex</a></li>
						<li><a data-value="slate" href="#"><i class="icon-blank"></i> Slate</a></li>
						<li><a data-value="spacelab" href="#"><i class="icon-blank"></i> Spacelab</a></li>
						<li><a data-value="united" href="#"><i class="icon-blank"></i> United</a></li>
					</ul>
				</div>
				<!-- theme selector ends -->
				
				<!-- user dropdown starts -->
				<div class="btn-group pull-right" >
					<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
						<i class="icon-user"></i><span class="hidden-phone"> 홍길동</span>
						<span class="caret"></span>
					</a>
					<ul class="dropdown-menu">
						<li><a href="#">정보수정</a></li>
						<li class="divider"></li>
						<li><a href="login.html">로그아웃</a></li>
					</ul>
				</div>
				<!-- user dropdown ends -->
				
				<!-- 
				<div class="top-nav nav-collapse">
					<ul class="nav">
						<li><a href="#">Visit Site</a></li>
						<li>
							<form class="navbar-search pull-left">
								<input placeholder="Search" class="search-query span2" name="query" type="text">
							</form>
						</li>
					</ul>
				</div>
				 -->
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>
	<!-- topbar ends -->
	<div class="container-fluid">
		<div class="row-fluid">
				
			<!-- left menu starts -->
			<div class="span2 main-menu-span">
				<div class="well nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li class="nav-header hidden-tablet">Menu</li>
						<li><a class="ajax-link" href="/rear/main"><i class="icon-home"></i><span class="hidden-tablet">Dashboard</span></a></li>
						<li><a class="ajax-link" href="/rear/product/list"><i class="icon-tags"></i><span class="hidden-tablet">상품관리</span></a></li>
						<li id="#catemenu">
							<a class="accordion-toggle" data-toggle="collapse" data-parent="#catemenu" href="#collapseOne"><i class="icon-tasks"></i><span class="hidden-tablet">카테고리 관리</span></a>
							<div id="collapseOne" class="accordion-body collapse out">
								<div class="accordion-inner">
									<ul class="nav-stacked">
										<li><a class="ajax-link" href="/rear/category/list"><span class="hidden-tablet">카테고리 목록</span></a></li>
										<li><a class="ajax-link" href="/rear/category/tag/list"><span class="hidden-tablet">태그 목록</span></a></li>
										<li><a class="ajax-link" href="/rear/category/tag/unreg/list"><span class="hidden-tablet">미등록 태그 목록</span></a></li>
									</ul>
								</div>
							</div>
						</li>
						<li><a class="ajax-link" href="/rear/member/list"><i class=" icon-user"></i><span class="hidden-tablet">회원 관리</span></a></li>
						<li><a class="ajax-link" href="/rear/appver/list"><i class="icon-bell"></i><span class="hidden-tablet">어플 버전 관리</span></a></li>						
						<li><a class="ajax-link" href="/rear/notice/list"><i class="icon-bullhorn"></i><span class="hidden-tablet">공지사항 관리</span></a></li>
						<li><a class="ajax-link" href="/rear/manager/list"><i class="icon-user"></i><span class="hidden-tablet">관리자관리</span></a></li>
					</ul>
					<label id="for-is-ajax" class="hidden-tablet" for="is-ajax"><input id="is-ajax" type="checkbox"> Ajax on menu</label>
				</div><!--/.well -->
			</div><!--/span-->
			<!-- left menu ends -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<div id="content" class="span10">
				<!-- content starts -->
				<div>
					<ul class="breadcrumb">
						<li>
							<a href="#">Home</a> <span class="divider">/</span>
						</li>
						<li>
							<a href="#">Dashboard</a>
						</li>
					</ul>
				</div>
				
				<div>
					<sitemesh:write property='body' />
				</div>
				
				<!-- content ends -->
			</div><!--/#content.span10-->
		</div><!--/fluid-row-->
				
		<hr>

		<div class="modal hide fade" id="myModal">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">×</button>
				<h3>Settings</h3>
			</div>
			<div class="modal-body">
				<p>Here settings can be configured...</p>
			</div>
			<div class="modal-footer">
				<a href="#" class="btn" data-dismiss="modal">Close</a>
				<a href="#" class="btn btn-primary">Save changes</a>
			</div>
		</div>

		<footer>
			<p class="pull-left">&copy; <a href="#" target="_blank">GS SHOP</a> 2013</p>
			<p class="pull-right">Powered by: <a href="#">GS SHOP</a></p>
		</footer>
		
	</div><!--/.fluid-container-->

	
</body>
</html>
