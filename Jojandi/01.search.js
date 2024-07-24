
let searchBnt = document.querySelector("#searchBnt");
let searchIn = document.querySelector("#searchIn").value;

function pageMove(){
    searchBnt.addEventListener('click', function(){
        let searchIn = document.querySelector("#searchIn").value;
        console.log("검색어 : "+searchIn);
        
        if(searchIn == "파친코"){
            window.location.href="03.search_loan_1.html";
        } else {
            window.location.href="03.search_loan_none.html";
        }
    })
}

pageMove();