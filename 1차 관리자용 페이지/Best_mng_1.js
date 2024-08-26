window.onload = function () {

    let pi1 = document.querySelector("#sideleft #i1");
    let pi2 = document.querySelector("#sideleft #i2");
    let pi3 = document.querySelector("#sideleft #i3");
    let pi4 = document.querySelector("#sideleft #i4");

    function pageOn() {
        pi1.addEventListener('click', function () {
            window.location.href = "best_we_all.html"
        })
        pi2.addEventListener('click', function () {
            window.location.href = "best_we.html"
        })
        pi3.addEventListener('click', function () {
            window.location.href = "best_we_3.html"
        })

    };
    function openGender() {

        const gender = document.getElementById('myGender');
        gender.style.display = 'block';
        const genderData = {
            labels: ['남성', '여성'],
            datasets: [{
                label: '성별 통계',
                data: [60, 40],
                backgroundColor: [
                    'rgba(54, 162, 235, 0.6)',
                    'rgba(255, 99, 132, 0.6)',
                ],
                borderColor: [
                    'rgba(54, 162, 235, 1)',
                    'rgba(255, 99, 132, 1)',
                ],
                borderWidth: 1
            }]
        };
        const ctx = document.getElementById('genderChart').getContext('2d');
        genderChart = new Chart(ctx, {
            type: 'doughnut',
            data: genderData,
            options: {
                responsive: true,
                legend: {
                    position: 'top',
                },
                title: {
                    display: true,
                    text: '성별 통계',
                    fontSize: 16,
                },
                animation: {
                    animateScale: true,
                    animateRotate: true
                }
            }
        })
    }

    function closeGender() {
        const gender_2 = document.getElementById('myGender');
        gender_2.style.display = 'none';

    }


    function openModal() {
        const modal = document.getElementById('myGraph');
        modal.style.display = 'block';
        const labels = ['10대', '20대', '30대', '40대', '50대'];
        const data = [20, 50, 30, 40, 70];

        const canvas = document.createElement('canvas');
        canvas.id = 'myChart';
        const chartContainer = document.getElementById('chartContainer');
        chartContainer.innerHTML = '';
        chartContainer.appendChild(canvas);

        const ctx = canvas.getContext('2d');
        const myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: labels,
                datasets: [{
                    label: '연령별 사용자',
                    data: data,
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
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    }

    function closeModal() {
        const modal = document.getElementById('myGraph');
        modal.style.display = 'none';
    }


    function openPopup(id) {
        const popup = document.getElementById('popup' + id);
        if (popup) {
            popup.style.display = 'block';
        }
    }



    function closePopup(id) {
        const popup = document.getElementById('popup' + id);
        if (popup) {
            popup.style.display = 'none';
        }
    }
    var existingRow = document.querySelector("#bookTable tbody tr");
    var existingCells = existingRow.querySelectorAll("td");

    document.getElementById("newBookName").value = existingCells[1].textContent.trim();
    document.getElementById("newBookInfo").value = existingCells[2].textContent.trim();
    document.getElementById("newRentalCount").value = existingCells[3].textContent.trim();
    document.getElementById("newLibraryStats").value = existingCells[4].querySelector("button").textContent.trim();
    document.getElementById("newNetflixCount").value = existingCells[5].textContent.trim();
    document.getElementById("newGenderStats").value = existingCells[6].querySelector("button").textContent.trim();
    document.getElementById("newAgeStats").value = existingCells[7].querySelector("button").textContent.trim();


    function addNewBook() {
        var table = document.getElementById("table_1").getElementsByTagName('tbody')[0];

        var newRow = table.insertRow();
        var cells = [];

        for (var i = 0; i < 8; i++) {
            cells.push(newRow.insertCell(i));
        }

        cells[0].innerHTML = '<input type="checkbox" data-delete="checkbox">';
        cells[1].innerText = document.getElementById("newBookName").value;
        cells[2].innerHTML = `<button onclick="openPopup(1)">도서정보 보기</button>
                                <div id="popup1" class="popup">
                                    <div class="popup-header">
                                        <h2>화를 이기는 불편한 심리학</h2>
                                        <span class="popup-close" onclick="closePopup(1)">&times;</span>
                                    </div>
                                    <p>
                                        <img
                                            src="https://cdn.discordapp.com/attachments/1128320143232077876/1265545266891591772/2024-07-24_2.44.42.png?ex=66a1e660&is=66a094e0&hm=7f08d46a4f1e184da2cc114a1821b28011bb55839fc85f40b1bb928e69a0f107&">
                                    </p>
                                    <p>저자: 다카시나 다카유키</p>
                                    <p>출판사: 밀리언서재</p>
                                    <p>출판일: 2024.07.20</p>
                                </div>`
        cells[3].innerText = document.getElementById("newRentalCount").value;
        cells[4].innerHTML = `
            <button onclick="openPopup(6)">통계보기</button>
            <div id="popup6" class="popup" style="display:none;">
                <h2>도서관별 대여 통계</h2>
                <table>
                    <tr>
                        <td>중앙도서관</td>
                        <td>200회</td>
                    </tr>
                    <tr>
                        <td>청수도서관</td>
                        <td>98회</td>
                    </tr>
                    <tr>
                        <td>신방도서관</td>
                        <td>102회</td>
                    </tr>
                    <tr>
                        <td>두정도서관</td>
                        <td>67회</td>
                    </tr>
                    <tr>
                        <td>쌍용도서관</td>
                        <td>87회</td>
                    </tr>
                </table>
            </div>`;
        cells[5].innerText = document.getElementById("newNetflixCount").value;
        cells[6].innerHTML = `
            <button onclick="openGender()">통계 보기</button>
            <div id="myGender" class="gender" style="display:none;">
                <h2>성별 통계</h2>
                <canvas id="genderChart" width="400" height="400"></canvas>
            </div>`;
        cells[7].innerHTML = `
            <button onclick="openModal()">통계보기</button>
            <div id="myGraph" class="graph" style="display:none;">
                <h2>연령별 통계</h2>
                <div id="chartContainer"></div>
            </div>`;
    }
    function selectAllBooks(checkbox) {
        var checkboxes = document.querySelectorAll('input[type="checkbox"][data-delete="checkbox"]');
        checkboxes.forEach(function (cb) {
            cb.checked = checkbox.checked;
        });
        toggleDeleteButton();
    }

    function deleteSelectedBooks() {
        var table = document.getElementById("table_1").getElementsByTagName('tbody')[0];
        var checkboxes = document.querySelectorAll('input[type="checkbox"][data-delete="checkbox"]:checked');

        checkboxes.forEach(function (checkbox) {
            var row = checkbox.closest('tr');
            row.style.display = 'none'; // 선택된 열 숨기기 (실제로 삭제하고 싶을 경우 아래 주석을 해제)
            // table.deleteRow(row.rowIndex);
        });
    }
}