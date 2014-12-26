<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-6">
	<div class="well">	
		<h2>Dane firmy</h2>
		<form action="/transporter-server/admin/companyDataEdit" method="get">
			<input type="hidden" value="${page}" name="page">
		    <input class="btn btn-primary" class="form-control" type="submit" value="Utwórz nowy">
		</form>
		<form:label path="companyData.searchKey">Klucz wyszukiwania</form:label>
		<form:input disabled="true" path="companyData.searchKey"  class="form-control" cssErrorClass="errorBc"/>
	</div>
</div>
</div>
</trans:template>