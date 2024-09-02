<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/noti/noti2.css" rel="stylesheet">
<meta charset="UTF-8">
<title>�������� ����</title>
</head>
<body>
    <%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
    <div id="wrap">
        <%@ include file="/WEB-INF/admin/notification/noti_side.jsp"%>
   <section>
       <h1>�������� ����</h1>
       <form action="${pageContext.request.contextPath}/notice/update" method="post" enctype="multipart/form-data">
           <input type="hidden" name="id" value="${notice.ann_seq}" />
           <table>
               <tr>
                   <td>�з� ID:</td>
                   <td><input type="text" name="class_id" value="${notice.class_id}" /></td>
               </tr>
               <tr>
                   <td>����:</td>
                   <td><input type="text" name="ann_title" value="${notice.ann_title}" /></td>
               </tr>
               <tr>
                   <td>�����:</td>
                   <td><input type="text" name="ann_regi" value="${notice.ann_regi}" readonly /></td>
               </tr>
               <tr>
                   <td>����:</td>
                   <td><textarea name="ann_detail">${notice.ann_detail}</textarea></td>
               </tr>
               <tr>
                   <td>÷������:</td>
                   <td>
                       <input type="file" name="ann_attach" />
                       <c:if test="${not empty notice.ann_attach}">
                           <p>���� ����: ${notice.ann_attach}</p>
                       </c:if>
                   </td>
               </tr>
           </table>
           <button type="submit">�����ϱ�</button>
       </form>
        </section>
    </div>
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
</body>
</html>