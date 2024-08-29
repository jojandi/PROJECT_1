<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/inven/inven_side.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
		<aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">재고 현황</h2>
                <div id="items">
                    <div class="item" id="i1">
                    	<a href="inventory">
	                        <span>실시간 재고 현황</span>
	                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    	</a>
                    </div>
                    <div class="item" id="i2">
	                    <a href="reservation">
	                        <span>도서 예약 현황</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
	                    </a>
                    </div>
                    <div class="item" id="i3">
                    	<a href="loan">
	                        <span>도서 대출 현황</span>
	                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    	</a>
                    </div>
                </div>
            </div>
        </aside>
</body>
</html>