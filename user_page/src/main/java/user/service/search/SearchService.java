package user.service.search;

import java.util.List;

import user.dao.search.SearchDAO;
import user.dto.my.loan.LoanDTO;


public class SearchService {
	
	public List search(String book_name) {
		return new SearchDAO().bookSearch(book_name);
	}
	
	public int resBook(LoanDTO dto) {
		return new SearchDAO().resBook(dto);
	}

	public int cartBook(LoanDTO dto) {
		return new SearchDAO().cartBook(dto);
	}
}
