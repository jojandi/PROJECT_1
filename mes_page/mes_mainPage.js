// chart.js
document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('productionChart').getContext('2d');

    // Example data: hourly production for each line (24 hours)
    const dataByHour = {
        '1번 라인': [120, 130, 125, 140, 150, 160, 155, 145, 140, 135, 150, 160, 170, 180, 190, 200, 210, 220, 230, 240, 250, 260, 270, 280],
        '2번 라인': [110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215, 220, 225],
        '3번 라인': [100, 105, 110, 115, 120, 125, 130, 135, 140, 145, 150, 155, 160, 165, 170, 175, 180, 185, 190, 195, 200, 205, 210, 215]
    };

    // Generate hourly labels from 00:00 to 23:00
    const hours = Array.from({ length: 24 }, (_, i) => `${i}:00`);

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: hours,
            datasets: Object.keys(dataByHour).map((lineName, index) => ({
                label: lineName,
                data: dataByHour[lineName],
                borderColor: `hsl(${index * 120}, 70%, 50%)`, // Different color for each line
                backgroundColor: `hsla(${index * 120}, 70%, 50%, 0.2)`, // Semi-transparent background for better visibility
                borderWidth: 2,
                fill: false // No fill under the line
            }))
        },
        options: {
            responsive: true,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: '시간'
                    },
                    ticks: {
                        autoSkip: false, // Show all tick labels
                        maxRotation: 90 // Rotate labels to fit
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: '생산량'
                    },
                    beginAtZero: true
                }
            },
            plugins: {
                legend: {
                    position: 'top'
                },
                tooltip: {
                    mode: 'index',
                    intersect: false
                }
            }
        }
    });
});

// chart.js
document.addEventListener('DOMContentLoaded', function () {
    const ctx = document.getElementById('progressChart').getContext('2d');

    // Example data: work progress for each age group
    const dataByAgeGroup = {
        '10대 필독도서': 75,
        '20대 필독도서': 85,
        '30대 필독도서': 65,
        '40대 필독도서': 70,
        '50대 필독도서': 60,
        '60대 이상 필독도서': 50
    };

    const ageGroups = Object.keys(dataByAgeGroup);
    const progressData = Object.values(dataByAgeGroup);

    // Create the chart
    new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ageGroups,
            datasets: [{
                label: 'Work Progress (%)',
                data: progressData,
                backgroundColor: 'rgba(75, 192, 192, 0.2)', // Light green background
                borderColor: 'rgba(75, 192, 192, 1)', // Dark green border
                borderWidth: 1
            }]
        },
        options: {
            responsive: true,
            scales: {
                x: {
                    title: {
                        display: true,
                        text: '연령대별 필독도서'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: '작엽진행률 (%)'
                    },
                    beginAtZero: true,
                    max: 100
                }
            },
            plugins: {
                legend: {
                    display: false
                },
                tooltip: {
                    mode: 'index',
                    intersect: false
                }
            }
        }
    });
});
