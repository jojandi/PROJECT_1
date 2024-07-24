
let invenBnt = document.querySelectorAll(".invenBnt");
let ci = document.querySelectorAll(".ci");
let cr = document.querySelectorAll(".cr");
let reserBnt = document.querySelectorAll(".reserBnt");
let cartBnt = document.querySelectorAll(".cartBnt");

let inven = document.querySelectorAll(".inven");
let reser = document.querySelectorAll(".reser");

let joong = document.querySelector("#joong");
let sin = document.querySelector("#sin");
let du = document.querySelector("#du");
let cheong = document.querySelector("#cheong");
let ssang = document.querySelector("#ssang");

function invenOn(){
    for(let i = 0 ; i < invenBnt.length; i++){
        invenBnt[i].addEventListener('click', function(){
            console.log('재고현황 클릭!!!');
            inven[i].style.display = "block";
        })
    }
}
function closer(){
    for(let i = 0 ; i < ci.length; i++){
        ci[i].addEventListener('click', function(){
            console.log('재고현황 닫기!!!');
            inven[i].style.display = "none";
            console.log('예약하기 닫기!!!');
            reser[i].style.display = "none";
        })
    }
    for(let i = 0 ; i < cr.length; i++){
        cr[i].addEventListener('click', function(){
            console.log('예약하기 닫기!!!');
            reser[i].style.display = "none";
        })
    }
}

function reserOn(){
    for(let i = 0 ; i < reserBnt.length; i++){
        reserBnt[i].addEventListener('click', function(){
            console.log('예약하기 클릭!!!');
            reser[i].style.display = "block";
        })   
    }
    joong.addEventListener('click', function(){
        alert("해당 책 대출이 예약되었습니다. (중앙도서관)");
    })
    sin.addEventListener('click', function(){
        alert("해당 책 대출이 예약되었습니다. (신방도서관)");
    })
    du.addEventListener('click', function(){
        alert("해당 책 대출이 예약되었습니다. (두정도서관)");
    })
    cheong.addEventListener('click', function(){
        alert("해당 책 대출이 예약되었습니다. (청수도서관)");
    })
    ssang.addEventListener('click', function(){
        alert("해당 책 대출이 예약되었습니다. (쌍용도서관)");
    })
}

invenOn();
closer();
reserOn();