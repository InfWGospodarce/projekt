<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Lista zamówień</h2>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Klucz wyszukiwania</th>
				<th>ID Klienta</th>
				<th>ID Adresu</th>
				<th>Nazwa</th>
				<th>Aktywny</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${orderList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.name}"></c:out></td>
					<td><c:out value="${var.searchKey}"></c:out></td>
					<td><c:out value="${var.customer.id}"></c:out></td>
					<td><c:out value="${var.deliveryAddress.id}"></c:out></td>
					
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
</trans:template>