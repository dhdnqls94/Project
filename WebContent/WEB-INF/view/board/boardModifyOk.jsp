<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>boardModifyOk 들어옴</h2>
	<c:if test="${ test == 1 }">
		<script type="text/javascript">
			alert("수정완료");
			location.href="list.bo";
		</script>
	</c:if>
	<c:if test="${ test == 0 }">
		<script type="text/javascript">
			alert("수정실패");
			location.href="list.bo";
		</script>
	</c:if>
</body>
</html>