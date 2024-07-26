
let searchBnt = document.querySelector("#searchBnt");
let searchIn = document.querySelector("#searchIn");

function pageMove(){

    searchIn.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            searchBnt.click();
        }
    })

    searchBnt.addEventListener('click', function(){
        let s = searchIn.value;
        console.log("검색어 : " + s);
        
        if(s == "파친코"){
            window.location.href="03.search_loan_1_login.html";
        } else if(s == "군주론"){
            window.location.href="03.search_loan_2_login.html";
        }else if(s == "곰탕"){
            window.location.href="03.search_loan_3_login.html";
        }else if(s == "나는 도대체 왜 피곤할까"){
            window.location.href="03.search_loan_4_login.html";
        }else if(s == "피터 스완슨"){
            window.location.href="03.search_loan_5_login.html";
        }
        else {
            window.location.href="03.search_loan_none_login.html";
        }
    })
}

pageMove();