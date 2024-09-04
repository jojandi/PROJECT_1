package mes_service;

import java.util.List;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesNoticeDTO;
import mes_DTO.MesPfworkDTO;

public class MesPfworkService {

	MesPfworkDAO PfworkDAO = new MesPfworkDAO();

	public List getPfwork() {

		List result = this.PfworkDAO.selectpfwork();

		return result;

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
