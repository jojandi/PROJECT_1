package mes_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesWorkorderDAO;
import mes_DTO.MesWorkorderDTO;



@WebServlet("/updateBook")
public class MesWorkOrderBomUpdate_2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        MesWorkorderDAO bookDAO = new  MesWorkorderDAO();

        // Loop through all book fields
        for (String paramName : request.getParameterMap().keySet()) {
            if (paramName.startsWith("book_code")) {
                int bookCode = Integer.parseInt(request.getParameter(paramName));
                String bookName = request.getParameter("book_name_" + bookCode);
                String bookIsbn = request.getParameter("book_isbn_" + bookCode);
                String bookAuthor = request.getParameter("book_author_" + bookCode);
                String bookPub = request.getParameter("book_pub_" + bookCode);
                int bookCount = Integer.parseInt(request.getParameter("book_count_" + bookCode));
                String whCode = request.getParameter("wh_code_" + bookCode);

                MesWorkorderDTO book = new MesWorkorderDTO();
                book.setMes_book_code(bookCode);
                book.setBook_name(bookName);
                book.setBook_isbn(Long.parseLong(bookIsbn));
                book.setBook_author(bookAuthor);
                book.setBook_pub(bookPub);
                book.setBook_count(bookCount);
                book.setWh_code(whCode);

                bookDAO.updateBook(book);
            }
        }

        response.sendRedirect("bom_read.jsp");
    }


}


