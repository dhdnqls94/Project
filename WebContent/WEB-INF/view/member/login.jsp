<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp"/>
<!DOCTYPE html>
<html>
<!-----------------------------------<head>부분 건들면 안됨 ----------------------------------->
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="./assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Material Kit by Creative Tim</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no' name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="./assets/css/material-kit.css?v=2.0.7" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="./assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">
	<!----------------------------------- 배경화면 및 로그인 페이지 ----------------------------------->
	<div class="page-header header-filter clear-filter purple-filter" data-parallax="true" style="background-image: url('./assets/img/bg2.jpg');">
		<div class="container">
			<div class="title">
				<div class="col-lg-4 col-md-6 ml-auto mr-auto">
					<div class="card card-login">

						<!-- <form class="form" method="" action=""> -->
						<form name="Member" class="form" method="post" action="MemberLoginAction.do">
							<div class="card-header card-header-primary text-center">
								<h4 class="card-title">Login</h4>
							</div>

							<div class="card-body">
								<div class="input-group">
									<input type="text" class="form-control" placeholder="id" name="id">
								</div>

								<div class="input-group">
									<input type="password" class="form-control" placeholder="Password" name="passwd">
								</div>
							</div>

							<div class="footer text-center">
								<input type="submit" value="로그인" class="btn btn-primary btn-link btn-wd btn-lg" onclick="checkMember()">
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">

		function checkMember() {
			// 영문 대문자와 소문자, 한글 한글이 자음과 모음만 검사하는 정규 표현식
			/* var regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; */

			// 이름에 대해 한글만 검사하는 정규 표현식
			/* var regExpName = /^[가-힣]*$/; */

			// 숫자만 검사하는 정규 표현식
			/* var regExpPasswd = /^[0-9]*$/; */
			
			/* var regExpPasswd = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣 | 0-9]/; */

			//전화번호 형태인지 검사하는 정규 표현식
			/* var regExpPhone = /^\d{3}-\d{3,4}-\d{4}$/; */

			// 이메일 형태인지 검사하는 정규 표현식
			/* var regExpEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; */

			/* var form = document.Member; */

			/* var id = form.id.value; */
			/* var name = form.name.value; */
			/* var passwd = form.passwd.value; */

			/* if(id == "") {
				alert("아이디를 입력해주세요!");
				form.id.select();
				return;
			} else if(passwd == "") {
				alert("비밀번호를 입력해주세요!");
				form.passwd.select();
			} */
			
			/* if (!regExpId.test(id)) {
				alert("아이디는 영문자로 시작해 주세요!");
				form.id.select();
				return;
			}
				
			else if (!regExpPasswd.test(passwd)) {
				alert("비밀번호에 특수문자는 뺴주세요!");
				form.passwd.select();
				return;
			}

			form.submit();

		} */
	</script>
	<!----------------------------------- 디자인 넣는 부분 ----------------------------------->

	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>
</body>

</html>