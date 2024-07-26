let pi1 = document.querySelector("#sideleft #i1");
let pi2 = document.querySelector("#sideleft #i2");
let pi3 = document.querySelector("#sideleft #i3");
let pi4 = document.querySelector("#sideleft #i4");
let pi5 = document.querySelector("#sideleft #i5");

function pageOn(){
    pi1.addEventListener('click', function(){
        window.location.href="도서관 정보(중앙).html"
    })
    pi2.addEventListener('click', function(){
        window.location.href="도서관 정보(쌍용).html"
    })
    pi3.addEventListener('click', function(){
        window.location.href="도서관 정보(두정).html"
    })
    pi4.addEventListener('click', function(){
        window.location.href="도서관 정보(신방).html"
    })
    pi5.addEventListener('click', function(){
        window.location.href="도서관 정보(청수).html"
    })
}

pageOn();