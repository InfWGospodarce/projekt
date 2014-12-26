<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<trans:template>
<%@ include file="/WEB-INF/jsp/template/sideBar.jsp" %>
	<div class="table">
				
				<table>
					<tr>
						<td><h2>Lista państw</h2></td>
						<td>
							<form action="/transporter-server/admin/countryEdit" method="get">
								<input type="hidden" value="${page}" name="page">
							    <input type="submit" value="Utwórz nowy">
							</form>
						</td>
					</tr>
					<tr>
						<td>
							<table class="listView">
								<tr>
									<th>Lp.</th>
									<th>Klucz wyszukiwania</th>
									<th>Nazwa</th>
									<th>Nazwa w j.</th>
									<th>Kod</th>
									<th>Kod UE</th>
									<th>Aktywny</th>
								</tr>
								<c:set var="i" value="0"></c:set>
								<c:forEach var="var" items="${list}">
									<c:set var="i" value="${i+1}"></c:set>
									<tr>
										<td><c:out value="${i+(page-1)*userctx.rowsPerPage}"></c:out></td>
										<td><c:out value="${var.searchKey}"></c:out></td>
										<td><c:out value="${var.name}"></c:out></td>
										<td><c:out value="${var.nativeName}"></c:out></td>
										<td><c:out value="${var.code}"></c:out></td>
										<td><c:out value="${var.codeEU}"></c:out></td>
										<td>
											<input type="checkbox" disabled="disabled" 
												<c:if test="${var.active eq 'true'}">
													checked="checked"
												</c:if>
											/>
										</td>
										<td>
											<form action="/transporter-server/admin/countryEdit" method="get">
												<input type="hidden" value="${page}" name="page">
												<input type="hidden" value="${var.id}" name="id">
											    <input type="submit" value="Edytuj">
											</form>
										</td>
									</tr>
								</c:forEach>
							</table>
						</td>
					</tr>
					<tr>
						<td>
							<%@ include file="/WEB-INF/jsp/template/listFooter.jsp" %>
						</td>
					</tr>
				</table>
	</div>
</trans:template>