package user.service.best;

import java.util.List;

import user.dao.best.BestDAO;

public class BestService {
	public List bsetList() {
		return new BestDAO().bsetList();
	}
}
