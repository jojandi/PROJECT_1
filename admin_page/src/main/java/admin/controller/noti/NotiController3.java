package admin.controller.noti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin/noti3")
public class NotiController3 extends HttpServlet {
    private static final long serialVersionUID = 1L;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항3 doGet 실행!");
        response.setContentType("text/html; charset=utf-8;");

		String noti3 = request.getParameter("");
		System.out.println("empno : " + empno2);

	
		request.getRequestDispatcher("/WEB-INF/admin/notification/noti3.jsp").forward(request, response);
    }
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}