<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div id="tophead">
	<table>
		<tr>
			<td><h1>Panel</h1></td>
			
			<c:choose>
				<c:when test="${empty userctx.username}">
					<td><a href="/transporter-server/log/register"><h2>Zarejestruj</h2></a></td>
					<td><a href="/transporter-server/log/login"><h2>Zaloguj</h2></a></td>
				</c:when>
				<c:otherwise>
		          	<td><a href="/transporter-server/errors/404"><h2>${user.username}</h2></a>></td>
		          	<td><a href="/transporter-server/log/logout"><h2>Wyloguj</h2></a></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</div>
