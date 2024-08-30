package mes_service;

import java.util.List;

import mes_DAO.MesHumanDAO;
import mes_DTO.MesHumanDTO;


public class MesHumanService {
	MesHumanDAO try2DAO = new MesHumanDAO();
	public List<MesHumanDTO> getList(){
		// DB에서 select
		
		
		
		
		List<MesHumanDTO> list = try2DAO.selectAll();
		
		
		return list;
		
	}
	
	public int register(MesHumanDTO try2DTO) {
		// DB에 insert
			
		int insertCount = this.try2DAO.insert(try2DTO);
		return insertCount;
		
	}
}
