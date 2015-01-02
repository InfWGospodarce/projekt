<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>

	<div class="form-group">
	<form:input disabled="true" path="${addressPrefix}addrStreetPrefix.name" class="form-control" cssErrorClass="errorBc"></form:input>
	<form:input disabled="true" path="${addressPrefix}street" class="form-control" cssErrorClass="errorBc"></form:input>
	</div>

	<div class="form-group">
	<form:label path="${addressPrefix}local">Numer mieszkania</form:label>
	<form:input disabled="true" path="${addressPrefix}local" class="form-control" cssErrorClass="errorBc"/>
	</div>	
	
	<div class="form-group">
	<form:label path="${addressPrefix}city">Miasto</form:label>
	<form:input disabled="true" path="${addressPrefix}city" class="form-control" cssErrorClass="errorBc"/> 
	</div>
	
	<div class="form-group">
	<form:label path="${addressPrefix}zipCode">Kod pocztowy</form:label>
	<form:input disabled="true" path="${addressPrefix}zipCode" class="form-control" cssErrorClass="errorBc"/> 
	</div>
	
	
	<div class="form-group">
	<form:label path="${addressPrefix}postCity">Miasto - poczta</form:label>
	<form:input disabled="true" path="${addressPrefix}postCity" class="form-control" cssErrorClass="errorBc"/> 
	</div>

	<div class="form-group">
	<form:label path="${addressPrefix}countryId">Kraj</form:label>
	<form:input disabled="true" path="${addressPrefix}country.name" class="form-control" cssErrorClass="errorBc"/> 
	</div>
	

