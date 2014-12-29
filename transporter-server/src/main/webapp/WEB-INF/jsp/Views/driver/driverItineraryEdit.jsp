<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja doręczenia</h1>
			<form:form action="/transporter-server/driver/driverItineraryEdit" method="post" commandName="Itinerary">
				<form:hidden path="Itinerary.id" value="${id}"></form:hidden>
				<div class="form-group">
					<form:label path="Itinerary.active">Aktywny</form:label>
					<form:checkbox path="Itinerary.active" class="checkbox" cssErrorClass="errorBc"></form:checkbox>
					<form:errors path="Itinerary.active" cssClass="error" />
				</div>
				<div class="form-group">
					<form:label path="Itinerary.searchKey">Klucz wyszukiwania</form:label>
					<form:input path="Itinerary.searchKey"  class="form-control" cssErrorClass="errorBc"/>
					<form:errors path="Vehicle.searchKey" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="Itinerary.name">Nazwa</form:label>
					<form:input path="Itinerary.name" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="Itinerary.name" cssClass="error" />
				</div>
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/logistic/driverVehicle?page=${page}'" />
			</form:form>
		</div>
	</div>
</div>
</trans:template>