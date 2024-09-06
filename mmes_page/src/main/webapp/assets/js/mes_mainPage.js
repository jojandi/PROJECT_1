
        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");

document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('yearSelect').addEventListener('change', loadBookStatistics);
    document.getElementById('monthSelect').addEventListener('change', loadBookStatistics);
});

// Chart 객체를 전역 변수로 선언
let chart;

function loadBookStatistics() {
    // 선택된 연도와 월을 가져옴
    const selectedYear = document.getElementById('yearSelect').value;
    const selectedMonth = document.getElementById('monthSelect').value;

    // 서버에서 연도와 월에 맞는 데이터를 가져옴
   fetch(`/mmes_page/getBookStatistics?year=${selectedYear}&month=${selectedMonth}`)

        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Received data:', data);

            if (data.length === 0) {
                console.warn('No data available for the selected year and month.');
                return;
            }

            // 장르별 데이터 추출
            const labels = data.map(item => item.genre);
            const totals = data.map(item => item.total);

            // Chart.js로 그래프 그리기
            const ctx = document.getElementById('bookStatisticsChart').getContext('2d');

            // 이전에 그려진 차트가 있으면 삭제하고 새로 그리기
            if (chart) {
                chart.destroy();
            }

            chart = new Chart(ctx, {
                type: 'bar',  // 막대 그래프
                data: {
                    labels: labels,  // x축: 장르명
                    datasets: [{
                        label: '장르별 도서 출고 수량',
                        data: totals,  // y축: 총 출고 수량
                        backgroundColor: 'rgba(75, 192, 192, 0.2)',  // 막대 색상
                        borderColor: 'rgba(75, 192, 192, 1)',  // 막대 테두리 색상
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true  // y축 0부터 시작
                        }
                    }
                }
            });
        })
        .catch(error => {
            console.error('Error fetching the statistics:', error);
        });
}