package admin.service.inven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import admin.DAO.inven.InvenDAO;
import admin.DTO.inven.InvenDTO;

public class InvenService {
	
	// 재고현황 조회
	public Map  bookList(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		InvenDAO dao = new InvenDAO();
		List list = dao.bookList(start, end);
		
		int totalCount = dao.totalPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
	}
	
	// 검색
	public Map  bookList(String book_name, String countPerPage, String page ) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		InvenDAO dao = new InvenDAO();
		List list = dao.bookList(start, end);
		
		int totalCount = dao.totalPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
	}
	
	// 상세 내역
	public InvenDTO bookCount(long book_isbn) {
		return new InvenDAO().bookCount(book_isbn);
	}
}
