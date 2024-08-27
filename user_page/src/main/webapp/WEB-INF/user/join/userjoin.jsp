<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<link href="../assets/css/join/user_join.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>
	
	<!--여기에 내가 짠 코드넣기  -->
	<div id="hg">
		<div class="name">
			<strong>행복만땅 회원가입</strong>
		</div>

		<div>
			<table border="1">
				<tr>
					<td class="label">이름</td>
					<td><input type="text" id="name_" placeholder="이름을 입력하세요.">
					</td>
				</tr>
				<tr>
					<td class="label">생년월일</td>
					<td>
						<div class="container">
							<select>
								<option value="년도">년도</option>
								<option value="1995">1995</option>
								<option value="1997">1997</option>
								<option value="2004">2004</option>
							</select> <select>
								<option value="월">월</option>
								<option value="1">1월</option>
								<option value="2">2월</option>
								<option value="3">3월</option>
								<option value="4">4월</option>
								<option value="5">5월</option>
								<option value="6">6월</option>
								<option value="7">7월</option>
								<option value="8">8월</option>
								<option value="9">9월</option>
								<option value="10">10월</option>
								<option value="11">11월</option>
								<option value="12">12월</option>
							</select> <select>
								<option value="일">일</option>
								<option value="1">1일</option>
								<option value="2">2일</option>
								<option value="3">3일</option>
								<option value="4">4일</option>
								<option value="5">5일</option>
								<option value="6">6일</option>
								<option value="7">7일</option>
								<option value="8">8일</option>
								<option value="9">9일</option>
								<option value="10">10일</option>
								<option value="11">11일</option>
								<option value="12">12일</option>
								<option value="13">13일</option>
								<option value="14">14일</option>
								<option value="15">15일</option>
								<option value="16">16일</option>
								<option value="17">17일</option>
								<option value="18">18일</option>
								<option value="19">19일</option>
								<option value="20">20일</option>
								<option value="21">21일</option>
								<option value="22">22일</option>
								<option value="23">23일</option>
								<option value="24">24일</option>
								<option value="25">25일</option>
								<option value="26">26일</option>
								<option value="27">27일</option>
								<option value="28">28일</option>
								<option value="29">29일</option>
								<option value="30">30일</option>
								<option value="31">31일</option>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<td class="label">아이디</td>
					<td>
						<div id="seob">
							<input type="text" id="username" placeholder="아이디">
							<div class="red" id="username-message">아이디를 적어주세요</div>
						</div>
						<div class="gaip">
							<input type="button" value="아이디 중복확인" id="check-username">
						</div>
					</td>
				</tr>
				<tr>

				</tr>
				<tr>
					<td class="label">비밀번호</td>
					<td><input type="password" id="password" placeholder="비밀번호">
						<div class="red" id="password-message">비밀번호를 적어주세요</div></td>
				</tr>
				<tr>
					<td class="label">비밀번호 확인</td>
					<td><input type="password" id="confirm-password"
						placeholder="비밀번호 재입력">
						<div class="red" id="confirm-password-message">비밀번호가 일치하지
							않습니다</div></td>
				</tr>
				<tr>
					<td class="label">전화번호</td>
					<td><input type="text" id="phone" placeholder="휴대폰 번호 입력">
					</td>
				</tr>
				<tr>
					<td class="label">주소</td>
					<td><input type="text" id="addressnum" placeholder="우편번호">
						<div class="gaip">
							<input type="button" value="검색">
						</div> <br> <input type="text" id="address" placeholder="기본주소 입력">
						<input type="text" id="addressinfo" placeholder="상세주소 입력">


					</td>
				</tr>
				<tr>
					<td class="label">e_mail</td>
					<td><input class="email-input" type="text" id="email-user"
						placeholder="이메일주소">
						<div class="email-domain">@</div> <input class="email-input"
						type="text" id="email-domain" placeholder="naver.com"></td>
				</tr>
				<tr>
					<td class="label">선호도 조사</td>
					<td><input type="checkbox" id="hre" placeholder="">언론
						<input type="checkbox" id="hre" placeholder="">소설 <input
						type="checkbox" id="hre" placeholder="">역사 <input
						type="checkbox" id="hre" placeholder="">과학 <input
						type="checkbox" id="hre" placeholder="">인문학 <input
						type="checkbox" id="hre" placeholder="">자기계발 <br> <input
						type="checkbox" id="hre" placeholder="">무협 <input
						type="checkbox" id="hre" placeholder="">만화 <input
						type="checkbox" id="hre" placeholder="">판타지 <input
						type="checkbox" id="hre" placeholder="">오디오 <input
						type="checkbox" id="hre" placeholder="">로맨스 <input
						type="checkbox" id="hre" placeholder="">일반</td>
				</tr>

				<!-- <tr> -->
				<!-- <div class="gaip2">
                        <td colspan="2" class="gaip">
                            <input id="gaip_1" type="button" value="회원가입 완료">
                        </td>
                    </div> -->
				<!-- </tr> -->
			</table>
			<div style="text-align: center;">
				<input id="gaip_1" type="button" value="회원가입 완료">
			</div>
		</div>

	</div>
	
	<script src="../assets/js/join/user_join.js"></script>
	<!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
</body>
</html>