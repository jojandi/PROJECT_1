package user.controller.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import user.dto.join.JoinDTO;
import user.service.login.LoginService;


@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 로그인 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		request.getRequestDispatcher("/WEB-INF/user/login/userlogin.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 로그인 dopost 실행!");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		String id= request.getParameter("id");
		String pw= request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		JoinDTO dto = new JoinDTO();
		
		dto.setUser_id(id);
		dto.setUser_pw(pw);
		
		LoginService service = new LoginService();
		
		JoinDTO result = service.login(dto);
		
		System.out.println("result : " + result);
		
		if(result != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login", result);
			
			// 세션 타임 제한, 초단위
			session.setMaxInactiveInterval(86400);
			
			// list 페이지로 sendRedirect
			response.sendRedirect(request.getContextPath() +"/user/main");
		} else {
			// login 페이지로 sendRedirect
			response.sendRedirect(request.getContextPath() +"/user/login?code=LO01");
		}
	
		
	}

}
