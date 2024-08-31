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
public class NotiController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;



    // 공지사항 목록 조회 시 사용하는 리스트
    private List<NoticeDTO> noticeList;

//    public void init() throws ServletException {
//        super.init();
//        // 초기화 블록에서 데이터 불러오기
//        noticeList = NoticeService.getEmp();  // EmpService에서 공지사항 리스트를 가져옴
//    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "list":
                listNotices(request, response);
                break;
            case "detail":
                detailNotice(request, response);
                break;
            case "createForm":
                showCreateForm(request, response);
                break;
            default:
                listNotices(request, response);
                break;
        }
    }

    // 공지사항 목록 조회
    private void listNotices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("notices", noticeList);
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

    // 공지사항 작성 폼 보여주기
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_create.jsp").forward(request, response);
    }

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

        String classId = request.getParameter("class_id");
        String title = request.getParameter("ann_title");
        String regiDate = request.getParameter("ann_regi");
        String detail = request.getParameter("ann_detail");
        String attach = request.getParameter("ann_attach");


        response.sendRedirect("noti?action=list");
    }
}
