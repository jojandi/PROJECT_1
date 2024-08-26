

let icon = document.querySelectorAll(".item .material-symbols-outlined");
let item = document.querySelectorAll(".item");
let loan = document.querySelector("#loan");
let overdue = document.querySelector("#overdue");
let t1 = document.querySelector("#t1");
let t2 = document.querySelector("#t2");

let minbnt = document.querySelectorAll(".minbnt");
let parent = document.querySelectorAll(".parent");



function iconon(){
    for(let i = 0; i < item.length; i++){
        item[i].addEventListener('click', function(){
            console.log('클릭!');
            console.log(this);
            console.log(this.querySelector(".material-symbols-outlined"));
            this.querySelector("span").style.fontWeight = "900";
            this.querySelector(".material-symbols-outlined").style.background = "rgb(165, 224, 144)";
        })
    }
}

function loanOn(){
    loan.addEventListener('click', function(){
        console.log('도서신청내역 클릭!!!');
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
        console.log('민원처리현황 클릭!!!');
        overdue.style.fontWeight = "900";
        overdue.style.textDecoration = "underline";
        loan.style.fontWeight = "500";
        loan.style.textDecoration = "none";
        t1.style.display = "none";
        t2.style.display = "block";
    })
}


function bntColor(){
    ing = $(".parent").find(".ing");
    end = $(".parent").find(".end");
    console.log($(".parent").find(".ing"));
    console.log($(".parent").find(".end"));

    for(let i = 0; i < ing.length; i++){
        ing[i].style.background = "rgb(233, 29, 29)";
        ing[i].style.color = "white";
        ing[i].setAttribute("ing", "ing");
    }
    for(let i = 0; i < end.length; i++){
        end[i].style.background = "rgb(185, 185, 185)";
    }
}

function del(){
    for(let i = 0; i < minbnt.length; i++){
        minbnt[i].addEventListener('click', function(){

            let ing = minbnt[i].hasAttribute("ing");
            
            console.log(ing)

            if(ing){
                alert("해당 민원을 취하합니다. ");
                parent[i].innerHTML="";
            } else{
                alert("취하할 수 없는 민원입니다. ")
            }
        })

    }
}

iconon();
loanOn();
overdueOn();
bntColor();
del();
