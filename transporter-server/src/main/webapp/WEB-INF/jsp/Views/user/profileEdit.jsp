<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">

			<h1>Edycja profilu</h1>
					
			<form:form action="/transporter-server/user/profileEdit" method="post" commandName="customerAccountForm">
					
					<div class="form-group">
					<form:label path="user.username">Użytkownik</form:label>
					<form:input disabled="true" path="user.username" class="form-control" cssErrorClass="errorBc" />
					</div>
					
					<%@ include file="../base/accountSimpleEdit.jsp" %>
					<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
					<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/user/profile'" />
						
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
