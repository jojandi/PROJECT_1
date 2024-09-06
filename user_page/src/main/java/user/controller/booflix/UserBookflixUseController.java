package user.controller.booflix;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.bookflix.BookflixService;

@WebServlet("/user/bookflix_use")
public class UserBookflixUseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 북플릭스 이용자 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
	    BookflixService service = new BookflixService();
	    List list = service.userBookflix(seq);
		
	    System.out.println(list);
	    
	    request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/user/bookflix/user_bookflix_use.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
