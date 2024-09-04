package user.service.my.loan;

import java.util.List;

import user.dao.my.loan.LoanDAO;

public class LoanService {

	public List myLoan(int seq) {
		return new LoanDAO().myLoan(seq);
	}
	
	public List myOver(int seq) {
		return new LoanDAO().myOver(seq);
	}
	
	public List myRes(int seq) {
		return new LoanDAO().myRes(seq);
	}

}
