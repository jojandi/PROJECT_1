package admin.service.mem;

import java.util.List;

import admin.DAO.mem.MemberDAO;
import admin.DTO.mem.MemberDTO;

public class MemberService {
	
	public List userList() {
		return new MemberDAO().userList();
	}
	
	public MemberDTO user(int user_seq) {
		return new MemberDAO().user(user_seq);
	}
}
