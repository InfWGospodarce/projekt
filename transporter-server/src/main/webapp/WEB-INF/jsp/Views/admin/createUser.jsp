<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<div class = "std">	
			<h1>Zakładanie konta pracownika</h1>
		
			<form:form action="/transporter-server/admin/createUser" method="post" commandName="emplyeeAccountForm">
				
						<form:label path="user.username">Użytkownik</form:label>
						<form:input path="user.username" cssErrorClass="errorBc" />
						<form:errors path="user.username" cssClass="error" />
					
					<%@ include file="../base/accountSimpleEdit.jsp" %>
					 	<input type="submit" value="Utwórz"/>
						</form:form>
		
</div>
</trans:template>