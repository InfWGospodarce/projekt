<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Historie zlecen</h2>
		<form action="/transporter-server/customer/customerHistoryaAdd" method="get">
			<input type="hidden" value="${page}" name="page">
		    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
		</form>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>Klucz wyszukiwania</th>
				<th>Nazwa</th>
				<th>Prefiks</th>
				<th>Aktywny</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="pre" items="${prefixList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr>
					<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td><c:out value="${pre.searchKey}"></c:out></td>
					<td><c:out value="${pre.name}"></c:out></td>
					<td><c:out value="${pre.prefix}"></c:out></td>
					<td>
						<input type="checkbox" disabled="disabled" 
							<c:if test="${pre.active eq 'true'}">
								checked="checked"
							</c:if>
						/>
					</td>
					<td>
						<form action="/transporter-server/admin/streetPrefixEdit" method="get">
							<input type="hidden" value="${page}" name="page">
							<input type="hidden" value="${pre.id}" name="id">
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