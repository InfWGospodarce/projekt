<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../template/headers.jsp" %>

    <table class="table">
    	<tr>
    		<td>
				<form:select onchange="selectedDevAdrChanged()" class="form-control" path="deliveryAddressSelector" id="deliveryAddressSelector">
    				<form:options items="${deliveryAddresses}" itemValue="id" class="form-control" itemLabel="name" cssErrorClass="errorBc"/>
    			</form:select>
    		</td>
    		<td>
				<input class="btn btn-primary" class="form-control" type="button" value="Pokaż Adres" onclick="showClientSelectedAddress()">
			</td>
    	</tr>
    	<tr>
    		<td colspan="4" id="customerSelectedAddress"></td>
    	</tr>
    </table>
<script>
$( document ).ready(function() {
	$( "#customerSelectedAddress").hide();
	loadClientSelectedAddress();
});
</script>