<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>

<table class="table">
	<tr>
		<th>Dane klienta</th>
		<th>Adres podstawowy</th>
	</tr>
	<tr>
		<td>
			<div class="form-group">
			<form:label path="object.name">Imię</form:label>
			<form:input disabled="true" path="object.name" class="form-control" cssErrorClass="errorBc" />
			</div>
			
			<div class="form-group">
			<form:label path="object.surname">Nazwisko</form:label>
			<form:input disabled="true" path="object.surname" class="form-control" cssErrorClass="errorBc" />
			</div>
			
			<c:if test="${object.company eq 'true'}">
				<div id="company" >
					<div class="form-group">
					<form:label path="object.companyName">Nazwa firmy</form:label>
					<form:input disabled="true" path="object.companyName" class="form-control" cssErrorClass="errorBc" />
					</div>
					
					<div class="form-group">
					<form:label path="object.nip">NIP</form:label>
					<form:input disabled="true" path="object.nip" class="form-control" cssErrorClass="errorBc" />
					</div>
					
				</div>
			</c:if>
		</td>
		<td>
						<c:set var="addressPrefix" scope="request" value="${object.baseAddress}"/>
						<%@ include file="../../base/address2.jsp" %>
		</td>
	</tr>
</table>