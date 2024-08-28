let username = document.querySelector("#username");
let password = document.querySelector("#password");
let loginBtn = document.querySelector("#loginBtn");

username.addEventListener('keyup', function(event){
    if(event.keyCode == 13){
        password.focus();
    }
})
password.addEventListener('keyup', function(event){
    if(event.keyCode == 13){
        loginBtn.click();
    }
})