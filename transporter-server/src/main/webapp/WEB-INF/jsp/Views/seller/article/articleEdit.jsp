<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
<div class="row">
	<div class="col-md-6">
		<div class="well">
			<h1>Edycja artykułu</h1>
			<form:form action="/transporter-server/mag/articleEdit" method="post" commandName="article">
			
				<form:hidden path="id" value="${id}"></form:hidden>
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
					<form:label path="unitId">Jednostka</form:label>
					<form:select class="form-control" path="unitId">
					    <form:options items="${units}" itemValue="id" class="form-control" itemLabel="code" cssErrorClass="errorBc"/>
					</form:select>
				</div>
				
				<div class="form-group">
					<form:label path="taxItemId">Stawka opodatkowania</form:label>
					<form:select class="form-control" path="taxItemId">
					    <form:options items="${taxItems}" itemValue="id" class="form-control" itemLabel="taxPercent" cssErrorClass="errorBc"/>
					</form:select>
				</div>
				
				<div class="form-group">
					<form:label path="articleTypeValue">Typ artykułu</form:label>
					<form:select class="form-control" path="articleTypeValue">
					    <form:options items="${articleTypes}" itemValue="value" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
					</form:select>
				</div>
				
				<div class="form-group">
					<form:label path="currentPrice">Cena netto</form:label>
					<c:if test="${empty id}">
						<form:input path="currentPrice" class="form-control" cssErrorClass="errorBc"/>
					</c:if>
					<c:if test="${not empty id}">
						<form:input disabled="true" path="currentPrice" class="form-control" cssErrorClass="errorBc"/>
					</c:if> 
					<form:errors path="currentPrice" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="height">Wysokość</form:label>
					<form:input path="height" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="height" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="width">Szerokość</form:label>
					<form:input path="width" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="width" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="depth">Głębokość</form:label>
					<form:input path="depth" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="depth" cssClass="error" />
				</div>
				
				<div class="form-group">
					<form:label path="weight">Waga</form:label>
					<form:input path="weight" class="form-control" cssErrorClass="errorBc"/> 
					<form:errors path="weight" cssClass="error" />
				</div>
				

				<input class="btn btn-primary" class="form-control" type="submit" value="Zapisz"/>
				<input class="btn btn-primary" class="form-control" type="button" name="cancel" value="Anuluj" onclick="window.location='/transporter-server/mag/articleList?page=${page}'" />
				
			</form:form>
</div></div></div>
</trans:template>