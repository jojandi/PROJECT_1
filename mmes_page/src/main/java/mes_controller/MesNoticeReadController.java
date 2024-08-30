package mes_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesNoticeDTO;
import mes_service.MesNoticeService;

@WebServlet("/notice_read")
public class MesNoticeReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("noticeRead doGet 실행");
		
		int notice_id = Integer.parseInt( request.getParameter("notice_id") );
		System.out.println(notice_id);
		
		MesNoticeService NoticeService = new MesNoticeService();
		MesNoticeDTO NoticeDTO = NoticeService.One(notice_id);
		
		System.out.println("asdf : " + NoticeDTO);
		
		request.setAttribute("read", NoticeDTO);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_notice/mes_noticeRead.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("noticeRead doPost 실행");
	}

}
