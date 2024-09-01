package admin.controller.noti;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/notice/insert")
public class NoticeinsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert doGet 실행");
		
		request.getRequestDispatcher("/WEB-INF/admin/notification/edit_notice.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    request.getRequestDispatcher("/WEB-INF/admin/notification/noti/insert.jsp").forward(request, response);
	    
	 // 폼 데이터 처리
        String classId = request.getParameter("class_id");
        String title = request.getParameter("ann_title");
        String registrationDate = request.getParameter("ann_regi");
        String detail = request.getParameter("ann_detail");

        // 파일 처리
        Part filePart = request.getPart("ann_attach");
        String fileName = filePart.getSubmittedFileName();
        
        // 파일 저장 경로
        String upload = getServletContext().getRealPath("") + File.separator + "uploads";
        File uploadDir = new File(upload);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // 파일 저장
        if (fileName != null && !fileName.isEmpty()) {
            File file = new File(upload + File.separator + fileName);
            filePart.write(file.getAbsolutePath());
        }

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>공지사항이 성공적으로 추가됨</h2>");
        out.println("<a href='notice_insert'>다시 추가하기</a>");
        out.println("</body></html>");
    }
	    
	    
	}


