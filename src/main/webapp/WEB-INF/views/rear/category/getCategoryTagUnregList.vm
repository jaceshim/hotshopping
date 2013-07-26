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
<form name="cateForm" method="get">

</form>


	<div class="row-fluid">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-tasks"></i> 로그 그룹 목록</h2>
			</div>
			<div class="box-content">
				<div class="row-fluid">
					<form name="searchForm" id="searchForm">
					<div class="span2">
						<select name="siteId" onchange="jsSearch();">
							<option value="">전체</option>
							<#list siteList as item>
							<option value="${item.siteId}" >${item.siteName}</option>
							</#list>
						</select>	
					</div>
					</form>
				</div>
				
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>그룹 순번</th>
							<th>그룹명(국문)</th>
							<th>그룹명(영문)</th>
							<th>사이트명</th>
							<th>구분자</th>
							<th>Actions</th>
						</tr>
					</thead>   
					<tbody>
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
								<a class="btn btn-info" href="#" onclick="insertCategoryTag(); return false;">
									<i class="icon-edit icon-white"></i> 카테고리 태그 등록                                            
								</a>								
								<button onclick="insertCategoryTag();">카테고리 태그 등록</button>
							</td>
						</tr>
						</#list>
						<#if !categoryUnregList?has_content>
						<tr>
							<td class="center" colspan="6">등록된 그룹이 없습니다.</td>
						</tr>
						</#if>
					</tbody>
				</table>				
				
			</div>
		</div>
	</div>
</body>




	