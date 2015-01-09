<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
<h2>Monituj Paczkę</h2>
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
				<th></th>
				
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
							<c:out value=""></c:out>
					    </td>
					    <td><c:out value="${var.deliveryAddress.street} ${var.deliveryAddress.local} ${var.deliveryAddress.zipCode} ${var.deliveryAddress.city}"></c:out></td>
					       <td>
							<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value=""></c:out>
							</td>
						<td><c:out value="${var.description}"></c:out></td>
							<td>
								<form action="/transporter-server/customer/bundleMonit/" method="get">
						<input type="number" value="${var.id}"  id="idbundle"/>
				    	<input class="btn btn-primary" class="form-control" type="submit" value="Monitoruj">
					</form>
							
				</tr>
				
			</c:forEach>
		
			<!-- PRZYKŁĄD
				<tr>
				<td> 1. </td>
				<td> 0001 </td>
				<td> 13.04.2015 </td>
				<td> adres ssss </td>
				<td> 14.04.2015 </td>
				<td> adres odbiorurrrrvbvsvsdvdsvsd </td>
				<td> 17.04.2015 </td>
				<td> Opis dskfkldsmf dsklfmdklsf kldsmfkmdslkf ksjdfklsd </td>
				<td> <a href="/transporter-server/customer/bundleMonit/" ><button class="btn btn-primary" >Monitoruj</button></a> </td>
				
				</tr>  -->
			
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
</trans:template>