<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h3>Lista zleceń</h3></td>
				<td><form action="/transporter-server/seller/requestEdit" method="get">
					<input type="hidden" value="${page}" name="page">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz zlecenie">
				</form></td>
			</tr>
		</table>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleDocumentSearch.jsp" %>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Użytkownik</th>
				<th>Data utworzenia</th>
				<th>Zaksięgowny</th>
				<th>Data księgowania</th>
				<th>Netto</th>
				<th>Brutto</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${var.customer.name} ${var.customer.surname}"></c:out></td>
					<td><c:out value="${var.createDate}"></c:out></td>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${var.filled eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td><c:out value="${var.fillingDate}"></c:out></td>
					<td><c:out value="${var.noTaxableAmount}"></c:out></td>
					<td><c:out value="${var.noTaxableAmount}"></c:out></td>
					<td><c:out value="${var.noTaxableAmount+var.taxAmount}+"></c:out></td>
					<td>
						<form action="/transporter-server/seller/requestEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${var.id}" name="id">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj"
						    	<c:if test="${object.filled eq 'true'}">
									disabled="disabled"
								</c:if>
						    >
						</form>
					</td>
					<td>
						<form action="/transporter-server/admin/salesOrderNew" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${var.id}" name="id">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Zamówienie"
						    	<c:if test="${object.filled eq 'true'}">
									disabled="disabled"
								</c:if>
						    >
						</form>
					</td>
				</tr>
				<tr class="rowsLine" id="${var.id}" >
					<td></td>
					<td colspan="8">
						<table class="table">
							<tr>
								<th>Lp.</th>
								<th>Artykuł</th>
								<th>Data utworzenia</th>
								<th>Zaksięgowny</th>
								<th>Data księgowania</th>
								<th>Netto</th>
								<th>Brutto</th>
							</tr>
							<c:set var="j" value="0"></c:set>
							<c:forEach var="row" items="${var.rows}">
								<c:set var="j" value="${j+1}"></c:set>
								<tr>
									<td><c:out value="${j}"></c:out></td>
									<td><c:out value="${row.ware.name}"></c:out></td>
								</tr>
							</c:forEach>
						</table>
					<td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
<script>
	$( document ).ready(function() {
		$( ".rowsLine" ).hide();
	});

	function showRows(id){
		var element = $(document.getElementById(id));
		if($(element).is(":visible")){
			$(element).hide();
		} else {
			$(element).show();
		};
	};
</script>
</trans:template>