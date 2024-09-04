package user.service.my.cart;

import java.util.List;

import user.dao.my.cart.CartDAO;
import user.dto.my.cart.CartDTO;
import user.dto.my.loan.LoanDTO;

public class CartService {

	public List myCart(int seq) {
		return new CartDAO().myCart(seq);
	}
	
	public int cartRes(LoanDTO dto) {
		return new CartDAO().cartRes(dto);
	}
	
	public int cartDel(CartDTO dto) {
		return new CartDAO().cartDel(dto);
	}
	
	public int cartResChk(String[] codes, int user){
		int result = -1;
		
		try {
			
			CartDAO dao = new CartDAO();

			for(int i = 0; i < codes.length; i++) {	
				LoanDTO dto = new LoanDTO();
				
				int code = Integer.parseInt(codes[i]);
				
				dto.setUser_seq(user);
				dto.setBook_code(code);
				
				result = dao.cartRes(dto);
				System.out.println("result : " + result);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
	
}
