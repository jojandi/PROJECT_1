package admin.controller.noti;

import java.io.IOException;
<<<<<<< HEAD
import java.util.List;
=======
>>>>>>> dd5e7f964a197065233260cb973255e109470a29
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD

import admin.DTO.notice.NoticeDTO;
import admin.service.EmpService;  // EmpService를 import해야 합니다
=======
import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;
>>>>>>> dd5e7f964a197065233260cb973255e109470a29

@WebServlet("/admin/noti")
public class NotiController extends HttpServlet {
    private static final long serialVersionUID = 1L;
 

<<<<<<< HEAD
    // EmpService 인스턴스 생성
    private EmpService empService = new EmpService();

    // 공지사항 목록 조회 시 사용하는 리스트
    private List<NoticeDTO> noticeList;

    @Override
    public void init() throws ServletException {
        super.init();
        // 초기화 블록에서 데이터 불러오기
        noticeList = empService.getNoticeList();  // EmpService에서 공지사항 리스트를 가져옴
=======
    private NoticeService noticeService;

    @Override
    public void init() throws ServletException {
        super.init();
        noticeService = new NoticeService();
>>>>>>> dd5e7f964a197065233260cb973255e109470a29
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
        System.out.println("공지사항 살행");
    	
    	String action = request.getParameter("action");
=======
        System.out.println("공지사항 doGet 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        String action = request.getParameter("action");
>>>>>>> dd5e7f964a197065233260cb973255e109470a29
        if (action == null) {
            action = "createForm";
        }

        switch (action) {
            case "createForm":
                showCreateForm(request, response);
                break;
            case "create":
                createNotice(request, response);
                break;
            default:
                showCreateForm(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }

<<<<<<< HEAD
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

    // 공지사항 작성 폼 보여주기
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_create.jsp").forward(request, response);
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
=======
>>>>>>> dd5e7f964a197065233260cb973255e109470a29
    private void createNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        NoticeDTO newNotice = new NoticeDTO();
        newNotice.setAnn_title(request.getParameter("ann_title"));
        newNotice.setAnn_detail(request.getParameter("ann_detail"));
        newNotice.setClass_id(request.getParameter("class_id"));
        newNotice.setAnn_attach(request.getParameter("ann_attach"));

<<<<<<< HEAD
        // 여기에 공지사항 생성을 처리하는 로직을 추가해야 합니다.
        // 예를 들어, NoticeDTO 객체를 만들고 empService의 메서드를 호출하여 공지사항을 저장할 수 있습니다.
=======
        newNotice.setAnn_regi(java.time.LocalDate.now().toString());
        newNotice.setAnn_check(0);
>>>>>>> dd5e7f964a197065233260cb973255e109470a29

        response.sendRedirect(request.getContextPath() + "/admin/noti2");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
