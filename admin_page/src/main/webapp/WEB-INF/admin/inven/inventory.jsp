<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                <col width="7%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">도서명</th>
                                    <th>저자명</th>
                                    <th>출판사</th>
                                    <th>출판연도</th>
                                    <th>도서코드</th>
                                    <th>ISBN</th>
                                    <th>권 수</th>
                                    <th>입고일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td class="bname">작별인사</td>
                                    <td>김영하</td>
                                    <td>문학동네</td>
                                    <td>2024.01.15</td>
                                    <td>code001</td>
                                    <td>101</td>
                                    <td>15</td>
                                    <td>2024.01.15</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="도서명 검색...">
                        </div>
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>

           
        </section>
    </div>
    
    <%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>
</body>
</html>