<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link href="../assets/css/info/user_notice3.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:include page="/WEB-INF/user/base/header.jsp" />
	<div id="wrap">
		<jsp:include page="/WEB-INF/user/info/user_info_side.jsp" />

		<div id="section">
			<div id="content_all">
				<div class="name">
					<div class="mini_name">공지 ></div>
					<strong>신규 도서 입고 안내 </strong>
					<div id="mini">
						<span class="mini_date">등록일 | 2024-09-05</span> <span>조회 |
							234</span>
					</div>
				</div>

				<div id="content">
					<div id="file">
						<div>
							<span>첨부파일 </span> <span class="material-symbols-outlined">folder</span>
						</div>
					</div>

					<div id="back">
						<table>
							<colgroup>
								<col width="15%">
								<col width="50%">
								<col width="20%">
							</colgroup>
							<thead>
								<tr>
									<td colspan="2">도서</td>
									<!-- <td id="tw"></td> -->
									<td>입고 예정일</td>
								</tr>
							</thead>

							<tbody>
								<tr class="cart">
									<td rowspan="3" class="bookCover border"><img
										src="https://contents.kyobobook.co.kr/sih/fit-in/458x0/pdt/9791168340510.jpg">
									</td>
									<td class="bookTitle book">파친코 2</td>
									<td class="border" rowspan="3">2024-09-15</td>
								</tr>
								<tr>
									<td id="info" class="book">-“역사는 우리를 저버렸지만, 그래도 상관없다” 역사에
										외면당한 재일조선인 가족의 대서사극 전 세계를 감동시킨 이민진 작가 화제작 《파친코》 새롭게 출간!</td>
								</tr>
								<tr class="cart">
									<td class="wirter book border"><span>이민진 (지은이)</span> <span>
											| </span> <span>문학사 (주)</span></td>
								</tr>
							</tbody>
						</table>
						<table>
							<colgroup>
								<col width="15%">
								<col width="50%">
								<col width="20%">
							</colgroup>


							<tbody>
								<tr class="cart">
									<td rowspan="3" class="bookCover border"><img
										src="https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/9788931023718.jpg">
									</td>
									<td class="bookTitle book">실비아 플라스의 일기</td>
									<td class="border" rowspan="3">2024-09-25</td>
								</tr>
								<tr>
									<td id="info" class="book">-국내 번역 출간 20주년 기념 리커버 에디션!

										비극적이며 매혹적인 한 시인의 격정적인 삶과 예민한 영혼의 기록</td>
								</tr>
								<tr class="cart">
									<td class="wirter book border"><span>실비아 플러스 (지은이)</span>
										<span> | </span> <span>문예출판사 (주)</span></td>
								</tr>
							</tbody>
						</table>

						<table>
							<colgroup>
								<col width="15%">
								<col width="50%">
								<col width="20%">
							</colgroup>


							<tbody>
								<tr class="cart">
									<td rowspan="3" class="bookCover border"><img
										src="https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/9791171177523.jpg">
									</td>
									<td class="bookTitle book">힘들어? 그래도 해야지 어떡해</td>
									<td class="border" rowspan="3">2024-09-27</td>
								</tr>
								<tr>
									<td id="info" class="book">-‘먹고사는 일’의 무게에 짓눌려 괴로운 당신에게 웃으며
										툭 선물하는 시원 뜨끈한 위로</td>
								</tr>
								<tr class="cart">
									<td class="wirter book border"><span>실비아 플러스 (지은이)</span>
										<span> | </span> <span>아찔 (주)</span></td>
								</tr>
							</tbody>
						</table>

						<table>
							<colgroup>
								<col width="15%">
								<col width="50%">
								<col width="20%">
							</colgroup>


							<tbody>
								<tr class="cart">
									<td rowspan="3" class="bookCover border"><img
										src="https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/9791198716057.jpg">
									</td>
									<td class="bookTitle book">짧게 말해 줘</td>
									<td class="border" rowspan="3">2024-09-27</td>
								</tr>
								<tr>
									<td id="info" class="book">-하구독자 23만 명 ‘더메시지랩’ 채널을 이끄는
										유튜버이자, 이 시대가 받아들이고 이해할 수 있는 언어로 젊은 세대와 활발히 소통하는 저자가 모든 것이 불안한
										청년에게 답이 되는 든든한 말을 들고 찾아왔다.</td>
								</tr>
								<tr class="cart">
									<td class="wirter book border"><span>조정민 (지은이)</span> <span>
											| </span> <span>워더 북 (주)</span></td>
								</tr>
							</tbody>
						</table>
						<div id="back">
							<a href="/user_page/user/notice"><input type="button"
								value="목록"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	 <jsp:include page="/WEB-INF/user/base/footer.jsp" />
</body>
</html>