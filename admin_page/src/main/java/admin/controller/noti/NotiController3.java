package admin.controller.noti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.notice.NoticeService;



@WebServlet("/admin/notice3")
public class NotiController3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeService noticeService = new NoticeService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
    	System.out.println("공지사항3 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti3.jsp").forward(request, response);
    }


    
=======
        System.out.println("공지사항3 doGet 실행!");
        response.setContentType("text/html; charset=utf-8;");

		
		

	
		request.getRequestDispatcher("/WEB-INF/admin/notification/notice3.jsp").forward(request, response);
    }
>>>>>>> 452ea8c769d96c5395bede0953f63ec096bcf303
    
    

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
    }
}