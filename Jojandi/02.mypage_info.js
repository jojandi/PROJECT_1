
let pwBnt = document.querySelector("#pwBnt");
let pwerror = document.querySelector("#pwerror");

let info1 = document.querySelector("#info1");
let info2 = document.querySelector("#info2");

function info1On(){
    pwBnt.addEventListener('click', function(){

        let pwIn = document.querySelector("#pwIn").value;
        
        console.log('비밀번호 확인 클릭!!!');
        console.log(pwIn);
        if(pwIn != ""){
            info2.style.display = "block";
            info1.style.display = "none";
        } else{
            pwerror.style.display = "block";
        }
    })
}

info1On();
