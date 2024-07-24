window.onload = function () {
    const searchInput = document.getElementById('searchInput');
    const showAllBtn = document.getElementById('showAllBtn');
    const table = document.querySelector('#main_page_1 #main_library tbody');
    const rows = table.querySelectorAll('tr');

    // 검색 기능
    searchInput.addEventListener('input', function () {
        const query = searchInput.value.toLowerCase();

        rows.forEach(row => {
            const bookTitle = row.querySelector('td').textContent.toLowerCase();
            if (bookTitle.includes(query)) {
                row.style.display = '';
            } else {
                row.style.display = 'none';
            }
        });
    });

    let pi1 = document.querySelector("#side #title");
    let pi2 = document.querySelector("#side #i1");
    let pi3 = document.querySelector("#side #i2");
    let pi4 = document.querySelector("#side #i3");

    pi1.addEventListener('click', function () {
        document.querySelector('#main_page_1').style.display = 'inline-block';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    // 전체선택
    document.querySelector('#main_page_1 #p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#main_page_1 #p1_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('#main_page_1 .p1_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            const checkboxes = document.querySelectorAll('.p1_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    // page2
    pi2.addEventListener('click', function () {
        document.querySelector('#main_page_2').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    // 전체선택
    document.querySelector('#main_page_2 #p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#main_page_2 #p1_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('#main_page_2 .p1_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            const checkboxes = document.querySelectorAll('#main_page_2 .p1_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    // page3
    pi3.addEventListener('click', function () {
        document.querySelector('#main_page_3').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    document.querySelector('#main_page_3 #p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#main_page_3 #p1_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('#main_page_3 .p1_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            const checkboxes = document.querySelectorAll('#main_page_3 .p1_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    document.querySelector('#main_page_3 #p2_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#main_page_3 #p2_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('#main_page_3 .p2_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            const checkboxes = document.querySelectorAll('#main_page_3 .p2_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    document.querySelector('#main_page_3 #page3_btn_1').addEventListener('click', function () {
        const table1 = document.querySelector('#main_page_3 #main_library_1 tbody');
        const table2 = document.querySelector('#main_page_3 #main_library_2 tbody');
        const checkboxes = document.querySelectorAll('#main_page_3 #main_library_1 .p1_main_chack');

        let allInputsValid = true;

        checkboxes.forEach(checkbox => {
            if (checkbox.checked) {
                const row = checkbox.closest('tr');
                const inputField = row.querySelector('td input[type="text"]');

                if (inputField.value.trim() === '') {
                    allInputsValid = false;
                }
            }
        });

        if (!allInputsValid) {
            alert('정확한 값을 입력해주세요');
            return;
        }

        for (let i = checkboxes.length - 1; i >= 0; i--) {
            if (checkboxes[i].checked) {
                const row = checkboxes[i].closest('tr');
                const inputField = row.querySelector('td input[type="text"]');
                const inputValue = inputField.value.trim();

                // 테이블1에서 행 제거
                table1.removeChild(row);

                // 테이블2에 행 추가
                const newRow = document.createElement('tr');

                // 기존 셀들 복사
                for (let j = 0; j < row.cells.length; j++) {
                    const newCell = document.createElement('td');
                    if (j === 0) {
                        // 첫 번째 셀은 체크박스
                        newCell.innerHTML = '<input type="checkbox" class="p2_main_chack">';
                    } else if (j === row.cells.length - 1) {
                        // 마지막 셀은 텍스트로 설정
                        newCell.innerText = inputValue;
                    } else {
                        newCell.innerHTML = row.cells[j].innerHTML;
                    }
                    newRow.appendChild(newCell);
                }

                table2.appendChild(newRow);
            }
        }
    });
    document.querySelector('.sortable').addEventListener('click', function () {
        // 클릭된 열의 인덱스 가져오기
        const header = this;
        const index = Array.from(header.parentNode.children).indexOf(header);

        // 각 페이지의 테이블을 정렬합니다
        ['main_page_1', 'main_page_2', 'main_page_3'].forEach(pageId => {
            // 현재 페이지의 테이블 가져오기
            const table = document.querySelector(`#${pageId} #main_library`);
            if (table) {
                sortByTitle(table, index);
            }
        });
    });

    // 도서명으로 정렬하는 함수
    function sortByTitle(table, index) {
        const tbody = table.querySelector('tbody');
        const rows = Array.from(tbody.querySelectorAll('tr'));

        // 정렬
        rows.sort((a, b) => {
            const aText = a.cells[index].innerText.trim();
            const bText = b.cells[index].innerText.trim();
            return aText.localeCompare(bText);
        });

        // 정렬된 행을 테이블에 다시 추가
        rows.forEach(row => tbody.appendChild(row));
    }
    // page4
    // pi4.addEventListener('click', function () {
    //     document.querySelector('#main_page_4').style.display = 'inline-block';
    //     document.querySelector('#main_page_1').style.display = 'none';
    //     document.querySelector('#main_page_2').style.display = 'none';
    //     document.querySelector('#main_page_3').style.display = 'none';
    // });
}

