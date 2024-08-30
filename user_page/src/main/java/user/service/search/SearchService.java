package user.service.search;

import java.util.List;

import user.dao.search.SearchDAO;


public class SearchService {
	
	public List search(String book_name) {
		return new SearchDAO().bookSearch(book_name);
	}
}
