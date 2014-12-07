<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<div>
	<form:form action="/transporter-server/log/register" method="post" commandName="customerAccountForm">
	<table>
		<tr>
			<td><form:label path="user.username">Użytkownik</form:label></td>
			<td><form:input path="user.username" cssErrorClass="errorBc" /></td>
			<td><form:errors path="user.username" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="password">Hasło</form:label></td>
			<td><form:password path="password" cssErrorClass="errorBc" /></td>
			<td><form:errors path="password" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="password2">Powtórz hasło</form:label></td>
			<td><form:password path="password2" cssErrorClass="errorBc" /></td>
			<td><form:errors path="password2" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="user.email">E-mail</form:label></td>
			<td><form:input path="user.email" cssErrorClass="errorBc" /></td>
			<td><form:errors path="user.email" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.name">Imię</form:label></td>
			<td><form:input path="customer.name" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.name" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.surname">Nazwisko</form:label></td>
			<td><form:input path="customer.surname" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.surname" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.company">Firma</form:label></td>
			<td><form:checkbox path="customer.company" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.company" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.companyName">Nazwa firmy</form:label></td>
			<td><form:input path="customer.companyName" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.companyName" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.nip">NIP</form:label></td>
			<td><form:input path="customer.nip" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.nip" cssClass="error" /></td>
		</tr>
		<tr>
			<td><form:label path="customer.regon">REGON</form:label></td>
			<td><form:input path="customer.regon" cssErrorClass="errorBc" /></td>
			<td><form:errors path="customer.regon" cssClass="error" /></td>
		</tr>
		<%-- <% String addressPrefix = "baseAddress"; %> --%>
		<c:set var="addressPrefix" scope="session" value="baseAddress."/>
		<tr>
			<th>Adres</th>
		</tr>
		<tr>
			<td>
				<%@ include file="addressEdit.jsp" %>
			</td>
		</tr>
		<%-- <% addressPrefix = "correspondeAddress"; %> --%>
		<c:set var="addressPrefix" scope="session" value="correspondeAddress."/>
		<tr>
			<td><form:checkbox path="corespondeAddress"/></td>
			<td><form:label path="corespondeAddress">Adres do korespondencji</form:label></td>
		</tr>
		<tr>
			<td>
				<%@ include file="addressEdit.jsp" %>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="Utwórz"/>
			</td>
		</tr>
	</table>
	</form:form>
</div>