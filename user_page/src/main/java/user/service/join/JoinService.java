package user.service.join;

import user.dao.join.JoinDAO;
import user.dto.join.JoinDTO;

public class JoinService {
	public int join(JoinDTO dto) {
		return new JoinDAO().join(dto);
	}
}
