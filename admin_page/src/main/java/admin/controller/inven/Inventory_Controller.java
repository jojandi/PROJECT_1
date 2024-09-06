package admin.controller.inven;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DTO.inven.InvenDTO;
import admin.service.inven.InvenService;


@WebServlet("/admin/inventory_")
public class Inventory_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 상세 doGet 실행!");
		
		String countPerPage = request.getParameter("countPerPage"); // 한 페이지 당 몇 개
		String page = request.getParameter("page"); // 현재 페이지
	    String text = request.getParameter("text");
	    System.out.println("search : " + text);
		
		// 기본값 설정
		if(countPerPage == null) countPerPage = "7";
		if(page == null) page = "1";
		
		InvenService service = new InvenService();
	    
	    Map bookList = service.bookList(text, countPerPage, page);
	    
		long isbn = Long.parseLong(request.getParameter("isbn"));
		System.out.println("isbn : " + isbn);
		InvenDTO dtoList = service.bookCount(isbn);
	    
	    request.setAttribute("dto", dtoList); 
	    request.setAttribute("map", bookList);
	    request.setAttribute("countPerPage", countPerPage);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/admin/inven/inventory_.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 doPost 실행!");	
	}

}
