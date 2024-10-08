window.onload = function () {
     const modal = document.getElementById('formModal');
    const openFormButton = document.getElementById('openForm');
    const closeButton = document.querySelector('.close');
    const form = document.getElementById('workForm');

    // 버튼 클릭 시 모달 열기
    openFormButton.addEventListener('click', function () {
        modal.style.display = 'block';
        console.log("클릭");
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
    document.getElementById('searchInput').addEventListener('keyup', function() {
    let filter = this.value.toUpperCase();
    let table = document.getElementById('main_library');
    let tr = table.getElementsByTagName('tr');

    // 테이블의 모든 행을 반복하여 검색어와 일치하는지 확인
    for (let i = 1; i < tr.length; i++) { // 첫 번째 행(헤더)은 건너뜀
        let tdArray = tr[i].getElementsByTagName('td');
        let isMatch = false;

        // 각 열의 텍스트 값을 검색어와 비교
        for (let j = 0; j < tdArray.length; j++) {
            let td = tdArray[j];
            if (td) {
                let txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    isMatch = true;
                    break;
                }
            }
        }

        // 검색어와 일치하는 열이 있으면 해당 행을 표시, 그렇지 않으면 숨김
        if (isMatch) {
            tr[i].style.display = "";
        } else {
            tr[i].style.display = "none";
        }
    }
});
   
   
}
    