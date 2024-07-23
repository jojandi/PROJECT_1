
        window.onload = function () {
            // page1---------------------------------------------------------
            document.querySelector('#page_1').addEventListener('click', function () {
                document.querySelector('#main_page_1').style.display = 'inline-block';
                // document.querySelector('#page_1').style.
                document.querySelector('#main_page_2').style.display = 'none';
                document.querySelector('#main_page_3').style.display = 'none';
            });
            // page2---------------------------------------------------------
            document.querySelector('#p2_add').addEventListener('click', function () {
                if (document.querySelector('#p2_add_table').style.display !== 'none') {
                    document.querySelector('#p2_add_table').style.display = 'none';
                } else {
                    document.querySelector('#p2_add_table').style.display = 'block';
                }
            })
            document.querySelector('#p2_checkAll').addEventListener('click', function () {
                const isChecked = document.querySelector('#p2_checkAll').checked;
                if (isChecked) {
                    const checkboxes = document.querySelectorAll('.p2_main_chack');

                    for (const checkbox of checkboxes) {
                        checkbox.checked = true;
                    }
                }

                else {
                    const checkboxes = document.querySelectorAll('.p2_main_chack');
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
            document.querySelector('#p2_add_comp').addEventListener('click', function () {
                const table = document.querySelector('#main_Privacy');
                console.log('클릭');
                const newRow = table.insertRow();

                const newCell1 = newRow.insertCell(0);
                const newCell2 = newRow.insertCell(1);
                const newCell3 = newRow.insertCell(2);
                const newCell4 = newRow.insertCell(3);
                const newCell5 = newRow.insertCell(4);
                const newCell6 = newRow.insertCell(5);


                newCell1.innerText = document.querySelector('#p_td_1').value;
                newCell2.innerText = document.querySelector('#p_td_2').value;
                newCell3.innerText = document.querySelector('#p_td_3').value;
                newCell4.innerText = document.querySelector('#p_td_4').value;
                newCell5.innerText = document.querySelector('#p_td_5').value;
                newCell6.innerHTML = '<input type="checkbox" class="p2_main_chack">';
            });
            document.querySelector('#page_2').addEventListener('click', function () {
                document.querySelector('#main_page_2').style.display = 'inline-block';
                document.querySelector('#main_page_1').style.display = 'none';
                document.querySelector('#main_page_3').style.display = 'none';
            });
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
            document.querySelector('#page_3').addEventListener('click', function () {
                document.querySelector('#main_page_3').style.display = 'inline-block';
                document.querySelector('#main_page_1').style.display = 'none';
                document.querySelector('#main_page_2').style.display = 'none';
            });
        };
