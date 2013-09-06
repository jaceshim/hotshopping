<head>
	<title>로그인</title>
	<style type="text/css">
		body {
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #eee;
		}
		
		.form-signin {
			max-width: 330px;
			padding: 15px;
			margin: 0 auto;
		}
		.form-signin .form-signin-heading,
		.form-signin .checkbox {
			margin-bottom: 10px;
		}
		.form-signin .checkbox {
			font-weight: normal;
		}
		.form-signin .form-control {
			position: relative;
			font-size: 16px;
			height: auto;
			padding: 10px;
			-webkit-box-sizing: border-box;
				 -moz-box-sizing: border-box;
							box-sizing: border-box;
		}
		.form-signin .form-control:focus {
			z-index: 2;
		}
		.form-signin input[type="text"] {
			margin-bottom: -1px;
			border-bottom-left-radius: 0;
			border-bottom-right-radius: 0;
		}
		.form-signin input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
	<script type="text/javascript">
		$(function() {
			var URI_PREFIX = '/rear/manager/';
			
			var SAVE_MANAGER_ID_KEY = 'save_manager_id';
			
			var saveManagerId = Common.getCookie(SAVE_MANAGER_ID_KEY);
			if (saveManagerId != '') {
				$('#mgrId').val(saveManagerId);
				
				var $saveId = $('#saveId');
				$saveId.attr('checked', true);
			}
			
			$('form').validate({
				rules: {
					mgrId: {required: true},
					password: {required: true},
				},
				messages: {
					mgrId: '아이디를 입력해 주십시오.',
					password: '비밀번호를 입력해 주십시오.'
				},
				submitHandler: function (frm) {
					if ($('#saveId').is(':checked') ) {
						Common.setCookie(SAVE_MANAGER_ID_KEY, $('#mgrId').val(), {expires: 60*24*365*10});
					} else {
						Common.deleteCookie(SAVE_MANAGER_ID_KEY);
					}
					frm.submit();
            	}
			});
		});
	</script>
</head>
<body>

	<div class="container">
		<form action="login" method="post" class="form-signin">
			<h2 class="form-signin-header">Please Login</h2>
			<input type="text" name="mgrId" placeholder="아이디" class="form-control" autofocus >
			<input type="password" name="password" placeholder="비밀번호" class="form-control" >
			<label for="saveId" class="checkbox">
				<input type="checkbox" id="saveId" />아이디 저장
			</label>
			<button class="btn btn-lg btn-primary btn-block" type="submit">로그인</button>
		</form>
	</div>

</body>