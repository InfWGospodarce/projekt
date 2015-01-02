<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">

			<c:choose> 
				<c:when test="${not empty customerAccountForm.user.id}">
					<h1>Edycja konta użytkownika</h1>
				</c:when>
				<c:otherwise>
					<h1>Tworzenie konta użytkownika</h1>
				</c:otherwise>
			</c:choose>
					
			<form:form action="/transporter-server/admin/userEdit" method="post" commandName="customerAccountForm">
					
					<div class="form-group">
					<form:label path="user.username">Użytkownik</form:label>
						<c:choose> 
							<c:when test="${not empty customerAccountForm.user.id}">
								<form:input disabled="true" path="user.username" class="form-control" cssErrorClass="errorBc" />
							</c:when>
							<c:otherwise>
								<form:input path="user.username" class="form-control" cssErrorClass="errorBc"/>
							</c:otherwise>
						</c:choose>
					<form:errors path="user.username" cssClass="error" />
					</div>
					
					<c:if test="${not empty customerAccountForm.employee}">
						<div class="form-group">
						<form:label path="employeeTypeId">Stanowisko</form:label>
							<form:select class="form-control" path="employeeTypeId" >
							    <form:options items="${employeeTypes}" itemValue="id" itemLabel="name" cssErrorClass="errorBc"/>
							</form:select>
						<form:errors path="employeeTypeId" cssClass="error" />
						</div>
						
						<div class="form-group">
						<form:label path="userRoleIds">Prawa</form:label>
							<form:select class="form-control" path="userRoleIds" multiple="true">
							    <form:options items="${roles}" itemValue="id" itemLabel="description" cssErrorClass="errorBc"/>
							</form:select>
						<form:errors path="userRoleIds" cssClass="error" />
						</div>
					</c:if>
				
					<%@ include file="../base/accountSimpleEdit.jsp" %>
					<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
					<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/admin/userList?page=${page}'" />
						
			</form:form>
			
			<script>
				[].slice.call(document.querySelectorAll('.js_toggle')).forEach(function (checkbox) {
					checkbox.addEventListener('change', function () {
						var target = document.querySelector(this.dataset.target);
						target.classList[this.checked ? 'remove' : 'add']('hidden');
					});
				});
				
				$( document ).ready(function() {
					[].slice.call(document.querySelectorAll('.js_toggle')).forEach(function (checkbox){
						var target = document.querySelector(checkbox.dataset.target);
						target.classList[checkbox.checked ? 'remove' : 'add']('hidden');
					});
				});
			</script>
		</div>
	</div>
</div>
</trans:template>
