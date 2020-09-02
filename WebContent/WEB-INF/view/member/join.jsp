<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../header.jsp" />
<%-- <jsp:include page="footer.jsp"/> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script type="text/javascript">
function IDCheck(){
    var id = $("#id").val();
    $.ajax({
       type: 'POST',
       /* url: './IDCheck', */
       url: './IDCheck',
       data: {id : id},
       success: function(rs){
          /* if(rs==1) $('#IDCheckMessage').html('사용 가능한 아이디 입니다').css('color', 'green');
          else $('#IDCheckMessage').html('사용할 수 없는 아이디 입니다').css('color', 'red');
          $('#checkModal').modal("hide"); */
            if(rs == 1) {
            	alert("사용할 수 없는 아이디 입니다.")
          } else {
          	alert("사용 가능한 아이디 입니다.")
          } 
       }
    });
 }


</script>
<body class="index-page sidebar-collapse">
	<!----------------------------------- 배경사진 및 코로나 기부금 중단 ----------------------------------->
	<div class="page-header header-filter clear-filter purple-filter" data-parallax="true" style="background-image: url('./assets/img/bg2.jpg');">
		<div class="container">
			<div class="title">
				<div class="col-lg-4 col-md-6 ml-auto mr-auto">
					<div class="card card-login">

						<form class="form" method="post" action="MemberJoinAction.do">
							<div class="card-header card-header-primary text-center">
								<h4 class="card-title">회원가입</h4>
							</div>

							<div class="card-body">
								<div class="input-group">
									<input id="id" type="text" name="id" class="form-control" placeholder="아이디" required>
									<button onclick="IDCheck();" type="button" style="width: auto;">중복체크</button><br>
									<!-- <h5 style="margin-left: 28px;" id="IDCheckMessage"></h5> -->
									<div style="size: 1px;" id="IDCheckMessage"></div>
								</div>
								<div class="input-group">
									<input type="text" name="name" class="form-control" placeholder="이름" required>
								</div>
								<div class="input-group">
									<input type="password" name="passwd" class="form-control" placeholder="비밀번호" required>
								</div>
								<div class="input-group">
									<input type="text" name="addr" class="form-control" placeholder="주소" required>
								</div>
								<div class="input-group">
									<input type="text" name="phone" class="form-control" placeholder="휴대폰" required>
								</div>
								
								<div class="input-group">
									<input type="email" name="email" class="form-control" placeholder="이메일" required">
								</div>
							</div>
							<div class="footer text-center">
								<!-- <a href="" class="btn btn-primary btn-link btn-wd btn-lg">회원가입</a> -->
								<input class="btn btn-primary btn-link btn-wd btn-lg" type="submit" value="회원가입">
							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!----------------------------------- 디자인 넣는 부분 ----------------------------------->


	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>


</body>

</html>