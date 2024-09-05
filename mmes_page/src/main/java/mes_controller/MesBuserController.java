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
		
		MesBuserService BuserService = new MesBuserService();
		
		List list = BuserService.getBuser();
		
		request.setAttribute("list", list);
		
		MesHumanService meshumanService = new MesHumanService ();
        List<MesHumanDTO> tryList = meshumanService.getList();
        
        request.setAttribute("list2", tryList);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_human/human_buser.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
