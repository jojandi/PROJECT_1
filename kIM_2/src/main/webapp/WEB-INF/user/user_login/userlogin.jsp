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
	<%@ include file="/WEB-INF/user/user_base/header.jsp"%>
	
	<!-- 여기에 내가 짠 코드 넣기 -->
	<div class="container">
    <h1 class="title">행복만땅 도서관</h1>
    <div class="input-group">
        <input type="text" id="username" placeholder="ID">
    </div>
    <div class="input-group">
        <input type="password" id="password" placeholder="Password">
        <img src="https://img.lovepik.com/free-png/20211107/lovepik-universal-books-material-png-image_400482551_wh1200.png" alt="Book">
    </div>
    <div>
        <input type="button" value="회원로그인" class="login-btn" id="loginBtn">
    </div>
    <div class="idpw">
        <input type="button" value="아이디 찾기">  
        <input type="button" value="비밀번호 찾기">
    </div>
</div>

<script src="../assets/js/login/user_login.js"></script>


	 <!-- footer -->
    <%@ include file="/WEB-INF/user/user_base/footer.jsp" %>
</body>
</html>
