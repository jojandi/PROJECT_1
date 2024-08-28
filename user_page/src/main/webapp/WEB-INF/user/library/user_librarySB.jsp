<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 정보(신방)</title>
<link href="../assets/css/library/user_library.css" rel="stylesheet">
<style>
	aside #items #i4 .material-symbols-outlined{
            background: rgb(165, 224, 144);
     }
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>
<div id="wrap">
	<!-- aside -->
	<%@ include file="/WEB-INF/user/library/user_librarcs_side.jsp"%>
	<section id="library_infor">
		<div id="infor_top_box">
			<h1>신방 도서관 정보</h1>
		</div>

		<div>
			<img id="infor_img"
				src="https://www.cheonan.go.kr/images/lib/content/il_01.jpg">
		</div>

		<div>
			<ul style="line-height: 200%;">
				<li><strong>위치</strong> 천안시 동남구 통정4로 7</li>

				<li><strong>연면적</strong> 5,390.63㎡(지하1층/지상3층)</li>

				<li><strong>개관일</strong> 2013.01.21.</li>

				<li><strong>총사업비 </strong> 10,051백만원(국도비 3600, 도비 600, 시비 5851)
				</li>

				<li><strong>주요시설</strong> 아동열람실, 북카페, 종합자료실, 디지털실, 열람실, 다목적홀,
					문화강좌실 등</li>

			</ul>
		</div>

		<div id="info_map_addr">
			<div id="infor_map">
				<h3>오시는길</h3>
				<!-- * 카카오맵 -->

				<div id="daumRoughmapContainer1721618390148"
					class="root_daum_roughmap root_daum_roughmap_landing"></div>

				<script charset="UTF-8" class="daum_roughmap_loader_script"
					src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

				<!-- 3. 실행 스크립트 -->
				<script charset="UTF-8">
					new daum.roughmap.Lander({
						"timestamp" : "1721618390148",
						"key" : "2k4yu",
						"mapWidth" : "640",
						"mapHeight" : "360"
					}).render();
				</script>
			
			</div>
			<div id="infor_adress">
				<div class="addr">
					<span class="material-symbols-outlined">home</span> 천안시 동남구 통정4로 7
				</div>
				<div class="call">
					<span class="material-symbols-outlined">call</span> 041-521-3724
				</div>
			</div>
		</div>

	</section>
	</div>
	<section id="library_infor">
		<div id="infor_top_box">
			<h1>신방 도서관 정보</h1>
		</div>

		<div>
			<img id="infor_img"
				src="https://www.cheonan.go.kr/images/lib/content/il_01.jpg">
		</div>

		<div>
			<ul style="line-height: 200%;">
				<li><strong>위치</strong> 천안시 동남구 통정4로 7</li>

				<li><strong>연면적</strong> 5,390.63㎡(지하1층/지상3층)</li>

				<li><strong>개관일</strong> 2013.01.21.</li>

				<li><strong>총사업비 </strong> 10,051백만원(국도비 3600, 도비 600, 시비 5851)
				</li>

				<li><strong>주요시설</strong> 아동열람실, 북카페, 종합자료실, 디지털실, 열람실, 다목적홀,
					문화강좌실 등</li>

			</ul>
		</div>

		<div id="info_map_addr">
			<div id="infor_map">
				<h3>오시는길</h3>
				<!-- * 카카오맵 -->

				<div id="daumRoughmapContainer1721618390148"
					class="root_daum_roughmap root_daum_roughmap_landing"></div>

				<script charset="UTF-8" class="daum_roughmap_loader_script"
					src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

				<!-- 3. 실행 스크립트 -->
				<script charset="UTF-8">
					new daum.roughmap.Lander({
						"timestamp" : "1721618390148",
						"key" : "2k4yu",
						"mapWidth" : "640",
						"mapHeight" : "360"
					}).render();
				</script>
			</div>
			<div id="infor_adress">
				<div class="addr">
					<span class="material-symbols-outlined">home</span> 천안시 동남구 통정4로 7
				</div>
				<div class="call">
					<span class="material-symbols-outlined">call</span> 041-521-3724
				</div>
			</div>
		</div>

	</section>
	</div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>
</body>
</html>