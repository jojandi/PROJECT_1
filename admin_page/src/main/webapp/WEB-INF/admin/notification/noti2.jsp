<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                    <tr>
                        <td>1</td>
                        <td>001</td>
                        <td>공지사항 제목 1</td>
                        <td>2024-08-30</td>
                        <td>123</td>
                        <td>공지사항 내용 1</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>002</td>
                        <td>공지사항 제목 2</td>
                        <td>2024-08-31</td>
                        <td>456</td>
                        <td>공지사항 내용 2</td>
                    </tr>
                </tbody>
            </table>
        </section>
    </div>
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
