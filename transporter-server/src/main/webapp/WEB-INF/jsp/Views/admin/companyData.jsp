<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-6">
	<div class="well">	
	
		<div class="form-group">
			<h2>Dane firmy</h2>
			
			<form action="/transporter-server/admin/companyDataEdit" method="get">
				<input type="hidden" value="${page}" name="page">
			    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
			</form>
		</div>
		
		<div class="form-group">
			<form:label path="companyData.searchKey">Klucz wyszukiwania</form:label>
			<form:input disabled="true" path="companyData.searchKey"  class="form-control" cssErrorClass="errorBc"/>
		</div>
		
		<div class="form-group">
			<form:label path="companyData.name">Nazwa firmy</form:label>
			<form:input disabled="true" path="companyData.name"  class="form-control" cssErrorClass="errorBc"/>
		</div>
		
		<div class="form-group">
			<form:label path="companyData.nip">NIP</form:label>
			<form:input disabled="true" path="companyData.nip"  class="form-control" cssErrorClass="errorBc"/>
		</div>
		
		<div class="form-group">
			<form:label path="companyData.regon">REGON</form:label>
			<form:input disabled="true" path="companyData.regon"  class="form-control" cssErrorClass="errorBc"/>
		</div>
		
		<c:set var="addressPrefix" scope="session" value="companyData.address."/>
		
			<h3>Adres</h3>
			<%@ include file="/WEB-INF/jsp/Views/base/address.jsp" %>
		
	</div>
</div>
</div>
</trans:template>