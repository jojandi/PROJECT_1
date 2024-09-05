package admin.controller.inven;

import java.io.IOException;
import java.util.List;

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
	    
	    LoanService service = new LoanService();
	    List list = service.memLoanList();
	    
	    request.setAttribute("list", list);
		
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
		
	    response.sendRedirect( request.getContextPath() + "/admin/loan");
	}

}
