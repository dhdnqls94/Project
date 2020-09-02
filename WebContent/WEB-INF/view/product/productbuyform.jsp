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
	no, qty, name, category, price, img
	<!----------------------------------- 디자인 넣는 부분 ----------------------------------->
	<div class="main main-raised">
		<div class="section section-basic">
			<div class="container">
				<div class="title">
					  <h1 class="main title" align="center">구매 정보</h1>
					  <div align="center">
					  	<form action="ProductInfoForm.po" method="post">
					  		<table width="1000">
					  			<tr>
					  				<td rowspan="7" width="500" align="center">
					  					<img src="img/${ img }" width="450">
					  				</td>
					  				
					  				<td width="250" align="center">제품</td>
					  				<td width="250" align="center">${ name }</td>
					  			</tr>
					  			
					  			<tr>
					  				<td width="250" align="center">수량</td>
					  				<td width="250" align="center">${ qty }</td>
					  			</tr>
					  			
					  			<tr>
					  				<td width="250" align="center">가격</td>
					  				<%-- <td width="250" align="center">${ price }</td> --%>
					  				<td width="250" align="center"><fmt:formatNumber value="${ price }" pattern="###,###,###"/></td>
					  			</tr>
					  			
					  			<tr>
					  				<td width="250" align="center">소계</td>
					  				<c:set var="total" value="${ price * qty }"/>
					  				<%-- <td width="250" align="center">${ total }</td> --%>
					  				<td width="250" align="center"><fmt:formatNumber value="${ total }" pattern="###,###,###"/></td>
					  			</tr>
					  			
					  			<tr>
					  				<td align="center" colspan="2">
					  					<input type="hidden" name="no" value="${ no }">
					  					<input type="hidden" name="img" value="${ img }">
					  					<input type="hidden" name="name" value="${ name }">
					  					<input type="hidden" name="qty" value="${ qty }">
					  					<input type="hidden" name="price" value="${ price }">
					  					<input type="hidden" name="total" value="${ total }">
					  					<input type="submit" value="주문하기" class="btn btn-success btn-round">
					  					<button class="btn btn-default btn-round">
					  						<a href="ProductCartForm.po?no=${ no }&qty=${ qty }& total=${ total }
					  														&img=${ img }&name=${ name }&price=${ price }">장바구니</a>
					  					</button>
					  					<input type="button" value="뒤로가기" onclick="history.back()" class="btn btn-primary btn-round">
					  				</td>
					  			</tr>
					  		</table>
					  	</form>	
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