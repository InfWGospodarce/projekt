<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>
			<h3>Pozaycje dokumentu</h3>
				<table class="table" id="documentTable">
					<tr>
						<th>Artykuł</th>
						<th></th>
						<th>Art. nazwa</th>
						<th>Ilość</th>
						<th>Jednostka</th>
					</tr>
					<tr>
							<form:hidden path="rows[0].id"/>
						<td>
							<div class="form-group">
								<div class="row js_select" data-target="/transporter-server/seller/articleList?select=true">
									<form:input id="wareId" disabled="true" path="rows[0].wareId" class="form-control" value="" cssErrorClass="errorBc" />						
									<form:errors path="rows[0].wareId" cssClass="error" />
					            	
						        </div>
							</div>
						</td>
						<td>
							<div class="row js_select" data-target="/transporter-server/seller/articleList?select=true">
								<div class="col-xs-4">
				            		<button id="1" type="button" class="btn btn-primary js_triggerART">Wybierz</button>
					            </div>
					        </div>
						</td>
						<td>
							<div class="form-group">
								<input type="text" class="form-control" disabled id="artnameId">
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:input path="rows[0].quantity" class="form-control" cssErrorClass="errorBc"/> 
								<form:errors path="rows[0].quantity" cssClass="error" />
							</div>
						</td>
						<td>
							<div class="form-group">
								<form:select class="form-control" path="rows[0].unitId">
								    <form:options items="${units}" itemValue="id" class="form-control" itemLabel="code" cssErrorClass="errorBc"/>
								</form:select>
							</div>
						</td>
					</tr>
				</table>
				
				<input type="button" class="btn btn-primary" class="form-control" value="Nowy wiersz" id="addRow" />
				
<c:set scope="request" value="/resources/javascript/documentRow.js" var="modalJsPath" />
<c:set scope="request" value="selectArticle" var="modalId" />
<%@ include file="../../../modals/modalSelect.jsp" %>
