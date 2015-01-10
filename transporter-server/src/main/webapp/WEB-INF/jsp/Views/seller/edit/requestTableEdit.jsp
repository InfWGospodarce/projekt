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
					<tr class="tr_clone" id="0">
							<form:hidden path="rows[0].id"/>
						<td>
							<div class="form-group">
							</div>
							<div class="row js_optionArt js_select" data-target="/transporter-server/seller/articleList?select=true">
								<form:input id="wareId0" disabled="true" path="rows[0].wareId" class="form-control" value="" cssErrorClass="errorBc" />
								<form:errors path='rows[0].wareId' cssClass='error' />
								<div class="col-xs-4">
				            		<button id="1" type="button" class="btn btn-primary js_trigger js_triggerART">Wybierz</button>
					            </div>
					        </div>
						</td>
						<td>
							<div class='form-group'>
								<input type='text' class='form-control' disabled id='artnameId'>
							</div>
						</td>
						<td>
							<div class='form-group'>
								<form:input path='rows[0].quantity' class='form-control' cssErrorClass='errorBc'/>
								<form:errors path='rows[0].quantity' cssClass='error' />
							</div>
						</td>
						<td>
							<div class='form-group'>
								<form:hidden class='form-control' path='rows[0].unitId' />
								<input disabled="disabled" class='form-control' id="unitText">
							</div>
						</td>
						<td>
							<button type="button" class="btn btn-primary" class="form-control" class="delRow">Usuń</button>
						</td>
					</tr>
				</table>
				
				<input type="button" class="btn btn-primary" class="form-control" value="Nowy wiersz" id="addRow" />
				<br/><br/>
<c:set scope="request" value="/resources/javascript/documentRow.js" var="modalJsPath" />
<c:set scope="request" value="selectArticle" var="modalId" />
<c:set scope="request" value="Wybierz artykuł" var="modalTitle" />
<%@ include file="../../../modals/modalSelect.jsp" %>
