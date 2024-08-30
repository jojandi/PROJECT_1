package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DTO.MesStockDTO;
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
		// 재고 확인 -----------------------------------------------
		// 발주 ----------------------------------------------------
		
		List<MesStockDTO> orderlist = stockservice.getorderlist();
		request.setAttribute("tbl_order", orderlist);
		System.out.println(orderlist);
		// ---------------------------------------------------------

		request.getRequestDispatcher("/WEB-INF/mes/mes_stock/mes_stock.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
