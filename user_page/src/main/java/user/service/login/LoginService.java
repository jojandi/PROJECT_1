package user.service.login;

import user.dao.login.LoginDAO;
import user.dto.join.JoinDTO;

public class LoginService {
	
	// 로그인
	public JoinDTO login(JoinDTO dto) {
		LoginDAO dao = new LoginDAO();
		JoinDTO joindto = dao.login(dto);
		System.out.println("joindto : " + joindto);
		return new LoginDAO().login(dto);
	}
	
}
