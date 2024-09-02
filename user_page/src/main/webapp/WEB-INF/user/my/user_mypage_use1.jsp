<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이페이지</title>
<link href="../assets/css/my/user_mypage_use.css" rel="stylesheet">
<style>
    section #smenu #res{ font-weight: 900; text-decoration: underline; }
    
</style>
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
<!-- mypage-use -->	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <div id="wrap">
        <!-- 사이드 -->
        <%@ include file="/WEB-INF/user/my/user_mypage_side.jsp" %>

        <section id="use">

            <div id="stitle">
                <h3>${ login.user_name }님의 이용내역</h3>
            </div>
            
            <div id="smenu"> 
                <span class="text on" id="res"><a href="res?seq=${login.user_seq}">예약내역</a></span>
                <span class="text" id="line">|</span>
                <span class="text on" id="loan"><a href="loan?seq=${login.user_seq}">대출내역</a></span>
                <span class="text" id="line">|</span>
                <span class="text on" id="overdue"><a href="over?seq=${login.user_seq}">연체내역</a></span>
            </div>

            <div class="table">
                <table>
                    <thead> 
                        <tr>
                            <td class="bnameall">도서명</td>
                            <td class="day1">예약일자</td>
                            <td class="day1">픽업일자</td>
                            <td>예약번호</td>
                            <td>현황</td>
                        </tr>
                    </thead>

                    <tbody>
                        <tr>
                            <td class="bname">봄은 또 오고</td>
                            <td>24.06.10</td>
                            <td>24.06.12</td>
                            <td>12345678</td>
                            <td>픽업완료</td>
                        </tr>
                        <tr>
                            <td class="bname">죽여 마땅한 사람들</td>
                            <td>24.06.14</td>
                            <td>-</td>
                            <td>56565656</td>
                            <td>대기중</td>
                        </tr>
                    </tbody>
                </table>
            </div>

            <div id="movepage">
                <span class="material-symbols-outlined">chevron_left</span>
                <span class="chap">1</span>
                <span class="material-symbols-outlined">chevron_right</span>
            </div>
        </section>

    <!-- wrap -->
    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>

</body>
</html>