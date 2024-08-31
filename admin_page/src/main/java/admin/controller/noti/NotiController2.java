package admin.controller.noti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DAO.noti.NoticeDAO;


@WebServlet("/admin/noti2")
public class NotiController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeDAO noticeDAO = new NoticeDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 목록 doGet 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").forward(request, response);
        
        String action = request.getParameter("action");


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}