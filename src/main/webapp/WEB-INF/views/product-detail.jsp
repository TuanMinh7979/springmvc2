<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h5 class="text-center">Chi tiet san pham</h5>
<div class="row">



	<div class="col-md-6">
		<img class="card-img-top img-fluid"
			src="<c:url value="/resource/img/${p.image}"/>" alt="Card image">
	</div>
	<div class="col-md-6">
		<h1>${p.name}</h1>

		<h3 class="text-danger">${p.price}</h3>
		<h3 class="text-danger">${p.description}</h3>
		<div>
			<input type="button" value="Dat hang" class="btn btn-danger">
		</div>
	</div>

</div>
<br />
<form action="">
	<div class="form-group">
		<textarea class="form-control" placeholder="Nhap danh gia cua ban">
</textarea>
		<input type="submit" value="Gui binh luan" class="btn btn-danger">
	</div>
</form>
<div class="row">
	<c:forEach items="${comments}" var="comment">
		<div class="col-md-2" style="padding: 10px">
			<img class="rounded-circle img-fluid"
				style="width: 50px; height: 50px" alt=""
				src="<c:url value="/resource/img/ava.png"/>">
		</div>
		<div class="col-md-10">
			<p>${comment.noidung}</p>
			<i>${comment.createdDate}</i>
		</div>
	</c:forEach>
</div>
