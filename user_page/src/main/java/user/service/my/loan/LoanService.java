package user.service.my.loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.dao.my.loan.LoanDAO;

public class LoanService {

	public Map myLoan(int seq, String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		LoanDAO dao = new LoanDAO();
		List list = dao.myLoan(seq, start, end);
		
		int totalCount = dao.totalLoan(seq);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
		
	}
	
	// 연체
	public Map myOver(int seq, String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		LoanDAO dao = new LoanDAO();
		List list = dao.myOver(seq, start, end);
		
		int totalCount = dao.totalOver(seq);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
	}
	
	// 에약
	public Map myRes(int seq, String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
		int start = ((pageNo - 1) * count) + 1;
		// 마지막 번호
		int end = start + count - 1;
		
		LoanDAO dao = new LoanDAO();
		List list = dao.myRes(seq, start, end);
		
		int totalCount = dao.totalRes(seq);
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount); // 전체 목록 개수
		
		return map;
	}

}
