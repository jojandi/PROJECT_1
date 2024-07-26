
window.onload = function () {
    // // page1---------------------------------------------------------
    // document.querySelector('#page_1').addEventListener('click', function () {
    //     document.querySelector('#main_page_1').style.display = 'inline-block';
    //     // document.querySelector('#page_1').style.
    //     document.querySelector('#main_page_2').style.display = 'none';
    //     document.querySelector('#main_page_3').style.display = 'none';
    // });
    // page2---------------------------------------------------------
    // document.querySelector('#p2_add').addEventListener('click', function () {
    //     if (document.querySelector('#p2_add_table').style.display !== 'none') {
    //         document.querySelector('#p2_add_table').style.display = 'none';
    //     } else {
    //         document.querySelector('#p2_add_table').style.display = 'block';
    //     }
    // })
    
    // page1 전체선택
    document.querySelector('#p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p1_checkAll').checked;
        const checkboxes = document.querySelectorAll('.p1_main_chack');
        if (isChecked) {
            // const checkboxes = document.querySelectorAll('.p2_main_chack');
            console.log(checkboxes)
            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            // const checkboxes = document.querySelectorAll('.p2_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    });


    // page2 전체선택
    document.querySelector('#p2_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p2_checkAll').checked;
        const checkboxes = document.querySelectorAll('.p2_main_chack');
        if (isChecked) {
            // const checkboxes = document.querySelectorAll('.p2_main_chack');
            console.log(checkboxes)
            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            // const checkboxes = document.querySelectorAll('.p2_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    });
    document.querySelector('#p2_del').addEventListener('click', function () {
        const list = document.querySelectorAll('.p2_main_chack:checked');

        if (list.length === 0) {
            alert("삭제할 항목을 선택해주세요.");
            return;
        }

        const confirmDelete = confirm("선택한 항목을 삭제하시겠습니까?");

        if (confirmDelete) {
            list.forEach(checkbox => {
                const row = checkbox.closest('tr');
                if (row) {
                    row.remove();
                }
            });
        }
    });
    // document.querySelector('#p2_add_comp').addEventListener('click', function () {
    //     const table = document.querySelector('#main_Privacy');
    //     console.log('클릭');
    //     const newRow = table.insertRow();

    //     const newCell1 = newRow.insertCell(0);
    //     const newCell2 = newRow.insertCell(1);
    //     const newCell3 = newRow.insertCell(2);
    //     const newCell4 = newRow.insertCell(3);
    //     const newCell5 = newRow.insertCell(4);
    //     const newCell6 = newRow.insertCell(5);


    //     newCell1.innerText = document.querySelector('#p_td_1').value;
    //     newCell2.innerText = document.querySelector('#p_td_2').value;
    //     newCell3.innerText = document.querySelector('#p_td_3').value;
    //     newCell4.innerText = document.querySelector('#p_td_4').value;
    //     newCell5.innerText = document.querySelector('#p_td_5').value;
    //     newCell6.innerHTML = '<input type="checkbox" class="p2_main_chack">';
    // });
    // page3-----------------------------------------------------------
    document.querySelector('#p3_add').addEventListener('click', function () {
        if (document.querySelector('#p3_add_table').style.display !== 'none') {
            document.querySelector('#p3_add_table').style.display = 'none';
        } else {
            document.querySelector('#p3_add_table').style.display = 'block';
        }
    })
    document.querySelector('#p3_add_comp').addEventListener('click', function () {
        const table = document.querySelector('#main_table');

        const newRow = table.insertRow();

        const newCell1 = newRow.insertCell(0);
        const newCell2 = newRow.insertCell(1);
        const newCell3 = newRow.insertCell(2);
        const newCell4 = newRow.insertCell(3);
        const newCell5 = newRow.insertCell(4);

        newCell1.innerHTML = '<input type="checkbox" class="main_chack">';
        newCell2.innerText = document.querySelector('#td_1').value;
        newCell3.innerText = document.querySelector('#td_2').value;
        newCell4.innerText = document.querySelector('#td_3').value;
        newCell5.innerText = document.querySelector('#td_4').value;
    })
    document.querySelector('#p3_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p3_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('.p3_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }
        else {
            const checkboxes = document.querySelectorAll('.p3_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    document.querySelector('#p3_del').addEventListener('click', function () {
        const list = document.querySelectorAll('.p3_main_chack:checked');

        if (list.length === 0) {
            alert("삭제할 항목을 선택해주세요.");
            return;
        }

        const confirmDelete = confirm("선택한 항목을 삭제하시겠습니까?");

        if (confirmDelete) {
            list.forEach(checkbox => {
                const row = checkbox.closest('tr');
                if (row) {
                    row.remove();
                }
            });
        }
    });
    let pi1 = document.querySelector("#side #title");
    let pi2 = document.querySelector("#side #i1");
    let pi3 = document.querySelector("#side #i2");
    let pi4 = document.querySelector("#side #i3");

    pi2.addEventListener('click', function () {
        document.querySelector('#main_page_1').style.display = 'inline-block';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    // page2
    pi3.addEventListener('click', function () {
        document.querySelector('#main_page_2').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    // page3
    pi4.addEventListener('click', function () {
        document.querySelector('#main_page_3').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        // document.querySelector('#main_page_4').style.display = 'none';
    });
    // page4
    // pi4.addEventListener('click', function () {
    //     document.querySelector('#main_page_4').style.display = 'inline-block';
    //     document.querySelector('#main_page_1').style.display = 'none';
    //     document.querySelector('#main_page_2').style.display = 'none';
    //     document.querySelector('#main_page_3').style.display = 'none';
    // });
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
        const library = document.getElementById('library').value;
        const name = document.getElementById('name').value;
        const number = document.getElementById('number').value;
        const address = document.getElementById('address').value;
        const e_mail = document.getElementById('e_mail').value;
        const date_1 = document.getElementById('date_1').value;

        const tableBody = document.querySelector('.main_tbody');
        const newRow = tableBody.insertRow();

        const cell1 = newRow.insertCell(0);
        const cell2 = newRow.insertCell(1);
        const cell3 = newRow.insertCell(2);
        const cell4 = newRow.insertCell(3);
        const cell5 = newRow.insertCell(4);
        const cell6 = newRow.insertCell(5);
        const cell7 = newRow.insertCell(6);



        cell1.textContent = library;
        cell2.textContent = name;
        cell3.textContent = number;
        cell4.textContent = address;
        cell5.textContent = e_mail;
        cell6.textContent = date_1;
        cell7.innerHTML = '<input type="checkbox" class="p2_main_chack">';


        modal.style.display = 'none';

        form.reset();
    });
};
