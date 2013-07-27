
<#if startRow != 0 || rowPerPage != 0>
<script type="text/javascript">
	function jsMovePage(currentPage) {
	    var form = document.forms[0];
	    form.currentPage.value = currentPage;
	    form.action = '/rear/category/test/list';
	    form.submit();		
	}
</script>
<div class="pagination pagination-centered">
	<ul>
		<#if blockFirstPage > 1>
		<li><a href="#" onclick="jsMovePage(1); return false;">맨처음</a></li>
		</#if>
		
		<#if prevPageRow  > 0>
		<li><a href="#" onclick="jsMovePage(${prevPageRow}); return false;">Prev</a></li>
		</#if>
		
		<#assign pageNum = blockFirstPage>
		<#list pageNum..blockLastPage as num>
			<#assign isActive = (num==currentPage)>
			
			<#if isActive>
				<li class="active">
					<a href="#">${num}</a>
				</li>
			<#else>
				 <#assign firstRow = ((num - 1) * rowPerPage) + 1>
				<li>
					<a href="#" onclick="jsMovePage(${firstRow}); return false;">${num}</a>
				</li>				 
			</#if>
		
		</#list>
		
		<#if nextPageRow > 0>
		<li><a href="#"  onclick="jsMovePage(${nextPageRow}); return false;">Next</a></li>
		</#if>
		
		<#if blockLastPage < lastPage && currentPage != lastPage>
		<li><a href="#" onclick="jsMovePage(${lastPageRow}); return false;">맨마지막</a></li>
		</#if>
		
	</ul>
</div>
</#if>