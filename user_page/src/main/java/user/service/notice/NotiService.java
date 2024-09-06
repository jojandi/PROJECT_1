package user.service.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import user.dao.noti.NotiDAO;


public class NotiService<InvenDAO> {

	// 재고현황 조회
		public Map  bookList(String countPerPage, String page, String page2) {
			int count = Integer.parseInt(countPerPage);
			int pageNo = Integer.parseInt(page);
			
			// 시작 번호 : 이전 페이지까지 보여준 것 바로 다음 것
			int start = ((pageNo - 1) * count) + 1;
			// 마지막 번호
			int end = start + count - 1;
			
//			System.out.println("시작번호 : " + start);
//			System.out.println("마지막번호 : " + end);
			
			NotiDAO dao = new NotiDAO();
			List list = dao.bookList(start, end);
			
			int totalCount = dao.totalPage();
			
			Map map = new HashMap();
			map.put("list", list);
			map.put("totalCount", totalCount); // 전체 목록 개수
			
			return map;
		}
		

	
}
