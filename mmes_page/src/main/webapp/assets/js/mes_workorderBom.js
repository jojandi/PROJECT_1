window.onload = function () {
    const searchInput = document.getElementById('searchInput');
    const table = document.querySelector('#main_page_1 #main_library tbody');


    
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
    
    // 작업지시서 생성 버튼 누를 시 모달6 화면 추가 스크립트
    let addbom = document.getElementById('addbom');
    let span2 = document.getElementsByClassName('close_6')[0];
    let modal6 = document.getElementById('modal_6');

    addbom.onclick = function () {
        modal6.style.display = 'block';
    }

    span2.onclick = function () {
        modal6.style.display = 'none';
    }

    window.onclick = function (event) {
        if (event.target === modal6) {
            modal6.style.display = 'none';
        }
    }
}

 