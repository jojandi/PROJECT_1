window.onload = function () {
document.querySelector('#page_1').addEventListener('click', function () {
    document.querySelector('#main_page_1').style.display = 'inline-block';
    document.querySelector('#main_page_2').style.display = 'none';
    document.querySelector('#main_page_3').style.display = 'none';
});
document.querySelector('#page_2').addEventListener('click', function () {
    document.querySelector('#main_page_2').style.display = 'inline-block';
    document.querySelector('#main_page_1').style.display = 'none';
    document.querySelector('#main_page_3').style.display = 'none';
});
document.querySelector('#page_3').addEventListener('click', function () {
    document.querySelector('#main_page_3').style.display = 'inline-block';
    document.querySelector('#main_page_1').style.display = 'none';
    document.querySelector('#main_page_2').style.display = 'none';
});
}