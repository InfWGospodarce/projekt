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
	<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
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
					<td><c:out value="${var.id}"></c:out></td>
							<td>
							<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value="${dateString}"></c:out></td>
						
				
			<td><c:out value="${var.targetAddress.street} ${var.targetAddress.local} ${var.targetAddress.zipCode} ${var.targetAddress.city}"></c:out></td>
					   <td>
							<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value="${dateString}"></c:out>
					    </td>
					    <td><c:out value="${var.targetAddress.street} ${var.targetAddress.local} ${var.targetAddress.zipCode} ${var.targetAddress.city}"></c:out></td>
					       <td>
							<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value="${dateString}"></c:out></td>
					
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
</trans:template>