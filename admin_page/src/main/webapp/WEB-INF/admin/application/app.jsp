<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

    <link href="../assets/css/noti/noti2.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>도서 신청관리</title>
    <style>
    aside #items #i2 .material-symbols-outlined{
	background-color: rgb(165, 224, 144);
	
}
    </style>
</head>
<body>
    <%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
    <div id="wrap">
        <%@ include file="/WEB-INF/admin/application/app_side.jsp"%>
        <section>
            <h3>도서 신청관리</h3>

      		<table>
          	<thead>
              <tr>
                  <th>번호</th>
                  <th>도서명</th>
                  <th>저자</th>
                  <th>출판사</th>
                  <th>신청일</th>
                  <th>회원번호</th>
                  <th>구매 상태</th>
                  <th>구매 요청</th>
              </tr>
          	</thead>
          <tbody>
              <!-- 도서 신청 목록을 동적으로 표시 -->
              <c:forEach var="appls" items="${appl}">
                  <tr>
                      <td>${appls.app_seq}</td>
                      <td>${appls.app_book}</td>
                      <td>${appls.app_name}</td>
                      <td>${appls.app_pub}</td>
                      <td>${appls.app_date}</td>
                      <td>${appls.user_seq}</td>
                      <td>
               <c:choose>
                   <c:when test="${appls.purchased != null}">
                       구매 완료
                   </c:when>
                   <c:otherwise>
                       구매 요청
                   </c:otherwise>
               </c:choose>
           </td>
           <td>
               <form action="${pageContext.request.contextPath}/admin/app" method="post" onsubmit="return confirm('정말로 이 도서를 구매하시겠습니까?');">
                   <input type="hidden" name="app_seq" value="${appls.app_seq}" />
<%--                    <input type="hidden" name="purchase" value="${appls.purchased}" /> --%>
                   <c:if test="${appls.purchased == null}">
                       <button type="submit">구매 요청</button>
                   </c:if>
               </form>
           </td>
       </tr>
       </c:forEach>
        </tbody>
    </table>
</section>
    </div>
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
