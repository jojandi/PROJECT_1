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

@WebServlet("/admin/noti2")
public class NotiController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeService noticeService = new NoticeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항2 doGet 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

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
            default:
                listNotices(request, response);
                break;
        }
    }

    private void listNotices(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<NoticeDTO> noticeList = noticeService.getAllNotices();
        request.setAttribute("notices", noticeList);
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").forward(request, response);
    }

    private void detailNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int annSeq = Integer.parseInt(request.getParameter("ann_seq"));
        NoticeDTO notice = noticeService.getNoticeById(annSeq);

        if (notice == null) {
            response.sendRedirect(request.getContextPath() + "/admin/noti2?action=list");
            return;
        }

        request.setAttribute("notice", notice);
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_detail.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 필요에 따라 추가적인 처리
    }
}