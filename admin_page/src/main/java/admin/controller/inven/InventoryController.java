package admin.controller.inven;

import java.io.IOException;
import java.util.List;

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
	    
	    String text = request.getParameter("text");
	    System.out.println("search : " + text);
	    
	    InvenService service = new InvenService();
	    
	    List bookList = service.bookList(text);
	    
	    System.out.println(bookList);
	    
	    request.setAttribute("list", bookList); 
		
		request.getRequestDispatcher("/WEB-INF/admin/inven/inventory.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 doPost 실행!");
	}
}
