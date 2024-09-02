package mes_service;

import java.util.ArrayList;
import java.util.List;

import mes_DAO.MesStockDAO;
import mes_DTO.MesNoticeDTO;
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
		
}

