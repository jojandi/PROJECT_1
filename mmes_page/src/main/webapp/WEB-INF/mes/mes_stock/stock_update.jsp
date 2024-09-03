<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>재고 관리</title>
<link href="./assets/css/admin_table.css" rel="stylesheet">
<link href="./assets/css/00.user_side_base.css" rel="stylesheet">
<link href="./assets/css/admin.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link href="./assets/css/click.css" rel="stylesheet">
<link href="./assets/css/mes_stock.css" rel="stylesheet">
<link href="./assets/css/mes_notice2.css" rel="stylesheet">

<script src="./assets/js/admin_stock.js"></script>
</head>

<body>

	<!-- 가장 위 고정 -->
	<!-- 헤더  -->
	<%@ include file="/WEB-INF/mes/mes_base/header.jsp"%>
	<!-- 헤더  -->


	<!-- 여기 사이에 이것 저것 코딩하세용 >< -->
	<div id="wrap">
		<aside class="clearfix" id="side">
			<div id="sideleft">
				<a href="stock"><h2 id="title">재고 관리 페이지로</h2></a>
				<div id="items"></div>
			</div>
		</aside>
		<section>
			<div class="main_page" id="main_page_1">
				<div class="container">
					<h1>발주 상세 및 수정</h1>
					<form id="postForm" method="post" action="stockUpdate">
						<input type="hidden" name="order_id" value="${dto.order_id }">
						<h1>주문번호 : ${dto.order_id }</h1>
						<br> <input type="hidden" name="order_date"	value="${dto.order_date }">
						<h2>발주일 : ${dto.order_date }</h2>
						<input type="hidden" name="order_price"	value="${dto.order_price }">
						<h2>총 금액 : ${dto.order_price }</h2>
						<input type="hidden" name="order_count"	value="${dto.order_count }">
						<h2>주문 개수 : ${dto.order_count }</h2>
						<h2>
							발주상태 : <select name="order_st">
								<option value="진행중" ${dto.order_st == '진행중' ? 'selected' : ''}>진행중</option>
								<option value="완료" ${dto.order_st == '완료' ? 'selected' : ''}>완료</option>
							</select>
						</h2>
						<input type="hidden" name="emp_ID" value="${dto.emp_id }">
						<h2>직원ID : ${dto.emp_id }</h2>
						<input type="hidden" name="pub_id" value="${dto.pub_id }">
						<h2>구매처ID : ${dto.pub_id }</h2>
						<input type="hidden" name="mes_book_code" value="${dto.mes_book_code }">
						<h2>부품코드 : ${dto.mes_book_code }</h2>
						<br> <input type="submit" value="등록">
					</form>

				</div>
			</div>
		</section>
	</div>


	<!-- 가장 아래 고정 -->

</body>
<script src="./assets/js/mes_stock.js"></script>
</html>