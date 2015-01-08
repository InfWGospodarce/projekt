<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja magazynu</h1>
			<form:form action="/transporter-server/seller/requestEdit" method="post" commandName="object">
			
				<form:hidden path="id"/>
				<div class="form-group">
					<form:label path="id">Id</form:label>
					<form:input class="form-control" disabled="true" path="id" value="${id}"></form:input>
				</div>
					
				<div class="form-group">
					<form:label path="wareId">Artykuł</form:label>
					<div class="row js_select" data-target="/transporter-server/seller/articleList?select=true">
						<form:hidden path="warehouseId" class="form-control" value="" cssErrorClass="errorBc" />						<input id="wareId" type="text" name="wareId" disabled class="form-control js_value" value="&hellip;" cssErrorClass="errorBc" > 
						<form:errors path="wareId" cssClass="error" />
						<div class="col-xs-8">
			            </div>  
			            	<div class="col-xs-4">
			            		<button type="button" class="btn btn-primary js_trigger">Wybierz</button>
			            </div>
			        </div>
				</div>
				
				<div class="form-group">
					<form:label path="quantity">Ilość</form:label>
					<form:input path="quantity" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="quantity" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="unitId">Jednostka</form:label>
					<form:select class="form-control" path="unitId">
					    <form:options items="${units}" itemValue="id" class="form-control" itemLabel="code" cssErrorClass="errorBc"/>
					</form:select>
				</div>
				
				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/seller/requestList?page=${page}'" />
				
			</form:form>
</div></div></div>

<div id="modal" class="modal fade">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal" aria-label="Zamknij"><span aria-hidden="true">&times;</span></button>
         <!--  <h4 class="modal-title">Wybierz magazyn</h4> -->
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
<script src="${pageContext.request.contextPath}/resources/javascript/select.js"></script>
<script src="${pageContext.request.contextPath}/resources/javascript/main.js"></script>
</trans:template>