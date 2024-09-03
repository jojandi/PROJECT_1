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
	
}
