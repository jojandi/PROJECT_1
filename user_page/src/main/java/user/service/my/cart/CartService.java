package user.service.my.cart;

import java.util.List;

import user.dao.my.cart.CartDAO;

public class CartService {

	public List myCart(int seq) {
		return new CartDAO().myCart(seq);
	}
	
}
