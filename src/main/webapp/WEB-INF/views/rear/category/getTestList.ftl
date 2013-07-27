<head>
</head>
<body>

<div class="box-content">
	<table class="table">
		  <thead>
			  <tr>
				  <th>순번</th>
				  <th>column1</th>
				  <th>column2</th>
				  <th>column3</th>
				  <th>column4</th>                                    
			  </tr>
		  </thead>   
		  <tbody>
		  	<#list data.items as item>
			<tr>
				<td>${item.seq}</td>
				<td class="center">${item.co1}</td>
				<td class="center">${item.co2}</td>
				<td class="center">${item.co3}</td>
				<td class="center">${item.co4}</td>                                       
			</tr>
			</#list>                                 
		  </tbody>
	 </table>
	 
	 ${data.pageHtml}
	     
</div>

</body>