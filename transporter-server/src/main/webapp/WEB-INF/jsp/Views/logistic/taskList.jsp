<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Lista zadań</h2>
		<form action="/transporter-server/logistic/taskListEdit" method="get">
			<input type="hidden" value="${page}" name="page">
		    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowe zadanie">
		</form>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Employee_id</th>
				<th>Vehicle_id</th>
				<th>Nazwa</th>
				<th>Data</th>
				<th>Czas trwania</th>
				<th>Aktywny</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${taskList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.employee.id}"></c:out></td>
					<td><c:out value="${var.vehicle.id}"></c:out></td>
					<td><c:out value="${var.name}"></c:out></td>
					<td><c:out value="${var.date}"></c:out></td>
					<td><c:out value="${var.duration}"></c:out></td>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td>
						<form action="/transporter-server/logistic/taskListEdit" method="get">
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