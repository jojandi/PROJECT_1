<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="user.dto.bookflix.BookflixDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/bookflix/bookflix_use.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <div id="wrap"> 
        <div id="parent">
            <div id="top_logo">
                <img id="top_logo_img"
                    src="../assets/img/bookflix.png">
            </div>
            
            <%
            	List list = (List)request.getAttribute("list");
            	
            	BookflixDTO dto = (BookflixDTO)list.get(0);
            	String start = dto.getBuser_date().toString();
            	String end = dto.getBuser_end().toString();
            	String date = dto.getBuser_date().toString();
            	System.out.println("start : " + start);
            	System.out.println("end : " + end);
            	
            	String[] starts = start.split("-");
            	String[] ends = end.split("-");
            	String[] dates = date.split("-");
            	for(int i =0; i < starts.length; i++){
	            	System.out.println("start : " + starts[i]);
            	}
            	for(int i =0; i < ends.length; i++){
	            	System.out.println("ends : " + ends[i]);
            	}
            	for(int i =0; i < dates.length; i++){
	            	System.out.println("dates : " + dates[i]);
            	}
            	String startMMDD = starts[1] + "월 " + starts[2] + "일";
            	String endMMDD = ends[1] + "월 " + ends[2] + "일";
            	String dateMMDD = dates[0] + "년" + dates[1] + "월 " + dates[2] + "일";
            %>

            <div id="top_box">
                <div>
                    ${list[0].user_name}님은 <%=dateMMDD %> 부터 구독 하셨습니다. <br>
                    구독 기간은 <%=startMMDD %>부터 <%=endMMDD %> 입니다.
                </div>
            </div>

            <div class="top_for_you">
                ${list[0].user_name}님만을 위한 취향저격 이달의 ${list[0].bom_name} 도서
                <div id="top_in_for_you">
                    ${list[0].user_name}님을 위한 책을 소개시켜드릴게요!<br>
                    인공지능 데이터를 토대로 추천 해드립니다.
                </div>
            </div>
            
            <div id="book_1_parent">
                <div id="bookall">
                <c:forEach var="list" items="${list}">
                    <div class="book">
                        <img id="book_1_img" src="${list.book_img}">
						<div class=book_name>&lt; ${list.book_name} &gt;</div>
                        <div>
                            <div class="btn">
                                <button class="popupBnt">책정보 보기</button>
                            </div>

                            <div id="popup1" class="popup">
                                <div class="popup-header">
                                    <h2>${list.book_name}</h2>
                                    <span class="popup-close">&times;</span>
                                </div>
                                <p>${list.book_author} (지은이)  &nbsp;|&nbsp; ${list.book_pub} (주)</p>
                                <p>${list.li_book_info}</p>
                            </div>

                        </div>

                    </div>
                    
                </c:forEach>
                </div>

            </div>
            
            <div id="review">
            	<div>
            		BOOKFLIX에 대한 평가를 남겨주세요!
            	</div>
	            <button type="button" id="reviewBnt">리뷰쓰기</button>
	            
	            <form method="post" action="bookflixk_review" id="form">
		            <div id="reviewPopup">
		            	<div class="close">
			            	<span class="popup-close">&times;</span>
		            	</div>
		            	<div class="star-rating">
		            		<span>별점 : </span>
						   	<input type="checkbox" name="star" class="star" value="1">
						   	<input type="checkbox" name="star" class="star" value="2">
						   	<input type="checkbox" name="star" class="star" value="3">
						   	<input type="checkbox" name="star" class="star" value="4">
						   	<input type="checkbox" name="star" class="star" value="5">
						 </div>
		                <textarea name="review_text" id="review_text" placeholder=" 리뷰를 입력해주세요. "></textarea>
		                <br>
		                <input type="hidden" name="buser" value="${list[0].buser_seq}">
		                <input type="hidden" name="user" value="${list[0].user_seq}">
		                <button type="submit" id="end">작성완료</button>
		            </div>
	            </form>
            </div>

    <!-- wrap -->
        </div>
    <script src="../assets/js/bookflix/bookflix_use.js"></script>
    </div>
    
     <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %> 

</body>
</html>