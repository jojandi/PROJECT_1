package mes_service;

import java.util.ArrayList;
import java.util.List;

import mes_DAO.MesStockDAO;
import mes_DTO.MesStockDTO;

public class MesStockService {
	MesStockDAO dao = new MesStockDAO();

	public List<MesStockDTO> getMesBook() {

		List<MesStockDTO> list = dao.selectMesBook();
		
		return list;
	}
	
		
}

