<head>
	<title>카테고리 미등록 태그 목록</title>
	<script type="text/javascript">
		function insertCategoryTag(seq, cateId) {
			alert(seq + ' : ' + cateId);
		}	
	</script>
</head>
<body>

<form name="cateForm" id="cateForm">

</form>
<div class="box-content">
	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>순번</th>
				<th>몰</th>
				<th>상품순번</th>
				<th>상품이미지</th>
				<th>상품명</th>
				<th>태그</th>
				<th>처리여부</th>
				<th>등록일시</th>
				<th>Action</th> 
			</tr>
		</thead>
		<tbody>
			<#list page.items as item>
			<tr>
				<td>${item.seq?c}</td>
				<td>${item.mallId}</td>
				<td>${item.prdSeq?c}</td>
				<td><a href="${item.prdUrl}" target="_blank"><img src="${item.prdThumbUrl}"></a></td>
				<td><a href="${item.prdUrl}" target="_blank"><a ${item.prdName}</a></td>
				<td>${item.tag}</td>
				<td>${item.procYn}</td>
				<td>${item.regDt}</td>
				<td>
					<div class="btn-group">
						<button type="button" class="btn btn-primary">태그등록</button>
						<button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown"><span class="caret"></span></button>
						<ul class="dropdown-menu">
							<#assign tempPcateId=-1>
							<#list categoryList as cate>
								<#if tempPcateId != -1 && tempPcateId != cate.pcateId>
								<li class="divider"></li>
								</#if>
								<li>
									<a href="#" onclick="insertCategoryTag(${item.seq}, ${cate.cateId});">
										<#if 1 < cate.level>
											&nbsp;&nbsp;&nbsp;
										</#if>
										${cate.cateName}
									</a>
								</li>
								<#assign tempPcateId=cate.pcateId>
							</#list>
						</ul>
					</div>		
				</td>
			</tr>
			</#list>
			<#if !page.items?has_content>
			<tr>
				<td colspan="9">등록된 데이터가 없습니다.</td>
			</tr>
			</#if>
		</tbody>
	</table>
	
	${page.getPageHtml("cateForm")}
	
</div>

</body>




	