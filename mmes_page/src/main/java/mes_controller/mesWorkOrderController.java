package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import mes_DTO.MesWorkorderDTO;
import mes_service.MesWorkorderService;
=======
import mes_service.MesWorkOrderWoService;
>>>>>>> 68cd16970854fc07e6d06ad3afc7a8b79d1816c8

@WebServlet("/workorder")
public class mesWorkOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		
		// 여기는 bomlist입니다--------------------------------------------------------
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        MesWorkorderService mesworkorderService = new MesWorkorderService ();
        List<MesWorkorderDTO> List = mesworkorderService.getList();
        
        request.setAttribute("list", List);
        //-------------------------------------------------------------------------
		
		
		
=======
	
		System.out.println("workorder doGet 실행");
		
		MesWorkOrderWoService WoService = new MesWorkOrderWoService();
		
		List list = WoService.getWorkwo();
		
		request.setAttribute("list", list);
		
		System.out.println(list);
>>>>>>> 68cd16970854fc07e6d06ad3afc7a8b79d1816c8
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_workorder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
