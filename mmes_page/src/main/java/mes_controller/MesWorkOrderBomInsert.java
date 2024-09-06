package mes_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesHumanDTO;
import mes_DTO.MesWorkorderDTO;
import mes_service.MesHumanService;
import mes_service.MesWorkorderService;

@WebServlet("/register")
public class MesWorkOrderBomInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("register doPost 실행");

	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8;");
	        
	        String bom_code = request.getParameter("bom_code");
	        String bom_name = request.getParameter("bom_name");
	        String mes_book_code1 = request.getParameter("mes_book_code1");
	        String mes_book_code2 = request.getParameter("mes_book_code2");
	        String mes_book_code3 = request.getParameter("mes_book_code3");
	       

	        MesWorkorderDTO dto = new  MesWorkorderDTO();
	       

	        dto.setBom_code(Integer.parseInt(bom_code));
	        dto.setBom_name(bom_name);
	        dto.setMes_book_code1(Integer.parseInt(mes_book_code1));
	        dto.setMes_book_code2(Integer.parseInt(mes_book_code2));
	        dto.setMes_book_code3(Integer.parseInt(mes_book_code3));
	      
	       
	        MesWorkorderService mesworkorderService = new MesWorkorderService();
	        int result = mesworkorderService.register(dto);
	        System.out.println("insert 결과 : " + result);

	        response.sendRedirect(request.getContextPath() + "/workorder");
	    }
	

}
