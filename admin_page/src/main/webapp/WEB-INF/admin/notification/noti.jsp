<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/noti/noti.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
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
						<div id= "con">
							<select id="notice_category">
								<option value="general">공지</option>
								<option value="event">안내</option>
							</select>
						</div>
						<input type="text" id="new_notice_title" placeholder="공지사항 제목">
						<input type="date" id="new_notice_date">

						<textarea id="new_notice_content" rows="5" placeholder="공지사항 내용"></textarea>
						<button onclick="addNotice()">공지사항 추가</button>
					</div>
				</div>
			</div>
		</section>
	</div>
	<script src="../assets/js/app/app_admin.js"></script>
	
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
