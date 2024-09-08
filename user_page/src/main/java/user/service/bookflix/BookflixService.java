package user.service.bookflix;

import java.util.List;

import user.dao.bookflix.BookflixDAO;

public class BookflixService {

	public List userBookflix(int seq) {
		return new BookflixDAO().userBookflix(seq);
	}
	
	public int review (int user, int buser, int star, String text) {
		return new BookflixDAO().bookflixReview(user, buser, star, text);
	}
	
	public int sub(int user) {
		return new BookflixDAO().bookflixSub(user);
	}
	
	public int subInsert(int user) {
		return new BookflixDAO().bookflixSubInsert(user);
	}
	
	public int bookflixDel(int buser) {
		return new BookflixDAO().bookflixDel(buser);
	}
	
	public int out(int user) {
		return new BookflixDAO().bookflixOut(user);
	}
}
