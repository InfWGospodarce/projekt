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
				<th>Nazwa</th>
			</tr>
			
			<c:set var="i" value="0"></c:set>
			<c:forEach var="object" items="${list}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${object.id}"></c:out></td>
					<td><c:out value="${object.searchKey}"></c:out></td>
					<td><c:out value="${object.name}"></c:out></td>
					<td>
						<input class="btn btn-primary" class="form-control" type="button" value="Adres" onclick="showAddres(${object.id})">
					</td>
					<td>
						<form action="/transporter-server/mag/warehouseEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${object.id}" name="id">
						    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
						</form>
					</td>
				</tr>
				<tr class="addresLine" id="${object.id}" style="{width:100%}">
				<td>
					<c:set var="addressPrefix" scope="request" value="${object.address}"/>
					<h3>Adres</h3>
					<%@ include file="../base/address2.jsp" %>
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
		$( ".addresLine" ).hide();
	});

	function showAddres(id){
		var element = $(document.getElementById(id));
		if($(element).is(":visible")){
			$(element).hide();
		} else {
			$(element).show();
		};
	};
</script>
</trans:template>