<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/base/user_base.css" rel="stylesheet">
</head>
<body>
	<!-- 가장 위 고정 -->
    <header id="top" class="clearfix">
                
        <div id="logoall">
            <div id="logo" class="left"></div>
            <!-- <a href="01.main_user_login.html" id="name" class="left">행복만땅 <br>도서관</a> -->
            <a href="01.main_user.html" id="name" class="left">행복만땅 <br>도서관</a>
        </div>

        <div id="menu">
            <div id="items" class="left">
                <a href="bookflix" class="item" id="i0">북플릭스</a>
                <a href="library" class="item" id="i1">도서관</a>
                <a href="best" class="item" id="i2">베스트</a>
                <a href="notic" class="item" id="i3">정보광장</a>
                <a href="mypage/use" class="item" id="i4">마이페이지</a>
            </div>
`
            <div class="right" id="userall">
                <a href="./로그인css.html" class="inb" id="login">로그인</a>
                <div class="inb">|</div>
                <a href="./회원가입.html" class="inb" id="userin">회원가입</a>
            </div>

            <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
            <!-- <div class="right" id="userall">
                <a href="./02.mypage_info.html" class="inb" id="user">조잔디님</a>
                <span class="material-symbols-outlined">person</span>
            </div> -->
        </div>
        <script src="./00.user_base.js"></script>
        
    </header>
</body>
</html>