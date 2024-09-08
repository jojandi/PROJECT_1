<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	<%@ include file="/WEB-INF/mes/mes_base/header.jsp"%>
	<!-- 헤더  -->
	<div id="wrap">
		<aside class="clearfix" id="side">
			<div id="sideleft">
				<h2 id="title">생산 관리</h2>
				<div id="items">
					<a href="workorder"><div class="item" id="i1">
							<span>작업지시서</span> <span class="material-symbols-outlined">arrow_forward_ios</span>
						</div></a> <a href="bom"><div class="item" id="i2">
							<span>BOM</span> <span class="material-symbols-outlined active">arrow_forward_ios</span>
						</div></a>
				</div>
			</div>
		</aside>
		<section>
			<div class="main_page" id="main_page_1">
				<h3>BOM 수정</h3>

				<div class="page_2">

					<form id="postForm" method="post" action="bom_read">
						<table id="main_library">
							<thead>
								<tr>
									<th class="sortable">제품코드</th>
									<th>부품명</th>
									<th>부품코드1</th>
									<th>부품코드2</th>
									<th>부품코드3</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>${dto.bom_code }</td>
									<td>${dto.bom_name }</td>
									<td><select name="mes_book_code1">
											<c:forEach var="code" items="${mes_book_code}">
												<option value="${code }">${code }</option>
											</c:forEach>
									</select></td>
									<td><select name="mes_book_code2">
											<c:forEach var="code" items="${mes_book_code}">
												<option value="${code }">${code }</option>
											</c:forEach>
									</select></td>
									<td><select name="mes_book_code3">
											<c:forEach var="code" items="${mes_book_code}">
												<option value="${code }">${code }</option>
											</c:forEach>
									</select></td>


								</tr>
							</tbody>
						</table>
						<input type="submit" value="등록">

					</form>
				</div>
				<form method="post" action="delete">

					<input type="hidden" name="bom_code" value="${param.bom_code }">
					<input type="submit" id="deleteButton" value="BOM 삭제">
				</form>
			</div>
		</section>

	</div>




	<script src="./assets/js/mes_workorderBom.js"></script>
</body>
</html>