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

    document.querySelector('#workFormBtn').addEventListener('click', function (event) {
        event.preventDefault(); // 폼 제출 시 페이지 새로고침 방지
        console.log('서밋');
    
        const bookTitle = document.getElementById('book_title').value;
        const isbn = document.getElementById('isbn').value;
        const publisher = document.getElementById('publisher').value;
        const author = document.getElementById('author').value;
        const quantity = document.getElementById('quantity').value;
        const order_Date = document.getElementById('order_Date').value;
       
    
        const tableBody = document.querySelector('.main_tbody');
        const newRow = tableBody.insertRow();
    
        const cell1 = newRow.insertCell(0);
        const cell2 = newRow.insertCell(1);
        const cell3 = newRow.insertCell(2);
        const cell4 = newRow.insertCell(3);
        const cell5 = newRow.insertCell(4);
        const cell6 = newRow.insertCell(5);
        const cell7 = newRow.insertCell(6);
        
        cell1.innerHTML = '<input type="checkbox" class="p2_main_check">';
        cell2.textContent = bookTitle;
        cell3.textContent = isbn;
        cell4.textContent = author;
        cell5.textContent = publisher;
        cell6.textContent = quantity;
        cell7.textContent = order_Date;
    
        modal.style.display = 'none';
        form.reset();
    });


    // 페이지 이동
    const items = document.querySelectorAll('.item');
    
    items.forEach(item => {
        item.addEventListener('click', function() {
            console.log('클릭');
            // 모든 항목의 색상 초기화
            items.forEach(i => {
                const icon = i.querySelector('.material-symbols-outlined');
                if (icon) {
                    icon.classList.remove('active');
                }
            });

            // 클릭된 항목에 색상 적용
            const clickedIcon = this.querySelector('.material-symbols-outlined');
            if (clickedIcon) {
                clickedIcon.classList.add('active');
            }

            // 페이지 전환 로직 추가
            const itemId = this.id;
            if (itemId === 'i1') {
                document.querySelector('#main_page_1').style.display = 'inline-block';
                document.querySelector('#main_page_2').style.display = 'none';
                document.querySelector('#main_page_3').style.display = 'none';
                // document.querySelector('#main_page_4').style.display = 'none';
            } else if (itemId === 'i2') {
                document.querySelector('#main_page_2').style.display = 'inline-block';
                document.querySelector('#main_page_1').style.display = 'none';
                document.querySelector('#main_page_3').style.display = 'none';
                // document.querySelector('#main_page_4').style.display = 'none';
            } else if (itemId === 'i3') {
                document.querySelector('#main_page_3').style.display = 'inline-block';
                document.querySelector('#main_page_1').style.display = 'none';
                document.querySelector('#main_page_2').style.display = 'none';
                // document.querySelector('#main_page_4').style.display = 'none';
            } 
            // else if (itemId === 'i4'){
            //     document.querySelector('#main_page_4').style.display = 'inline-block';
            //     document.querySelector('#main_page_1').style.display = 'none';
            //     document.querySelector('#main_page_2').style.display = 'none';
            //     document.querySelector('#main_page_3').style.display = 'none';
            // }
        });
    });


}