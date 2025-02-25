<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재고 관리</title>
    <link href="./assets/css/admin_table.css" rel="stylesheet">
    <link href="./assets/css/00.user_base_login.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link href="./assets/css/click.css" rel="stylesheet">
    <style>
        .page {
            /* border: 1px solid red; */
            width: 100%;
            height: 100%;
            margin: auto;
            margin-top: 10px;
            overflow: scroll;
        }
        .page_1 {
            /* border: 1px solid red; */
            width: 100%;
            height: 250px;
            margin: auto;
            margin-top: 10px;
            overflow: scroll;
        }
        .page_2 {
            /* border: 1px solid red; */
            width: 100%;
            height: 500px;
            overflow: scroll; height: 500px;
            margin: auto;
            margin-top: 10px;
        }

        .table_wrap {
            /* border: 1px solid red; */
            /* width: 80%; */
            height: 100%;
            /* overflow: scroll; */
        }

        .bot_btn {
            text-align: right;
            margin-right: 10px;
        }

        #main_library {
            margin-bottom: 10px;
        }

        th.sortable {
            cursor: pointer;
        }

        th.sorted-asc::after {
            content: " ▲";
        }

        th.sorted-desc::after {
            content: " ▼";
        }

        .main_page {
            width: 100%;
        }
        .input_style {
            width: 30px;
            text-align: center;
        }

        #menu #items #i3{
            font-weight: 900;
            text-decoration: underline;
        } 
        .modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 500px;
            top: 100px;
            width: 400px;
            height: 80%;
            overflow: auto;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        #workForm {
            text-align: center;
        }
        
    </style>
    <script src="./assets/js/admin_stock.js"></script>
</head>

<body>

    <!-- 가장 위 고정 -->
    <header id="top" class="clearfix">

        <div id="logoall">
            <div id="logo" class="left"><a href="mes_mainPage.html"><img class="logo_img" src="https://cdn.discordapp.com/attachments/1263360143756759099/1267275014273634415/KakaoTalk_20240729_090859720-removebg-preview_3.png?ex=66a83154&is=66a6dfd4&hm=4f6d706e06b34db529815a64763136b9f3f073d06fbc4513dd57c737077310f0&"></a></div>
            <!-- <div id="name" class="left">행복만땅 <br>도서관</div> -->
        </div>

        <div id="menu">
            <div id="items" class="left">
                <div class="item" id="i1"><a href="mes_pfwork.html">작업 수행</a></div>
                <div class="item" id="i2"><a href="admin_library.html">생산 관리</a></div>
                <div class="item" id="i3"><a href="/Park_2/stock">재고 관리</a></div>
                <div class="item" id="i4"><a href="mes_human.html">직원 관리</a></div>
                <div class="item" id="i5"><a href="mes_statistics_1.html">통계 및 분석</a></div>
                <div class="item" id="i6"><a href="/Park_2/notice">게시판</a></div>
            </div>
            <div class="right" id="userall">
                <div>OOO관리자</div>
                <div><a href="../사용자용 페이지/01.main_user.html">로그아웃</a></div>
                <!-- <div class="inb" id="login">로그인</div>
                <div class="inb">|</div>
                <div class="inb" id="userin">회원가입</div>
                <div class="inb" id="menus"></div> -->
            </div>
        </div>
    </header>


    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">재고 관리</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span>재고 현황</span>
                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    </div>
                    <div class="item" id="i2">
                        <span>보유 도서 목록</span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                    <div class="item" id="i3">
                        <span>도서 발주</span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                </div>
            </div>
        </aside>
        <section>
            <div class="main_page" id="main_page_1">
                <h3>재고 현황</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="3%">
                                <col width="10%">
                                <col width="20%">
                                <col width="8%">
                                <col width="7%">
                                <col width="10%">
                                <col width="7%">
                                <col width="7%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">제품 코드</th>
                                    <th>제품명</th>
                                    <th>구성 도서 수</th>
                                    <th>재고 수량</th>
                                    <th>출고 예정 수량</th>
                                    <th>보관 위치</th>
                                    <th>비고</th>
                                </tr>
                            </thead>
                            <tbody>
                            <!-- 여기 데이터 채우세요 -->
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="도서명 검색...">
                        </div>
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>

            <div class="main_page" id="main_page_2">
                <h3>보유 도서 목록</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">도서명</th>
                                    <th>도서 코드</th>
                                    <th>도서명</th>
                                    <th>저자</th>
                                    <th>출판사</th>
                                    <th>수량</th>
                                    <th>보관 위치</th>
                                </tr>
                            </thead>
                            <!-- 여기에 데이터 -->
                        </table>
                    </div>
                    <div class="bot_btn">
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>

            <div class="main_page" id="main_page_3">
                <h3>도서 발주</h3>
                <div>
                    <div class="table_wrap">
                        <div class="page_2">
                            <table id="main_library_1">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" id="p1_checkAll"></th>
                                        <th class="sortable">도서명</th>
                                        <th>도서 코드</th>
                                    	<th>도서명</th>
                                    	<th>저자</th>
                                    	<th>출판사</th>
                                    	<th>수량</th>
                                    	<th>발주일</th>
                                    </tr>
                                </thead>
                                <tbody class="main_tbody">

                                </tbody>
                            </table>

                        </div>
                        <div class="text_right">
                            <input id="openForm" type="button" value="발주">
                        </div>
                        <!-- <div class="page_1">
                            <h3>도서 구매 내역</h3>
                            <table id="main_library_2">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" id="p2_checkAll"></th>
                                        <th class="sortable">도서명</th>
                                        <th>저자명</th>
                                        <th>출판사</th>
                                        <th>출판연도</th>
                                        <th>도서코드</th>
                                        <th>발주 권수</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>

                        </div> -->
                        <div class="bot_btn">
                            <input type="button" value="Excel 파일화">
                        </div>
                    </div>

                </div>
            </div>
            <div id="formModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <form id="workForm">
                        <table>
                            <tr>
                                <th colspan="2">도서 발주</th>
                            </tr>
                            <tr>
                                <td>도서명</td>
                                <td><input id="book_title" type="text"></td>
                            </tr>
                            <tr>
                                <td>저자명</td>
                                <td><input id="author_name" type="text"></td>
                            </tr>
                            <tr>
                                <td>출판사</td>
                                <td><input id="publisher" type="text"></td>
                            </tr>
                            <tr>
                                <td>요청 도서관</td>
                                <td><input id="requesting_library" type="text"></td>
                            </tr>
                            <tr>
                                <td>출판연도</td>
                                <td><input id="publication_year" type="text"></td>
                            </tr>
                            <tr>
                                <td>도서코드</td>
                                <td><input id="book_code" type="text"></td>
                            </tr>
                            <tr>
                                <td>발주 권수</td>
                                <td><input id="order_quantity" type="text"></td>
                            </tr>
                        </table>
                        <input id="workFormBtn" type="submit" value="완료">
                    </form>
                </div>
            </div>
        </section>
    </div>


    <!-- 가장 아래 고정 -->
    <footer>
        <div id="bottom" class="clearfix">

            <div id="logoall">
                <div id="logo" class="left"></div>
                <div id="name" class="left">행복만땅 <br>도서관</div>
            </div>

            <div id="footerinfo">
                Tel : 중앙도서관 : 041-521-3721 신방도서관 : 041-521-3724
                청수도서관 : 041-521-3725 쌍용도서관 : 041-521-3731 두정도서관 : 041-521-3733
            </div>

        </div>
    </footer>
</body>
<script src="./assets/js/mes_stock.js"></script>
</html>