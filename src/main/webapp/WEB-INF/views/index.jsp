<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${currentUser != null}">
${currentUser.email} - ${currentUser.firstName}
</c:if>
<ul class="pagination">
	<c:forEach begin="1" end="${Math.ceil(productCounter/6)}" var="page">

		<li class="page-item"><a class="page-link"
			href="<c:url value='/'/>?page=${page}">${page}</a></li>

	</c:forEach>


</ul>
<div class="row">
	<c:forEach var="p" items="${products}">
		<div class="col-md-4 col-xs-12 " style="padding: 10px">

			<div class="card">

				<img class="card-img-top img-fluid"
					src="<c:url value="/resource/img/${p.image}"/>" alt="Card image" />


				<div class="card-img-overlay">
					<h4 class="card-title">${p.name}</h4>
					<p class="card-text">${p.price}</p>
					<a href="#" class="btn btn-primary"
						onclick="addToCart(${p.id}, '${p.name}',${p.price})">Them vao
						gio</a> <a class="btn btn-warning"
						href="<c:url value='products/${p.id}'/>">Chi Tiet</a>
				</div>
			</div>


		</div>
	</c:forEach>
</div>

<div class="alert alert-success">
	<h5 class="text-center">CAC SAN DUOC BINH LUAN NHIEU NHAT</h5>
</div>

<div class="row">

	<c:forEach var="p" items="${discussProducts}">
		<div class="col-md-4 col-xs-12" style="padding: 10px">

			<div class="card">
				<a href="<c:url value="/products/${p[0]}"/>"> <img
					class="card-img-top img-fluid"
					src="<c:url value='/resource/img/${p[3]}'/>">
				</a>
				<div class="card-body">
					<h4 class="card-title">${p[1]}</h4>
					<p class="card-text">${p[2]}VND</p>


				</div>

			</div>

		</div>



	</c:forEach>
</div>