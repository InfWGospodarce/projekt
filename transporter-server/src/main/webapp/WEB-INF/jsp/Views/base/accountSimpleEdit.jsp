<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>

			<form:hidden path="user.id"/>	
			<form:hidden path="user.searchKey"/>
			<form:hidden path="user.active"/>
			
			<c:choose> 
				<c:when test="${not empty customerAccountForm.user.id}">
				</c:when>
				<c:otherwise>
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
				</c:otherwise>
			</c:choose>
		    
			<div class="form-group">
			<form:label path="user.email">E-mail</form:label>
			<form:input path="user.email" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="user.email" cssClass="error" />
			</div>
			
			<c:if test="${not empty customerAccountForm.employee}">
				<form:hidden path="employee.email"/>
				<form:hidden path="employee.id"/>
				<form:hidden path="employee.searchKey"/>
				<form:hidden path="employee.active"/>
				<div class="form-group">
				<form:label path="employee.name">Imię</form:label>
				<form:input path="employee.name" class="form-control" cssErrorClass="errorBc" />
				<form:errors path="employee.name" cssClass="error" />
				</div>
				
				<div class="form-group">
				<form:label path="employee.surname">Nazwisko</form:label>
				<form:input path="employee.surname" class="form-control" cssErrorClass="errorBc" />
				<form:errors path="employee.surname" cssClass="error" />
				</div>
				
			</c:if>
			
			<c:if test="${not empty customerAccountForm.customer}">
				<form:hidden path="customer.email"/>
				<form:hidden path="customer.id"/>
				<form:hidden path="customer.searchKey"/>
				<form:hidden path="customer.active"/>
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
				
				<div class="form-group">
					<form:label path="customer.company">Firma</form:label>
					<form:checkbox class="checkbox js_toggle" path="customer.company" data-target="#company"/>
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
			</c:if>
		
		<c:set var="addressPrefix" scope="request" value="baseAddress."/>
		
			<h3>Adres</h3>
			<%@ include file="addressEdit.jsp" %>
		
		<div class="checkbox">
			<c:set var="addressPrefix" scope="request" value="correspondeAddress."/>
			<label>
				<form:checkbox path="corespondeAddress" class="js_toggle" data-target="#correspondence" />
				Adres do korespondencji
			</label>
		</div>
		
		<div id="correspondence" class="hidden">
			<%@ include file="addressEdit.jsp" %>
		</div>
			