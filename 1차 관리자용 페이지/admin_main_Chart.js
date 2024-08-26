document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('loanRateChart').getContext('2d');
    const loanRateChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['중앙도서관', '청수도서관', '신방도서관', '쌍용도서관', '두정도서관'],
            datasets: [{
                label: '대출률 (%)',
                data: [55, 65, 35, 55, 40], // 예시 데이터
                backgroundColor: [
                    'rgba(255, 99, 132, 0.2)',
                    'rgba(54, 162, 235, 0.2)',
                    'rgba(255, 206, 86, 0.2)',
                    'rgba(75, 192, 192, 0.2)',
                    'rgba(153, 102, 255, 0.2)'
                ],
                borderColor: [
                    'rgba(255, 99, 132, 1)',
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 206, 86, 1)',
                    'rgba(75, 192, 192, 1)',
                    'rgba(153, 102, 255, 1)'
                ],
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
});