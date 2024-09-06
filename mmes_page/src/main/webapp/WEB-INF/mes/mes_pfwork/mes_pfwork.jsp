<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="./assets/css/click.css" rel="stylesheet">
<link href="./assets/css/mes_pfwork.css" rel="stylesheet">
</head>

<body>

	<!-- 가장 위 고정 -->
	<!-- 헤더  -->
	<%@ include file="/WEB-INF/mes/mes_base/header.jsp"%>
	<!-- 헤더  -->


	<!-- 여기 사이에 이것 저것 코딩하세용 >< -->
	<div id="wrap">
		<!-- 사이드바 -->
		<%@ include file="/WEB-INF/mes/mes_pfwork/mes_pfwork_side.jsp"%>
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
							<thead>
								<tr>
									<th class="sortable">주문번호</th>
									<th>제품명</th>
									<th>회원ID</th>
									<th>주문날짜</th>
									<th>담당자</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="work" items="${ list }">
									<tr>
										<td class="sortable">${ work.os_id }</td>
										<td>${ work.bom_name }</td>
										<td>${ work.user_id }</td>
										<td>${ work.os_date }</td>
										<td>${ work.emp_name }</td>
										<td><a href="pfwork_read?os_id=${ work.os_id }"><input type="button" value="수정"></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<br>
					<div id="pfworkpush">
						<input type="button" id="addpf" value="주문추가">
					</div>
				</div>
			</div>

			<!-- ///////////////////// 출고 현황 ///////////////////////////// -->
			<div class="main_page" id="main_page_2">
				<h3>출고 현황</h3>
				<div>
					<div class="page_2">
						<table id="main_librar2">
							<thead>
								<tr>
									<th class="sortable">주문번호</th>
									<th>출고일자</th>
									<th>회원ID</th>
									<th>제품명</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="ds" items="${ ds }">
									<tr>
										<td>${ ds.os_id }</td>
										<td>${ ds.ds_date }</td>
										<td>${ ds.user_id }</td>
										<td>${ ds.bom_name }</td>
										<td>${ ds.ds_con }</td>
									</tr>
								</c:forEach>
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
			<span class="material-symbols-outlined"> close </span>
		</div>
		<div class="modal-content_2">
			<div id="daylist_2"></div>
			<div id="modal-content-divs_2">
				<h2>&lt;주문추가&gt;</h2>
				<div class="modal-div_">
					<span class="red">*</span> 필수
				</div>
				<form method="post" action="pfwork_insert">
					<div id="table">
						<table>
							<tr class="modal-div_2">
								<td><span class="red">*</span> <span class="modal-item">제품명</span>
								</td>
								<td><select name="bom_code">
										<c:forEach var="code" items="${bom_code}">
											<option value="${code}">${code}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr class="modal-div_2">
								<td><span class="red">*</span> <span class="modal-item">회원ID</span>
								</td>
								<td><select name="buser_seq">
										<c:forEach var="code" items="${buser_seq}">
											<option value="${code}">${code}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr class="modal-div_2">
								<td><span class="red">*</span> <span class="modal-item">주문날짜</span>
								</td>
								<td><input type="date" name="os_date"></td>
							</tr>
							<tr class="modal-div_2">
								<td class="modal-item">담당자</td>
								<td><select name="emp_id">
										<c:forEach var="code" items="${emp_id}">
											<option value="${code}">${code}</option>
										</c:forEach>
								</select></td>
							</tr>
						</table>
					</div>
					<div class="modal-div_3" style="text-align: right;">
						<input class="inpa" type="submit" value="생성">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- //////////////////////////// 첫번째 모달 ////////////////////////////////////// -->

	<!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->
	<div id="modal_4" class="modal_4">
		<div class="close_4">
			<span class="material-symbols-outlined"> close </span>
		</div>
		<div class="modal-content_4">
			<div id="daylist_4"></div>
			<div id="modal-content-divs_4">
				<h2>&lt;상세내역&gt;</h2>
				<div class="modal-div_"></div>
				<div id="table">
					<table>
						<tr class="modal-div_4">
							<td><span class="modal-item">주문번호</span></td>
							<td><span class="modal-item">제품명</span></td>
							<td><span class="modal-item">회원</span></td>
							<td><span class="modal-item">주문날짜</span></td>
							<td><span class="modal-item">담당자</span></td>
						</tr>
						<c:forEach var="modal" items="${ update }">
							<tr class="modal-div_4">
								<td><span>${ modal.os_id }</span></td>
								<td><span>${ modal.bom_name }</span></td>
								<td><span>${ modal.user_id }</span></td>
								<td><span>${ modal.os_date }</span></td>
								<td><span>${ modal.emp_name }</span></td>
							</tr>
						</c:forEach>
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