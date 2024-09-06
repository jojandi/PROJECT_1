package user.service.my;

import java.util.List;

import user.dao.my.MyDAO;
import user.dto.join.JoinDTO;

public class MyService {
	
	public int userUpdate(JoinDTO dto) {
		return new MyDAO().userUpdate(dto);
	}

	public int delete(JoinDTO dto) {
		return new MyDAO().delete(dto);
	}
	
	public List bookfilx(int seq) {
		return new MyDAO().userBookflix(seq);
	}
	
}
