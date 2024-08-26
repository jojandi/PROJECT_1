<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 정보(청수)</title>
<link href="../assets/css/library/user_library.css" rel="stylesheet">
<style>
	aside #items #i5 .material-symbols-outlined{
            background: rgb(165, 224, 144);
     }
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/user_base/header.jsp"%>
<div id="wrap">
	<!-- aside -->
	<%@ include file="/WEB-INF/user/library/user_librarcs_side.jsp"%>

	<section id="library_infor">
		<div id="infor_top_box">
			<h1>청수 도서관 정보</h1>
		</div>

		<div>
			<img id="infor_img"
				src="https://www.cheonan.go.kr/images/lib/content/sub03020801.png">
		</div>

		<div id="info">
			<ul style="line-height: 200%;">
				<li><strong>위치 : </strong> 충청남도 천안시 동남구 청수16로 5-10</li>

				<li><strong>부지면적 : </strong> 3,219.5㎡(약 1,073평)</li>

				<li><strong>주차면수 : </strong> 37면(지상19대, 지하18대)</li>

				<li><strong>좌석수 : </strong> 총 780석</li>

				<li><strong>개관일 : </strong> 2018. 07. 24.</li>

				<li><strong>총사업비 : </strong> 19,900백만원(국58억,도10억,시131억)</li>

				<li><strong>주요시설 : </strong> 어린이자료실, 영어자료실, 종합자료실, 디지털실, 북카페,
					다목적홀, 강좌실 등</li>

			</ul>
		</div>

		<div id="info_map_addr">
			<div id="infor_map">
				<h3>오시는길</h3>
				<!-- * 카카오맵-->

				<div id="daumRoughmapContainer1721618641811"
					class="root_daum_roughmap root_daum_roughmap_landing"></div>

				<script charset="UTF-8" class="daum_roughmap_loader_script"
					src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

				<!-- 3. 실행 스크립트 -->
				<script charset="UTF-8">
					new daum.roughmap.Lander({
						"timestamp" : "1721618641811",
						"key" : "2k4yv",
						"mapWidth" : "640",
						"mapHeight" : "360"
					}).render();
				</script>
			</div>

			<div id="infor_adress">
				<div class="addr">
					<span class="material-symbols-outlined">home</span> 천안시 서북구 부성3길 9
				</div>
				<div class="call">
					<span class="material-symbols-outlined">call</span> 041-521-3733
				</div>
			</div>
		</div>


	</section>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/user_base/footer.jsp"%>
</body>
</html>