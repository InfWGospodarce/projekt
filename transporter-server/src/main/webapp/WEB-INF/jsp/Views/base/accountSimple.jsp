<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>

		    
			<div class="form-group">
			<form:label path="user.email">E-mail</form:label>
			<form:input disabled="true" path="user.email" class="form-control" cssErrorClass="errorBc" />
			</div>
			
			<c:if test="${not empty customerAccountForm.employee}">
				<div class="form-group">
				<form:label path="employee.name">Imię</form:label>
				<form:input disabled="true" path="employee.name" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
				<form:label path="employee.surname">Nazwisko</form:label>
				<form:input disabled="true" path="employee.surname" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<c:set var="addressPrefix" scope="session" value="baseAddress."/>
		
				<h3>Adres</h3>
				<%@ include file="address.jsp" %>
			
				<c:if test="${not empty correspondeAddress}">
					c:set var="addressPrefix" scope="session" value="correspondeAddress."/>
					Adres do korespondencji
					<%@ include file="address.jsp" %>
				</c:if>
				
			</c:if>
			
			<c:if test="${not empty customerAccountForm.customer}">
				<div class="form-group">
				<form:label path="customer.name">Imię</form:label>
				<form:input disabled="true" path="customer.name" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
				<form:label path="customer.surname">Nazwisko</form:label>
				<form:input disabled="true" path="customer.surname" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
					<form:label path="customer.company">Firma</form:label>
					<form:checkbox class="checkbox js_toggle" path="customer.company" data-target="#company"/>
				</div>
				
				<c:if test="${customerAccountForm.customer.company eq 'true'}">
					<div id="company" >
						<div class="form-group">
						<form:label path="customer.companyName">Nazwa firmy</form:label>
						<form:input path="customer.companyName" class="form-control" cssErrorClass="errorBc" />
						<form:errors path="customer.companyName" cssClass="error" />
						</div>
						
						<div class="form-group">
						<form:label path="customer.nip">NIP</form:label>
						<form:input path="customer.nip" class="form-control" cssErrorClass="errorBc" />
						<form:errors path="customer.nip" cssClass="error" />
						</div>
						
						<div class="form-group">
						<form:label path="customer.regon">REGON</form:label>
						<form:input path="customer.regon" class="form-control" cssErrorClass="errorBc" />
						<form:errors path="customer.regon" cssClass="error" />
						</div>
					</div>
				</c:if>
				
				<c:set var="addressPrefix" scope="session" value="baseAddress."/>
		
				<h3>Adres</h3>
				<%@ include file="address.jsp" %>
			
				<c:if test="${not empty user.customer.contactAddress}">
					c:set var="addressPrefix" scope="session" value="user.customer.contact."/>
					Adres do korespondencji
					<%@ include file="address.jsp" %>
				</c:if>
			</c:if>
