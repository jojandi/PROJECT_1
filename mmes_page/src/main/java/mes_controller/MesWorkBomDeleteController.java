package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesWorkorderDTO;
import mes_service.MesWorkorderService;

@WebServlet("/delete")
public class MesWorkBomDeleteController extends HttpServlet {

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        System.out.println("/mes/bom/read 실행");
	        
	        // BOM 코드 파라미터를 가져옵니다.
	        String str_bom_code = request.getParameter("bom_code");
	        System.out.println("str_bom_code : " + str_bom_code);
	        
	        int bom_code = Integer.parseInt(str_bom_code);
	        
	        // 서비스 객체를 생성하고 데이터 가져오기
	        MesWorkorderService workorderService = new MesWorkorderService();
	        List<MesWorkorderDTO> bookList = workorderService.get(bom_code);
	        
	        // 결과를 로그로 출력
	        System.out.println("책 정보 리스트: " + bookList);
	        
	        // JSP 페이지에 데이터 전달
	        request.setAttribute("bookList", bookList);
	        request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_bom_read.jsp").forward(request, response);
	    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str_bom_code = request.getParameter("bom_code");
		int bom_code2 = Integer.parseInt(str_bom_code);
		System.out.println(bom_code2);
		MesWorkorderService service = new MesWorkorderService();
		int result = service.remove(bom_code2);
		
		System.out.println("삭제 개수 : "+ result);
		
		response.sendRedirect("workorder");
	
	}

}
