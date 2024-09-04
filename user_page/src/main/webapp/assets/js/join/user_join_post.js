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

    xhr.onload = funtion(){
    	if(xhr.status===200){    //status = response 상태 코드 반환 : 200 정상응답
        console.log(xhr.responseText);
    	}
    }
    
}