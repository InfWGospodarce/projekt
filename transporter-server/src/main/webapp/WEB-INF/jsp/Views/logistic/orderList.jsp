<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Lista zadań</h2>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Klucz wyszukiwania</th>
				<th>Customer</th>
				<th>Delivery address</th>
				<th>Aktywny</th>
				<th>Nazwa</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${orderList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.searchKey}"></c:out></td>
					<td><c:out value="${var.employee.id}"></c:out></td>
					<td><c:out value="${var.deliveryaddress.id}"></c:out></td>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td>
						<form action="/transporter-server/logistic/orderList" method="get">
							<input type="hidden" value="${var.id}" name="id">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Szczegóły">
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