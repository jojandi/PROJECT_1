
let pwBnt = document.querySelector("#pwBnt");
let pwerror = document.querySelector("#pwerror");

let info1 = document.querySelector("#info1");
let info2 = document.querySelector("#info2");

let nickBtn = document.querySelector("#nickBtn");
let pweditBtn = document.querySelector("#pweditBtn");
let numBnt = document.querySelector("#numBnt");
let in1 = document.querySelector("#in1");
let pweditIn = document.querySelector("#pweditIn");
let in2 = document.querySelector("#in2");
let in3 = document.querySelector("#in3");

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

// nick.value 값 어떻게 읽어야할까
let nick = document.querySelector("#nick");
function edit(){
    nickBtn.addEventListener('click', function(){
        in1.innerHTML="";
        let click = in1.classList.contains("click");
        if(click){
            in1.classList.remove("click");
            console.log(nick);
            in1.innerHTML=nick;
        } else{
            let html='<input type="text" id=nick placeholder="변경할 닉네임을 입력하세요.">'
            in1.innerHTML=html;
            in1.classList.add("click");
            console.log(nick);
        }
    })


    pweditBtn.addEventListener('click', function(){
        let pw = pweditIn.value;
        
        console.log(pw);

        if(pw == ""){
            alert("비밀번호를 입력해주세요. ");
        } else{
            alert(pw + "로 비밀번호를 변경하시겠습니까?");
    
            in2.innerHTML="비밀번호가 변경되었습니다. ";
        }
    })


    numBnt.addEventListener('click', function(){
        in3.innerHTML="";
        let click = in3.classList.contains("click");
        if(click){
            in3.classList.remove("click");
            console.log(number);
            in3.innerHTML=number;
        } else{
            let html='<input type="text" id=number placeholder="변경할 전화번호를 입력하세요.">'
            in3.innerHTML=html;
            in3.classList.add("click");
            console.log(number);
        }
    })

}


info1On();
edit();