package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesStockDAO;
import mes_DTO.MesStockDTO;
import mes_service.MesStockService;

@WebServlet("/bomupdate")
public class MesBomUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("/bomupdate doget실행");
		// 재고 확인 -----------------------------------------------
		MesStockService stockservice = new MesStockService();
		List<MesStockDTO> stockList = stockservice.getMesBook();

		request.setAttribute("mesBook", stockList);
		// 부품코드 셀렉트 옵션을 jsp로 전달해주는놈~
		MesStockDAO dao = new MesStockDAO();
		List<String> mesBookCodes = dao.getMesBookCodes();
		request.setAttribute("mes_book_code", mesBookCodes);
		// ---------------------------------------------------------

		request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/mes_bom_update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
