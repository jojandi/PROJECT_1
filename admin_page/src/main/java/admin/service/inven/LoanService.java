package admin.service.inven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.DAO.inven.InvenDAO;
import admin.DAO.inven.LoanDAO;
import admin.DTO.inven.InvenDTO;
import admin.DTO.inven.LoanResDTO;

public class LoanService {
	
	public Map memLoanList(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		LoanDAO dao = new LoanDAO();
		List list = dao.memLoanList(start, end);
		
		int totalCount = dao.totalPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
	}

	public int memLoanUpdate(LoanResDTO dto) {
		return new LoanDAO().memLoanUpdate(dto);
	}
	
	public int invenUpdate(InvenDTO dto) {
		return new LoanDAO().invenUpdate(dto);
	}
	public int memberUpdate(LoanResDTO dto) {
		return new LoanDAO().memberUpdate(dto);
	}
}
