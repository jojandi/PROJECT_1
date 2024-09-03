<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <link href="../assets/css/noti/noti2.css" rel="stylesheet">
    <meta charset="UTF-8">
    <title>도서 신청관리</title>
</head>
<body>
    <%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
    <div id="wrap">
        <%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>
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
                      <td>${appl.ann_seq}</td>
                      <td>${appl.app_book}</td>
                      <td>${appl.app_name}</td>
                      <td>${appl.app_pub}</td>
                      <td>${appl.app_date}</td>
                      <td>${appl.user_seq}</td>
                      <td>
               <c:choose>
                   <c:when test="${appl.purchased}">
                       구매 완료
                   </c:when>
                   <c:otherwise>
                       구매 대기 중
                   </c:otherwise>
               </c:choose>
           </td>
           <td>
               <form action="${pageContext.request.contextPath}/admin/app" method="post" onsubmit="return confirm('정말로 이 도서를 구매하시겠습니까?');">
                   <input type="hidden" name="ann_seq" value="${appl.ann_seq}" />
                   <input type="hidden" name="action" value="purchase" />
                   <c:if test="${!appl.purchased}">
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
