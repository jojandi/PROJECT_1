<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	<!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->
	<div id="wrap">
		<aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">생산 관리</h2>
                <div id="items">
                    <a href="workorder"><div class="item" id="i1">
                        <span>작업지시서</span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div></a>
                    <a href="bom"><div class="item" id="i2">
                        <span>BOM</span>
                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    </div></a>
                </div>
            </div>
        </aside>
		<section>
			<div class="main_page" id="main_page_1">
				<h3>BOM 생성</h3>
				<div>
					<form>
					<div class="page_2">
						<table id="main_library">
							<thead>
								<tr>
									<th><input type="checkbox" id="p1_checkAll"></th>
									<th class="sortable">제품코드</th>
									<th>도서명</th>
									<th>ISBN 코드</th>
									<th>저자</th>
									<th>출판사</th>
									<th>수량</th>
									<th>보관 위치</th>
								</tr>
							</thead>
							<!-- 여기에 데이터 -->
							<tbody>
								 <c:forEach var="dto" items="${list}">
				                <tr>
				                    <td><input type="checkbox" class="bom_checkbox"></td>				                     
									<td>${dto.mes_book_code}</td>
									<td id = "book_code">${dto.mes_book_code}</td>
									<td>${dto.book_name}</td>
				                    <td>${dto.book_isbn}</td>
				                    <td>${dto.book_author}</td>
				                    <td>${dto.book_pub}</td>
				                    <td>${dto.book_count}</td>
				                    <td>${dto.wh_code}</td>
				                </tr>
				            </c:forEach>
							</tbody>
						</table>
					</div>
					<div class="bot_btn">
						<div class="search-container">
							<input type="text" id="searchInput" placeholder="도서명 검색...">
						</div>
						<input type="button" id="addbom" value="bom생성">
					</div>
					</form>
				</div>
			</div>
		</section>
		</div>
		
		<!-- //////////////////////////// 세번째 모달 ////////////////////////////////////// -->
    <div id="modal_6" class="modal_6">
        <div class="close_6">
            <span class="material-symbols-outlined">
                close
            </span>
        </div>
        <div class="modal-content_6">
            <div id="daylist_6"></div>
            <div id="modal-content-divs_6">
                <h2>&lt;BOM 등록&gt;</h2>
                <div class="modal-div_">
                </div>
	            <div id="table">
                	
                	 <form id="bomForm" action="register" method="post">
		                <input type="hidden" name="mes_book_code1" id="mes_book_code1">
		                <input type="hidden" name="mes_book_code2" id="mes_book_code2">
		                <input type="hidden" name="mes_book_code3" id="mes_book_code3">
		                <p>
		                    <label for="bom_code">BOM 코드:</label>
		                    <input type="text" id="bomCode" name="bom_code" required>
		                </p>
		                <p>
		                    <label for="bom_name">BOM 이름:</label>
		                    <input type="text" id="bomName" name="bom_name" required>
		                </p>
		                <button type="submit">등록</button>
            		</form>
                </div>
               
            </div>
        </div>
    </div>
    <!-- //////////////////////////// 세번째 모달 ////////////////////////////////////// -->
		
	
	
	<script src="./assets/js/mes_workorderBom.js"></script>
</body>
</html>