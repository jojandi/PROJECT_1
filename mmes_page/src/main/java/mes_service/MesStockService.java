package mes_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mes_DAO.MesStockDAO;
import mes_DTO.MesStockDTO;

public class MesStockService {
	MesStockDAO dao = new MesStockDAO();

	public List<MesStockDTO> getMesBook() {

		List<MesStockDTO> list = dao.selectMesBook();
		
		return list;
	}
	public List<MesStockDTO> getPruduct() {
		
		List<MesStockDTO> list = dao.selectProduct();
		
		return list;
	}
	public List<MesStockDTO> getorderlist() {
		
		List<MesStockDTO> list = dao.selectOrder();
		
		return list;
	}
	public int order (MesStockDTO MesStockDTO) {
		
		return dao.order(MesStockDTO);
		
	}
	public int deleteOrder (MesStockDTO MesStockDTO) {
		
		return dao.deleteOrder(MesStockDTO);
		
	}
	public int updateMesBook (MesStockDTO MesStockDTO) {
		
		return dao.updateMesBook(MesStockDTO);
		
	}
	public MesStockDTO getStockOrder (int order_id) {
		
		return dao.getStockOrder(order_id);
		
	}
	public Map getStockPage2(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo - 1) * count) + 1;
		int end = pageNo * count;
//		int end = start + count - 1;
		

		List list = dao.selectStockPage2(start, end);
		
		int totalCount = dao.totalStockPage2();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map;
	}
	
		
}

