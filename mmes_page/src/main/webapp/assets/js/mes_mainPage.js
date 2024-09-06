
        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");

// scripts.js
document.addEventListener('DOMContentLoaded', function () {
    // 차트 컨텍스트
    const ctxBar = document.getElementById('barChart').getContext('2d');
    const ctxLine = document.getElementById('lineChart').getContext('2d');
    const ctxShipment = document.getElementById('shipmentChart').getContext('2d');
    
    // 셀렉트 요소
    const monthSelectDemand = document.getElementById('monthSelectDemand');
    const monthSelectForecast = document.getElementById('monthSelectForecast');
    const monthSelectShipment = document.getElementById('monthSelectShipment');

    // 데이터
    const dataByMonthDemand = {
        1: [5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55],
        2: [4, 11, 14, 21, 24, 28, 33, 38, 43, 48, 53],
        3: [6, 12, 16, 22, 26, 32, 37, 42, 47, 52, 57],
        4: [7, 13, 17, 23, 27, 33, 38, 43, 48, 53, 58],
        5: [8, 14, 18, 24, 28, 34, 39, 44, 49, 54, 59],
        6: [9, 15, 19, 25, 29, 35, 40, 45, 50, 55, 60],
        7: [10, 16, 20, 26, 30, 36, 41, 46, 51, 56, 61],
        8: [11, 17, 21, 27, 31, 37, 42, 47, 52, 57, 62],
        9: [12, 18, 22, 28, 32, 38, 43, 48, 53, 58, 63],
        10: [13, 19, 23, 29, 33, 39, 44, 49, 54, 59, 64],
        11: [14, 20, 24, 30, 34, 40, 45, 50, 55, 60, 65],
        12: [15, 21, 25, 31, 35, 41, 46, 51, 56, 61, 66]
    };

    const dataByMonthForecast = {
        1: [6, 11, 16, 23, 28, 34, 40, 46, 52, 58, 64],
        2: [5, 12, 18, 25, 30, 35, 42, 48, 54, 60, 66],
        3: [7, 13, 20, 27, 32, 37, 44, 50, 56, 62, 68],
        4: [8, 14, 21, 28, 33, 39, 46, 52, 58, 64, 70],
        5: [9, 15, 22, 29, 34, 40, 47, 53, 59, 65, 71],
        6: [10, 16, 23, 30, 35, 41, 48, 54, 60, 66, 72],
        7: [11, 17, 24, 31, 36, 42, 49, 55, 61, 67, 73],
        8: [12, 18, 25, 32, 37, 43, 50, 56, 62, 68, 74],
        9: [13, 19, 26, 33, 38, 44, 51, 57, 63, 69, 75],
        10: [14, 20, 27, 34, 39, 45, 52, 58, 64, 70, 76],
        11: [15, 21, 28, 35, 40, 46, 53, 59, 65, 71, 77],
        12: [16, 22, 29, 36, 41, 47, 54, 60, 66, 72, 78]
    };

    const dataByMonthShipment = {
        1: [8, 14, 20, 26, 32, 38, 44, 50, 56, 62, 68],
        2: [7, 13, 19, 25, 31, 37, 43, 49, 55, 61, 67],
        3: [9, 15, 21, 27, 33, 39, 45, 51, 57, 63, 69],
        4: [10, 16, 22, 28, 34, 40, 46, 52, 58, 64, 70],
        5: [11, 17, 23, 29, 35, 41, 47, 53, 59, 65, 71],
        6: [12, 18, 24, 30, 36, 42, 48, 54, 60, 66, 72],
        7: [13, 19, 25, 31, 37, 43, 49, 55, 61, 67, 73],
        8: [14, 20, 26, 32, 38, 44, 50, 56, 62, 68, 74],
        9: [15, 21, 27, 33, 39, 45, 51, 57, 63, 69, 75],
        10: [16, 22, 28, 34, 40, 46, 52, 58, 64, 70, 76],
        11: [17, 23, 29, 35, 41, 47, 53, 59, 65, 71, 77],
        12: [18, 24, 30, 36, 42, 48, 54, 60, 66, 72, 78]
    };

    // 차트 생성
    let barChart = new Chart(ctxBar, {
        type: 'bar',
        data: {
            labels: ['언론추천', '소설추천', '역사추천', '인문학 추천', '자기계발추천', '무협추천', '만화추천', '판타지추천', '로맨스 추천', '추리추천', '스릴러추천'],
            datasets: [{
                label: '도서 수요량',
                data: dataByMonthDemand[1],
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

    let lineChart = new Chart(ctxLine, {
        type: 'line',
        data: {
            labels: ['언론추천', '소설추천', '역사추천', '인문학 추천', '자기계발추천', '무협추천', '만화추천', '판타지추천', '로맨스 추천', '추리추천', '스릴러추천'],
            datasets: [{
                label: '도서 수요 예측량',
                data: dataByMonthForecast[1],
                backgroundColor: 'rgba(75, 192, 192, 0.2)', // 배경 색상
                borderColor: 'rgba(75, 192, 192, 1)', // 선 색상
                borderWidth: 2, // 선 두께
                pointBackgroundColor: 'rgba(75, 192, 192, 1)', // 점 색상
                pointBorderColor: '#fff', // 점 테두리 색상
                pointBorderWidth: 2, // 점 테두리 두께
                pointRadius: 5, // 점 크기
                fill: false // 선 그래프 아래 색칠 여부
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

    let shipmentChart = new Chart(ctxShipment, {
        type: 'bar',
        data: {
            labels: ['언론추천', '소설추천', '역사추천', '인문학 추천', '자기계발추천', '무협추천', '만화추천', '판타지추천', '로맨스 추천', '추리추천', '스릴러추천'],
            datasets: [{
                label: '도서 출고량',
                data: dataByMonthShipment[1],
                backgroundColor: 'rgba(255, 159, 64, 0.2)',
                borderColor: 'rgba(255, 159, 64, 1)',
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

    // 차트 업데이트 함수
    function updateChart(chart, data) {
        chart.data.datasets[0].data = data;
        chart.update();
    }

    // 이벤트 리스너
    monthSelectDemand.addEventListener('change', function () {
        const month = monthSelectDemand.value;
        updateChart(barChart, dataByMonthDemand[month]);
    });

    monthSelectForecast.addEventListener('change', function () {
        const month = monthSelectForecast.value;
        updateChart(lineChart, dataByMonthForecast[month]);
    });

    monthSelectShipment.addEventListener('change', function () {
        const month = monthSelectShipment.value;
        updateChart(shipmentChart, dataByMonthShipment[month]);
    });
});
