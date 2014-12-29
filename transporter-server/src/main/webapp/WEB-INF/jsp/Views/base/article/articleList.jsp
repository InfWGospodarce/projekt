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
					
						<h1 class="Lista">Lista artykułów</h1>
						<td>
							<form action="/transporter-server/mag/articleEdit" method="get">
							    <input type="submit" value="Utwórz nowy">
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<table>
								<tr>
								
									<th class="copyrights">Klucz</th>
									<th class="copyrights">KOD</th>
									<th class="copyrights">Nazwa</th>
								
								</tr>
								<c:forEach var="article" items="${articleList}">
									<tr>
										<td><c:out value="${article.searchKey}"></c:out></td>
										<td><c:out value="${article.code}"></c:out></td>
										<td><c:out value="${article.name}"></c:out></td>
										<td>
											<form action="/transporter-server/mag/articleEdit?id=${article.id}" method="get">
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
					
			</c:otherwise>
		</c:choose>
		</div>
		
</trans:template>