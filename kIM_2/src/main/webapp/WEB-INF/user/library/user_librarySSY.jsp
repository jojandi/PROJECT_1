<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 정보(쌍용)</title>
<link href="../assets/css/library/user_library.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/user_base/header.jsp"%>
<div id="wrap">
	<!-- aside -->
	<%@ include file="/WEB-INF/user/library/user_librarcs_side.jsp"%>
	       <section id = "library_infor">
            <div id = "infor_top_box">
                <h1>쌍용 도서관 정보</h1>
            </div>
            
            <div>
                <img id = "infor_img" src= "https://www.cheonan.go.kr/images/lib/content/il_06_20190731.jpg">
            </div>

            <div>
                <ul style="line-height:200%;">
                    <li>
                    <strong>위치</strong>
                    천안시 서북구 월봉4로 153
                    </li> 
                    
                    <li>
                    <strong>부지면적</strong>
                    4,824㎡(지상 4층, 지하1층)
                    </li> 
                    
                    <li>
                    <strong>건물면적</strong>
                    4,792㎡(지하 1층, 지상 4층)
                    </li> 
                    
                    <li>
                    <strong>좌석수</strong>
                    659석(열람석수 : 481석)
                    </li> 
                    
                    <li>
                    <strong>공사기간</strong>
                    2000.05.18.~2001.12.27.(개관 2002.03.15.)
                    </li> 
                    
                    <li>
                    <strong>총사업비</strong>
                    5,186백만원(도비 1,250백만 원, 시비 3,936백만 원)
                    </li> 
                    
                    <li>
                    <strong>주요시설</strong>
                    어린이자료실, 일반자료실, 북카페, 세미나실, 전시 등 복합문화공간, 이야기뜰, 동아리실 등
                    </li> 

                </ul>
            </div>

            <div id="info_map_addr">
                <div id = "infor_map">
                    <h3>오시는길</h3>
                <!-- * 카카오맵 --->

                    <div id="daumRoughmapContainer1721617560534" class="root_daum_roughmap root_daum_roughmap_landing"></div>
                    <script charset="UTF-8" class="daum_roughmap_loader_script" src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

                    <!-- 3. 실행 스크립트 -->
                    <script charset="UTF-8">
                        new daum.roughmap.Lander({
                            "timestamp" : "1721617560534",
                            "key" : "2k4yo",
                            "mapWidth" : "640",
                            "mapHeight" : "360"
                        }).render();
                    </script>
                </div>
                <div id="infor_adress">
                    <div class="addr">
                        <span class="material-symbols-outlined">home</span>
                        천안시 서북구 월봉4로 153
                    </div>
                    <div class="call">
                        <span class="material-symbols-outlined">call</span>
                        041-521-3731
                    </div>
                </div>
            </div>
        </section>
    </div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/user_base/footer.jsp"%>
</body>
</html>