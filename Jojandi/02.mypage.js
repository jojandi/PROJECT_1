let i1 = document.querySelector("#sideleft #i1");
let i2 = document.querySelector("#sideleft #i2");
let i3 = document.querySelector("#sideleft #i3");
let i4 = document.querySelector("#sideleft #i4");

let s1 = document.querySelector("#use");
let s2 = document.querySelector("#cart");
let s3 = document.querySelector("#min");
let s4 = document.querySelector("#info");

function use(){
    i1.addEventListener('click', function(){
        console.log("aa")
        s1.src="./02.mypage_use.html"
        s2.src="./02.mypage_use.html"
        s3.src="./02.mypage_use.html"
        s4.src="./02.mypage_use.html"
    })
}

// use();