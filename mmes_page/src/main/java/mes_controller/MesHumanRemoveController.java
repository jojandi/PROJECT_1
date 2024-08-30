package mes_controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_service.MesHumanService;

@WebServlet("/remove")
public class MesHumanRemoveController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_emp_id = request.getParameter("emp_id");
		int emp_id2 = Integer.parseInt(str_emp_id);
		System.out.println(emp_id2);
		MesHumanService service = new MesHumanService();
		int result = service.remove(emp_id2);
		
		System.out.println("삭제 개수 : "+ result);
		
		response.sendRedirect("human");
	}

}
