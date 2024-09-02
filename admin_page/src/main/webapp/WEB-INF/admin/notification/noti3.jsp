<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/noti/noti.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
<div id="wrap">
	<%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>
	<div id="section">
		<div class="name">
			<div class="mini_name">${notice.class_id}/ 공지 ></div>
			<strong>${notice.ann_title}</strong>
			<div id="mini">
				<span class="mini_date">등록일 | ${notice.ann_regi}</span> <span>조회
					| ${notice.ann_check}</span>
			</div>
		</div>

		<div id="content">
			<div id="file">
				<div>
					<span>첨부파일 </span> <span class="material-symbols-outlined">folder</span>
					${notice.ann_attach}
				</div>
			</div>
			<img src="첨부파일이 있는 경우 해당 이미지 경로 또는 URL">
		</div>

	</div>
	</div>

	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>