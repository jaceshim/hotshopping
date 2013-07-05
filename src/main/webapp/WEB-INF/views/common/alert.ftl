<!-- TODO: freemarker기반으로변경. -->
<form id="alertForm" name="alertForm" onsubmit="return false;">
	#if (! (!$params))
		#foreach ( $key in $params.keySet() )
		<input type="hidden" name="$key" value="$params.get($key)" />
		#end
	#end
</form>
<script type="text/javascript">
	var form = document.alertForm;
	#if ($!type == 1)
		form.method = 'get';
		form.action = '$!destUrl';
	#elseif ($!type == 2)
		alert('$!message');
		history.back(-1);
	#elseif ($!type == 3)
		alert('$!message');
		form.target = opener.name;
		form.method = 'get';
		form.action = '$!destUrl';
		self.close();
	#elseif ($!type == 4 || $!type == 5)
		alert('$!message');	
		
		#if ($!type == 5)
		form.method = 'post';
		#else
		form.method = 'get';
		#end
		form.action = '$!destUrl';
	#elseif ($!type == 6 || $!type == 7)
		#if ($!type == 7)
		form.method = 'post';
		#else
		form.method = 'get';
		#end
		
		var answer = confirm('$!message');
		if (answer) {
		    #if (!(!$destUrl) && "$!destUrl" != "")
		    form.action = '$!destUrl';
		    #end
		} else {
			#if (!(!$cancelUrl) && "$!cancelUrl" != "")
			form.action = '$!cancelUrl';
			#end
		}
	#end
	
	#if (!(!$target) && "$!target" != "")
	form.target = '$!target';
	#end
	
	#if ($!type != 2)
		form.submit();
	#end
</script>