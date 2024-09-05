<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
    pageEncoding="UTF-8"
    import="java.util.*"%>
=======
<<<<<<< HEAD
    pageEncoding="UTF-8"
    import="java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
    pageEncoding="UTF-8"%>
>>>>>>> 02d44dde726cb13da35544e6ccc157b05a28cc52
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
>>>>>>> 96827b0ef89511291e105b5ca5ade098c9e4f900
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="mes_DTO.MesHumanDTO" %> 
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
	<link href="./assets/css/admin_table.css" rel="stylesheet">
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
/*        	table { */
/*        	font-size: 18px; */
/*        	} */
       	 .clickable {
            cursor: pointer;
            color: blue;
            text-decoration: underline;
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
<<<<<<< HEAD
        <%@ include file="/WEB-INF/mes/mes_human/buser_side.jsp" %>
        
        <section>
=======
        <%@ include file="/WEB-INF/mes/mes_human/human_side.jsp" %>
        
        <section>
            
           <div class="main_page" id="main_page_1">
                <h3>직원관리</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="7%">
                                <col width="8%">
                     			<col width="11%">
						        <col width="8%">
						        <col width="16%">
						        <col width="21%">
						        <col width="20%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">사원번호</th>
                                   	<th>이름</th>
                                    <th>직급</th>
                                    <th>부서</th>
                                    <th>전화번호</th>
                                    <th>주소</th>
                                    <th>입사일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <!-- 여기 데이터 채우세요 -->
                             <tbody>
           
				            <c:forEach var="dto" items="${list}">
				                <tr>
				                    <td><input type="checkbox" class="emp_checkbox"></td>				                    
									<td><a href = "http://localhost:8080/mmes_page/read?emp_id=${dto.emp_id}">${dto.emp_id}</a></td> 
									<td>${dto.emp_name}</td>
				                    <td>${dto.po_name}</td>
				                    <td>${dto.dept_name}</td>
				                    <td>${dto.emp_hp}</td>
				                    <td>${dto.emp_add}</td>
				                    <td>${dto.emp_hiredate}</td>
				                </tr>
				            </c:forEach>
        					</tbody>
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
                    <form id="workForm" method="post" action="human">
                        <table>
                            <tr>
                                <th colspan="2">사원 추가</th>
                            </tr>
                            <tr>
                                <td>이름</td>
                                <td><input type="text" name="emp_name"></td>
                            </tr>
                            <tr>
                                <td>직급</td>
                                <td><input type="text" name="po_name"></td>
                            </tr>
                            <tr>
                                <td>부서</td>
                                <td><input type="text"  name="dept_name"></td>
                            </tr>
                            <tr>
                                <td>전화번호</td>
                                <td><input type="text"  name="emp_hp"></td>
                            </tr>
                            <tr>
                                <td>주소</td>
                                <td><input type="text" name="emp_add"></td>
                            </tr>
                            <tr>
                                <td>입사일</td>
                                <td><input name="emp_hiredate" type="date"></td>
                            </tr>
                        </table>
                        <input id="workFormBtn" type="submit" value="등록하기">
                    </form>
                </div>
            </div>
<<<<<<< HEAD
        </section>
    </div>
    <!--자바 스크립트 영역-->
    



    <!-- 가장 아래 고정 -->
   <script src="./assets/js/mes_human.js"></script>
=======
>>>>>>> 02d44dde726cb13da35544e6ccc157b05a28cc52
            
           <div class="main_page" id="main_page_1">
                <h3>회원관리</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                            </colgroup>
                            <thead>
                                <tr>
                                    <th class="sortable">회원번호</th>
                                   	<th>회원 ID</th>
                                    <th>회원 주소</th>
                                    <th>회원 이메일</th>
                                    <th>가입일</th>
                                    <th>만료일</th>
                                </tr>
                            </thead>
                            <tbody>
                            <!-- 여기 데이터 채우세요 -->
                             <tbody>
           
				            <c:forEach var="dto" items="${list}">
				                <tr>
									<td>${dto.buser_seq}</td> 
									<td>${dto.user_id}</td>
				                    <td>${dto.user_addr}</td>
				                    <td>${dto.user_email}</td>
				                    <td>${dto.buser_date}</td>
				                    <td>${dto.buser_end}</td>
				                </tr>
				            </c:forEach>
        					</tbody>
                            </tbody>
                        </table>
<<<<<<< HEAD
                    </div>
                    <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="회원 검색...">
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!--자바 스크립트 영역-->
    



    <!-- 가장 아래 고정 -->
   <script src="./assets/js/mes_human.js"></script>
=======
        </div>
    </header>
>>>>>>> 96827b0ef89511291e105b5ca5ade098c9e4f900
>>>>>>> 02d44dde726cb13da35544e6ccc157b05a28cc52
</body>

</html>