package admin.controller.noti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;

@WebServlet("/admin/noti")
	public class NotiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeService noticeService = new NoticeService(); // NoticeService 인스턴스 생성
    private List<NoticeDTO> noticeList; // 공지사항 목록 조회 시 사용하는 리스트

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 doget 실행");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
    	
    	
    	
    	
    	request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }



    // 공지사항 상세 조회
    private void detailNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annSeq = Integer.parseInt(request.getParameter("ann_seq"));
        NoticeDTO notice = noticeList.stream()
                                     .filter(n -> n.getAnn_seq() == annSeq)
                                     .findFirst()
                                     .orElse(null);

        if (notice == null) {
            response.sendRedirect("noti?action=list");
            return;
        }

        request.setAttribute("notice", notice);
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_detail.jsp").forward(request, response);
    }



    // 공지사항 작성 처리
    private void createNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        NoticeDTO newNotice = new NoticeDTO();
        newNotice.setAnn_title(request.getParameter("ann_title"));
        newNotice.setAnn_detail(request.getParameter("ann_detail"));
        newNotice.setClass_id(request.getParameter("class_id"));
        newNotice.setAnn_attach(request.getParameter("ann_attach"));
        newNotice.setAnn_regi(java.time.LocalDate.now().toString());
        newNotice.setAnn_check(0);


        response.sendRedirect(request.getContextPath() + "/admin/noti2");
    }
}