<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="user.dto.noti.NotiDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 사용자용</title>
<link href="../assets/css/info/user_notice.css" rel="stylesheet">
<link href="../assets/js/notice/user_notice.js" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>

	<div id="wrap">

		<!-- aside -->
		<%@ include file="/WEB-INF/user/info/user_info_side.jsp"%>

		<div id="section">
			<div class="name">
				<strong>공지사항</strong>
			</div>

			<div id="table">
				<table class="report" id="reportTable">
					<tr>
						<th>분류</th>
						<th>제목</th>
						<th>등록일</th>
					<!-- <th>내용</th> -->
						<th>조회</th>
					</tr>

					<c:choose>
						<c:when test="${notiList != null && !notiList.isEmpty()}">
							<c:forEach var="noti" items="${notiList}">
								<tr>
									<td>${noti.class_name}</td>
									<td class="retitle"><a
										href="http://localhost:8080/user_page/user/notice3?ann_seq=${noti.ann_Seq}">
											${noti.ann_Title} </a></td>
									<td>${noti.ann_Regi}</td>
				<%-- <td>${noti.ann_Detail}</td> --%>
									<td>${noti.ann_Check}</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5">공지사항이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>

			<!-- 페이지 이동 -->
			<div id="movepage">
				<!-- 이전 페이지 링크 -->
				<c:if test="${currentPage > 1}">
					<a href="?page=${currentPage - 1}"
						class="material-symbols-outlined">chevron_left</a>
				</c:if>

				<!-- 페이지 번호 링크 -->
				<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<a href="?page=${i}"
						class="chap <c:if test="${i == currentPage}">current</c:if>">${i}</a>
				</c:forEach>

				<!-- 다음 페이지 링크 -->
				<c:if test="${currentPage < totalPages}">
					<a href="?page=${currentPage + 1}"
						class="material-symbols-outlined">chevron_right</a>
				</c:if>
			</div>

			<form id="search" method="get" action="comment">
				<div id="search">
					<select name="period">
						<option value="전체기간">전체기간</option>
					</select> <select name="type">
						<option value="게시물+댓글">게시물 + 댓글</option>
					</select> <input type="search" id="searchInput" name="keyword"
						placeholder="검색어를 입력해주세요"> <input type="button" value="검색"
						class="search" onclick="filterTable()">
				</div>
			</form>
<%-- 
			<!-- Debugging Info -->
			<p>Current Page: ${currentPage}</p>
			<p>Total Pages: ${totalPages}</p>
			<p>Start Page: ${startPage}</p>
			<p>End Page: ${endPage}</p> --%>
		</div>

	</div>

	<script src="../assets/js/info/user_notice.js"></script>
	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>

</body>
</html>
