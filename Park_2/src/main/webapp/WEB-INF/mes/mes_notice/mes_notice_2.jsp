<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 글쓰기</title>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h1, h2 {
            text-align: center;
            color: #333;
        }
        form {
            display: flex;
            flex-direction: column;
        }
        label {
            margin-top: 10px;
            font-weight: bold;
        }
        input[type="text"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        button {
            margin-top: 20px;
            padding: 10px;
            border: none;
            background-color: #5cb85c;
            color: white;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }
        button:hover {
            background-color: #4cae4c;
        }
        .comments {
            margin-top: 40px;
        }
        .comment {
            padding: 10px;
            border-top: 1px solid #ddd;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>게시판</h1>
        <form id="postForm">
            <h2>게시판 글쓰기</h2>
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required>
            
            <label for="content">내용</label>
            <textarea id="content" name="content" rows="10" required></textarea>

            <label for="author">작성자</label>
            <input type="text" id="author" name="author" required>
            
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
                <button type="submit">댓글 달기</button>
            </form>
        </div>
    </div>
    <script>
        document.getElementById('postForm').addEventListener('submit', function(event) {
            event.preventDefault();
            const title = document.getElementById('title').value;
            const content = document.getElementById('content').value;
            const author = document.getElementById('author').value;

            const posts = JSON.parse(localStorage.getItem('posts1')) || [];
            const newPost = {
                title: title,
                content: content,
                author: author,
                date: new Date().toLocaleString(),
                comments: []
            };
            posts.push(newPost);
            localStorage.setItem('posts1', JSON.stringify(posts));

            alert('글이 저장되었습니다!');
            window.location.href = 'mes_notice_1.html';
        });

        function displayPost(postIndex) {
            const posts = JSON.parse(localStorage.getItem('posts1')) || [];
            if (postIndex >= 0 && postIndex < posts.length) {
                const post = posts[postIndex];
                document.getElementById('postTitle').innerText = post.title;
                document.getElementById('postContent').innerText = post.content;
                document.getElementById('postAuthor').innerText = '작성자: ' + post.author;
                document.getElementById('postDisplay').style.display = 'block';
                document.getElementById('postForm').style.display = 'none';
                const commentsContainer = document.getElementById('comments');
                commentsContainer.innerHTML = '';
                post.comments.forEach(comment => {
                    const commentDiv = document.createElement('div');
                    commentDiv.className = 'comment';
                    commentDiv.innerText = comment;
                    commentsContainer.appendChild(commentDiv);
                });
                document.getElementById('commentForm').onsubmit = function(event) {
                    event.preventDefault();
                    const comment = document.getElementById('comment').value;
                    post.comments.push(comment);
                    localStorage.setItem('posts1', JSON.stringify(posts));
                    const commentDiv = document.createElement('div');
                    commentDiv.className = 'comment';
                    commentDiv.innerText = comment;
                    commentsContainer.appendChild(commentDiv);
                    document.getElementById('comment').value = '';
                };
            }
        }

        const urlParams = new URLSearchParams(window.location.search);
        const postIndex = urlParams.get('postIndex');
        if (postIndex !== null) {
            displayPost(parseInt(postIndex, 10));
        }
    </script>
</body>
</html>