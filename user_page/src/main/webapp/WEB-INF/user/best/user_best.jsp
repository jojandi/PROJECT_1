<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>베스트 도서</title>
<link href="../assets/css/best/user_best.css" rel="stylesheet">
</head>
<body>
<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">
        <section class="best_infor">
            <div id="show_box_"> <!--가져와서 출력될 div -->
                <h1>종합 베스트 도서</h1>
                <c:forEach var="list" items="${list}">
	                <table>
	                    <tr>
	                        <td rowspan="4">
	                            <div class="imge">
	                                <img src="${list.book_img}" alt="'${list.book_name}' 책 표지">
	                            </div>
	                        </td>
	                        <td><span id="in_top">전체 1위</span></td>
	                        <td rowspan="4" class="bookBnt">
	                        	<form method="post" action="res_best">
		                        	<input type="hidden" name="code" value="${list.book_code}" class="code">
		                        	<input type="hidden" name="user" value="${login.user_seq}" class="user">
		                            <input type="submit" class="reserBnt" value="예약하기">
	                        	</form>
	                        	<form method="post" action="cart_best">
		                        	<input type="hidden" name="code" value="${list.book_code}" class="code">
		                        	<input type="hidden" name="user" value="${login.user_seq}" class="user">
		                            <input type="submit" class="cartBnt" value="장바구니">
	                        	</form>
	                        </td>
	                    </tr>
	                    <tr>
	                    	<td class="bookTitle">${list.book_name}</td>
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
            <script>
            	let login = '${ login }';
            	
            	let reserBnt = document.querySelectorAll(".reserBnt"); // 예약하기 버튼
            	let cartBnt = document.querySelectorAll(".cartBnt"); // 장바구니 버튼

            	let reser = document.querySelectorAll(".reser"); // 예약 블럭


            	function login(){

            		for(let i = 0 ; i < reserBnt.length; i++){
            	        reserBnt[i].addEventListener('click', function(e){
            				if(login == ''){
            	                e.preventDefault();
            					alert("로그인 후 이용 가능합니다. ")
            				} else{
            		           console.log('예약하기 클릭!!!');
            		           alert("해당 도서가 예약되었습니다. ")
            				}
            	        })   
            	    }
            	    
            	    for(let i = 0 ; i < cartBnt.length; i++){
            	        cartBnt[i].addEventListener('click', function(e){
            	            if(login == ''){
            	                e.preventDefault();
            					alert("로그인 후 이용 가능합니다. ")
            				} else{
            		           console.log('장바구니 클릭!!!');
            		           alert("해당 도서가 장바구니에 담겼습니다. ")
            				}
            	        })
            	        
            	    }
            	}


            	login();
            </script>
        </section>
    </div>

	
<!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
	
</body>
</html>