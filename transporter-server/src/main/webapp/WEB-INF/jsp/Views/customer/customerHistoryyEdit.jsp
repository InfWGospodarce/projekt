<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja Zlecenia</h1>
			<form:form action="/transporter-server/admin/countryEdit" method="post" commandName="country">
				<form:hidden path="id" value="${id}"></form:hidden>
				<div class="form-group">
					<form:label path="active">Aktywny</form:label>
					<form:checkbox path="active" class="checkbox"  cssErrorClass="errorBc"></form:checkbox>
					<form:errors path="active" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="searchKey">Klucz wyszukiwania</form:label>
					<form:input path="searchKey" class="form-control" cssErrorClass="errorBc"/>
					<form:errors path="searchKey" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="name">Nazwa</form:label>
					<form:input path="name" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="name" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="nativeName">Nazwa w języku natyvnym</form:label>
					<form:input path="nativeName" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="nativeName" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="code">Kod</form:label>
					<form:input path="code" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="code" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="codeEU">Kod UE</form:label>
					<form:input path="codeEU" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="codeEU" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="ISOCode">Kod ISO</form:label>
					<form:input path="ISOCode" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="ISOCode" cssClass="error" />
				</div>
			
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/admin/countriesList?page=${page}'" />
				
			</form:form>
</div></div></div>
</trans:template>