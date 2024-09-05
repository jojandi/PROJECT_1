<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/inven/inven.css" rel="stylesheet">
<style>
	 #i2 .material-symbols-outlined { background-color: rgb(165, 224, 144); }
</style>
<head>
<meta charset="UTF-8">
<title>도서 재고 관리</title>
</head>
<body>
	<%@ include file="/WEB-INF/admin/base/a.header.jsp"%>
	<div id="wrap">

		<%@ include file="/WEB-INF/admin/inven/inventory_side.jsp"%>
		<section>
			<div class="main_page" id="main_page_1">
				<h3>도서 예약 관리</h3>
				<div>

						<div class="page">
							<table>
								<colgroup>
	                                <col width="5%">
	                                <col width="5%">
	                                <col width="5%">
	                                <col width="28%">
	                                <col width="10%">
	                                <col width="7%">
	                                <col width="12%">
	                                <col width="10%">
	                            </colgroup>
								<thead>
									<tr>
										<th>회원번호</th>
										<th>예약번호</th>
										<th>도서코드</th>
										<th>도서명</th>
										<th>예약일자</th>
										<th>픽업일자</th>
										<th>현황</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${list}">
										<tr>
											<td>${list.user_seq}</td>
											<td>${list.res_id}</td>
											<td>${list.book_code}</td>
											<td>${list.book_name}</td>
											<td>${list.res_day}</td>
											<td>
												<c:if test="${list.res_ing == false}">
				                            		${list.res_pick}
				                            	</c:if>
				                            	<c:if test="${list.res_ing == true}">
				                            		-
				                            	</c:if>
											</td>
											<td>
												<c:if test="${list.res_ing == true}">
													<select name="loan_ing" class="select">
														<option value="Y">픽업완료</option>
														<option value="N" selected>대기중</option>
													</select> 
												</c:if>
												<c:if test="${list.res_ing == false}">
													픽업완료
												</c:if>
											</td>
											<td>
												<c:if test="${list.res_pick == null}">
													<input type="hidden" value=${list.book_code} class="code">
													<input type="hidden" value=${list.user_seq} class="user">
													<input type="hidden" value=${list.res_id} class="seq">
													<input type="submit" value="수정" class="submit">
												</c:if>
												<c:if test="${list.res_pick != null}">
													-
												</c:if>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
				</div>
			</div>
		</section>
	</div>
	<script src="../assets/js/inven/res_post.js"></script>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
