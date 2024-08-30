<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 현황</title>
<link href="../assets/css/inven/inven.css" rel="stylesheet">
<style>
	aside #items #i2 .material-symbols-outlined{ background: rgb(165, 224, 144); }
</style>
</head>
<body>
<%@ include file="/WEB-INF/admin/base/a.header.jsp" %>

    <div id="wrap">
        
	<%@ include file="/WEB-INF/admin/inven/inventory_side.jsp" %>

        <section>
            <div class="main_page" id="main_page_1">
                <h3>실시간 도서 예약</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                        	<colgroup>
                                <col width="20%">
                                <col width="8%">
                                <col width="8%">
                                <col width="10%">
                                <col width="8%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th class="sortable">도서명</th>
                                    <th>도서 코드</th>
                                    <th>예약자</th>
                                    <th>예약번호</th>
                                    <th>예약일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="bname">미드나잇 라이브러리</td>
                                    <td>001</td>
                                    <td>박규태</td>
                                    <td>12121212</td>
                                    <td>2024-07-01</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
	        <form method="post" action="res_update" id="form">
	            <div class="popup">
	            	<div class="close">
		            	<span class="popup-close">&times;</span>
	            	</div>
	            	<table>
	                	<colgroup>
	                        <col width="25%">
	                        <col width="10%">
	                        <col width="8%">
	                        <col width="10%">
	                        <col width="10%">
	                        <col width="15%">
	                        <col width="15%">
	                    </colgroup>
	                    <thead>
	                        <tr>
	                            <th class="sortable">도서명</th>
	                            <th>도서 코드</th>
	                            <th>예약자</th>
	                            <th>예약번호</th>
	                            <th>예약일</th>
	                            <th>픽업일</th>
	                            <th>현황</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                        <tr>
	                            <td>미드나잇 라이브러리</td>
	                            <td>001</td>
	                            <td>박규태</td>
	                            <td>12121212</td>
	                            <td>2024-07-01</td>
	                            <td><input type="date" name="res_pick"></td>
	                            <td>
		                            <select name="res_ing">
										<option value="wait">픽업대기</option>
										<option value="end">픽업완료</option>
									</select>
	                            </td>
	                        </tr>
	                        
	                    </tbody>
	                </table>
	                        
	                <button type="submit" class="end">현황 수정하기</button>
	            </div>
	       	</form>
        </section>
        <script src="../assets/js/inven/res_popup.js"></script>
    </div>
    
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>
</body>
</html>