<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="mes_DTO.MesHumanDTO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link href="./assets/css/00.user_side_base.css" rel="stylesheet">
<link href="./assets/css/00.user_side_base.css" rel="stylesheet">
<link href="./assets/css/admin.css" rel="stylesheet">
<link href="./assets/css/mes_review.css" rel="stylesheet">
<link href="./assets/css/admin_table.css" rel="stylesheet">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

<style>

/* -------------------------------관리자 직원관리------------------------------ */
#menu #items #i5 {
	font-weight: 901;
	text-decoration: underline;
}

#i_1 {
	background-color: rgb(165, 224, 144);
}

.clickable {
	cursor: pointer;
	color: blue;
	text-decoration: underline;
}

/* ------------------------------------------------------------------ */

	.hidden-column {
		display: none;
	}

</style>



</head>

<body>

	<!-- 가장 위 고정 -->
	<!-- 헤더  -->
	<%@ include file="/WEB-INF/mes/mes_base/header.jsp"%>
	<!-- 헤더  -->

	<div id="wrap">
		<!-- 사이드 -->
		<%@ include file="/WEB-INF/mes/mes_bookflix/review_side.jsp"%>

		<section>

			<div class="main_page" id="main_page_1">
				<h3>리뷰 관리</h3>
				<div>
					<div class="bot_btn">
						<div class="search-container">
							<input type="text" id="searchInput" placeholder="리뷰 검색...">
							<input type="submit" value="검색">
						</div>
					</div>
					<div class="page_2">
						<table id="main_library">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성날짜</th>
								<th class="hidden-column">평점</th>
        						<th class="hidden-column">내용</th>
							</tr>
							<c:forEach var="list" items="${ list }">
								<tr class="data-row" data-id="${ list.review_seq }">
									<td>${ list.review_seq }</td>
									<td>${ list.review_name }</td>
									<td>${ list.user_id }</td>
									<td>${ list.review_date }</td>
									<td class="hidden-column">${ list.review_score }</td>
            						<td class="hidden-column">${ list.review_contents }</td>
								</tr>
							</c:forEach>
						</table>
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
			<div id="modal-content-divs_4">
				<div id="table">
					<table id="modalTable">

					</table>
				</div>
			</div>
		</div>
	</div>
	<!-- //////////////////////////// 두번째 모달 ////////////////////////////////////// -->

	<!--자바 스크립트 영역-->
	<script src="./assets/js/mes_review.js"></script>


</body>

</html>