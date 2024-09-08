<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 추가</title>
<link href="../assets/css/noti/noti.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>

	<div id="wrap">
		<%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>
		<section>

	<div id="section">
	<div class="main_page" id="main_page_1">
		<div id="admin_controls">
			<h2>공지사항 추가</h2>

<!-- 			<form action="noti2" method="post" enctype="multipart/form-data"> -->
			<form action="noti2" method="post">
				<input type="hidden" name="action" value="create">
				<div id="con">
					<select id="notice_category" name="class_id">
						<option value="5001">공지</option>
						<option value="5002">안내</option>
					</select>
				</div>
				<input type="text" id="new_notice_title" name="ann_title"
					placeholder="공지사항 제목" required>
						<input type='date' id='currentDate'/>
				<textarea id="new_notice_content" name="ann_detail" rows="5"
					placeholder="공지사항 내용" required></textarea>
				<input type='file' id='ann_attach' name='ann_attach'>
				<button type="submit">공지사항 추가</button> 
			</form>
		</div>
	</div>
</div>
		</section>
	</div>
	<script>
  	document.getElementById('currentDate').value = new Date().toISOString().substring(0, 10);;
	</script>

	<script src="../assets/js/app/noti.js"></script>

	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
