<head>
	<title>카테고리 태그 목록</title>
	<script type="text/javascript">

	</script>
</head>
<body>

<form name="cateForm" id="cateForm">

</form>

<div class="box-content">

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th width="60">순번</th>
				<th>카테고리 아이디</th>
				<th>카테고리 명</th>
				<th>태그</th>
				<th>Action</th> 
			</tr>
		</thead>
		<tbody>
			<#list page.items as item>
			<tr>
				<td>${item.seq?c}</td>
				<td>${item.category.cateId}</td>
				<td>${item.category.cateName}</td>
				<td>${item.tag}</td>
				<td>&nbsp;</td>
			</tr>
			</#list>
			<#if !page.items?has_content>
			<tr>
				<td colspan="5">등록된 데이터가 없습니다.</td>
			</tr>
			</#if>
		</tbody>
	</table>
	
	${page.getPageHtml("cateForm")}
	
</div>

</body>




	