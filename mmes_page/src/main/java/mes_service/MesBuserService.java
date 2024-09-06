package mes_service;

import java.util.List;

import mes_DAO.MesBuserDAO;

public class MesBuserService {
	
		MesBuserDAO BuserDAO = new MesBuserDAO();
	
		public List getBuser(String user_id2) {
		
		List result = this.BuserDAO.selectBuser( user_id2 );
		
		return result;
		
		}
}
