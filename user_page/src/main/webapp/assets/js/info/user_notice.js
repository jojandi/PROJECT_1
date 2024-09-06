// 검색어에 따라 테이블을 필터링하는 함수
function filterTable() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("searchInput");  // 검색 입력 필드
    filter = input.value.toLowerCase();  // 검색어를 소문자로 변환
    table = document.getElementById("reportTable");  // 테이블 ID
    tr = table.getElementsByTagName("tr");  // 테이블 행 가져오기

    // 테이블 행을 반복하여 검색 조건에 맞는지 확인
    for (i = 1; i < tr.length; i++) {
        tr[i].style.display = "none";  // 기본적으로 행을 숨김 처리

        td = tr[i].getElementsByTagName("td");
        if (td) {
            for (var j = 0; j < td.length; j++) {  // 각 셀을 반복하여 검사
                if (td[j]) {
                    txtValue = td[j].textContent || td[j].innerText;
                    if (txtValue.toLowerCase().indexOf(filter) > -1) {
                        tr[i].style.display = "";  // 검색어와 일치하면 행을 표시
                        break;  // 검색어와 일치하는 셀이 있으면 다음 행으로 넘어감
                    }
                }
            }
        }
    }
}
