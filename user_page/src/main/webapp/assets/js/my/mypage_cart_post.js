
document.querySelector("#reserchk").addEventListener('click', function(){
    ajax_reschk();
})
document.querySelector("#delall").addEventListener('click', function(){
    ajax_del('post');
})
document.querySelector("#reserall").addEventListener('click', function(){
    ajax_resall('post');
})


function ajax_reschk() {

    //jQuery로 for문 돌면서 check 된값 배열에 담는다
    var lists = [];
    $("input[name='cart_chk']:checked").each(function(i){   
        lists.push($(this).val());
    });

    console.log(lists);
    console.log("code=" + lists + "&user=" + user )
    
    
    if(lists.length > 0){
        let url = 'reschk';
        
        // ajax
        let xhr = new XMLHttpRequest();
        
        xhr.open('post', url);
        
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
    
        xhr.send( "code=" + lists + "&user=" + user);
    
    } else{
        alert("도서를 선택해주세요. ")
    }
}

function ajax_del(method) {

    let seqs = [];

    $("input[name='cart_seq']").each(function(i){   
        seqs.push($(this).val());
    });

    console.log(seqs);
    
    if(seqs.length > 0){
	    let url = 'mypage_use';
	    
	    // ajax
	    let xhr = new XMLHttpRequest();
	    
	    xhr.open(method, url);
	    
	    if(method == 'get'){			
	        xhr.send();
	    } else{
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	    
	        xhr.send( "cart_seq=" + seqs );
	        
	    }
	
	
	    xhr.onload = function(){
	        // responseText : 서버에서 응답받은 데이터를 문자열로 반환
	        console.log(xhr.responseText);
	    }
	}
    
}

function ajax_resall(method) {

    let seqs = [];

    $("input[name='cart_seq']").each(function(i){   
        seqs.push($(this).val());
    });

    console.log(seqs);
    
    if(seqs.length > 0){
	    let url = 'mypage_use';
	    
	    // ajax
	    let xhr = new XMLHttpRequest();
	    
	    xhr.open(method, url);
	    
	    if(method == 'get'){			
	        xhr.send();
	    } else{
	        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
	    
	        xhr.send( "cart_seq=" + seqs );
	        
	    }
	
	
	    xhr.onload = function(){
	        // responseText : 서버에서 응답받은 데이터를 문자열로 반환
	        console.log(xhr.responseText);
	    }
	}
}



