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
					  <h1 class="main title" align="center">장바구니</h1>
					  <div align="center">
					  		<table class="table" width="1000">
					  			<tr align="center">
					  				<th colspan="2">제품 이미지</th>
					  				<th></th>
					  				<th>제품 이름</th>
					  				<th>제품 수량</th>
					  				<th>금액</th>
					  				<th>구매 여부</th>
					  				<th>삭제하기</th>
					  			</tr>
					  		<c:forEach var="ArrayList" items="${ ArrayList }">
					  			<tr align="center">
					  				<td colspan="2"><img src="img/${ ArrayList.img }" width="120" height="100"></td>
					  				<td></td>
					  				<td>${ ArrayList.name }</td>
					  				<td>${ ArrayList.qty }</td>
					  				<c:set var="total" value="${ qty * price }"/>
					  				<td><fmt:formatNumber value="${ ArrayList.qty * ArrayList.price }" pattern="###,###,###"/></td>
					  				<td><button><a href="ProductBuyForm.po?no=${ ArrayList.no }&qty=${ ArrayList.qty }
					  								&name=${ ArrayList.name }&price=${ ArrayList.price }
					  								&img=${ ArrayList.img }">구매하기</a></button></td>
					  				<td>
						  				<button onclick="alert('해당 장바구니 상품 삭제 완료')"><a href="ProductCartDelete.po?no=${ ArrayList.no }&qty=${ ArrayList.qty }
						  								&name=${ ArrayList.name }&price=${ ArrayList.price }
						  								&img=${ ArrayList.img }">삭제</a>
						  				</button>
					  								
					  				</td>
					  				
					  			</tr>
					  		</c:forEach>
					  	</table>
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