package mes_controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesReviewDAO;
import mes_service.MesReviewService;

@WebServlet("/review")
public class MesReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("review doGet 실행");
		
		MesReviewDAO rvdao = new MesReviewDAO();
		
		MesReviewService rvsv = new MesReviewService();

		List list = rvsv.getReview();
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/WEB-INF/mes/mes_bookflix/mes_review.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
