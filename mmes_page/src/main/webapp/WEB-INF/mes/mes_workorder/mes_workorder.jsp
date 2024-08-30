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
    <link href="./assets/css/mes_workorder.css" rel="stylesheet">
    <link href="./assets/css/click.css" rel="stylesheet">
        
</head>

<body>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

    <!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->

    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
        <%@ include file="/WEB-INF/mes/mes_workorder/workorder_side.jsp" %>
        <section>
        <!-- ---------------------- 작업지시서 페이지 ---------------------------- -->
            <div class="main_page" id="main_page_1">
                <h3>작업지시서</h3>
                <div>
                    <div class="page_2">
                    	<div class="search-container">
                            <input type="text" id="searchInput" placeholder="지시번호 검색">
                        </div>
                        <table id="main_library1">
                            <colgroup>
                                <col width="5%">
                                <col width="15%">
                                <col width="10%">
                                <!-- <col width="8%"> -->
                                <!-- <col width="10%">
                                <col width="10%"> -->
                                <!-- <col width="5%"> -->
                                <!-- <col width="7%"> -->
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">지시번호</th>
                                    <th>제품코드</th>
                                    <th>제품명</th>
                                    <th>공정</th>
                                    <th>시작일</th>
                                    <th>종료일</th>
                                    <th>수량</th>
                                    <th>상태</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td class="sortable">B990915B20</td>
                                    <td>book-20</td>
                                    <td>20대필독목록</td>
                                    <td>A공정</td>
                                    <td>24.08.25</td>
                                    <td>24.09.10</td>
                                    <td>10EA</td>
                                    <td>진행중</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></td>
                                    <td class="sortable">B990915B30</td>
                                    <td>book-30</td>
                                    <td>30대필독목록</td>
                                    <td>A공정</td>
                                    <td>24.08.26</td>
                                    <td>24.09.11</td>
                                    <td>25EA</td>
                                    <td>진행중</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></td>
                                    <td class="sortable">B990915Byth</td>
                                    <td>book-yth</td>
                                    <td>청소년필독서</td>
                                    <td>B공정</td>
                                    <td>24.08.26</td>
                                    <td>24.09.11</td>
                                    <td>20EA</td>
                                    <td>대기</td>
                                </tr>
                            </tbody>
                        </table>
                        
                    </div>
                    
                    <div class="bot_btn">
                        <input type="button" id="addbtn" value="작업지시서 생성">
                    </div>
                </div>
            </div>

	<!-- -------------------------------- BOM페이지 ------------------------------- -->
            <div class="main_page" id="main_page_2">
                <h3>BOM</h3>
                <div>
                    <div id="bomsh">
                        <input type="text" placeholder="통합검색">
                    </div>
                    <div class="page_2">
                        <table id="main_library">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">부품코드</th>
                                    <th>부품명</th>
                                    <th>소요량</th>
                                    <th>가용재고</th>
                                    <th>적정재고</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>book-20</td>
                                    <td>20대필독서</td>
                                    <td>4</td>
                                    <td>15</td>
                                    <td>30</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>book-30</td>
                                    <td>30대필독서</td>
                                    <td>5</td>
                                    <td>5</td>
                                    <td>20</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>book-yth</td>
                                    <td>청소년추천서</td>
                                    <td>4</td>
                                    <td>10</td>
                                    <td>20</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
                        <a href="bom"><input type="button" id="addbom" value="BOM 생성"></a>
                    </div>
                </div>
            </div>

        </section>
    </div>

    <!-- //////////////////////////// 첫번째 모달 ////////////////////////////////////// -->
    <div id="modal_2" class="modal_2">
        <div class="close_2">
            <span class="material-symbols-outlined">
                close
            </span>
        </div>
        <div class="modal-content_2">
            <div id="daylist_2"></div>
            <div id="modal-content-divs_2">
                <h2>&lt;작업 지시서 생성&gt;</h2>
                <div class="modal-div_">
                    <span class="red">*</span> 필수
                </div>
	            <div id="table">
                	<form>
	                    <table>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">지시번호</span> 
	                            </td>
	                            <td>
	                                <input type="text" name="order_id">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">제품코드</span> 
	                            </td>
	                            <td>
	                                <input type="text" name="bom_code">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">공정</span> 
	                            </td>
	                            <td>
	                                <select name="order_process">
										<option value="pro1">A공정</option>
										<option value="pro2">B공정</option>
										<option value="pro3">C공정</option>
									</select>
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td class="modal-item">예정시작 날짜 </td>
	                            <td>
	                                <input type="date" name="order_Sdate"> 
	                            </td>
	                        </tr>
	                        <tr>
	                            <td class="modal-item">예정종료 날짜</td>
	                            <td>
	                                <input type="date" name="order_Edate"> 
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td class="modal-item">수량</td> 
	                            <td>
	                                <input type="text" name="order_count">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td class="modal-item">상태</td> 
	                            <td>
	                                <input type="text" name="order_status">
	                            </td>
	                        </tr>
	                    </table>
                    </form>
                </div>
                <div class="modal-div_3" style="text-align: right;">
                    <input class="inpa" type="submit" value="생성"> 
                </div>
            </div>
        </div>
    </div>
    <!-- //////////////////////////// 첫번째 모달 ////////////////////////////////////// -->

    <!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->
    <div id="modal_4" class="modal_4">
        <div class="close_4">
            <span class="material-symbols-outlined">
                close
            </span>
        </div>
        <div class="modal-content_4">
            <div id="daylist_4"></div>
            <div id="modal-content-divs_4">
                <div class="modal-div_">
                	<h2 id="bom_head">20대필독서</h2>
                </div>
                <div id="table">
                    <table>
                        <tr class="modal-div_4">
                            <th>
                                <span class="modal-item">상위부품코드</span> 
                            </th>
                            <th>
                                <span>상위부품명</span>
                            </th>
                            <th>
                                <span>부품코드</span>
                            </th>
                            <th>
                                <span>부품명</span>
                            </th>
                            <th>
                                <span>수량</span>
                            </th>
                            <th>
                                <span>사용여부</span>
                            </th>
                            <th>
                                <span>비고</span>
                            </th>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">book-20</span> 
                            </td>
                            <td>
                                <span>20대필독서</span>
                            </td>
                            <td>
                                <span>20101</span>
                            </td>
                            <td>
                                <span>너의췌장을 먹고 싶어</span>
                            </td>
                            <td>
                                <span>1</span>
                            </td>
                            <td>
                                <span>Y</span>
                            </td>
                            <td>
                                <span>-</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">book-20</span> 
                            </td>
                            <td>
                                <span>20대필독서</span>
                            </td>
                            <td>
                                <span>20102</span>
                            </td>
                            <td>
                                <span>죽여 마땅한 사람들</span>
                            </td>
                            <td>
                                <span>1</span>
                            </td>
                            <td>
                                <span>Y</span>
                            </td>
                            <td>
                                <span>-</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">book-20</span> 
                            </td>
                            <td>
                                <span>20대필독서</span>
                            </td>
                            <td>
                                <span>20103</span>
                            </td>
                            <td>
                                <span>죽고싶지만 떡볶이는 먹고싶어</span>
                            </td>
                            <td>
                                <span>1</span>
                            </td>
                            <td>
                                <span>Y</span>
                            </td>
                            <td>
                                <span>-</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">book-20</span> 
                            </td>
                            <td>
                                <span>20대필독서</span>
                            </td>
                            <td>
                                <span>20104</span>
                            </td>
                            <td>
                                <span>응가</span>
                            </td>
                            <td>
                                <span>1</span>
                            </td>
                            <td>
                                <span>Y</span>
                            </td>
                            <td>
                                <span>-</span>
                            </td>
                        </tr>
                        
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->
    
    
    <script src="./assets/js/mes_workorder.js"></script>

    <!-- 가장 아래 고정 -->
     
    
    
</body>

</html>