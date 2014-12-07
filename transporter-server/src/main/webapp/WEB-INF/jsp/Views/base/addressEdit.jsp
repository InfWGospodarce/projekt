<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<tr>
	<td><form:label path="${addressPrefix}addrStreetPrefixId">Ulica</form:label></td>
	<td>
		<form:select path="${addressPrefix}addrStreetPrefixId" >
		    <form:options items="${addrStreetPrefixs}" itemValue="id" itemLabel="name" cssErrorClass="errorBc"/>
		</form:select>
	</td>
	<td><form:input path="${addressPrefix}street" cssErrorClass="errorBc"></form:input></td>
	<td><form:errors path="${addressPrefix}street" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${addressPrefix}local">Numer mieszkania</form:label></td>
	<td><form:input path="${addressPrefix}local" cssErrorClass="errorBc"/></td>
	<td><form:errors path="${addressPrefix}local" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${addressPrefix}city">Miasto</form:label></td>
	<td><form:input path="${addressPrefix}city" cssErrorClass="errorBc"/> </td>
	<td><form:errors path="${addressPrefix}city" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${addressPrefix}zipCode">Kod pocztowy</form:label></td>
	<td><form:input path="${addressPrefix}zipCode" cssErrorClass="errorBc"/> </td>
	<td><form:errors path="${addressPrefix}zipCode" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${addressPrefix}postCity">Miasto - poczta</form:label></td>
	<td><form:input path="${addressPrefix}postCity" cssErrorClass="errorBc"/> </td>
	<td><form:errors path="${addressPrefix}postCity" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${addressPrefix}countryId">Kraj</form:label></td>
	<td>
		<form:select path="${addressPrefix}countryId">
		    <form:options items="${countries}" itemValue="id" itemLabel="name" cssErrorClass="errorBc"/>
		</form:select>
	</td>
</tr>
