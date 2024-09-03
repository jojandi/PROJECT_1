package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_service.MesWorkOrderWoService;

@WebServlet("/workorder")
public class mesWorkOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("workorder doGet 실행");
		
		MesWorkOrderWoService WoService = new MesWorkOrderWoService();
		
		List list = WoService.getWorkwo();
		
		request.setAttribute("list", list);
		
		System.out.println(list);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_workorder.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
