<head>
	<title>카테고리 목록</title>
	<style type="text/css">
		.parent-category-hover {
			background-color: #CCDDBB;
		}
		.child-category-hover {
			background-color: #EDEBE1;
		}
	</style>
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
		
		function rightViewHandler(flag, catenm, cateid) {
			var $rightViewTitle = $('#dev-right-view-title');
			var $rightViewContent = $('#dev-right-view-content');
			var rightViewTitle = '';
			if (flag == 'C') {
				if (cateid == -1) {
					// 일단 2depth 하위 카테고리 생성은 막음.
					alert('하위 카테고리를 생성할 수 없는 카테고리 입니다.');
					return;
				}
				rightViewTitle = ' 하위 카테고리 등록';
			} else if (flag == 'R') {
				rightViewTitle = '카테고리 상세조회';
			} else if (flag == 'U') {
				rightViewTitle = '카테고리 수정';
			}
			
			$rightViewTitle.text('[ ' + catenm + ' ] ' + rightViewTitle);
			$rightViewContent.html('<h1>신규등록폼.</h1>');
			$('html, body').animate({ scrollTop: ($rightViewTitle.offset().top-20) }, 500);
		}
		
		$(document).ready(function () {
			$('label.tree-toggler').click(function () {
				var $tempThis = $(this);
				$('label.tree-toggler').parents().removeClass('parent-category-hover');
				$('.dev-submenu-item').removeClass('child-category-hover');
				
				$tempThis.parent().addClass('parent-category-hover');
				$tempThis.parent().children('ul.tree').toggle(300);
			});
			
			$('.dev-submenu-item').click(function() {
				var $tempThis = $(this);
				$('.dev-submenu-item').removeClass('child-category-hover');
				$(this).addClass('child-category-hover');
			});
		});
	</script>
</head>
<body>

<div class="row-fluid">

	<div class="box span4">
		<div class="box-header well">
			<h2>카테고리 목록</h2>
		</div>
		<div class="box-content">
			<div style="overflow-y: scroll; overflow-x: hidden; height: 500px;">
				<ul class="nav nav-list ">
				<#assign parentLevel = 0>
				<#list categoryList as item>
					<#if parentLevel != 0 && item.level == 1>
							</li>
						</ul></li>
						<li class="divider"></li>
					</#if>				
					<#if item.level == 1>
						<li>
							<label class="tree-toggler nav-header" style="font-size: 1.2em; cursor: pointer;"><span>${item.cateName}</span>
								<div class="box-icon">
									<a href="#" onclick="rightViewHandler('R', '${item.cateName}', ${item.cateId}); return false;" data-rel="tooltip" data-original-title="상세조회">
										<i class="icon-info-sign"></i>
									</a>							
									<a href="#" onclick="rightViewHandler('U', '${item.cateName}', ${item.cateId}); return false;" style="margin-left: 8px;" data-rel="tooltip" data-original-title="정보수정">
										<i class="icon-ok-sign"></i>
									</a>							
									<a href="#" onclick="rightViewHandler('C', '${item.cateName}', -1); return false;" style="margin-left: 8px;" data-rel="tooltip" data-original-title="신규등록">
										<i class="icon-plus-sign"></i>
									</a>
								</div>
							</label>
							<ul class="nav nav-list tree" style="display: none;">
					<#else>
						<li>
							<a href="#" class="dev-submenu-item" ><span>${item.cateName}</span>
								<div class="box-icon">
									<a href="#" onclick="rightViewHandler('R', '${item.cateName}', ${item.cateId}); return false;" data-rel="tooltip" data-original-title="상세조회">
										<i class="icon-info-sign"></i>
									</a>							
									<a href="#" onclick="rightViewHandler('U', '${item.cateName}', ${item.cateId}); return false;" style="margin-left: 8px;" data-rel="tooltip" data-original-title="정보수정">
										<i class="icon-ok-sign"></i>
									</a>							
									<a href="#" onclick="rightViewHandler('C', '${item.cateName}', -1); return false;" style="margin-left: 8px;" data-rel="tooltip" data-original-title="신규등록">
										<i class="icon-plus-sign"></i>
									</a>
								</div>
							</a>
						</li>
					</#if>
					<#assign parentLevel = item.level>
				</#list>
				</ul>
			</div>
    	</div>  	                
	</div>
	
	<div class="box span8">
		<div class="box-header well">
			<h2 id="dev-right-view-title">&nbsp;</h2>
		</div>
		<div class="box-content">
			<div class="row-fluid">
				<div id="dev-right-view-content">&nbsp;</div>
			</div>
    	</div>                  
	</div>
	
</div>

</body>




	