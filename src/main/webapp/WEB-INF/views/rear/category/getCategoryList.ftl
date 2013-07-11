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
<h3>카테고리 목록</h3>

<form name="cateForm" method="get">

</form>

<table border="1">
	<tr>
		<th>카테고리 아이디</th>
		<th>카테고리 명</th>
		<th>부모카테고리 아이디</th>
		<th>사용여부</th>
	</tr>
	<#list categoryList as item>
	<tr>
		<#if item.level > 1>
		<td>&nbsp</td>
		<td>${item.cateId}</td>
		<td>${item.cateName}</td>
		<td>${item.useYn}</td>
		<#else>
		<td>${item.cateId}</td>
		<td>${item.cateName}</td>
		<td>${item.pcateId}</td>
		<td>${item.useYn}</td>		
		</#if>
	</tr>
	</#list>
</table>
<br /><br />
<button onclick="showInsertForm();">등록</button>

<div id="insertFormArea" style="display: none;">
	<form name="insertCateForm">
	
	<table>
		<tr>
			<th style="width: 120px;">카테고리 명</th>
			<td>
				<input type="text" id="cateName" name="cateName" />
			</td>
		</tr>
		<tr>
			<th style="width: 120px;">상위 카테고리</th>
			<td>
				<select id="pcateId" name="pcateId">
					<option value="0">최상위로 등록</option>
					<#list categoryList as item>
						<option value="${item.cateId}">${item.cateName}</option>
					</#list>
				</select>
			</td>
		</tr>		
	
	
	</table>
	
	<form>
	<button onclick="showInsertForm();">취소</button>
	<button onclick="insertCategory();">카테고리 등록</button>
</div>

</body>




	