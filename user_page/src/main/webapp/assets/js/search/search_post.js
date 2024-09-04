// 예약
let reserBnt = document.querySelectorAll(".reserBnt")

for(let i = 0; i<reserBnt.length; i++){
    reserBnt[i].addEventListener('click', function(){
        resajax(i);
    })
}

let code = document.querySelectorAll(".code");
let user = document.querySelectorAll(".user");

function resajax(i) {

    console.log("code : " + code[i].value);
    console.log("user : " + user[i].value);
    console.log("code=" + code[i].value + "&user=" + user[i].value);
    
    let url = 'res_user';
    
    // ajax
    let xhr = new XMLHttpRequest();
    
    xhr.open("post", url);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 

    xhr.send( "code=" + code[i].value + "&user=" + user[i].value);
}



// 장바구니
let cartBnt = document.querySelectorAll(".cartBnt")

for(let i = 0; i<cartBnt.length; i++){
    cartBnt[i].addEventListener('click', function(){
        cartajax(i);
    })
}

let code2 = document.querySelectorAll(".code");
let user2 = document.querySelectorAll(".user");

function cartajax(i) {

    console.log("code : " + code2[i].value);
    console.log("user : " + code2[i].value);
    console.log("code=" + code2[i].value + "&seq=" + "&user=" + code2[i].value);
    
    let url = 'cart_user';
    
    // ajax
    let xhr = new XMLHttpRequest();
    
    xhr.open("post", url);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 

    xhr.send( "code=" + code[i].value + "&seq=" + "&user=" + user[i].value);
}