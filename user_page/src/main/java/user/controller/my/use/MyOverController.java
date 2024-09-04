package user.controller.my.use;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.service.my.loan.LoanService;


@WebServlet("/user/over")
public class MyOverController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자용 마이페이지 이용내역 연체 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String countPerPage = request.getParameter("countPerPage"); // 한 페이지 당 몇 개
		String page = request.getParameter("page"); // 현재 페이지
		
		// 기본값 설정
		if(countPerPage == null) countPerPage = "7";
		if(page == null) page = "1";
	    
	    int seq = Integer.parseInt(request.getParameter("seq"));
	    
	    LoanService service = new LoanService();
	    Map map = service.myOver(seq, countPerPage, page);
	    
	    request.setAttribute("map", map);
	    request.setAttribute("countPerPage", countPerPage);
	    request.setAttribute("page", page);
	    
		request.getRequestDispatcher("/WEB-INF/user/my/user_mypage_use3.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
