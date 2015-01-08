<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	

	
		<table class="table">
			<tr>
				<th>Lp.</th>	
				<th>ID. Paczki</th>			
				<th>Data Dodania</th>
				<th>Adres Odbioru</th>
				<th>Data Odbioru</th>
				<th>Adres Docelowy</th>
				<th>Data Dostarczenia</th>
				<th>Opis</th>
				<th></th>
				
			</tr>
		
				<tr>
				<td> 1. </td>
				<td> 0001 </td>
				<td> 13.04.2015 </td>
				<td> adres ssss </td>
				<td> 14.04.2015 </td>
				<td> adres odbiorurrrrvbvsvsdvdsvsd </td>
				<td> 17.04.2015 </td>
				<td> Opis dskfkldsmf dsklfmdklsf kldsmfkmdslkf ksjdfklsd </td>
				<td> <a href="/transporter-server/customer/customerMonit/0001" ><button class="btn btn-primary" >Monitoruj</button></a> </td>
				
				</tr>
		
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
	</div>
</div>
</div>
</trans:template>