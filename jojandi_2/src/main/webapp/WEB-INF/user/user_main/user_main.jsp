<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 메인페이지</title>
<link href="../assets/css/main/main_user.css" rel="stylesheet">
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/user_base/header.jsp" %>
	<!-- 메인페이지 -->

    <!-- google fonts 가져오기 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <div id="wrap">

        <section class="section1">

            <div id="hukwan">
            
                <div id="librarys">
                    
                    <div class="library" id="joong">중앙</div>
                    <div class="library" id="ssang">쌍용</div>
                    <div class="library" id="du">두정</div>
                    <div class="library" id="sin">신방</div>
                    <div class="library" id="cheong">청수</div>
                    
                </div>
                
                <div id="calendar">
                    <div class="calHeader">
                        <h2 id="YearMonth">
                            <!-- YYYY년 M월 -->
                        </h2>
                    </div>

                    <div id="days">
                        <div>일</div>
                        <div>월</div>
                        <div>화</div>
                        <div>수</div>
                        <div>목</div>
                        <div>금</div>
                        <div>토</div>
                    </div>

                    <div id="dates">
                        <!-- 날짜들 들어오는 곳 -->
                    </div>
                </div>
                <script src="../assets/js/main/calendar.js"></script>

            </div>

        </section>

        <section class="section1">

            <div id="search">
                <h2 id="searchText">자료 검색</h2><br>
                <input type="text" id="searchIn" placeholder=" 검색어를 입력해주세요. ">
                <!-- <input type="button" id="searchBnt" value="⌕"> -->
                <div id="searchBnt">⌕</div>
            </div>

            <div id="pageall">

                <div class="pages">

                    <div>
                        <div class="page" id="p1">
                            <span class="material-symbols-outlined">home</span>
                            <a href="./도서관 정보(중앙).html"></a>
                        </div>
                        <div class="pname">도서관소개</div>
                    </div>
                    <div>
                        <div class="page" id="p2">
                            <span class="material-symbols-outlined">kid_star</span>
                            <a href="./best_we_all.html"></a>
                        </div>
                        <div class="pname">베스트도서</div>
                    </div>
                    <div>
                        <div class="page" id="p3">
                            <span class="material-symbols-outlined">sync_saved_locally</span>
                            <a href="./bookflix_no.html"></a>
                        </div>
                        <div class="pname">북플릭스</div>
                    </div>
                    <div>
                        <div class="page" id="p4">
                            <span class="material-symbols-outlined">assignment_add</span>
                            <a href="./로그인css.html"></a>
                        </div>
                        <div class="pname">도서 신청</div>
                    </div>
                    
                </div>

                <div class="pages">

                    <div>
                        <div class="page" id="p5">
                            <span class="material-symbols-outlined">shopping_cart</span>
                            <a href="./로그인css.html"></a>
                        </div>
                        <div class="pname">장바구니</div>
                    </div>
                    <div>
                        <div class="page" id="p6">
                            <span class="material-symbols-outlined">person_edit</span>
                            <a href="./로그인css.html"></a>
                        </div>
                        <div class="pname">내 이용정보</div>
                    </div>
                    <div>
                        <div class="page" id="p7">
                            <span class="material-symbols-outlined">sd_card_alert</span>
                            <a href="./로그인css.html"></a>
                        </div>
                        <div class="pname">불량도서 신고</div>
                    </div>
                    <div>
                        <div class="page" id="p8">
                            <span class="material-symbols-outlined">full_coverage</span>
                            <a href="./공지사항_사용자.html"></a>
                        </div>
                        <div class="pname">정보광장</div>
                    </div>
                    
                </div>

                <script src="../assets/js/main/box.js"></script>
                <script src="./01.search.js"></script>
                <script src="./01.isLogin.js"></script>
            </div>
        </section>


        <section class="section2">
            
            <div id="noticewrap">          
                <div id="noticetitle">
                    <sapn>공지사항</sapn>
                    <a href="./공지사항_사용자.html">
                        <span class="material-symbols-outlined">add</span>
                    </a>
                </div>

                <div id="notices">

                    <ul>
                        <li class="notice" id="n1">
                            <div class="nbox joong">중앙</div>
                            <div class="noticeTD">
                                <div class="title">중앙도서관 재개관 안내</div>
                                <div class="update">2024-07-24</div>
                            </div>
                        </li>

                        <li class="notice" id="n2">
                            <div class="nbox joong">중앙</div>
                            <div class="noticeTD">
                                <div class="title">중앙도서관 열람실 공사 안내 ( 07/23 ~ 08/03 )</div>
                                <div class="update">2024-06-23</div>
                            </div>
                        </li>

                        <li class="notice" id="n3">
                            <div class="nbox all">공통</div>
                            <div class="noticeTD">
                                <div class="title">2024 전국 청소년 영어 스피치 콘테스트 안내</div>
                                <div class="update">2024-06-22</div>
                            </div>
                        </li>

                    </ul>

                </div>
            </div>

        </section>

        <section class="section3">
            <div id="booksub">
                <img src="../assets/img/bookflix.png">
                <div id="booksubInfoTitle">
                    취향 맞춤 도서 추천 서비스!
                </div>
                <div id="booksubInfo">
                    매달 2권씩 당신의 취향에 맞는 책을 <br>추천해드립니다.
                </div>
                <a href="./bookflix_no.html">
                    <input type="button" id="booksubBnt" value="더 알아보기">
                </a>
            </div>
            
        </section>


    <!-- wrap -->
    </div> 
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/user_base/footer.jsp" %>
</body>
</html>