
        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");

   $(document).ready(function() {
            const ctx = document.getElementById('salesChart').getContext('2d');
            let chart = null;

            $('#monthSelect').change(function() {
                const month = $(this).val();
                if (month) {
                    $.ajax({
                        url: 'monthlySales',
                        type: 'GET',
                        data: { month: month },
                        dataType: 'json',
                        success: function(data) {
                            const labels = data.map(item => `월 ${item.date_id}`);
                            const sales = data.map(item => item.total_sales);

                            if (chart) {
                                chart.destroy(); // 기존 차트를 제거
                            }

                            chart = new Chart(ctx, {
                                type: 'bar',
                                data: {
                                    labels: labels,
                                    datasets: [{
                                        label: '총 매출',
                                        data: sales,
                                        backgroundColor: 'rgba(75, 192, 192, 0.2)',
                                        borderColor: 'rgba(75, 192, 192, 1)',
                                        borderWidth: 1
                                    }]
                                },
                                options: {
                                    scales: {
                                        x: {
                                            beginAtZero: true,
                                            title: {
                                                display: true,
                                                text: '월'
                                            }
                                        },
                                        y: {
                                            beginAtZero: true,
                                            title: {
                                                display: true,
                                                text: '매출'
                                            }
                                        }
                                    }
                                }
                            });
                        },
                        error: function(xhr, status, error) {
                            console.error('Error:', status, error);
                        }
                    });
                }
            });
        });