package user.controller.booflix;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.bookflix.BookflixService;

@WebServlet("/user/bookflixk_review")
public class BookflixReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 북플릭스 리뷰 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int user = Integer.parseInt(request.getParameter("user"));
	    System.out.println("유저 : " + user);
	    int buser = Integer.parseInt(request.getParameter("buser"));
	    System.out.println("북플릭스유저 : " + buser);
	    String text = request.getParameter("review_text");
	    System.out.println("리뷰 : " + text);

	    String[] stars = request.getParameterValues("star");
	    int star = 0;
	    for(int i = 0; i < stars.length; i++) {
	    	star += Integer.parseInt(stars[i]);
	    }
	    System.out.println("별점 : " + star);
	    
	    BookflixService service = new BookflixService();
	    int result = service.review(user, buser, star, text);
	    System.out.println("리뷰 작성 완료 : " + result);
		
	    response.sendRedirect(request.getContextPath() + "/user/bookflix_use?seq=" + user);
	}

}
