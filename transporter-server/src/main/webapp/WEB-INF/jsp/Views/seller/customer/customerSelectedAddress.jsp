<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
<table class="table">
	<tr>
		<td>
			<c:set var="addressPrefix" scope="request" value="${object}"/>
			<%@ include file="../../base/address2.jsp" %>
		</td>
	</tr>
</table>