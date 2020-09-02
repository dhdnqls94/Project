<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@ page import="com.project.web.board.dao.*" %>
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
					<!-- <h2 class="main title">공지사항</h2> -->
					  <h1 class="main title" align="center">배송준비 페이지</h1>
					  <div align="center">
					  	<%-- <form action="ProductRefund.po?productnum=${ list.productnum }" method="post"> --%>
					  		<table class="table table-hover">
					  			<tr>
					  				<th>주문번호</th>
					  				<th>이름</th>
					  				<th style="text-align: center">주소</th>
					  				<th>제품명</th>
					  				<th>제품 수량</th>
					  				<th>금액</th>
					  				<th>배송상태</th>
					  				<th>처리</th>
					  			</tr>
					  			<c:forEach var="list" begin="0" end="${ list.size() }" items="${ list }">
					  			<tr>
					  				<td>${ list.productnum }</td>
					  				<td>${ list.name }</td>
					  				<td align="center">${ list.addr }</td>
					  				<td>${ list.productName }</td>
					  				<td align="center">${ list.productQty }</td>
					  				<td><fmt:formatNumber value="${ list.productTotal }" pattern="###,###,###"/></td>
					  				<%-- <td>${ list.productTotal }</td> --%>
					  				<td>배송준비중</td>
					  				<td><button onclick="location.href='ProductDeliveryProcessing.po?productnum=${ list.productnum }'">배송완료</button></td>
					  			</tr>
					  			</c:forEach>
					  		</table>
					  	<!-- </form> -->
					</div>
				</div>
			</div>
		</div>
	</div>
						
								
	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>
</body>

</html>