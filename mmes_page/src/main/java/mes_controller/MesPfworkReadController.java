package mes_controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesPfworkDTO;
import mes_service.MesPfworkService;

@WebServlet("/pfwork_read")
public class MesPfworkReadController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pfwork_read doGet 실행");
		
		MesPfworkDAO PfworkDAO = new MesPfworkDAO();
		
		int os_id = Integer.parseInt( request.getParameter("os_id") );
		
		MesPfworkService PfworkService = new MesPfworkService();
		MesPfworkDTO PfworkDTO = PfworkService.One(os_id);
		
		System.out.println("asdf : " + PfworkDTO);
		
		request.setAttribute("read", PfworkDTO);
		
		
		List mesbom_code = PfworkDAO.getMesbom_code();
		request.setAttribute("bom_code", mesbom_code);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_pfwork/mes_pfworkRead.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pfworkRead doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String os_id = request.getParameter("os_id");
	    String bom_code = request.getParameter("bom_code");
	    String user_id = request.getParameter("user_id");
//	    String os_date = request.getParameter("os_date");
	    String emp_name = request.getParameter("emp_name");
	    
//	    System.out.println("Received os_date: " + os_date);
	    
	    MesPfworkDTO PfworkDTO = new MesPfworkDTO();
	    PfworkDTO.setOs_id( Integer.parseInt(os_id) );
	    PfworkDTO.setBom_code(Integer.parseInt(bom_code));
	    PfworkDTO.setUser_id(user_id);
//	    PfworkDTO.setOs_date(Date.valueOf(os_date));
	    PfworkDTO.setEmp_name(emp_name);
	    
	    MesPfworkService PfworkService = new MesPfworkService();
	    int result = PfworkService.update(PfworkDTO);
	    System.out.println("insert : " + result);
	    
	    response.sendRedirect("/mmes_page/pfwork");		
	}

}
