<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<table class="table">
				<tr>
					<td><h2>Ustawienia uzytkownika</h2></td>
					<td>
						<form action="/transporter-server/user/propertiesEdit" method="get">
					    	<input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
						</form>
					</td>
				</tr>
			</table>
			
			<div class="form-group">
			<form:label path="user.rowsPerPage">Wyników na strone</form:label>
			<form:input disabled="true" path="user.rowsPerPage" class="form-control" cssErrorClass="errorBc" />
			</div>
		</div>
	</div>
</div>
</trans:template>
