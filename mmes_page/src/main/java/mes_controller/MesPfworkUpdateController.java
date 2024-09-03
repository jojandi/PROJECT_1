package mes_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesNoticeDTO;
import mes_DTO.MesPfworkDTO;
import mes_service.MesNoticeService;
import mes_service.MesPfworkService;

@WebServlet("/not")
public class MesPfworkUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update doGet 실행");
		
		int os_id = Integer.parseInt( request.getParameter("os_id") );
		
		MesPfworkService PfworkService = new MesPfworkService();
		MesPfworkDTO PfworkDTO = PfworkService.get(os_id);
		
		request.setAttribute("update", PfworkDTO);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_notice/mes_noticeUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("update doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String notice_id = request.getParameter("notice_id");
//	    System.out.println(notice_id);
	    String notice_name = request.getParameter("notice_name");
	    System.out.println(notice_name);
	    String notice_contents = request.getParameter("notice_contents");
	    
	    MesNoticeDTO NoticeDTO = new MesNoticeDTO();
	    NoticeDTO.setNotice_id( Integer.parseInt(notice_id) );
	    NoticeDTO.setNotice_name(notice_name);
	    NoticeDTO.setNotice_contents(notice_contents);
	    
	    MesNoticeService NoticeService = new MesNoticeService();
	    int result = NoticeService.update(NoticeDTO);
	    System.out.println("insert : " + result);
	    
	    response.sendRedirect("/mmes_page/notice");		
		
	}

}
