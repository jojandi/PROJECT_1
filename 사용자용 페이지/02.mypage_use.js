
let loan = document.querySelector("#loan");
let overdue = document.querySelector("#overdue");
let t1 = document.querySelector("#t1");
let t2 = document.querySelector("#t2");

function loanOn(){
    loan.addEventListener('click', function(){
        console.log('대출내역 클릭!!!');
        loan.style.fontWeight = "900";
        loan.style.textDecoration = "underline";
        overdue.style.fontWeight = "500";
        overdue.style.textDecoration = "none";
        t1.style.display = "block";
        t2.style.display = "none";
    })
}
function overdueOn(){
    overdue.addEventListener('click', function(){
        console.log('연체내역 클릭!!!');
        overdue.style.fontWeight = "900";
        overdue.style.textDecoration = "underline";
        loan.style.fontWeight = "500";
        loan.style.textDecoration = "none";
        t1.style.display = "none";
        t2.style.display = "block";
    })
}

loanOn();
overdueOn();