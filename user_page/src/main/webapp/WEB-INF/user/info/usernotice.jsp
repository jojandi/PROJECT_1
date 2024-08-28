<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
						<th></th>
						<th>분류</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회</th>
					</tr>
					<tr>
						<td>중앙</td>
						<td>공지</td>
						<td class="retitle">중앙도서관 재개관 안내</td>
						<td>2024-07-24</td>
						<td>123</td>
					</tr>
					<tr>
						<td>중앙</td>
						<td>안내</td>
						<td class="retitle">중앙도서관 열람실 공사 안내(07/23~08/03)</td>
						<td>2024-07-23</td>
						<td>456</td>
					</tr>
					<tr>
						<td>공통</td>
						<td>안내</td>
						<td class="retitle">2024 전국 청소년 영어 스피치 콘테스트 안내</td>
						<td>2024-07-22</td>
						<td>789</td>
					</tr>
					<tr>
						<td>중앙</td>
						<td>폐관</td>
						<td class="retitle">문성종작은도서관 폐관 공고</td>
						<td>2024-07-21</td>
						<td>321</td>
					</tr>
					<tr>
						<td>공통</td>
						<td>공지</td>
						<td class="retitle">천안시 도서관 누리집(홈페이지) 서비스 중단 안내</td>
						<td>2024-07-20</td>
						<td>654</td>
					</tr>
	
				</table>
			</div>
	
			<!-- 페이지 이동 -->
			<div id="movepage">
				<span class="material-symbols-outlined">chevron_left</span> <span
					class="chap">1</span> <span class="material-symbols-outlined">chevron_right</span>
			</div>
			<form id ="serch" method="get" action="comment">

			<div id="search">
				<select name="">
					<option value="전체기간">전체기간</option>
				</select> <select name="">
					<option value="게시물+댓글">게시물 + 댓글</option>
				</select> <input type="search" id="searchInput" name="keyword" placeholder="검색어를 입력해주세요">
				<input type="button" value="검색" class="search"
					onclick="filterTable()">
			</div>
		</form>
	
		</div>

	</div>


	<script src="../assets/js/info/user_notice.js"></script>
	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>

</body>
</html>