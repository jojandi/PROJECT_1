package admin.controller.inven;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.service.inven.InvenService;


@WebServlet("/admin/inventory")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    String countPerPage = request.getParameter("countPerPage"); // 한 페이지 당 몇 개
		String page = request.getParameter("page"); // 현재 페이지
//		System.out.println("현재 페이지 : " + page);
//		System.out.println("페이지 당 개수 : " + countPerPage);
		
		// 기본값 설정
		if(countPerPage == null) countPerPage = "7";
		if(page == null) page = "1";
	    
	    String text = request.getParameter("text");
	    System.out.println("search : " + text);
	    
	    InvenService service = new InvenService();
	    
	    Map bookList = service.bookList(text, countPerPage, page);
	    
	    System.out.println(bookList);
	    
	    request.setAttribute("map", bookList); 
	    request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		
		request.getRequestDispatcher("/WEB-INF/admin/inven/inventory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 doPost 실행!");
	}
}
