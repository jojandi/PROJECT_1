package admin.service.inven;

import java.util.List;

import admin.DAO.inven.LoanDAO;
import admin.DTO.inven.InvenDTO;
import admin.DTO.inven.LoanResDTO;

public class LoanService {
	
	public List memLoanList() {
		return new LoanDAO().memLoanList();
	}

	public int memLoanUpdate(LoanResDTO dto) {
		return new LoanDAO().memLoanUpdate(dto);
	}
	
	public int invenUpdate(InvenDTO dto) {
		return new LoanDAO().invenUpdate(dto);
	}
}
