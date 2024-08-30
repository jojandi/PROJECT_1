package admin.controller.noti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/admin/noti")
public class NotiController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		request.getRequestDispatcher("/WEB-INF/admin/notification/noti.jsp").forward(request, response);
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String category = request.getParameter("notice_category");
	        String title = request.getParameter("new_notice_title");
	        String date = request.getParameter("new_notice_date");
	        String content = request.getParameter("new_notice_content");

	        // Create DTO
	        NotificationDTO notification = new NotificationDTO();
	        notification.setCategory(category);
	        notification.setTitle(title);
	        notification.setDate(date);
	        notification.setContent(content);

	        try {
	            // Call service to add notification
	            notificationService.addNotification(notification);
	            // Redirect or forward to a success page
	            response.sendRedirect("success.jsp");
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception, e.g., redirect to an error page
	            response.sendRedirect("error.jsp");
	        }
	    }
	}
		
		
	}

}
