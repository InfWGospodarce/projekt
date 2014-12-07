<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/template/headers.jsp" %>
<%@ attribute name="bodyOnload" required="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<title>transporter</title>
		<meta http-equiv="Cache-Control" content="no-cache; no-store; must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" /> 
		<meta http-equiv="Expires" content="-1" />
		<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
		<meta name="Classification" content="" />
		<meta name="Owner" content="transporter" />
		<meta name="Language" content="pl" />
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/global.css"/>
	</head>
	<body>
	<div>
	<jsp:include page="/WEB-INF/jsp/template/tophead.jsp" />
	</div>
	<div class="wrapper">
		<div id="menuleft" ><jsp:include page="/WEB-INF/jsp/template/actorsMenus/admin.jsp" /></div>
		<div id="content"><jsp:doBody /></div>
	</div>
	<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
	</body>
</html>
