<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<tr>
	<td>
		<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
		
		<c:choose>
			<c:when test="${1!=page}">
					<input type="hidden" value="${page-1}" name="id">
				    <input type="submit" value="Poprzednia">
			</c:when>
		</c:choose>
			<input type="number"  value="${page}" min="1" max="${pageCount}" name="page"><c:out value=" z ${pageCount}" />
		    <input type="submit" value="Idź">
		<c:choose>
			<c:when test="${pageCount!=page}">
					<input type="hidden" value="${page+1}" name="page">
				    <input type="submit" value="Następna">
				
			</c:when>
		</c:choose>
		</form>
	</td>
</tr>
