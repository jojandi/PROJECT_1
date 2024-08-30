package user.service.search;

import java.util.List;

import user.dao.search.SearchDAO;


public class SearchService {
	
	public List bookList(String book_name) {
		return new SearchDAO().bookList(book_name);
	}
}
