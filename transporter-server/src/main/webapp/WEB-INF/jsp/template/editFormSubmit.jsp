<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<c:if test="${id empty}">
	<input type="submit" value="Utwórz"/>
<c:otherwise>
	<input type="submit" value="Edytuj"/>
</c:otherwise>
</c:if>
