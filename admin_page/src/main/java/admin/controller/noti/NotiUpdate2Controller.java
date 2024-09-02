package admin.controller.noti;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import admin.DTO.notice.NoticeDTO;
import admin.service.notice.NoticeService;

@WebServlet("/notice/update2")
public class NotiUpdate2Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정할 공지사항을 가져와서 JSP 페이지로 전달
        String annSeq = request.getParameter("ann_seq");
        // 데이터베이스에서 annSeq에 해당하는 공지사항을 조회
        // 예시: NoticeDTO notice = noticeService.getNoticeById(annSeq);
        // request.setAttribute("notice", notice);
        
        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("update doPost 실행");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        String id = request.getParameter("id");
        String classId = request.getParameter("class_id");
        String title = request.getParameter("ann_title");
        String registrationDate = request.getParameter("ann_regi");
        String detail = request.getParameter("ann_detail");

        // 파일 처리
        Part filePart = request.getPart("ann_attach");
        String fileName = filePart.getSubmittedFileName();

        // 파일 저장 경로 설정
        String uploadDirPath = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(uploadDirPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 파일 저장 및 중복 파일명 처리
        String uniqueFileName = null;
        if (fileName != null && !fileName.isEmpty()) {
            uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            File file = new File(uploadDirPath + File.separator + uniqueFileName);
            filePart.write(file.getAbsolutePath());
        }

//         
//         NoticeDTO updatedNotice = new NoticeDTO();
//         updatedNotice.setAnn_check(Integer.parseInt(id));
//         updatedNotice.setClass_id(classId);
//         updatedNotice.setAnn_title(title);
//         updatedNotice.setAnn_regi(registrationDate);
//         updatedNotice.setAnn_detail(detail);
//         if (uniqueFileName != null) {
//             updatedNotice.setAnn_attach(uniqueFileName);
//         }
//         NoticeService.updateNotice(updatedNotice);

        // 사용자에게 결과 출력
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h2>공지사항이 성공적으로 업데이트되었습니다.</h2>");
            out.println("<a href='notice_list'>공지사항 목록으로 돌아가기</a>");
            out.println("</body></html>");
        }
    }
}
