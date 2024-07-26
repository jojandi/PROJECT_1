document.getElementById("check-username").addEventListener("click", function() {
    const username = document.getElementById("username").value;
    if (username === "") {
        alert("아이디를 입력하세요.");
        document.getElementById("username").focus();
    } else {
        alert(`아이디 ${username}은(는) 사용 가능합니다.`);
    }
});

document.getElementById("gaip_1").addEventListener("click", function() {
    const name = document.getElementById("name").value;
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;
    const confirmPassword = document.getElementById("confirm-password").value;
    const phone = document.getElementById("phone").value;
    const emailUser = document.getElementById("email-user").value;
    const emailDomain = document.getElementById("email-domain").value;

    

    if (!name || !username || !password || !confirmPassword || !phone || !emailUser || !emailDomain) {
        alert("모든 필드를 입력하세요.");
        return;
    }

    if (password !== confirmPassword) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    alert("회원가입이 완료되었습니다.");
});

function msg(){

    let idmsg = document.querySelector("#username-message");
    let pw = document.getElementById("password");
    let username = document.getElementById("username").value;

    pw.addEventListener("focus", function(){
        console.log("비번")
        if(username == ""){
            console.log("dkflksdf")
            idmsg.style.display="block";
        }
    })
    

    let conpw = document.getElementById("confirm-password");
    let password = document.getElementById("password").value;
    let pwmsg = document.querySelector("#password-message");

    conpw.addEventListener("focus", function(){
        console.log("비번")
        if(password == ""){
            console.log("dkflksdf")
            pwmsg.style.display="block";
        }
    })
}

msg();