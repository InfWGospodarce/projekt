<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<trans:template>
<script>
	var clientDataLoaded = false;
</script>

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
				
				<div class="form-group">
					<form:label path="currencyId">Waluta</form:label>
					<form:select class="form-control" path="currencyId">
					    <form:options items="${currencies}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>	
				
				<div class="form-group">
					<form:label path="customerId">Klient</form:label>
					<div class="row js_select" data-target="/transporter-server/seller/customerList?select=true">
						<table >
							<tr>
								<td>
									<form:input id="customerId" path="customerId" class="form-control" value="" cssErrorClass="errorBc" />
									<!-- <input  type="text" name="customerId" disabled class="form-control js_value" value="&hellip;" cssErrorClass="errorBc" > -->
								</td>
								<td>
									<div class="col-xs-4">
						            	<button type="button" class="btn btn-primary js_trigger">Wybierz</button>
						            </div>
								</td>
								<td>
									<input class="btn btn-primary" class="form-control" type="button" value="Pokaż dane" onclick="loadClientData()">
								</td>
							</tr>
							<tr>
								
								<td><form:errors path="customerId" cssClass="error" /></td>
							</tr>
						</table> 
			        </div>
				</div>
				
				<div id="clientData">
				
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
<script>
	function loadClientData(){
		var id = $('input[name=customerId]').val();
		console.log("ID: " + id);
		if(id === 'undefined') return;
		console.log("loaded: " + clientDataLoaded);
		if(clientDataLoaded){
			var element = $(document.getElementById("#clientData"));
			console.log("visible: " + $(element).is(":visible"));
			if(!element.css('visibility') === 'hidden'){
				$(element).hide();
			} else {
				$(element).show();
			};	
		} else {
			clientDataLoaded = true;
			$(document.getElementById("clientData")).load("/transporter-server/seller/customerSimple?id="+id);
		}
		
	}
</script>
<c:set scope="request" value="/resources/javascript/selectCustomer.js" var="modalJsPath" />
<c:set scope="request" value="selectCustomer" var="modalId" />
<%@ include file="../../../modals/modalSelect.jsp" %>
</trans:template>