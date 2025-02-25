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

@WebServlet("/user/cart_res")
public class CartResController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 마이페이지 장바구니 예약 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    int code = Integer.parseInt(request.getParameter("code"));
	    int cart = Integer.parseInt(request.getParameter("cart"));
	    
	    CartService service = new CartService();

	    LoanDTO dto = new LoanDTO();
	    dto.setBook_code(code);
	    dto.setUser_seq(seq);
	    
	    CartDTO cdto = new CartDTO();
	    cdto.setCart_seq(cart);
	    
	    int result = service.cartRes(dto);
	    int delete = service.cartDel(cdto);
	    System.out.println("예약내역 : " + result);
	    System.out.println("삭제 : " + delete);
		
	    response.sendRedirect("res?seq="+seq);
	
	}

}
