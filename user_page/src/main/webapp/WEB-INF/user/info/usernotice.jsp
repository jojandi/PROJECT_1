<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="user.dto.noti.NotiDTO"%>
<%@ page import="user.dao.noti.NotiDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 사용자용</title>
<link href="../assets/css/info/user_notice.css" rel="stylesheet">
<link href="../assets/js/notice/user_notice.js" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<%@ include file="/WEB-INF/user/base/header.jsp"%>

	<div id="wrap">

		<!-- aside -->
		<%@ include file="/WEB-INF/user/info/user_info_side.jsp"%>

		<div id="section">
			<div class="name">
				<strong>공지사항</strong>
			</div>

			<%
			// DAO를 사용하여 공지사항 데이터를 가져옴
			NotiDAO notiDAO = new NotiDAO();
			List<NotiDTO> notiList = notiDAO.getAllNotiRequests();
			%>


			<div id="table">
				<table class="report" id="reportTable">
					<tr>
						<th>분류</th>
						<th>제목</th>
						<th>등록일</th>
						<th>내용</th>
						<th>조회</th>
					</tr>

					<%
					if (notiList != null && !notiList.isEmpty()) {
						for (NotiDTO noti : notiList) {
					%>
					<tr>
						<td><%=noti.getClass_name()%></td>
						<td class="retitle"><a
							href="http://localhost:8080/admin_page/admin/notice3?ann_seq=<%=noti.getAnn_Seq()%>">
								<%=noti.getAnn_Title()%>
						</a></td>


						<%-- <td class="retitle"><%=noti.getAnn_Title()%></td> --%>
						<td><a
							href="http://localhost:8080/admin_page/admin/notice3?ann_seq=<%=noti.getAnn_Seq()%>">
								<%=noti.getAnn_Regi()%>
						</a></td>
						<!--<tdnoti.getAnn_Regi()i() %></td>  -->
						<td><%=noti.getAnn_Detail()%></td>
						<!-- 공지사항 내용 출력 -->
						<td><%=noti.getAnn_Check()%></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="5">공지사항이 없습니다.</td>
					</tr>
					<%
					}
					%>

				</table>
			</div>

			<!-- 페이지 이동 -->
			<div id="movepage">
				<span class="material-symbols-outlined">chevron_left</span> <span
					class="chap">1</span> <span class="chap">2</span> <span
					class="chap">3</span> <span class="chap">4</span> <span
					class="material-symbols-outlined">chevron_right</span>
			</div>

			<form id="search" method="get" action="comment">
				<div id="search">
					<select name="">
						<option value="전체기간">전체기간</option>
					</select> <select name="">
						<option value="게시물+댓글">게시물 + 댓글</option>
					</select> <input type="search" id="searchInput" name="keyword"
						placeholder="검색어를 입력해주세요"> <input type="button" value="검색"
						class="search" onclick="filterTable()">
				</div>
			</form>

		</div>

	</div>

	<script src="../assets/js/info/user_notice.js"></script>
	<!-- footer -->
	<%@ include file="/WEB-INF/user/base/footer.jsp"%>

</body>
</html>