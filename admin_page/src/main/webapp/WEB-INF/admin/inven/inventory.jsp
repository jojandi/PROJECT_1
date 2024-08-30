<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>재고현황</title>
<link href="../assets/css/inven/inven.css" rel="stylesheet">
<style>
	aside #items #i1 .material-symbols-outlined{ background: rgb(165, 224, 144); }
</style>
</head>
<body>
<%@ include file="/WEB-INF/admin/base/a.header.jsp" %>

    <div id="wrap">
        
	<%@ include file="/WEB-INF/admin/inven/inventory_side.jsp" %>

        <section>
            <div class="main_page" id="main_page_1">
                <h3>실시간 재고 현황</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="5%">
                                <col width="25%">
                                <col width="10%">
                                <col width="8%">
                                <col width="10%">
                                <col width="8%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">도서명</th>
                                    <th>저자명</th>
                                    <th>출판사</th>
                                    <th>ISBN</th>
                                    <th>도서코드</th>
                                </tr>
                            </thead>
                            <tbody>
                            	<c:forEach var="list" items="${list}">
	                                <tr>
	                                    <td><input type="checkbox" class="p1_main_chack"></td>
	                                    <td class="bname2">
	                                    	<a href="inventory_?isbn=${list.book_ISBN}">${list.book_name}</a>
	                                    </td>
	                                    <td>${list.book_author}</td>
	                                    <td>${list.book_pub}</td>
	                                    <td>${list.book_ISBN}</td>
	                                    <td>${list.book_code}</td>
	                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
	                    <form>
	                        <div class="search-container">
	                            <input type="text" id="searchInput" name="text" placeholder="도서명">
		                        <input type="submit" value="검색">
	                        </div>
	                    </form>
                    </div>
                </div>
            </div>
			
	            <div class="popup">
	            	<div class="close">
		            	<span class="popup-close">&times;</span>
	            	</div>
	            	<table>
	                	<colgroup>
	                        <col width="15%">
	                        <col width="25%">
	                        <col width="15%">
	                        <col width="20%">
	                        <col width="10%">
	                    </colgroup>
	                    <thead>
	                        <tr>	                        	
                                 <th></th>
                                 <th>도서명</th>
                                 <th>ISBN</th>
                                 <th>출판사</th>
                                 <th>수량</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                        	<td class="img"><img src="${dto.book_img}"></td>
	                        	<td>${dto.book_name}</td>
                                <td>${dto.book_ISBN}</td>
                                <td>${dto.book_pub}</td>
                                <td>${dto.count}</td>
	                        </tr>
	                        
	                    </tbody>
	                </table>
	                        
	            </div>
           
        </section>
        <script src="../assets/js/inven/res_popup.js"></script>
    </div>
    
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>
</body>
</html>