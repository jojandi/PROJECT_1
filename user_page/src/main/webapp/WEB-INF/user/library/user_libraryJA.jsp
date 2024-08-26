<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 정보(중앙)</title>
<link href="../assets/css/library/user_library.css" rel="stylesheet">
<style>
	aside #items #i1 .material-symbols-outlined{
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

	  <section id = "library_infor">
            <div id = "infor_top_box">
                <h1>중앙 도서관 정보</h1>
            </div>
            
            <div>
                <img id = "infor_img" src= "https://www.cheonan.go.kr/images/lib/sub03/sub03020101_img_01.jpg">
            </div>

            <div>
                <ul style="line-height:200%;">
                    <li>
                    <strong>위치</strong>
                    충청남도 천안시 동남구 중앙로 118
                    </li> 
                    
                    <li>
                    <strong>연면적</strong>
                    4,824㎡(지상 4층, 지하1층)
                    </li> 
                    
                    <li>
                    <strong>주차면수</strong>
                    59면(일반 53, 장애인 3, 경차 2, 전기차 1)
                    </li> 
                    
                    <li>
                    <strong>좌석수</strong>
                    540석
                    </li> 
                    
                    <li>
                    <strong>재개관일</strong>
                    2024. 6. 14.(금)
                    </li> 
                    
                    <li>
                    <strong>리모델링 총사업비 </strong>
                    124.5억원(국비21억, 시비 103.5억)
                    </li> 
                    
                    <li>
                    <strong>주요시설</strong>
                    어린이자료실, 일반자료실, 천안학자료관, 1318채움, 동아리실 등
                    </li> 

                </ul>
            </div>

            <div id="info_map_addr">
                <div id = "infor_map">
                    <h3>오시는길</h3>
                    <!-- * 카카오맵 -->
                    <div id="daumRoughmapContainer1721612623091" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                    <!--실행 스크립트 -->
                    <script charset="UTF-8">
                        new daum.roughmap.Lander({
                            "timestamp" : "1721612623091",
                            "key" : "2k4wb",
                            "mapWidth" : "640",
                            "mapHeight" : "360"
                        }).render();
                    </script>
                </div>
                <div id="infor_adress">
                    <div class="addr">
                        <span class="material-symbols-outlined">home</span>
                        충청남도 천안시 동남구 중앙로 118
                    </div>
                    <div class="call">
                        <span class="material-symbols-outlined">call</span>
                        041-521-3721
                    </div>
                </div>
            </div>
        </section>

    </div>  <section id = "library_infor">
            <div id = "infor_top_box">
                <h1>중앙 도서관 정보</h1>
            </div>
            
            <div>
                <img id = "infor_img" src= "https://www.cheonan.go.kr/images/lib/sub03/sub03020101_img_01.jpg">
            </div>

            <div>
                <ul style="line-height:200%;">
                    <li>
                    <strong>위치</strong>
                    충청남도 천안시 동남구 중앙로 118
                    </li> 
                    
                    <li>
                    <strong>연면적</strong>
                    4,824㎡(지상 4층, 지하1층)
                    </li> 
                    
                    <li>
                    <strong>주차면수</strong>
                    59면(일반 53, 장애인 3, 경차 2, 전기차 1)
                    </li> 
                    
                    <li>
                    <strong>좌석수</strong>
                    540석
                    </li> 
                    
                    <li>
                    <strong>재개관일</strong>
                    2024. 6. 14.(금)
                    </li> 
                    
                    <li>
                    <strong>리모델링 총사업비 </strong>
                    124.5억원(국비21억, 시비 103.5억)
                    </li> 
                    
                    <li>
                    <strong>주요시설</strong>
                    어린이자료실, 일반자료실, 천안학자료관, 1318채움, 동아리실 등
                    </li> 

                </ul>
            </div>

            <div id="info_map_addr">
                <div id = "infor_map">
                    <h3>오시는길</h3>
                    <!-- * 카카오맵 -->
                    <div id="daumRoughmapContainer1721612623091" class="root_daum_roughmap root_daum_roughmap_landing"></div>

                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                    <!--실행 스크립트 -->
                    <script charset="UTF-8">
                        new daum.roughmap.Lander({
                            "timestamp" : "1721612623091",
                            "key" : "2k4wb",
                            "mapWidth" : "640",
                            "mapHeight" : "360"
                        }).render();
                    </script>
                </div>
                <div id="infor_adress">
                    <div class="addr">
                        <span class="material-symbols-outlined">home</span>
                        충청남도 천안시 동남구 중앙로 118
                    </div>
                    <div class="call">
                        <span class="material-symbols-outlined">call</span>
                        041-521-3721
                    </div>
                </div>
            </div>
        </section>

    </div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/user_base/footer.jsp"%>
</body>
</html>