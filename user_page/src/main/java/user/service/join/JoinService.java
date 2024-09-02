package user.service.join;

import user.dao.join.JoinDAO;
import user.dto.join.JoinDTO;

public class JoinService {
	
	// 회원 인서트
	public int join(JoinDTO dto) {
		return new JoinDAO().join(dto);
	}
	
	public JoinDTO idChk(JoinDTO dto) {
		return new JoinDAO().idChk(dto);
	}
}
