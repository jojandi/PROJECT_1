package mes_service;

import java.util.List;

import mes_DAO.MesReviewDAO;

public class MesReviewService {
	
	MesReviewDAO rvdao = new MesReviewDAO();
	
	public List getReview() {

		List result = this.rvdao.selectReview();

		return result;

	}

}
