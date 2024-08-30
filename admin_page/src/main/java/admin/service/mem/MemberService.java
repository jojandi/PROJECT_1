package admin.service.mem;

import java.util.List;

import admin.dao.mem.MemberDAO;
import admin.dto.mem.MemberDTO;

public class MemberService {
	
	public List userList() {
		return new MemberDAO().userList();
	}
	
	public MemberDTO user(int user_seq) {
		return new MemberDAO().user(user_seq);
	}
}
