<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>사용자용 메인페이지</title>
    <link href="./assets/css/mes_mainPage.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link href="./assets/css/admin_table.css" rel="stylesheet">
    <link href="./assets/css/modal.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script src="admin_main_Chart.js"></script>
    <script src="./assets/js/modal.js"></script>
    <script src="./assets/js/click.js"></script>
    <link href="./assets/css/click.css" rel="stylesheet">
<style>
       #section1{
            width: 90vw;
            height: 50vh;
            text-align: center;
            margin:auto;
        
       }
       
       #productionChart {
            width: 90vw;
            height: 80vh;
            text-align: center;
            margin: auto;
        }

       
</style>
</head>
<body>

<!-- 가장 위 고정 -->
    <!-- 헤더  -->
		<%@ include file="/WEB-INF/mes/mes_base/header.jsp" %>
	<!-- 헤더  -->

<!-- 메인페이지 -->

    <!-- google fonts 가져오기 -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <div id="wrap">

        <section class="section1">

            <div id="hukwan">
            
                <!-- <div id="librarys">   
                    <div class="library" id="joong">중앙</div>
                    <div class="library" id="ssang">쌍용</div>
                    <div class="library" id="du">두정</div>
                    <div class="library" id="sin">신방</div>
                    <div class="library" id="cheong">청수</div>
                </div> -->
                <div id="calendar">
                    <div class="calHeader">
                        <h2 id="YearMonth">
                            <!-- YYYY년 M월 -->
                        </h2>
                    </div>

                    <div id="days">
                        <div>일</div>
                        <div>월</div>
                        <div>화</div>
                        <div>수</div>
                        <div>목</div>
                        <div>금</div>
                        <div>토</div>
                    </div>

                    <div id="dates">
                        <!-- 날짜들 들어오는 곳 -->
                    </div>
                </div>
                <script src="./assets/js/01.calendar.js"></script>

            </div>
            <div id="hukwan_bot"><div class="circle_1"></div>출고일 <div class="circle_2"></div><small>도서입고일</small></div>
        </section>

        <section class="section1">
            <h1>작업 진행률</h1>
    <canvas id="progressChart"></canvas>
    
    
        </section>

        <section class="section2">
            <h1>라인별 시간당 생산량</h1>
    
            <canvas id="productionChart"></canvas>

        
        </section>


    <!-- wrap -->
    </div> 

    <script src="./assets/js/mes_mainPage.js"></script>
    <script src="./assets/js/chart.js"></script>


<!-- 가장 아래 고정 -->
   
    <!-- 모달 -->
    <div id="taskModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>작업지시서</h2>
            <div class="modal-body">
                <p><strong>작업명:</strong> <span id="taskName"></span></p>
                <p><strong>작업자:</strong> <span id="taskAssignee"></span></p>
                <p><strong>진행상황:</strong> <span id="taskStatus"></span></p>
                <p><strong>발생 일자:</strong> <span id="taskDate"></span></p>
                <p><strong>위치:</strong> <span id="taskLocation"></span></p>
                <p><strong>작업 세부사항:</strong></p>
                <textarea id="taskDetails" rows="4" cols="50" readonly></textarea>
            </div>
        </div>
    </div>
</body>
</html>