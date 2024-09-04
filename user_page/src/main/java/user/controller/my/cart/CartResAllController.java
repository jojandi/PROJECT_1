package user.controller.my.cart;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.my.cart.CartService;

@WebServlet("/user/resAll")
public class CartResAllController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 장바구니 전체 예약 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String code = request.getParameter("code");
	    System.out.println("책코드 : " + code);
	    String cart = request.getParameter("cart");
	    System.out.println("장바구니 번호 : " + cart);
	    int user = Integer.parseInt(request.getParameter("user"));
	    
	    CartService service = new CartService();

    	String[] codes = code.split(","); // 만약 책이 하나면 한 개짜리 배열을 돌려줌
    	String[] carts = cart.split(","); // 만약 책이 하나면 한 개짜리 배열을 돌려줌
    
    	int result = service.cartResChk(codes, user);
    	int delete = service.cartDelAll(carts);
	
	    
	    System.out.println("예약 : " + result);
	    System.out.println("삭제 : " + delete);
	    
	    response.sendRedirect(request.getContextPath() + "/user/res?seq=" + user);
	}

}
