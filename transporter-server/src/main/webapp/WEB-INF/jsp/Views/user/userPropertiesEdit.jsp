<%@ page language="java" contentType="text/html; charset=UTF-8" ageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h2>Edycja ustawień uzytkownika</h2>
			
			<form:form action="/transporter-server/user/propertiesEdit" method="post" commandName="user">
			
				<div class="form-group">
				<form:label path="rowsPerPage">Wyników na strone</form:label>
				<form:input path="rowsPerPage" class="form-control" cssErrorClass="errorBc" />
				<form:errors path="rowsPerPage" cssClass="error" />
				</div>
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/user/properties'" />
				
			</form:form>
						
		</div>
	</div>
</div>
</trans:template>
