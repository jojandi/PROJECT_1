package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesStockDAO;
import mes_DTO.MesNoticeDTO;
import mes_DTO.MesStockDTO;
import mes_service.MesNoticeService;
import mes_service.MesStockService;



@WebServlet("/stock")
public class MesStockController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/stock doget실행");
		// 재고 확인 -----------------------------------------------
		MesStockService stockservice = new MesStockService();
		List<MesStockDTO> stockList = stockservice.getMesBook();

		request.setAttribute("mesBook", stockList);
		// 세트재고 확인 -----------------------------------------------

		List<MesStockDTO> productList = stockservice.getPruduct();
		request.setAttribute("productList", productList);
		System.out.println("productList 실행"+productList);
		//----------------------------------------------------------
		
		// 발주 ----------------------------------------------------
		
		List<MesStockDTO> orderlist = stockservice.getorderlist();
		request.setAttribute("tbl_order", orderlist);
		System.out.println(orderlist);
		// ---------------------------------------------------------
		
		// 부품코드 셀렉트 옵션을 jsp로 전달해주는놈~
		MesStockDAO dao = new MesStockDAO();
		List<String> mesBookCodes = dao.getMesBookCodes();
		request.setAttribute("mes_book_code", mesBookCodes);
		// ---------------------------------------------------------
		// 발주처id를 셀렉트 옵션을 jsp로 전달해주는놈~

		List<String> mesPubId = dao.getMesPubId();
		request.setAttribute("pub_id", mesPubId);

		// ---------------------------------------------------------
		request.getRequestDispatcher("/WEB-INF/mes/mes_stock/mes_stock.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		System.out.println("/stock doPost실행");
		// 한글 깨짐 방지------------------------------------------
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		// --------------------------------------------------------
		// 발주 insert---------------------------------------------
	    String mes_book_code = request.getParameter("mes_book_code");
	    String order_count = request.getParameter("order_count");
	    String pub_id = request.getParameter("pub_id");

		
	    MesStockDTO dto = new MesStockDTO();
	    dto.setMes_book_code(Integer.parseInt(mes_book_code));
	    dto.setOrder_count(Integer.parseInt(order_count));
	    dto.setPub_id(pub_id);
	    System.out.println(mes_book_code);
	    System.out.println("pub_id"+pub_id);
	    MesStockService stockservice = new MesStockService();
	    int result = stockservice.order(dto);
	    System.out.println("insert : " + result);
	    
		// --------------------------------------------------------
	    
	    response.sendRedirect("/mmes_page/stock");

	}

}
