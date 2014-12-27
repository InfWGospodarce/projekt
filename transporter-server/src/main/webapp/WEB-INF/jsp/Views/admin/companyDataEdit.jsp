<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-6">
	<div class="well">	
		<h2>Edytuj dane firmy</h2>
		
		<form action="/transporter-server/admin/companyDataEdit" method="get">
			<input type="hidden" value="${page}" name="page">
		    <input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
		</form>
		<form:form action="/transporter-server/admin/companyDataEdit" method="post" commandName="companyData">
		
			<div class="form-group">
				<form:label path="searchKey">Klucz wyszukiwania</form:label>
				<form:input path="searchKey"  class="form-control" cssErrorClass="errorBc"/>
			</div>
			
			<div class="form-group">
				<form:label path="name">Nazwa firmy</form:label>
				<form:input path="name"  class="form-control" cssErrorClass="errorBc"/>
			</div>
			
			<div class="form-group">
				<form:label path="nip">NIP</form:label>
				<form:input path="nip"  class="form-control" cssErrorClass="errorBc"/>
			</div>
			
			<div class="form-group">
				<form:label path="regon">REGON</form:label>
				<form:input path="regon"  class="form-control" cssErrorClass="errorBc"/>
			</div>
			
			<c:set var="addressPrefix" scope="session" value="address."/>
			
				<h3>Adres</h3>
				<%@ include file="/WEB-INF/jsp/Views/base/addressEdit.jsp" %>
				
			<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
			<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/admin/companyData'" />
				
		</form:form>
	</div>
</div>
</div>
</trans:template>