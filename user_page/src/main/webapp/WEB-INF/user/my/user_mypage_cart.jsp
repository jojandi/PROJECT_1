<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <h3>조잔디님의 찜 목록</h3>
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
                        <tr class="cart">
                            <td rowspan="2">
                                <input type="checkbox" name="cart_chk" value="1" class="chk"> 
                            </td>
                            <td rowspan="2" class="bookCover">
                                <img src="https://image.aladin.co.kr/product/33845/80/covermini/k132930705_1.jpg">
                            </td>
                            <td class="bookTitle book">
                                사랑받는 이기주의자
                                <div> - 나를 지키며 사랑받는 관계의 기술</div>
                            </td>
                            <td rowspan="2">
                            	<form method="post" action="res">
                            		<input type="hidden" name="li_book_code" value="1">
	                                <input type="submit" class="reser" value="예약"><br>
                            	</form>
                            	<form method="post" action="cart_del">
                            		<input type="hidden" name="cart_seq" value="1">
	                                <input type="submit" class="del" value="삭제">
                            	</form>
                            </td>
                        </tr>
                        <tr class="cart">
                            <td class="wirter book">박코 (지은이)</td>
                        </tr>

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

        <script src="../assets/js/my/mypage_cart.js"></script>
        <script src="../assets/js/my/mypage_cart_post.js"></script>
    <!-- wrap -->
    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>

</body>
</html>