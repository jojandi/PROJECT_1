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
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">직원관리</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span><a href="mes_human.html">직원관리</a></span>
                        <span class="material-symbols-outlined" id="i_1">arrow_forward_ios</span>
                    </div>
                   
                </div>
            </div>
        </aside>
        <section>
            
            <div class="button-container" style="margin-top: 30px;">
                <button id="addEmployeeBtn">직원 추가</button>
                <button id="deleteEmployeeBtn">직원 삭제</button>
                <button id="saveBtn">저장</button>
            </div>

            <div class="employee-table">
                <div class="row header">
                    <input id="selectAllCheckbox" class="check-cell" type="checkbox">
                    <!--  헤더쪽에 있는 체크박스를 누르면 전체 취소 및 전체 체크를 하기 위한 id를 따로 줌 -->
                    <div class="cell">이름</div>
                    <div class="cell">직급</div>
                    <div class="cell">부서</div>
                    <div class="cell">전화번호</div>
                    <div class="cell">주소</div>
                    <div class="cell">입사일</div>
                </div>
                <div class="row">
                    <input class="check-cell" type="checkbox">
                    <div class="cell">이제섭</div>
                    <div class="cell">대리</div>
                    <div class="cell">포장팀</div>
                    <div class="cell">010-1234-5678</div>
                    <div class="cell">서울특별시 송파구</div>
                    <div class="cell">2020-01-15</div>
                </div>
                <div class="row">
                    <input class="check-cell" type="checkbox">
                    <div class="cell">박규태</div>
                    <div class="cell">대리</div>
                    <div class="cell">도서관리팀</div>
                    <div class="cell">010-9876-5432</div>
                    <div class="cell">경기도 분당구</div>
                    <div class="cell">2019-05-20</div>
                </div>
                <div class="row">
                    <input class="check-cell" type="checkbox">
                    <div class="cell">김승환</div>
                    <div class="cell">부장</div>
                    <div class="cell">영업팀</div>
                    <div class="cell">010-1111-2222</div>
                    <div class="cell">천안시 동남구</div>
                    <div class="cell">2021-03-10</div>
                </div>
                <div class="row">
                    <input class="check-cell" type="checkbox">
                    <div class="cell">김아영</div>
                    <div class="cell">부장</div>
                    <div class="cell">도서관리팀</div>
                    <div class="cell">010-5143-5125</div>
                    <div class="cell">세종시 전의</div>
                    <div class="cell">2022-07-01</div>
                </div>
                <div class="row">
                    <input class="check-cell" type="checkbox">
                    <div class="cell">조민정</div>
                    <div class="cell">사장</div>
                    <div class="cell"></div>
                    <div class="cell">010-5143-5125</div>
                    <div class="cell">세종시 전의</div>
                    <div class="cell">2022-07-01</div>
                </div>

            </div>

            <div id="employeeModal" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <div class="modal-header">
                        <h2>직원 정보 수정</h2>
                    </div>
                    <div class="modal-body">
                        <div class="row">
                            <span class="label">이름:</span>
                            <input type="text" id="modalNameInput">
                        </div>
                        <div class="row">
                            <span class="label">직급:</span>
                            <select id="modalPositionInput">
                                <option value="" selected disabled hidden>선택해주세요</option>
                                <option value="매니저">매니저</option>
                                <option value="개발자">개발자</option>
                                <option value="영업담당자">영업담당자</option>
                                <option value="디자이너">디자이너</option>
                            </select>
                        </div>
                        <div class="row">
                            <span class="label">부서:</span>
                            <select id="modalDepartmentInput">
                                <option value="" selected disabled hidden>선택해주세요</option>
                                <option value="기획팀">기획팀</option>
                                <option value="엔지니어링팀">엔지니어링팀</option>
                                <option value="영업팀">영업팀</option>
                                <option value="디자인팀">디자인팀</option>
                            </select>
                        </div>
                        <div class="row">
                            <span class="label">전화번호:</span>
                            <input type="text" id="modalPhoneNumberInput">
                        </div>
                        <div class="row">
                            <span class="label">주소:</span>
                            <input type="text" id="modalAddressInput">
                        </div>
                        <div class="row">
                            <span class="label">입사일:</span>
                            <input type="date" id="modalStartDateInput">
                        </div>
                    </div>
                    <button id="updateEmployeeBtn">저장</button>
                </div>
            </div>

            <div class="button-container">
                <input type="text" id="searchInput" placeholder="직원 검색">
                <button id="searchEmployeeBtn">검색</button>
            </div>
        </section>
    </div>
    <!--자바 스크립트 영역-->
    <script src="./assets/js/mes_human.js"></script>



    <!-- 가장 아래 고정 -->
   
</body>

</html>