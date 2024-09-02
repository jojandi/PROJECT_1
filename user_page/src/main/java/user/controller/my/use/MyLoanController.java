package user.controller.my.use;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.loan.LoanService;


@WebServlet("/user/loan")
public class MyLoanController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 마이페이지 이용내역 대출 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
	    LoanService service = new LoanService();
	    List list = new ArrayList();
	    list = service.myLoan(seq);
	    
	    request.setAttribute("list", list);
	    
		request.getRequestDispatcher("/WEB-INF/user/my/user_mypage_use2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
