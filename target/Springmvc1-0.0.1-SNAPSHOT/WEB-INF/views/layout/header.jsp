<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<a class="navbar-brand" href="#">Navbar</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav">
			<li class="nav-item active"><a class="nav-link" href="<c:url value="/"/>">Home
					<span class="sr-only">(current)</span>
			</a></li>
			<c:forEach var="cat" items="${categories}">
				<li class="nav-item"><a class="nav-link" href="#">${cat.name}</a>
				</li>
			</c:forEach>
			<li class="nav-item active"><a class="nav-link textdanger"
				href="<c:url value="/register"/>">Dang ky</a></li>
			<c:if test="${pageContext.request.userPrincipal.name==null }">
				<li class="nav-item active"><a class="nav-link textdanger"
					href="<c:url value="/login"/>">Dang nhap</a></li>
			</c:if>
			<c:if test="${pageContext.request.userPrincipal.name!=null }">
				<li class="nav-item active"><a class="nav-link textdanger"
					href="<c:url value="/logout"/>">${pageContext.request.userPrincipal.name}
				</a></li>
				<li class="nav-item active"><a class="nav-link textdanger"
					href="<c:url value="/cart"/>">Gio hang<span
						class="badge badge-danger" id="cartCounter">${cartCounter}</span>
				</a></li>
			</c:if>

		</ul>
	</div>
</nav>