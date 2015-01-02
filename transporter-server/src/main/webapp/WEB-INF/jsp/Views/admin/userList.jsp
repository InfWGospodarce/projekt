<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h3>Lista użytkowników</h3></td>
				<td><form action="/transporter-server/admin/userEdit" method="get">
					<input type="hidden" value="${page}" name="page">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz pracownika">
				</form></td>
				<td><form action="/transporter-server/admin/userEdit" method="get">
					<input type="hidden" value="${page}" name="page">
					<input type="hidden" value="1" name="customer">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz klienta">
				</form></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Klucz wyszukiwania</th>
				<th>Nazwa użytkownika</th>
				<th>Imię</th>
				<th>Nazwisko</th>
				<th>Stanowisko</th>
				<th>Aktywny</th>
				<th>Role</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.key.searchKey}"></c:out></td>
					<td><c:out value="${var.key.username}"></c:out></td>
					<c:if test="${not empty var.key.customer}">
						<td><c:out value="${var.key.customer.name}"></c:out></td>
						<td><c:out value="${var.key.customer.surname}"></c:out></td>
						<td>Klient</td>
					</c:if>
					<c:if test="${not empty var.key.employee}">
						<td><c:out value="${var.key.employee.name}"></c:out></td>
						<td><c:out value="${var.key.employee.surname}"></c:out></td>
						<td><c:out value="${var.key.employee.employeeType.name}"></c:out></td>
					</c:if>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.key.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td>
						<c:forEach var="role" items="${var.key.role}">
							<c:out value="${role.name}"></c:out>
						</c:forEach>
					</td>
					<td>
						<form action="/transporter-server/admin/userEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${var.key.id}" name="id">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
						</form>
					</td>
					<c:if test="${var.value eq 'true'}">
						<td>
							<form action="/transporter-server/admin/userDisconnect" method="get">
								<input type="hidden" value="${page}" name="page">
								<input type="hidden" value="${var.key.id}" name="id">
							    <input class="btn btn-primary" class="form-control" type="submit" value="Rozłącz">
							</form>
						</td>	
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
</trans:template>