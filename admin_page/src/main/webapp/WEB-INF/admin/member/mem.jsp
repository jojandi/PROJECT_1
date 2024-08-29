<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="wrap">
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">회원 관리</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span><a href="회원관리.html">도서 회원 관리</a></span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                    <div class="item" id="i2">
                        <span><a href="장기연체자css,js.html">장기연체자 관리</a></span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                   
                </div>
            </div>
        </aside>
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
                                <th>대여일</th>
                                <th>반납일</th>
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
                                <td>2024-07-01</td>
                                <td>2024-07-15</td>
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
                                <td>2024-07-10</td>
                                <td>2024-07-24</td>
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
                                <td>2024-06-25</td>
                                <td>2024-07-09</td>
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
                                <td>2024-06-25</td>
                                <td>2024-07-09</td>
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

</body>
</html>