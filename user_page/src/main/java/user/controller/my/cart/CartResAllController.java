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
	    String[] codes = null;
	    
	    System.out.println(code.indexOf(","));
	    
	    if(code.indexOf(',') == -1) {	    	
	    	codes[0] = code;
	    } else {
	    	codes = code.split(",");
	    }
	    
	    int user = Integer.parseInt(request.getParameter("user"));
	    
	    System.out.println("bookcode : " + code + ", user_seq : " + user);
	    
	    CartService service = new CartService();
	    int result = service.cartResChk(codes, user);
	    
	    System.out.println("result : 검색 -> 예약" + result);
	    
	    response.sendRedirect(request.getContextPath() + "/user/res?seq=" + user);
	}

}
