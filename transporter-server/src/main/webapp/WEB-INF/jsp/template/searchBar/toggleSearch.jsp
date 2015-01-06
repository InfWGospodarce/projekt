<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	var showSearchBar=false;
</script>
<div class="form-group">
	<a href="#" onclick="searchControll()">Opcje wyszukiwania</a>
		<div id="genericSearch">
		<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
			<input type="hidden" name="page" id="page" value="1">
			<table class="table">
				<tr>
					<td>	
						<div class="form-group">
							<h5>Klucz wyszukiwania</h5>
							<input type="text" class="form-control" name="searchKey"/>
						</div>
					</td>
					<td>
						<div class="form-group">
							<h5>Nazwa</h5>
							<input type="text" class="form-control" name="name"/>
						</div>
					<td>
					<td>
						<div class="form-group">
							<h5>Aktywny</h5>
							<select class="form-control" name="active">
								<option value="0">Tak</option>
								<option value="1">Nie</option>
								<option value="2">Wszystkie</option>
							</select> 
						</div>
					<td>
				</tr>
				<tr>
					<td>	
						<div class="form-group">
							<h5>Data utworzenia</h5>
							<input type="text" class="form-control" name="createDateFrom"/>
							<input type="text" class="form-control" name="createDateTo"/>
						</div>
					</td>
					<td>
						<div class="form-group">
							<h5>Data księgowania</h5>
							<input type="text" class="form-control" name="createDateFrom"/>
							<input type="text" class="form-control" name="createDateTo"/>
						</div>
					<td>
					<td>
						<div class="form-group">
							<h5>Aktywny</h5>
							<select class="form-control" name="filled">
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
</div>
<%@ include file="genericSearch.jsp" %>
<script>
	$( document ).ready(function() {
		$(document.getElementById("genericSearch")).hide();
	});

	function searchControll(){
		if(showSearchBar){
			$(document.getElementById("genericSearch")).hide();
			showSearchBar=false;
		} else {
			$(document.getElementById("genericSearch")).show();
			showSearchBar=true;
		}
	}
</script>