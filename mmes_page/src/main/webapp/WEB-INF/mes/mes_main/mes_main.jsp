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
            width: 200px;
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
		 .section2{
            width: 200px;
       
            text-align: center;
            margin:auto;
        
       }
       .all{
        width: 200px;
       }
        #wrap {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    .section1,
    .section2 {
        flex: 1;
        margin: 10px;
    }

    .section1 {
        width: 50%; /* 적절한 너비 설정 */
        height: 40vh; /* 적절한 높이 설정 */
    }

    .section2 {
        width: 30%; /* 적절한 너비 설정 */
        height:40vh; /* 적절한 높이 설정 */
        overflow: auto; /* 내용이 넘치면 스크롤 */
    }

    #productionChart {
        width: 70vw;
        height: 60vh;
        text-align: center;
        margin: auto;
    }

    .all {
        width: 100%; /* section2 내에서 적절한 너비 설정 */
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

        <section class="section2">
           
            <h3>수요 통계 및 예측</h3>
            <div class="all">
	            <div class="mini_title">수요 통계</div>
	    		<div id="select">
		            <select id="monthSelect">
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
		            </select>
	    		</div>
	            
	            <canvas id="ageGroupChart"></canvas>
	           
	        </div>
        
            <script src="./assets/js/chart.js"></script>

            
    <canvas id="progressChart"></canvas>
    
    
        </section>

        <section class="section3">
            
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