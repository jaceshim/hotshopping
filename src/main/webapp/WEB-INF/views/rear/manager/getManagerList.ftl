<head>
	<title>관리자 목록조회</title>
	<script type="text/javascript">
	
		$(function() {
			var URI_PREFIX = '/rear/manager/';
			
			$('.wcsdev-update-btn').bind('click', function() {
				var $form = $('#linkForm');
				$('#linkForm').attr('action', URI_PREFIX + 'updateform');
				var mgrId = $(this).attr('mgrId');
				$('#mgrId').val(mgrId);
				
				$form.submit();		
			});
			
			$('.wcsdev-insert-btn').bind('click', function(e) {
				var $form = $('#linkForm');
				$form.attr('action', URI_PREFIX + 'insertform');
				$('#mgrId').remove();
				
				$form.submit();
			});
		});
		
	</script>
</head>
<body>

	<div class="box-content">
		<form name="linkForm" id="linkForm" method="post">
			<input type="hidden" name="mgrId" id="mgrId" >
		</form>

		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>관리자 아이디</th>
					<th>관리자 명</th>
					<th>활성여부</th>
					<th>등록일시</th>
					<th>마지막 로그인 일시</th>
					<th>Actions</th>
				</tr>
			</thead>   
			<tbody>
				<#list page.items as item>
				<tr>
					<td class="center">${item.mgrId}</td>
					<td class="center">${item.mgrName}</td>
					<td class="center">
						<#if item.useYn == "Y"> 활성
						<#else> 비활성
						</#if>
					</td>
					<td>${item.regDt}</td>
					<td>${item.loginDt!'N/A'}</td>
					<td>
						<button class="btn btn-info wcsdev-update-btn" mgrId="${item.mgrId}">
							<i class="icon-edit icon-white"></i>
							정보수정
						</button>								
					</td>
				</tr>
				</#list>
				<#if !page.items?has_content>
				<tr>
					<td class="center" colspan="7">등록된 관리자가 없습니다.</td>
				</tr>
				</#if>
			</tbody>
		</table>
		
		<button class="btn btn-primary wcsdev-insert-btn">신규등록</button>
		
	</div>
</body>