let pi1 = document.querySelector("#sideleft #i1");
let pi2 = document.querySelector("#sideleft #i2");
let pi3 = document.querySelector("#sideleft #i3");
let pi4 = document.querySelector("#sideleft #i4");

function pageOn(){
    pi1.addEventListener('click', function(){
        window.location.href="공지사항_사용자.html"
    })
    pi2.addEventListener('click', function(){
        alert("로그인 후 이용 가능한 페이지입니다. ")
        window.location.href="로그인css.html"
    })
    pi3.addEventListener('click', function(){
        alert("로그인 후 이용 가능한 페이지입니다. ")
        window.location.href="로그인css.html"
    })
    pi4.addEventListener('click', function(){
        alert("로그인 후 이용 가능한 페이지입니다. ")
        window.location.href="로그인css.html"
    })
}

pageOn();