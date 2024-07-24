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
    let pi1 = document.querySelector("#side #title");
    let pi2 = document.querySelector("#side #i1");
    let pi3 = document.querySelector("#side #i2");
    let pi4 = document.querySelector("#side #i3");

    pi1.addEventListener('click', function () {
        document.querySelector('#main_page_1').style.display = 'inline-block';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page2
    pi2.addEventListener('click', function () {
        document.querySelector('#main_page_2').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page3
    pi3.addEventListener('click', function () {
        document.querySelector('#main_page_3').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page4
    pi4.addEventListener('click', function () {
        document.querySelector('#main_page_4').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
    });

    const modal = document.getElementById('formModal');
    const openFormButton = document.getElementById('openForm');
    const closeButton = document.querySelector('.close');
    const form = document.getElementById('workForm');

    // 버튼 클릭 시 모달 열기
    openFormButton.addEventListener('click', function () {
        modal.style.display = 'block';
    });

    // 모달 닫기
    closeButton.addEventListener('click', function () {
        modal.style.display = 'none';
    });

    // 창 외부 클릭 시 모달 닫기
    window.addEventListener('click', function (event) {
        if (event.target === modal) {
            modal.style.display = 'none';
        }
    });

    // 폼 제출 시 데이터 추가
    document.querySelector('#workFormBtn').addEventListener('click', function (event) {
        event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지
        console.log('서밋');
        const bookName = document.getElementById('bookName').value;
        const bookId = document.getElementById('bookId').value;
        const workType = document.getElementById('workType').value;
        const workDate = document.getElementById('workDate').value;
        const bookLocation = document.getElementById('bookLocation').value;
        const manager = document.getElementById('manager').value;

        const tableBody = document.querySelector('.main_tbody');
        const newRow = tableBody.insertRow();

        const cell1 = newRow.insertCell(0);
        const cell2 = newRow.insertCell(1);
        const cell3 = newRow.insertCell(2);
        const cell4 = newRow.insertCell(3);
        const cell5 = newRow.insertCell(4);
        const cell6 = newRow.insertCell(5);
        const cell7 = newRow.insertCell(6);
        const cell8 = newRow.insertCell(7);
        const cell9 = newRow.insertCell(8);


        cell1.innerHTML = '<input type="checkbox" class="p2_main_chack">';
        cell2.textContent = bookName;
        cell3.textContent = bookId;
        cell4.textContent = workType;
        cell5.textContent = workDate;
        cell6.innerHTML = '<input type="checkbox" class="p2_main_chack">'
        cell7.textContent = manager;
        cell8.innerHTML = '<input type="checkbox" class="p2_main_chack">'

        const date = new Date(workDate);
        date.setDate(date.getDate() + 7);
        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        const newDate = `${year}-${month}-${day}`;

        cell9.innerText = newDate;


        modal.style.display = 'none';

        form.reset();
    });

    document.querySelector('#btn_1').addEventListener('click', function () {
        console.log('check');
        const table1 = document.querySelector('#main_page_1 .page .table_wrap #main_library tbody');
        const table2 = document.querySelector('#main_page_2 .table_wrap #main_library tbody');
        const checkboxes = document.querySelectorAll('#main_page_1 .page .table_wrap #main_library .p1_main_chack');

        const statusOptions = `
        <option value="검수중">검수중</option>
        <option value="검수 완료">검수 완료</option>
        `;
        const assigneeOptions = `
        <option value="박규태">박규태</option>
        <option value="이제섭">이제섭</option>
        <option value="조민정">조민정</option>
        `;
        const methodOptions = `
        <option value="폐기">폐기</option>
        <option value="수리">수리</option>
        <option value="기부">기부</option>
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
                    const statusSelect = document.createElement('select');
                    statusSelect.innerHTML = statusOptions;
                    statusCell.appendChild(statusSelect);
    
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
        // for (let i = checkboxes.length - 1; i >= 0; i--) {
        //     console.log('작동');
        //     if (checkboxes[i].checked) {
        //         const row = checkboxes[i].closest('tr'); // 체크박스의 상위 <tr> 요소를 찾습니다.

        //         table1.removeChild(row);
        //         table2.appendChild(row);

        //         console.log('작동');
        //     }
        // }

    });




};