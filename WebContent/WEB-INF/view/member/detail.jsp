<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

                <h2 class="main title">공지사항</h2>
                    <table class="table">
                        <tbody>
                        	<tr>
                                <th>작성번호</th>
                                <td>${n.index_num}</td>
                            </tr>
                            <tr>
                                <th>제목</th>
                                <td>${n.title}</td>
                            </tr>
                            <tr>
                                <th>작성일</th>
                                <td>${n.date}</td>
                            </tr>
                            <tr>
                                <th>작성자</th>
                                <td>${n.admin}</td>
                            </tr>
                            <tr>
                            	<th>내용</th>
                                <td>${n.content}</td>
                            </tr>
                        </tbody>
                    </table>


                <div class="margin-top text-align-center">
                    <a class="btn-text btn-cancel" href="list">목록</a>
                    <!-- 수정삭제는 관리자만 보이게 하기 -->
                    <a class="btn-text btn-default" href="edit.html">수정</a>
                    <a class="btn-text btn-default" href="del.html">삭제</a>
                </div>

					</div>
			

				</div>
				<div class="space-50"></div>
			</div>
	<!----------------------------------- 하단 부분 ----------------------------------->
	<jsp:include page="../footer.jsp"/>
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
</body>

</html>