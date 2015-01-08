<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja zlecenia</h1>
			<form:form action="/transporter-server/seller/requestEdit" method="post" commandName="object">
			
				<form:hidden path="id"/>
				<form:hidden path="searchKey"/>
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input class="form-control" disabled="true" path="id" value="${id}"></form:input>
				</div>
					
				<div class="form-group">
					<form:label path="name">Nr dokumentu</form:label>
					<form:input path="name" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="name" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="description">Uwagi</form:label>
					<form:input path="description" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="description" cssClass="error" />
				</div>
				
				<%-- <div class="form-group">
					<form:label path="orderTypeValue">Typ zlecenia</form:label>
					<form:select class="form-control" path="currencyId">
					    <form:options items="${orderTypes}" itemValue="value" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>	 --%>
				
				<div class="form-group">
					<form:label path="currencyId">Waluta</form:label>
					<form:select class="form-control" path="currencyId">
					    <form:options items="${currencies}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>	
				
				<div class="form-group">
					<form:label path="customerId">Klient</form:label>
					<div class="row js_select" data-target="/transporter-server/seller/customerList?select=true">
						<form:hidden path="customerId" class="form-control" value="" cssErrorClass="errorBc" />						
						<input id="customerId" type="text" name="customerId" disabled class="form-control js_value" value="&hellip;" cssErrorClass="errorBc" > 
						<form:errors path="customerId" cssClass="error" />
						<div class="col-xs-8">
			            </div>  
			            	<div class="col-xs-4">
			            		<button type="button" class="btn btn-primary js_trigger">Wybierz</button>
			            </div>
			        </div>
				</div>		
				
				<div class="form-group">
					<form:label path="deliveryAddressId">Adres</form:label>
					<form:select class="form-control" path="deliveryAddressId">
					    <form:options items="${currencies}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>	
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/seller/requestList?page=${page}'" />
				
			</form:form>
</div></div></div>
<c:set scope="request" value="/resources/javascript/selectCustomer.js" var="modalJsPath" />
<c:set scope="request" value="selectCustomer" var="modalId" />
<%@ include file="../../../modals/modalSelect.jsp" %>
</trans:template>