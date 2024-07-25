const imoge = document.querySelectorAll('.material-symbols-outlined');
        imoge.forEach(button => {
            button.addEventListener('click', function () {
                imoge.forEach(btn => btn.classList.remove('active'));
                this.classList.add('active');
                const selectedGender = this.getAttribute('data-gender');
                console.log(`선택된 성별: ${selectedGender}`);
                if (selectedGender === 'female') {
                    window.location.href = 'best_we_woman.html';
                } else if (selectedGender === 'male') {
                    window.location.href = 'best_we_man.html';
                }
                //const goToPage2Button = document.getElementById('goToPage2');
                //window.location.href = 'best_we_2.html';            
            });

        });



        const buttons = document.querySelectorAll('.age-button');
        buttons.forEach(button => {
            button.addEventListener('click', function () {
                buttons.forEach(btn => btn.classList.remove('active'));
                this.classList.add('active');
                const selectedAge = this.getAttribute('data-age');
                console.log(`선택된 연령대: ${selectedAge}`);
                if (selectedAge === '10s') {
                    window.location.href = 'best_we_10.html';
                } else if (selectedAge === '20s') {
                    window.location.href = 'best_we_20.html';
                } else if (selectedAge === '30s') {
                    window.location.href = 'best_we_30.html';
                } else if (selectedAge === '40s') {
                    window.location.href = 'best_we_40.html';
                } else if (selectedAge === '50s') {
                    window.location.href = 'best_we_50.html';
                }
            });
        });

        let pi1 = document.querySelector("#sideleft #i1");
        let pi2 = document.querySelector("#sideleft #i2");
        let pi3 = document.querySelector("#sideleft #i3");
        let pi4 = document.querySelector("#sideleft #i4");

        function pageOn() {
            pi1.addEventListener('click', function () {
                window.location.href = "best_we_all.html"
            })
            pi2.addEventListener('click', function () {
                window.location.href = "best_we_man.html"
            })
            pi3.addEventListener('click', function () {
                window.location.href = "best_we_10.html"
            })

        };



        pageOn();