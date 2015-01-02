<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
	
	<form:hidden path="${addressPrefix}id"/>
	<form:hidden path="${addressPrefix}searchKey"/>
	<form:hidden path="${addressPrefix}active"/>
	
	<div class="form-group">
	<form:select class="form-control" path="${addressPrefix}addrStreetPrefixId" >
	    <form:options items="${addrStreetPrefixs}" itemValue="id" itemLabel="name" cssErrorClass="errorBc"/>
	</form:select>
	<form:input path="${addressPrefix}street" class="form-control" cssErrorClass="errorBc"></form:input>
	<form:errors path="${addressPrefix}street" cssClass="error" />
	</div>

	<div class="form-group">
	<form:label path="${addressPrefix}local">Numer mieszkania</form:label>
	<form:input path="${addressPrefix}local" class="form-control" cssErrorClass="errorBc"/>
	<form:errors path="${addressPrefix}local" cssClass="error" />
	</div>	
	
	
	<div class="form-group">
	<form:label path="${addressPrefix}city">Miasto</form:label>
	<form:input path="${addressPrefix}city" class="form-control" cssErrorClass="errorBc"/> 
	<form:errors path="${addressPrefix}city" cssClass="error" />
	</div>
	
	<div class="form-group">
	<form:label path="${addressPrefix}zipCode">Kod pocztowy</form:label>
	<form:input path="${addressPrefix}zipCode" class="form-control" cssErrorClass="errorBc"/> 
	<form:errors path="${addressPrefix}zipCode" cssClass="error" />
	</div>
	
	<div class="form-group">
	<form:label path="${addressPrefix}postCity">Miasto - poczta</form:label>
	<form:input path="${addressPrefix}postCity" class="form-control" cssErrorClass="errorBc"/> 
	<form:errors path="${addressPrefix}postCity" cssClass="error" />
	</div>

	<div class="form-group">
	<form:label path="${addressPrefix}countryId">Kraj</form:label>
	<form:select class="form-control" path="${addressPrefix}countryId">
	    <form:options items="${countries}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
	</form:select>
	</div>
	

