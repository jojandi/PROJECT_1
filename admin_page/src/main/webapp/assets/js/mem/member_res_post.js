let submit = document.querySelectorAll(".submit")

for(let i = 0; i<submit.length; i++){
    submit[i].addEventListener('click', function(){
        ajax(i);
    })
}

let code = document.querySelectorAll(".code");
let seq = document.querySelectorAll(".seq");
let user = document.querySelectorAll(".user");

function ajax(i) {

    console.log("code : " + code[i].value);
    console.log("seq : " + seq[i].value);
    console.log("user : " + user[i].value);
    console.log("code=" + code[i].value + "&seq=" + seq[i].value + "&user=" + user[i].value);
    let url = 'res';
    
    // ajax
    let xhr = new XMLHttpRequest();
    
    xhr.open("post", url);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 

    xhr.send( "code=" + code[i].value + "&seq=" + seq[i].value + "&user=" + user[i].value);
    
    
}