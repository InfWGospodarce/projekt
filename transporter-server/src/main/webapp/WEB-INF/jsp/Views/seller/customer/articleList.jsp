<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<c:if test="${empty param.select}">
	<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
</c:if>
<div class="row">
<div class="col-md-8">
	<div class="well">	
		<h2>Lista artykułów</h2>
		<%@ include file="/WEB-INF/jsp/template/searchBar/toggleSearch.jsp" %>
		<table class="table">
			<tr>
				<th>Lp.</th>
				<th>ID</th>
				<th>Klucz</th>
				<th>Kod</th>
				<th>Nazwa</th>
				<th>Cena</th>
				<th>Podatek</th>
				<th>Jednostka</th>
			</tr>
			<c:set var="i" value="0"></c:set>
			<c:forEach var="object" items="${articleList}">
				<c:set var="i" value="${i+1}"></c:set>
				<tr id="article.id" data-value="${article.id}">
					<td class="js_option"><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
					<td class="js_option"><c:out value="${article.id}"></c:out></td>
					<td class="js_option"><c:out value="${article.searchKey}"></c:out></td>
					<td class="js_option"><c:out value="${article.code}"></c:out></td>
					<td class="js_option"><c:out value="${article.name}"></c:out></td>
					<td class="js_option"><c:out value="${article.currentPrice}"></c:out></td>
					<td class="js_option"><c:out value="${article.taxitem.taxPercent}"></c:out></td>
					<td class="js_option"><c:out value="${article.unit.code}"></c:out></td>
					<td>
					</td>
				</tr>
			</c:forEach>
		</table>
		<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
		</div>
	</div>
</div>
</trans:template>