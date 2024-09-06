document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput'); // 검색 입력 필드
    const table = document.getElementById('main_library2'); // 테이블 ID 선택
    const rows = table.querySelectorAll('tbody tr'); // 테이블의 모든 행 선택

    // 검색 기능
    searchInput.addEventListener('input', function () {
        const query = searchInput.value.toLowerCase(); // 입력 값을 소문자로 변환

        rows.forEach(row => {
            const bookTitleCell = row.querySelector('.sortable'); // 도서명이 포함된 셀
            const bookTitle = bookTitleCell.textContent.toLowerCase(); // 도서명을 소문자로 변환
            if (bookTitle.includes(query)) {
                row.style.display = ''; // 검색어가 포함된 경우 행을 보여줌
            } else {
                row.style.display = 'none'; // 검색어가 포함되지 않은 경우 행을 숨김
            }
        });
    });
});