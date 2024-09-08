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
	// 관리자 로그인
	public JoinDTO loginAdmin(JoinDTO dto) {
		LoginDAO dao = new LoginDAO();
		JoinDTO joindto = dao.login(dto);
		System.out.println("joindto : " + joindto);
		return new LoginDAO().loginAdmin(dto);
	}
	// mes 로그인
	public JoinDTO loginMes(JoinDTO dto) {
		LoginDAO dao = new LoginDAO();
		JoinDTO joindto = dao.login(dto);
		System.out.println("joindto : " + joindto);
		return new LoginDAO().loginMes(dto);
	}
	
}
