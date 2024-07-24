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
    document.querySelector('#page_1').addEventListener('click', function () {
        document.querySelector('#main_page_1').style.display = 'inline-block';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page2
    document.querySelector('#page_2').addEventListener('click', function () {
        document.querySelector('#main_page_2').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page3
    document.querySelector('#page_3').addEventListener('click', function () {
        document.querySelector('#main_page_3').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page4
    document.querySelector('#page_4').addEventListener('click', function () {
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
    form.addEventListener('submit', function (event) {
        event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지

        const bookId = document.getElementById('bookId').value;
        const workDetails = document.getElementById('workDetails').value;
        const workDate = document.getElementById('workDate').value;

        // 테이블에 새로운 행 추가
        const tableBody = document.querySelector('#workTable tbody');
        const newRow = tableBody.insertRow();

        const cell1 = newRow.insertCell(0);
        const cell2 = newRow.insertCell(1);
        const cell3 = newRow.insertCell(2);

        cell1.textContent = bookId;
        cell2.textContent = workDetails;
        cell3.textContent = workDate;

        // 모달 닫기
        modal.style.display = 'none';

        // 폼 초기화
        form.reset();
    });

    
};