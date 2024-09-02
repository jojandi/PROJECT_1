package mes_controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesPfworkDTO;
import mes_service.MesPfworkService;

@WebServlet("/pfwork_insert")
public class MesPfworkInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pfwork_insert doGet 실행");
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_pfwork/mes_pfwork.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pfwork_insert doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
//	    String os_id = request.getParameter("os_id");
	    String bom_code = request.getParameter("bom_code");
	    String emp_id = request.getParameter("emp_id");
	    String os_date = request.getParameter("os_date");
	    String buser_seq = request.getParameter("buser_seq");
	    
	    MesPfworkDTO PfworkDTO = new MesPfworkDTO();
	    
//	    PfworkDTO.setOs_id(Integer.parseInt(os_id));
	    PfworkDTO.setBom_code(Integer.parseInt(bom_code));
	    PfworkDTO.setEmp_id(Integer.parseInt(emp_id));
	    PfworkDTO.setOs_date(Date.valueOf(os_date));
	    PfworkDTO.setBuser_seq(Integer.parseInt(buser_seq));
	    
	    MesPfworkService PfworkService = new MesPfworkService();
	    int result = PfworkService.insert(PfworkDTO);
	    System.out.println("insert : " + result);
	    
	    response.sendRedirect("/mmes_page/pfwork");
	    
	}

}
