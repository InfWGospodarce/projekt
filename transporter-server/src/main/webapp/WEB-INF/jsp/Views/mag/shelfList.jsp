<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h2>Lista polek</h2></td>
				<td><form action="/transporter-server/mag/shelfEdit" method="get">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
				</form></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
		<table class="table">
		
			<tr>
				<th>Lp.</th>
				<th>Id</th>
				<th>Klucz</th>
				<th>Nazwa</th>
				<th>kod</th>
				<th>Magazyn</th>
			</tr>
			
			<c:set var="i" value="0"></c:set>
			<c:forEach var="object" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${object.id}"></c:out></td>
					<td><c:out value="${object.searchKey}"></c:out></td>
					<td><c:out value="${object.name}"></c:out></td>
					<td><c:out value="${object.code}"></c:out></td>
					<td><c:out value="${object.warehouse.name}"></c:out></td>
					<td>
						<form action="/transporter-server/mag/shelfEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${object.id}" name="id">
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