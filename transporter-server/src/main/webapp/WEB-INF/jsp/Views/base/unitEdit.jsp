<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja jednostki miary</h1>
			<form:form action="/transporter-server/admin/unitEdit" method="post" commandName="object">
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
					<form:label path="code">Kod</form:label>
					<form:input path="code" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="code" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="ISOCode">Kod ISO</form:label>
					<form:input path="ISOCode" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="ISOCode" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="sign">Znak</form:label>
					<form:input path="sign" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="sign" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="unitTypeValue">Typ jednostki</form:label>
					<form:select class="form-control" path="unitTypeValue">
					    <form:options items="${dimensions}" itemValue="value" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>
			
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/admin/unitList?page=${page}'" />
				
			</form:form>
</div></div></div>
</trans:template>