<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<body>
		<div class="error">
			<c:choose>
					<c:when test="${empty userctx}">
					</c:when>
					<c:otherwise>
						<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
					</c:otherwise>
			</c:choose>
			<h1>HTTP Status 404 - Strona nie odnaleziona :(</h1>
		</div>
	</body>
</trans:template>