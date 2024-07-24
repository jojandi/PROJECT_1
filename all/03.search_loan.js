
let invenBnt = document.querySelectorAll(".invenBnt");
let close = document.querySelectorAll(".close");

let inven = document.querySelectorAll(".inven");

function invenOn(){
    for(let i = 0 ; i < invenBnt.length; i++){
        invenBnt[i].addEventListener('click', function(){
            console.log('재고현황 클릭!!!');
            inven[i].style.display = "block";
        })
    }
}
function closer(){
    for(let i = 0 ; i < invenBnt.length; i++){
        close[i].addEventListener('click', function(){
            console.log('재고현황 닫기!!!');
            inven[i].style.display = "none";
        })
    }
}

invenOn();
closer();