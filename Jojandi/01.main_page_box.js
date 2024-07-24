
let page = document.querySelectorAll(".page");
let icon = document.querySelectorAll(".section1 #pageall .pages .page .material-symbols-outlined")

let p1 = document.querySelector("#p1");
let p2 = document.querySelector("#p2");
let p3 = document.querySelector("#p3");
let p4 = document.querySelector("#p4");
let p5 = document.querySelector("#p5");
let p6 = document.querySelector("#p6");
let p7 = document.querySelector("#p7");
let p8 = document.querySelector("#p8");

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

hover();