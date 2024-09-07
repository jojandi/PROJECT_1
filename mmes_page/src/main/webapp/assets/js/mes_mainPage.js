
        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");
let bookChart = null;  // 도서 출고 통계 차트
let demandChart = null;  // 수요 통계 차트
let forecastChart = null; //수요예측 차트

document.addEventListener('DOMContentLoaded', function() {
    // 도서 출고 통계 이벤트 리스너 추가
    document.getElementById('yearSelect').addEventListener('change', loadBookStatistics);
    document.getElementById('monthSelect').addEventListener('change', loadBookStatistics);

    // 수요 통계 이벤트 리스너 추가
    document.getElementById('yearSelectDemand').addEventListener('change', loadDemandStatistics);
    document.getElementById('monthSelectDemand').addEventListener('change', loadDemandStatistics);

    // 페이지가 로드될 때 두 통계 모두 첫 데이터를 로드
    loadBookStatistics();
    loadDemandStatistics();
});

// 도서 출고 통계 그래프 그리기
function loadBookStatistics() {
    const selectedYear = document.getElementById('yearSelect').value;
    const selectedMonth = document.getElementById('monthSelect').value;

    fetch(`/mmes_page/getBookStatistics?year=${selectedYear}&month=${selectedMonth}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Received book statistics:', data);  // 데이터를 확인하는 콘솔 출력

            if (data.length === 0) {
                console.warn('No book statistics available for the selected year and month.');
                return;
            }

            const labels = data.map(item => item.genre);  // 장르 데이터
            const totals = data.map(item => item.total);  // 출고량 데이터

            const ctx = document.getElementById('bookStatisticsChart').getContext('2d');

            // 기존 차트가 있으면 삭제
            if (bookChart) {
                bookChart.destroy();
            }

            // 새로운 도서 출고 차트 생성
            bookChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: '장르별 도서 출고 수량',
                        data: totals,
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
        })
        .catch(error => {
            console.error('Error fetching the book statistics:', error);
        });
}

// 수요 통계 그래프 그리기
function loadDemandStatistics() {
    const selectedYear = document.getElementById('yearSelectDemand').value;
    const selectedMonth = document.getElementById('monthSelectDemand').value;

    fetch(`/mmes_page/getDemandStatistics?year=${selectedYear}&month=${selectedMonth}`)
        .then(response => response.json())
        .then(data => {
            console.log('Received demand statistics:', data);  // 데이터를 확인하는 콘솔 출력

            if (data.length === 0) {
                console.warn('No demand statistics available for the selected year and month.');
                return;
            }

            const labels = data.map(item => item.genre);  // 장르 데이터
            const demands = data.map(item => item.demand);  // 수요량 데이터

            const ctx = document.getElementById('demandStatisticsChart').getContext('2d');

            // 기존 차트가 있으면 삭제
            if (demandChart) {
                demandChart.destroy();
            }

            // 새로운 수요 통계 차트 생성
            demandChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,
                    datasets: [{
                        label: '장르별 도서 수요량',
                        data: demands,
                        backgroundColor: 'rgba(153, 102, 255, 0.2)',
                        borderColor: 'rgba(153, 102, 255, 1)',
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true,
                              max: 100
                        }
                    }
                }
            });
        })
        .catch(error => {
            console.error('Error fetching demand statistics:', error);
        });
       }
 // 페이지가 로드되면 실행
document.addEventListener('DOMContentLoaded', function() {
    // 수요 예측 통계 이벤트 리스너 추가
    document.getElementById('yearSelectForecast').addEventListener('change', loadForecastStatistics);
    document.getElementById('monthSelectForecast').addEventListener('change', loadForecastStatistics);

    // 페이지 로드 시 첫 데이터를 로드
    loadForecastStatistics();
});

// 수요 예측 통계 그래프 그리기
function loadForecastStatistics() {
    const selectedYear = document.getElementById('yearSelectForecast').value;
    const selectedMonth = document.getElementById('monthSelectForecast').value;

    fetch(`/mmes_page/demandForecast?year=${selectedYear}&month=${selectedMonth}`)
        .then(response => response.json())
        .then(data => {
            console.log('Received forecast statistics:', data); 

            if (data.length === 0) {
                console.warn('No forecast statistics available for the selected period.');
                return;
            }

            const labels = data.map(item => item.genre);  // 장르 데이터
            const expectedDemands = data.map(item => item.expectedDemand);  // 예측 수요량 데이터

            const ctx = document.getElementById('forecastStatisticsChart').getContext('2d');

            // 기존 차트가 있으면 삭제
            if (forecastChart) {
                forecastChart.destroy();
            }

            // 새로운 수요 예측 차트 생성
            forecastChart = new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: labels,  // 장르명
                    datasets: [{
                        label: '예측 수요량',
                        data: expectedDemands,
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
        })
        .catch(error => {
            console.error('Error fetching forecast statistics:', error);
        });
}