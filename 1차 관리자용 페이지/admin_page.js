window.onload = function () {
    // page1
    document.querySelector('#p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p1_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('.p1_main_chack');

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
    document.querySelector('#btn_1').addEventListener('click', function () {
        const isChecked = document.querySelector('.p1_main_chack')
        if (isChecked) {

        }
    })
    
    document.querySelector('#p2_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p2_checkAll').checked;
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

    document.querySelector('#btn_2').addEventListener('click', function () {
        
        
        // 페이지 2의 테이블에서 tbody 요소 가져오기
        const page2TableBody = document.querySelector('#main_page_2 table tbody');

        // 페이지 3의 테이블에서 tbody 요소 가져오기
        const page3TableBody = document.querySelector('#main_page_3 table tbody');

        // 페이지 2의 tbody에서 체크된 행만 가져와서 페이지 3의 형식에 맞춰 추가
        Array.from(page2TableBody.rows).forEach(row => {
            const checkbox = row.cells[0].querySelector('input[type="checkbox"]');
            if (checkbox && checkbox.checked) {
                const cells = row.cells;
                const newRow = page3TableBody.insertRow();

                // 페이지 3의 테이블 형식에 맞게 셀 추가
                newRow.insertCell().appendChild(document.createElement('input')).type = 'checkbox'; // 체크박스
                newRow.insertCell().innerText = cells[1].innerText; // 도서명
                newRow.insertCell().innerText = cells[2].innerText; // 도서 ID

                // 불량 유형 - 셀렉트 박스의 선택된 값
                const defectType = cells[8].querySelector('select');
                if (defectType) {
                    newRow.insertCell().innerText = defectType.value;
                } else {
                    newRow.insertCell().innerText = cells[8].innerText;
                }

                newRow.insertCell().innerText = cells[4].innerText; // 발생 일자
                newRow.insertCell().innerText = "작업 완료";

                // 처리 담당자 - 셀렉트 박스의 선택된 값
                const handler = cells[7].querySelector('select');
                if (handler) {
                    newRow.insertCell().innerText = handler.value;
                } else {
                    newRow.insertCell().innerText = cells[7].innerText;
                }

                newRow.insertCell().innerHTML = `<select>
                                                <option value="폐기">폐기</option>
                                                <option value="복구완료">복구완료</option>
                                                <option value="기부">기부</option>
                                                </select>`; // 처리 상태 (빈 값으로 두기)
                newRow.insertCell().innerText = "2024-07-30" // 처리 기한

                // 체크된 행을 페이지 2의 테이블에서 제거
                row.remove();
            }
        });
    });
    // document.querySelector('#btn_2').addEventListener('click', function () {
    //     console.log('check');
    //     const table1 = document.querySelector('#main_page_2 .table_wrap #main_library tbody');
    //     const table2 = document.querySelector('#main_page_3 .table_wrap #main_library tbody');
    //     const checkboxes = document.querySelectorAll('#main_page_2 .table_wrap #main_library .p1_main_chack');

    //     const statusOptions = `
    //     <option value="검수중">검수중</option>
    //     <option value="검수 완료">검수 완료</option>
    //     `;
    //     const assigneeOptions = `
    //     <option value="박규태">박규태</option>
    //     <option value="이제섭">이제섭</option>
    //     <option value="조민정">조민정</option>
    //     `;
    //     const methodOptions = `
    //     <option value="표지훼손">표지훼손</option>
    //     <option value="페이지훼손">페이지훼손</option>
    //     <option value="기부">기부</option>
    //     `;

    //     for (let i = checkboxes.length - 1; i >= 0; i--) {
    //         console.log('작동');
    //         if (checkboxes[i].checked) {
    //             const row = checkboxes[i].closest('tr'); // 체크박스의 상위 <tr> 요소를 찾습니다.

    //             if (row) {
    //                 // 테이블1에서 행 제거
    //                 table1.removeChild(row);

    //                 // 새로운 셀을 생성하여 추가합니다.
    //                 const statusCell = document.createElement('td');
    //                 const statusSelect = document.createElement('select');
    //                 statusSelect.innerHTML = statusOptions;
    //                 statusCell.appendChild(statusSelect);

    //                 const assigneeCell = document.createElement('td');
    //                 const assigneeSelect = document.createElement('select');
    //                 assigneeSelect.innerHTML = assigneeOptions;
    //                 assigneeCell.appendChild(assigneeSelect);

    //                 const methodCell = document.createElement('td');
    //                 const methodSelect = document.createElement('select');
    //                 methodSelect.innerHTML = methodOptions;
    //                 methodCell.appendChild(methodSelect);

    //                 const dueDateCell = document.createElement('td');
    //                 const dueDateInput = document.createElement('input');
    //                 dueDateInput.type = 'date';
    //                 dueDateCell.appendChild(dueDateInput);

    //                 // 기존 행의 내용을 복사하여 새 행을 생성합니다.
    //                 const newRow = document.createElement('tr');
    //                 newRow.innerHTML = row.innerHTML; // 기존의 셀을 복사합니다.
    //                 newRow.appendChild(statusCell);
    //                 newRow.appendChild(assigneeCell);
    //                 newRow.appendChild(methodCell);
    //                 newRow.appendChild(dueDateCell);

    //                 // 테이블2에 새 행 추가
    //                 table2.appendChild(newRow);

    //                 console.log('작동');
    //             }
    //         }
    //     }
    // });
    // page3
    

    // const modal = document.getElementById('formModal');
    // const openFormButton = document.getElementById('openForm');
    // const closeButton = document.querySelector('.close');
    // const form = document.getElementById('workForm');

    // // 버튼 클릭 시 모달 열기
    // openFormButton.addEventListener('click', function () {
    //     modal.style.display = 'block';
    // });

    // // 모달 닫기
    // closeButton.addEventListener('click', function () {
    //     modal.style.display = 'none';
    // });

    // // 창 외부 클릭 시 모달 닫기
    // window.addEventListener('click', function (event) {
    //     if (event.target === modal) {
    //         modal.style.display = 'none';
    //     }
    // });

    // // 폼 제출 시 데이터 추가
    // document.querySelector('#workFormBtn').addEventListener('click', function (event) {
    //     event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지
    //     console.log('서밋');
    //     const bookName = document.getElementById('bookName').value;
    //     const bookId = document.getElementById('bookId').value;
    //     const workType = document.getElementById('workType').value;
    //     const workDate = document.getElementById('workDate').value;
    //     const bookLocation = document.getElementById('bookLocation').value;
    //     const manager = document.getElementById('manager').value;

    //     const tableBody = document.querySelector('.main_tbody');
    //     const newRow = tableBody.insertRow();

    //     const cell1 = newRow.insertCell(0);
    //     const cell2 = newRow.insertCell(1);
    //     const cell3 = newRow.insertCell(2);
    //     const cell4 = newRow.insertCell(3);
    //     const cell5 = newRow.insertCell(4);
    //     const cell6 = newRow.insertCell(5);
    //     const cell7 = newRow.insertCell(6);
    //     const cell8 = newRow.insertCell(7);
    //     const cell9 = newRow.insertCell(8);


    //     cell1.innerHTML = '<input type="checkbox" class="p2_main_chack">';
    //     cell2.textContent = bookName;
    //     cell3.textContent = bookId;
    //     cell4.textContent = workType;
    //     cell5.textContent = workDate;
    //     cell6.innerHTML = '<input type="checkbox" class="p2_main_chack">'
    //     cell7.textContent = manager;
    //     cell8.innerHTML = '<input type="checkbox" class="p2_main_chack">'

    //     const date = new Date(workDate);
    //     date.setDate(date.getDate() + 7);
    //     const year = date.getFullYear();
    //     const month = String(date.getMonth() + 1).padStart(2, '0');
    //     const day = String(date.getDate()).padStart(2, '0');
    //     const newDate = `${year}-${month}-${day}`;

    //     cell9.innerText = newDate;

    //     modal.style.display = 'none';

    //     form.reset();
    // });

    document.querySelector('#btn_1').addEventListener('click', function () {
        console.log('check');
        const table1 = document.querySelector('#main_page_1 .page .table_wrap #main_library tbody');
        const table2 = document.querySelector('#main_page_2 .table_wrap #main_library tbody');
        const checkboxes = document.querySelectorAll('#main_page_1 .page .table_wrap #main_library .p1_main_chack');
    
        const assigneeOptions = `
            <option value="박규태">박규태</option>
            <option value="이제섭">이제섭</option>
            <option value="조민정">조민정</option>
            <option value="김아영">김아영</option>
        `;
        const methodOptions = `
            <option value="표지훼손">표지훼손</option>
            <option value="페이지훼손">페이지훼손</option>
            <option value="페이지오염">페이지오염</option>
        `;
    
        for (let i = checkboxes.length - 1; i >= 0; i--) {
            console.log('작동');
            if (checkboxes[i].checked) {
                const row = checkboxes[i].closest('tr'); // 체크박스의 상위 <tr> 요소를 찾습니다.
    
                if (row) {
                    // 테이블1에서 행 제거
                    table1.removeChild(row);
    
                    // 새로운 셀을 생성하여 추가합니다.
                    const statusCell = document.createElement('td');
                    statusCell.textContent = '검수 완료'; // 검수 완료 텍스트 추가
    
                    const assigneeCell = document.createElement('td');
                    const assigneeSelect = document.createElement('select');
                    assigneeSelect.innerHTML = assigneeOptions;
                    assigneeCell.appendChild(assigneeSelect);
    
                    const methodCell = document.createElement('td');
                    const methodSelect = document.createElement('select');
                    methodSelect.innerHTML = methodOptions;
                    methodCell.appendChild(methodSelect);
    
                    const dueDateCell = document.createElement('td');
                    const dueDateInput = document.createElement('input');
                    dueDateInput.type = 'date';
                    dueDateCell.appendChild(dueDateInput);
    
                    // 기존 행의 내용을 복사하여 새 행을 생성합니다.
                    const newRow = document.createElement('tr');
                    newRow.innerHTML = row.innerHTML; // 기존의 셀을 복사합니다.
                    newRow.appendChild(statusCell);
                    newRow.appendChild(assigneeCell);
                    newRow.appendChild(methodCell);
                    newRow.appendChild(dueDateCell);
    
                    // 테이블2에 새 행 추가
                    table2.appendChild(newRow);
    
                    console.log('작동');
                }
            }
        }
    });




};