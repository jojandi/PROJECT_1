<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/noti/noti.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>공지사항 추가</title>
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

						<form action="noti2" method="post">
							<input type="hidden" name="action" value="create">
							<div id="con">
								<select id="notice_category" name="class_id">
									<option value="general">공지</option>
									<option value="event">안내</option>
								</select>
							</div>
							<input type="text" id="new_notice_title" name="ann_title"
								placeholder="공지사항 제목"> <input type="date"
								id="new_notice_date" name="ann_regi">
							<textarea id="new_notice_content" name="ann_detail" rows="5"
								placeholder="공지사항 내용"></textarea>
							<input type='file' id='ann_attach' name='ann_attach'>
							<button type="submit">공지사항 추가</button>
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>

	<script src="../assets/js/app/noti.js"></script>

	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
