package user.controller.my;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.join.JoinDTO;
import user.service.my.MyService;

/**
 * Servlet implementation class MyInfoUpdateController
 */
@WebServlet("/user/update")
public class MyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 마이페이지 민원내역 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
	    String name = request.getParameter("name");
	    System.out.println("name : " + name);
	    String id = request.getParameter("id");
	    System.out.println("id : " + id);
	    String pw = request.getParameter("pw");
	    System.out.println("pw : " + pw);
	    
	    String tel = request.getParameter("tel");
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
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    System.out.println("seq : " + seq);
	    
	    JoinDTO dto = new JoinDTO();
	    
	    dto.setLike_id(Integer.parseInt(like));
		dto.setUser_addr1(address);
		dto.setUser_addr2(addressinfo);
		dto.setUser_email(email);
		dto.setUser_id(id);
		dto.setUser_name(name);
		dto.setUser_pw(pw);
		dto.setUser_tel(tel);
		dto.setUser_seq(seq);
	    
	    MyService service = new MyService();
	    service.userUpdate(dto);
	    
	    response.sendRedirect(request.getContextPath() +"/user/mypage_info");
	}

}
