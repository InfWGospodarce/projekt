<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h1>Nowe zlecenie</h1>
			<form:form action="/transporter-server/customer/customerHistoryEdit" method="post" commandName="object">
			
			<h3>Adres odbioru</h3>
			
			<c:set var="addressPrefix" scope="request" value="deliveryAddress."/>
		
			<h3>Adres</h3>
			<%@ include file="../base/addressEdit.jsp" %>
	
	
			<h3>Adres dostawy</h3>
			
			<c:set var="addressPrefix" scope="request" value="targetAddress."/>
		
	
			<h3>Adres</h3>
			<%@ include file="../base/addressEdit.jsp" %>


				
	
		
		<div class="form-group">
		
				<form:label path="description">Opis</form:label><br/>
				<form:textarea path="description" cols="120" rows="5"/>
				</div>
				
						<div class="form-group">
		
				<form:label path="description">Opis</form:label><br/>
				<form:textarea path="description" cols="120" rows="5"/>
				</div>
				
					<div class="form-group">
	<form:label path="transportServicetypeId">Typ przesyki</form:label>
	<form:select class="form-control" path="transportServicetypeId">
	    <form:options items="${art}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
	</form:select>
	</div>
				
				
	
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/customer/customerHistory'" />
				
			</form:form>
	
	</div>
</div>
</div>
</trans:template>