<head>
	<title>카테고리 목록</title>
	<script type="text/javascript">
		function insertFormHandler() {
			var $insertForm = $('#insertFormArea');
			if ($insertForm.is(':visible')) {
				$insertForm.hide();
			} else {
				$insertForm.show();
			}
		}	
		
		function insertCategory() {
			var form = document.insertCateForm;
			if (form.cateName.value == '') {
				alert('카테고리명을 입력해 주십시오.');
				form.cateName.focus();
				return;
			}
			form.action = 'insert';
			form.submit();
		}
	</script>
</head>
<body>

<div class="row-fluid">

	<div class="box span3">
		<div class="box-header well" data-original-title="">
			<h2>부모 카테고리</h2>
		</div>
		<div class="box-content">
      	<div class="row-fluid">
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
        	<div class="span4"><h6>span 4</h6></div>
    	</div>                   
	</div>

	<div class="box span3">
		<div class="box-header well" data-original-title="">
			<h2><i class="icon-th"></i> Grid 3</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
      	<div class="row-fluid">
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
        </div>                   
      </div>
	</div><!--/span-->
	<div class="box span3">
		<div class="box-header well" data-original-title="">
			<h2><i class="icon-th"></i> Grid 3</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
      	<div class="row-fluid">
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
        </div>                   
      </div>
	</div><!--/span-->
	<div class="box span3">
		<div class="box-header well" data-original-title="">
			<h2><i class="icon-th"></i> Grid 3</h2>
			<div class="box-icon">
				<a href="#" class="btn btn-close btn-round"><i class="icon-remove"></i></a>
			</div>
		</div>
		<div class="box-content">
      	<div class="row-fluid">
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
            <div class="span4"><h6>span 4</h6></div>
        </div>                   
      </div>
	</div><!--/span-->

	</div><!--/span-->
</div>

</body>




	