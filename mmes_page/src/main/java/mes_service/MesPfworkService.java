package mes_service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesPfworkDTO;

public class MesPfworkService {

	MesPfworkDAO PfworkDAO = new MesPfworkDAO();

//	public List getPfwork() {
//
//		List result = this.PfworkDAO.selectpfwork();
//
//		return result;
//
//	}
	
	public Map getPwPage(String countPerPage, String page) {
		int count = Integer.parseInt(countPerPage);
		int pageNo = Integer.parseInt(page);
		
		int start = ((pageNo -1) * count) + 1;
		int end = start + count -1;
//		int end = pageNo * count;
		
		MesPfworkDAO dao = new MesPfworkDAO();
		List list = dao.selectpfwork(start, end);
		
		int totalCount = dao.totalPwPage();
		
		Map map = new HashMap();
		map.put("list", list);
		map.put("totalCount", totalCount);
		
		return map;
	}

	public MesPfworkDTO get(int os_id) {

		MesPfworkDTO PfworkDTO = new MesPfworkDTO();

		PfworkDTO = PfworkDAO.selectOne(os_id);

		return PfworkDTO;

	}

	public MesPfworkDTO One(int os_id) {

		MesPfworkDTO PfworkDTO = new MesPfworkDTO();

		PfworkDTO = this.PfworkDAO.selectOne(os_id);

		return PfworkDTO;
	}

	public List getPfworkds() {

		List result = this.PfworkDAO.selectpfworkds();

		return result;

	}

	public int insert(MesPfworkDTO PfworkDTO) {

		return this.PfworkDAO.insert(PfworkDTO);

	}

	public int update(MesPfworkDTO PfworkDTO) {

		return this.PfworkDAO.update(PfworkDTO);

	}

	public int delete(MesPfworkDTO PfworkDTO) {

		return this.PfworkDAO.delete(PfworkDTO);

	}

}
