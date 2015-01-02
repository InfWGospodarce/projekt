<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>

		    
			<div class="form-group">
			<form:label path="customerAccountForm.user.email">E-mail</form:label>
			<form:input disabled="true" path="customerAccountForm.user.email" class="form-control" cssErrorClass="errorBc" />
			</div>
			
			<c:if test="${not empty customerAccountForm.employee}">
				<div class="form-group">
				<form:label path="customerAccountForm.employee.name">Imię</form:label>
				<form:input disabled="true" path="customerAccountForm.employee.name" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
				<form:label path="customerAccountForm.employee.surname">Nazwisko</form:label>
				<form:input disabled="true" path="customerAccountForm.employee.surname" class="form-control" cssErrorClass="errorBc" />
				</div>
			</c:if>
			
			<c:if test="${not empty customerAccountForm.customer}">
				<div class="form-group">
				<form:label path="customerAccountForm.customer.name">Imię</form:label>
				<form:input disabled="true" path="customerAccountForm.customer.name" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
				<form:label path="customerAccountForm.customer.surname">Nazwisko</form:label>
				<form:input disabled="true" path="customerAccountForm.customer.surname" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
					<form:label path="customerAccountForm.customer.company">Firma</form:label>
					<form:checkbox disabled="true" class="checkbox js_toggle" path="customerAccountForm.customer.company" data-target="#company"/>
				</div>
				
				<c:if test="${customerAccountForm.customer.company eq 'true'}">
					<div id="company" >
						<div class="form-group">
						<form:label path="customerAccountForm.customer.companyName">Nazwa firmy</form:label>
						<form:input disabled="true" path="customerAccountForm.customer.companyName" class="form-control" cssErrorClass="errorBc" />
						</div>
						
						<div class="form-group">
						<form:label path="customerAccountForm.customer.nip">NIP</form:label>
						<form:input disabled="true" path="customerAccountForm.customer.nip" class="form-control" cssErrorClass="errorBc" />
						</div>
						
						<div class="form-group">
						<form:label path="customerAccountForm.customer.regon">REGON</form:label>
						<form:input disabled="true" path="customerAccountForm.customer.regon" class="form-control" cssErrorClass="errorBc" />
						</div>
					</div>
				</c:if>
			</c:if>

			<c:set var="addressPrefix" scope="session" value="customerAccountForm.baseAddress."/>
		
			<h3>Adres</h3>
			<%@ include file="address.jsp" %>
		
			<c:if test="${not empty customerAccountForm.correspondeAddress}">
				<c:set var="addressPrefix" scope="session" value="customerAccountForm.correspondeAddress."/>
				<h3>Adres do korespondencji</h3>
				<%@ include file="address.jsp" %>
			</c:if>