<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />

	<!-- 가장 위 고정 -->
	<!-- 헤더  -->
	<%@ include file="/WEB-INF/mes/mes_base/header.jsp"%>
	<!-- 헤더  -->

	<!-- 여기 사이에 이것 저것 코딩하세용 >< -->
	<div id="wrap">
		<%@ include file="/WEB-INF/mes/mes_workorder/workorder_side.jsp"%>
		<section>
			<!-- ---------------------- 작업지시서 페이지 ---------------------------- -->
			<div class="main_page" id="main_page_1">
				<h3>작업지시서</h3>
				<div>
						<div class="search-container">
							<input type="text" id="searchInput" placeholder="지시번호 검색">
						</div>
					<div class="page_2">
						<table id="main_library1">
							<col width="15%"/>
						    <col width="20%"/>
						    <col width="20%"/>
						    <col width="10%"/>
						    <col width="10%"/>
						    <col width="10%"/>
						    <col width="10%"/>
							<thead>
								<tr>
									<th class="sortable">지시번호</th>
									<th>제품코드</th>
									<th>제품명</th>
									<th>공정</th>
									<th>수량</th>
									<th>상태</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="list" items="${list1 }">
									<tr>
										<td class="sortable">${ list.wo_id }</td>
										<td>${ list.bom_code }</td>
										<td>${ list.bom_name }</td>
										<td>${ list.wo_process }</td>
										<td>${ list.wo_count }</td>
										<td>${ list.wo_status }</td>
										<td><form method="get" action="wo_update">
												<input type="hidden" name="wo_id" value="${ list.wo_id }">
												<input type="submit" value="수정">
											</form></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>

					</div>

					<div class="bot_btn">
						<a href="wo_insert"><input type="button" id="addbtn"
							value="작업지시서 생성"></a>

					</div>

				</div>
			</div>


			<!-- -------------------------------- BOM페이지 ------------------------------- -->
			<div class="main_page" id="main_page_2">
				<h3>BOM</h3>
				<div>
					<div id="bomsh">
						<input type="text" id="searchBom" placeholder="제품명 검색">
					</div>
					<div class="page_2">
						<table id="main_library">
							<thead>
								<tr>
									<th><input type="checkbox" id="p1_checkAll"></th>
									<th>제품코드</th>
									<th class="sortable">제품명</th>
									<th>부품코드1</th>
									<th>부품코드2</th>
									<th>부품코드3</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="dto" items="${list}">
									<tr>
										<td><input type="checkbox" class="bom_checkbox"></td>
										<td><a
											href="http://localhost:8080/mmes_page/bom_read?bom_code=${dto.bom_code}">${dto.bom_code}</a></td>
										<td class="sortable">${dto.bom_name}</td>
										<td>${dto.mes_book_code1}</td>
										<td>${dto.mes_book_code2}</td>
										<td>${dto.mes_book_code3}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<div class="bot_btn">
						<a href="bom"><input type="button" id="addbom" value="BOM 생성"></a>
					</div>
				</div>
			</div>

						<!-- -------------------------------- BOM페이지 ------------------------------- -->
				<div class="main_page" id="main_page_2">
                  <h3>BOM</h3>
                     <div>
                        <div id="bomsh">
                            <input type="text" id="searchAll" placeholder="제품명 검색">
                        </div>
                        <div class="page_2">
                           <table id="main_library">
                              <thead>
                                <tr>
                                 
                                  <th class="sortable">상품코드</th>
                                  <th>상품명</th>
                                  <th>부품코드 1</th>
                                  <th>부품코드 2</th>
                                  <th>부품코드 3</th>
                                </tr>
                             </thead>
                             <tbody>
                               <c:forEach var="dto" items="${list}">
                                   <tr>
                                      
                                       <td><a href="http://localhost:8080/mmes_page/bom_read?bom_code=${dto.bom_code}">${dto.bom_code}</a></td>
                                       <td>${dto.bom_name}</td>
                                       <td>${dto.mes_book_code1}</td>
                                       <td>${dto.mes_book_code2}</td>
                                       <td>${dto.mes_book_code3}</td>
                                   </tr>
                               </c:forEach>
                              </tbody>
                           </table>
                         </div>
                         <div class="bot_btn">
                               <a href="bom"><input type="button" value="BOM 생성"></a>
                           </div>
                           
                        </div>
                       </div>

		</section>
	</div>


	<!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->
	<div id="modal_4" class="modal_4">
		<div class="close_4">
			<span class="material-symbols-outlined"> close </span>
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
							<th><span class="modal-item">상위부품코드</span></th>
							<th><span>상위부품명</span></th>
							<th><span>부품코드</span></th>
							<th><span>부품명</span></th>
							<th><span>수량</span></th>
							<th><span>사용여부</span></th>
							<th><span>비고</span></th>
						</tr>
						<tr class="modal-div_4">
							<td><span class="modal-item">book-20</span></td>
							<td><span>20대필독서</span></td>
							<td><span>20101</span></td>
							<td><span>너의췌장을 먹고 싶어</span></td>
							<td><span>1</span></td>
							<td><span>Y</span></td>
							<td><span>-</span></td>
						</tr>
						<tr class="modal-div_4">
							<td><span class="modal-item">book-20</span></td>
							<td><span>20대필독서</span></td>
							<td><span>20102</span></td>
							<td><span>죽여 마땅한 사람들</span></td>
							<td><span>1</span></td>
							<td><span>Y</span></td>
							<td><span>-</span></td>
						</tr>
						<tr class="modal-div_4">
							<td><span class="modal-item">book-20</span></td>
							<td><span>20대필독서</span></td>
							<td><span>20103</span></td>
							<td><span>죽고싶지만 떡볶이는 먹고싶어</span></td>
							<td><span>1</span></td>
							<td><span>Y</span></td>
							<td><span>-</span></td>
						</tr>
						<tr class="modal-div_4">
							<td><span class="modal-item">book-20</span></td>
							<td><span>20대필독서</span></td>
							<td><span>20104</span></td>
							<td><span>응가</span></td>
							<td><span>1</span></td>
							<td><span>Y</span></td>
							<td><span>-</span></td>
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