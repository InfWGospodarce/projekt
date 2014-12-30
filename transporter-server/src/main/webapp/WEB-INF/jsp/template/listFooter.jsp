<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<table class="table"><tr>
	<c:choose>
		<c:when test="${1!=page}">
		<td>
			<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
				<input type="hidden" value="${page-1}" name="page" id="page">
			    <input class="btn btn-primary" class="form-control" type="submit" value="Poprzednia">
			</form>
		</td></c:when>
	</c:choose>
		<td>
		<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
			<input type="number"  value="${page}" min="1" max="${pageCount}" name="page" id="page"><c:out value=" z ${pageCount}" />
		    <input class="btn btn-primary" class="form-control" type="submit" value="Idź">
		</form>
		</td>
	<c:choose>
		<c:when test="${pageCount!=page}">
		<td>
			<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
				<input type="hidden" value="${page+1}" name="page" id="page">
			    <input class="btn btn-primary" class="form-control" type="submit" value="Następna">
			</form>
		</td></c:when>
	</c:choose>
</tr></table>
