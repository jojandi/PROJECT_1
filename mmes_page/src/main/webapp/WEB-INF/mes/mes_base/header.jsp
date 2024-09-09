<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./assets/css/base/user_base.css" rel="stylesheet">
</head>
<body>
	<!-- 가장 위 고정 -->
    <header id="top" class="clearfix">

        <div id="logoall">
            <div id="logo" class="left"><a href="main"><img class="logo_img" src="https://cdn.discordapp.com/attachments/1263360143756759099/1267275014273634415/KakaoTalk_20240729_090859720-removebg-preview_3.png?ex=66a83154&is=66a6dfd4&hm=4f6d706e06b34db529815a64763136b9f3f073d06fbc4513dd57c737077310f0&"></a></div>
            <!-- <div id="name" class="left">행복만땅 <br>도서관</div> -->
        </div>

        <div id="menu">
            <div id="items" class="left">
                <div class="item" id="i1"><a href="pfwork">작업 수행</a></div>
                <div class="item" id="i2"><a href="workorder">생산 관리</a></div>
                <div class="item" id="i3"><a href="stock">재고 관리</a></div>
                <div class="item" id="i4"><a href="human">직원 관리</a></div>
                <div class="item" id="i5"><a href="buser">북플릭스 관리</a></div>
                <div class="item" id="i6"><a href="notice">게시판</a></div>
            </div>
            <c:if test="${ not empty login }">
				<div class="right" id="userall">
					<span class="inb" id="user">${ login.user_name }님</span>
	                <span class="material-symbols-outlined">person</span>
				</div>
			</c:if>
        </div>
    </header>
</body>
</html>