
let icon = document.querySelectorAll(".material-symbols-outlined");
let item = document.querySelectorAll(".item");


function icon(){
    for(let i = 0; i < icon.length; i++){
        icon[i].style.backgroundColor = "green";
        icon[i].style.fontWeight = "900";
    }
}

// icon();