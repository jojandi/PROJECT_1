<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/member/member.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>도서 회원 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">

		<%@ include file="/WEB-INF/admin/member/member_side.jsp"%>
		<section>
			<div class="main_page" id="main_page_1">
				<h3>도서 회원 관리</h3>
				<div>
					<!-- 언제부터 대출가능 한지 넣기  -->

					<form action="/processMembers" method="post">
						<div class="page">
							<table>
								<colgroup>
	                                <col width="17%">
	                                <col width="10%">
	                                <col width="10%">
	                                <col width="12%">
	                                <col width="7%">
	                                <col width="7%">
	                                <col width="7%">
	                            </colgroup>
								<thead>
									<tr>
										<th>이름</th>
										<th>생년월일</th>
										<th>아이디</th>
										<th>전화번호</th>
										<th>대여수</th>
										<th>연체정보</th>
										<th>비고</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${map}">
										<tr>
											<td><a href="member_?seq=${map.user_seq}">${map.user_name}</a></td>
											<td>${map.user_birth}</td>
											<td>${map.user_id}</td>
											<td>${map.user_tel}</td>
											<td>${map.user_loan}</td>
											<td><c:if test="${map.user_over == true}">
								연체
							</c:if> <c:if test="${map.user_over == false}">
								-
							</c:if></td>
									<td><c:if test="${map.user_over == true}">
								${map.user_pass}부터 대여 가능
							</c:if> <c:if test="${map.user_over == false}">
								-
							</c:if></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</form>
				</div>
			</div>
		</section>
	</div>
	<script src="../assets/js/mem/member.js"></script>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
