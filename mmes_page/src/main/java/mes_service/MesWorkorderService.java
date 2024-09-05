package mes_service;

import java.util.List;

import mes_DAO.MesHumanDAO;
import mes_DAO.MesWorkorderDAO;
import mes_DTO.MesHumanDTO;
import mes_DTO.MesWorkorderDTO;

public class MesWorkorderService {
	MesWorkorderDAO workorderDAO = new MesWorkorderDAO();
	public List<MesWorkorderDTO> getList(){

		List<MesWorkorderDTO> list = workorderDAO.selectAll();
		
		
		return list;
	}
	
	
	public List<MesWorkorderDTO> getList2(){

		List<MesWorkorderDTO> list = workorderDAO.selectMesBook();
		
		
		return list;
	}
	
    public List<MesWorkorderDTO> get(int bom_code) {
        MesWorkorderDAO dao = new MesWorkorderDAO();
        List<MesWorkorderDTO> bookList = dao.selectOne(bom_code);
        return bookList;
    }
    public int register(MesWorkorderDTO workDTO) {
		// DB에 insert
			
		int insertCount = this.workorderDAO.insert(workDTO);
		return insertCount;
		
	}
    
    
    public int remove(int bom_code) {
		MesWorkorderDAO dao = new MesWorkorderDAO();
		return dao.deleteOne(bom_code);
	}
	
}	