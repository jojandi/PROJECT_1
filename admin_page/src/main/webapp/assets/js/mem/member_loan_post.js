let submit = document.querySelectorAll(".submit")

for(let i = 0; i<submit.length; i++){
    submit[i].addEventListener('click', function(){
        ajax(i);
    })
}

let select = document.querySelectorAll(".select");
let seq = document.querySelectorAll(".seq");

function ajax(i) {

    console.log("select : " + select[i].value);
    console.log("seq : " + seq[i].value);

    let url = 'loan';
    
    // ajax
    let xhr = new XMLHttpRequest();
    
    xhr.open("post", url);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 

    xhr.send( "ing=" + select[i].value + "&seq=" + seq[i].value);
    
    
}