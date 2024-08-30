<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/search/search.css" rel="stylesheet">
</head>
<body>
<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">

        <div id="search">
            <input type="text" id="searchIn" name="search" placeholder=" 검색어를 입력해주세요. ">
            <div id="searchBnt">⌕</div>
        </div>
        

        <div class="searchEnd">

            <div class="books" id="b1">

                <table>
                    <tr>
                        <td rowspan="3">
                            <div class="imge">
                                <img src="${list.book_img}">
                            </div>
                        </td>
                        <td class="best">
                            <span>20대 Best 1</span>
                            <span>추천도서</span>
                        </td>
                        <td rowspan="3" class="bookBnt">
                            <input type="button" class="reserBnt" value="예약하기"><br>
                            <input type="button" class="cartBnt" value="장바구니">
                        </td>
                    </tr>
                    <tr>
                        <td class="bookTitle">${list.book_name}</td>
                    </tr>
                    <tr>
                        <td class="information">
                            <div class="bookInfo wirter">
                                ${list.book_author} (지은이) <br> 
                                ${list.book_pub}(주)
                            </div>
                        </td>
                    </tr>
                </table>

            </div>

        </div>

    </div>
    
    <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
</body>
</html>