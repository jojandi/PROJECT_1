package admin.controller.inven;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DTO.inven.InvenDTO;
import admin.DTO.inven.LoanResDTO;
import admin.service.inven.ResService;



@WebServlet("/admin/res")
public class ResController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 예약 관리 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String countPerPage = request.getParameter("countPerPage"); // 한 페이지 당 몇 개
		String page = request.getParameter("page"); // 현재 페이지
//		System.out.println("현재 페이지 : " + page);
//		System.out.println("페이지 당 개수 : " + countPerPage);
		
		// 기본값 설정
		if(countPerPage == null) countPerPage = "10";
		if(page == null) page = "1";
	    
	    ResService service = new ResService();
	    Map map = service.memResList(countPerPage, page);
	    
	    request.setAttribute("map", map); 
	    request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/admin/inven/res.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 예약 관리 업데이트 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String seq = request.getParameter("seq");
	    String code = request.getParameter("code");
	    String user = request.getParameter("user");
	    System.out.println(user);
	    
	    LoanResDTO dto = new LoanResDTO();
	    InvenDTO idto = new InvenDTO();
	    
	    dto.setRes_id(Integer.parseInt(seq));
	    dto.setBook_code(Integer.parseInt(code));
	    dto.setUser_seq(Integer.parseInt(user));
	    
	    idto.setBook_code(Integer.parseInt(code));
	    
	    ResService service = new ResService();
	    int result = service.memResUpdate(dto);
	    System.out.println("예약 : " + result);
	    
	    result = service.resLoan(dto);
	    System.out.println("대출 : " + result);
	    
	    int update = service.invenUpdate(idto);
	    System.out.println("대출중 : " + update);
	    
	    int update2 = service.invenUpdate2(idto);
	    System.out.println("예약X : " + update2);
	    
		
	    response.sendRedirect( request.getContextPath() + "/admin/res");
	}

}
