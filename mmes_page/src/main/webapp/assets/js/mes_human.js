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
  document.addEventListener('DOMContentLoaded', function() {
            const checkAll = document.getElementById('p1_checkAll');
            const checkboxes = document.querySelectorAll('.emp_checkbox');

            // 전체 선택 체크박스의 상태가 변경될 때
            checkAll.addEventListener('change', function() {
                // 전체 선택 체크박스의 상태에 맞게 모든 개별 체크박스의 체크 상태를 변경
                checkboxes.forEach(checkbox => {
                    checkbox.checked = checkAll.checked;
                });
            });

            // 개별 체크박스가 하나라도 변경될 때
            checkboxes.forEach(checkbox => {
                checkbox.addEventListener('change', function() {
                    // 모든 개별 체크박스의 상태를 체크
                    const allChecked = Array.from(checkboxes).every(checkbox => checkbox.checked);
                    const anyChecked = Array.from(checkboxes).some(checkbox => checkbox.checked);

                    // 전체 선택 체크박스의 상태를 업데이트
                    checkAll.checked = allChecked;
                    checkAll.indeterminate = !allChecked && anyChecked;
                });
            });
        });
}
