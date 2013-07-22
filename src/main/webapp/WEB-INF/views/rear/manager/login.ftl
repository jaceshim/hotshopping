<head>
	<title>로그인</title>
	<script type="text/javascript">
		function jsLogin() {
			var form = $('form')[0];
			if (form.managerId.value == '') {
				alert('관리자 아이디를 입력해 주십시오.');
				form.managerId.focus();
				return false;
			} else if (form.passwd.value == '') {
				alert('비밀번호를 입력해 주십시오.');
				form.passwd.focus();
				return false;
			}
			
			form.action = 'login';
			return true;
		}
	</script>
</head>
<body>
	<div class="row-fluid">
		<div class="span12 center login-header">
			<h2>Welcome to WCS</h2>
		</div><!--/span-->
	</div><!--/row-->

	<div class="row-fluid">
		<div class="well span5 center login-box">
			<div class="alert alert-info">
				관리자 아이디와 비밀번호를 입력 후 로그인 해주십시오.
			</div>
			<form class="form-horizontal" method="post" onsubmit="return jsLogin();">
				<fieldset>
					<div class="input-prepend" title="관리자 아이디" data-rel="tooltip">
						<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="managerId" id="managerId" type="text" value="" />
					</div>
					<div class="clearfix"></div>

					<div class="input-prepend" title="비밀번호" data-rel="tooltip">
						<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="passwd" id="passwd" type="password" value="" />
					</div>
					<div class="clearfix"></div>

					<div class="input-prepend">
					<label class="remember" for="rememberId"><input type="checkbox" id="rememberId" />아이디 저장</label>
					</div>
					<div class="clearfix"></div>

					<p class="center span5">
					<button type="submit" class="btn btn-primary">Login</button>
					</p>
				</fieldset>
			</form>
		</div><!--/span-->
	</div><!--/row-->

</body>