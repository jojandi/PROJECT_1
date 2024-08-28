<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>
    <link rel="stylesheet" href="layout.css" type="text/css">
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <link href="./assets/css/admin_table.css" rel="stylesheet">
    <link href="./assets/css/00.user_base_login.css" rel="stylesheet">
    <link href="./assets/css/00.user_side_base.css" rel="stylesheet">
    <link href="./assets/css/admin.css" rel="stylesheet">
    <link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <link href="./assets/css/click.css" rel="stylesheet">
    <style>
        

        
        #pagination button {
            margin: 0 4px;
            padding: 8px 16px;
        }

        /* #pagination {
            text-align: center;
        } */

        .write {
            text-align: right;
            margin-top: 35px;
        }

        .btnnn {
            padding: 10px 20px;
            font-size: 16px;
            cursor: pointer;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
        }
        .delete-btn {
            background-color: #d9534f;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
            border-radius: 4px;
        }
        .delete-btn:hover {
            background-color: #c9302c;
        }
        section h3{
            border: 1px solid #ccc;
            width: 100%;
            text-align: center;
            font-size: 22px;
            padding: 17px;
            box-sizing: border-box;
        }
        .notince {
            width: 100%;
            height: 80%;
            display: inline-block;
        }
        .t1 {
            width: 100%;
            height: 78%;
        }
        .t1 div {
            height: 515px;
        }
        #menu #items #i6{
            font-weight: 900;
            text-decoration: underline;
        } 
    </style>
</head>

<body>

    <!-- 가장 위 고정 -->
    <header id="top" class="clearfix">

        <div id="logoall">
            <div id="logo" class="left"><a href="mes_mainPage.html"><img class="logo_img"
                        src="https://cdn.discordapp.com/attachments/1263360143756759099/1267275014273634415/KakaoTalk_20240729_090859720-removebg-preview_3.png?ex=66a83154&is=66a6dfd4&hm=4f6d706e06b34db529815a64763136b9f3f073d06fbc4513dd57c737077310f0&"></a>
            </div>
            <!-- <div id="name" class="left">행복만땅 <br>도서관</div> -->
        </div>

        <div id="menu">
            <div id="items" class="left">
                <div class="item" id="i1"><a href="mes_pfwork.html">작업 수행</a></div>
                <div class="item" id="i2"><a href="admin_library.html">생산 관리</a></div>
                <div class="item" id="i3"><a href="/Park_2/stock">재고 관리</a></div>
                <div class="item" id="i4"><a href="mes_human.html">직원 관리</a></div>
                <div class="item" id="i5"><a href="mes_statistics_1.html">통계 및 분석</a></div>
                <div class="item" id="i6"><a href="/Park_2/notice">게시판</a></div>
            </div>
            <div class="right" id="userall">
                <div>OOO관리자</div>
                <div><a href="../사용자용 페이지/01.main_user.html">로그아웃</a></div>
                <!-- <div class="inb" id="login">로그인</div>
                <div class="inb">|</div>
                <div class="inb" id="userin">회원가입</div>
                <div class="inb" id="menus"></div> -->
            </div>
        </div>
    </header>


    <!-- 여기 사이에 이것 저것 코딩하세용 >< -->
    <div id="wrap">
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">게시판</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span>게시판</span>
                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    </div>
                </div>
            </div>
        </aside>
        <section>
            <div class="main_page">
                <h3>게시판</h3>
                <div class="notince" >
                    <div class="t1">
                        <div>
                            <table>
                                <tr>
                                    <th>번호</th>
                                    <th>제목</th>
                                    <th>작성자</th>
                                    <th>작성날짜</th>
                                    <th>삭제</th>
                                </tr>
                                <tbody id="posts">
                                    <!-- 게시글 데이터가 여기에 삽입됩니다 -->
                                </tbody>
                            </table>
                        </div>
                    </div>
                    <div id="pagination"></div>
                    <div class="scc">
                        <input class="sch" type="text" name="search" placeholder="검색어를 입력하세요">
                        <button class="sb" name="검색" value="검색">검색</button>
                    </div>
                    <div class="write">
                        <a href="mes_notice_2.html">
                            <input type="button" class="btnnn" value="글쓰기">
                        </a>
                    </div>
                </div>
            </div>
        </section>
    </div>


    <!-- 가장 아래 고정 -->
    <footer>
        <div id="bottom" class="clearfix">

            <div id="logoall">
                <div id="logo" class="left"></div>
                <div id="name" class="left">행복만땅 <br>도서관</div>
            </div>

            <div id="footerinfo">
                Tel : 중앙도서관 : 041-521-3721 신방도서관 : 041-521-3724
                청수도서관 : 041-521-3725 쌍용도서관 : 041-521-3731 두정도서관 : 041-521-3733
            </div>

        </div>
    </footer>
    <script>
        $(document).ready(function () {
            $('.cate ul').hide(); // 버튼 누르기 전에 ul 리스트들 숨기기
            $('.cate .menu .subopen').click(function () {
                var $this = $(this);
                var $menu = $this.closest('.menu'); // 클릭된 항목의 부모 .menu
                var $currentUl = $menu.siblings('ul'); // 현재 클릭된 항목의 ul
                if ($this.hasClass('active')) {
                    // 현재 열려있는 ul 숨기기
                    $currentUl.slideUp('fast');
                    $this.removeClass('active'); // 현재 버튼에서 active 클래스 제거
                    $menu.removeClass('active'); // 현재 부모 .menu에서 active 클래스 제거
                } else {
                    // 모든 .menu에서 active 클래스 제거
                    $('.cate .menu').removeClass('active');
                    // 모든 ul 숨기기
                    $('.cate ul').slideUp('fast');
                    // 클릭된 항목의 ul 보이기
                    $currentUl.slideDown('fast');
                    $this.addClass('active'); // 클릭된 버튼에 active 클래스 추가
                    $menu.addClass('active'); // 클릭된 버튼의 부모 .menu에 active 클래스 추가
                }
            });
        });

        window.onload = function () {
            let userpmo = document.getElementById('userpmo');
            let username = document.getElementById('username');
            let decodedData = decodeURIComponent(new URLSearchParams(window.location.search).get('param1'));//get 방식으로 받아온 유저 정보를 json객체로 만들기 위한 과정
            let decodedDataJson = JSON.parse(decodedData);//json화



            const postsContainer = document.getElementById('posts');
            const paginationContainer = document.getElementById('pagination');
            const posts = JSON.parse(localStorage.getItem('posts1')) || [];
            const postsPerPage = 10; // 페이지당 게시글 수
            let currentPage = 1; // 현재 페이지
            let searchResults = [];
            let isSearching = false;

            function paginatePosts(posts, page, postsPerPage) {
                const start = (page - 1) * postsPerPage;
                const end = start + postsPerPage;
                return posts.slice(start, end);
            }

            function createPaginationButtons(totalPosts, postsPerPage) {
                const totalPages = Math.ceil(totalPosts / postsPerPage);
                let buttons = '';
                for (let i = 1; i <= totalPages; i++) {
                    buttons += `<button onclick="goToPage(${i})">${i}</button>`;
                }
                paginationContainer.innerHTML = buttons;
            }

            function goToPage(page) {
                currentPage = page;
                if (isSearching) {
                    displayPosts(searchResults);
                } else {
                    displayPosts(posts);
                }
            }

            function displayPosts(data) {
                let paginatedPosts = paginatePosts(data, currentPage, postsPerPage);
                let postsHtml = '';
                paginatedPosts.forEach((post, index) => {
                    const globalIndex = (currentPage - 1) * postsPerPage + index;
                    postsHtml += `
                        <tr>
                            <td>${globalIndex + 1}</td>
                            <td><a href="mes_notice_2.html?postIndex=${globalIndex}">${post.title}</a></td>
                            <td>${post.author}</td>
                            <td>${post.date}</td>
                            <td><button class="delete-btn" data-index="${globalIndex}">삭제</button></td>
                        </tr>
                    `;
                });
                postsContainer.innerHTML = postsHtml;

                const deleteButtons = document.querySelectorAll('.delete-btn');
                deleteButtons.forEach(button => {
                    button.addEventListener('click', function () {
                        const index = this.getAttribute('data-index');
                        deletePost(index);
                    });
                });
            }

            function deletePost(index) {
                if (confirm('정말로 이 글을 삭제하시겠습니까?')) {
                    posts.splice(index, 1);
                    localStorage.setItem('posts1', JSON.stringify(posts));
                    if (isSearching) {
                        searchResults = searchResults.filter((_, i) => i !== index);
                        displayPosts(searchResults);
                        createPaginationButtons(searchResults.length, postsPerPage);
                    } else {
                        displayPosts(posts);
                        createPaginationButtons(posts.length, postsPerPage);
                    }
                }
            }

            createPaginationButtons(posts.length, postsPerPage);
            displayPosts(posts);

            document.querySelector('.sb').addEventListener('click', function () {
                let searchText = document.querySelector('.sch').value.trim().toLowerCase();
                searchResults = posts.filter(post => post.title.toLowerCase().includes(searchText));
                isSearching = true;
                createPaginationButtons(searchResults.length, postsPerPage);
                goToPage(1);
            });

            document.querySelector('.sch').addEventListener('keyup', function (event) {
                if (event.keyCode === 13) {
                    event.preventDefault();
                    document.querySelector('.sb').click();
                }
            });

            window.goToPage = goToPage;
        }
    </script>
</body>

</html>