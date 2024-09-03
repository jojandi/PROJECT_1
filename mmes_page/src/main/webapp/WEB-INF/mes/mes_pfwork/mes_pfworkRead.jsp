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
					<form method="post" action="pfwork_read">
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
									<tr>
										<td class="sortable"><input type=hidden name="os_id"
											value="${ read.os_id }">${ read.os_id }</td>
										<td><select name="bom_code">
												<c:forEach var="code" items="${bom_code}">
													<option value="${code}">${code}</option>
												</c:forEach>
										</select></td>
										<td>${ read.user_id }</td>
										<td>${ read.os_date }</td>
										<td>${ read.emp_name }</td>
									</tr>
								</tbody>
							</table>
						</div>
						<div>
							<input type="submit" id="upbtn" value="수정">
							<a href="/mmes_page/pfwork_delete?os_id=${ read.os_id }"><input type="button" value="삭제"></a>
						</div>
					</form>
					<br>
				</div>
			</div>

			<div class="main_page" id="main_page_2">
				<h3>출고 현황</h3>
				<div>
					<div class="page_2">
						<table id="main_librar2">
							<thead>
								<tr>
									<th><input type="checkbox" id="p1_checkAll"></th>
									<th class="sortable">주문번호</th>
									<th>출고일자</th>
									<th>회원ID</th>
									<th>제품명</th>
									<th>상태</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td><input type="checkbox"></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</section>
	</div>


	<script src="./assets/js/mes_pfworkread.js"></script>
	<!-- 가장 아래 고정 -->

</body>

</html>