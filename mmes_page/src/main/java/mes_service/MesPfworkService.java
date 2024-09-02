package mes_service;

import java.util.List;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesPfworkDTO;

public class MesPfworkService {
	
	MesPfworkDAO PfworkDAO = new MesPfworkDAO();
	
	public List getPfwork() {
		
		List result = this.PfworkDAO.selectpfwork();
		
		return result;
		
	}
	
	public List getPfworkds() {
		
		List result = this.PfworkDAO.selectpfworkds();
		
		return result;
		
	}
		
	public int insert (MesPfworkDTO PfworkDTO) {
				
		return this.PfworkDAO.insert(PfworkDTO);
				
	}

}
