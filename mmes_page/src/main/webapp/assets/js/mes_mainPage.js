
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
                        label: '필독 도서 수요량',
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




     
