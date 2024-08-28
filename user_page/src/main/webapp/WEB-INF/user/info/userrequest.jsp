<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 도서신청</title>
<link href="../assets/css/info/user_request.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>
	
	<div id="wrap">
		<!-- aside -->
		<%@ include file="/WEB-INF/user/info/user_info_side.jsp"%>
	
		<div id="section">
			<!-- 수정해야할 곳 꼭 섹션 안에서!!! -->
			<h3>도서신청</h3>
	
			<form method="post" action="request">
				<div class="app">
					<div>
						<input type="text" name="app_book" placeholder="책이름을 입력해주세요"> 
						<input type="submit" value="책이름">
					</div>
		
					<div>
						<input type="text" name="app_name" placeholder="저자를 입력해주세요"> 
						<input type="submit" value="저자"><br>
					</div>
		
					<div>
						<input type="text" name="app_pub" placeholder="출판사를 입력해주세요"> 
						<input type="submit" value="출판사"><br>
					</div>
		
					<!-- 추가로 수정한거 -->
					<div>
						<select name="lib_id" class="library-select">
							<option value="">도서관을 선택해주세요</option>
							<option value="central">중앙도서관</option>
							<option value="sinbang">신방도서관</option>
							<option value="cheongsu">청수도서관</option>
							<option value="ssangyong">쌍용도서관</option>
							<option value="dujeong">두정도서관</option>
						</select>
					</div>
		
					<div>
						<input type="submit" value="도서신청하기">
					</div>
				</div>
			</form>
		</div>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>

</body>
</html>
