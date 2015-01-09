<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<div id="genericSearch">
	<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
		<input type="hidden" name="page" id="page" value="1">
		<table class="table">
			<tr>
				<td>	
					<div class="form-group">
						<h5>Klucz wyszukiwania</h5>
						<input type="text" class="form-control" name="searchKey" value="${param.searchKey}" id="genericSearchKey" />
					</div>
				</td>
				<td>
					<div class="form-group">
						<h5>Nazwa</h5>
						<input type="text" class="form-control" name="name" value="${param.name}" id="genericName"/>
					</div>
				<td>
				<td>
					<div class="form-group">
						<h5>Aktywny</h5>
						<select class="form-control" name="active" id="genericActive">
							<option value="0"
								<c:if test="${param.active eq '0'}">
									selected="selected"								
								</c:if>
							>Tak</option>
							<option value="1"
								<c:if test="${param.active eq '1'}">
									selected="selected"								
								</c:if>
							>Nie</option>
							<option value="2"
								<c:if test="${param.active eq '2'}">
									selected="selected"								
								</c:if>
							>Wszystkie</option>
						</select> 
					</div>
				<td>
			</tr>
			<tr>
				<td>
					<c:if test="${empty param.select}">
						<input class="btn btn-primary" class="form-control" type="submit" value="Szukaj">
					</c:if>
					<c:if test="${not empty param.select}">
						<a data-target="#modal" onclick="searchReload()" class="btn btn-primary" class="form-control" type="submit" role="button" href="javascript:void(0)">Szukaj</a>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</div>
<script>
function searchReload() {
   var searchKey = $('#genericSearchKey').val();
   console.log("SK: " + searchKey + $('#genericSearchKey').val() + document.getElementById("#genericSearchKey"));
   var name = $('#genericName').val();
   console.log("NA: " + name);
   var active = $("#genericActive").val();
   console.log("AC: " + active);
   var ref = "${requestScope['javax.servlet.forward.request_uri']}?select=true&searchKey=" + searchKey.toString() + "&name=" + name.toString()+ "&active=" + active.toString();
   $("#<c:out value="${modalId}"/> .modal-body").load(ref, function() { 
       $("#<c:out value="${modalId}"/>").modal("show"); 
  });
}
</script>