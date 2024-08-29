        document.getElementById('selectAll').addEventListener('change', function () {
            const isChecked = this.checked;
            document.querySelectorAll('.select').forEach(checkbox => {
                checkbox.checked = isChecked;
            });
        });
    
        function handleButtonClick(action) {
            const selectedRows = document.querySelectorAll('.select:checked');
            if (selectedRows.length === 0) {
                alert('선택된 항목이 없습니다.');
                return;
            }
    
            if (action === 'buy') {
                selectedRows.forEach(row => {
                    const tr = row.closest('tr');
                    const bookData = {
                        번호: tr.cells[0].innerText,
                        이름: tr.cells[1].innerText,
                        책제목: tr.cells[2].innerText,
                        저자: tr.cells[3].innerText,
                        등록일: tr.cells[4].innerText
                    };
                    console.log('도서 구매:', bookData);
                });
                alert('선택된 도서가 구매 목록에 추가되었습니다.');
            } else if (action === 'delete') {
                selectedRows.forEach(row => {
                    const tr = row.closest('tr');
                    tr.parentNode.removeChild(tr);
                });
                alert('선택된 항목이 삭제되었습니다.');
            }
        }