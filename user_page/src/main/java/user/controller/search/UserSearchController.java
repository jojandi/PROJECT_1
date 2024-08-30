package user.controller.search;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.search.SearchService;

@WebServlet("/user/search")
public class UserSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 검색 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String book_name = request.getParameter("book");
	    
	    SearchService service = new SearchService();
	    List search_list = service.search(book_name);
	    
	    request.setAttribute("list", search_list); 
		request.getRequestDispatcher("/WEB-INF/user/search/search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
