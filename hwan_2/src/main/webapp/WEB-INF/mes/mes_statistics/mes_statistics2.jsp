<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/00.user_base_login.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link href="./assets/css/click.css" rel="stylesheet">
    <link href="./assets/css/mes_statistics.css" rel="stylesheet">

    
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <!-- <link href="click.css" rel="stylesheet"> -->
    <style>


        /* -------------------------------관리자 도서관 정보------------------------------ */
        #i_2{
        background-color: rgb(165, 224, 144);

        }   
        #menu #items #i5{
            font-weight: 901;
            text-decoration: underline;
        } 
        /* ------------------------------------------------------------------ */
        #menu #items #i5{
            font-weight: 900;
            text-decoration: underline;
        } 
    </style>
    


</head>

<body>

    <!-- 가장 위 고정 -->
    <header id="top" class="clearfix">

        <div id="logoall">
            <div id="logo" class="left"><a href="mes_mainPage.html"><img class="logo_img" src="https://cdn.discordapp.com/attachments/1263360143756759099/1267275014273634415/KakaoTalk_20240729_090859720-removebg-preview_3.png?ex=66a83154&is=66a6dfd4&hm=4f6d706e06b34db529815a64763136b9f3f073d06fbc4513dd57c737077310f0&"></a></div>
            <!-- <div id="name" class="left">행복만땅 <br>도서관</div> -->
        </div>

        <div id="menu">
            <div id="items" class="left">
                <div class="item" id="i1"><a href="mes_pfwork.html">작업 수행</a></div>
                <div class="item" id="i2"><a href="admin_library.html">생산 관리</a></div>
                <div class="item" id="i3"><a href="mes_stock.html">재고 관리</a></div>
                <div class="item" id="i4"><a href="mes_human.html">직원 관리</a></div>
                <div class="item" id="i5"><a href="mes_statistics_1.html">통계 및 분석</a></div>
                <div class="item" id="i6"><a href="mes_notice_1.html">게시판</a></div>
            </div>
            <div class="right" id="userall">
                <div>OOO관리자</div>
                <div><a href="../사용자용 페이지/01.main_user.html">로그아웃</a></div>
                <!-- <div class="inb" id="login">로그인</div>
                <div class="inb">|</div>
                <div class="inb" id="userin">회원가입</div>
                <div class="inb" id="menus"></div> -->
            </div>
        </div>

    </header>

    <!-- 여기 사이에 이것 저것 코딩하세용 >< 
    <div id="left_menu">
        <div class="l_menu" id="l_menu_1" style="font-size: 20px;"><h2>베스트 도서</h2></div>
        <div class="l_menu" id="l_menu_1" style="font-size: 20px;"><strong>남/녀별 베스트도서</strong></div>
    <div class="l_menu" id="l_menu_1" style="font-size: 20px;">연령별 베스트도서</div>
    </div> 인기도서 관리창 코딩시작 >< 
    
-->

    <div id="wrap">
        <!-- 사이드 -->
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">통계 및 분석</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <a href="statistics1"><span>수요 통계 및 예측</span>
                        <span class="material-symbols-outlined" id="i_1">arrow_forward_ios</span></a>
                    </div>
                    <div class="item" id="i2">
                        <a href="statistics2"><span>출고 통계</span>
                        <span class="material-symbols-outlined" id="i_2">arrow_forward_ios</span></a>
                    </div>
                </div>
            </div>
        </aside>
        <section>
            <h3>월별 출고 통계</h3>
    
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
            
            <div class="table">
	            <table id="bookTable">
	                <thead>
	                    <tr>
	                        <th>연령별 필독도서</th>
	                        <th>판매량</th>
	                    </tr>
	                </thead>
	                <tbody>
	                </tbody>
	            </table>
            </div>
          
        
            <script src="./assets/js/chart.js"></script>
        </section>
    </div>
    <!--자바 스크립트 영역-->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>

        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");

        // chart.js
        document.addEventListener('DOMContentLoaded', function () {
            const ctx = document.getElementById('ageGroupChart').getContext('2d');
            const monthSelect = document.getElementById('monthSelect');
            const bookTableBody = document.querySelector('#bookTable tbody');

            const dataByMonth = {
                1: [5, 10, 15, 20, 25, 30],
                2: [4, 11, 14, 21, 24, 28],
                3: [6, 12, 16, 22, 26, 32],
                4: [7, 13, 17, 23, 27, 33],
                5: [8, 14, 18, 24, 28, 34],
                6: [9, 15, 19, 25, 29, 35],
                7: [10, 16, 20, 26, 30, 36],
                8: [11, 17, 21, 27, 31, 37],
                9: [12, 18, 22, 28, 32, 38],
                10: [13, 19, 23, 29, 33, 39],
                11: [14, 20, 24, 30, 34, 40],
                12: [15, 21, 25, 31, 35, 41]
            };

            const labels = ['10대 필독도서', '20대 필독도서', '30대 필독도서', '40대 필독도서', '50대 필독도서', '60대 이상 필독도서'];

            let chart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: '도서 출고량',
                        data: dataByMonth[1],
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

            function updateChart(month) {
                chart.data.datasets[0].data = dataByMonth[month];
                chart.update();
            }

            function updateTable(month) {
                bookTableBody.innerHTML = '';
                dataByMonth[month].forEach((books, index) => {
                    const row = document.createElement('tr');
                    const ageCell = document.createElement('td');
                    ageCell.textContent = labels[index];
                    const booksCell = document.createElement('td');
                    booksCell.textContent = books;
                    row.appendChild(ageCell);
                    row.appendChild(booksCell);
                    bookTableBody.appendChild(row);
                });
            }

            monthSelect.addEventListener('change', function () {
                const month = monthSelect.value;
                updateChart(month);
                updateTable(month);
            });

            updateTable(1);
        });




     

    </script>


    <!-- 가장 아래 고정 -->
    <footer>
        <div id="bottom" class="clearfix">

            <div id="logoall">
                <div id="logo" class="left"></div>
                <div id="name" class="left">행복만땅 <br>도서관</div>
            </div>

            <div id="footerinfo">
                Tel : 중앙도서관 : 041-521-3721 신방도서관 : 041-521-3724
                청수도서관 : 041-521-3725 쌍용도서관 : 041-521-3731 두정도서관 : 041-521-3733
            </div>

        </div>
    </footer>
</body>

</html>