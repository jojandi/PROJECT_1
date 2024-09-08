package mes_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesStockDAO;
import mes_DTO.MesHumanDTO;
import mes_DTO.MesStockDTO;
import mes_DTO.MesWorkorderDTO;
import mes_service.MesHumanService;
import mes_service.MesStockService;
import mes_service.MesWorkorderService;

/**
 * Servlet implementation class MesWorkOrderReadController
 */
@WebServlet("/bom_read")
public class MesWorkOrderReadController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("/bom_read 실행");

		String bom_code = request.getParameter("bom_code");
		System.out.println("bom_code : " + bom_code);

		int bom_code2 = Integer.parseInt(bom_code);

		MesWorkorderService bomservice = new MesWorkorderService();
		MesWorkorderDTO dto = bomservice.getBomSelectOne(bom_code2);

		request.setAttribute("dto", dto);
		// 부품코드 셀렉트 옵션을 jsp로 전달해주는놈~
		MesStockDAO dao = new MesStockDAO();
		List<String> mesBookCodes = dao.getMesBookCodes();
		request.setAttribute("mes_book_code", mesBookCodes);
		// ---------------------------------------------------------

		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_bom_read.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 System.out.println("update doPost 실행");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			
			String str_bom_code = request.getParameter("bom_code");
			int bom_code3 = Integer.parseInt(str_bom_code);
			
			
	        String bom_name = request.getParameter("bom_name");
	        String mes_book_code1 = request.getParameter("mes_book_code1");
	        String mes_book_code2 = request.getParameter("mes_book_code2");
	        String mes_book_code3 = request.getParameter("mes_book_code3");
	       
			
			MesWorkorderDTO orderDTO = new MesWorkorderDTO();
			orderDTO.setBom_code(bom_code3);
			orderDTO.setBom_name(bom_name);
			orderDTO.setMes_book_code1(Integer.parseInt(mes_book_code1));
			orderDTO.setMes_book_code2(Integer.parseInt(mes_book_code2));
			orderDTO.setMes_book_code3(Integer.parseInt(mes_book_code3));
			
		        MesWorkorderService workorderService = new MesWorkorderService();
		        int result = workorderService.update(orderDTO);
		        System.out.println("update 결과 : " + result);

		        response.sendRedirect("http://localhost:8080/mmes_page/workorder");
		}



	
}
