window.onload = function () {
    let pi1 = document.querySelector("#side #title");
    let pi2 = document.querySelector("#side #i1");
    let pi3 = document.querySelector("#side #i2");
    let pi4 = document.querySelector("#side #i3");

    pi1.addEventListener('click', function () {
        document.querySelector('#main_page_1').style.display = 'inline-block';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    document.querySelector('#p1_checkAll').addEventListener('click', function () {
        const isChecked = document.querySelector('#p1_checkAll').checked;
        if (isChecked) {
            const checkboxes = document.querySelectorAll('.p1_main_chack');

            for (const checkbox of checkboxes) {
                checkbox.checked = true;
            }
        }

        else {
            const checkboxes = document.querySelectorAll('.p1_main_chack');
            for (const checkbox of checkboxes) {
                checkbox.checked = false;
            }
        }
    })
    // page2
    pi2.addEventListener('click', function () {
        document.querySelector('#main_page_2').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_3').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page3
    pi3.addEventListener('click', function () {
        document.querySelector('#main_page_3').style.display = 'inline-block';
        document.querySelector('#main_page_1').style.display = 'none';
        document.querySelector('#main_page_2').style.display = 'none';
        document.querySelector('#main_page_4').style.display = 'none';
    });
    // page4
    // pi4.addEventListener('click', function () {
    //     document.querySelector('#main_page_4').style.display = 'inline-block';
    //     document.querySelector('#main_page_1').style.display = 'none';
    //     document.querySelector('#main_page_2').style.display = 'none';
    //     document.querySelector('#main_page_3').style.display = 'none';
    // });
}

