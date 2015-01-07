<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<c:if test="${empty param.select}">
	<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
</c:if>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h2>Lista artykułów</h2></td>
				<c:if test="${empty param.select}">
					<td><form action="/transporter-server/mag/articleEdit" method="get">
					    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
					</form></td>
				</c:if>
			</tr>
		</table>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>ID</th>
				<th>Klucz</th>
				<th>Kod</th>
				<th>Nazwa</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="object" items="${articleList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td class="js_option" data-value="${article.id}"><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td class="js_option" data-value="${article.id}"><c:out value="${article.id}"></c:out></td>
					<td class="js_option" data-value="${article.id}"><c:out value="${article.searchKey}"></c:out></td>
					<td class="js_option" data-value="${article.id}"><c:out value="${article.code}"></c:out></td>
					<td> class="js_option" data-value="${article.id}"<c:out value="${article.name}"></c:out></td>
					<td>
						<c:if test="${empty param.select}">
							<form action="/transporter-server/mag/articleEdit" method="get">
								<input type="hidden" value="${page}" name="page">
								<input type="hidden" value="${article.id}" name="id">
							    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
							</form>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
		</div>
	</div>
</div>
</trans:template>