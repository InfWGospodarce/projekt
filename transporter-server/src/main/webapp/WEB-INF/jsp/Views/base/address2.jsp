<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>

	<div class="form-group">
	<c:out value="${addressPrefix.addrStreetPrefix.name}"></c:out>
	<input disabled="disabled" name="${addressPrefix.street}" class="form-control" value="${addressPrefix.street}">
	</div>

	<div class="form-group">
	<h5>Numer mieszkania</h5>
	<input disabled="disabled" name="${addressPrefix.local}" class="form-control"  value="${addressPrefix.local}"/>
	</div>	
	
	<div class="form-group">
	<h5>Miasto</h5>
	<input disabled="disabled" name="${addressPrefix.city}" class="form-control" value="${addressPrefix.city}">  
	</div>
	
	<div class="form-group">
	<h5>Kod pocztowy</h5>
	<input disabled="disabled" name="${addressPrefix.zipCode}" class="form-control" value="${addressPrefix.zipCode}">  
	</div>
	
	
	<div class="form-group">
	<h5>Miasto - poczta</h5>
	<input disabled="disabled" name="${addressPrefix.postCity}" class="form-control" value="${addressPrefix.postCity}"> 
	</div>

	<div class="form-group">
	<h5>Kraj</h5>
	<input disabled="disabled" name="${addressPrefix.country.name}" class="form-control" value="${addressPrefix.country.name}">  
	</div>
	

