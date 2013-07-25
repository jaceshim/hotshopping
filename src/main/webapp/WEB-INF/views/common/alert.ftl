<#if alertType == "alert_and_post" || alertType == "confirm_and_post">
	<#assign methodType = "post">
<#else>
	<#assign methodType = "get">
</#if>

<script type="text/javascript">
	window.onload = function() {
		goPage();
	}
	
	function goPage() {
		var form = document.alertForm;
		<#if alertType == "go_page">
			form.method = '${methodType}';
			form.action = '${redirectUrl}';
		<#elseif alertType == "alert_and_back">
			alert('${message}');
			history.back(-1);
		<#elseif alertType == "alert_and_close">
			alert('${message}');
			form.target = opener.name;
			form.method = '${methodType}';
			form.action = '${redirectUrl}';
			self.close();
		<#elseif alertType == "alert_and_go" || alertType == "alert_and_post">
			alert('${message}');	
			form.method = '${methodType}';
			form.action = '${redirectUrl}';
		<#elseif alertType == "confirm_and_go" || alertType == "confirm_and_post">
			form.method = '${methodType}';
			var answer = confirm('${message}');
			if (answer) {
				<#if redirectUrl?has_content>
			    form.action = '${redirectUrl}';
			    </#if>
			} else {
				<#if cancelUrl?has_content>
				form.action = '${cancelUrl}';
				</#if>
			}
		</#if>
		
		<#if target?has_content>
			form.target = '${target}';
		</#if>
		
		<#if alertType != "alert_and_back">
			form.submit();
		</#if>	
	}
	
</script>

<form id="alertForm" name="alertForm" onsubmit="return false;">
	<#if params?has_content>
		<#list params?keys as key>
			<input type="hidden" name="${key}" value="${params.get(key)}" />
		</#list>
	</#if>
</form>