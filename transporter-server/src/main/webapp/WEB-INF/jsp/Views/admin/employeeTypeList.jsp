<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<div class="view">
		<c:choose>
			<c:when test="${empty userctx}">
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
				<table>
					<tr>
						<td><h2>Lista stanowisk pracowniczych</h2></td>
						<td>
							<form action="/transporter-server/admin/employeeTypeListEdit}">
							    <input type="submit" value="Utwórz nowy">
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<table class="listView">
								<tr>
									<th>Lp.</th>
									<th>Klucz wyszukiwania</th>
									<th>Nazwa</th>
									<th>Aktywny</th>
								</tr>
								<c:set var="i" value="0"></c:set>
								<c:forEach var="var" items="${employeeList}">
									<c:set var="i" value="${i+1}"></c:set>
									<tr>
										<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
										<td><c:out value="${var.searchKey}"></c:out></td>
										<td><c:out value="${var.name}"></c:out></td>
										<td><c:out value="${var.active}"></c:out></td>
										<td>
											<form action="/transporter-server/admin/streetPrefixEdit">
												<input type="hidden" value="${pre.id}" name="id">
											    <input type="submit" value="Edytuj">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
						</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</trans:template>