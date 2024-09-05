package admin.app.controller;

import java.io.IOException;
import java.sql.Date;
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

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 doGet 실행!");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 도서신청을 목록으로 가져왁서 jsp에 전달하기
		AppDAO appDAO = new AppDAO();
		List<AppDTO> list = appDAO.getAllBookRequests();
		
		request.setAttribute("appl", list);
		System.out.println("list "+ list);
		// jsp 페이지로 포워딩
		request.getRequestDispatcher("/WEB-INF/admin/application/app.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("도서신청 dopost 실행!");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		// 폼에서 넘어론 데이터 처리
		String appSeq = (request.getParameter("app_seq"));
		String appBook = request.getParameter("app_book");
		String appName = request.getParameter("app_name");
		String appPub = request.getParameter("app_pub");
//		String appDate = request.getParameter("app_date");
		String userSeq = request.getParameter("user_seq");
//		String purchased = request.getParameter("purchased");
		String app_status = request.getParameter("app_status");
		
		String purchased = "구매 완료"; 

		// DTO 객체에 데이터 세팅
		AppDTO appDTO = new AppDTO();
		appDTO.setApp_seq(Integer.parseInt(appSeq));
		appDTO.setApp_book(appBook);
		appDTO.setApp_name(appName);
		appDTO.setApp_pub(appPub);
//		appDTO.setApp_date(Date.valueOf(appDate));
		appDTO.setUser_seq(userSeq);
		appDTO.setPurchased(purchased);
		appDTO.setApp_status(app_status);
		
		

		// DAO를 통해 데이터베이스에 삽입
		AppDAO appDAO = new AppDAO();  // AppDAO 클래스의 인스턴스 생성
		int result = appDAO.update(appDTO);  // 인스턴스를 통해 메서드 호출

	    // 업데이트 결과 확인
	    if (result > 0) {
	        System.out.println("업데이트 성공!");
	    } else {
	        System.out.println("업데이트 실패!");
	    }
			response.sendRedirect(request.getContextPath() + "/admin/app");

//			request.getRequestDispatcher("/WEB-INF/admin/application/app.jsp")
//					.forward(request, response);
	}
}
