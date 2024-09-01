package user.controller.my;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dto.join.JoinDTO;
import user.service.my.MyService;

@WebServlet("/user/user_del")
public class UserMyDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 delete doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
	    // 파라미터에서 tno값 가져오기
 		int code = Integer.parseInt(request.getParameter("code"));
 		
 		// DTO의 tno에 파라미터에서 가져온 tno 넣어주기
 		JoinDTO dto = new JoinDTO();
 		dto.setUser_seq(code);
 		
 		// service의 delete메소드 실행
 		MyService service = new MyService();
 		int result = service.delete(dto);
 		System.out.println("삭제 개수 : " + result);
 		
 		// 실행 후 list.jsp로 이동
 		response.sendRedirect("main");
	    
	}

}
