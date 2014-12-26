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
				Driver task
				<c:forEach var="task" items="${taskList}">
					<c:out value="${task.id}"></c:out>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</div>
</trans:template>