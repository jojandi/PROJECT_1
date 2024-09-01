document.querySelector("#check-username").addEventListener('click', function(){
    ajax();
})

let id = document.querySelector("#username");

function ajax() {

    console.log(id.value);

    let url = 'join';
    
    // ajax
    let xhr = new XMLHttpRequest();
    
    xhr.open("post", url);

    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 

    xhr.send( "username=" + id.value );
    
}