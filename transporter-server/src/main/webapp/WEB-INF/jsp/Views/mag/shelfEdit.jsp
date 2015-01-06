<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja magazynu</h1>
			<form:form action="/transporter-server/mag/shelfEdit" method="post" commandName="object">
			
				<form:hidden path="id"/>
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input class="form-control" disabled="true" path="id" value="${id}"></form:input>
				</div>
					
				<div class="form-group">
					<form:label path="active">Aktywny</form:label>
					<form:checkbox path="active" class="checkbox"  cssErrorClass="errorBc"></form:checkbox>
					<form:errors path="active" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="searchKey">Klucz wyszukiwania</form:label>
					<form:input path="searchKey" class="form-control" cssErrorClass="errorBc"/>
					<form:errors path="searchKey" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="name">Nazwa</form:label>
					<form:input path="name" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="name" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="warehouse">Magazyn</form:label>
					<div class="row js_select" data-target="warehouseList.jsp?select=true">
						<form:input path="warehouse" class="form-control js_value" value="&hellip;" cssErrorClass="errorBc"/> 
						<form:errors path="warehouse" cssClass="error" />
						<div class="col-xs-8">
			            </div>  
			            	<div class="col-xs-4">
			            		<button type="button" class="btn btn-primary js_trigger">Wybierz</button>
			            </div>
			        </div>
				</div>
				
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/mag/shelfList?page=${page}'" />
				
			</form:form>
</div></div></div>

<div id="modal" class="modal fade">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Zamknij"><span aria-hidden="true">&times;</span></button>
          <h4 class="modal-title">Wybierz magazyn</h4>
        </div>
        <div class="modal-body">
          <p>One fine body&hellip;</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
        </div>
      </div>
    </div>
  </div>
<script src="/WEB-INF/js/select.js"></script>
<script src="/WEB-INF/js/main.js"></script>
</trans:template>