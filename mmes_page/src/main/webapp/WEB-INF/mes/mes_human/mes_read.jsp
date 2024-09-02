<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 전체 페이지 스타일 */
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	margin: 0;
	padding: 0;
}

/* 테이블 컨테이너 스타일 */
#main_library {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

/* 테이블 컬럼 너비 조정 */
colgroup col:nth-child(1) {
	width: 7%;
}

colgroup col:nth-child(2) {
	width: 8%;
}

colgroup col:nth-child(3) {
	width: 11%;
}

colgroup col:nth-child(4) {
	width: 8%;
}

colgroup col:nth-child(5) {
	width: 16%;
}

colgroup col:nth-child(6) {
	width: 21%;
}

colgroup col:nth-child(7) {
	width: 20%;
}

/* 헤더 스타일 */
thead th {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: left;
	font-weight: bold;
}

/* 테이블 바디 스타일 */
tbody tr {
	background-color: #fff;
	border-bottom: 1px solid #ddd;
}

tbody tr:nth-child(even) {
	background-color: #f9f9f9;
}

tbody td {
	padding: 10px;
	text-align: left;
}

/* 체크박스 스타일 */
input[type="checkbox"] {
	margin: 0;
	cursor: pointer;
}

/* 링크 스타일 */
a {
	text-decoration: none;
	color: #007bff;
}

a:hover {
	text-decoration: underline;
}

/* 마지막 행의 테두리 */
tbody tr:last-child {
	border-bottom: 2px solid #333;
}
/* 버튼 컨테이너 스타일 */
.button-container {
    margin: 20px 0;
    text-align: right; /* 오른쪽 정렬 */
}

.modal {
            display: none;
            position: fixed;
            z-index: 1;
            left: 500px;
            top: 100px;
            width: 400px;
            height: 80%;
            overflow: auto;
        }

        .modal-content {
            background-color: #fefefe;
            margin: 15% auto;
            padding: 20px;
            border: 1px solid #888;
            width: 80%;
        }

        .close {
            color: #aaa;
            float: right;
            font-size: 28px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: black;
            text-decoration: none;
            cursor: pointer;
        }

        #workForm {
            text-align: center;
        }}
</style>

</head>
<body>
	<table id="main_library">
		<colgroup>
			<col width="7%">
			<col width="8%">
			<col width="11%">
			<col width="8%">
			<col width="16%">
			<col width="21%">
			<col width="20%">
		</colgroup>
		<thead>
			<tr>
				<th><input type="checkbox" id="p1_checkAll"></th>
				<th class="sortable">사원번호</th>
				<th>이름</th>
				<th>직급</th>
				<th>부서</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>입사일</th>
			</tr>
		</thead>
		<tbody>


			<tr>
				<td><input type="checkbox" class="emp_checkbox"></td>
				<td>${dto.emp_id}</td>
				<td>${dto.emp_name}</td>
				<td>${dto.po_name}</td>
				<td>${dto.dept_name}</td>
				<td>${dto.emp_hp}</td>
				<td>${dto.emp_add}</td>
				<td>${dto.emp_hiredate}</td>
			</tr>


		</tbody>
	</table>
	<div class="button-container">
		 <div class="text_right">
         <input id="openForm2" type="button" value="수정하기">
         </div>
		<form method="post" action="remove">
		<input type="hidden" name="emp_id" value="${dto.emp_id }">
		<input type="submit" value="삭제">
		</form>
		<button class="btn" id="listBtn"><a href="http://localhost:8080/mmes_page/human">목록으로 가기</a></button>
	</div>
	<div id="formModal2" class="modal">
                <div class="modal-content">
                    <span class="close">&times;</span>
                    <form id="workForm2" method="post" action="human">
                        <table>
                            <tr>
                                <th colspan="2">사원 수정</th>
                            </tr>
                            <tr>
                                <td>사원번호</td>
                                <td><input  type= "text" name="emp_id"></td>
                            </tr>
                            <tr>
                                <td>이름</td>
                                <td><input type="text" name="emp_name"></td>
                            </tr>
                            <tr>
                                <td>직급</td>
                                <td><input type="text" name="po_name"></td>
                            </tr>
                            <tr>
                                <td>부서</td>
                                <td><input type="text"  name="dept_name"></td>
                            </tr>
                            <tr>
                                <td>전화번호</td>
                                <td><input type="text"  name="emp_hp"></td>
                            </tr>
                            <tr>
                                <td>주소</td>
                                <td><input type="text" name="emp_add"></td>
                            </tr>
                            <tr>
                                <td>입사일</td>
                                <td><input name="emp_hiredate" type="date"></td>
                            </tr>
                        </table>
                        <input id="workFormBtn" type="submit" value="수정하기">
                    </form>
                </div>
            </div>
          <script src="./assets/js/mes_human_2.js"></script>
</body>
</html>