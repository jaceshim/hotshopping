<head>
	<title>카테고리 태그 목록</title>
	<script type="text/javascript">
		function insertCategory() {
			var form = document.cateForm;
			form.action = "insertForm";
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
		<td>카테고리 아이디</td>
		<td>카테고리 명</td>
		<td>부모카테고리 아이디</td>
		<td>사용여부</td>
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
<button onclick="insertCategory();">등록</button>

</body>




	