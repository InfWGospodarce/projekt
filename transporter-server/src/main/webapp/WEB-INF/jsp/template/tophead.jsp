<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
	<a class="navbar-brand" href="/transporter-server/index">Transporter</a>
			<c:choose>
				<c:when test="${empty userctx.username}">
					<ul class="nav navbar-nav pull-right">
						<li>
							<a href="/transporter-server/log/login">Zaloguj</a>
		         		</li>
		         		<li>
		         			<a href="/transporter-server/log/register">Zarejestruj</a>
		         		</li>
		         	</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${userctx.username} <span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="/transporter-server/user/properties"><span>Ustawienia</span></a>
								</li>
								<li>
									<a href="/transporter-server/user/profile"><span>Profil</span></a>
								</li>
							</ul>
		         		</li>
		         		<li>
		         			<form action="/transporter-server/j_spring_security_logout" method="post">
							    <input class="btn btn-primary"  type="submit" value="Wyloguj">
							    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</form>
		         		</li>
		         	</ul>
				</c:otherwise>
			</c:choose>
	</div>
</nav>
