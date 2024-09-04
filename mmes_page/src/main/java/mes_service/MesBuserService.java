package mes_service;

import java.util.List;

import mes_DAO.MesBuserDAO;

public class MesBuserService {
	
		MesBuserDAO BuserDAO = new MesBuserDAO();
	
		public List getBuser() {
		
		List result = this.BuserDAO.selectBuser();
		
		return result;
		
		}
}
