<#include "/common/macro.ftl">

<head>
	<title>상품 목록</title>
	<script type="text/javascript">
		var URI_PREFIX = '/rear/product/';
		
		function jsList() {
			var form = document.prdForm;
			form.action = URI_PREFIX + 'list';
			form.submit();
		}
	</script>
</head>
<body>

	<div class="box-content">
		<div class="row-fluid">
		
			<form name="prdForm" id="prdForm">
				<input type="hidden" name="pageNum" >
			<div class="span6">
				<span>몰 : </span>
				<select name="mallId" onchange="jsList()">
					<option value="">-- 선택 --</option>
					<#assign mallIdParam="-1">
					<#if !RequestParameters.mallId?exists || RequestParameters.mallId == "">
						<#assign mallIdParam="-1">
					<#else>
						<#assign mallIdParam=RequestParameters.mallId>
					</#if>
					<#list mallList as item>
					<option value="${item.mallId}" <#if mallIdParam?number == item.mallId>selected="selected"</#if> >${item.mallName}</option>
					</#list>
				</select>
			</div>
			</form>
		</div>
			
		<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th>#</th>
					<th>몰</th>
					<th>카테고리</th>
					<th>상품이미지</th>
					<th>상품명</th>
					<th>원상품 아이디</th>
					<th>상품가격</th>
					<th>사용여부</th>
					<th width="100">Action</th> 
				</tr>
			</thead>
			<tbody>
			
				<#list page.items as item>
				<tr>
					<td>${item.prdSeq?c}</td>
					<td><@parsePrdType item.prdType /></td>
					<td>
						<#if item.category?exists>
							${item.category.cateName}
						<#else>
							N/A
						</#if>
					</td>
					<td><a href="${item.prdUrl!''}" target="_blank"><img src="${item.prdThumbUrl!''}" class="prd-img"></a></td>
					<td><a href="${item.prdUrl!''}" target="_blank">${item.prdName!'N/A'}</a></td>
					<td>${item.prdOrgId}</td>
					<td>${item.prdPrice}</td>
					<td>${item.useYn}</td>
					<td>&nbsp;</td>
				</tr>
				</#list>
				<#if !page.items?has_content>
				<tr>
					<td colspan="9">등록된 데이터가 없습니다.</td>
				</tr>
				</#if>
			</tbody>
		</table>
	
	
		${page.getPageHtml("prdForm")}
	</div>


</body>




	