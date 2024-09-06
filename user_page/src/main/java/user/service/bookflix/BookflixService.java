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
}
