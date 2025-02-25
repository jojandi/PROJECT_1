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
public class LoginController extends HttpServlet {
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
		
		JoinDTO user = service.login(dto);
		JoinDTO admin = service.loginAdmin(dto);
		JoinDTO mes = service.loginMes(dto);
		
		if(user != null) {
			HttpSession session = request.getSession();
			// 세션 타임 제한, 초단위
			session.setMaxInactiveInterval(60 * 60 * 60);

			session.setAttribute("login", user);
			session.setAttribute("isLogin", true);
			
			// 사용자 main 페이지로 sendRedirect
			response.sendRedirect(request.getContextPath() +"/user/main");
		} else if(admin != null) {
			HttpSession session = request.getSession();
			// 세션 타임 제한, 초단위
			session.setMaxInactiveInterval(60 * 60 * 60);

			session.setAttribute("login", admin);
			session.setAttribute("isLogin", true);
			
			// 관리자 main 페이지로 sendRedirect
			response.sendRedirect("http://localhost:8080/admin_page/admin/main");
		} else if(mes != null) {
			HttpSession session = request.getSession();
			// 세션 타임 제한, 초단위
			session.setMaxInactiveInterval(60 * 60 * 60);

			session.setAttribute("login", mes);
			session.setAttribute("isLogin", true);
			
			// 관리자 main 페이지로 sendRedirect
			response.sendRedirect("http://localhost:8080/mmes_page/main");
		} else {
			// login 페이지로 sendRedirect
			response.sendRedirect(request.getContextPath() +"/user/login?code=LO01");
		}
	
		
	}

}
