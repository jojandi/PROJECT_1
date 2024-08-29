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
<%@ include file="/WEB-INF/admin/base/a.header.jsp" %>
 <div id="wrap">
 <%@ include file="/WEB-INF/admin/application/app_side.jsp" %>
	<section>
	
		<!-- 여기에 내용 적기 -->
		<h3>도서 신청 목록</h3>
		<div>
			<table class="report" id="reportTable">
				<thead>
					<tr>
						<th>번호</th>
						<th>이름</th>
						<th>책제목</th>
						<th>저자</th>
						<th>등록일</th>
						<!-- <th>도서구매</th> -->
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
						<!-- <td><input type="checkbox" class="purchase"></td> -->
						<td><input type="checkbox" class="select"></td>
					</tr>
					<tr>
						<td>02</td>
						<td>이제섭</td>
						<td>나는 도대체 왜 피곤할까</td>
						<td>에이미 샤</td>
						<td>2024-07-23</td>
						<!-- <td><input type="checkbox" class="purchase"></td> -->
						<td><input type="checkbox" class="select"></td>
					</tr>
					<tr>
						<td>03</td>
						<td>김아영</td>
						<td>불면의 법칙</td>
						<td>존 릴런드</td>
						<td>2024-07-22</td>
						<!-- <td><input type="checkbox" class="purchase"></td> -->
						<td><input type="checkbox" class="select"></td>
					</tr>
					<tr>
						<td>04</td>
						<td>조민정</td>
						<td>돈의 심리학</td>
						<td>김훈</td>
						<td>2024-07-21</td>
						<!-- <td><input type="checkbox" class="purchase"></td> -->
						<td><input type="checkbox" class="select"></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="click">
			<input type="button" value="도서구매" class="search"
				onclick="handleButtonClick('buy')"> <input type="button"
				value="선택삭제" class="search" onclick="handleButtonClick('delete')">
		</div>
	</section>
	</div>

<%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>	
</body>
</html>