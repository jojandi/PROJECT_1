<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<link href="../assets/css/inven/inven.css" rel="stylesheet">
<style>
	 #i3 .material-symbols-outlined { background-color: rgb(165, 224, 144); }
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
				<h3>도서 대출 관리</h3>
				<div>
						<div class="page">
							<table>
								<colgroup>
	                                <col width="5%">
	                                <col width="5%">
	                                <col width="28%">
	                                <col width="10%">
	                                <col width="7%">
	                                <col width="12%">
	                                <col width="10%">
	                                <col width="8%">
	                            </colgroup>
								<thead>
									<tr>
										<th>회원번호</th>
										<th>도서코드</th>
										<th>도서명</th>
										<th>대출일자</th>
										<th>대출현황</th>
										<th>반납예정일</th>
										<th>반납일</th>
										<th></th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="list" items="${list}">
										<tr>
											<td>${list.user_seq}</td>
											<td>${list.book_code}</td>
											<td>${list.book_name}</td>
											<td>${list.loan_date}</td>
											<td>
												<c:if test="${list.loan_ing == true}">
													<select name="loan_ing" class="select">
														<option value="Y" selected>대출중</option>
														<option value="N">반납완료</option>
													</select>
												</c:if>
												<c:if test="${list.loan_ing == false}">
													반납완료
												</c:if>
											</td>
											<td>${list.loan_ex}</td>
											<td>
												<c:if test="${list.loan_return == null}">
				                            		-
				                            	</c:if>
				                            	<c:if test="${list.loan_return != null}">
				                            		${list.loan_return}
				                            	</c:if> 
											</td>
											<td>
												<c:if test="${list.loan_ing == true}">
													<input type="hidden" value=${list.book_code} class="code">
													<input type="hidden" value=${list.loan_seq} class="seq">
													<input type="submit" value="수정" class="submit">
												</c:if>
												<c:if test="${list.loan_ing == false}">
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
	<script src="../assets/js/inven/loan_post.js"></script>
	<%@ include file="/WEB-INF/admin/base/a.footer.jsp"%>
</body>
</html>
