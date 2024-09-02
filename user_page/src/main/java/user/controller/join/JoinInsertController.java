package user.controller.join;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.join.JoinDTO;
import user.service.join.JoinService;

@WebServlet("/user/join_insert")
public class JoinInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 회원가입 완료 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String name = request.getParameter("user_name");
	    System.out.println("name : " + name);
	    String id = request.getParameter("username");
	    System.out.println("id : " + id);
	    String pw = request.getParameter("user_pw");
	    System.out.println("pw : " + pw);
	    
	    String yyyy = request.getParameter("yyyy");
	    String mm = request.getParameter("mm");
	    String dd = request.getParameter("dd");
	    String d = yyyy + "-" + mm + "-" + dd;
	    java.sql.Date birth = java.sql.Date.valueOf(d);
	    System.out.println("birth : " + birth);
	    
	    String tel = request.getParameter("user_tel");
	    System.out.println("tel : " + tel);
	    String address = request.getParameter("address");
	    System.out.println("address : " + address);
	    String addressinfo = request.getParameter("addressinfo");
	    System.out.println("addressinfo : " + addressinfo);
	    
	    String user_email = request.getParameter("user_email");
	    String domain = request.getParameter("domain");
	    String email = user_email + "@" + domain;
	    System.out.println("email : " + email);
	   
	    String like = request.getParameter("like");
	    System.out.println("like : " + like);
	    
	    JoinDTO dto = new JoinDTO();
	    
	    dto.setLike_id(Integer.parseInt(like));
		dto.setUser_addr1(address);
		dto.setUser_addr2(addressinfo);
		dto.setUser_birth(birth);
		dto.setUser_email(email);
		dto.setUser_id(id);
		dto.setUser_name(name);
		dto.setUser_pw(pw);
		dto.setUser_tel(tel);
		dto.setUser_sub(false);
		
		JoinService service = new JoinService();
		int resutl = service.join(dto);
		
		System.out.println("resutl : " + resutl);
		
		request.setAttribute("dto", dto);
		
		request.getRequestDispatcher("/WEB-INF/user/login/userlogin.jsp").forward(request, response);
	}

}
