<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.pn -->g">
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
<!-- 여기가 새로운 -->
<!--  -->

	
	<nav class="navbar navbar-transparent navbar-color-on-scroll fixed-top navbar-expand-lg" color-on-scroll="100" id="sectionsNav">
		<div class="container">

			<div class="navbar-translate">
				<a class="navbar-brand" href="index.po">생활용품</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
					<span class="sr-only">Toggle navigation</span> <span class="navbar-toggler-icon"></span> <span class="navbar-toggler-icon"></span> <span class="navbar-toggler-icon"></span>
				</button>
			</div>

			<div class="collapse navbar-collapse">
				<ul class="navbar-nav ml-auto">
					<!-- <li class="dropdown nav-item"><a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <i class="material-icons">apps</i> memu -->
					<!-- </a> -->
						<!-- <div class="dropdown-menu dropdown-with-icons"> -->
							<!-- <a href="covid" class="dropdown-item"> <i class="material-icons"></i>코로나19 현황
							</a> <a href="index" class="dropdown-item"> <i class="material-icons"></i>전체상품
							</a> <a href="list" class="dropdown-item"> <i class="material-icons"></i>공지사항
							</a> -->
						<!-- </div></li> -->
					<li class="dropdown nav-item"><a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"> <i class="material-icons">apps</i> 관리자</a>
						<div class="dropdown-menu dropdown-with-icons">
							<a href="ProductDeliveryPreparationForm.po" class="dropdown-item"> <i class="material-icons"></i>배송준비</a>
							<a href="ProductDeliveryOkForm.po" class="dropdown-item"> <i class="material-icons"></i>배송완료</a> 
							<a href="ProductRefundForm.po" class="dropdown-item"> <i class="material-icons"></i>환불상품</a> 
							<a href="MemberListAll.do" class="dropdown-item"> <i class="material-icons"></i>회원리스트</a>
							<!-- <a href="adminproductwriter.jsp" class="dropdown-item"> <i class="material-icons"></i>상품등록</a> -->
							<!-- <a href="adminlist.jsp" class="dropdown-item"> <i class="material-icons"></i>공지관리</a> -->
						</div></li>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="index.po"> <i class=""></i>상품 페이지</a></li>
						<c:if test="${ sessionID eq null }">
							<li class="nav-item"><a class="nav-link" href="JoinForm.do"> <i class=""></i> 회원가입
							<li class="nav-item"><a class="nav-link" href="LoginForm.do"> <i class=""></i>로그인</a></li>
						</c:if>
						
						<c:if test="${ sessionID ne null }">
							<!-- <li class="nav-item"><a class="nav-link" href="MemberLogoutAction.do"> <i class=""></i>로그아웃</a></li> -->
							<%-- <li>${ sessionID }</li> --%>
							<li class="dropdown nav-item"><a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown"><i class="material-icons"></i>${ sessionID }
							</a>
								<div class="dropdown-menu dropdown-with-icons">
									<a href="MemberLogoutAction.do" class="dropdown-item"><i class="material-icons"></i>로그아웃</a>
									<a href="MemberInfoAction.do" class="dropdown-item"><i class="material-icons"></i>회원정보</a>
									<a href="ProductCartList.po" class="dropdown-item"><i class="material-icons"></i>장바구니</a>
									<a href="DeleteForm.do" class="dropdown-item"><i class="material-icons"></i>회원탈퇴</a>
								</div></li>
						</c:if>
						
					<li class="nav-item"><a class="nav-link" href="ProductOrderListForm.po"> <i class=""></i>주문확인</a></li>
					<li class="nav-item"><a class="nav-link" href="list.bo"> <i class=""></i>자유게시판</a></li>
					<li class="nav-item"><a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://twitter.com/KoreaCDC" target="_blank" data-original-title="Follow us on Twitter" rel="nofollow"> <i class="fa fa-twitter"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://www.facebook.com/koreacdcpr" target="_blank" data-original-title="Like us on Facebook" rel="nofollow"> <i class="fa fa-facebook"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link" rel="tooltip" title="" data-placement="bottom" href="https://www.youtube.com/channel/UCa7-3Zvxg-5Rfxgu3RQY_gw" target="_blank" data-original-title="Follow us on Youtube" rel="nofollow"> <i class="fa fa-youtube"></i>
					</a></li>

				</ul>
			</div>
		</div>
	</nav>

</body>
</html>