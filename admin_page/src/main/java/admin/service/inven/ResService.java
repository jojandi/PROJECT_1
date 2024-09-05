package admin.service.inven;

import java.util.List;

import admin.DAO.inven.ResDAO;
import admin.DTO.inven.InvenDTO;
import admin.DTO.inven.LoanResDTO;

public class ResService {
	
	public List memResList() {
		return new ResDAO().memResList();
	}

	public int memResUpdate(LoanResDTO dto) {
		return new ResDAO().memResUpdate(dto);
	}
	
	public int resLoan(LoanResDTO dto) {
		return new ResDAO().resLoan(dto);
	}

	public int invenUpdate(InvenDTO idto) {
		return new ResDAO().invenUpdate(idto);
	}
	
	public int invenUpdate2(InvenDTO idto) {
		return new ResDAO().invenUpdate2(idto);
	}
}
