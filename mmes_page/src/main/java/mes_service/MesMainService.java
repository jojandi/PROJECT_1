package mes_service;

import java.util.List;
import mes_DAO.MesMainDAO;
import mes_DTO.MesMainDTO;

public class MesMainService {
	MesMainDAO mainDAO = new MesMainDAO();
	public List<MesMainDTO> getList(){
		// DB에서 select
		
		
		
		
		List<MesMainDTO> list = mainDAO.selectAll();
		
		
		return list;
		
	}
    
}