<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/my/user_mypage_side.css" rel="stylesheet">
<style>
     #menu #items #i4{ font-weight: 900; text-decoration: underline; }  
</style>
</head>
<body>
	<!-- 사이드 -->
        <aside class="clearfix" id="side">
            
            <div id="sideleft">
                <h2 id="title">마이페이지</h2>
                
                <div id="items">
                    
                    <div class="item" id="i1">
                    	<a href="mypage_use">
    	                    <span>이용내역</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    	</a>
                    </div>
                    <div class="item" id="i2">
                    	<a href="mypage_cart">
    	                    <span>찜 목록</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    	</a>
                    </div>
                    <div class="item" id="i3">
	                    <a href="mypage_bookadd">
	                        <span>도서 신청 내역</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
	                    </a>
                    </div>
                    <div class="item" id="i4">
                    	<a href="mypage_info">
    	                    <span>내 정보</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    	</a>
                    </div>
                    
                </div>
            </div>
            
        </aside>
        <script src="../assets/js/my/mypage.js"></script>
</body>
</html>