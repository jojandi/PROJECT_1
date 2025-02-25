package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_service.MesNoticeService;

@WebServlet("/notice")
public class MesNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/notice doget실행");
		
		MesNoticeService noticeService = new MesNoticeService();
		
		List list = noticeService.getNotice();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_notice/mes_notice_1.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
