package admin.controller.noti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;


@WebServlet("/notice/delete")
public class NotiDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("notidelete doGet 실행");
		
		int notice = Integer.parseInt(request.getParameter("ann_seq"));
		
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setAnn_seq(notice);
		
		NoticeService noticeService = new NoticeService();
		int result = noticeService.delete(noticeDTO);
		System.out.println("result : " + result);
		request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").forward(request, response);
//		response.sendRedirect("/admin_page/noti2");
	}

}
