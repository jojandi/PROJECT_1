<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>책 수정</title>
</head>
<body>
    <h3>책 수정</h3>
    <form action="updateBook" method="post">
        <c:forEach var="book" items="${books}">
            <input type="hidden" name="book_code" value="${book.mes_book_code}">
            <p>
                <label for="book_name_${book.mes_book_code}">도서명:</label>
                <input type="text" id="book_name_${book.mes_book_code}" name="book_name_${book.mes_book_code}" value="${book.book_name}" required>
            </p>
            <p>
                <label for="book_isbn_${book.mes_book_code}">ISBN 코드:</label>
                <input type="text" id="book_isbn_${book.mes_book_code}" name="book_isbn_${book.mes_book_code}" value="${book.book_isbn}" required>
            </p>
            <p>
                <label for="book_author_${book.mes_book_code}">저자:</label>
                <input type="text" id="book_author_${book.mes_book_code}" name="book_author_${book.mes_book_code}" value="${book.book_author}" required>
            </p>
            <p>
                <label for="book_pub_${book.mes_book_code}">출판사:</label>
                <input type="text" id="book_pub_${book.mes_book_code}" name="book_pub_${book.mes_book_code}" value="${book.book_pub}" required>
            </p>
            <p>
                <label for="book_count_${book.mes_book_code}">수량:</label>
                <input type="number" id="book_count_${book.mes_book_code}" name="book_count_${book.mes_book_code}" value="${book.book_count}" required>
            </p>
            <p>
                <label for="wh_code_${book.mes_book_code}">보관 위치:</label>
                <input type="text" id="wh_code_${book.mes_book_code}" name="wh_code_${book.mes_book_code}" value="${book.wh_code}" required>
            </p>
            <hr>
        </c:forEach>
        <input type="submit" value="수정 완료">
    </form>
</body>
</html>
