
let page = document.querySelectorAll(".page");
let icon = document.querySelectorAll(".section1 #pageall .pages .page .material-symbols-outlined")

let my = document.querySelector("#i4");

function hover(){
    for(let i = 0; i < page.length; i++){
        page[i].addEventListener('mouseover', function(){
            console.log("in");
            page[i].style.background = "rgb(106, 170, 82)";
            page[i].style.transition ="all 0.8s";

            icon[i].style.color ="white";
            icon[i].style.transition ="all 0.8s";
        })
    }

    for(let i = 0; i < page.length; i++){
        page[i].addEventListener('mouseout', function(){
            console.log("out");
            page[i].style.background = "white";

            icon[i].style.color ="rgb(106, 170, 82)";
        })
    }
}

function mypageNo(){
    my.addEventListener('click', function(){
        alert("로그인 후 이용 가능한 페이지입니다. ")
    })
}

hover();
mypageNo();