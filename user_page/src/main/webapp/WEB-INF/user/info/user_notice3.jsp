<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/info/user_notice3.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="/WEB-INF/user/base/header.jsp" />
	<div id="wrap">
		<jsp:include page="/WEB-INF/user/info/user_info_side.jsp" />

		<div id="section">
		<div id="content_all">
		<div class="name">
			<div class="mini_name">${notice.class_name }</div>
			<strong>${notice.ann_Title }</strong>
			<div id="mini">
				<span class="mini_date">등록일 | ${notice.ann_Regi }</span> <span>조회 |
					${notice.ann_Check }</span>
			</div>
		</div>

		<div id="content">
			<div id="file">
				<div>
					<span>첨부파일 </span> <span class="material-symbols-outlined">folder</span>
				</div>
			</div>

				

							<div class="bookTitle book">${notice.ann_Detail }</div>

				<div id="back">
					<a href="/user_page/user/notice"><input type="button"
						value="목록"></a>
				</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	 <jsp:include page="/WEB-INF/user/base/footer.jsp" />
</body>
</html>