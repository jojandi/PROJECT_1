<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이페이지</title>
<link href="../assets/css/my/user_mypage_bookadd.css" rel="stylesheet">
</head>
<body>

	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">
        <!-- 사이드 -->
       	<%@ include file="/WEB-INF/user/my/user_mypage_side.jsp" %>

        <section id="min">

            <div id="stitle">
                <h3>조잔디님의 도서 신청 내역</h3>
            </div>

            <div id="t1" class="table">
                <table>
                    <thead> 
                        <tr>
                            <td id="bnameall">도서명</td>
                            <td>신청 도서관</td>
                            <td>신청일</td>
                            <td>신청현황</td>
                            <td>
                            </td>
                        </tr>
                    </thead>

                    <tbody>
                        <tr class="parent">
                            <td class="bname">마녀와의 7일</td>
                            <td>두정도서관</td>
                            <td>24.07.01</td>
                            <td>구비완료</td>
                            <td>
                                <input type="button" class="minbnt end" id="b1" value="신청취하">
                            </td>
                        </tr>
                        <tr class="parent">
                            <td class="bname">파도의 아이들</td>
                            <td>청수도서관</td>
                            <td>24.07.15</td>
                            <td>신청완료</td>
                            <td>
                                <input type="button" class="minbnt end" id="b2" value="신청취하">
                            </td>
                        </tr>
                        <tr class="parent">
                            <td class="bname">사랑받는 이기주의자</td>
                            <td>중앙도서관</td>
                            <td>24.07.19</td>
                            <td>진행 중</td>
                            <td>
                                <input type="button" class="minbnt ing" id="b3" value="신청취하">
                            </td>
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

		<script src="../assets/js/my/mypage_bookadd.js"></script>
    <!-- wrap -->
    </div>
	
	<!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>

</body>
</html>