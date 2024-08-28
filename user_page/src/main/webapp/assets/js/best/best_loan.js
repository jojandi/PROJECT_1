let cr = document.querySelectorAll(".cr"); // 예약하기 닫기
let reserBnt = document.querySelectorAll(".reserBnt"); // 예약하기 버튼
let cartBnt = document.querySelectorAll(".cartBnt"); // 장바구니 버튼

let reser = document.querySelectorAll(".reser"); // 예약 블럭

let joong = document.querySelectorAll(".btnbox .joong"); // 중앙도서관
let sin = document.querySelectorAll(".btnbox .sin"); // 신방도서관
let du = document.querySelectorAll(".btnbox .du"); // 두정도서관
let cheong = document.querySelectorAll(".btnbox .cheong"); // 청수도서관
let ssang = document.querySelectorAll(".btnbox .ssang"); // 쌍용도서관

// 닫기 클릭 이벤트
function closer(){
    for(let i = 0 ; i < cr.length; i++){
        cr[i].addEventListener('click', function(){
            console.log('예약하기 닫기!!!');
            reser[i].style.display = "none"; // 예약현황 none
        })
    }
}

// 예약하기 클릭 이벤트
function reserOn(){
    for(let i = 0 ; i < reserBnt.length; i++){
        reserBnt[i].addEventListener('click', function(){
            console.log('예약하기 클릭!!!');
            reser[i].style.display = "block";
        })   
    }

    for(let i = 0 ; i < joong.length; i++){
        joong[i].addEventListener('click', function(){
            console.log("중앙");
            // 버튼의 value가 예약이라면 대출가능, 예약불가라면 예약 불가능
            if(joong[i].value == "예약"){
                alert("해당 책 대출이 예약되었습니다. (중앙도서관)");
            } else{
                alert("예약할 수 없습니다. ");
            }
        })
        sin[i].addEventListener('click', function(){
            console.log("신방");
            if(sin[i].value == "예약"){
                alert("해당 책 대출이 예약되었습니다. (신방도서관)");
            } else{
                alert("예약할 수 없습니다. ");
            }
        })
        du[i].addEventListener('click', function(){
            console.log("두정");
            if(du[i].value == "예약"){
                alert("해당 책 대출이 예약되었습니다. (두정도서관)");
            } else{
                alert("예약할 수 없습니다. ");
            }
        })
        cheong[i].addEventListener('click', function(){
            console.log("청수");
            if(cheong[i].value == "예약"){
                alert("해당 책 대출이 예약되었습니다. (청수도서관)");
            } else{
                alert("예약할 수 없습니다. ");
            }
        })
        ssang[i].addEventListener('click', function(){
            console.log("쌍용");
            console.log("예약")
            if(ssang[i].value == "예약"){
                alert("해당 책 대출이 예약되었습니다. (쌍용도서관)");
            } else{
                alert("예약할 수 없습니다. ");
            }
        })
    }

}



// 장바구니 클릭 이벤트
function cartOn(){
    for(let i = 0 ; i < cartBnt.length; i++){
        cartBnt[i].addEventListener('click', function(){
            console.log("장바구니 클릭!!!");
            alert("해당 도서가 장바구니에 담겼습니다. ")
        })
    }
}


closer();
reserOn();
cartOn();