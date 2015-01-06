<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
	var showSearchBar=false;
</script>
<div class="form-group">
	<a href="#" onclick="searchControll()">Opcje wyszukiwania</a>
</div>
<%@ include file="genericSearch.jsp" %>
<script>
	$( document ).ready(function() {
		if(window.location.href.search("active=") == -1){
			$(document.getElementById("genericSearch")).hide();
		}
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