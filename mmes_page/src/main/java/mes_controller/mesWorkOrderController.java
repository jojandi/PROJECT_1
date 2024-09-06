package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mes_DAO.MesWorkorderWoDAO;


import mes_DTO.MesWorkorderDTO;
import mes_service.MesWorkorderService;


import mes_service.MesWorkOrderWoService;


@WebServlet("/workorder")
public class mesWorkOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8");
	     response.setContentType("text/html; charset=utf-8;");
	
		System.out.println("workorder doGet 실행");
		
		MesWorkorderWoDAO woDAO = new MesWorkorderWoDAO();
		
		MesWorkOrderWoService WoService = new MesWorkOrderWoService();

		List list2 = WoService.getWorkwo();
		
		request.setAttribute("list", list2);
		
		System.out.println(list2);
		
		// bom 셀렉트 jsp로 전달해주는 놈 ~
		List mesbom_code = woDAO.getMesbom_code();
		request.setAttribute("bom_code", mesbom_code);

		List list1 = WoService.getWorkwo();
		
		request.setAttribute("list1", list1);
		
		System.out.println(list1);
		
        
    	
        // 여기는 bomlist입니다--------------------------------------------------------
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        MesWorkorderService mesworkorderService = new MesWorkorderService ();
        List<MesWorkorderDTO> list = mesworkorderService.getList();
        
        request.setAttribute("list", list);
        System.out.println(list);
        System.out.println("Bom_2 실행!");
        
        //-------------------------------------------------------------------------
		
		


		
		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_workorder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		System.out.println("workorder doPost 실행");
		
	

		

	}

}
