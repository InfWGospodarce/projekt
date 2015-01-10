<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<table class="table"><tr>
		<td>
			<c:choose>
				<c:when test="${1!=page}">
					<div class="form-group">
						<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
							<c:if test="${empty param.select}">
								<input type="hidden" value="${page-1}" name="page" id="page1">
						    	<input class="btn btn-primary" class="form-control" type="submit" value="Poprzednia">
						    </c:if>
							<c:if test="${not empty param.select}">
								<input type="hidden" value="true" name="select">
								<a data-target="#modal" onclick="fillHref('page1')" class="btn btn-primary" class="form-control" type="submit" role="button" href="javascript:void(0)">Poprzednia</a>
							</c:if>
						</form>
					</div>
				</c:when>
			</c:choose>
		</td>
		<td>
			<div class="form-group">
				<c:if test="${empty param.select}">
					<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
						<input type="number" value="${page}" min="1" max="${pageCount}" name="page" id="page"><c:out value=" z ${pageCount}" />
				    	<input class="btn btn-primary" class="form-control" type="submit" value="Idź">
					</form>
				</c:if>
			    <c:if test="${not empty param.select}">
			    	<input type="number" value="${page}" min="1" max="${pageCount}" name="page" id="page2"><c:out value=" z ${pageCount}" />
					<a data-target="#modal" onclick="fillHref('page2')" class="btn btn-primary" class="form-control" type="submit" role="button" href="javascript:void(0)">Idź</a>
				</c:if>
			</div>
		</td>
		<td>
			<c:choose>
				<c:when test="${pageCount!=page}">
					<div class="form-group">
						<form action="${requestScope['javax.servlet.forward.request_uri']}" method="get">
							<c:if test="${empty param.select}">
								<input type="hidden" value="${page+1}" name="page" id="page3">
								<input class="btn btn-primary" class="form-control" type="submit" value="Następna">
							</c:if>
							<c:if test="${not empty param.select}">
								<input type="hidden" value="true" name="select">
								<a data-target="#modal" onclick="fillHref('page3')" class="btn btn-primary" class="form-control" type="submit" role="button" href="javascript:void(0)">Następna</a>							
							</c:if>
						</form>
					</div>
				</c:when>
			</c:choose>
		</td>
</tr></table>
<script>
function fillHref(pager) {
   var href = $("#" + pager).val();
   var ref = "${requestScope['javax.servlet.forward.request_uri']}?select=true&page=" + href.toString();
   $("#<c:out value="${modalId}"/> .modal-body").load(ref, function() { 
       $("#<c:out value="${modalId}"/>").modal("show"); 
  });
}
</script>