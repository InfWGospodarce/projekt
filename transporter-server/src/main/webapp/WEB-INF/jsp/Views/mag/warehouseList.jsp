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
				<td><h2>Lista magazynów</h2></td>
				<td><form action="/transporter-server/mag/warehouseEdit" method="get">
				    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
				</form></td>
			</tr>
		</table>

		<table class="table">
		
			<tr>
				<th>Lp.</th>
				<th>Id</th>
				<th>Klucz</th>
				<th>KOD</th>
				<th>Nazwa</th>
			</tr>
			
			<c:set var="i" value="0"></c:set>
			<c:forEach var="object" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr id="${object.id}">
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${object.id}"></c:out></td>
					<td><c:out value="${object.searchKey}"></c:out></td>
					<td><c:out value="${object.code}"></c:out></td>
					<td><c:out value="${object.name}"></c:out></td>
					<td>
						<input class="btn btn-primary" class="form-control" type="button" value="Adres" onclick="showAddres(object.id)">
					</td>
					<td>
						<form action="/transporter-server/mag/warehouseEdit?id=${object.id}" method="get">
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
<script>
	function showAddres(id){
		var element = $(document.getElementById(id));
		if($(element).is(":visible")){
			$(element).hide();
		} else {
			$(element).show();
		}
	}
</script>
</trans:template>