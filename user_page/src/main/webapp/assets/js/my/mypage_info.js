
let pwBnt = document.querySelector("#pwBnt");
let pwerror = document.querySelector("#pwerror");
let pwIn = document.querySelector("#pwIn");

let info1 = document.querySelector("#info1");
let info2 = document.querySelector("#info2");

let nickBtn = document.querySelector("#nickBtn");
let pweditBtn = document.querySelector("#pweditBtn");
let numBnt = document.querySelector("#numBnt");
let in1 = document.querySelector("#in1");
let pweditIn = document.querySelector("#pweditIn");
let in2 = document.querySelector("#in2");
let in3 = document.querySelector("#in3");

let nick = document.querySelector("#nick");
let nickname = document.querySelector("#nickname")

let out = document.querySelector("#out")
let realout = document.querySelector("#realout")
let bookout = document.querySelector("#bookout")


function info1On(){

    pwIn.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            pwBnt.click();
        }
    })

    pwBnt.addEventListener('click', function(){

        let pwIn = document.querySelector("#pwIn").value;
        
        console.log('비밀번호 확인 클릭!!!');
        console.log(pwIn);
        if(pwIn == "1234"){
            info2.style.display = "block";
            info1.style.display = "none";
        } else{
            pwerror.style.display = "block";
        }
    })
}

function logout(){
    out.addEventListener('click', function(){
        let c = confirm("로그아웃 하시겠습니까?");

        if(c){
            window.location.href="main"
        } else{
            window.location.href="mypage_info"
        }
    })

    realout.addEventListener('click', function(){
        let c = confirm("회원 탈퇴 하시겠습니까?");

        if(c){
            c = confirm("정말로 회원 탈퇴 하시겠습니까?");
            if(c){
                c = confirm("정말 정말로 회원 탈퇴 하시겠습니까?");
                if(c){
                    c = confirm("진짜 정말 정말로 회원 탈퇴 하시겠습니까?");
                    if(c){
                        alert("탈퇴되었습니다. 감사했습니다. ")
                        window.location.href="main"
                    } else{
                        alert("감사합니다. 앞으로 잘 모시겠습니다. ")
                    }
                } else{
                    alert("감사합니다. 앞으로 잘 모시겠습니다. ")
                }
            } else{
                alert("감사합니다. 앞으로 잘 모시겠습니다. ")
            }
        } else{
            window.location.href="mypage_info"
        }
    })

    bookout.addEventListener('click', function(){
        let c = confirm("북플릭스 회원 탈퇴 하시겠습니까?");

        if(c){
            c = confirm("정말로 북플릭스 회원 탈퇴 하시겠습니까?");
            if(c){
                c = confirm("정말 정말로 북플릭스 회원 탈퇴 하시겠습니까?");
                if(c){
                    c = confirm("진짜 정말 정말로 북플릭스 회원 탈퇴 하시겠습니까?");
                    if(c){
                        alert("탈퇴되었습니다. 감사했습니다. ")
                        window.location.href="bookflix"
                    } else{
                        alert("감사합니다. 앞으로 잘 모시겠습니다. ")
                    }
                } else{
                    alert("감사합니다. 앞으로 잘 모시겠습니다. ")
                }
            } else{
                alert("감사합니다. 앞으로 잘 모시겠습니다. ")
            }
        } else{
            window.location.href="mypage_info"
        }
    })
}


function edit(){

    nick.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            nickBtn.click();
        }
    })

    nickBtn.addEventListener('click', function(){
        in1.innerHTML="";
        let click = in1.classList.contains("click");
        if(click){
            in1.innerHTML = nick.value;
            nickname.innerHTML = "";
            nickname.innerHTML = nick.value;

            in1.classList.remove("click");
            in1.style.display="inline-block";
            nick.style.display="none";
            console.log(nick.value);
        } else{
            nick.innerHTML = "";

            in1.classList.add("click");
            in1.style.display="none";
            nick.style.display="inline-block";
            console.log(nick.value);
        }
    })


    pweditIn.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            pweditBtn.click();
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


    number.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            numBnt.click();
        }
    })

    numBnt.addEventListener('click', function(){
        in3.innerHTML="";
        let click = in3.classList.contains("click");
        if(click){
            in3.innerHTML = number.value;

            in3.classList.remove("click");
            in3.style.display="inline-block";
            number.style.display="none";
            
            console.log(number.value);
            in3.innerHTML=number.value;
        } else{
            number.value="";

            in3.style.display="none";
            number.style.display="inline-block";
            in3.classList.add("click");
            console.log(number.value);
        }
    })

}


info1On();
edit();
logout()