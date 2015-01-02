<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Lista artykułów</h2>
		<form action="/transporter-server/mag/articleEdit" method="get">
		    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
		</form>

		<table class="table">
			<tr>
				<th>Klucz</th>
				<th>KOD</th>
				<th>Nazwa</th>
			</tr>
			<c:forEach var="article" items="${articleList}">
				<tr>
					<td><c:out value="${article.searchKey}"></c:out></td>
					<td><c:out value="${article.code}"></c:out></td>
					<td><c:out value="${article.name}"></c:out></td>
					<td>
						<form action="/transporter-server/mag/articleEdit?id=${article.id}" method="get">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
		</div>
	</div>
</div>
</trans:template>