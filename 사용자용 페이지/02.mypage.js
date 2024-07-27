let pi1 = document.querySelector("#sideleft #i1");
let pi2 = document.querySelector("#sideleft #i2");
let pi3 = document.querySelector("#sideleft #i3");
let pi4 = document.querySelector("#sideleft #i4");

function pageOn(){
    pi1.addEventListener('click', function(){
        window.location.href="02.mypage_use.html"
    })
    pi2.addEventListener('click', function(){
        window.location.href="02.mypage_cart.html"
    })
    pi3.addEventListener('click', function(){
        window.location.href="02.mypage_min.html"
    })
    pi4.addEventListener('click', function(){
        window.location.href="02.mypage_info_sub.html"
    })
}

pageOn();