package admin.controller.mem;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.dto.mem.MemberDTO;
import admin.service.mem.MemberService;

@WebServlet("/admin/member_")
public class MemberReadaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원관리 상세페이지 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
	    MemberService service = new MemberService();
	    
	    MemberDTO dto = service.user(seq);
		
	    request.setAttribute("dto", dto);
		request.getRequestDispatcher("/WEB-INF/admin/member/mem_read.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
