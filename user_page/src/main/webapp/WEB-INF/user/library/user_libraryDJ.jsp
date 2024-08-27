<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관 정보(두정)</title>
<link href="../assets/css/library/user_library.css" rel="stylesheet">
<style>
	aside #items #i3 .material-symbols-outlined{
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
        <section id = "library_infor">
            <div id = "infor_top_box">
                <h1>두정 도서관 정보</h1>
            </div>
            
            <div>
                <img id = "infor_img" src= "https://www.cheonan.go.kr/images/lib/content/il_02.jpg">
            </div>
            <div>
                <ul style="line-height:200%;">
                    <li>
                    <strong>위치</strong>
                    천안시 서북구 부성3길 9
                    </li> 
                    
                    <li>
                    <strong>부지면적</strong>
                    16,325㎡
                    </li> 
                    
                    <li>
                    <strong>건물면적</strong>
                    6,663㎡(지하 1층, 지상 4층)
                    </li> 
                    
                    <li>
                    <strong>좌석수</strong>
                    701석(자료실 : 210석, 디지털자료실 : 65석, 열람실 : 148석, 어린이 : 82석, 장애인 : 5석 기타 : 191석)
                    </li> 
                
                    <li>
                    <strong>주차시설</strong>
                    46대(지하 33대, 13대)
                    </li> 
                    
                    <li>
                    <strong>주요시설</strong>
                    어린이자료실, 어린이체험실, 다목적강당, 일반열람실, 문화강의실, 식당, 제1종합자료실, 디지털자료실, 제2종합자료실
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
                        천안시 서북구 부성3길 9
                    </div>
                    <div class="call">
                        <span class="material-symbols-outlined">call</span>
                        041-521-3733
                    </div>
                </div> 
            </div>
        
        </section>
    </div>

	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>
</body>
</html>