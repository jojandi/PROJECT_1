function popupOn(){
    let popup = document.querySelectorAll(".popup");
    let popupBnt = document.querySelectorAll(".popupBnt");
    let end = document.querySelectorAll(".popup-close");

    for(let i = 0; i < popup.length; i++){
        popupBnt[i].addEventListener('click', function(){
            popup[i].style.display='block';
        })
        end[i].addEventListener('click', function(){
            popup[i].style.display='none';
        })
    }
}

function reviewOn(){
    let review = document.querySelector("#reviewPopup");
    let reviewBnt = document.querySelector("#reviewBnt");
    let end = document.querySelector("#end");

    reviewBnt.addEventListener('click', function(){
        review.style.display='block';
    })
    end.addEventListener('click', function(){
        alert("리뷰 작성이 완료되었습니다. ");
        review.style.display='none';
    })
    
}

popupOn();
reviewOn();