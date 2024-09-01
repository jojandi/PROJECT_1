<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 마이페이지</title>
<link href="../assets/css/my/user_mypage_info.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp" %>
	
	<div id="wrap">
        <!-- 사이드 -->
       	<%@ include file="/WEB-INF/user/my/user_mypage_side.jsp" %>

        <section id="info">

            <div id="stitle">
                <h3>조잔디님의 정보</h3>
            </div>
            
            <!-- 기본정보 -->
            <div id="information">  
                <div id="miniInfo"> 
                    <div id="profile"></div>
                    <div id="nickname">${ login.user_name }</div>
                    <div id="email">${ login.user_email }</div>
                    <div id="num">회원번호 : ${ login.user_seq }</div>
                    <div id="out">
                    	<form method="post" action="user_del">
		                    <a href="logout" id="logout">로그아웃</a>
		                    <input type="hidden" name="code" value="${login.user_seq}">
                    		<input type="submit" value="회원탈퇴" id="realout">
                    	</form>
                    </div>
                </div>

                <div id="booksub">
                    <div id="booklogo">
                        <img src="../assets/img/bookflix.png">
                    </div>

                    <div id="bookuser">
                        <div id="bookall">
                            <span>${ login.user_name }님의 이달의 추천 책</span>
    
                            <div id="books">
                                <table>
                                    <tr>
                                        <td>
                                            <img src="https://contents.kyobobook.co.kr/sih/fit-in/200x0/pdt/9791156756552.jpg">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="booktitle">죽여 마땅한 사람들</td>
                                    </tr>
                                </table>
                                <table>
                                    <tr>
                                        <td>
                                            <img src="https://contents.kyobobook.co.kr/sih/fit-in/200x0/pdt/9788950995454.jpg">
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="booktitle">곰탕 1:미래에서 온 살인자</td>
                                    </tr>
                                </table>
                            </div>
                        </div>
    
                        <div id="bookout">
                            탈퇴하기
                        </div>
                    </div>
                   
                </div>

                <!-- 정보수정 -->
                <div id="infoedit">
                    <h3 id="infoeditTite">내 정보 수정</h3>

                    <div id="info1">
                        <input type="password" id="pwIn" placeholder="비밀번호를 입력해주세요."><br>
                        <input type="submit" id="pwBnt" value="확인">
                        <div id="pwerror">비밀번호를 확인해주세요</div>
                    </div>
                    
                    <script>
	                    function info1On(){
	
	                        pwIn.addEventListener('keyup', function(event){
	                            if(event.keyCode == 13){
	                                pwBnt.click();
	                            }
	                        })
	
	                        pwBnt.addEventListener('click', function(){
	
	                            let pwIn = document.querySelector("#pwIn").value;
	                            let pw = '${ login.user_pw }';
	                            
	                            console.log(pw)
	                            console.log('비밀번호 확인 클릭!!!');
	                            console.log(pwIn);
	                            if(pwIn == pw){
	                                info2.style.display = "block";
	                                info1.style.display = "none";
	                            } else{
	                                pwerror.style.display = "block";
	                            }
	                        })
	                    }
	                    
	                    info1On();
                    </script>

                    <div id="info2">
                    <form method="post" action="update">
                        <table>
                            <tr>
                                <td class="center">이름</td>
                                <td>
                                    <span id="in1">
                                        ${ login.user_name }
                                    </span>
                                    <input type="text" id=nick name="name" value="${ login.user_name }">
                                    <input type="button" class="right" id="nickBtn" value="변경">
                                </td>
                            </tr>
                            <tr>
                                <td class="center">아이디</td>
                                <td>
                                    ${ login.user_id }
                                </td>
                            </tr>
                            <tr>
                                <td class="center">비밀번호</td>
                                <td id="pwedit">
                                    <span id="in2">
                                        <input type="password" id="pweditIn" value="${ login.user_pw }">
                                    </span>
                                    <input type="button" class="right" id="pweditBtn" value="변경">
                                </td>
                            </tr>
                            <tr>
                                <td class="center">전화번호</td>
                                <td>
                                    <span id="in3">${ login.user_tel }</span>
                                    <!-- <input type="text" id=number>
                                    <input type="button" class="right" id="numBnt" value="변경"> -->
                                </td>
                            </tr>
                        </table>
                        <div id=update>
	                        <input type="submit" value="변경하기">
                        </div>
                    </form>

                    </div>

                </div>

            </div>

        </section>

        <script src="../assets/js/my/mypage_info.js"></script>
    <!-- wrap -->
    </div>
    
    	<!-- footer -->
    <%@ include file="/WEB-INF/user/base/footer.jsp" %>
</body>
</html>