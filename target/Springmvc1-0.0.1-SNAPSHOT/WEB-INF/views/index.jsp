<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							src="<c:url value="/resource/img/${p.image}"/>" alt="Card image"/>
					
			
				<div class="card-img-overlay">
					<h4 class="card-title">${p.name}</h4>
					<p class="card-text">${p.price}</p>
					<a href="#" class="btn btn-primary">Them vao gio</a>
					<a class="btn btn-warning" href="<c:url value='products/${p.id}'/>">Chi Tiet</a>
				</div>
			</div>


		</div>
	</c:forEach>
</div>