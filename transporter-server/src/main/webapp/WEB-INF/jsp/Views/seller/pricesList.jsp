<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h2>Lista cen artykułów</h2>
				<td><form action="/transporter-server/seller/pricesEdit" method="get">
					<input type="hidden" value="${page}" name="page">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
				</form></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Klucz wyszukiwania</th>
				<th>Artykuł</th>
				<th>Data</th>
				<th>Cena</th>
				<th>Aktywny</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.searchKey}"></c:out></td>
					<td><c:out value="${var.article}"></c:out></td>
					<td><c:out value="${var.date}"></c:out></td>
					<td><c:out value="${var.price}"></c:out></td>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td>
						<form action="/transporter-server/seller/pricesEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${var.id}" name="id">
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