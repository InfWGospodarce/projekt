<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<div id="genericSearch">
	<form action="${requestScope['javax.servlet.forward.request_uri']}Search" method="get">
		<input type="hidden" name="page" id="page" value="${page}">
		<table class="table">
			<tr>
				<td>
					<div class="form-group">
						<h5>Klucz wyszukiwania</h5>
						<input class="form-control" name="searchKey"/>
					</div>
				<td>
				<td>
					<div class="form-group">
						<h5>Nazwa</h5>
						<input class="form-control" name="name"/>
					</div>
				<td>
				<td>
					<div class="form-group">
						<h5>Aktywny</h5>
						<select class="form-control" name="name">
							<option value="0">Tak</option>
							<option value="1">Nie</option>
							<option value="2">Wszystkie</option>
						</select> 
					</div>
				<td>
			</tr>
			<tr>
				<td><input class="btn btn-primary" class="form-control" type="submit" value="Szukaj"></td>
			</tr>
		</table>
	</form>
</div>