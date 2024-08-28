let cr = document.querySelectorAll(".cr"); // 예약하기 닫기
let reserBnt = document.querySelectorAll(".reserBnt"); // 예약하기 버튼
let cartBnt = document.querySelectorAll(".cartBnt"); // 장바구니 버튼

let reser = document.querySelectorAll(".reser"); // 예약 블럭

// 예약하기 클릭 이벤트
function reserOn(){
    for(let i = 0 ; i < reserBnt.length; i++){
        reserBnt[i].addEventListener('click', function(){
            console.log('예약하기 클릭!!!');
           alert("해당 도서가 예약되었습니다. ")
        })   
    }
}



// 장바구니 클릭 이벤트
function cartOn(){
    for(let i = 0 ; i < cartBnt.length; i++){
        cartBnt[i].addEventListener('click', function(){
            console.log("장바구니 클릭!!!");
            alert("해당 도서가 찜 목록에 담겼습니다. ")
        })
    }
}


closer();
reserOn();
cartOn();