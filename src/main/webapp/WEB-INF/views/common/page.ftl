<script type="text/javascript">
	function jsMovePage(pageNum) {
	    var form = document.${page.formName};
	    if (form.pageNum === undefined) {
	    	var newPageNumEl = document.createElement('input');
	    	newPageNumEl.name='pageNum';
	    	newPageNumEl.type = 'hidden';
	    	
	    	form.appendChild(newPageNumEl);
	    }
	    
	    form.pageNum.value = pageNum;
	    form.action = document.location.pathname;
	    form.submit();		
	}
</script>
<div class="pagination pagination-centered">
	<ul>

		<#-- TODO: 로직검토 
		<#if page.hasPrevPageUnit()>
		<li><a href="#" onclick="jsMovePage(${page.pageOfPrevPageUnit}); return false;">맨처음</a></li>
		</#if>
		-->
		
		<#if page.hasPrevPage()>
		<li><a href="#" onclick="jsMovePage(${page.prevPage}); return false;">Prev</a></li>
		</#if>
		
		<#assign pageIdx = page.beginUnitPage>
		<#list pageIdx..page.endItemsPage as num>
			<#assign isActive = (num == page.currentPage)>
			
			<#if isActive>
				<li class="active">
					<a href="#">${num}</a>
				</li>
			<#else>
				<li>
					<a href="#" onclick="jsMovePage(${num}); return false;">${num}</a>
				</li>				 
			</#if>
		
		</#list>
		
		<#if page.hasNextPage()>
		<li><a href="#"  onclick="jsMovePage(${page.nextPage}); return false;">Next</a></li>
		</#if>
		
		<#-- TODO: 로직검토
		<#if page.hasNextPageUnit()>
		<li><a href="#" onclick="jsMovePage(${page.pageOfNextPageUnit}); return false;">맨마지막</a></li>
		</#if>
		-->		
	</ul>
</div>