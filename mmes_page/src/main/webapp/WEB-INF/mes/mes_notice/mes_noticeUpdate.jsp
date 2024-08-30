<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method=post action="notice_update">
	번호 : <input type="hidden" name="notice_id" value="${ update.notice_id }"><br>
	제목 : <input type="text" name="notice_name" placeholder="${ update.notice_name }"><br>
	작성자 : ${ update.emp_name }<Br>
	내용 : <textarea name="notice_contents" placeholder="${ update.notice_contents }"></textarea>
	<br>
	<input type=submit value="수정">
	</form>
</body>
</html>