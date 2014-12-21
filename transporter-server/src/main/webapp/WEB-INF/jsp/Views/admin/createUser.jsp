<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<div class = "std">
	<table>
		<tr>
			<td><h1>Zakładanie konta pracownika</h1></td>
		</tr>
		<tr>
			<form:form action="/transporter-server/admin/createUser" method="post" commandName="emplyeeAccountForm">
				<table>
					<tr>
						<td><form:label path="user.username">Użytkownik</form:label></td>
						<td><form:input path="user.username" cssErrorClass="errorBc" /></td>
						<td><form:errors path="user.username" cssClass="error" /></td>
					</tr>
					<%@ include file="../base/accountSimpleEdit.jsp" %>
					<tr>
						<td>
							<input type="submit" value="Utwórz"/>
						</td>
					</tr>
				</table>
			</form:form>
		</tr>
	</table>
</div>
</trans:template>