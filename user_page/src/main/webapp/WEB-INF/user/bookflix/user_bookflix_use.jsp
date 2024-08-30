<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../assets/css/bookflix/bookflix_use.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<link rel="stylesheet"
        href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />

    <div id="wrap">
        <div id="parent">
            <div id="top_logo">
                <img id="top_logo_img"
                    src="../assets/img/bookflix.png">
            </div>

            <div id="top_box">
                <div>
                    조잔디님은 2024.7.30 부터 구독 하셨습니다. <br>
                    도서 대여기간은 7월 30일부터 8월 30일 입니다.
                </div>
            </div>

            <div class="top_for_you">
                조잔디님만을 위한 취향저격 이달의 추천 도서
                <div id="top_in_for_you">
                    조잔디님을 위한 책을 소개시켜드릴게요!<br>
                    인공지능 데이터를 토대로 추천 해드립니다.
                </div>
            </div>
            
            <div id="book_1_parent">

                
                <div id="bookall">
                    <div class="book">
                        <img id="book_1_img"
                            src="https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/9791170611561.jpg">

                        <div>
                            <div class="btn">
                                <button class="popupBnt">책정보 보기</button>
                            </div>

                            <div id="popup1" class="popup">
                                <div class="popup-header">
                                    <h2>당신이 누군가를 죽였다</h2>
                                    <span class="popup-close">&times;</span>
                                </div>
                                <p>저자명: 히가시노 게이고</p>
                                <p>출판사: 북다</p>
                                <p>출판일: 2024.07.23</p>
                                <p>“미스터리란 어떤 소설인가? 라는 질문을 들었을 때 이런 소설이다, 라고 대답할 수 있는 작품입니다.”작품은 장르문학계의 거장인 작가가
                                    101번째 작품을 맞아 추리소설의 원점으로 돌아가 ‘황금시대 미스터리’의 매력을 유감없이 발휘한 걸작으로 평단과 독자의 호평을 받고
                                    있다. 1986년 발표된 『졸업』을 시작으로 장장 38년째 이어진 히가시노 게이고 미스터리의 정수인 〈가가 형사 시리즈〉 열두 번째
                                    작품이기도 한 신작은, 2023년 출간 즉시 일본 서점 미스터리 판매 전체 1위를 석권하며 세월이 지나도 변치 않는 시리즈의 인기를
                                    증명했다. 『당신이 누군가를 죽였다』는 호화 별장지에 여름 휴가를 온 다섯 가족의 파티로 시작한다. 하지만 그날 밤, 다섯 명이
                                    살해당하고 한 명이 다치는 사건이 벌어지고, 살아남은 사람들은 참극의 진상을 밝히기 위해 검증회를 연다. 그 자리에 장기 휴가 중이던
                                    형사 ‘가가 교이치로’가 참석하고, 그는 사람들이 저마다 감추고 있던 비밀을 파헤치기 시작한다. 작품은 재미있는 본격 미스터리의 필수
                                    요소를 몹시 정교하게 구현하고 있다. </p>
                            </div>

                        </div>

                    </div>
                    <div class="book">
                        <img id="book_2_img"
                            src="https://contents.kyobobook.co.kr/sih/fit-in/300x0/pdt/9788930041683.jpg">

                        <div>
                            <div class="btn">
                                <button class="popupBnt">책정보 보기</button>
                            </div>

                            <div id="popup2" class="popup">
                                <div class="popup-header">
                                    <h2>허송세월</h2>
                                    <span class="popup-close">&times;</span>
                                </div>
                                <p>김훈</p>
                                <p>출판사: 나남</p>
                                <p>출판일: 2024.06.20</p>
                                <p>삶의 어쩔 수 없는 비애와 아름다움을 누구보다 잘 이해하는 우리 시대의 문장가, 김훈. 시간과 공간 속으로 삭아드는 인생의 단계를
                                    절감한다는 그가 “겪은 일을 겪은 대로” 쓴 신작 산문을 들고 돌아왔다. 생과 사의 경계를 헤매고 돌아온 경험담, 전쟁의 야만성을 생활
                                    속의 유머로 승화해 낸 도구에 얽힌 기억, 난세를 살면서도 푸르게 빛났던 역사의 청춘들, 인간 정서의 밑바닥에 고인 온갖 냄새에
                                    이르기까지, 그의 치열한 ‘허송세월’을 담은 45편의 글이 실렸다. ‘본래 스스로 그러한 세상’의 이치를 아는 이로서 그 어느 때보다
                                    명료하고도 섬세한 문체로 생활의 정서를 파고든 《허송세월》은 김훈 산문의 새 지평이다.</p>
                            </div>

                            
                        </div>

                    </div>
                </div>

            </div>
            
            <div id="review">
            	<div>
            		BOOKFLIX에 대한 평가를 남겨주세요!
            	</div>
	            <button type="button" id="reviewBnt">리뷰쓰기</button>
	            
	            <form method="post" action="bookflixk_review" id="form">
		            <div id="reviewPopup">
		            	<div class="close">
			            	<span class="popup-close">&times;</span>
		            	</div>
		            	<div class="star-rating">
		            		<span>별점 : </span>
						   	<input type="checkbox" name="star" class="star" value="1">
						   	<input type="checkbox" name="star" class="star" value="2">
						   	<input type="checkbox" name="star" class="star" value="3">
						   	<input type="checkbox" name="star" class="star" value="4">
						   	<input type="checkbox" name="star" class="star" value="5">
						 </div>
		                <textarea name="review_text" id="review_text" placeholder=" 리뷰를 입력해주세요. "></textarea>
		                <br>
		                <button type="submit" id="end">작성완료</button>
		            </div>
	            </form>
            </div>

    <!-- wrap -->
        </div>
    <script src="../assets/js/bookflix/bookflix_use.js"></script>
    </div>
    
     <!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>

</body>
</html>