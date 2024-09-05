package mes_service;

import java.util.List;

import mes_DAO.MesWorkorderWoDAO;
import mes_DTO.MesNoticeDTO;
import mes_DTO.MesWorkorderWoDTO;

public class MesWorkOrderWoService {

	MesWorkorderWoDAO WoDAO = new MesWorkorderWoDAO();
	
	MesWorkorderWoDTO WoDTO = new MesWorkorderWoDTO();

	public List getWorkwo() {

		List result = this.WoDAO.selectWorkwo();

		return result;

	}
	
	public int insert (MesWorkorderWoDTO woDTO) {
		
		return this.WoDAO.insert(woDTO);
		
	}
	
	public int delete (MesWorkorderWoDTO WoDTO) {
		
		return this.WoDAO.delete(WoDTO);
		
	}
	
	public int update (MesWorkorderWoDTO WoDTO) {
		
		return this.WoDAO.update(WoDTO);
		
	}

}
