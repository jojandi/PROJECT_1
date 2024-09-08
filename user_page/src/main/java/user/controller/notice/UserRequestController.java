package user.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.request.RequestDAO;
import user.dto.app.AppDTO;



@WebServlet("/user/request")
public class UserRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 사용자용 doGet 실행!");
		request.setCharacterEncoding("utf-8");
	    response.setContentType("text/html; charset=utf-8;");
		
		request.getRequestDispatcher("/WEB-INF/user/info/userrequest.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("도서신청 사용자용 doPost 실행!");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        // 폼에서 제출된 데이터 가져오기
        String bookName = request.getParameter("app_book"); //도서명
        String author = request.getParameter("app_name");  //저자 
        String publisher = request.getParameter("app_pub"); // 출판사
        String user_seq = request.getParameter("user_seq"); // 출판사
        
        System.out.println(Integer.parseInt(user_seq));
        
        AppDTO dto = new AppDTO();
        dto.setApp_book(bookName);
        dto.setApp_name(author);
        dto.setApp_pub(publisher); 
        dto.setUser_seq(user_seq); 
        
        RequestDAO dao = new RequestDAO();
        
        int result = dao.insertApp(dto);
        System.out.println("insert : " + result);
        
        request.getRequestDispatcher("/WEB-INF/user/info/userrequest.jsp").forward(request, response);
        
	}

}
