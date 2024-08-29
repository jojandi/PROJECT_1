<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link href="./assets/css/mes_human.css" rel="stylesheet">

    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    <style>


        /* -------------------------------관리자 직원관리------------------------------ */
        #menu #items #i4{
            font-weight: 901;
            text-decoration: underline;
        }
        
        #i_1{
        background-color: rgb(165, 224, 144);

        }   
       
        /* ------------------------------------------------------------------ */
        
    </style>
    


</head>

<body>

    <!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->

    <!-- 여기 사이에 이것 저것 코딩하세용 >< 
    <div id="left_menu">
        <div class="l_menu" id="l_menu_1" style="font-size: 20px;"><h2>베스트 도서</h2></div>
        <div class="l_menu" id="l_menu_1" style="font-size: 20px;"><strong>남/녀별 베스트도서</strong></div>
    <div class="l_menu" id="l_menu_1" style="font-size: 20px;">연령별 베스트도서</div>
    </div> 인기도서 관리창 코딩시작 >< 
    
-->

    <div id="wrap">
        <!-- 사이드 -->
        <%@ include file="/WEB-INF/mes/mes_human/human_side.jsp" %>
        
        <section>
            
           <div class="main_page" id="main_page_1">
                <h3>직원관리</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="11%">
                                <col width="10%">
                                <col width="15%">
                                <col width="20%">
                                <col width="15%">
                                <col width="25%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">이름</th>
                                    <th>직급</th>
                                    <th>부서</th>
                                    <th>전화번호</th>
                                    <th>주소</th>
                                    <th>입사일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <!-- 여기 데이터 채우세요 -->
                            </tbody>
                        </table>
                    </div>
                    <div class="text_right">
                  		<input id="openForm" type="button" value="직원추가">
             		</div>
                    <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="사원 검색...">
                        </div>
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>
             
<div id="formModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <form id="workForm">
                        <table>
                            <tr>
                                <th colspan="2">사원 추가</th>
                            </tr>
                            <tr>
                                <td>이름</td>
                                <td><input id="emp_name" type="text"></td>
                            </tr>
                            <tr>
                                <td>직급</td>
                                <td><input id="po_name" type="text"></td>
                            </tr>
                            <tr>
                                <td>부서</td>
                                <td><input id="dept_name" type="text"></td>
                            </tr>
                            <tr>
                                <td>전화번호</td>
                                <td><input id="emp_hp" type="text"></td>
                            </tr>
                            <tr>
                                <td>주소</td>
                                <td><input id="emp_adress" type="text"></td>
                            </tr>
                            <tr>
                                <td>입사일</td>
                                <td><input id="emp_hiredate" type="text"></td>
                            </tr>
                        </table>
                        <input id="workFormBtn" type="submit" value="완료">
                    </form>
                </div>
            </div>
        </section>
    </div>
    <!--자바 스크립트 영역-->
    



    <!-- 가장 아래 고정 -->
   <script src="./assets/js/mes_human.js"></script>
</body>

</html>