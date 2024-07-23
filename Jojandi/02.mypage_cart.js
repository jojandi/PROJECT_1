
let del = document.querySelectorAll(".del");
let cart = document.querySelectorAll(".cart");

let delall = document.querySelector("#delall");

let chk = document.querySelectorAll(".chk");
let chkall = document.querySelector("#chkall")

function delOn(){
    for(let i = 0; i < del.length; i++){
        del[i].addEventListener('click', function(){
            console.log("삭제!");

            cart[i].innerHTML="";           
            cart[i+1].innerHTML="";           
        })
    }
}

function delallOn(){
    delall.addEventListener('click', function(){
        for(let i = 0; i < cart.length; i++){
            console.log("전체 삭제!");

            cart[i].innerHTML="";
        }
    })
}

function chkallOn(){
    
    chkall.addEventListener('click', function(){
        let ischk = chkall.hasAttribute("checked");

        if(ischk){
            console.log(ischk);
            
            chkall.removeAttribute("checked");
            console.log("전체 선택 해제!");

            for(let i = 0; i < chk.length; i++){
                chk[i].removeAttribute("checked");
            }
            
        } else{
            console.log(ischk);
            
            chkall.setAttribute("checked", "checked");
            console.log("전체 선택!");

            for(let i = 0; i < chk.length; i++){
                chk[i].setAttribute("checked", "checked");
            }
        }
    })

    for(let i = 0; i < chk.length; i++){
        chk[i].addEventListener('click', function(){
            let ischk = chk[i].hasAttribute("checked");

            if(ischk){
                chk[i].setAttribute("checked", "checked");
            } else{
                chk[i].removeAttribute("checked");
            }
        });
    }
    
}

delOn();
delallOn();
chkallOn();

