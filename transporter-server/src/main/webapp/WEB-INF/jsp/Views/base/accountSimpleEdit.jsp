<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>


		    <div class="form-group">
    		
    		<form:label path="password">Hasło</form:label>
			<form:password path="password" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="password" cssClass="error" />
			</div>
		
		
			
			<div class="form-group">
			
			<form:label path="password2">Powtórz hasło</form:label>
			<form:password path="password2" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="password2" cssClass="error" />
			</div>
			
			
			<div class="form-group">
			
			<form:label path="user.email">E-mail</form:label>
			<form:input path="user.email" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="user.email" cssClass="error" />
		
			</div>
			
			
			<div class="form-group">
			
			<form:label path="customer.name">Imię</form:label>
			<form:input path="customer.name" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="customer.name" cssClass="error" />
		
			</div>
			
			
			<div class="form-group">
			
			<form:label path="customer.surname">Nazwisko</form:label>
			<form:input path="customer.surname" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="customer.surname" cssClass="error" />
			
			</div>
		
			<div class="checkbox">
				<label>
					<input type="checkbox" class="js_toggle" data-target="#company"> Firma
				</label>
			</div>
		
			<div id="company" class="hidden">
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
		
		<c:set var="addressPrefix" scope="session" value="baseAddress."/>
		
			<h3>Adres</h3>
			<%@ include file="addressEdit.jsp" %>
		
		<div class="checkbox">
			<c:set var="addressPrefix" scope="session" value="correspondeAddress."/>
			<label>
				<form:checkbox path="corespondeAddress" class="js_toggle" data-target="#correspondence" />
				Adres do korespondencji
			</label>
		</div>
		
		<div id="correspondence" class="hidden">
			<%@ include file="addressEdit.jsp" %>
		</div>
			