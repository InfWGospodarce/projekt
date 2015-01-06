<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h1>Nowe zlecenie</h1>
			<form:form action="/transporter-server/customer/customerHistoryEdit" method="post" commandName="object">
			
			<label>Adres odbioru: 
			<input name="AdrReceiver" type="text"/></label><br/>
			<label>Adres docelowy: <input name="AdrTarget"  type="text"/></label>		<br/>
					
					
				<label>Opis <br/>
					 <textarea col="10" row="10"  name="description" ></textarea></label>
							<br/>	
	
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/customer/customerHistory'" />
				
			</form:form>
	
	</div>
</div>
</div>
</trans:template>