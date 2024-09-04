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
<link href="../assets/css/my/user_mypage_cart.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
<!-- mypage-use -->	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <div id="wrap">
        <!-- 사이드 -->
        <%@ include file="/WEB-INF/user/my/user_mypage_side.jsp" %>

        <section id="cart">

            <div id="stitle">
                <h3>${ login.user_name }님의 찜 목록</h3>
            </div>

        <div id="table_btn">

           	<div id="t1" class="table">
                <table>
                    <colgroup>
                        <col width="5%">
                        <col width="15%">
                        <col width="55%">
                        <col width="15%">
                    </colgroup>
                    <thead> 
                        <tr>
                            <td>
                                <input type="checkbox" id="chkall">
                            </td>
                            <td colspan="2">상품명</td>
                            <!-- <td id="tw"></td> -->
                            <td>예약/삭제</td>
                        </tr>
                    </thead>

                    <tbody>
                    	<c:forEach var="list" items="${list}">
                    	<input type="hidden" name="user" class="code" value="${login.user_seq}">
            			<input type="hidden" name="code" class="user" value="${list.book_code}">
	                        <tr class="cart">
	                            <td rowspan="3" class="border">
	                                <input type="checkbox" name="cart_chk" value="${list.book_code}" class="chk"> 
	                            </td>
	                            <td rowspan="3" class="bookCover border">
	                                <img src="${list.book_img}"  alt="${list.book_name}의 책표지">
	                            </td>
	                            <td class="bookTitle book">
	                                ${list.book_name}
	                            </td>
	                            <td class="border" rowspan="3">
	                            	<form method="post" action="cart_res">
	                            		<input type="hidden" name="seq" value="${list.user_seq}">
	                            		<input type="hidden" name="code" value="${list.book_code}">
	                            		<input type="hidden" name="cart" value="${list.cart_seq}">
		                                <input type="submit" class="reser" value="예약"><br>
	                            	</form>
	                            	<form method="post" action="cart_del">
	                            		<input type="hidden" name="seq" value="${list.user_seq}">
	                            		<input type="hidden" name="cart" value="${list.cart_seq}">
	                            		<input type="hidden" name="cart_seq" value="1">
		                                <input type="submit" class="del" value="삭제">
	                            	</form>
	                            </td>
	                        </tr>
	                       	<tr>
	                            <td id="info" class="book">
	                                 - ${list.li_book_info}
	                            </td>
	                        </tr>
	                        <tr class="cart">
	                            <td class="wirter book border">
	                            	<span>${list.book_author}(지은이)</span>
	                            	<span> | </span>
	                            	<span>${list.book_pub}(주)</span>
	                            </td>
	                        </tr>
	                    </c:forEach>
                    </tbody>
                </table>
            </div>

            <div id="bntall">
                <input type="button" id="reserchk" class="bnt" value="선택 도서 예약하기"><br>
                <input type="button" id="delall" class="bnt" value="전체 도서 삭제하기">
                <input type="button" id="reserall" class="bnt" value="전체 도서 예약하기">
            </div>
        
        </div>
        </section>
		<script>
			let user = '${login.user_seq}';
		</script>
        <script src="../assets/js/my/mypage_cart.js"></script>
        <script src="../assets/js/my/mypage_cart_post.js"></script>
    <!-- wrap -->
    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>

</body>
</html>