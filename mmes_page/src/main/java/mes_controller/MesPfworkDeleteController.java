package mes_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesPfworkDTO;
import mes_service.MesPfworkService;

@WebServlet("/pfwork_delete")
public class MesPfworkDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("pfwork_delete doGet 실행");
		
		int os_id = Integer.parseInt(request.getParameter("os_id"));
		
		MesPfworkDTO PfworkDTO = new MesPfworkDTO();
		PfworkDTO.setOs_id(os_id);
		
		MesPfworkService PfworkService = new MesPfworkService();
		int result = PfworkService.delete(PfworkDTO);
		System.out.println("result : " + result);
		
		response.sendRedirect("/mmes_page/pfwork");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
