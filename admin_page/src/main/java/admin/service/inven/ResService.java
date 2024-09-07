package admin.service.inven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.DAO.inven.LoanDAO;
import admin.DAO.inven.ResDAO;
import admin.DTO.inven.InvenDTO;
import admin.DTO.inven.LoanResDTO;

public class ResService {
	
	public Map memResList(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		ResDAO dao = new ResDAO();
		List list = dao.memResList(start, end);
		
		int totalCount = dao.totalPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
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
