package admin.controller.noti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DAO.noti.NoticeDAO;
import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;

@WebServlet("/admin/noti2")
public class NotiController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService noticeService = new NoticeService();

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항2 doGet 실행!");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		String action = request.getParameter("action");
		if (action == null) {
			action = "list";
		}

		switch (action) {
			case "list" :
				listNotices(request, response);
				break;
			case "detail" :
				detailNotice(request, response);
				break;
			default :
				listNotices(request, response);
				break;
		}
		
	}

	
	  private void listNotices(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException { List<NoticeDTO>
	  noticeList = noticeService.getAllNotices();
	  request.setAttribute("notices", noticeList);
	  request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").
	  forward(request, response); }
	

	private void detailNotice(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int annSeq = Integer.parseInt(request.getParameter("ann_seq"));
		NoticeDTO notice = noticeService.getNoticeById(annSeq);

		if (notice == null) {
			response.sendRedirect(
					request.getContextPath() + "/admin/noti2?action=list");
			return;
		}

		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").forward(request, response);
		request.getRequestDispatcher("/WEB-INF/user/info/usernotice.jsp").forward(request, response);
		
				
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {request.setCharacterEncoding("UTF-8");
			System.out.println("공지사항 dopost 실행");
			System.out.println("ann_title "+ request.getParameter("ann_title"));
			System.out.println("ann_detail "+ request.getParameter("ann_detail"));
			
//			int annSeq = Integer.parseInt(request.getParameter("ann_seq")); //공지사항 번호
	        String classId = request.getParameter("class_id"); 			
	        String annTitle = request.getParameter("ann_title");		
	        String annRegi = request.getParameter("ann_regi");		
	        String annCheck = request.getParameter("ann_check");		
	        String annDetail = request.getParameter("ann_detail");		
	        String annAttach = request.getParameter("ann_attach");		

	        // DTO 객체에 데이터 설정
	        NoticeDTO noticeDTO = new NoticeDTO();
//	        noticeDTO.setAnn_seq(annSeq);
	        noticeDTO.setClass_id(classId);
	        noticeDTO.setAnn_title(annTitle);
	        noticeDTO.setAnn_detail(annDetail);
	        noticeDTO.setAnn_attach(annAttach);

	        // DAO를 사용하여 데이터베이스에 삽입
	        NoticeDAO noticeDAO = new NoticeDAO();
	        noticeDAO.insertNotice(noticeDTO);

	        // 공지사항 목록 페이지로 리다이렉트
	        response.sendRedirect(request.getContextPath() + "/admin/noti2");

	}

}