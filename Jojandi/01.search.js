
let searchBnt = document.querySelector("#searchBnt");
let searchIn = document.querySelector("#searchIn");

function pageMove(){

    searchIn.addEventListener('keyup', function(event){
        if(event.keyCode == 13){
            searchBnt.click();
        }
    })

    searchBnt.addEventListener('click', function(){
        let searchInValue = searchIn.value;
        console.log("검색어 : " + searchInValue);
        
        if(searchInValue == "파친코"){
            window.location.href="03.search_loan_1.html";
        } else if(searchInValue == "군주론"){
            window.location.href="03.search_loan_2.html";
        }else {
            window.location.href="03.search_loan_none.html";
        }
    })
}

pageMove();