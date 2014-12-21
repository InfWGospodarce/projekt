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
						<td><h2>Lista prefiksów ulic</h2></td>
						<td>
							<form action="/transporter-server/admin/streetPrefixEdit" method="get">
							    <input type="submit" value="Utwórz nowy">
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
									<th>Klucz wyszukiwania</th>
									<th>Nazwa</th>
									<th>Aktywny</th>
								</tr>
								<c:forEach var="pre" items="${prefixList}">
									<tr>
										<td><c:out value="${pre.searchKey}"></c:out></td>
										<td><c:out value="${pre.name}"></c:out></td>
										<td><c:out value="${pre.active}"></c:out></td>
										<td>
											<form action="/transporter-server/admin/streetPrefixEdit?id=${pre.id}" method="get">
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