package mes_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import mes_DTO.MesHumanDTO;
import mes_service.MesHumanService;

@WebServlet("/read")
public class MesHumanReadController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("/mes/read 실행");
		
		String str_emp_id = request.getParameter("emp_id");
		System.out.println("str_emp_id : "+ str_emp_id);
		
		int tno2 = Integer.parseInt(str_emp_id);
		
		MesHumanService mesService = new MesHumanService();
		MesHumanDTO dto2 = mesService.get(tno2);
		System.out.println(dto2);
		request.setAttribute("dto", dto2);
		request.getRequestDispatcher("/WEB-INF/mes/mes_human/mes_read.jsp").forward(request, response);

	}
}
