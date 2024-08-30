package mes_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesNoticeDTO;
import mes_service.MesNoticeService;

@WebServlet("/notice_delete")
public class MesNoticeDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("notice_delete doGet 실행");
		
		int notice_id = Integer.parseInt(request.getParameter("notice_id"));
		
		MesNoticeDTO NoticeDTO = new MesNoticeDTO();
		NoticeDTO.setNotice_id(notice_id);
		
		MesNoticeService NoticeService = new MesNoticeService();
		int result = NoticeService.delete(NoticeDTO);
		System.out.println("result : " + result);
		
		response.sendRedirect("/mmes_page/notice");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
