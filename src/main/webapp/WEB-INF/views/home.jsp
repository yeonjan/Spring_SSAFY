<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>홈페이지</h1>
	<a href="${pageContext.request.contextPath}/book/list">책 목록 조회</a>
	<a href="${pageContext.request.contextPath}/book/goRegist">책 등록</a>
	<c:if test="${empty userInfo}">
		<a href="${pageContext.request.contextPath}/user/login">로그인</a>
	</c:if>
	<c:if test="${not empty userInfo}">
		<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
	</c:if>


</body>
</html>
