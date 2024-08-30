package admin.service.mem;

import java.util.List;

import admin.dao.mem.MemberDAO;

public class MemberService {
	
	public List userList() {
		return new MemberDAO().userList();
	}
}
