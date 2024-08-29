<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대출 현황</title>
<link href="../assets/css/inven/inven.css" rel="stylesheet">
<style>
	aside #items #i3 .material-symbols-outlined{ background: rgb(165, 224, 144); }
</style>
</head>
<body>
<%@ include file="/WEB-INF/admin/base/a.header.jsp" %>

    <div id="wrap">
        
	<%@ include file="/WEB-INF/admin/inven/inventory_side.jsp" %>

        <section>
            <div class="main_page" id="main_page_1">
                <h3>실시간 도서 대출</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                        	<colgroup>
                                <col width="20%">
                                <col width="8%">
                                <col width="10%">
                                <col width="10%">
                                <col width="8%">
                                <col width="10%">
                                <col width="5%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th class="sortable">도서명</th>
                                    <th>도서 코드</th>
                                    <th>대출자(아이디)</th>
                                    <th>대출일</th>
                                    <th>반납예정일</th>
                                    <th>현황</th>
                                    <th>연체</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td class="bname">미드나잇 라이브러리</td>
                                    <td>001</td>
                                    <td>박규태(121212)</td>
                                    <td>2024-07-01</td>
                                    <td>2024-07-08</td>
                                    <td>반납완료</td>
                                    <td>-</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    
					<form method="post" action="loan_update" id="form">
			            <div class="popup">
			            	<div class="close">
				            	<span class="popup-close">&times;</span>
			            	</div>
			            	<table>
			                	<colgroup>
			                        <col width="25%">
			                        <col width="9%">
			                        <col width="8%">
			                        <col width="10%">
			                        <col width="10%">
			                        <col width="10%">
			                        <col width="12%">
			                        <col width="8%">
			                    </colgroup>
			                    <thead>
			                        <tr>
			                            <th class="sortable">도서명</th>
	                                    <th>도서 코드</th>
	                                    <th>대출자(아이디)</th>
	                                    <th>대출일</th>
	                                    <th>반납예정일</th>
	                                    <th>현황</th>
	                                    <th>반납일</th>
	                                    <th>연체</th>
			                        </tr>
			                    </thead>
			                    <tbody>
			                        <tr>
			                        	<td>미드나잇 라이브러리</td>
	                                    <td>001</td>
	                                    <td>박규태(121212)</td>
	                                    <td>2024-07-01</td>
	                                    <td>2024-07-08</td>
	                                    <td>
	                                    	<select name="loan_ing">
												<option value="loaning">대출중</option>
												<option value="end">반납완료</option>
											</select>
	                                    </td>
	                                    <td><input type="date" name="loan_return"></td>
	                                    <td><input type="text" name="loan_over"></td>
			                        </tr>
			                        
			                    </tbody>
			                </table>
			                        
			                <button type="submit" class="end">현황 수정하기</button>
			            </div>
			       	</form>
                </div>
            </div>
            <script src="../assets/js/inven/res_popup.js"></script>
        </section>
    </div>
    
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>
</body>
</html>