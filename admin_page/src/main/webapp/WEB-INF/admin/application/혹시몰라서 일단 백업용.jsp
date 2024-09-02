<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/app/app.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>도서신청</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">
		<%@ include file="/WEB-INF/admin/application/app_side.jsp"%>
		<section>
			<h3>도서 신청 목록</h3>
			<form action="/admin_page/admin/app" method="post">
				<div>
					<table class="report" id="book">
						<thead>
							<tr>
								<th>번호</th>
								<th>도서명</th>
								<th>저 자</th>
								<th>출판사</th>
								<th>신청일</th>
								<th>회원번호</th>
								<th><input type="checkbox" id="selectAll"></th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>01</td>
								<td>박규태</td>
								<td>당신이 누군가를 죽였다</td>
								<td>히가시노게이노</td>
								<td>2024-07-24</td>
								<td><input type="checkbox" name="select" value="01"></td>
							</tr>
							<tr>
								<td>02</td>
								<td>이제섭</td>
								<td>나는 도대체 왜 피곤할까</td>
								<td>에이미 샤</td>
								<td>2024-07-23</td>
								<td><input type="checkbox" name="select" value="02"></td>
							</tr>
							<tr>
								<td>03</td>
								<td>김아영</td>
								<td>불면의 법칙</td>
								<td>존 릴런드</td>
								<td>2024-07-22</td>
								<td><input type="checkbox" name="select" value="03"></td>
							</tr>
							<tr>
								<td>04</td>
								<td>조민정</td>
								<td>돈의 심리학</td>
								<td>김훈</td>
								<td>2024-07-21</td>
								<td><input type="checkbox" name="select" value="04"></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="click">
					<input type="button" value="도서구매" class="search" id="bookPurchaseBtn"> 
					<input type="submit" value="선택삭제" class="search">
				</div>
			</form>
		</section>
	</div>

	<!-- 모달창 시작 -->      
	<div id="bookPurchaseModal" class="modal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<h2>도서구매</h2>
			<p>도서 구매를 진행하시겠습니까?</p>
			<button>구매하기</button>
		</div>
	</div>
	<!-- 모달창 끝 -->


	<script src="../assets/js/app/app_admin.js"></script>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
/* 여기서부터 */
#section {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	padding: 20px;
	font-size: 50px;
	margin-left: 20px;
	vertical-align: top;
	display: inline-block;
}

table.report {
	width: 100%;
	border-collapse: collapse;
}

table.report th, table.report td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: center;
}

table.report th {
	background-color: #f2f2f2;
	font-weight: bold;
}

/* 마우스 올리면 색깔 나오게 하는 방법 */
table.report tr:nth-child(even) {
	background-color: #f9f9f9;
}

table.report tr:hover {
	background-color: #f1f1f1;
}

input[type="checkbox"] {
	margin-right: 10px;
}

/* input[type="button"] {
	padding: 8px 16px;
	background-color: #a2f796;
	color: rgb(19, 2, 2);
	border: none;
	border-radius: 4px;
	cursor: pointer;
} */

/* input[type="button"]:hover {
	background-color: #9ae880;
} */

.pagination {
	display: flex;
	justify-content: center;
	margin-top: 20px;
}

.pagination div {
	margin: 0 5px;
	padding: 8px 12px;
	background-color: #a2f796;
	color: black;
	border-radius: 4px;
	cursor: pointer;
}

/* .pagination div:hover {
	background-color: #9ae880;
} */

.search-bar {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 20px;
}

.search-bar select, .search-bar input[type="search"], .search-bar input[type="button"].search
	{
	margin-right: 10px;
	padding: 8px;
	border-radius: 4px;
	border: 1px solid #ddd;
}

.search-bar input[type="button"].search {
	background-color: #a2f796;
	color: white;
	border: none;
	cursor: pointer;
}

/* .search-bar input[type="button"].search:hover {
	background-color: #9ae880;
}
 */
.click {
	display: flex;
	justify-content: flex-end;
	margin-top: 20px;
}

.click input[type="button"] {
	margin-left: 10px;
}

#wrap {
	height: 550px;
}

/*----------------------------------------*/
  /* 모달창 스타일 */
    .modal {
        display: none; /* 기본적으로 숨김 */
        position: fixed; 
        left: 0;
        top: 0;
        width: 100%; 
        height: 100%; 
        overflow: auto; 
        background-color: rgb(0,0,0); 
        background-color: rgba(0,0,0,0.4); 
        padding-top: 60px; 
    }

    .modal-content {
        background-color: #fefefe;
        margin: 5% auto;
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
