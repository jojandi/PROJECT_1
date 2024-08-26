

document.getElementById('loginBtn').addEventListener('click', function() {
    // 입력 필드 값 가져오기
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    // ID와 비밀번호 확인 (예시: ID가 'user'이고 비밀번호가 'password'일 때 성공)
    if (username === 'user' && password === '1234') {
        alert('로그인 성공!');
        window.location.href="01.main_user_login.html";
        // 로그인 성공 후 수행할 작업 추가
    } else if(username === 'admin' && password === '5678') {
        alert('로그인 성공!');
        window.location.href="../관리자용 페이지/admin_main.html";
    }
    
    else {
        alert('ID 또는 비밀번호가 잘못되었습니다.');
    }
});

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