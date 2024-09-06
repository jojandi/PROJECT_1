package mes_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mes_DAO.MesWorkorderDAO;
import mes_DTO.MesWorkorderDTO;
import mes_service.MesWorkorderService;

@WebServlet("/update")
public class MesWorkOrderBomUpdate extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("utf-8");
	        response.setContentType("text/html; charset=utf-8");

	        String[] selectedBookCodes = request.getParameterValues("selectedBooks");

	        if (selectedBookCodes != null) {
	            MesWorkorderDAO bookDAO = new MesWorkorderDAO();
	            List<MesWorkorderDTO> books = new ArrayList<>();

	            for (String code : selectedBookCodes) {
	            	MesWorkorderDTO book = bookDAO.selectBookByCode(Integer.parseInt(code));
	                books.add(book);
	            }

	            request.setAttribute("books", books);
	            request.getRequestDispatcher("/WEB-INF/mes/mes_workorder/updateBooks.jsp").forward(request, response);
	        } else {
	            response.sendRedirect("bom_read.jsp");
	        }
	    }
}
