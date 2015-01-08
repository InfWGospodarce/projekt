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
					<form:label path="code">Kod</form:label>
					<form:input path="code" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="code" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="maxWeight">Maksymalne obciążenia</form:label>
					<form:input path="maxWeight" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="maxWeight" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="width">Szerokość</form:label>
					<form:input path="width" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="width" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="height">Wysokość</form:label>
					<form:input path="height" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="height" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="depth">Głębokość</form:label>
					<form:input path="depth" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="depth" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="coordinateX">Położenie w X</form:label>
					<form:input path="coordinateX" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="coordinateX" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="coordinateY">Położenie w Y</form:label>
					<form:input path="coordinateY" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="coordinateY" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="coordinateZ">Położenie w Z</form:label>
					<form:input path="coordinateZ" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="coordinateZ" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="warehouseId">Magazyn</form:label>
					<div class="row js_select" data-target="/transporter-server/mag/warehouseList?select=true">
						<form:hidden path="warehouseId" class="form-control" value="" cssErrorClass="errorBc" />
						<input id="selectionId" type="text" name="warehouseId" disabled class="form-control js_value" value="${object.warehouseId}" cssErrorClass="errorBc" > 
						<form:errors path="warehouseId" cssClass="error" />
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
    <div class="modal-dialog modal-lg">
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
<script src="${pageContext.request.contextPath}/resources/javascript/selectWarehouse.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/main.js"></script>
</trans:template>