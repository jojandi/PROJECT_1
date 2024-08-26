function openPopup(id) {
            const popup = document.getElementById('popup' + id);
            if (popup) {
                popup.style.display = 'block';
            }
        }

        function closePopup(id) {
            const popup = document.getElementById('popup' + id);
            if (popup) {
                popup.style.display = 'none';
            }
        } 

        function reviewOn(){
            let review = document.querySelectorAll(".review");
            let reviewBnt = document.querySelectorAll(".reviewBnt");
            let end = document.querySelectorAll(".end");

            for(let i = 0; i < review.length; i++){
                reviewBnt[i].addEventListener('click', function(){
                    review[i].style.display='block';
                })
                end[i].addEventListener('click', function(){
                    alert("리뷰 작성이 완료되었습니다. ");
                    review[i].style.display='none';
                })
            }
        }

        reviewOn();