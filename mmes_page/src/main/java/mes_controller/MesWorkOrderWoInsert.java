package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesWorkorderWoDAO;
import mes_DTO.MesWorkorderWoDTO;
import mes_service.MesWorkOrderWoService;

@WebServlet("/wo_insert")
public class MesWorkOrderWoInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("wo_insert doGet 실행");
		
		MesWorkorderWoDAO woDAO = new MesWorkorderWoDAO();
		
		// bom 셀렉트 jsp로 전달해주는 놈 ~
		List mesbom_code = woDAO.getMesbom_code();
		request.setAttribute("bom_code", mesbom_code);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_workorderwoinsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("wo_insert doPost 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String bom_code = request.getParameter("bom_code");
	    String wo_process = request.getParameter("wo_process");
	    String wo_count = request.getParameter("wo_count");
	    String wo_status = request.getParameter("wo_status");
	    
	    MesWorkorderWoDTO woDTO = new MesWorkorderWoDTO();
	    woDTO.setBom_code(Integer.parseInt(bom_code));
	    woDTO.setWo_process(wo_process);
	    woDTO.setWo_count(Integer.parseInt(wo_count));
	    woDTO.setWo_status(wo_status);
	    
	    MesWorkOrderWoService WoService = new MesWorkOrderWoService();
	    int result = WoService.insert(woDTO);
	    System.out.println("insert : " + result);
	    
	    response.sendRedirect("/mmes_page/workorder");
	}

}
