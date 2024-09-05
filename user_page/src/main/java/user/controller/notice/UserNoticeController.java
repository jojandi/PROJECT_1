package user.controller.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.noti.NotiDAO;
import user.dto.noti.NotiDTO;


@WebServlet("/user/notice")
public class UserNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항 사용자용 doGet 실행!");
		response.setContentType("text/html;charset=utf-8;");
		
		NotiDAO notiDAO = new NotiDAO();
        List<NotiDTO> notiList = notiDAO.getAllNotiRequests();
        
        request.setAttribute("notiList", notiList);
		
		request.getRequestDispatcher("/WEB-INF/user/info/usernotice.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
