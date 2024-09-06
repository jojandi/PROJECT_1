package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesHumanDTO;
import mes_service.MesBuserService;
import mes_service.MesHumanService;

@WebServlet("/buser")
public class MesBuserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("buser doGet 실행");
		
		String user_id2 =  request.getParameter("user_id2");
		System.out.println("user_id2: " + user_id2);
		
		MesBuserService BuserService = new MesBuserService();
		List list = BuserService.getBuser(user_id2);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_bookflix/human_buser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
