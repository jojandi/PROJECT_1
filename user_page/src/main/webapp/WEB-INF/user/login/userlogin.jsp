<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
