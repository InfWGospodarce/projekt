<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	


	<table style="border: 1px solid black; width:99%" >
	<tr style="border: 1px solid black;">
	<th style="border: 0px solid black;">ID Paczki</th>
	<td style="border: 0px solid black;"><c:out value="${var.id}"></c:out></td>
	</tr>
	<tr>
	<th style="border: 1px solid black;" >Adres Nadawcy</th>
	<th style="border: 1px solid black;" >Adres Odbiorcy</th>
	</tr>
	<tr>
	<td style="border: 1px solid black;" ><c:out value="${var.deliveryAddress.street} ${var.deliveryAddress.local} ${var.deliveryAddress.zipCode} ${var.deliveryAddress.city}"></c:out></td>
	<td style="border: 1px solid black;" ><c:out value="${var.targetAddress.street} ${var.targetAddress.local} ${var.targetAddress.zipCode} ${var.targetAddress.city}"></c:out></td>
	</tr>
	</table>
	
		<table class="table">
			<tr>
				<th>Lp.</th>	
				<th>Nazwa punktu</th>			
				<th>Data/godzina Odbioru</th>
				<th>Data/godzina Wyjścia</th>				
				<th>Opis</th>
			</tr>
		<c:set var="i" value="0"></c:set>
			<c:forEach var="var" items="${list}">
				<tr>
				<td> <c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out> </td>
				<td> <c:out value="${var.name}"></c:out> </td>
				<td> 
<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value=""></c:out>
			 </td>
				<td> 
<fmt:formatDate value="${var.createDate}" var="dateString" pattern="dd-MM-yyyy" />
							<c:out value=""></c:out>
							 </td>
				<td> <c:out value="${var.description}"></c:out> </td>
				</tr>

		</c:forEach>
		<!-- PRZYKŁĄD
			<tr>
				<td> 1. </td>
				<td> Nadawca </td>
				<td> ----------- </td>
				<td> 13.04.2015 11:30 </td>
				<td> Opis wedsfsdf342 </td>
				</tr>
				
		<tr>
				<td> 2. </td>
				<td> Punkt 1 </td>
				<td> 14.04.2015 9:30 </td>
				<td> 14.04.2015 11:30 </td>
				<td> Opis werew42343r43 </td>
				</tr>
				
					<tr>
				<td> 3. </td>
				<td> Punkt 2 </td>
				<td> 15.04.2015 9:30 </td>
				<td> 16.04.2015 11:30 </td>
				<td> Opis dskfkldsmf dsklfmdklsf kldsmfkmdslkf ksjdfklsd </td>
				</tr>
				
					<tr>
				<td> 4. </td>
				<td> Odbiorca </td>
				<td> 16.04.2015 15:30 </td>
				<td> ---------- </td>
				<td> Opis dskfkldsmf dsklfmdklsf kldsmfkmdslkf ksjdfklsd </td>
				</tr>
		</table>   -->

	</div>
</div>
</div>
</trans:template>