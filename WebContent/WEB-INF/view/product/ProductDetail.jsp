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
					  <h1 class="main title" align="center">상품 정보</h1>
					  <div align="center">
					  	<form action="ProductBuyForm.po?no=${ dto.no }" method="post">
					  		<table class="table" width="1000">
					  			<tr height="100">
					  				<td rowspan="6" width="400" align="center">
					  					<img src="img/${ dto.img }" width="450">
					  				</td>
					  				<td width="250" align="center"><b>제품이름</b></td>
					  				<td width="250" align="center">${ dto.name }</td>
					  			</tr>
					  			<tr>
					  				<td width="250" align="center"><b>제품수량</b></td>
					  				<td width="250" align="center"><select name="qty">
					  												<option value="1">1</option>
					  												<option value="2">2</option>
					  												<option value="3">3</option>
					  											  </select></td>
					  			</tr>
					  			<tr>
					  				<td width="250" align="center"><b>제품분류</b></td>
					  				<c:set var="category" value="${ dto.category }"/>
							  		<c:choose>
							  			<c:when test="${ category eq 1 }">
							  				<c:set var="temp" value="마스크"/>
							  				<td width="250" align="center">${ temp }</td>
							  			</c:when>
							  			
							  			<c:when test="${ category eq 2 }">
							  				<c:set var="temp" value="구강/면도"/>
							  				<td width="250" align="center">${ temp }</td>
							  			</c:when>
							  			
							  			<c:when test="${ category eq 3 }">
							  				<c:set var="temp" value="헤어/바디/세안"/>
							  				<td width="250" align="center">${ temp }</td>
							  			</c:when>
							  			
							  			<c:when test="${ category eq 4 }">
							  				<c:set var="temp" value="청소"/>
							  				<td width="250" align="center">${ temp }</td>
							  			</c:when>
							  			<c:otherwise>
							  				Error
							  			</c:otherwise>
							  		</c:choose>
					  			</tr>
					  				
					  			<tr>
					  				<td width="250" align="center"><b>제품가격</b></td>
					  				<td width="250" align="center"><fmt:formatNumber value="${ dto.price }" pattern="###,###,###"/></td>
					  			</tr>
					  			<tr>
					  				<td align="center" colspan="2">
					  					<input type="hidden" name="no" value="${ dto.no }">
					  					<input type="hidden" name="name" value="${ dto.name }">
					  					<input type="hidden" name="category" value="${ dto.category }">
					  					<input type="hidden" name="price" value="${ dto.price }">
					  					<input type="hidden" name="img" value="${ dto.img }">
					  					<input type="submit" value="구매하기">
					  					<input type="button" value="상품 목록" onclick="location.href='index.po'">
					  				</td>
					  			</tr>
					  		</table>
					  		<br><br><br>
					  		<font size="5" color="gray"> 제품 정보 </font>
					  		<p>
					  		<font size="4" color="black">${ dto.info }</font>
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