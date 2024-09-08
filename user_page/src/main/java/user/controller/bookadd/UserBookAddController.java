package user.controller.bookadd;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.bookadd.BookAddDAO;
import user.dto.app.AppDTO;


@WebServlet("/user/bookadd")
public class UserBookAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 doget 실행");
		response.setContentType("text/html;charset=utf-8;");
		
		int user_seq = Integer.parseInt( request.getParameter("user_seq") );
		System.out.println(user_seq);
		
		AppDTO dto  = new AppDTO();
		BookAddDAO dao = new BookAddDAO();
		
		List list = dao.one(user_seq);
		
		System.out.println("tostring : " + list);
		
		request.setAttribute("add", list);


		// JSP로 포워딩
		
		request.getRequestDispatcher("/WEB-INF/user/my/user_mypage_bookadd.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
