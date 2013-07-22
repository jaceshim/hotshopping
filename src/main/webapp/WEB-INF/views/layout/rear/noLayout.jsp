<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html >
<head>
	<meta charset="utf-8">
	<title>WCS Administration :: <sitemesh:write property='title' /></title>
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
	
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->	

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

	<div class="container-fluid">
		<div class="row-fluid">
			<div>
				<sitemesh:write property='body' />
			</div>
		</div><!--/fluid-row-->
		
	</div><!--/.fluid-container-->
	
</body>
</html>
