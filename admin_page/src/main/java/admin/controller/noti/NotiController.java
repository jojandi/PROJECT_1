package admin.controller.noti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import admin.service.notice.NoticeService;

@WebServlet("/admin/noti")
	public class NotiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeService noticeService = new NoticeService();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 doget 실행");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
    	
    	
    	
    	
    	request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");


    }
}
