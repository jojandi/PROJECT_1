
let left = document.querySelector("#left");
let right = document.querySelector("#right");
let one = document.querySelector("#one");
let two = document.querySelector("#two");
let t1 = document.querySelector("#t1");
let t2 = document.querySelector("#t2");

function move(){
    one.addEventListener('click', function(){
        t1.computedStyleMap.display= "none";
        t2.computedStyleMap.display= "block";
    })
}

move();