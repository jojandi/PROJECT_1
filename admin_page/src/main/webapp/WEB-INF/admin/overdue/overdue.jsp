<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <section>
 <div class="main_page" id="main_page_1">
     <h3>장기연체자</h3>
     <div>
         <table>
             <thead>
                 <tr>
                     <th><input type="checkbox" id="selectAllCheckbox" onclick="toggleSelectAll(this)"></th>
                     <th>이름</th>
                     <th>생년월일</th>
                     <th>아이디</th>
                     <th>전화번호</th>
                     <th>빌린 권 수</th>
                     <th>대여일</th>
                     <th>반납일</th>
                     <th>연체정보</th>
                     <th>문자알림</th>
                 </tr>
             </thead>
             <tbody>
                 <tr>
                     <td><input type="checkbox" class="rowCheckbox"></td>
                     <td>이제섭</td>
                     <td>1995-12-30</td>
                     <td>Lee789</td>
                     <td>010-5555-6666</td>
                     <td>2</td>
                     <td>2024-06-25</td>
                     <td>2024-07-09</td>
                     <td>미반납</td>
                     <td><input type="button" value=" 문자알림완료  "></td>
                 </tr>
                 <tr>
                     <td><input type="checkbox" class="rowCheckbox"></td>
                     <td>김아영</td>
                     <td>1997-12-30</td>
                     <td>Kim459</td>
                     <td>010-5555-6666</td>
                     <td>2</td>
                     <td>2024-06-25</td>
                     <td>2024-07-09</td>
                     <td>미반납</td>
                     <td><input type="button" value="문자알림미완료"></td>
                 </tr>
             </tbody>
         </table>
         <div class="click">
             <button onclick="selectAll()">전체선택</button>
             <button onclick="deselectAll()">전체삭제</button>
            </div>
        </div>
</section>
</body>
</html>