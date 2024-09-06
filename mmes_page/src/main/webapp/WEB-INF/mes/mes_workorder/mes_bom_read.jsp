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
				<h3>BOM 상세정보</h3>
				<div>
					<form>
						<div class="page_2">
							<form id="postForm" method="post" action="stockUpdate">
								<input type="hidden" name="order_id" value="${dto.bom_code }">
								<h1>제품코드 : ${dto.bom_code }</h1>
								<br> <input type="hidden" name="order_date"
									value="${dto.bom_name }">
								<h2>제품이름 : ${dto.bom_name }</h2>
								<input type="hidden" name="mes_book_code1"
									value="${dto.mes_book_code1 }">
								<h2>부품코드1 : ${dto.mes_book_code1 }</h2>
								<input type="hidden" name="mes_book_code2"
									value="${dto.mes_book_code2 }">
								<h2>부품코드2 : ${dto.mes_book_code2 }</h2>
								<input type="hidden" name="mes_book_code3"
									value="${dto.mes_book_code3 }">
								<h2>부품코드3 : ${dto.mes_book_code3 }</h2>
								<br> <input type="submit" value="등록">
							</form>
						</div>
					</form>
					<form method="post" action="delete">

						<input type="hidden" name="bom_code" value="${param.bom_code }">
						<input type="submit" id="deleteButton" value="BOM 삭제">
					</form>
				</div>
			</div>
		</section>
	</div>

	<!-- //////////////////////////// 세번째 모달 ////////////////////////////////////// -->
	<div id="modal_6" class="modal_6">
		<div class="close_6">
			<span class="material-symbols-outlined"> close </span>
		</div>
		<div class="modal-content_6">
			<div id="daylist_6"></div>
			<div id="modal-content-divs_6">
				<h2>&lt;BOM 등록&gt;</h2>
				<div class="modal-div_"></div>
				<div id="table">
					<form>
						<table>
							<tr class="modal-div_6">
								<td><span class="modal-item">제품코드</span></td>
								<td><input type="text" name="bom_code"></td>
							</tr>
							<tr class="modal-div_6">
								<td><span class="modal-item">제품명</span></td>
								<td><input type="text" name="bom_name"></td>
							</tr>

						</table>
					</form>

				</div>
				<div class="modal-div_7" style="text-align: right;">
					<input class="inpa" type="submit" value="생성">
				</div>
			</div>
		</div>
	</div>
	<!-- //////////////////////////// 세번째 모달 ////////////////////////////////////// -->



	<script src="./assets/js/mes_workorderBom.js"></script>
</body>
</html>