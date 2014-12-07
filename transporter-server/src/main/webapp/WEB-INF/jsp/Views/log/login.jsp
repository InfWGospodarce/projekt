<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<div class="login">
		<form:form action="/transporter-server/log/login" method="post" commandName="user">
		<table>
			<tr>
				<td><h1> Login </h1></td>
			</tr>
			<tr>
				<td><form:errors path="username" cssClass="error" /></td>
			</tr>
			<tr>
				<td><form:label path="username">Użytkownik</form:label></td>
				<td><form:input path="username"/></td>
			</tr>
			<tr>
				<td><form:label path="password">Hasło</form:label></td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Zaloguj" />
					<a href="/transporter-server/log/register"><button>Zarejestruj</button></a>
				</td>
			</tr>
		</table>
		</form:form>
	</div>
</trans:template>