<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/noti/noti3.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
/*     aside #items #i3 .material-symbols-outlined{ */
/* background-color: rgb(165, 224, 144); */
	
}
    </style>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">
		<%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>

		<div id="section">
			<div id="content_all">
				<div class="name">
					<div class="mini_name">중앙 / 공지 ></div>
					<strong>중앙도서관 재개관 안내</strong>
					<div id="mini">
						<span class="mini_date">등록일 | 2024-07-24</span> <span>조회 |
							234</span>
					</div>
				</div>

				<div id="content">
					<div id="file">
						<div>
							<span>첨부파일 </span> <span class="material-symbols-outlined">folder</span>
						</div>
					</div>
					<img
						src="https://www.cheonan.go.kr/crosseditor/binary/images/001062/20240613100113543_G7CSX518.png">
				</div>

				<div id="back">
					<a href="/admin_page/admin/noti2">목록</a>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>