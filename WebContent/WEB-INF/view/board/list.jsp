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
					<h2 class="main title">자유게시판</h2>
						<!-- <button><a href="boardWriteForm.bo">글쓰기</a></button> -->
					<form action="boardWriteForm.bo" method="post">
					<input type="submit" value="글쓰기">
						<table class="table">
								<tr>
									<th class="expand">작성번호</th>
									<th class="w100">작성자</th>
									<th class="w100">제목</th>
									<th class="w100">작성일</th>
									<th class="w100">조회수</th>
								</tr>
							<c:forEach var="list" items="${ list }">
							<c:set var="number" value="${ number }"/>
								<tr>
									<td>${ number }</td>
									<td>${ list.bWriter }</td>
									<td>
										<c:if test="${ list.reStep > 1 }">
										<c:forEach var="j" begin="1" end="${ (list.reStep-1)*5 }">
											&nbsp;
										</c:forEach>
										</c:if>
										<a href="boardOneForm.bo?bNum=${ list.bNum }">${ list.bTitle }</a>
									</td>
									<td>${ list.bDate }</td>
									<td>${ list.readCount }</td>
									<td><input type="hidden" name="bWriter" value="${ n.bWriter }"></td>
								</tr>
							<c:set var="number" value="${ number-1 }"/>
							</c:forEach>
						</table>
						<!-- <input type="submit" value="글쓰기"> -->
						
						<!-- 페이지 카운터링 소스를 작성 -->
						<p>
			<div align="center">
					<c:if test="${ count > 0 }">
							<c:set var="pageCount" value="${ count/pageSize+(count%pageSize == 0 ? 0 : 1) }" />
							<c:set var="startPage" value="${ 1 }"/>
							
						<c:if test="${ currentPage % 10 != 0 }">
								<fmt:parseNumber var="result" value="${ currentPage/10 }" integerOnly="true"/>
								<c:set var="startPage" value="${ result*10+1 }"/>
						</c:if>
							
							<c:if test="${ currentPage%10 == 0 }">
								<c:set var="startPage" value="${ (result-1)*10+1 }"/>
							</c:if>
							
							<c:set var="pageBlock" value="${ 10 }"/>
							<c:set var="endPage" value="${ startPage+pageBlock-1 }"/>
							
						<c:if test="${ endPage > pageCount }">
							<c:set var="endPage" value="${ pageCount }"/>
								
							<c:if test="${ startPage > 10 }">
								<a href="list.bo?pageNum=${ startPage-10 }">[이전] </a>
							</c:if>
						</c:if>
						
						<c:forEach var="i" begin="${ startPage }" end="${ endPage }">
							<a href="list.bo?pageNum=${ i }">[${ i }] </a>
						</c:forEach>
						
						<c:if test="${ endPage < pageCount }">
							<a href="list.bo?pageNum=${ startPage+10 }">[다음] </a>
						</c:if>
					</c:if>
			</div>
				</form> 
					</div>
				</div>
				<div class="space-50"></div>
			</div>
		</div>
		
		<!-- 페이지 카운터링 소스를 작성 -->

	<!----------------------------------- 하단 부분 ----------------------------------->
	<!-----------------------------------  Core JS Files 반응형동작 부분  (절대로 손대지 말것) ----------------------------------->
	<jsp:include page="../footer.jsp"/>
</body>

</html>







































