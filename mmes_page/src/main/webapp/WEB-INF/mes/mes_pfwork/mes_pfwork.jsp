<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="./assets/css/admin_table.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script src="./assets/js/click.js"></script>
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

        #menu #items #i1{
            font-weight: 900;
            text-decoration: underline;
        }  
        
    </style>
    
</head>

<body>

    <!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->


    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">작업 수행</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span>주문현황</span>
                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    </div>
                    <div class="item" id="i2">
                        <span>출고현황</span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                </div>
            </div>
        </aside>
        <section>
            <div class="main_page" id="main_page_1">
                <h3>주문 현황</h3>
                <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="주문번호 검색">
                        </div>
                    </div>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="5%">
                                <col width="20%">
                                <col width="10%">
                                <col width="8%">
                                <col width="10%">
                                <col width="10%">
                                <col width="5%">
                                <col width="7%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">주문번호</th>
                                    <th>제품명</th>
                                    <th>주문업체</th>
                                    <th>주문날짜</th>
                                    <th>수량</th>
                                    <th>담당자</th>
                                    <th>비고</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td class="sortable">A24082511</td>
                                    <td>20대필독목록, 30대필독목록,<br> ...</td>
                                    <td>쌍용도서관</td>
                                    <td>24.08.25</td>
                                    <td>10EA</td>
                                    <td>박규태</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></td>
                                    <td class="sortable">A24082621</td>
                                    <td>30대필독목록, 아동필독서, <br> ...</td>
                                    <td>중앙도서관</td>
                                    <td>24.08.26</td>
                                    <td>25EA</td>
                                    <td>조민정</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></td>
                                    <td class="sortable">A24082611</td>
                                    <td>청소년필독서, 50대추천도서, <br> ...</td>
                                    <td>두정도서관</td>
                                    <td>24.08.26</td>
                                    <td>15EA</td>
                                    <td>이제섭</td>
                                    <td>-</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="main_page" id="main_page_2">
                <h3>출고 내역</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">주문번호</th>
                                    <th>출고일자</th>
                                    <th>거래처명</th>
                                    <th>품목</th>
                                    <th>제품코드</th>
                                    <th>수량</th>
                                    <th>단가</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082511</td>
                                    <td>2024.08.28</td>
                                    <td>쌍용도서관</td>
                                    <td>20대필독목록, <br> 30대필독목록, <br> ...</td>
                                    <td>book-20, <br> book-30 <br> ...</td>
                                    <td>10EA</td>
                                    <td>400,000</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082621</td>
                                    <td>2024.09.10</td>
                                    <td>중앙도서관</td>
                                    <td>30대필독목록, <br> 아동필독서, <br> ...</td>
                                    <td>book-30, <br> book-kid <br> ...</td>
                                    <td>25EA</td>
                                    <td>600,000</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082611</td>
                                    <td>2024.09.11</td>
                                    <td>두정도서관</td>
                                    <td>청소년필독서, <br> 50대추천도서, <br> ...</td>
                                    <td>book-yth, <br> book-50 <br> ...</td>
                                    <td>15EA</td>
                                    <td>500,000</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </section>
    </div>
    <script src="./assets/js/admin_stock.js"></script>
    <!-- 가장 아래 고정 -->
    
</body>

</html>