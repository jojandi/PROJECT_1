<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이페이지</title>
<link href="../assets/css/my/user_mypage_info.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">
        <!-- 사이드 -->
       	<%@ include file="/WEB-INF/user/my/user_mypage_side.jsp" %>

        <section id="info">

            <div id="stitle">
                <h3>조잔디님의 정보</h3>
            </div>
            
            <!-- 기본정보 -->
            <div id="information">  
                <div id="miniInfo"> 
                    <div id="profile"></div>
                    <div id="nickname">조잔디</div>
                    <div id="email">cutecat@naver.com</div>
                    <div id="num">회원번호 : 202121313</div>
                    <div id="out">
                    	<form method="post" action="user_del">
		                    <span id="logout">로그아웃</span>
		                    <input type="heddin" name="code" value="${dto.user_seq}">
                    		<input type="submit" value="회원탈퇴" id="realout">
                    	</form>
                    </div>
                </div>

                <div id="booksub">
                    <div id="booklogo">
                        <img src="../assets/img/bookflix.png">
                    </div>

                    <div id="bookuser">
                        <div id="bookall">
                            <span>조잔디님의 이달의 추천 책</span>
    
                            <div id="books">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="https://contents.kyobobook.co.kr/sih/fit-in/200x0/pdt/9791156756552.jpg">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="booktitle">죽여 마땅한 사람들</td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <img src="https://contents.kyobobook.co.kr/sih/fit-in/200x0/pdt/9788950995454.jpg">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="booktitle">곰탕 1:미래에서 온 살인자</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
    
                        <div id="bookout">
                            탈퇴하기
                        </div>
                    </div>
                   
                </div>

                <!-- 정보수정 -->
                <div id="infoedit">
                    <h3 id="infoeditTite">내 정보 수정</h3>

                    <div id="info1">
                        <input type="password" id="pwIn" placeholder="비밀번호를 입력해주세요."><br>
                        <input type="submit" id="pwBnt" value="확인">
                        <div id="pwerror">비밀번호를 확인해주세요</div>
                    </div>

                    <div id="info2">
                    <form method="post" action="update">
                        <table>
                            <tr>
                                <td class="center">이름</td>
                                <td>
                                    <span id="in1">
                                        조잔디
                                    </span>
                                    <input type="text" id=nick name="name" value="조잔디">
                                    <input type="button" class="right" id="nickBtn" value="변경">
                                </td>
                            </tr>
                            <tr>
                                <td class="center">아이디</td>
                                <td>
                                    user
                                </td>
                            </tr>
                            <tr>
                                <td class="center">비밀번호</td>
                                <td id="pwedit">
                                    <span id="in2">
                                        <input type="password" id="pweditIn" value="1234">
                                    </span>
                                    <input type="button" class="right" id="pweditBtn" value="변경">
                                </td>
                            </tr>
                            <tr>
                                <td class="center">전화번호</td>
                                <td>
                                    <span id="in3">010-0000-0000</span>
                                    <input type="text" id=number value="010-0000-0000">
                                    <input type="button" class="right" id="numBnt" value="변경">
                                </td>
                            </tr>
                        </table>
                        <div id=update>
	                        <input type="submit" value="변경하기">
                        </div>
                    </form>

                    </div>

                </div>

            </div>

        </section>

        <script src="../assets/js/my/mypage_info.js"></script>
    <!-- wrap -->
    </div>
    
    	<!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
</body>
</html>