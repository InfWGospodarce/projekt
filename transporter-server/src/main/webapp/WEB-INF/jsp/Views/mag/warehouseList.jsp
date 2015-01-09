<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<c:if test="${empty param.select}">
	<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
</c:if>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<table class="table">
			<tr>
				<td><h2>Lista magazynów</h2></td>
				<c:if test="${empty param.select}">
					<td><form action="/transporter-server/mag/warehouseEdit" method="get">
					    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
					</form></td>
				</c:if>
			</tr>
		</table>
		<c:set scope="request" var="modalId" value="modal"></c:set>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
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
					<td class="js_option" data-value="${object.id}"><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td class="js_option" data-value="${object.id}"><c:out value="${object.id}"></c:out></td>
					<td class="js_option" data-value="${object.id}"><c:out value="${object.searchKey}"></c:out></td>
					<td class="js_option" data-value="${object.id}"><c:out value="${object.name}"></c:out></td>
					<td>
						<input class="btn btn-primary" class="form-control" type="button" value="Adres" onclick="showAddres(${object.id})">
					</td>
					<td>
						<c:if test="${empty param.select}">
							<form action="/transporter-server/mag/warehouseEdit" method="get">
								<input type="hidden" value="${page}" name="page">
								<input type="hidden" value="${object.id}" name="id">
							    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
							</form>
						</c:if>
					</td>
				</tr>
				<tr class="addresLine" id="${object.id}" class="">
					<td></td>
					<td colspan="4">
						<table class="table">
							<tr>
								<th>Adres</th>
							</tr>
							<tr>
								<td>
									<c:set var="addressPrefix" scope="request" value="${object.address}"/>
									<%@ include file="../base/address2.jsp" %>
								</td>
							</tr>
						</table>
					<td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
		</div>
	</div>
</div>
<script src="${pageContext.request.contextPath}/resources/javascript/addressHiddable.js"></script>
</trans:template>