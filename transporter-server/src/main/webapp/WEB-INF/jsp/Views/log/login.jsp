<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
	<div class="row">
     <div class="col-md-4">
    
	<div class="well">
	     
		<form:form action="/transporter-server/j_spring_security_check" method="post" commandName="user">
		<%-- <form:form action="/transporter-server/log/login" method="post" commandName="user"> --%>
			<h1> Login </h1>
			<c:if test="${not empty param.error}">
				<span class="error">Błąd logowania</span>
			</c:if>
			
			
			 <div class="form-group">
			<form:label path="username">Użytkownik</form:label>
			<form:input path="username" class="form-control"/>
			</div>
				
		
			<div class="form-group">
			<form:label path="password">Hasło</form:label>
			<form:password path="password" class="form-control"/>
			</div>
			<input type="submit" class="btn btn-primary" value="Zaloguj" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form:form>
	</div>
	</div>
	<div class="col-md-8">
	<img src="${pageContext.request.contextPath}/resources/Images/1.jpg" width="600" high="311">
	</div>
	
	</div>
</trans:template>