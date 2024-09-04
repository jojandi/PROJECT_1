<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="mes_DTO.MesHumanDTO" %> 
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
                <div class="item" id="i4"><a href="human">직원 및 회원 관리</a></div>
                <div class="item" id="i5"><a href="statistics1">통계 및 분석</a></div>
                <div class="item" id="i6"><a href="notice">게시판</a></div>
            </div>
            <div class="right" id="userall">
                <div>OOO관리자</div>
                <div><a href="../사용자용 페이지/01.main_user.html">로그아웃</a></div>
                <!-- <div class="inb" id="login">로그인</div>
                <div class="inb">|</div>
                <div class="inb" id="userin">회원가입</div>
                <div class="inb" id="menus"></div> -->
            </div>
            
            <table id="main_library">
                            <colgroup>
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">회원번호</th>
                                   	<th>회원ID</th>
                                    <th>회원 주소</th>
                                    <th>회원 이메일</th>
                                    <th>가입일</th>
                                    <th>만료일</th>
                                </tr>
                            </thead>
				            <c:forEach var="dto" items="${list}">
				                <tr>
				                    <td><input type="checkbox" class="emp_checkbox"></td>				                    
									<td>${dto.buser_seq}</td> 
									<td>${dto.user_id}</td>
				                    <td>${dto.user_addr}</td>
				                    <td>${dto.user_email}</td>
				                    <td>${dto.buser_date}</td>
				                    <td>${dto.buser_end}</td>
				                </tr>
				            </c:forEach>
        					</tbody>
                            </tbody>
                        </table>
        </div>
    </header>
</body>
</html>