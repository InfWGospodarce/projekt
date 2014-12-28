<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Transporter strona główna</h2>
		<c:choose>
			<c:when test="${empty userctx}">
				<p>
					Witaj na stronie programu transporter.<br>
					Kliknij "Zaloguj" w menu na górze aby przejść do oprogramu.<br>
				</p>
			</c:when>
			
			<c:otherwise>
				<h3>
					Hail ${userctx.username} !<br/>
			    </h3>
			    <%-- <%@ include file="Views/activity.jsp" %> --%>
			</c:otherwise>
		</c:choose>
	</div>
	</div>
</div>
</trans:template>