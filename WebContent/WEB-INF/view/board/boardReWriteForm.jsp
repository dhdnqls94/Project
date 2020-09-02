<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <jsp:include page="../header.jsp"/>
 
	
<!DOCTYPE html>
<html>
<!-----------------------------------<head>부분 건들면 안됨 ----------------------------------->
<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="./assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="./assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Material Kit by Creative Tim</title>
<meta content='width=device-width, initial-scale=1.0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
<!-- CSS Files -->
<link href="./assets/css/material-kit.css?v=2.0.7" rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="./assets/demo/demo.css" rel="stylesheet" />
</head>

<body class="index-page sidebar-collapse">
	<!----------------------------------- 배경사진 및 코로나 기부금 중단 ----------------------------------->
	<div class="page-header header-filter clear-filter "
		data-parallax="true"
		style="background-image: url('./assets/img/bg.jpg');">
		<div class="container">
			<div class="row">
				<div class="col-md-8 ml-auto mr-auto">
					<div class="brand">
						<h1>이번달 기부 금액 2.000.000</h1>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<!----------------------------------- 디자인 넣는 부분 ----------------------------------->
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<div class="title">
					<h2 class="main title" align="center">답글 쓰기</h2>
				<form action="boardReWriteAction.bo" method="post">
						<table class="table">
					<%-- <c:forEach var="n" items="${ list }"> --%>
						<tr>
							<td>작성자</td>
							<td>${ sessionID }</td>
							
							<td>제목</td>
							<td><input type="text" name="bTitle" value="[답변]"></td>
						</tr>
						
						<tr>
							<td>이메일</td>
							<td>${ bEmail }</td>
						</tr>
						
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="bPassword"></td>
						</tr>
						
						<tr>
							<td>글내용</td>
							<td><textarea rows="10" cols="60" name="content"></textarea></td>
						</tr>
						
						<tr>
							<td><input type="hidden" name="ref" value="${ ref }"></td>
							<td><input type="hidden" name="reStep" value="${ reStep }"></td>
							<td><input type="hidden" name="reLevel" value="${ reLevel }"></td>
							<td><input type="hidden" name="id" value="${ sessionID }"></td>
							<td><input type="hidden" name="bEmail" value="${ bEmail }"></td>
						</tr>
						
				<div align="center">
					<input type="submit" value="답글완료">&nbsp;&nbsp;
					<button><a href="list.bo">취소</a></button> &nbsp;&nbsp;
					<input type="reset" value="다시작성">&nbsp;&nbsp;
					<button><a href="index.po">메인페이지</a></button>&nbsp;&nbsp;
				</div>
					  <%-- </c:forEach> --%>
					</table>
					<div align="center">
				</form>
					</div>
					
					</div>
				</div>
				<div class="space-50"></div>
			</div>
		</div>

	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>
</body>

</html>