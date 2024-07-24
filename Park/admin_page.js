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
    document.querySelector('#btn_1').addEventListener('click',function(){
        const isChecked = document.querySelector('.p1_main_chack')
        if(isChecked){
            
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


};