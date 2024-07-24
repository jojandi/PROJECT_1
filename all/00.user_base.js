

let i1 = document.querySelector("#i1");
let i2 = document.querySelector("#i2");
let i4 = document.querySelector("#i4");
let i5 = document.querySelector("#i5");

let login = document.querySelector("#login");
let userin = document.querySelector("#userin");

function pageMove(){
    i1.addEventListener('click', function(){
        window.location.href="두정도서관 정보.html"
    })
    i2.addEventListener('click', function(){
        window.location.href="best_we.html"
    })
    i3.addEventListener('click', function(){
        window.location.href="공지사항사용자.html"
    })
    i4.addEventListener('click', function(){
        window.location.href="02.mypage_use.html"
    })

    login.addEventListener('click', function(){
        window.location.href="kim/로그인.html"
    })
    userin.addEventListener('click', function(){
        window.location.href="회원가입.html"
    })
}

pageMove();