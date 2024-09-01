package admin.service.inven;

import java.util.List;

import admin.DTO.inven.InvenDTO;
import admin.dao.inven.InvenDAO;

public class InvenService {
	
	// 재고현황 조회
	public List bookList() {
		return new InvenDAO().bookList();
	}
	public List bookList(String book_name) {
		return new InvenDAO().bookList(book_name);
	}
	
	// 상세 내역
	public InvenDTO bookCount(long book_isbn) {
		return new InvenDAO().bookCount(book_isbn);
	}
}
