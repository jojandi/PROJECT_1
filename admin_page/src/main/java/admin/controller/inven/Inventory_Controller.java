package admin.controller.inven;

import java.io.IOException;
import java.util.List;

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
		InvenService service = new InvenService();
	    
	    List bookList = service.bookList();
	    
		long isbn = Long.parseLong(request.getParameter("isbn"));
		System.out.println("isbn : " + isbn);
		InvenDTO dtoList = service.bookCount(isbn);
	    
	    request.setAttribute("dto", dtoList); 
	    request.setAttribute("list", bookList); 
		request.getRequestDispatcher("/WEB-INF/admin/inven/inventory_.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("실시간 재고 doPost 실행!");	
	}

}
