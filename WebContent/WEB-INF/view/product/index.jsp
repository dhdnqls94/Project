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
				<div class="title" align="center">
					<!-- <h2 class="main title">전체상품</h2> -->
						<!-- <button><a href="boardWriteForm.bo">글쓰기</a></button> -->
						<!-- <font size="6" color="gray"> 전체상품 </font> -->
									<h1 class="main title" align="center">전체 상품</h1>
									<!-- <button><a href="boardWriteForm.bo">글쓰기</a></button> -->
							<table class="table" width="1000">
									<!-- <td align="center" colspan="3"> -->
								<c:set var="j" value="${ 0 }"/>
								<c:forEach var="list" begin="${ 0 }" end="${ list.size() }" items="${ list }" >
									<c:if test="${ j % 4 == 0 }">
							<tr height="220">
									</c:if>
											<td width="333" align="center">
												<a href="ProductDetailForm.po?no=${ list.no }">
													<img src="img/${ list.img }" width="200" height="200">
												</a><p>
												<font size="3" color="gray"><b>제품 : ${ list.name }</b></font><br>
												<font size="3" color="gray"><b>가격 : <fmt:formatNumber value="${ list.price }" pattern="###,###,###"/></b></font><br>
												<c:set var="j" value="${ j + 1 }"/>
											</td>
								</c:forEach>
							</tr>
						</table>
					</div>
				</div>
				<div class="space-50"></div>
			</div>
		</div>
	<!-- <img alt="마스크" src="img/filter.jpg" width="333px"/> -->
	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>
</body>

</html>