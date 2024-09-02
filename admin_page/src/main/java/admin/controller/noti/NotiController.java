package admin.controller.noti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DTO.notice.NoticeDTO;
<<<<<<< HEAD
=======
import admin.service.EmpService;
>>>>>>> e1ff4722ede449416171033f05b921096a952038
import admin.service.notice.NoticeService;

@WebServlet("/admin/noti")
public class NotiController extends HttpServlet {
    private static final long serialVersionUID = 1L;

<<<<<<< HEAD
=======
    private EmpService empService = new EmpService(); // EmpService 인스턴스 생성
>>>>>>> e1ff4722ede449416171033f05b921096a952038
    private NoticeService noticeService = new NoticeService(); // NoticeService 인스턴스 생성
    private List<NoticeDTO> noticeList; // 공지사항 목록 조회 시 사용하는 리스트

    @Override
    public void init() throws ServletException {
        super.init();
<<<<<<< HEAD
=======
        noticeList = empService.getNoticeList(); // EmpService에서 공지사항 리스트를 가져옴
>>>>>>> e1ff4722ede449416171033f05b921096a952038
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 실행");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        String action = request.getParameter("action");
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
<<<<<<< HEAD
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }

    
    
=======
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_detail.jsp").forward(request, response);
    }

>>>>>>> e1ff4722ede449416171033f05b921096a952038
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("create".equals(action)) {
            createNotice(request, response);
        } else {
            doGet(request, response);
        }
    }

<<<<<<< HEAD
   
=======
    // 공지사항 작성 처리
>>>>>>> e1ff4722ede449416171033f05b921096a952038
    private void createNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        NoticeDTO newNotice = new NoticeDTO();
        newNotice.setAnn_title(request.getParameter("ann_title"));
        newNotice.setAnn_detail(request.getParameter("ann_detail"));
        newNotice.setClass_id(request.getParameter("class_id"));
        newNotice.setAnn_attach(request.getParameter("ann_attach"));
        newNotice.setAnn_regi(java.time.LocalDate.now().toString());
        newNotice.setAnn_check(0);
<<<<<<< HEAD
=======

        // 공지사항 생성을 처리하는 로직을 여기에 추가해야 합니다.
        // 예를 들어, noticeService의 메서드를 호출하여 공지사항을 저장할 수 있습니다.
>>>>>>> e1ff4722ede449416171033f05b921096a952038

        response.sendRedirect(request.getContextPath() + "/admin/noti2");
    }
}
