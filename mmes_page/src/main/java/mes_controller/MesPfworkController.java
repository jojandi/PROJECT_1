package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesPfworkDAO;
import mes_DTO.MesPfworkDTO;
import mes_service.MesPfworkService;

@WebServlet("/pfwork")
public class MesPfworkController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("pfwork doGet 실행");
		

		MesPfworkService PfworkService = new MesPfworkService();

		// ------------------------ pfwork 주문현황-------------------------
		List list = PfworkService.getPfwork();

		request.setAttribute("list", list);

		MesPfworkDTO pfDTO = new MesPfworkDTO();

		System.out.println(pfDTO.toString());

		// 발주처id를 셀렉트 옵션을 jsp로 전달해주는놈~
		MesPfworkDAO PfworkDAO = new MesPfworkDAO();

		List<String> mesEmp_id = PfworkDAO.getMesPubId();
		request.setAttribute("emp_id", mesEmp_id);
		
		// bom 셀렉트 jsp로 전달해주는 놈 ~
		List mesbom_code = PfworkDAO.getMesbom_code();
		request.setAttribute("bom_code", mesbom_code);
		
		// user_name 셀렉트 jsp로 전달해주는 놈 ~
		List<String> mesbuser_seq = PfworkDAO.getMesbuser_seq();
		request.setAttribute("buser_seq", mesbuser_seq);
		
		// ------------------------ pfwork 주문현황-------------------------
		
		// ------------------------ pfwork 출고현황-------------------------
		List list1 = PfworkService.getPfworkds();

		request.setAttribute("ds", list1);

		System.out.println(pfDTO.toString());

		request.getRequestDispatcher("/WEB-INF/mes/mes_pfwork/mes_pfwork.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
