<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../../template/headers.jsp" %>
<trans:template>
<div class="row">
	<div class="col-md-6">
		<div class="well">
	
			<h1>Zakładanie konta użytkownika</h1>
		
			<form:form action="/transporter-server/log/register" method="post" commandName="customerAccountForm">
					
						<div class="form-group">
     					
     					
						<form:label path="user.username">Użytkownik</form:label>
						<form:input path="user.username" class="form-control" cssErrorClass="errorBc" />
						<form:errors path="user.username" cssClass="error" />
			
						</div>
				
				
					<%@ include file="../base/accountSimpleEdit.jsp" %>
					<input class="btn btn-primary" class="form-control" type="submit" value="Utwórz"/>
						
			</form:form>
			
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
