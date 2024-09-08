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
public class BookflixUseController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 북플릭스 이용자 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    System.out.println("유저 seq : " + seq);
	    
	    BookflixService service = new BookflixService();
	    List list = service.userBookflix(seq);
		
	    System.out.println(list);
	    
	    request.setAttribute("list", list);
		request.getRequestDispatcher("/WEB-INF/user/bookflix/bookflix_use.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 북플릭스 이용자 탈퇴 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("bseq"));
	    int user = Integer.parseInt(request.getParameter("user"));
	    System.out.println("북플릭스 유저 seq : " + seq);
	    
	    BookflixService service = new BookflixService();
	    int result = service.bookflixDel(seq);
	    int resultOut = service.out(user);
	    
	    System.out.println("북플릭스 탈퇴 : " + result);
	    System.out.println("북플릭스 진짜 탈퇴 : " + resultOut);
	    
	    response.sendRedirect(request.getContextPath() + "/user/main");
	}

}
