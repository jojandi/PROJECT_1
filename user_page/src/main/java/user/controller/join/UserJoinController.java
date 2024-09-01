package user.controller.join;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import user.dto.join.JoinDTO;
import user.service.join.JoinService;


@WebServlet("/user/join")
public class UserJoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 회원가입 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
	    String code = request.getParameter("code");
	    
	    System.out.println("code : " + code);
	    
		request.getRequestDispatcher("/WEB-INF/user/join/userjoin.jsp?code=" + code).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 회원가입 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String id = request.getParameter("username");
		
		JoinDTO dto = new JoinDTO();
		
		dto.setUser_id(id);
		
		JoinService service = new JoinService();
		JoinDTO result = service.idChk(dto);
		
		if(result == null) {
			System.out.println("사용 가능");
			response.sendRedirect(request.getContextPath() +"/user/join?code=LO01");
		} else {
			System.out.println("사용 불가능");
			response.sendRedirect(request.getContextPath() +"/user/join?code=LO02");
		}
	}

}
