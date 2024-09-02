package mes_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesHumanDTO;
import mes_service.MesHumanService;

@WebServlet("/modify")
public class MesHumanModifyController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	System.out.println("/modify doGet 실행");
		
	String str_emp_id = request.getParameter("emp_id");
	System.out.println("str_emp_id : "+ str_emp_id);
	
	int tno2 = Integer.parseInt(str_emp_id);
	
	MesHumanService mesService = new MesHumanService();
	MesHumanDTO dto2 = mesService.get(tno2);
	System.out.println(dto2);
	request.setAttribute("dto", dto2);
	request.getRequestDispatcher("/WEB-INF/mes/mes_human/mes_read.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  System.out.println("modify doPost 실행");
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8;");
			
			String str_emp_id = request.getParameter("emp_id");
			int emp_id2 = Integer.parseInt(str_emp_id);
			
			
	        String emp_name = request.getParameter("emp_name");
	        String po_name = request.getParameter("po_name");
	        String dept_name = request.getParameter("dept_name");
	        String emp_hp = request.getParameter("emp_hp");
	        String emp_add = request.getParameter("emp_add");
	        String emp_hiredate = request.getParameter("emp_hiredate");
			System.out.println(emp_name+po_name+dept_name+emp_hp+emp_add+emp_hiredate);
			
			MesHumanDTO humanDTO = new MesHumanDTO();
			humanDTO.setEmp_id(emp_id2);
			humanDTO.setEmp_name(emp_name);
			humanDTO.setPo_name(po_name);
			humanDTO.setDept_name(dept_name);
			humanDTO.setEmp_hp(emp_hp);
			humanDTO.setEmp_add(emp_add);
			humanDTO.setPo_name(po_name);
			  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		        formatter.setLenient(false);
		        try {
		            if (emp_hiredate == null || emp_hiredate.trim().isEmpty()) {
		                throw new ParseException("날짜 값이 비어있습니다.", 0);
		            }
		            Date date = formatter.parse(emp_hiredate);
		            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		            
		            // 날짜 검증: 유효한 날짜인지 확인
		            if (sqlDate.getYear() < 0 || sqlDate.getYear() > 9999) {
		                throw new ParseException("잘못된 연도입니다.", 0);
		            }
		            humanDTO.setEmp_hiredate(sqlDate);
		        } catch (ParseException e) {
		            e.printStackTrace();
		            response.sendRedirect(request.getContextPath() + "/errorPage.jsp");
		            return;
		        }

		        MesHumanService meshumanService = new MesHumanService();
		        int result = meshumanService.modify(humanDTO);
		        System.out.println("update 결과 : " + result);

		        response.sendRedirect(request.getContextPath() + "/human");
		}


}
