<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<tr>
	<td><form:label path="${prefix}active">Aktywny</form:label></td>
	<td><form:checkbox path="${prefix}active" cssErrorClass="errorBc"></form:checkbox></td>
	<td><form:errors path="${prefix}active" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${prefix}searchKey">Klucz wyszukiwania</form:label></td>
	<td><form:input path="${prefix}searchKey" cssErrorClass="errorBc"/></td>
	<td><form:errors path="${prefix}searchKey" cssClass="error" /></td>
</tr>
<tr>
	<td><form:label path="${prefix}name">Nazwa</form:label></td>
	<td><form:input path="${prefix}name" cssErrorClass="errorBc"/> </td>
	<td><form:errors path="${prefix}name" cssClass="error" /></td>
</tr>