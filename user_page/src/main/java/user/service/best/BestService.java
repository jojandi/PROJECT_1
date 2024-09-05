package user.service.best;

import java.util.List;

import user.dao.best.BestDAO;
import user.dao.search.SearchDAO;
import user.dto.my.loan.LoanDTO;

public class BestService {
	public List bsetList() {
		return new BestDAO().bsetList();
	}
	
	public int resBook(LoanDTO dto) {
		return new SearchDAO().resBook(dto);
	}

	public int cartBook(LoanDTO dto) {
		return new SearchDAO().cartBook(dto);
	}
}
