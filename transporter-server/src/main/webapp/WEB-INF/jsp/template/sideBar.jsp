<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div class="sidebar">
<c:choose>
	<c:when test="${empty user.username}">
	</c:when>
	<c:otherwise>
         	test bar
	</c:otherwise>
</c:choose>
</div>