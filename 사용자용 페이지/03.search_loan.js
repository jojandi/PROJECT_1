
let invenBnt = document.querySelectorAll(".invenBnt");
let ci = document.querySelectorAll(".ci");
let cr = document.querySelectorAll(".cr");
let reserBnt = document.querySelectorAll(".reserBnt");
let cartBnt = document.querySelectorAll(".cartBnt");

let inven = document.querySelectorAll(".inven");
let reser = document.querySelectorAll(".reser");

let joong = document.querySelectorAll(".btnbox .joong");
let sin = document.querySelectorAll(".btnbox .sin");
let du = document.querySelectorAll(".btnbox .du");
let cheong = document.querySelectorAll(".btnbox .cheong");
let ssang = document.querySelectorAll(".btnbox .ssang");

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
            alert("로그인 후 이용 가능합니다. ");
            window.location.href="로그인css.html"
        })   
    }
}

invenOn();
closer();
reserOn();