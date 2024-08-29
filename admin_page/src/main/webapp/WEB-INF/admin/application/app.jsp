<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/app/app.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>도서신청</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">
		<%@ include file="/WEB-INF/admin/application/app_side.jsp"%>
		<section>
			<h3>도서 신청 목록</h3>
			<form action="/admin_page/admin/app" method="post">
				<div>
					<table class="report" id="book">
						<thead>
							<tr>
								<th>번호</th>
								<th>이름</th>
								<th>책제목</th>
								<th>저자</th>
								<th>등록일</th>
								<th><input type="checkbox" id="selectAll"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>01</td>
								<td>박규태</td>
								<td>당신이 누군가를 죽였다</td>
								<td>히가시노게이노</td>
								<td>2024-07-24</td>
								<td><input type="checkbox" name="select" value="01"></td>
							</tr>
							<tr>
								<td>02</td>
								<td>이제섭</td>
								<td>나는 도대체 왜 피곤할까</td>
								<td>에이미 샤</td>
								<td>2024-07-23</td>
								<td><input type="checkbox" name="select" value="02"></td>
							</tr>
							<tr>
								<td>03</td>
								<td>김아영</td>
								<td>불면의 법칙</td>
								<td>존 릴런드</td>
								<td>2024-07-22</td>
								<td><input type="checkbox" name="select" value="03"></td>
							</tr>
							<tr>
								<td>04</td>
								<td>조민정</td>
								<td>돈의 심리학</td>
								<td>김훈</td>
								<td>2024-07-21</td>
								<td><input type="checkbox" name="select" value="04"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="click">
					<input type="button" value="도서구매" class="search" id="bookPurchaseBtn"> 
					<input type="submit" value="선택삭제" class="search">
				</div>
			</form>
		</section>
	</div>

	<!-- 모달창 시작 -->
	<div id="bookPurchaseModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>도서구매</h2>
			<p>도서 구매를 진행하시겠습니까?</p>
			<button>구매하기</button>
		</div>
	</div>
	<!-- 모달창 끝 -->


	<script src="../assets/js/app/app_admin.js"></script>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
