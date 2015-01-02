<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja ustawień uzytkownika</h1>
			
			<div class="form-group">
			<form:label path="user.rowsPerPage">Wyników na strone</form:label>
			<form:input path="user.rowsPerPage" class="form-control" cssErrorClass="errorBc" />
			<form:errors path="user.rowsPerPage" cssClass="error" />
			</div>
		</div>
	</div>
</div>
</trans:template>
