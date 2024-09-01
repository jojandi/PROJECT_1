<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/noti/noti2.css" rel="stylesheet">
<meta charset="UTF-8">
<title>공지사항 게시판</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">
		<%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>
		<section>
			<h1>공지사항 게시판</h1>

			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th>분류 ID</th>
						<th>제목</th>
						<th>등록일</th>
						<th>조회수</th>
						<th>내용</th>
						<th>첨부파일</th>
					</tr>
				</thead>
				<tbody>
					<!-- 공지사항 목록을 동적으로 표시 -->
					<c:forEach var="notice" items="${notices}">
						<tr>
							<td>${notice.ann_seq}</td>
							<td>${notice.class_id}</td>
							<td>${notice.ann_title}</td>
							<td>${notice.ann_regi}</td>
							<td>${notice.ann_check}</td>
							<td>${notice.ann_detail}</td>
							<td>${notice.ann_attach}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
				
		</section>
	</div>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
