<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/member/member.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/admin/base/a.header.jsp" %>
<div id="wrap">

 <%@ include file="/WEB-INF/admin/member/member_side.jsp" %>
        <section>
            <div class="main_page" id="main_page_1">
                <h3>도서 회원 관리</h3>
                <div>
                    <!-- 언제부터 대출가능 한지 넣기  -->

                    <table>
                        <thead>
                            <tr>
                                <th><input type="checkbox" id="selectAllCheckbox" onclick="toggleSelectAll(this)"></th>
                                <th>이름</th>
                                <th>생년월일</th>
                                <th>아이디</th>
                                <th>전화번호</th>
                                <th>대여수</th>
                                <th>연체정보</th>
                                <th>비고</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td><input type="checkbox" class="rowCheckbox"></td>
                                <td>조*정</td>
                                <td>2004-01-01</td>
                                <td>Joe123</td>
                                <td>010-1234-5678</td>
                                <td>3</td>
                                <td>없음</td>
                                <td>정상</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="rowCheckbox"></td>
                                <td>박*태</td>
                                <td>1995-05-15</td>
                                <td>Park456</td>
                                <td>010-9876-5432</td>
                                <td>1</td>
                                <td>없음</td>
                                <td>정상</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="rowCheckbox"></td>
                                <td>이*섭</td>
                                <td>1995-12-30</td>
                                <td>Lee789</td>
                                <td>010-5555-6666</td>
                                <td>2</td>
                                <td>2일 연체</td>
                                <td>7/12이후 대출가능</td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="rowCheckbox"></td>
                                <td>김*영</td>
                                <td>1997-12-30</td>
                                <td>Kim459</td>
                                <td>010-5555-6666</td>
                                <td>2</td>
                                <td>4일 연체</td>
                                <td>7/15이후 대출가능</td>
                            </tr>
                        </tbody>

                    </table>
                    <div class="click">
                        <button onclick="selectAll()">전체선택</button>
                        <button onclick="deselectAll()">전체삭제</button>
                        <button onclick="deselectAll()">선택삭제</button>
                    </div>
                </div>
            </div>

        </section>
    </div>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp" %>
</body>
</html>