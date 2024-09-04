package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesWorkorderWoDAO;
import mes_DTO.MesWorkorderWoDTO;
import mes_service.MesWorkOrderWoService;

@WebServlet("/wo_update")
public class MesWorkOrderWoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("updat doGet 실행");
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    MesWorkorderWoDAO woDAO = new MesWorkorderWoDAO();
		
		MesWorkOrderWoService WoService = new MesWorkOrderWoService();
		

		List list1 = WoService.getWorkwo();
		
		request.setAttribute("list1", list1);
		
		System.out.println(list1);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_workorderupdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		String wo_id = request.getParameter("wo_id");
		String bom_code = request.getParameter("bom_code");
		String wo_count = request.getParameter("wo_count");
		String wo_status = request.getParameter("wo_status");
		
		
		MesWorkorderWoDTO dto = new MesWorkorderWoDTO();
		
		dto.setWo_id(Integer.parseInt(wo_id));
		dto.setBom_code(Integer.parseInt(bom_code));
		dto.setWo_count(Integer.parseInt(wo_count));
		dto.setWo_status(wo_status);
		
		
		// 주문 상태가 "완료"로 변경되었을 때
	      if ("완료".equals(wo_status)) {
	         // 1. tbl_order 테이블에서 해당 주문 삭제
	    	 MesWorkOrderWoService WoService = new MesWorkOrderWoService();
	    	 WoService.delete(dto);

	         // 2. mes_book 테이블에서 book_count 업데이트 (수량 추가)
	    	 WoService.update(dto);
	      }
	      System.out.println("update dto:"+dto);
	      // 완료 후 리디렉션 또는 적절한 응답 처리
	      response.sendRedirect("/mmes_page/workorder");
		
	}

}
