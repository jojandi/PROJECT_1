let pi1 = document.querySelector("#sideleft #i1");
let pi2 = document.querySelector("#sideleft #i2");
let pi3 = document.querySelector("#sideleft #i3");
let pi4 = document.querySelector("#sideleft #i4");

function pageOn(){
    pi1.addEventListener('click', function(){
        window.location.href="공지사항_사용자_로그인.html"
    })
    pi2.addEventListener('click', function(){
        window.location.href="도서신청_사용자_로그인.html"
    })
    pi3.addEventListener('click', function(){
        window.location.href="시설물신청_사용자_로그인.html"
    })
    pi4.addEventListener('click', function(){
        window.location.href="불량도서신고_사용자_로그인.html"
    })
}

pageOn();