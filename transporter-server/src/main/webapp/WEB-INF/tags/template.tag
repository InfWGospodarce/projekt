<%@tag import="org.pwr.transporter.entity.UserAcc"%>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"  />
		<meta name="Classification" content="" />
		<meta name="Owner" content="transporter" />
		<meta name="Language" content="pl" />
		<!--<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/global.css"/>-->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" media="all" href="${pageContext.request.contextPath}/resources/css/main.css"/>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
	</head>
	<body class="body">
		<div class="container">
			<jsp:include page="/WEB-INF/jsp/template/tophead.jsp" />
			<jsp:doBody />
			<jsp:include page="/WEB-INF/jsp/template/footer.jsp" />
		</div>
	</body>
</html>
