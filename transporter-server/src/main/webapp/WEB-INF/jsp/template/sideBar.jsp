<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div class="sidebar">
<c:choose>
	<c:when test="${empty userctx}">
	</c:when>
	<c:otherwise>
         	<ul id="coolMenu">
         		<h1>Menu</h1>
         		<c:choose>
	         		<c:when test="${userctx.hasRole('ADMIN') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Opcje administracyjne</a><ul>
	         				<%@ include file="../Views/roleMenuView/adminItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
         		<c:choose>
	         		<c:when test="${userctx.hasRole('DRIVER') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel kierowcy</a><ul>
	         				<%@ include file="../Views/roleMenuView/driverItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('ACCOUNT') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel księgowości</a><ul>
	         				<%@ include file="../Views/roleMenuView/accoutmanItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('CUSTOMER') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel klienta</a><ul>
	         				<%@ include file="../Views/roleMenuView/customerItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('LOGISTIC') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel logistyki</a><ul>
	         				<%@ include file="../Views/roleMenuView/logisticsItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('SALES') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel sprzedawcy</a><ul>
	         				<%@ include file="../Views/roleMenuView/sellerItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('MAG') || userctx.hasRole('DEV')}">
	         			<li><a href="#">Panel magazynu</a><ul>
	         				<%@ include file="../Views/roleMenuView/warehousemanItems.jsp" %>
	         			</ul></li>
					</c:when>
				</c:choose>
			</ul>
	</c:otherwise>
</c:choose>
</div>