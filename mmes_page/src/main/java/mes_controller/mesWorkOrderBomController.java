package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesHumanDTO;
import mes_DTO.MesWorkorderDTO;
import mes_service.MesHumanService;
import mes_service.MesWorkorderService;

@WebServlet("/bom")
public class mesWorkOrderBomController extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		        System.out.println("Bomcreate 실행!");
		    	// 여기는 bomlist입니다--------------------------------------------------------
		        request.setCharacterEncoding("utf-8");
		        response.setContentType("text/html; charset=utf-8;");
		        
		        MesWorkorderService mesworkorderService = new MesWorkorderService ();
		        List<MesWorkorderDTO> List = mesworkorderService.getList2();
		        
		        request.setAttribute("list", List);
		        //-------------------------------------------------------------------------
				
				        
		        
		        
		        
		        
		        request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_bomcreate.jsp").forward(request, response);
		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
