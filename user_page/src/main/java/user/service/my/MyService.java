package user.service.my;

import user.dao.my.MyDAO;
import user.dto.join.JoinDTO;

public class MyService {
	
	public int userUpdate(JoinDTO dto) {
		return new MyDAO().userUpdate(dto);
	}

	public int delete(JoinDTO dto) {
		return new MyDAO().delete(dto);
	}
	
}
