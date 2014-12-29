<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<div class="view">
		<h1 class="Transporter">Transporter strona główna</h1>
		<c:choose>
			<c:when test="${empty userctx}">
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
				Sales order
				<table>
					<tr>
						<c:forEach var="order" items="${orderList}">
							<td><c:out value="${order.id}"></c:out></td>
						</c:forEach>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</trans:template>