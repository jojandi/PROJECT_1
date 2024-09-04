package mes_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesStockDTO;
import mes_service.MesStockService;

@WebServlet("/stockUpdate")
public class MesStrockUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("update doget 실행");

		String order_id = request.getParameter("order_id");
		System.out.println("order_id : " + order_id);

		// 문자를 숫자로 String to int
		int order_id2 = Integer.parseInt(order_id);

		MesStockService stockservice = new MesStockService();
		MesStockDTO dto = stockservice.getStockOrder(order_id2);

		request.setAttribute("dto", dto);
		// stock_update read -----------------------------------------------

		request.getRequestDispatcher("/WEB-INF/mes/mes_stock/stock_update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		
		System.out.println("update doPost 실행");
		
		String orderId = request.getParameter("order_id");
		String orderSt = request.getParameter("order_st");
		int orderCount = Integer.parseInt(request.getParameter("order_count"));
		String mesBookCode = request.getParameter("mes_book_code");
		
		MesStockDTO dto = new MesStockDTO();
		
		dto.setOrder_id(orderId);
		dto.setOrder_st(orderSt);
		dto.setOrder_count(orderCount);
		dto.setMes_book_code(Long.parseLong(mesBookCode));
		
		// 주문 상태가 "완료"로 변경되었을 때
		if ("완료".equals(orderSt)) {
			// 1. tbl_order 테이블에서 해당 주문 삭제
			MesStockService stockservice = new MesStockService();
			stockservice.deleteOrder(dto);

			// 2. mes_book 테이블에서 book_count 업데이트 (수량 추가)
			stockservice.updateMesBook(dto);
		}
		System.out.println("update dto:"+dto);
		// 완료 후 리디렉션 또는 적절한 응답 처리
		response.sendRedirect("/mmes_page/stock");

	}

}
