<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/inven/admin_inven.css" rel="stylesheet">
</head>
<body>
    <div id="wrap">
        <aside class="clearfix" id="side">
            <div id="sideleft">
                <h2 id="title">재고 현황</h2>
                <div id="items">
                    <div class="item" id="i1">
                        <span>실시간 재고 현황</span>
                        <span class="material-symbols-outlined active">arrow_forward_ios</span>
                    </div>
                    <div class="item" id="i2">
                        <span>도서 예약 현황</span>
                        <span class="material-symbols-outlined">arrow_forward_ios</span>
                    </div>
                </div>
            </div>
        </aside>
        <section>
            <div class="main_page" id="main_page_1">
                <h3>실시간 재고 현황</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <colgroup>
                                <col width="5%">
                                <col width="25%">
                                <col width="10%">
                                <col width="8%">
                                <col width="10%">
                                <col width="10%">
                                <col width="5%">
                                <col width="7%">
                            </colgroup>
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">도서명</th>
                                    <th>저자명</th>
                                    <th>출판사</th>
                                    <th>출판연도</th>
                                    <th>도서코드</th>
                                    <th>ISBN</th>
                                    <th>권 수</th>
                                    <th>도서관</th>
                                    <th>입고일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>작별인사</td>
                                    <td>김영하</td>
                                    <td>문학동네</td>
                                    <td>2024.01.15</td>
                                    <td>code001</td>
                                    <td>101</td>
                                    <td>15</td>
                                    <td>두정도서관</td>
                                    <td>2024.01.15</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>나는 나로 살기로 했다</td>
                                    <td>김수현</td>
                                    <td>위즈덤하우스</td>
                                    <td>2023.05.20</td>
                                    <td>code002</td>
                                    <td>102</td>
                                    <td>12</td>
                                    <td>청수도서관</td>
                                    <td>2023.05.20</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>빨간 머리 앤</td>
                                    <td>루시 모드 몽고메리</td>
                                    <td>더클래식</td>
                                    <td>2023.07.30</td>
                                    <td>code003</td>
                                    <td>103</td>
                                    <td>25</td>
                                    <td>쌍용도서관</td>
                                    <td>2023.07.30</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>오롯이 나</td>
                                    <td>장강명</td>
                                    <td>문학과지성사</td>
                                    <td>2023.04.10</td>
                                    <td>code004</td>
                                    <td>104</td>
                                    <td>20</td>
                                    <td>중앙도서관</td>
                                    <td>2023.04.10</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>지금, 여기</td>
                                    <td>박상영</td>
                                    <td>인플루엔셜</td>
                                    <td>2023.09.15</td>
                                    <td>code005</td>
                                    <td>105</td>
                                    <td>18</td>
                                    <td>두정도서관</td>
                                    <td>2023.09.15</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>타인의 삶</td>
                                    <td>김혜자</td>
                                    <td>한겨레출판</td>
                                    <td>2023.03.05</td>
                                    <td>code006</td>
                                    <td>106</td>
                                    <td>22</td>
                                    <td>두정도서관</td>
                                    <td>2023.03.05</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>인간의 조건</td>
                                    <td>김도언</td>
                                    <td>갈매나무</td>
                                    <td>2023.06.25</td>
                                    <td>code007</td>
                                    <td>107</td>
                                    <td>30</td>
                                    <td>쌍용도서관</td>
                                    <td>2023.06.25</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>내가 사랑한 유럽</td>
                                    <td>윤이형</td>
                                    <td>한길사</td>
                                    <td>2023.08.10</td>
                                    <td>code008</td>
                                    <td>108</td>
                                    <td>16</td>
                                    <td>신방도서관</td>
                                    <td>2023.08.10</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>지금, 이 순간</td>
                                    <td>이기주</td>
                                    <td>북라이프</td>
                                    <td>2023.02.01</td>
                                    <td>code009</td>
                                    <td>109</td>
                                    <td>28</td>
                                    <td>쌍용도서관</td>
                                    <td>2023.02.01</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>해리포터와 마법사의 돌</td>
                                    <td>J.K. 롤링</td>
                                    <td>문학동네</td>
                                    <td>2023.11.01</td>
                                    <td>code010</td>
                                    <td>110</td>
                                    <td>35</td>
                                    <td>쌍용도서관</td>
                                    <td>2023.11.01</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>도둑맞은 책</td>
                                    <td>마르크스 제이미슨</td>
                                    <td>정신세계</td>
                                    <td>2023.12.15</td>
                                    <td>code011</td>
                                    <td>111</td>
                                    <td>10</td>
                                    <td>신방도서관</td>
                                    <td>2023.12.15</td>
                                </tr>
                                <tr>
                                    <th><input type="checkbox" class="p1_main_chack"></th>
                                    <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                    <td>에이미 샤</td>
                                    <td>북플레저</td>
                                    <td>2024.07.10</td>
                                    <td>code011</td>
                                    <td>112</td>
                                    <td>13</td>
                                    <td>두정도서관</td>
                                    <td>2024.07.15</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
                        <div class="search-container">
                            <input type="text" id="searchInput" placeholder="도서명 검색...">
                        </div>
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>

            <div class="main_page" id="main_page_2">
                <h3>실시간 도서 예약</h3>
                <div>
                    <div class="page_2">
                        <table id="main_library">
                            <thead>
                                <tr>
                                    <th><input type="checkbox" id="p1_checkAll"></th>
                                    <th class="sortable">도서명</th>
                                    <th>도서 코드</th>
                                    <th>예약자</th>
                                    <th>예약자 Id</th>
                                    <th>예약도서관</th>
                                    <th>예약일</th>
                                    <th>반납예정일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>미드나잇 라이브러리</td>
                                    <td>001</td>
                                    <td>박규태</td>
                                    <td>user01</td>
                                    <td>중앙도서관</td>
                                    <td>2024-07-01</td>
                                    <td>2024-07-15</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>죽고 싶지만 떡볶이는 먹고 싶어</td>
                                    <td>002</td>
                                    <td>이제섭</td>
                                    <td>user02</td>
                                    <td>쌍용도서관</td>
                                    <td>2024-07-02</td>
                                    <td>2024-07-16</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>지구 끝의 온실</td>
                                    <td>003</td>
                                    <td>조민정</td>
                                    <td>user03</td>
                                    <td>신방도서관</td>
                                    <td>2024-07-03</td>
                                    <td>2024-07-17</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>달러구트 꿈 백화점</td>
                                    <td>004</td>
                                    <td>김아영</td>
                                    <td>user04</td>
                                    <td>두정도서관</td>
                                    <td>2024-07-04</td>
                                    <td>2024-07-18</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>모든 순간이 너였다</td>
                                    <td>005</td>
                                    <td>김승환</td>
                                    <td>user05</td>
                                    <td>중앙도서관</td>
                                    <td>2024-07-05</td>
                                    <td>2024-07-19</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>완전한 행복</td>
                                    <td>006</td>
                                    <td>현준수</td>
                                    <td>user06</td>
                                    <td>쌍용도서관</td>
                                    <td>2024-07-06</td>
                                    <td>2024-07-20</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>트렌드 코리아 2024</td>
                                    <td>007</td>
                                    <td>박규태</td>
                                    <td>user01</td>
                                    <td>두정도서관</td>
                                    <td>2024-07-07</td>
                                    <td>2024-07-21</td>
                                </tr>
                                <tr>
                                    <td><input type="checkbox"></td>
                                    <td>여행의 이유</td>
                                    <td>008</td>
                                    <td>김아영</td>
                                    <td>user04</td>
                                    <td>신방도서관</td>
                                    <td>2024-07-08</td>
                                    <td>2024-07-22</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="bot_btn">
                        <input type="button" value="Excel 파일화">
                    </div>
                </div>
            </div>

            <div class="main_page" id="main_page_3">
                <h3>도서 구매</h3>
                <div>
                    <div class="table_wrap">
                        <div class="page_1">
                            <table id="main_library_1">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" id="p1_checkAll"></th>
                                        <th class="sortable">도서명</th>
                                        <th>저자명</th>
                                        <th>출판사</th>
                                        <th>요청 도서관</th>
                                        <th>출판연도</th>
                                        <th>도서코드</th>
                                        <th>발주 권수</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <th><input type="checkbox" class="p1_main_chack"></th>
                                        <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                        <td>에이미 샤</td>
                                        <td>북플레저</td>
                                        <td>중앙도서관</td>
                                        <td>2024.07.10</td>
                                        <td>as123</td>
                                        <td><input class="input_style" type="text"></td>
                                    </tr>
                                    <tr>
                                        <th><input type="checkbox" class="p1_main_chack"></th>
                                        <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                        <td>에이미 샤</td>
                                        <td>북플레저</td>
                                        <td>신방도서관</td>
                                        <td>2024.07.10</td>
                                        <td>as123</td>
                                        <td><input class="input_style"" type="text"></td>
                                    </tr>
                                    <tr>
                                        <th><input type="checkbox" class="p1_main_chack"></th>
                                        <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                        <td>에이미 샤</td>
                                        <td>북플레저</td>
                                        <td>청수도서관</td>
                                        <td>2024.07.10</td>
                                        <td>as123</td>
                                        <td><input class="input_style"" type="text"></td>
                                    </tr>
                                    <tr>
                                        <th><input type="checkbox" class="p1_main_chack"></th>
                                        <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                        <td>에이미 샤</td>
                                        <td>북플레저</td>
                                        <td>쌍용도서관</td>
                                        <td>2024.07.10</td>
                                        <td>as123</td>
                                        <td><input class="input_style" type="text"></td>
                                    </tr>
                                    <tr>
                                        <th><input type="checkbox" class="p1_main_chack"></th>
                                        <td>나는 도대체 왜 피곤할까 (이 죽일 놈의 피로와 결별하는 법)</td>
                                        <td>에이미 샤</td>
                                        <td>북플레저</td>
                                        <td>두정도서관</td>
                                        <td>2024.07.10</td>
                                        <td>as123</td>
                                        <td><input class="input_style" type="text"></td>
                                    </tr>
                                </tbody>
                            </table>

                        </div>
                        <div class="bot_btn">
                            <input id="page3_btn_1" type="button" value="발주">
                        </div>

                        <div class="page_1">
                            <h3>도서 구매 내역</h3>
                            <table id="main_library_2">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" id="p2_checkAll"></th>
                                        <th class="sortable">도서명</th>
                                        <th>저자명</th>
                                        <th>출판사</th>
                                        <th>출판연도</th>
                                        <th>도서코드</th>
                                        <th>발주 권수</th>
                                    </tr>
                                </thead>
                                <tbody>

                                </tbody>
                            </table>

                        </div>
                        <div class="bot_btn">
                            <input type="button" value="Excel 파일화">
                            <input id="comp_btn" type="button" value="완료">
                        </div>
                    </div>

                </div>
            </div>
        </section>
    </div>
</body>
</html>