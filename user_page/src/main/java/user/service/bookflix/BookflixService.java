package user.service.bookflix;

import java.util.List;

import user.dao.bookflix.BookflixDAO;

public class BookflixService {

	public List userBookflix(int seq) {
		return new BookflixDAO().userBookflix(seq);
	}
}
