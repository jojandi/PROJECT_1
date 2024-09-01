package admin.controller.noti;

import java.io.IOException;
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

    private NoticeService noticeService;

    @Override
    public void init() throws ServletException {
        super.init();
        noticeService = new NoticeService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 doGet 실행!");
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
            default:
                showCreateForm(request, response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
    }

    private void createNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        NoticeDTO newNotice = new NoticeDTO();
        newNotice.setAnn_title(request.getParameter("ann_title"));
        newNotice.setAnn_detail(request.getParameter("ann_detail"));
        newNotice.setClass_id(request.getParameter("class_id"));
        newNotice.setAnn_attach(request.getParameter("ann_attach"));

        newNotice.setAnn_regi(java.time.LocalDate.now().toString());
        newNotice.setAnn_check(0);

        noticeService.addNotice(newNotice);

        response.sendRedirect(request.getContextPath() + "/admin/noti2");
    }
}
