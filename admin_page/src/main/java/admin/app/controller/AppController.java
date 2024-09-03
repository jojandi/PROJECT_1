package admin.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.DAO.app.AppDAO;
import admin.DTO.app.AppDTO;


@WebServlet("/admin/app")
public class AppController extends HttpServlet {
	private List<AppDTO> applications = new ArrayList();
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 doGet 실행!");
		request. setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	     AppDAO apps = new AppDAO();
//	      도서 신청 목록을 JSP에 전달
        request.setAttribute("books","app");
	    
	    
		request.getRequestDispatcher("/WEB-INF/admin/application/app.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 dopost 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
	    
	    // 구매 요청 처리
	    String action = request.getParameter("action");
        if ("purchase".equals(action)) {
            int ann_seq = Integer.parseInt(request.getParameter("ann_seq"));
            processPurchase(ann_seq);
        }
        

    

	    
	    request.getRequestDispatcher("/WEB-INF/admin/application/app.jsp").forward(request, response);
	   
    }

	private void processPurchase(int ann_seq) {
		
	}
}


  
	    	
	    	
	    
	    
	
