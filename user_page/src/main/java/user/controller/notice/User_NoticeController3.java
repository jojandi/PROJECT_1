package user.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/notice3")
public class User_NoticeController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("새로운 도서 doGet 실행!");
		response.setContentType("text/html;charset=utf-8;");



		// JSP로 포워딩
		
		request.getRequestDispatcher("/WEB-INF/user/info/user_notice3.jsp").forward(request, response);
				
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
