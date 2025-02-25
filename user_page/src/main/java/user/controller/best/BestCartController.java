package user.controller.best;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.my.loan.LoanDTO;
import user.service.search.SearchService;

@WebServlet("/user/cart_best")
public class BestCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 베스트 장바구니 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String code = request.getParameter("code");
	    String user = request.getParameter("user");
	    
	    System.out.println("bookcode : " + code + ", user_seq : " + user);
	    
	    LoanDTO dto = new LoanDTO();
	    dto.setBook_code(Integer.parseInt(code));
	    dto.setUser_seq(Integer.parseInt(user));
	    
	    SearchService service = new SearchService();
	    int result = service.cartBook(dto);
	    
	    System.out.println("result : 검색 -> 장바구니 " + result);
	    
	    response.sendRedirect(request.getContextPath() + "/user/mypage_cart?seq=" + user);
	}

}
