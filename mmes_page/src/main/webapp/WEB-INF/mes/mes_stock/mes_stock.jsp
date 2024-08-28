<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>재고 관리</title>
    <link href="./assets/css/admin_table.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link href="./assets/css/click.css" rel="stylesheet">
    <link href="./assets/css/mes_stock.css" rel="stylesheet">

    <script src="./assets/js/admin_stock.js"></script>
</head>

<body>

    <!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->


    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
        <%@ include file="/WEB-INF/mes/mes_stock/stock_side.jsp" %>
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

</body>
<script src="./assets/js/mes_stock.js"></script>
</html>