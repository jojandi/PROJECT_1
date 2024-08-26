
// ------------------------------------ 인사관리 -----------------------------------------------
document.getElementById('addEmployeeBtn').addEventListener('click', function () {    // -----------여기부터 
   let newRow = document.createElement('div');
   newRow.classList.add('row', 'new-employee');

   newRow.innerHTML = `
               <input class="check-cell" type="checkbox">
               <div class="cell"><input type="text" placeholder="이름"></div>
               <div class="cell">
                   <select>
                       <option value="" selected disabled hidden>선택해주세요</option>
                       <option value="사장">사장</option>
                       <option value="부장">부장</option>
                       <option value="대리">대리</option>
                       <option value="사원">사원</option>
                   </select>
               </div>
               <div class="cell">
                   <select>
                       <option value="" selected disabled hidden>선택해주세요</option>
                       <option value="기획팀">기획팀</option>
                       <option value="포장팀">포장팀</option>
                       <option value="영업팀">영업팀</option>
                       <option value="도서관리팀">도서관리팀</option>
                   </select>    
               </div>
               <div class="cell"><input type="text" placeholder="전화번호"></div>
               <div class="cell"><input type="text" placeholder="주소"></div>
               <div class="cell"><input type="date"></div>
               `;

   let employeeTable = document.querySelector('.employee-table');
   employeeTable.appendChild(newRow);                                               // -------------- 여기까지가 정보 추가 

   // // 새로운 직원 추가 후 헤더 체크박스 동기화
   syncHeaderCheckbox();


});



// 저장 버튼 클릭 이벤트 처리 
document.getElementById('saveBtn').addEventListener('click', function () {            // :::::::::::::::: 여기부터 저장버튼 클릭이벤트 ::::::::::::::::
   let newRows = document.querySelectorAll('.new-employee');

   newRows.forEach(function (newRow) {
       console.log(newRow.querySelector('.cell:nth-child(1)'));                                                       // forEach로 순회하면서 
       let name = newRow.querySelector('.cell:nth-child(2) input').value;                  // 정보들의 값을 저장하게끔
       let position = newRow.querySelector('.cell:nth-child(3) select').value;
       let department = newRow.querySelector('.cell:nth-child(4) select').value;
       let phoneNumber = newRow.querySelector('.cell:nth-child(5) input').value;       // 중간에 들어가는 ntn-child는 몇 번째에 
       let address = newRow.querySelector('.cell:nth-child(6) input').value;
       let startDate = newRow.querySelector('.cell:nth-child(7) input').value;        // :::::::::::::::: 여기부터 저장버튼 클릭이벤트 끝내고 ::::::::::::::::

       if (!name | !position | !department | !phoneNumber | !address | !startDate) {
           alert("필수 요소 입력");
       }
       else {
           let newTableEntry = document.createElement('div');
           newTableEntry.classList.add('row');

           newTableEntry.innerHTML = `
               <input class="check-cell" type="checkbox">
               <div class="cell">${name}</div>
               <div class="cell">${position}</div>
               <div class="cell">${department}</div>
               <div class="cell">${phoneNumber}</div>
               <div class="cell">${address}</div>
               <div class="cell">${startDate}</div>
               `;

           let employeeTable = document.querySelector('.employee-table');
           employeeTable.appendChild(newTableEntry);

           // 새로 추가한 행은 삭제
           newRow.remove();

           // 새로 추가된 직원에 대해서도 더블 클릭 시 모달 처리

           let cells = newTableEntry.querySelectorAll('.cell');
           cells.forEach(function (cell) {
               cell.addEventListener('dblclick', function () {
                   populateModalForEdit(cells);
               })
           })
           syncHeaderCheckbox();
           alert('저장되었습니다.');
       }
   });

});

// 헤더 체크박스와 모든 직원 체크박스 동기화 함수
function syncHeaderCheckbox() {
   let headerCheckbox = document.getElementById('selectAllCheckbox');
   let checkboxes = document.querySelectorAll('.check-cell');

   headerCheckbox.addEventListener('click', function () {   // selectAllCheckbox 는 체크박스 첫번째 헤더 체크박스 // 클릭이벤트 처리
       checkboxes.forEach(function (checkbox, index) {             // check-cell class를 가진 체크박스 요소들을 반복하여 처리 
           if (index > 0) {                                        // 조건을 사용 첫번째 요소(헤더 체크박스) 는 제외 , 
               checkbox.checked = headerCheckbox.checked;       // 나머지 체크박스의 checked 상태를 selectAllCheckbox.checked 값으로 설정
           }
       });
   });


   checkboxes.forEach(function (checkbox, index) {         // 각 체크박스의 클릭 이벤트 
       checkbox.addEventListener('click', function () {
           if (index === 0 && !checkbox.checked) {
               headerCheckbox.checked = false;          // 첫 번째 체크박스(헤더 체크박스)가 선택 해제될 때 selectAllCheckbox.checked 값을 false로 설정
           } else {
               let allChecked = true;                          // else 
               for (let i = 1; i < checkboxes.length; i++) {   // 체크박스를 1부터 시작해서 하나씩 돌면서 체크가 되어 있는지 확인
                   if (!checkboxes[i].checked) {               // 체크가 안 되어 있다면 false
                       allChecked = false;
                       break;
                   }
               }
               headerCheckbox.checked = allChecked;         // false 값을 줌 
           }
       });
   });

}



// 헤더 체크박스 클릭 시 모든 직원 체크박스 선택 및 해제
document.getElementById('selectAllCheckbox').addEventListener('click', function () {
   let checkboxes = document.querySelectorAll('.check-cell');
   checkboxes.forEach(function (checkbox, index) {
       checkbox.checked = document.getElementById('selectAllCheckbox').checked;
   });
});


document.getElementById('deleteEmployeeBtn').addEventListener('click', function () {
   // 삭제 버튼 클릭 시 처리
   let rowsToDelete = document.querySelectorAll('.row input.check-cell:checked');

   if (rowsToDelete.length === 0) {    // 삭제 버튼을 클릭했을 때, 선택된 직원 정보를 삭제하기 전에 삭제할 대상이 있는지를 검사하는 역할
       alert('삭제할 직원을 선택해주세요.');
       return;
   }

   // 확인 메시지 띄우기
   if (confirm('선택한 직원 정보를 삭제하시겠습니까?')) {
       rowsToDelete.forEach(function (row) {
           if (!row.parentElement.classList.contains('header')) { // 헤더부분은 제외
               row.parentElement.remove(); // 선택된 행 삭제
           }
       });
   }
});

/////////////////////////////////////////////////////////////// checkbox ////////////////////////////////////////////////////////////////////
syncHeaderCheckbox();


/////////////////////////////////////////////////////////////////////////    checkbox <<<<끝>>>>>>     ///////////////////////////////////////////////////////////


////////////////////////////////////////// 더블 클릭 했을 시 정보 보이는 ///////////////////////////////////////////


// 직원 정보 모달 관련 스크립트
let modal = document.getElementById('employeeModal');
let closeBtn = document.querySelector('.close');

closeBtn.addEventListener('click', function () {
   modal.style.display = 'none';
});

window.addEventListener('click', function (event) {//모달 화면에서 밖에를 눌러서 나가게 하기
   if (event.target === modal) {
       modal.style.display = 'none';
   }
});


// 모달 수정 ------------------------------------------------------------------

// 직원 정보 편집을 위해 모달에 데이터를 채우는 함수
function populateModalForEdit(cells) {
   document.getElementById('modalNameInput').value = cells[0].textContent;
   document.getElementById('modalPositionInput').value = cells[1].textContent;
   document.getElementById('modalDepartmentInput').value = cells[2].textContent;
   document.getElementById('modalPhoneNumberInput').value = cells[3].textContent;
   document.getElementById('modalAddressInput').value = cells[4].textContent;
   document.getElementById('modalStartDateInput').value = cells[5].textContent;
   modal.style.display = 'block';

   editingRow = cells[0].closest('.row');//row에 끝부분에 추가하는 코드

}

// 저장 버튼 클릭 이벤트 처리
document.getElementById('updateEmployeeBtn').addEventListener('click', function () {

   // 모달에서 입력된 값 가져오기
   let name = document.getElementById('modalNameInput').value;
   let position = document.getElementById('modalPositionInput').value;
   let department = document.getElementById('modalDepartmentInput').value;
   let phoneNumber = document.getElementById('modalPhoneNumberInput').value;
   let address = document.getElementById('modalAddressInput').value;
   let startDate = document.getElementById('modalStartDateInput').value;

   // 수정된 데이터로 행 업데이트
   editingRow.querySelector('.cell:nth-child(2)').textContent = name;
   editingRow.querySelector('.cell:nth-child(3)').textContent = position;
   editingRow.querySelector('.cell:nth-child(4)').textContent = department;
   editingRow.querySelector('.cell:nth-child(5)').textContent = phoneNumber;
   editingRow.querySelector('.cell:nth-child(6)').textContent = address;
   editingRow.querySelector('.cell:nth-child(7)').textContent = startDate;

   // 모달 닫기
   document.getElementById('employeeModal').style.display = 'none';

   alert("저장되었습니다.");
});

// 행을 더블 클릭하여 직원 정보 편집
let rows = document.querySelectorAll('.row:not(.header)');
rows.forEach(function (row) {
   let cells = row.querySelectorAll(".cell");
   cells.forEach(function (cell) {
       cell.addEventListener('dblclick', function () {
           populateModalForEdit(cells);
       })
   })
});


// 모달 닫기 버튼 이벤트 리스너
closeBtn.addEventListener('click', function () {
   modal.style.display = 'none';
});

/////////////////////////////////////////////////////////////// 검색 기능 ///////////////////////////////////////////////////////////////////////

document.getElementById('searchEmployeeBtn').addEventListener('click', function () {
   let searchText = document.getElementById('searchInput').value.trim().toLowerCase(); // 공백 제거 및 소문자로 변환
   let rows = document.querySelectorAll('.employee-table .row:not(.header)');  // 직원행을 가져옴 

   rows.forEach(function (row) {
       let cells = row.querySelectorAll('.cell');      // 각 셀들의 행을 가져오고 
       let found = false;                              // 검색어를 포함한 셀이 있는지 여부

       cells.forEach(function (cell, index) {
           if (cell.textContent.toLowerCase().includes(searchText)) {
               found = true;       // 검색어를 포함한 셀이 하나라도 있으면 found 를 true로 변경
           }
       });

       if (found) {
           row.style.display = ''; // 검색어를 포함한 행은 보이기
       } else {
           row.style.display = 'none'; // 포함하지 않은 행 숨기기
       }
   });
});

//검색 input에서 엔터키 누르면 검색 버튼이 눌리게
document.querySelector('#searchInput').addEventListener('keyup', function () {
   if (event.keyCode === 13) {
       event.preventDefault();
       document.querySelector('#searchEmployeeBtn').click();
   }
})

