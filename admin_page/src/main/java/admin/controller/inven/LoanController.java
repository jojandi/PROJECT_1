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
import admin.service.inven.LoanService;



@WebServlet("/admin/loan")
public class LoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 대출 관리 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String countPerPage = request.getParameter("countPerPage"); // 한 페이지 당 몇 개
		String page = request.getParameter("page"); // 현재 페이지
//		System.out.println("현재 페이지 : " + page);
//		System.out.println("페이지 당 개수 : " + countPerPage);
		
		// 기본값 설정
		if(countPerPage == null) countPerPage = "10";
		if(page == null) page = "1";
	    
	    LoanService service = new LoanService();
	    Map map = service.memLoanList(countPerPage, page);
	    
	    request.setAttribute("map", map); 
	    request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/admin/inven/loan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("회원 대출 관리 업데이트 doPost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String ing = request.getParameter("ing");
	    String seq = request.getParameter("seq");
	    String code = request.getParameter("code");
	    
	    LoanResDTO dto = new LoanResDTO();
	    InvenDTO idto = new InvenDTO();
	    
	    dto.setLoan_seq(Integer.parseInt(seq));
	    idto.setBook_code(Integer.parseInt(code));
	    
	    if("Y".equals(ing)) {	    	
	    	dto.setLoan_ing(true);
	    } else {
	    	dto.setLoan_ing(false);
	    }
	    
	    LoanService service = new LoanService();
	    int result = service.memLoanUpdate(dto);
	    System.out.println("반납 : " + result);
	    
	    int update = service.invenUpdate(idto);
	    System.out.println("- : " + update);
	    
	    int mem = service.memberUpdate(dto);
	    System.out.println("회원 연체 : " + mem);
		
	    response.sendRedirect( request.getContextPath() + "/admin/loan");
	}

}
