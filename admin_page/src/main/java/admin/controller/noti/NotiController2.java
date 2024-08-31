package admin.controller.noti;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DAO.noti.NoticeDAO;


@WebServlet("/admin/noti2")
public class NotiController2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private NoticeDAO noticeDAO = new NoticeDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("공지사항 목록 doGet 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");

        request.getRequestDispatcher("/WEB-INF/admin/notification/noti2.jsp").forward(request, response);
        
//        String action = request.getParameter("action");
//        
//        PrintWriter out = response.getWriter();
//        
//        out.println("<!DOCTYPE html>");
//        out.println("<html>");
//        out.println("<head>");
//        out.println("<meta charset=\"UTF-8\">");
//        out.println("<title>Insert title here</title>");
//        out.println("<link href=\"../assets/css/noti/noti.css\" rel=\"stylesheet\">");
//        out.println("</head>");
//        out.println("<body>");
//        
//        // Include header
//        request.getRequestDispatcher("/WEB-INF/admin/base/a.header.jsp").include(request, response);
//        
//        out.println("<div id=\"wrap\">");
//        
//        // Include side menu
//        request.getRequestDispatcher("/WEB-INF/admin/notification/noti_side.jsp").include(request, response);
//        
//        out.println("<section class=\"notice\">");
//        out.println("<div class=\"page-title\">");
//        out.println("<div class=\"container\">");
//        out.println("<h3>공지사항</h3>");
//        out.println("</div>");
//        out.println("</div>");
//        
//        out.println("<div id=\"board-search\">");
//        out.println("<div class=\"container\">");
//        out.println("<div class=\"search-window\">");
//        out.println("<form action=\"\">");
//        out.println("<div class=\"search-wrap\">");
//        out.println("<label for=\"search\" class=\"blind\">공지사항목록</label>");
//        out.println("<input id=\"search\" type=\"search\" name=\"\" placeholder=\"검색어를 입력해주세요.\" value=\"\">");
//        out.println("<button type=\"submit\" class=\"btn btn-dark\">글쓰기</button>");
//        out.println("</div>");
//        out.println("</form>");
//        out.println("</div>");
//        out.println("</div>");
//        out.println("</div>");
//        
//        out.println("<div id=\"board-list\">");
//        out.println("<div class=\"container\">");
//        out.println("<table class=\"board-table\">");
//        out.println("<thead>");
//        out.println("<tr>");
//        out.println("<th scope=\"col\" class=\"th-num\">번호</th>");
//        out.println("<th scope=\"col\" class=\"th-title\">제목</th>");
//        out.println("<th scope=\"col\" class=\"th-date\">등록일</th>");
//        out.println("</tr>");
//        out.println("</thead>");
//        out.println("<tbody>");
//        
//        out.println("<tr>");
//        out.println("<td>3</td>");
//        out.println("<th>[공지사항] 개인정보 처리방침 변경안내처리방침<p>테스트</p></th>");
//        out.println("<td>2017.07.13</td>");
//        out.println("</tr>");
//        
//        out.println("<tr>");
//        out.println("<td>2</td>");
//        out.println("<th>공지사항 안내입니다. 이용해주셔서 감사합니다</th>");
//        out.println("<td>2017.06.15</td>");
//        out.println("</tr>");
//        
//        out.println("<tr>");
//        out.println("<td>1</td>");
//        out.println("<th>공지사항 안내입니다. 이용해주셔서 감사합니다</th>");
//        out.println("<td>2017.06.15</td>");
//        out.println("</tr>");
//        
//        out.println("</tbody>");
//        out.println("</table>");
//        out.println("</div>");
//        out.println("</div>");
//        
//        out.println("</section>");
//        out.println("</div>");
//        
//        // Include footer
//        request.getRequestDispatcher("/WEB-INF/admin/base/a.footer.jsp").include(request, response);
//        
//        out.println("</body>");
//        out.println("</html>");
//        
//        out.close();
//    }
//        
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


}