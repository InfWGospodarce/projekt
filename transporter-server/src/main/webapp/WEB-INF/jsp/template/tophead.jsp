<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="headers.jsp" %>
<div class="tophead">
	<h1>Transporter</h1>
	<div id="panel">
	<table>
		<tr>
			<c:choose>
				<c:when test="${empty userctx.username}">
					<ul>
						<li>
							<a href="/transporter-server/log/register">Zarejestruj</a>
		         		</li>
		         		<li>
		         			<a href="/transporter-server/log/login">Zaloguj</a>
		         		</li>
		         	</ul>
				</c:when>
				<c:otherwise>
					<ul>
						<li>
						<a href="#"><span>${userctx.username}</span></a>
							<ul>
								<li>
									<a href="/transporter-server/user/properties"><span>Ustawienia</span></a>
								</li>
								<li>
									<a href="/transporter-server/user/profile"><span>Profil</span></a>
								</li>
							</ul>
		         		</li>
		         		<li>
		         			<a href="/transporter-server/log/logout"><span>Wyloguj</span></a>
		         		</li>
		         	</ul>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
	</div>
</div>
