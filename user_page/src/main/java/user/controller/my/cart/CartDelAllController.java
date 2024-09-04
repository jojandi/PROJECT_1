package user.controller.my.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.my.cart.CartDTO;
import user.dto.my.loan.LoanDTO;
import user.service.my.cart.CartService;

@WebServlet("/user/delall")
public class CartDelAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 마이페이지 장바구니 전체 삭제 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String seq = request.getParameter("seq");
	    int user = Integer.parseInt(request.getParameter("user"));
	    
	    String[] seqs = seq.split(",");
	    
	    CartService service = new CartService();
	    
	    int delete = service.cartDelAll(seqs);
	    System.out.println("전체 삭제 : " + delete);
		
	    response.sendRedirect("mypage_cart?seq="+user);
	
	}

}
