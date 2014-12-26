<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div class="sidebar">
<c:choose>
	<c:when test="${empty userctx}">
	</c:when>
	<c:otherwise>
         	
         		<h1>Menu</h1>
         		<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
         		<c:choose>
         		<c:when test="${userctx.hasRole('ADMIN') || userctx.hasRole('DEV')}">
			     
					  <div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingOne">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					          Opcje administracyjne
					           </a>
					      </h4>
					    </div>
					          <div id="collapseOne" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/adminItems.jsp" %>
					      	
					      	  </div>
					    </div>
					  </div>
			      
	      		</c:when>
				</c:choose> 
				
         		<c:choose>
         		<c:when test="${userctx.hasRole('DRIVER') || userctx.hasRole('DEV')}">
	         		
	         		<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingTwo">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="true" aria-controls="collapseTwo">
					          Panel kierowcy
					           </a>
					      </h4>
					    </div>
					          <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/driverItems.jsp" %>
					      	
					      	  </div>
					    </div>
					  </div>
					  
					  </c:when>
				 	</c:choose>
				 	
				 	
				<c:choose>
				<c:when test="${userctx.hasRole('ACCOUNT') || userctx.hasRole('DEV')}">
				
				
				<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingThree">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="true" aria-controls="collapseThree">
					          Panel księgowości
					           </a>
					      </h4>
					    </div>
					          <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/accoutmanItems.jsp" %>
					      	
					      	  </div>
					    </div>
					  </div>
	         		
       			</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('CUSTOMER') || userctx.hasRole('DEV')}">
	         			
	         				
				<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingFour">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="true" aria-controls="collapseFour">
					          Panel klienta
					           </a>
					      </h4>
					    </div>
					          <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/customerItems.jsp" %>
					      	
					      	  </div>
					    </div>
					  </div>
	         		
	         			
	         			</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('LOGISTIC') || userctx.hasRole('DEV')}">
	         			
	         							
				<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingFive">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="true" aria-controls="collapseFive">
					          Panel logistyki
					           </a>
					      </h4>
					    </div>
					          <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/logisticsItems.jsp" %>
					      	</div>
					    </div>
					  </div>
	         			
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('SALES') || userctx.hasRole('DEV')}">
	         			
	         			<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingSix">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="true" aria-controls="collapseSix">
					          Panel sprzedawcy
					           </a>
					      </h4>
					    </div>
					          <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSix">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/sellerItems.jsp" %>
					      	</div>
					    </div>
					  </div>
	         			
					</c:when>
				</c:choose>
				<c:choose>
	         		<c:when test="${userctx.hasRole('MAG') || userctx.hasRole('DEV')}">
	         			
	         			<div class="panel panel-default">
					    <div class="panel-heading" role="tab" id="headingSeven">
					      <h4 class="panel-title">
					        <a data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="true" aria-controls="collapseSeven">
					          Panel magazynu
					           </a>
					      </h4>
					    </div>
					          <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
					      <div class="panel-body">
					      	<%@ include file="../Views/roleMenuView/warehousemanItems.jsp" %>
					      	</div>
					    </div>
					  </div>
	         			
					</c:when>
				</c:choose>
			</div>
	</c:otherwise>
</c:choose>
</div>