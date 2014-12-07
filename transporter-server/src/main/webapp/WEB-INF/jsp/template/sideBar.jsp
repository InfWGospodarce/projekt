<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div class="sidebar">
<c:choose>
	<c:when test="${empty userctx}">
	</c:when>
	<c:otherwise>
         	<ul id="coolMenu">
         		<c:choose>
	         		<c:when test="${userctx.hasRole('ADMIN')}">
	         			<li><a href="#">Opcje administracyjne</a><ul>
	         				<%@ include file="../Views/roleMenuView/adminItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
			    <li><a href="#">Lorem</a></li>
			    <li><a href="#">Mauricii</a></li>
			    <li>
			        <a href="#">Periher</a>
			        <ul>
			            <li><a href="#">Hellenico</a></li>
			            <li><a href="#">Genere</a></li>
			            <li><a href="#">Indulgentia</a></li>
			        </ul>
			    </li>
			    <li><a href="#">Tyrio</a></li>
			    <li><a href="#">Quicumque</a></li>
			</ul>
	</c:otherwise>
</c:choose>
</div>