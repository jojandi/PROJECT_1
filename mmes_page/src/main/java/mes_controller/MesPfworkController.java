package mes_controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesNoticeDTO;
import mes_DTO.MesPfworkDTO;
import mes_service.MesNoticeService;
import mes_service.MesPfworkService;

@WebServlet("/pfwork")
public class MesPfworkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pfwork doGet 실행");
		

		MesPfworkService PfworkService = new MesPfworkService();
		MesPfworkDTO pfDTO = new MesPfworkDTO();
		MesPfworkDAO PfworkDAO = new MesPfworkDAO();

		// ------------------------ pfwork 주문현황-------------------------
		List list = PfworkService.getPfwork();

		request.setAttribute("list", list);

		System.out.println(pfDTO.toString());

		// 발주처id를 셀렉트 옵션을 jsp로 전달해주는놈~

		List<String> mesEmp_id = PfworkDAO.getMesPubId();
		request.setAttribute("emp_id", mesEmp_id);
		
		// bom 셀렉트 jsp로 전달해주는 놈 ~
		List mesbom_code = PfworkDAO.getMesbom_code();
		request.setAttribute("bom_code", mesbom_code);
		
		// user_name 셀렉트 jsp로 전달해주는 놈 ~
		List<String> mesbuser_seq = PfworkDAO.getMesbuser_seq();
		request.setAttribute("buser_seq", mesbuser_seq);
		
		// ------------------------ pfwork 주문현황-------------------------
		
		// ------------------------ pfwork 출고현황-------------------------
		List list1 = PfworkService.getPfworkds();

		request.setAttribute("ds", list1);

		System.out.println(pfDTO.toString());
		// ------------------------ pfwork 출고현황-------------------------
		
		// ------------------------ pfwork update-------------------------
//		int os_id = Integer.parseInt( request.getParameter("os_id") );
//		MesPfworkDTO PfworkDTO = PfworkService.get(os_id);
//		request.setAttribute("update", PfworkDTO);
		

		request.getRequestDispatcher("/WEB-INF/mes/mes_pfwork/mes_pfwork.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		System.out.println("update doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String os_id = request.getParameter("os_id");
	    String bom_name = request.getParameter("bom_name");
	    String user_id = request.getParameter("user_id");
	    String os_date = request.getParameter("os_date");
	    String emp_name = request.getParameter("emp_name");
	    
	    MesPfworkDTO PfworkDTO = new MesPfworkDTO();
	    PfworkDTO.setOs_id( Integer.parseInt(os_id) );
	    PfworkDTO.setBom_name(bom_name);
	    PfworkDTO.setUser_id(user_id);
	    PfworkDTO.setOs_date(Date.valueOf(os_date));
	    PfworkDTO.setEmp_name(emp_name);
	    
	    MesPfworkService PfworkService = new MesPfworkService();
	    int result = PfworkService.update(PfworkDTO);
	    System.out.println("insert : " + result);
	    
	    response.sendRedirect("/mmes_page/pfwork");	
		
	}

}
