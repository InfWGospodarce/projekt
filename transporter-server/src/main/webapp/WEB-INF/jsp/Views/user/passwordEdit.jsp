<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h2>Edycja ustawień uzytkownika</h2>
			
			<form:form action="/transporter-server/user/passwordEdit" method="post" commandName="password">
			
				<div class="form-group">
					<form:label path="oldPassword">Stare hasło</form:label>
					<form:password path="oldPassword" class="form-control" cssErrorClass="errorBc" />
					<form:errors path="oldPassword" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="newPassword">Nowe hasło</form:label>
					<form:password path="newPassword" class="form-control" cssErrorClass="errorBc" />
					<form:errors path="newPassword" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="newPasswordRe">Powtórz nowe hasło</form:label>
					<form:password path="newPasswordRe" class="form-control" cssErrorClass="errorBc" />
					<form:errors path="newPasswordRe" cssClass="error" />
				</div>
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/user/profile'" />
				
			</form:form>
						
		</div>
	</div>
</div>
</trans:template>
