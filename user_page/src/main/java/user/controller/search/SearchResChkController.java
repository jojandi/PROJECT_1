package user.controller.search;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.my.loan.LoanDTO;
import user.service.search.SearchService;

@WebServlet("/user/res_user")
public class SearchResChkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 검색 예약 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String code = request.getParameter("code");
	    String user = request.getParameter("user");
	    
	    System.out.println("bookcode : " + code + ", user_seq : " + user);
	    
	    LoanDTO dto = new LoanDTO();
	    dto.setBook_code(Integer.parseInt(code));
	    dto.setUser_seq(Integer.parseInt(user));
	    
	    SearchService service = new SearchService();
	    int result = service.resBook(dto);
	    
	    System.out.println("result : 검색 -> 예약" + result);
	    
	    response.sendRedirect(request.getContextPath() + "/user/res?seq=" + user);
	}

}
