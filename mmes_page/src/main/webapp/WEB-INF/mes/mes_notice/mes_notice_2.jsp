<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="./assets/css/mes_notice2.css" rel="stylesheet">
    <title>공지사항 글쓰기</title>
</head>
<body>
    <div class="container">
        <h1>게시판</h1>
        <form id="postForm">
            <h2>게시판 글쓰기</h2>
            <label for="title">제목</label>
            <input type="text" id="title" name="notice_name" required>
            
            <label for="content">내용</label>
            <textarea id="content" name="notice_contents" rows="10" required></textarea>

            <label for="author">작성자</label>
            <input type="text" id="author" name="emp_name" required>
            
            <button type="submit">제출</button>
        </form>
        <div id="postDisplay" style="display:none;">
            <!-- <h2>작성된 게시판</h2> -->
            <h3 id="postTitle"></h3>
            <p id="postContent"></p>
            <h4 id="postAuthor"></h4>
            <h2>댓글</h2>
            <div id="comments" class="comments"></div>
            <form id="commentForm">
                <label for="comment">댓글 작성</label>
                <textarea id="comment" name="comment" rows="4" required></textarea>
                <button type="button">댓글 달기</button>
            </form>
        </div>
    </div>

        
</body>
</html>