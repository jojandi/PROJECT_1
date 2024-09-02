package user.service.loan;

import java.util.List;

import user.dao.loan.LoanDAO;

public class LoanService {

	public List myLoan(int seq) {
		return new LoanDAO().myLoan(seq);
	}

}
