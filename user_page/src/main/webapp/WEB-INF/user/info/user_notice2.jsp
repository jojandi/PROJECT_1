<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="user.dto.noti.NotiDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 사용자용</title>
<link href="../assets/css/info/user_notice2.css" rel="stylesheet">
<link href="../assets/js/notice/user_notice.js" rel="stylesheet">
</head>
<style>
aside #items #i3 .material-symbols-outlined {
        background: rgb(165, 224, 144);
}
</style>
<body>
    <!-- header -->
    <jsp:include page="/WEB-INF/user/base/header.jsp" />

    <div id="wrap">

        <!-- aside -->
        <jsp:include page="/WEB-INF/user/info/user_info_side.jsp" />

        <div id="section">
            <div class="name">
                <strong>이용시간 안내</strong>
            </div>

            <div id="table">
                <table class="report" id="reportTable">

                <thead>
                    <tr>
                        <th>열람실명</th>
                        <th>평일 이용시간</th>
                        <th>주말 이용시간</th>
                        <th>휴관일</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>일반 열람실</td>
                        <td>09:00 - 21:00</td>
                        <td>09:00 - 18:00</td>
                        <td>매주 월요일, 공휴일</td>
                    </tr>
                    <tr>
                        <td>디지털 열람실</td>
                        <td>09:00 - 20:00</td>
                        <td>09:00 - 17:00</td>
                        <td>매주 월요일, 공휴일</td>
                    </tr>
                    <tr>
                        <td>러닝커먼스</td>
                        <td>09:00 - 22:00</td>
                        <td>09:00 - 18:00</td>
                        <td>매주 화요일, 공휴일</td>
                    </tr>
                    <tr>
                        <td>일반자료실</td>
                        <td>09:00 - 21:00</td>
                        <td>09:00 - 17:00</td>
                        <td>매주 화요일, 공휴일</td>
                    </tr>
                  
                </tbody>

            </table>
        </div>

    </div>

</div>

    <script src="../assets/js/info/user_notice.js"></script>
    <!-- footer -->
    <jsp:include page="/WEB-INF/user/base/footer.jsp" />

</body>
</html>
