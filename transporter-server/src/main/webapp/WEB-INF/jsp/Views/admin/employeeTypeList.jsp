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
							<table>
								<c:forEach var="var" items="${employeeList}">
								<tr>
									<td><c:out value="${var.searchKey}"></c:out></td>
									<td><c:out value="${var.name}"></c:out></td>
									<td><c:out value="${var.active}"></c:out></td>
									<td>
										<form action="/transporter-server/admin/streetPrefixEdit?id=${pre.id}">
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