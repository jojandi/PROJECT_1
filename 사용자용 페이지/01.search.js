
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
            window.location.href="03.search_loan_1.html";
        } else if(s == "군주론"){
            window.location.href="03.search_loan_2.html";
        }else if(s == "곰탕"){
            window.location.href="03.search_loan_3.html";
        }else if(s == "나는 도대체 왜 피곤할까"){
            window.location.href="03.search_loan_4.html";
        }else if(s == "피터 스완슨"){
            window.location.href="03.search_loan_5.html";
        }
        else {
            window.location.href="03.search_loan_none.html";
        }
    })
}

pageMove();