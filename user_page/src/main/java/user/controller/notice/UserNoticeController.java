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
	private static final int PAGE_SIZE = 5; // 한 페이지에 표시할 공지사항 수

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("공지사항 사용자용 doGet 실행!");
		response.setContentType("text/html;charset=utf-8;");

		// 현재 페이지 번호
		int currentPage = 1; // 기본 페이지 번호
		String pageStr = request.getParameter("page");
		if (pageStr != null && !pageStr.isEmpty()) {
			try {
				currentPage = Integer.parseInt(pageStr);
			} catch (NumberFormatException e) {
				currentPage = 1; // 페이지 번호가 잘못된 경우 기본 페이지로 설정
			}
		}

		// DAO 사용
		NotiDAO notiDAO = new NotiDAO();
		int totalNotiCount = notiDAO.getTotalNotiCount();
		int totalPages = (int) Math.ceil((double) totalNotiCount / PAGE_SIZE);

		// 공지사항 가져오기
		List<NotiDTO> notiList = notiDAO.getNotiByPage(currentPage, PAGE_SIZE);

		// 페이지 링크 계산
		int displayPageCount = 5; // 표시할 페이지 수
		int startPage, endPage;

		if (totalPages <= displayPageCount) {
			// 전체 페이지 수가 표시할 페이지 수보다 작거나 같은 경우
			startPage = 1;
			endPage = totalPages;
		} else {
			// 현재 페이지를 기준으로 앞뒤 페이지 계산
			startPage = Math.max(1, currentPage - 2);
			endPage = Math.min(totalPages, currentPage + 2);

			// 페이지 범위를 5개로 맞추기
			if (endPage - startPage + 1 < displayPageCount) {
				if (startPage == 1) {
					endPage = Math.min(displayPageCount, totalPages);
				} else if (endPage == totalPages) {
					startPage = Math.max(totalPages - displayPageCount + 1, 1);
				}
			}
		}

		// Request 속성 설정
		request.setAttribute("notiList", notiList);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		// JSP로 포워딩
		request.getRequestDispatcher("/WEB-INF/user/info/usernotice.jsp")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
}
