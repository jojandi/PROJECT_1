package admin.controller.noti;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DAO.noti.NoticeDAO3;
import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;



@WebServlet("/admin/notice3")
public class NotiController3 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeService noticeService = new NoticeService();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("공지사항3 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    int ann_seq = Integer.parseInt( request.getParameter("ann_seq") );
		System.out.println(ann_seq);
		
		NoticeDTO dto  = new NoticeDTO();
		NoticeDAO3 dto3  = new NoticeDAO3();
		
		dto = dto3.getNotiByPage(ann_seq);
		
		System.out.println("asdf : " + dto);
		
		request.setAttribute("notice", dto);
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti3.jsp").forward(request, response);
    }

		

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
    }
}