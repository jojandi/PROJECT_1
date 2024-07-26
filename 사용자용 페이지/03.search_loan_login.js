
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
            reser[i].style.display = "block";
        })   
    }

    for(let i = 0 ; i < joong.length; i++){
        joong[i].addEventListener('click', function(){
            console.log("중앙");
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

invenOn();
closer();
reserOn();