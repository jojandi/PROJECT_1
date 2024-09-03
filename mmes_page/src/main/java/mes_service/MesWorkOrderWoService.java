package mes_service;

import java.util.List;

import mes_DAO.MesWorkorderWoDAO;

public class MesWorkOrderWoService {
	
	MesWorkorderWoDAO WoDAO = new MesWorkorderWoDAO();
	
		public List getWorkwo() {
		
		List result = this.WoDAO.selectWorkwo();
		
		return result;
		
		}

}
