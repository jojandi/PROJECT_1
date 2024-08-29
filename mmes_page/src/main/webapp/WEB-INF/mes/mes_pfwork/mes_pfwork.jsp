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
    <link href="./assets/css/mes_pfwork.css" rel="stylesheet">
</head>

<body>

    <!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->


    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
    	<!-- 사이드바 -->
        <%@ include file="/WEB-INF/mes/mes_pfwork/mes_pfwork_side.jsp" %>
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
                        <table id="main_library1">
                            <colgroup>
<!--                                 <col width="5%"> -->
<!--                                 <col width="20%"> -->
<!--                                 <col width="10%"> -->
<!--                                 <col width="8%"> -->
<!--                                 <col width="10%"> -->
<!--                                 <col width="10%"> -->
<!--                                 <col width="5%"> -->
<!--                                 <col width="7%"> -->
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">주문번호</th>
                                    <th>제품명</th>
                                    <th>회원ID</th>
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
                                    <td>액션추천서</td>
                                    <td>ksh6287</td>
                                    <td>24.08.25</td>
                                    <td>1</td>
                                    <td>박규태</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></tdetaild>
                                    <td class="sortable">A24082621</td>
                                    <td>로맨스추천서</td>
                                    <td>tae880</td>
                                    <td>24.08.26</td>
                                    <td>1</td>
                                    <td>조민정</td>
                                    <td>-</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox" class="p1_main_chack"></td>
                                    <td class="sortable">A24082611</td>
                                    <td>에세이추천서</td>
                                    <td>seob283</td>
                                    <td>24.08.26</td>
                                    <td>1</td>
                                    <td>이제섭</td>
                                    <td>-</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <br>
                    <div id="pfworkpush">
                    	<input type="button" id="addpf" value="주문추가">
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
                                    <th>제품코드</th>
                                    <th>수량</th>
                                    <th>판매단가</th>
                                    <th>상태</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082511</td>
                                    <td>2024.08.28</td>
                                    <td>쌍용도서관</td>
                                    <td>book-20, <br> book-30 <br> ...</td>
                                    <td>10EA</td>
                                    <td>400,000</td>
                                    <td>완료</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082621</td>
                                    <td>2024.09.10</td>
                                    <td>중앙도서관</td>
                                    <td>book-30, <br> book-kid <br> ...</td>
                                    <td>25EA</td>
                                    <td>600,000</td>
                                    <td>진행중</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>A24082611</td>
                                    <td>2024.09.11</td>
                                    <td>두정도서관</td>
                                    <td>book-yth, <br> book-50 <br> ...</td>
                                    <td>15EA</td>
                                    <td>500,000</td>
                                    <td>진행중</td>
                                </tr>
                            </tbody>
                        </table>
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
                <h2>&lt;주문추가&gt;</h2>
                <div class="modal-div_">
                    <span class="red">*</span> 필수
                </div>
	            <div id="table">
                	<form>
	                    <table>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">주문번호</span> 
	                            </td>
	                            <td>
	                                <input type="text" name="os_id">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">제품명</span> 
	                            </td>
	                            <td>
	                                <input type="text" name="os_name">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">회원ID</span> 
	                            </td>
	                            <td>
									<input type="text" name="user_id">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">주문날짜</span> 
	                            </td>
	                            <td>
									<input type="date" name="os_date">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td>
	                                <span class="red">*</span>
	                                <span class="modal-item">수량</span> 
	                            </td>
	                            <td>
									<input type="text" name="os_count">
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td class="modal-item">담당자</td> 
	                            <td>
	                                <select name="emp_id">
										<option value="Eid1">조민정</option>
										<option value="Eid2">박규태</option>
										<option value="Eid3">이제섭</option>
										<option value="Eid4">김아영</option>
										<option value="Eid5">김승환</option>
									</select>
	                            </td>
	                        </tr>
	                        <tr class="modal-div_2">
	                            <td class="modal-item">비고</td> 
	                            <td>
	                                <input type="text" name="os_m" value="-">
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
                <h2>&lt;상세내역&gt;</h2>
                <div class="modal-div_">
                </div>
                <div id="table">
                    <table>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">주문번호</span> 
                            </td>
                            <td>
                                <span>A24082511</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">출고일자</span> 
                            </td>
                            <td>
                                <span>2024.08.28</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td>
                                <span class="modal-item">거래처명</span> 
                            </td>
                            <td>
                                <span>쌍용도서관</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td class="modal-item">제품코드</td>
                            <td>
                                <span>
                                	book-20<br>
                                	book-30<br>
                                	book-yth
                                </span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td class="modal-item">수량</td>
                            <td>
                            	<span>10EA</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td class="modal-item">판매단가</td> 
                            <td>
                                <span>400,000</span>
                            </td>
                        </tr>
                        <tr class="modal-div_4">
                            <td class="modal-item">상태</td> 
                            <td>
                                <span>완료</span>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->
    
    
    <script src="./assets/js/mes_pfwork.js"></script>
    <!-- 가장 아래 고정 -->
    
</body>

</html>