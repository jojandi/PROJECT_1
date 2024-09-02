<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link href="../assets/css/login/user_login.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>

	<!-- 여기에 내가 짠 코드 넣기 -->
	<div class="container">
		<h1 class="title">행복만땅 도서관</h1>
		<form method="post" action="login">
			<div class="input-group">
				<input type="text" id="username" name="id" placeholder="ID">
			</div>
			<div class="input-group">
				<input type="password" id="password" name="pw" placeholder="Password">
				<img src="../assets/img/logo.png">
			</div>
			<c:if test='${param.code == "LO01" }'>
				<div id="error">
					아이디 또는 비밀번호를 확인해 주세요. 
				</div>
			</c:if>
			<div>
				<input type="submit" value="회원로그인" class="login-btn" id="loginBtn">
			</div>
			
	</form>
	</div>

	<!-- <script src="../assets/js/login/user_login.js"></script> -->


	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>
</body>
</html>
