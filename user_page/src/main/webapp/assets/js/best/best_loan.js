let reserBnt = document.querySelectorAll(".reserBnt"); // 예약하기 버튼
let cartBnt = document.querySelectorAll(".cartBnt"); // 장바구니 버튼

let reser = document.querySelectorAll(".reser"); // 예약 블럭


function login(){

	for(let i = 0 ; i < reserBnt.length; i++){
        reserBnt[i].addEventListener('click', function(e){
			if(login == null){
                e.preventDefault();
				alert("로그인 후 이용 가능합니다. ")
			} else{
	           console.log('예약하기 클릭!!!');
	           alert("해당 도서가 예약되었습니다. ")
			}
        })   
    }
    
    for(let i = 0 ; i < cartBnt.length; i++){
        cartBnt[i].addEventListener('click', function(e){
            if(login == null){
                e.preventDefault();
				alert("로그인 후 이용 가능합니다. ")
			} else{
	           console.log('장바구니 클릭!!!');
	           alert("해당 도서가 장바구니에 담겼습니다. ")
			}
        })
        
    }
}


login();
// reserOn();
// cartOn();