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
			<li class="nav-item active"><a class="nav-link"
				href="<c:url value="/"/>">Home <span class="sr-only">(current)</span>
			</a></li>
			<c:forEach var="cat" items="${categories}">
				<li class="nav-item"><a class="nav-link"
					href="?CateId=${cat.id}">${cat.name}</a></li>
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
					href="<c:url value="/cart"/>">Gio hang </a></li>
			</c:if>
			<li class="nav-item"><a href="#" class="nav-link text-info">
					<i class="fa fa-shopping-cart" aria-hidden="true"></i>
					<div class="badge badge-danger" id="cartCounter">
						${cartCounter}</div>
			</a></li>

			<form class="form-inline" action="<c:url value='/'/>">

				<input type="text" name="kw" class="form-control mr-sm-2"
					placeholder="Nhap tu khoa">

				<button class="btn btn-success" type="submit">Search</button>


			</form>

		</ul>
	</div>
</nav>