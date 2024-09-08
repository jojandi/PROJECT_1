package user.controller.booflix;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.bookflix.BookflixService;

@WebServlet("/user/sub")
public class BookflixSubController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 북플릭스 구독 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int user = Integer.parseInt(request.getParameter("seq"));
	    
	    BookflixService service = new BookflixService();
	    int result_user = service.sub(user);
	    int result_buser = service.subInsert(user);
	    System.out.println("구독 완료! " + result_user);
	    System.out.println("구독 진짜 완료! " + result_buser);
	   
	    response.sendRedirect(request.getContextPath() + "/user/bookflix_use?seq=" + user);
	}

}
