<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<div class="view">
		<h1>Transporter strona główna</h1>
		<c:choose>
			<c:when test="${empty user}">
				<p>
					Witaj na stronie programu transporter.<br>
					Kliknij "Zaloguj" w menu na górze aby przejść do oprogramu.<br>
				</p>
			</c:when>
			
			<c:otherwise>
				<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
				<h2>
					Hail ${user.username} !<br/>
			    </h2>
			    <%-- <%@ include file="Views/activity.jsp" %> --%>
			</c:otherwise>
		</c:choose>
	</div>
</trans:template>