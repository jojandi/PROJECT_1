<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이페이지</title>
<link href="../assets/css/my/user_mypage_cart.css" rel="stylesheet">
<style>
</style>
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/user_base/header.jsp" %>
	
<!-- mypage-use -->	
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <div id="wrap">
        <!-- 사이드 -->
        <%@ include file="/WEB-INF/user/user_my/user_mypage_side.jsp" %>

        <section id="cart">

            <div id="stitle">
                <h3>조잔디님의 장바구니</h3>
            </div>

        <div id="table_btn">

            <div id="t1" class="table">
                <table>
                    <colgroup>
                        <col width="5%">
                        <col width="15%">
                        <col width="55%">
                        <col width="10%">
                        <col width="15%">
                    </colgroup>
                    <thead> 
                        <tr>
                            <td>
                                <input type="checkbox" id="chkall">
                            </td>
                            <td colspan="2">상품명</td>
                            <!-- <td id="tw"></td> -->
                            <td>수량</td>
                            <td>예약/삭제</td>
                        </tr>
                    </thead>

                    <tbody>
                        <tr class="cart">
                            <td rowspan="2">
                                <input type="checkbox" class="chk"> 
                            </td>
                            <td rowspan="2" class="bookCover">
                                <img src="https://image.aladin.co.kr/product/33845/80/covermini/k132930705_1.jpg">
                            </td>
                            <td class="bookTitle book">
                                사랑받는 이기주의자
                                <div> - 나를 지키며 사랑받는 관계의 기술</div>
                            </td>
                            <td rowspan="2">
                                <select>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                </select>
                            </td>
                            <td rowspan="2">
                                <input type="button" class="reser" value="예약"><br>
                                <input type="button" class="del" value="삭제">
                            </td>
                        </tr>
                        <tr class="cart">
                            <td class="wirter book">박코 (지은이)</td>
                        </tr>

                        <tr class="cart">
                            <td rowspan="2">
                                <input type="checkbox" class="chk">
                            </td>
                            <td rowspan="2" class="bookCover">
                                <img src="https://image.aladin.co.kr/product/33077/71/coversum/k572937407_1.jpg">
                            </td>
                            <td class="bookTitle book">
                                내가 틀릴 수도 있습니다
                                <div> - 숲속의 현자가 전하는 마지막 인생 수업</div>
                            </td>
                            <td rowspan="2">
                                <select>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                </select>
                            </td>
                            <td rowspan="2">
                                <input type="button" class="reser" value="예약"><br>
                                <input type="button" class="del" value="삭제">
                            </td>
                        </tr>
                        <tr class="cart">
                            <td class="wirter book">비욘 나티코 린데블라드 (지은이)</td>
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
    <!-- wrap -->
    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/user_base/footer.jsp" %>

</body>
</html>