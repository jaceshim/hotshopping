<head>
	<title>카테고리 미등록 태그 목록</title>
	<script type="text/javascript">
		function insertCategoryTag() {
			var form = document.cateForm;
			form.action = "insertForm";
			form.submit();			
		}	
	</script>
</head>
<body>
<h3>카테고리 미등록 태그 목록</h3>

<form name="cateForm" method="get">

</form>

<table border="1">
	<tr>
		<td>순번</td>
		<td>몰아이디</td>
		<td>상품순번</td>
		<td>상품명</td>
		<td>태그</td>
		<td>처리여부</td>
		<td>등록일시</td>
		<td>작업</td>
	</tr>
	<#list categoryUnregList as item>
	<tr>
		<td>${item.seq}</td>
		<td>${item.mallId}</td>
		<td>${item.prdSeq}</td>
		<td>${item.prdName}</td>
		<td>${item.tag}</td>
		<td>${item.procYn}</td>
		<td>${item.regDt}</td>
		<td>
			<button onclick="insertCategoryTag();">카테고리 태그 등록</button>
		</td>
	</tr>
	</#list>
</table>

</body>




	