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

@WebServlet("/admin/noti")
public class NotiController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService noticeService = new NoticeService(); 
	private List<NoticeDTO> noticeList; // 공지사항 목록 조회 시 사용하는 리스트

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항 doget 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {request.setCharacterEncoding("UTF-8");
			System.out.println("공지사항 dopost 실행");
			
			int annSeq = Integer.parseInt(request.getParameter("ann_seq")); //공지사항 번호
	        String classId = request.getParameter("class_id"); 			//분류
	        String annTitle = request.getParameter("ann_title");		//공지사항 제목
	        String annDetail = request.getParameter("ann_detail");		//공지사항 내용
	        String annAttach = request.getParameter("ann_attach");		//첨부파일

	        System.out.println(classId);
	        
	        
	        // DTO 객체에 데이터 설정
	        NoticeDTO noticeDTO = new NoticeDTO();
	        noticeDTO.setAnn_seq(annSeq);
	        noticeDTO.setClass_id(classId);
	        noticeDTO.setAnn_title(annTitle);
	        noticeDTO.setAnn_detail(annDetail);
	        noticeDTO.setAnn_attach(annAttach);

	        // DAO를 사용하여 데이터베이스에 삽입
	        NoticeDAO noticeDAO = new NoticeDAO();
	        noticeDAO.insertNotice(noticeDTO);

	        // 공지사항 목록 페이지로 리다이렉트
	        response.sendRedirect(request.getContextPath() + "/admin_page/admin/noti2");
	        response.sendRedirect(request.getContextPath() + "/user_page//user/notice");

	}


}