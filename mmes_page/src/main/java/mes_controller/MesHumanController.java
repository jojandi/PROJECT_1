package mes_controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesHumanDTO;
import mes_service.MesHumanService;



@WebServlet("/human")
public class MesHumanController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("직원관리 doGet 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        MesHumanService meshumanService = new MesHumanService ();
        List<MesHumanDTO> tryList = meshumanService.getList();
        
        request.setAttribute("list", tryList);
        request.getRequestDispatcher("/WEB-INF/mes/mes_human/human.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register doPost 실행");

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        String emp_name = request.getParameter("emp_name");
        String po_name = request.getParameter("po_name");
        String dept_name = request.getParameter("dept_name");
        String emp_hp = request.getParameter("emp_hp");
        String emp_add = request.getParameter("emp_add");
        String emp_hiredate = request.getParameter("emp_hiredate");

        MesHumanDTO dto = new MesHumanDTO();
       

        dto.setEmp_name(emp_name);
        dto.setPo_name(po_name);
        dto.setDept_name(dept_name);
        dto.setEmp_hp(emp_hp);
        dto.setEmp_add(emp_add);
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date;
        try {
            date = formatter.parse(emp_hiredate);
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            dto.setEmp_hiredate(sqlDate);
        } catch (ParseException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/errorPage.jsp"); // 예: 오류 페이지로 리다이렉트
            return;
        }

        MesHumanService meshumanService = new MesHumanService();
        int result = meshumanService.register(dto);
        System.out.println("insert 결과 : " + result);

        response.sendRedirect(request.getContextPath() + "/human");
    }
}
