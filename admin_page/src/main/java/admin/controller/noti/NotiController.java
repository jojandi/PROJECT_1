package admin.controller.noti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import admin.DTO.notice.NoticeDTO;
=======
>>>>>>> 488d8c0b42ae2c042f5308d784ff94e4e1e3dd36
import admin.service.notice.NoticeService;

@WebServlet("/admin/noti")
	public class NotiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

<<<<<<< HEAD
    private NoticeService noticeService = new NoticeService(); // NoticeService 인스턴스 생성
    private List<NoticeDTO> noticeList; // 공지사항 목록 조회 시 사용하는 리스트

=======
    private NoticeService noticeService = new NoticeService();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 doget 실행");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
    	
    	
    	
    	
    	request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }
>>>>>>> 488d8c0b42ae2c042f5308d784ff94e4e1e3dd36

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");


<<<<<<< HEAD
        switch (action) {
            case "createForm":
                showCreateForm(request, response);
                break;
            case "create":
                createNotice(request, response);
                break;
            case "detail":
                detailNotice(request, response);
                break;
            default:
                showCreateForm(request, response);
                break;
        }
    }

    // 공지사항 작성 폼 보여주기
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_create.jsp").forward(request, response);
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createNotice(request, response);
        } else {
            doGet(request, response);
        }
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

        // 공지사항 생성을 처리하는 로직을 여기에 추가해야 합니다.
        // 예를 들어, noticeService의 메서드를 호출하여 공지사항을 저장할 수 있습니다.

        response.sendRedirect(request.getContextPath() + "/admin/noti2");
=======
>>>>>>> 488d8c0b42ae2c042f5308d784ff94e4e1e3dd36
    }
}