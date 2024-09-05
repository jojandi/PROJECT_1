<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 도서 검색</title>
<link href="../assets/css/search/search.css" rel="stylesheet">
</head>
<body>
<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">

        <div id="search">
           	<form action="search" method="get">
                <input type="text" id="searchIn" name="book" value="${param.book}" placeholder=" 검색어를 입력해주세요. ">
                <input type="submit" id="searchBnt" value="⌕">
           	</form>
        </div>
        

        <div class="searchEnd">

            <div class="books" id="b1">

               	<c:forEach var="list" items="${list}">
	                <table>
	                    <tr>
	                        <td rowspan="3">
	                            <div class="imge">
	                                <img src="${list.book_img}" alt="${list.book_name} 책 표지">
	                            </div>
	                        </td>
	                        <td class="bookTitle">${list.book_name}</td>
	                        <td rowspan="3" class="bookBnt">
	                        	<input type="hidden" name="code" value="${list.book_code}" class="code">
	                        	<input type="hidden" name="user" value="${login.user_seq}" class="user">
	                            <input type="button" class="reserBnt" value="예약하기"><br>
	                            <input type="button" class="cartBnt" value="장바구니">
	                        </td>
	                    </tr>
	                    <tr>
	                        <td>
			                    <div class="realInven">재고 <span>${list.count}</span> 권</div>
	                    	</td>
	                    </tr>
	                    <tr>
	                        <td class="information">
	                            <div class="bookInfo wirter">
	                                ${list.book_author} (지은이) | ${list.book_pub}(주)
	                            </div>
	                            <div class="bookInfo review">
	                                    ${list.li_book_info}
	                            </div>
	                        </td>
	                    </tr>
                	</table>
                	
                </c:forEach>

            </div>

        </div>
	<script src="../assets/js/search/search_post.js"></script>
    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
</body>
</html>