<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<div class = "view">
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
	<table>
		<tr>
			<td><h1>Zakładanie konta użytkownika</h1></td>
		</tr>
		<tr>
			<form:form action="/transporter-server/admin/roleEdit" method="post" commandName="role">
			<form:hidden path="id" value="${id}"></form:hidden>
				<table>
					<tr>
						<td><form:label path="active">Aktywny</form:label></td>
						<td><form:checkbox path="active" cssErrorClass="errorBc"></form:checkbox></td>
						<td><form:errors path="active" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="searchKey">Klucz wyszukiwania</form:label></td>
						<td><form:input path="searchKey" cssErrorClass="errorBc"/></td>
						<td><form:errors path="searchKey" cssClass="error" /></td>
					</tr>
					<tr>
						<td><form:label path="name">Nazwa</form:label></td>
						<td><form:input path="name" cssErrorClass="errorBc"/> </td>
						<td><form:errors path="name" cssClass="error" /></td>
					</tr>
					<tr>
						<td>
							<input type="submit" value="Zapisz"/>
						</td>
						<td>
							<input type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/admin/rolesList?page=${page}'" />
						</td>
					</tr>
				</table>
			</form:form>
		</tr>
	</table>
</div>
</trans:template>