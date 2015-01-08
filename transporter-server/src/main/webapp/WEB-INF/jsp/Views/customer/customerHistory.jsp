<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h3>Historia Zleceń</h3></td>
				<td>
				<a href="/transporter-server/customer/customerHistoryEdit">
				<button class="btn btn-primary" >Utwórz Zlecenie</button>
				</a>
			</td>
			
			</tr>
		</table>
	
		<table class="table">
			<tr>
				<th>Lp.</th>	
				<th>ID.</th>			
				<th>Data Dodania</th>
				<th>Adres Odbioru</th>
				<th>Data Odbioru</th>
				<th>Adres Docelowy</th>
				<th>Data Dostarczenia</th>
				<th>Opis</th>
				
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
						    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj"
						    	<c:if test="${object.filled eq 'true'}">
									disabled="disabled"
								</c:if>
						    >
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