<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja zamówienia</h1>
			<form:form action="/transporter-server/logistic/orderListEdit" method="post" commandName="order">
				<form:hidden path="id" value="${id}"></form:hidden>
				<div class="form-group">
					<form:label path="active">Aktywny</form:label>
					<form:checkbox path="active" class="checkbox" cssErrorClass="errorBc"></form:checkbox>
					<form:errors path="active" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="searchKey">Klucz wyszukiwania</form:label>
					<form:input path="searchKey"  class="form-control" cssErrorClass="errorBc"/>
					<form:errors path="searchKey" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="customer.id">ID Klienta</form:label>
					<form:input path="customer.id" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="customer.id" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="deliveryAddress.id">ID Adresu Klienta</form:label>
					<form:input path="deliveryAddress.id" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="deliveryAddress.id" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="name">Nazwa</form:label>
					<form:input path="name" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="name" cssClass="error" />
				</div>
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/logistic/orderList?page=${page}'" />
			</form:form>
		</div>
	</div>
</div>
</trans:template>