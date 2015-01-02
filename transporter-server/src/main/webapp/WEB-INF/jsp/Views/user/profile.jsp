<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<table class="table">
				<tr>
					<td><h2>Profil</h2></td>
					<td>
						<form action="/transporter-server/user/profileEdit" method="get">
					    	<input class="btn btn-primary" class="form-control" type="submit" value="Edytuj">
						</form>
					</td>
				</tr>
			</table>
					
			<div class="form-group">
			<form:label path="customerAccountForm.user.username">Użytkownik</form:label>
			<form:input disabled="true" path="customerAccountForm.user.username" class="form-control" cssErrorClass="errorBc" />
			</div>
			
			<c:if test="${not empty customerAccountForm.employee}">
				<div class="form-group">
				<form:label path="customerAccountForm.user.employee.employeeType">Stanowisko</form:label>
				<form:input disabled="true" path="customerAccountForm.user.employee.employeeType.name" class="form-control" cssErrorClass="errorBc" />
				</div>
				
				<div class="form-group">
				<form:label path="customerAccountForm.userRoleIds">Prawa</form:label>
					<form:select disabled="true" class="form-control" path="customerAccountForm.userRoleIds">
					    <form:options items="${customerAccountForm.user.role}" itemValue="id" itemLabel="description" cssErrorClass="errorBc"/>
					</form:select>
				</div>
			</c:if>
		
			<%@ include file="../base/accountSimple.jsp" %>
			
			<script>
				[].slice.call(document.querySelectorAll('.js_toggle')).forEach(function (checkbox) {
					checkbox.addEventListener('change', function () {
						var target = document.querySelector(this.dataset.target);
						
						target.classList[this.checked ? 'remove' : 'add']('hidden');
					});
				});
			</script>
		</div>
	</div>
</div>
</trans:template>
