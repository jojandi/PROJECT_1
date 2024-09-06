package mes_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesMainDAO;
import mes_DTO.MesMainDTO;
import mes_DTO.MesWorkorderDTO;
import mes_service.MesMainService;
import mes_service.MesWorkorderService;

	@WebServlet("/status")
	public class  MesMainstatusController extends HttpServlet {

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	        System.out.println("Bomcreate 실행!");
	    	// 여기는 bomlist입니다--------------------------------------------------------
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8;");
	        
	        MesMainService mesmainService = new MesMainService ();
	        List< MesMainDTO> List = mesmainService.getList();
	        
	        request.setAttribute("list", List);
	        //-------------------------------------------------------------------------
			
			        
	        
	        
	        
	        
	        request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_main.jsp").forward(request, response);
	    

			}
		
	}
