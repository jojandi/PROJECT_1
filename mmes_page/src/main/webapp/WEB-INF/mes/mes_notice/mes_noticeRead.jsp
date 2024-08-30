<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	번호 : ${ read.notice_id }
	제목 : ${ read.notice_name }
	작성자 : ${ read.emp_name }
	내용 : ${ read.notice_contents }
	작성일 : ${ read.notice_date }

</body>
</html>